package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static gregtech.api.GTValues.EV;

public class MetaTileEntityElectrolyticTank extends RecipeMapMultiblockController {

    public MetaTileEntityElectrolyticTank(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.ELECTROLYZER_RECIPES);
        this.recipeMapWorkable = new ElectrolyticTankRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityElectrolyticTank(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("          ", "   DDDD   ", "   DDDD   ", "          ")
                .aisle("F FCCCCF F", "CCCUUUUEEE", "CCCUUUUEEE", "CCC    CCC")
                .aisle("   CCCC   ", "CCCUUUUCCC", "V#PUUUUP#V", "CMC    CMC")
                .aisle("F FCCCCF F", "CCCUUUUEEE", "CSCUUUUEEE", "CCC    CCC")
                .aisle("          ", "   DDDD   ", "   DDDD   ", "          ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .or(abilities(MultiblockAbility.INPUT_ENERGY)
                                .setMaxGlobalLimited(3)
                                .setPreviewCount(2))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)
                                .setExactLimit(1)))
                .where('D', states(getCasingState())
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS)
                                .setPreviewCount(8))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)
                                .setPreviewCount(8)))
                .where('E', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS)
                                .setPreviewCount(6))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)
                                .setPreviewCount(6)))
                .where('F', states(getFrameState()))
                .where('U', states(getUniqueCasingState()))
                .where('V', states(getSecondUniqueCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.ELECTROLYTIC_CELL);
    }

    private static IBlockState getSecondUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.NONCONDUCTING_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.ELECTROLYZER_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.electrolytic_tank.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.electrolytic_tank.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.electrolytic_tank.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.electrolytic_tank.tooltip.4"));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class ElectrolyticTankRecipeLogic extends MultiblockRecipeLogic {
        public ElectrolyticTankRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        private int ParallelTier(int tier) {
            if (tier - EV <= 0) {
                return 64;
            } else {
                return 64 * (tier - EV);
            }
        }

        /**
         * @return Parallel = 64 * (tier - EV), i.e. IV 64, LuV 128, ZPM, 256, UV, 512, UHV, 1024,...
         * Max Parallel: 4096
         */
        @Override
        public int getParallelLimit() {
            int tier = GTUtility.getTierByVoltage(getMaxVoltage());
            return Math.min(ParallelTier(tier), 4096);
        }
    }
}