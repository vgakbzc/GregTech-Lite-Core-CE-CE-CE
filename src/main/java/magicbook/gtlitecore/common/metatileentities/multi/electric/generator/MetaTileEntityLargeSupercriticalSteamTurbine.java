package magicbook.gtlitecore.common.metatileentities.multi.electric.generator;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.metatileentity.multi.GTLiteMultiblockAbility;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockMetalCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.api.GTValues.LuV;

public class MetaTileEntityLargeSupercriticalSteamTurbine extends MetaTileEntityLargeTurbine {

    public MetaTileEntityLargeSupercriticalSteamTurbine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES, LuV);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeSupercriticalSteamTurbine(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCC", "CHHC", "CCCC")
                .aisle("CHHC", "RGGR", "CHHC")
                .aisle("CCCC", "CSHC", "CCCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()))
                .where('G', states(getSecondCasingState()))
                .where('R', metaTileEntities(MultiblockAbility.REGISTRY.get(GTLiteMultiblockAbility.REINFORCED_ROTOR_HOLDER_ABILITY).stream()
                        .filter(mte -> (mte instanceof ITieredMetaTileEntity) && (((ITieredMetaTileEntity) mte).getTier() >= tier))
                        .toArray(MetaTileEntity[]::new))
                        .addTooltips("gregtech.multiblock.pattern.clear_amount_3")
                        .addTooltip("gregtech.multiblock.pattern.error.limited.1", GTValues.VN[tier])
                        .setExactLimit(1)
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY)).setExactLimit(1))
                .where('H', states(getCasingState())
                        .or(autoAbilities(false, true, false, false, true, true, true)))
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.MAR_M200_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.MAR_M200_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.LARGE_STEAM_TURBINE_OVERLAY;
    }
}
