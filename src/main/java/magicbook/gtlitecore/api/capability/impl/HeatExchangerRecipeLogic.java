package magicbook.gtlitecore.api.capability.impl;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import magicbook.gtlitecore.api.capability.GTLiteDataCode;
import magicbook.gtlitecore.api.metatileentity.multi.IHeatExchanger;
import magicbook.gtlitecore.api.metatileentity.multi.NoEnergyMultiblockController;
import magicbook.gtlitecore.api.recipe.properties.FlowRateProperty;
import magicbook.gtlitecore.api.recipe.properties.MaxRateProperty;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gate Guardian
 *
 * <p>
 *     This class is basic logic for Heat Exchanger.
 *     Thanks for my friend Gate Guardian create it, I just redo something.
 * </p>
 */
@SuppressWarnings("all")
public class HeatExchangerRecipeLogic extends NoEnergyMultiblockRecipeLogic {

    private int currentHeat;
    private final int maxHeat;
    private boolean isSuperheat;
    private int rate;

    public HeatExchangerRecipeLogic(NoEnergyMultiblockController tileEntity) {
        super(tileEntity, tileEntity.recipeMap);
        this.maxHeat = ((IHeatExchanger) tileEntity).getHeatTime() * 20;
    }

    @Override
    public void update() {
        if ((!isActive() || !canProgressRecipe() || !isWorkingEnabled()) && currentHeat > 0) {
            setHeat(currentHeat - 1);
            setRate(0);
            setSuperheat(false);
        }
        super.update();
    }

    @Override
    protected void updateRecipeProgress() {
        super.updateRecipeProgress();
        if (!canRecipeProgress)
            return;

        if (currentHeat < maxHeat) {
            setHeat(currentHeat + 1);
        }
    }

    @Override
    protected boolean checkPreviousRecipe() {
        if (this.previousRecipe == null) {
            return false;
        } else {
            List<FluidStack> fluidStackList = new ArrayList<>(GTUtility.fluidHandlerToList(getInputTank()));
            fluidStackList.add(Materials.DistilledWater.getFluid(Integer.MAX_VALUE));
            return (long) this.previousRecipe.getEUt() <= this.getMaxVoltage() && this.previousRecipe.matches(false, Collections.emptyList(), fluidStackList);
        }
    }

    @Override
    protected void trySearchNewRecipeCombined() {
        long maxVoltage = getMaxVoltage();
        List<FluidStack> fluidStackList = new ArrayList<>(GTUtility.fluidHandlerToList(getInputTank()));
        fluidStackList.add(Materials.DistilledWater.getFluid(Integer.MAX_VALUE));
        Recipe currentRecipe;

        // see if the last recipe we used still works
        if (checkPreviousRecipe()) {
            currentRecipe = this.previousRecipe;
            // If there is no active recipe, then we need to find one.
        } else {
            currentRecipe = getRecipeMap().findRecipe(Integer.MAX_VALUE, Collections.emptyList(), fluidStackList);
        }
        // If a recipe was found, then inputs were valid. Cache found recipe.
        if (currentRecipe != null) {
            this.previousRecipe = currentRecipe;
        }
        this.invalidInputsForRecipes = (currentRecipe == null);

        // proceed if we have a usable recipe.
        if (currentRecipe != null && checkRecipe(currentRecipe)) {
            prepareRecipe(currentRecipe);
        }
    }

    @Override
    public boolean prepareRecipe(Recipe recipe) {
        FluidStack recipeFluidStack = recipe.getFluidInputs().get(1).getInputFluidStack();
        FluidStack inputFluidStack = getInputFluidStack(recipeFluidStack);
        IHeatExchanger mte = (IHeatExchanger) metaTileEntity;
        int rMaxInletFlow = recipe.getProperty(MaxRateProperty.getInstance(), 0);

        int tMaxInletFlow = (int) Math.ceil((0.4 + 0.006 * mte.getThrottle()) * ((double) currentHeat / maxHeat) * mte.getParallel() * rMaxInletFlow);
        int threshold = (int) Math.ceil(0.01 * recipe.getProperty(FlowRateProperty.getInstance(), 0) * mte.getThrottle());

        if (inputFluidStack != null) {
            int amount = GTLiteUtils.clamp(inputFluidStack.amount, 0, tMaxInletFlow);
            if (amount >= threshold) {
                setSuperheat(true);
                return setRecipe(recipe, amount, 1);
            } else {
                setSuperheat(false);
                return setRecipe(recipe, amount, 0);
            }
        }
        return false;
    }

    private boolean setRecipe(Recipe recipe, int amount, int i) {
        Recipe tRecipe =  getRecipeMap().recipeBuilder().append(recipe, 1, false)
                .clearFluidOutputs()
                .fluidOutputs(recipe.getFluidOutputs().get(i))
                .fluidOutputs(recipe.getFluidOutputs().get(2))
                .build().getResult();
        RecipeBuilder<?> recipeBuilder = getRecipeMap().recipeBuilder();
        recipeBuilder.append(tRecipe, amount, false);
        applyParallelBonus(recipeBuilder);
        recipe = recipeBuilder.build().getResult();
        if (recipe != null && setupAndConsumeRecipeInputs(recipe, getInputInventory())) {
            setupRecipe(recipe);
            setRate(amount);
            return true;
        } else {
            metaTileEntity.doExplosion(6);
            return false;
        }
    }

    public FluidStack getInputFluidStack(FluidStack fluidStack) {
        return getInputTank().drain(new FluidStack(fluidStack.getFluid(), Integer.MAX_VALUE), false);
    }

    private void setHeat(int heat) {
        if (heat != this.currentHeat && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(GTLiteDataCode.ChannelHeatExchangerHeat, b -> b.writeVarInt(heat));
        }
        this.currentHeat = heat;
    }

    private void setSuperheat(boolean isSuperheat) {
        if (this.isSuperheat != isSuperheat && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(GTLiteDataCode.ChannelHeatExchangerSuperheat, b -> b.writeBoolean(isSuperheat));
        }
        this.isSuperheat = isSuperheat;
    }

    private void setRate(int rate) {
        if (this.rate != rate && ! metaTileEntity.getWorld().isRemote) {
            writeCustomData(GTLiteDataCode.ChannelHeatExchangerRate, b -> b.writeVarInt(rate));
        }
        this.rate = rate;
    }

    public double getHeatEfficiency() {
        return (double) currentHeat / maxHeat;
    }

    public int getRate() {
        return rate;
    }

    public boolean isSuperheat() {
        return isSuperheat;
    }

    @NotNull
    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setInteger("Heat", currentHeat);
        compound.setInteger("Rate", rate);
        compound.setBoolean("isSuperheat", isSuperheat);
        return compound;
    }

    @Override
    public void deserializeNBT(@NotNull NBTTagCompound compound) {
        super.deserializeNBT(compound);
        currentHeat = compound.getInteger("Heat");
        rate = compound.getInteger("Rate");
        isSuperheat = compound.getBoolean("isSuperheat");
    }

    @Override
    public void writeInitialData(@NotNull PacketBuffer buf) {
        super.writeInitialData(buf);
        buf.writeVarInt(currentHeat);
        buf.writeVarInt(rate);
        buf.writeBoolean(isSuperheat);
    }

    @Override
    public void receiveInitialData(@NotNull PacketBuffer buf) {
        super.receiveInitialData(buf);
        this.currentHeat = buf.readVarInt();
        this.rate = buf.readVarInt();
        this.isSuperheat = buf.readBoolean();
    }

    @Override
    public void receiveCustomData(int dataId, @NotNull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GTLiteDataCode.ChannelHeatExchangerHeat) {
            this.currentHeat = buf.readVarInt();
        }
        if (dataId == GTLiteDataCode.ChannelHeatExchangerSuperheat) {
            this.isSuperheat = buf.readBoolean();
        }
        if (dataId == GTLiteDataCode.ChannelHeatExchangerRate) {
            this.rate = buf.readVarInt();
        }
    }
}
