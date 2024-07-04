package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.Widget;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ImageCycleButtonWidget;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.api.util.LocalizationUtils;
import gregtech.api.util.TextComponentUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.items.behaviors.TurbineRotorBehavior;
import magicbook.gtlitecore.api.capability.GTLiteDataCode;
import magicbook.gtlitecore.api.capability.IReinforcedRotorHolder;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.metatileentity.multi.ITurbineMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.rotorHolders;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.formatNumbers;

public class MetaTileEntityMegaTurbine extends FuelMultiblockController implements ITieredMetaTileEntity, ITurbineMode, IProgressBarMultiblock {

    private int mode = 0;
    public final int tier;
    public final IBlockState casingState;
    public final IBlockState gearboxState;
    public final ICubeRenderer casingRenderer;
    public final boolean hasMufflerHatch;
    public final ICubeRenderer frontOverlay;
    private static final int MIN_DURABILITY_TO_WARN = 10;
    public IFluidHandler exportFluidHandler;

    public MetaTileEntityMegaTurbine(ResourceLocation metaTileEntityId,
                                     RecipeMap<?> recipeMap,
                                     int tier,
                                     IBlockState casingState,
                                     IBlockState gearboxState,
                                     ICubeRenderer casingRenderer,
                                     boolean hasMufflerHatch,
                                     ICubeRenderer frontOverlay) {
        super(metaTileEntityId, recipeMap, tier);
        this.casingState = casingState;
        this.gearboxState = gearboxState;
        this.casingRenderer = casingRenderer;
        this.hasMufflerHatch = hasMufflerHatch;
        this.frontOverlay = frontOverlay;
        this.tier = tier;
        this.recipeMapWorkable = new MegaTurbineWorkableHandler(this, tier);
        this.recipeMapWorkable.setMaximumOverclockVoltage(GTValues.V[tier]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMegaTurbine(metaTileEntityId, recipeMap, tier, casingState, gearboxState, casingRenderer, hasMufflerHatch, frontOverlay);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        this.exportFluidHandler = new FluidTankList(true, getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        ((MegaTurbineWorkableHandler) this.recipeMapWorkable).updateTanks();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.exportFluidHandler = null;
    }

    @Override
    protected void initializeAbilities() {
        this.inputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.inputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.outputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        List<IEnergyContainer> energyContainer = new ArrayList<>(this.getAbilities(MultiblockAbility.OUTPUT_ENERGY));
        energyContainer.addAll(this.getAbilities(MultiblockAbility.OUTPUT_LASER));
        this.energyContainer = new EnergyContainerList(energyContainer);
    }

    @Override
    public boolean checkRecipe(@NotNull Recipe recipe, boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess) && checkRotors() && checkRotorMaterial();
    }

    @Override
    protected long getMaxVoltage() {
        long maxProduction = recipeMapWorkable.getMaxVoltage();
        long currentProduction = ((MegaTurbineWorkableHandler) recipeMapWorkable).boostProduction((int) maxProduction);
        if (isActive() && currentProduction < maxProduction) {
            return recipeMapWorkable.getMaxVoltage();
        } else {
            return 0L;
        }
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean isRotorFaceFree() {
        List<IReinforcedRotorHolder> rotorHolders = getRotorHolders();
        if (!isStructureFormed() || rotorHolders == null) return false;

        for (IReinforcedRotorHolder rotorHolder : rotorHolders) {
            if (!rotorHolder.isFrontFaceFree()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<IReinforcedRotorHolder> getRotorHolders() {
        return this.getAbilities(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY);
    }

    protected void setupRotors() {
        if (checkRotors()) return;
        for (int index = 0; index < inputInventory.getSlots(); index++) {
            ItemStack itemStack = inputInventory.getStackInSlot(index);
            if (itemStack.isEmpty()) continue;

            if (TurbineRotorBehavior.getInstanceFor(itemStack) == null) continue;

            for (IReinforcedRotorHolder holder : getRotorHolders()) {
                if (!holder.hasRotor()) {
                    inputInventory.extractItem(index, 1, false);
                    holder.setRotor(itemStack);
                    break;
                }
            }
        }
    }

    protected void setSpeed(int speed) {
        for (IReinforcedRotorHolder holder : getRotorHolders()) {
            if (holder.hasRotor()) {
                holder.setCurrentSpeed(speed);
            }
        }
    }

    protected boolean checkRotors() {
        for (IReinforcedRotorHolder holder : getRotorHolders()) {
            if (!holder.hasRotor()) {
                return false;
            }
        }
        return true;
    }

    protected boolean checkRotorMaterial() {
        return getRotorHolders().stream()
                .map(IReinforcedRotorHolder::getRotorMaterial)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet()).size() == 1;
    }

    @Override
    public void update() {
        super.update();
        if (getOffsetTimer() % 20 == 0) {
            if (!checkRotors()) {
                setSpeed(0);
            }
            if (!getWorld().isRemote && isStructureFormed()) {
                setupRotors();
            }
        }
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCC", "CRCACRC", "CCCACCC", "CCCACCC", "CRCACRC", "CCCACCC", "CCCACCC", "CRCACRC", "CCCCCCC")
                .aisle("CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC")
                .aisle("CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCMMMCC")
                .aisle("CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCMSMCC")
                .aisle("CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCMMMCC")
                .aisle("CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC", "CCCCCCC", "CGCCCGC", "CCCCCCC")
                .aisle("CCCCCCC", "CRCACRC", "CCCACCC", "CCCACCC", "CRCACRC", "CCCACCC", "CCCACCC", "CRCACRC", "CCCCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('G', states(getGearBoxState()))
                .where('R', rotorHolders())
                .where('M', states(getCasingState())
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH))
                        .setPreviewCount(8))
                .where('A', states(getCasingState())
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY)
                                .setMaxGlobalLimited(1)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.OUTPUT_LASER)
                                .setMaxGlobalLimited(1)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS)
                                .setMaxGlobalLimited(1)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(4)
                                .setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setMinGlobalLimited(1)
                                .setMaxGlobalLimited(4)
                                .setPreviewCount(1)))
                .build();
    }

    public IBlockState getCasingState() {
        return casingState;
    }

    public IBlockState getGearBoxState() {
        return gearboxState;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return casingRenderer;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return frontOverlay;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockFuelRecipeLogic recipeLogic = (MultiblockFuelRecipeLogic) this.recipeMapWorkable;
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive())
                //  Custom Energy Production line
                //  Do not use {@link MultiblockDisplayText#addEnergyProductionLine(long, long)},
                //  because it is wrong in Mega Turbine situation.
                .addCustom((tl) -> {
                    IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
                    if (this.checkRotors() && this.checkRotorMaterial() && rotorHolder.getRotorEfficiency() > 0) {
                        long maxProduction = recipeMapWorkable.getMaxVoltage();
                        long currentProduction = this.isActive() ? ((MegaTurbineWorkableHandler) recipeMapWorkable).boostProduction((int) maxProduction) : 0;
                        String voltageName = GTValues.VNF[GTUtility.getTierByVoltage(currentProduction)];
                        if (this.isActive()) {
                            ITextComponent energyPerTickInfo = TextComponentUtil.stringWithColor(
                                    TextFormatting.GRAY,
                                    formatNumbers(currentProduction)
                            );
                            tl.add(TextComponentUtil.translationWithColor(
                                    TextFormatting.GRAY,
                                    "gtlitecore.universal.multiblock.energy_per_tick",
                                    energyPerTickInfo,
                                    voltageName
                            ));
                        }
                    }
                })
                //  Custom Rotor Efficiency line
                //  Use to show Total Efficiency of All Rotors in Mega Turbine.
                .addCustom((tl) -> {
                    IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
                    if (this.checkRotors() && this.checkRotorMaterial() && rotorHolder.getRotorEfficiency() > 0) {
                        ITextComponent efficiencyInfo = TextComponentUtil.stringWithColor(
                                TextFormatting.AQUA,
                                formatNumbers(rotorHolder.getTotalEfficiency()) + "%");
                        tl.add(TextComponentUtil.translationWithColor(
                                TextFormatting.GRAY,
                                "gregtech.multiblock.turbine.efficiency",
                                efficiencyInfo
                        ));
                    }
                })
                .addFuelNeededLine(recipeLogic.getRecipeFluidInputInfo(), recipeLogic.getPreviousRecipeDuration())
                .addWorkingStatusLine();
    }

    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed(), false)
                //  Check durability of Rotors.
                .addCustom(tl -> {
                    if (this.isStructureFormed()) {
                        IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
                        if (this.checkRotors() && this.checkRotorMaterial() && rotorHolder.getRotorEfficiency() > 0) {
                            if (rotorHolder.getRotorDurabilityPercent() <= MIN_DURABILITY_TO_WARN) {
                                tl.add(TextComponentUtil.translationWithColor(
                                        TextFormatting.YELLOW,
                                        "gregtech.multiblock.turbine.rotor_durability_low"
                                ));
                            }
                        }
                    }
                })
                //  Do not check if rotors are exist in all Rotor Holder,
                //  because it maybe causes some problem.
                .addLowDynamoTierLine(this.isDynamoTierTooLow())
                .addMaintenanceProblemLines(this.getMaintenanceProblems());
    }

    @Override
    protected void addErrorText(List<ITextComponent> textList) {
        super.addErrorText(textList);
        if (this.isStructureFormed()) {
            if (!this.isRotorFaceFree()) {
                textList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.RED,
                        "gregtech.multiblock.turbine.obstructed"
                ));
                textList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.GRAY,
                        "gregtech.multiblock.turbine.obstructed.desc"
                ));
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.universal.tooltip.base_production_eut", GTValues.V[tier] * 2 * 16));
        tooltip.add(I18n.format("gregtech.multiblock.turbine.efficiency_tooltip", GTValues.VNF[tier]));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.laser_output"));
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("gtlitecore.machine.mega_turbine.description")};
    }

    @NotNull
    @Override
    protected Widget getFlexButton(int x, int y, int width, int height) {
        return new ImageCycleButtonWidget(x, y, width, height, GTLiteGuiTextures.BUTTON_HIGH_SPEED_MODE, 2, this::getMode, this::setMode)
                .setTooltipHoverString(i -> LocalizationUtils.format("gtlitecore.machine.mega_turbine.mode." + getMode()));
    }

    @Override
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
        if (!getWorld().isRemote) {
            writeCustomData(GTLiteDataCode.ChannelMegaTurbine, buf -> buf.writeByte(mode));
            markDirty();
        }
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GTLiteDataCode.ChannelMegaTurbine) {
            this.mode = buf.readByte();
            scheduleRenderUpdate();
        }
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public boolean isStructureObstructed() {
        return super.isStructureObstructed() || !isRotorFaceFree();
    }

    @Override
    public boolean hasMufflerMechanics() {
        return hasMufflerHatch;
    }

    @Override
    public boolean canVoidRecipeItemOutputs() {
        return true;
    }

    @Override
    public boolean canVoidRecipeFluidOutputs() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeByte(mode);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.mode = buf.readByte();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setByte("mode", (byte) mode);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.mode = data.getByte("mode");
    }

    @Override
    public int getNumProgressBars() {
        return 3;
    }

    @Override
    public double getFillPercentage(int index) {
        if (index == 0) {
            int[] fuelAmount = new int[2];
            if (this.getInputFluidInventory() != null) {
                MultiblockFuelRecipeLogic recipeLogic = (MultiblockFuelRecipeLogic) this.recipeMapWorkable;
                if (recipeLogic.getInputFluidStack() != null) {
                    FluidStack testStack = recipeLogic.getInputFluidStack().copy();
                    testStack.amount = Integer.MAX_VALUE;
                    fuelAmount = this.getTotalFluidAmount(testStack, this.getInputFluidInventory());
                }
            }
            return fuelAmount[1] != 0 ? 1.0 * fuelAmount[0] / fuelAmount[1] : 0;
        } else if (index == 1) {
            IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
            return rotorHolder != null ? 1.0 * rotorHolder.getRotorSpeed() / rotorHolder.getMaxRotorHolderSpeed() : 0;
        } else {
            IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
            return rotorHolder != null ? 1.0 * rotorHolder.getRotorDurabilityPercent() / 100 : 0;
        }
    }

    @Override
    public TextureArea getProgressBarTexture(int index) {
        if (index == 0) {
            return GuiTextures.PROGRESS_BAR_LCE_FUEL;
        } else if (index == 1) {
            return GuiTextures.PROGRESS_BAR_TURBINE_ROTOR_SPEED;
        } else {
            return GuiTextures.PROGRESS_BAR_TURBINE_ROTOR_DURABILITY;
        }
    }

    @Override
    public void addBarHoverText(List<ITextComponent> hoverList, int index) {
        if (index == 0) {
            this.addFuelText(hoverList);
        } else if (index == 1) {
            IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
            if (rotorHolder == null || !this.checkRotors() || rotorHolder.getRotorEfficiency() <= 0) {
                hoverList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.YELLOW,
                        "gregtech.multiblock.turbine.no_rotor"));
            } else {
                int rotorSpeed = rotorHolder.getRotorSpeed();
                int rotorMaxSpeed = rotorHolder.getMaxRotorHolderSpeed();
                ITextComponent rpmTranslated = TextComponentUtil.translationWithColor(
                        this.getRotorSpeedColor(rotorSpeed, rotorMaxSpeed),
                        "gregtech.multiblock.turbine.rotor_rpm_unit_name");
                ITextComponent rotorInfo = TextComponentUtil.translationWithColor(
                        this.getRotorSpeedColor(rotorSpeed, rotorMaxSpeed),
                        "%s / %s %s",
                        formatNumbers(rotorSpeed),
                        formatNumbers(rotorMaxSpeed),
                        rpmTranslated);
                hoverList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.GRAY,
                        "gregtech.multiblock.turbine.rotor_speed",
                        rotorInfo));
            }
        } else {
            IReinforcedRotorHolder rotorHolder = this.getRotorHolders().get(0);
            if (rotorHolder == null || !this.checkRotors() || rotorHolder.getRotorEfficiency() <= 0) {
                hoverList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.YELLOW,
                        "gregtech.multiblock.turbine.no_rotor"));
            } else {
                int rotorDurability = rotorHolder.getRotorDurabilityPercent();
                ITextComponent rotorInfo = TextComponentUtil.stringWithColor(
                        this.getRotorDurabilityColor(rotorDurability),
                        rotorDurability + "%");
                hoverList.add(TextComponentUtil.translationWithColor(
                        TextFormatting.GRAY,
                        "gregtech.multiblock.turbine.rotor_durability",
                        rotorInfo));
            }
        }
    }

    private TextFormatting getRotorDurabilityColor(int durability) {
        if (durability > 40) {
            return TextFormatting.GREEN;
        } else if (durability > MIN_DURABILITY_TO_WARN) {
            return TextFormatting.YELLOW;
        } else {
            return TextFormatting.RED;
        }
    }

    private TextFormatting getRotorSpeedColor(int rotorSpeed, int maxRotorSpeed) {
        double speedRatio = 1.0 * rotorSpeed / maxRotorSpeed;
        if (speedRatio < 0.4) {
            return TextFormatting.RED;
        } else if (speedRatio < 0.8) {
            return TextFormatting.YELLOW;
        } else {
            return TextFormatting.GREEN;
        }
    }
}