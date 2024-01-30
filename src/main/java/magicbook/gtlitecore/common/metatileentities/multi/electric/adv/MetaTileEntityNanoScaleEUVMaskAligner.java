package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockComputerCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockScienceCasing;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.UV;

@Deprecated
public class MetaTileEntityNanoScaleEUVMaskAligner extends MultiMapMultiblockController {

    public int casingTier;

    public MetaTileEntityNanoScaleEUVMaskAligner(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.LASER_ENGRAVER_RECIPES,
                GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES});
        this.recipeMapWorkable = new NanoScaleEUVMaskAlignerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityNanoScaleEUVMaskAligner(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("FieldCasingTieredStats");
        this.casingTier = GTLiteUtils.getOrDefault(() -> type instanceof WrappedIntTier,
                () -> ((WrappedIntTier) type).getIntTier(), 0);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.casingTier = 0;
    }

    @Override
    protected void initializeAbilities() {
        this.inputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.inputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputInventory = new ItemHandlerList(this.getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.outputFluidInventory = new FluidTankList(this.allowSameFluidFillForOutputs(), this.getAbilities(MultiblockAbility.EXPORT_FLUIDS));
        List<IEnergyContainer> energyContainer = new ArrayList<>(this.getAbilities(MultiblockAbility.INPUT_ENERGY));
        energyContainer.addAll(this.getAbilities(MultiblockAbility.INPUT_LASER));
        this.energyContainer=new EnergyContainerList(energyContainer);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("F      F", "F      F", "        ", "        ", "        ", "        ", "        ")
                .aisle("        ", "        ", "FXXXXXXF", "EGGGGGGE", "EGGGGGGE", "EGGGGGGE", " XXXXXX ")
                .aisle("        ", "        ", "ECCCCCCE", "DOOOOOOD", "DOOOOOOD", "DOOOOOOD", "ECCCCCCE")
                .aisle("        ", "        ", "ECccccCE", "DOOOOOOD", "DooooooD", "DOOOOOOD", "ECccccCE")
                .aisle("        ", "        ", "ECCCCCCE", "DOOOOOOD", "DOOOOOOD", "DOOOOOOD", "ECCCCCCE")
                .aisle("        ", "        ", "FXXXXXXF", "EGGGGGGE", "SGGGGGGE", "EGGGGGGE", " XXXXXX ")
                .aisle("F      F", "F      F", "        ", "        ", "        ", "        ", "        ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState()))
                .where('E', states(getCasingState())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.INPUT_LASER)
                                .setMaxGlobalLimited(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS)
                                .setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS)
                                .setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setMaxGlobalLimited(3))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1)))
                .where('X', states(getSecondCasingState()))
                .where('D', states(getThirdCasingState()))
                .where('O', states(getCoilState()))
                .where('o', states(getBoilerCasingState()))
                .where('G', states(getGlassState()))
                .where('c', GTLiteTraceabilityPredicate.FIELD_CASING.get())
                .where('F', states(getFrameState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.COMPUTER_CASING.getState(BlockComputerCasing.CasingType.HIGH_POWER_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.NaquadahAlloy).getBlock(Materials.NaquadahAlloy);
    }

    private static IBlockState getGlassState() {
        return GTLiteMetaBlocks.TRANSPARENT_CASING.getState(BlockTransparentCasing.TransparentCasingType.QUANTUM_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.HIGH_ENERGY_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.DECAY_GENERATOR_OVERLAY;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("F      F", "F      F", "        ", "        ", "        ", "        ", "        ")
                .aisle("        ", "        ", "FXXXXXXF", "NGGGGGGP", "EGGGGGGE", "EGGGGGGE", " XXXXXX ")
                .aisle("        ", "        ", "ICCCCCCJ", "DOOOOOOD", "DOOOOOOD", "DOOOOOOD", "KCCCCCCL")
                .aisle("        ", "        ", "ICccccCJ", "DOOOOOOD", "DooooooD", "DOOOOOOD", "KCccccCL")
                .aisle("        ", "        ", "ICCCCCCJ", "DOOOOOOD", "DOOOOOOD", "DOOOOOOD", "KCCCCCCL")
                .aisle("        ", "        ", "FXXXXXXF", "MGGGGGGE", "SGGGGGGE", "EGGGGGGE", " XXXXXX ")
                .aisle("F      F", "F      F", "        ", "        ", "        ", "        ", "        ")
                .where('S', GTLiteMetaTileEntities.NANOSCALE_EUV_MASK_ALIGNER, EnumFacing.SOUTH)
                .where('C', getCasingState())
                .where('E', getCasingState())
                .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.SOUTH)
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[UV], EnumFacing.WEST)
                .where('J', MetaTileEntities.ITEM_EXPORT_BUS[UV], EnumFacing.EAST)
                .where('K', MetaTileEntities.FLUID_IMPORT_HATCH[UV], EnumFacing.WEST)
                .where('L', MetaTileEntities.FLUID_EXPORT_HATCH[UV], EnumFacing.EAST)
                .where('N', MetaTileEntities.ENERGY_INPUT_HATCH[UV], EnumFacing.NORTH)
                .where('P', MetaTileEntities.LASER_INPUT_HATCH_256[3], EnumFacing.NORTH)
                .where('X', getSecondCasingState())
                .where('D', getThirdCasingState())
                .where('O', getCoilState())
                .where('o', getBoilerCasingState())
                .where('F', getFrameState())
                .where('G', getGlassState());
        GTLiteAPI.MAP_FIELD_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .forEach(entry -> shapeInfo.add(builder.where('c', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.6"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.7"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.8"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.9"));
        tooltip.add(I18n.format("gtlitecore.machine.nanoscale_euv_mask_aligner.tooltip.10"));
    }

    public class NanoScaleEUVMaskAlignerRecipeLogic extends MultiblockRecipeLogic {

        public NanoScaleEUVMaskAlignerRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        private boolean isLaserEngraverMode() {
            return this.getRecipeMap() == RecipeMaps.LASER_ENGRAVER_RECIPES;
        }

        public int getMaxParallel(int casingTier) {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            return tier * (casingTier * 64);
        }

        @Override
        public int getParallelLimit() {

            if (isLaserEngraverMode()) {
                return Math.min(getMaxParallel(casingTier), 16384);
            } else {
                return Math.min(getMaxParallel(casingTier), 4096);
            }
        }

        @Override
        public void setMaxProgress(int maxProgress) {

            if (isLaserEngraverMode()) {
                int MaxProgress = (int) Math.floor(maxProgress * Math.pow(0.5, casingTier));
                super.setMaxProgress(MaxProgress);
            }
        }

    }

}