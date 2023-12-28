package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
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

public class MetaTileEntityAmazonWarehousingDepot extends RecipeMapMultiblockController {

    public MetaTileEntityAmazonWarehousingDepot(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.PACKER_RECIPES);
        this.recipeMapWorkable = new WarehousingDepotRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityAmazonWarehousingDepot(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC")
                .aisle("CCC", "CGC", "CCC")
                .aisle("CCC", "CSC", "CCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(16)
                        .or(autoAbilities()))
                .where('G', states(getSecondCasingState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.AUSTENITIC_STAINLESS_STEEL_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.AUSTENITIC_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.PACKER_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.amazon_warehousing_depot.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.amazon_warehousing_depot.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.amazon_warehousing_depot.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.amazon_warehousing_depot.tooltip.4"));
    }

    private class WarehousingDepotRecipeLogic extends MultiblockRecipeLogic {

        public WarehousingDepotRecipeLogic(MetaTileEntityAmazonWarehousingDepot tileEntity) {
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
