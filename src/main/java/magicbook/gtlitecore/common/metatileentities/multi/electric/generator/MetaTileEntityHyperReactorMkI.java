package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockActiveMultiblockCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.UIV;
import static gregtech.api.GTValues.V;

public class MetaTileEntityHyperReactorMkI extends FuelMultiblockController implements IProgressBarMultiblock {

    private boolean boostAllowed;

    public MetaTileEntityHyperReactorMkI(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.HYPER_REACTOR_MK1_RECIPES, UEV);
        this.recipeMapWorkable = new HyperReactorMark1WorkableHandler(this);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[UIV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityHyperReactorMkI(metaTileEntityId);
    }

    @Override
    protected void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        List<IEnergyContainer> energyContainer = new ArrayList<>(this.getAbilities(MultiblockAbility.OUTPUT_ENERGY));
        energyContainer.addAll(this.getAbilities(MultiblockAbility.OUTPUT_LASER));
        this.energyContainer = new EnergyContainerList(energyContainer);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        HyperReactorMark1WorkableHandler recipeLogic = (HyperReactorMark1WorkableHandler) this.recipeMapWorkable;
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive())
                .addEnergyProductionLine(V[UIV], recipeLogic.getRecipeEUt())
                .addFuelNeededLine(recipeLogic.getRecipeFluidInputInfo(), recipeLogic.getPreviousRecipeDuration())
                .addCustom((tl) -> {
                    if (this.isStructureFormed() && recipeLogic.isBoosted) {
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.AQUA, "gtlitecore.machine.large_naquadah_reactor.plasma_oxygen_boosted"));
                    }
                })
                .addWorkingStatusLine();
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.base_production_eut", GTValues.V[UEV]));
        tooltip.add(I18n.format("gtlitecore.machine.hyper_reactor_mk1.tooltip.boost", GTValues.V[UEV] * 4L));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.laser_output"));
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCCCC", "G#H#G", "GHHHG", "G#H#G", "CCCCC")
                .aisle("CCCCC", "G###G", "G#H#G", "G###G", "CCCCC")
                .aisle("CCSCC", "CGGGC", "CGGGC", "CGGGC", "CCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(autoAbilities(false, true, false, false, true, false, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getOutputVoltage() <= GTValues.V[UIV];})
                                .toArray(MetaTileEntity[]::new))
                                .setMaxGlobalLimited(1)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.OUTPUT_LASER)
                                .setMaxGlobalLimited(1)
                                .setPreviewCount(1)))
                .where('G', states(getGlassState()))
                .where('H', states(getUniqueCasingState()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.NAQUADRIA_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GTLiteMetaBlocks.ACTIVE_MULTIBLOCK_CASING.getState(BlockActiveMultiblockCasing.ActiveCasingType.HYPER_CORE_MK1);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.NAQUADRIA_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.POWER_SUBSTATION_OVERLAY;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        IEnergyContainer energyContainer = this.getEnergyContainer();
        this.boostAllowed = energyContainer != null && energyContainer.getOutputVoltage() >= GTValues.V[UIV];
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    public boolean isBoostAllowed() {
        return this.boostAllowed;
    }

    @Override
    public int getNumProgressBars() {
        return 2;
    }

    @Override
    public double getFillPercentage(int index) {
        int[] plasmaAmount;
        if (index == 0) {
            plasmaAmount = new int[2];
            if (this.getInputFluidInventory() != null) {
                MultiblockFuelRecipeLogic recipeLogic = (MultiblockFuelRecipeLogic) this.recipeMapWorkable;
                if (recipeLogic.getInputFluidStack() != null) {
                    FluidStack testStack = recipeLogic.getInputFluidStack().copy();
                    testStack.amount = Integer.MAX_VALUE;
                    plasmaAmount = this.getTotalFluidAmount(testStack, this.getInputFluidInventory());
                }
            }

            return plasmaAmount[1] != 0 ? 1.0 * plasmaAmount[0] / (double) plasmaAmount[1] : 0.0;
        } else {
            plasmaAmount = new int[2];
            if (this.getInputFluidInventory() != null && this.isBoostAllowed()) {
                FluidStack plasmaStack = Materials.Iron.getPlasma(Integer.MAX_VALUE);
                plasmaAmount = this.getTotalFluidAmount(plasmaStack, this.getInputFluidInventory());
            }

            return plasmaAmount[1] != 0 ? 1.0 * plasmaAmount[0] / (double) plasmaAmount[1] : 0.0;
        }
    }

    @Override
    public TextureArea getProgressBarTexture(int index) {
        if (index == 0) {
            return GuiTextures.PROGRESS_BAR_LCE_FUEL;
        } else {
            return GuiTextures.PROGRESS_BAR_HPCA_COMPUTATION;
        }
    }

    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        if (index == 0) {
            this.addFuelText(hoverList);
        } else {
            int plasmaStored;
            int plasmaCapacity;
            TextComponentString plasmaInfo;

            if (this.isBoostAllowed()) {
                plasmaStored = 0;
                plasmaCapacity = 0;
                if (this.isStructureFormed() && this.getInputFluidInventory() != null) {
                    FluidStack plasmaStack = Materials.Iron.getPlasma(Integer.MAX_VALUE);
                    int[] plasmaAmount = this.getTotalFluidAmount(plasmaStack, this.getInputFluidInventory());
                    plasmaStored = plasmaAmount[0];
                    plasmaCapacity = plasmaAmount[1];
                }

                plasmaInfo = TextComponentUtil.stringWithColor(TextFormatting.AQUA, TextFormattingUtil.formatNumbers(plasmaStored) + " / " + TextFormattingUtil.formatNumbers(plasmaCapacity) + " L");
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gtlitecore.machine.large_naquadah_reactor.plasma_amount", plasmaInfo));
            } else {
                hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.YELLOW, "gtlitecore.machine.large_naquadah_reactor.boost_disallowed"));
            }
        }
    }

    private static class HyperReactorMark1WorkableHandler extends MultiblockFuelRecipeLogic {

        private boolean isBoosted = false;
        private final MetaTileEntityHyperReactorMkI hyperReactor;
        private static final FluidStack PLASMA_IRON_STACK = Materials.Iron.getPlasma(100);

        public HyperReactorMark1WorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.hyperReactor = (MetaTileEntityHyperReactorMkI) tileEntity;
        }

        @Override
        protected void updateRecipeProgress() {
            if (this.canRecipeProgress && this.drawEnergy(this.recipeEUt, true)) {
                this.drainPlasma();
                this.drawEnergy(this.recipeEUt, false);
                if (++this.progressTime > this.maxProgressTime) {
                    this.completeRecipe();
                }
            }
        }

        protected void checkPlasma() {
            if (this.hyperReactor.isBoostAllowed()) {
                IMultipleTankHandler inputTank = this.hyperReactor.getInputFluidInventory();
                FluidStack boosterStack = PLASMA_IRON_STACK;
                this.isBoosted = boosterStack.isFluidStackIdentical(inputTank.drain(boosterStack, false));
            }
        }

        protected void drainPlasma() {
            if (this.isBoosted && this.totalContinuousRunningTime % 20L == 0L) {
                this.hyperReactor.getInputFluidInventory().drain(PLASMA_IRON_STACK, true);
            }
        }

        @Override
        protected boolean shouldSearchForRecipes() {
            this.checkPlasma();
            return super.shouldSearchForRecipes();
        }

        @Override
        protected boolean canProgressRecipe() {
            return super.canProgressRecipe();
        }

        @Override
        public long getMaxVoltage() {
            return this.isBoosted ? V[UEV] * 2L : V[UEV];
        }

        @Override
        protected long boostProduction(long production) {
            if (this.isBoosted) {
                return production * 2L;
            } else {
                return production;
            }
        }

        @Override
        public void invalidate() {
            this.isBoosted = false;
            super.invalidate();
        }
    }

}