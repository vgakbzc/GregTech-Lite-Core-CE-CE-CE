package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtechfoodoption.block.GTFOGlassCasing;
import gregtechfoodoption.block.GTFOMetaBlocks;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.IV;

public class MetaTileEntityExtremeIndustrialGreenhouse extends RecipeMapMultiblockController {

    public MetaTileEntityExtremeIndustrialGreenhouse(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTFORecipeMaps.GREENHOUSE_RECIPES);
        this.recipeMapWorkable = new ExtremeIndustrialGreenhouseRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityExtremeIndustrialGreenhouse(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CCCCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                .aisle("CCCCC", "CCSCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(60)
                        .or(autoAbilities()))
                .where('B', states(getSecondCasingState())
                        .or(states(getAnotherSecondCasingState())))
                .where('G', states(getGlassState()))
                .where('P', states(getBoilerCasingState()))
                .where('D', states(getThirdCasingState()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    private static IBlockState getSecondCasingState() {
        return Blocks.DIRT.getDefaultState();
    }

    private static IBlockState getAnotherSecondCasingState() {
        return Blocks.GRASS.getDefaultState();
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    private static IBlockState getGlassState() {
        return GTFOMetaBlocks.GTFO_GLASS_CASING.getState(GTFOGlassCasing.CasingType.GREENHOUSE_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.5"));
        tooltip.add(I18n.format("gtlitecore.machine.extreme_industrial_greenhouse.tooltip.6"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
        MultiblockShapeInfo.Builder baseBuilder = null;
        if (Blocks.AIR != null) {
            baseBuilder = MultiblockShapeInfo.builder()
                    .aisle("EECCC", "CCCCC", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                    .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                    .aisle("CCCCC", "CBBBC", "G###G", "G###G", "CPPPC", "CDDDC")
                    .aisle("CCMCC", "IJSKL", "GGGGG", "GGGGG", "CCCCC", "CCCCC")
                    .where('S', GTLiteMetaTileEntities.EXTREME_INDUSTRIAL_GREENHOUSE, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('B', getSecondCasingState())
                    .where('G', getGlassState())
                    .where('P', getBoilerCasingState())
                    .where('D', getThirdCasingState())
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[HV], EnumFacing.SOUTH)
                    .where('J', MetaTileEntities.FLUID_IMPORT_HATCH[HV], EnumFacing.SOUTH)
                    .where('K', MetaTileEntities.ITEM_EXPORT_BUS[HV], EnumFacing.SOUTH)
                    .where('L', MetaTileEntities.FLUID_EXPORT_HATCH[HV], EnumFacing.SOUTH)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[HV], EnumFacing.NORTH)
                    .where('M', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.SOUTH)
                    .where('#', Blocks.AIR.getDefaultState());
        }
        if (baseBuilder != null) {
            shapeInfos.add(baseBuilder.shallowCopy().where('B', getAnotherSecondCasingState()).build());
            shapeInfos.add(baseBuilder.build());
        }
        return shapeInfos;
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class ExtremeIndustrialGreenhouseRecipeLogic extends MultiblockRecipeLogic {

        public ExtremeIndustrialGreenhouseRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity, true);
        }

        /**
         * @return If machine's voltage less than or equal IV, then return 64 parallel.
         *         If machine's voltage greater than IV, then return 256 parallel.
         */
        @Override
        public int getParallelLimit() {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            if (tier < IV) {
                return 64;
            } else {
                return 256;
            }

        }

        /**
         * @param maxProgress If machine's voltage greater than IV, then get 1/2 progress time.
         */
        @Override
        public void setMaxProgress(int maxProgress) {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            if (tier > IV) {
                this.maxProgressTime = maxProgress / 2;
            } else {
                this.maxProgressTime = maxProgress;
            }
        }

    }
}
