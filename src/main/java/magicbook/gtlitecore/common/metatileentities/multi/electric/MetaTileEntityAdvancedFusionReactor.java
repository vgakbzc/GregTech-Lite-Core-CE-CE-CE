package magicbook.gtlitecore.common.metatileentities.multi.electric;

import com.google.common.util.concurrent.AtomicDouble;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.*;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ImageCycleButtonWidget;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.IndicatorImageWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.FusionEUToStartProperty;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import static gregtech.api.GTValues.UEV;
import static gregtech.api.GTValues.UHV;

public class MetaTileEntityAdvancedFusionReactor extends RecipeMapMultiblockController {

    private final int tier;
    public final IBlockState casingState;
    public final IBlockState coilState;
    public final IBlockState cryostatState;
    public final IBlockState divertorState;
    public final IBlockState vacuumState;
    private EnergyContainerList inputEnergyContainers;
    private long heat = 0;
    private Integer color;
    private final FusionProgressSupplier progressBarSupplier;

    public MetaTileEntityAdvancedFusionReactor(ResourceLocation metaTileEntityId,
                                               int tier,
                                               IBlockState casingState,
                                               IBlockState coilState,
                                               IBlockState cryostatState,
                                               IBlockState divertorState,
                                               IBlockState vacuumState) {
        super(metaTileEntityId, RecipeMaps.FUSION_RECIPES);
        this.recipeMapWorkable = new AdvancedFusionRecipeLogic(this);
        this.tier = tier;
        this.casingState = casingState;
        this.coilState = coilState;
        this.cryostatState = cryostatState;
        this.divertorState = divertorState;
        this.vacuumState = vacuumState;
        this.energyContainer = new EnergyContainerHandler(this, Integer.MAX_VALUE, 0, 0, 0, 0) {
            @Nonnull
            @Override
            public String getName() {
                return GregtechDataCodes.FUSION_REACTOR_ENERGY_CONTAINER_TRAIT;
            }
        };
        this.progressBarSupplier = new FusionProgressSupplier();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAdvancedFusionReactor(metaTileEntityId, tier, casingState, coilState, cryostatState, divertorState, vacuumState);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("               ", "               ", "     cECEc     ", "     cECEc     ", "               ", "               ")
                .aisle("               ", "       C       ", "   icvvvvvci   ", "   icvvvvvci   ", "       C       ", "               ")
                .aisle("       C       ", "  C  ddddd  C  ", "  Cvv#####vvC  ", "  Cvv#####vvC  ", "  C  bbbbb  C  ", "       C       ")
                .aisle("   C   C   C   ", "   ddddddddd   ", " Iv#########vI ", " Iv#########vI ", "   bbbbbbbbb   ", "   C   C   C   ")
                .aisle("    C     C    ", "   ddd#C#ddd   ", " cv###vvv###vc ", " cv###vvv###vc ", "   bbb#C#bbb   ", "    C     C    ")
                .aisle("               ", "  dddC###Cddd  ", "cv###v#C#v###vc", "cv###v#C#v###vc", "  bbbC###Cbbb  ", "               ")
                .aisle("               ", "  dd##CCC##dd  ", "Ev##v#CXC#v##vE", "Ev##v#CXC#v##vE", "  bb##CCC##bb  ", "               ")
                .aisle("  CC       CC  ", " CddC#CCC#CddC ", "Cv##vCXXXCv##vC", "Cv##vCXXXCv##vC", " CbbC#CCC#CbbC ", "  CC       CC  ")
                .aisle("               ", "  dd##CCC##dd  ", "Ev##v#CXC#v##vE", "Ev##v#CXC#v##vE", "  bb##CCC##bb  ", "               ")
                .aisle("               ", "  dddC###Cddd  ", "cv###v#C#v###vc", "cv###v#C#v###vc", "  bbbC###Cbbb  ", "               ")
                .aisle("    C     C    ", "   ddd#C#ddd   ", " cv###vvv###vc ", " cv###vvv###vc ", "   bbb#C#bbb   ", "    C     C    ")
                .aisle("   C   C   C   ", "   ddddddddd   ", " Iv#########vI ", " Iv#########vI ", "   bbbbbbbbb   ", "   C   C   C   ")
                .aisle("       C       ", "  C  ddddd  C  ", "  Cvv#####vvC  ", "  Cvv#####vvC  ", "  C  bbbbb  C  ", "       C       ")
                .aisle("               ", "       C       ", "   icvvvvvci   ", "   icvvvvvci   ", "       S       ", "               ")
                .aisle("               ", "               ", "     cECEc     ", "     cECEc     ", "               ", "               ")
                .where('S', this.selfPredicate())
                .where('C', states(getCryostatState()))
                .where('X', states(getCoilState()))
                .where('d', states(getDivertorState()))
                .where('v', states(getVacuumState()))
                .where('c', states(getCasingState()))
                .where('E', states(getCasingState())
                        .or(metaTileEntities(Arrays.stream(MetaTileEntities.ENERGY_INPUT_HATCH)
                                .filter(mte -> mte != null && tier <= mte.getTier() && mte.getTier() <= UEV)
                                .toArray(MetaTileEntity[]::new))
                                .setMinGlobalLimited(1)
                                .setPreviewCount(16))
                )
                .where('I', states(getCasingState())
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMinGlobalLimited(2)
                                .setPreviewCount(8)))
                .where('i', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setMinGlobalLimited(2)
                                .setPreviewCount(8)))
                .where('b', states(getCasingState()))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private IBlockState getCasingState() {
        return casingState;
    }

    private IBlockState getCoilState() {
        return coilState;
    }

    private IBlockState getCryostatState() {
        return cryostatState;
    }

    private IBlockState getDivertorState() {
        return divertorState;
    }

    private IBlockState getVacuumState() {
        return vacuumState;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        if (this.recipeMapWorkable.isActive()) {
            if (tier == UHV) {
                return GTLiteTextures.ADVANCED_ACTIVE_FUSION_TEXTURE;
            } else {
                return GTLiteTextures.ULTIMATE_ACTIVE_FUSION_TEXTURE;
            }
        } else {
            if (tier == UHV) {
                return GTLiteTextures.ADVANCED_FUSION_TEXTURE;
            } else {
                return GTLiteTextures.ULTIMATE_FUSION_TEXTURE;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.FUSION_REACTOR_OVERLAY;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        long energyStored = this.energyContainer.getEnergyStored();
        super.formStructure(context);
        this.initializeAbilities();
        ((EnergyContainerHandler) this.energyContainer).setEnergyStored(energyStored);
    }

    @Override
    protected void initializeAbilities() {
        this.inputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.inputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputInventory = new ItemHandlerList(getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.outputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        List<IEnergyContainer> energyInputs = getAbilities(MultiblockAbility.INPUT_ENERGY);
        this.inputEnergyContainers = new EnergyContainerList(energyInputs);
        long euCapacity = calculateEnergyStorageFactor(energyInputs.size());
        this.energyContainer = new EnergyContainerHandler(this, euCapacity, GTValues.V[tier], 0, 0, 0) {
            @Nonnull
            @Override
            public String getName() {
                return GregtechDataCodes.FUSION_REACTOR_ENERGY_CONTAINER_TRAIT;
            }
        };
    }

    private long calculateEnergyStorageFactor(int energyInputAmount) {
        return energyInputAmount * (long) Math.pow(2, tier - 6) * 10000000L;
    }

    @Override
    protected void updateFormedValid() {
        if (this.inputEnergyContainers.getEnergyStored() > 0) {
            long energyAdded = this.energyContainer.addEnergy(this.inputEnergyContainers.getEnergyStored());
            if (energyAdded > 0) this.inputEnergyContainers.removeEnergy(energyAdded);
        }
        super.updateFormedValid();
        if (recipeMapWorkable.isWorking() && color == null) {
            if (recipeMapWorkable.getPreviousRecipe() != null && recipeMapWorkable.getPreviousRecipe().getFluidOutputs().size() > 0) {
                int newColor = 0xFF000000 | recipeMapWorkable.getPreviousRecipe().getFluidOutputs().get(0).getFluid().getColor();
                if (!Objects.equals(color, newColor)) {
                    color = newColor;
                    writeCustomData(GregtechDataCodes.UPDATE_COLOR, this::writeColor);
                }
            }
        } else if (!recipeMapWorkable.isWorking() && isStructureFormed() && color != null) {
            color = null;
            writeCustomData(GregtechDataCodes.UPDATE_COLOR, this::writeColor);
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        writeColor(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        readColor(buf);
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.UPDATE_COLOR) {
            readColor(buf);
        }
    }

    private void readColor(PacketBuffer buf) {
        color = buf.readBoolean() ? buf.readVarInt() : null;
    }

    private void writeColor(PacketBuffer buf) {
        buf.writeBoolean(color != null);
        if (color != null) {
            buf.writeVarInt(color);
        }
    }

    @Override
    protected ModularUI.Builder createUITemplate(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 198, 236);
        builder.image(4, 4, 190, 138, GuiTextures.DISPLAY);
        //  Energy Bar
        builder.widget((new ProgressWidget(() -> this.energyContainer.getEnergyCapacity() > 0L ? 1.0 * (double) this.energyContainer.getEnergyStored() / (double) this.energyContainer.getEnergyCapacity() : 0.0, 4, 144, 94, 7, GuiTextures.PROGRESS_BAR_FUSION_ENERGY, ProgressWidget.MoveType.HORIZONTAL))
                .setHoverTextConsumer(this::addEnergyBarHoverText));
        //  Heat Bar
        builder.widget((new ProgressWidget(() -> this.energyContainer.getEnergyCapacity() > 0L ? 1.0 * (double) this.heat / (double) this.energyContainer.getEnergyCapacity() : 0.0, 100, 144, 94, 7, GuiTextures.PROGRESS_BAR_FUSION_HEAT, ProgressWidget.MoveType.HORIZONTAL))
                .setHoverTextConsumer(this::addHeatBarHoverText));
        //  Logo
        builder.widget((new IndicatorImageWidget(174, 122, 17, 17, this.getLogo()))
                .setWarningStatus(this.getWarningLogo(), this::addWarningText)
                .setErrorStatus(this.getErrorLogo(), this::addErrorText));
        //  Fusion Reactor Title
        if (this.tier == UHV) {
            builder.widget((new ImageWidget(66, 9, 67, 12, GTLiteGuiTextures.FUSION_REACTOR_MK4_TITLE)).setIgnoreColor(true));
        } else {
            builder.widget((new ImageWidget(65, 9, 69, 12, GTLiteGuiTextures.FUSION_REACTOR_MK5_TITLE)).setIgnoreColor(true));
        }
        //  Fusion Reactor Diagram
        builder.widget((new ImageWidget(55, 24, 89, 101, GuiTextures.FUSION_REACTOR_DIAGRAM)).setIgnoreColor(true));
        builder.widget(FusionProgressSupplier.Type.BOTTOM_LEFT.getWidget(this));
        builder.widget(FusionProgressSupplier.Type.TOP_LEFT.getWidget(this));
        builder.widget(FusionProgressSupplier.Type.TOP_RIGHT.getWidget(this));
        builder.widget(FusionProgressSupplier.Type.BOTTOM_RIGHT.getWidget(this));
        builder.widget((new ImageWidget(7, 98, 108, 41, GuiTextures.FUSION_REACTOR_LEGEND)).setIgnoreColor(true));
        //  Bottom
        TextureArea var10007 = GuiTextures.BUTTON_POWER;
        MultiblockRecipeLogic var10008 = this.recipeMapWorkable;
        Objects.requireNonNull(var10008);
        BooleanSupplier var3 = var10008::isWorkingEnabled;
        MultiblockRecipeLogic var10009 = this.recipeMapWorkable;
        Objects.requireNonNull(var10009);
        builder.widget(new ImageCycleButtonWidget(173, 211, 18, 18, var10007, var3, var10009::setWorkingEnabled));
        builder.widget(new ImageWidget(173, 229, 18, 6, GuiTextures.BUTTON_POWER_DETAIL));
        builder.widget((new ImageCycleButtonWidget(173, 189, 18, 18, GuiTextures.BUTTON_VOID_MULTIBLOCK, 4, this::getVoidingMode, this::setVoidingMode))
                .setTooltipHoverString(MultiblockWithDisplayBase::getVoidingModeTooltip));
        builder.widget((new ImageWidget(173, 171, 18, 18, GuiTextures.BUTTON_NO_DISTINCT_BUSES))
                .setTooltip("gregtech.multiblock.universal.distinct_not_supported"));
        builder.widget(this.getFlexButton(173, 153, 18, 18));
        builder.bindPlayerInventory(entityPlayer.inventory, 153);
        return builder;
    }

    private void addEnergyBarHoverText(List<ITextComponent> hoverList) {
        ITextComponent energyInfo = TextComponentUtil.stringWithColor(TextFormatting.AQUA, TextFormattingUtil.formatNumbers(this.energyContainer.getEnergyStored()) + " / " + TextFormattingUtil.formatNumbers(this.energyContainer.getEnergyCapacity()) + " EU");
        hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.energy_stored", energyInfo));
    }

    private void addHeatBarHoverText(List<ITextComponent> hoverList) {
        ITextComponent heatInfo = TextComponentUtil.stringWithColor(TextFormatting.RED, TextFormattingUtil.formatNumbers(this.heat) + " / " + TextFormattingUtil.formatNumbers(this.energyContainer.getEnergyCapacity()));
        hoverList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.fusion_reactor.heat", heatInfo));
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.fusion_reactor.capacity", calculateEnergyStorageFactor(16) / 1000000L));
        tooltip.add(I18n.format("gregtech.machine.fusion_reactor.overclocking"));
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    private static class FusionProgressSupplier {
        private final AtomicDouble tracker = new AtomicDouble(0.0);
        private final ProgressWidget.TimedProgressSupplier bottomLeft = new ProgressWidget.TimedProgressSupplier(200, 164, false) {
            public double getAsDouble() {
                double val = super.getAsDouble();
                FusionProgressSupplier.this.tracker.set(val);
                return val >= 0.25 ? 1.0 : 4.0 * val;
            }

            public void resetCountdown() {
                super.resetCountdown();
                FusionProgressSupplier.this.tracker.set(0.0);
            }
        };
        private final DoubleSupplier topLeft = () -> {
            double val = this.tracker.get();
            if (val < 0.25) {
                return 0.0;
            } else {
                return val >= 0.5 ? 1.0 : 4.0 * (val - 0.25);
            }
        };
        private final DoubleSupplier topRight = () -> {
            double val = this.tracker.get();
            if (val < 0.5) {
                return 0.0;
            } else {
                return val >= 0.75 ? 1.0 : 4.0 * (val - 0.5);
            }
        };
        private final DoubleSupplier bottomRight = () -> {
            double val = this.tracker.get();
            if (val < 0.75) {
                return 0.0;
            } else {
                return val >= 1.0 ? 1.0 : 4.0 * (val - 0.75);
            }
        };

        public FusionProgressSupplier() {}

        public void resetCountdown() {
            this.bottomLeft.resetCountdown();
        }

        public DoubleSupplier getSupplier(FusionProgressSupplier.Type type) {
            Object var10000;
            switch (type) {
                case BOTTOM_LEFT:
                    var10000 = this.bottomLeft;
                    break;
                case TOP_LEFT:
                    var10000 = this.topLeft;
                    break;
                case TOP_RIGHT:
                    var10000 = this.topRight;
                    break;
                case BOTTOM_RIGHT:
                    var10000 = this.bottomRight;
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return (DoubleSupplier) var10000;
        }

        private enum Type {
            BOTTOM_LEFT(61, 66, 35, 41, GuiTextures.PROGRESS_BAR_FUSION_REACTOR_DIAGRAM_BL, ProgressWidget.MoveType.VERTICAL),
            TOP_LEFT(61, 30, 41, 35, GuiTextures.PROGRESS_BAR_FUSION_REACTOR_DIAGRAM_TL, ProgressWidget.MoveType.HORIZONTAL),
            TOP_RIGHT(103, 30, 35, 41, GuiTextures.PROGRESS_BAR_FUSION_REACTOR_DIAGRAM_TR, ProgressWidget.MoveType.VERTICAL_DOWNWARDS),
            BOTTOM_RIGHT(97, 72, 41, 35, GuiTextures.PROGRESS_BAR_FUSION_REACTOR_DIAGRAM_BR, ProgressWidget.MoveType.HORIZONTAL_BACKWARDS);

            private final int x;
            private final int y;
            private final int width;
            private final int height;
            private final TextureArea texture;
            private final ProgressWidget.MoveType moveType;

            Type(int x, int y, int width, int height, TextureArea texture, ProgressWidget.MoveType moveType) {
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
                this.texture = texture;
                this.moveType = moveType;
            }

            public ProgressWidget getWidget(MetaTileEntityAdvancedFusionReactor instance) {
                return (new ProgressWidget(() -> instance.recipeMapWorkable.isActive() ? instance.progressBarSupplier.getSupplier(this).getAsDouble() : 0.0, this.x, this.y, this.width, this.height, this.texture, this.moveType))
                        .setIgnoreColor(true)
                        .setHoverTextConsumer((tl) -> MultiblockDisplayText.builder(tl, instance.isStructureFormed())
                                .setWorkingStatus(instance.recipeMapWorkable.isWorkingEnabled(), instance.recipeMapWorkable.isActive())
                                .addWorkingStatusLine());
            }
        }
    }

    private class AdvancedFusionRecipeLogic extends MultiblockRecipeLogic {

        public AdvancedFusionRecipeLogic(MetaTileEntityAdvancedFusionReactor tileEntity) {
            super(tileEntity);
        }

        @Override
        protected double getOverclockingDurationDivisor() {
            return 2.0D;
        }

        @Override
        protected double getOverclockingVoltageMultiplier() {
            return 2.0D;
        }

        @Override
        public long getMaxVoltage() {
            return Math.min(GTValues.V[tier], super.getMaxVoltage());
        }

        @Override
        public void updateWorkable() {
            super.updateWorkable();
            // Drain heat when the reactor is not active, is paused via soft mallet, or does not have enough energy and has fully wiped recipe progress
            // Don't drain heat when there is not enough energy and there is still some recipe progress, as that makes it doubly hard to complete the recipe
            // (Will have to recover heat and recipe progress)
            if (heat > 0) {
                if (!isActive || !workingEnabled || (hasNotEnoughEnergy && progressTime == 0)) {
                    heat = heat <= 10000 ? 0 : (heat - 10000);
                }
            }
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (!super.checkRecipe(recipe))
                return false;

            // if the reactor is not able to hold enough energy for it, do not run the recipe
            if (recipe.getProperty(FusionEUToStartProperty.getInstance(), 0L) > energyContainer.getEnergyCapacity())
                return false;

            long heatDiff = recipe.getProperty(FusionEUToStartProperty.getInstance(), 0L) - heat;
            // if the stored heat is >= required energy, recipe is okay to run
            if (heatDiff <= 0)
                return true;

            // if the remaining energy needed is more than stored, do not run
            if (energyContainer.getEnergyStored() < heatDiff)
                return false;

            // remove the energy needed
            energyContainer.removeEnergy(heatDiff);
            // increase the stored heat
            heat += heatDiff;
            return true;
        }

        @Nonnull
        @Override
        public NBTTagCompound serializeNBT() {
            NBTTagCompound tag = super.serializeNBT();
            tag.setLong("Heat", heat);
            return tag;
        }

        @Override
        public void deserializeNBT(@Nonnull NBTTagCompound compound) {
            super.deserializeNBT(compound);
            heat = compound.getLong("Heat");
        }
    }
}
