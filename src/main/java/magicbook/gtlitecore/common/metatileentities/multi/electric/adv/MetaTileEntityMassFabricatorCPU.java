package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

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
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockSupportCasing;
import magicbook.gtlitecore.common.blocks.BlockTransparentUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MetaTileEntityMassFabricatorCPU extends RecipeMapMultiblockController {

    public MetaTileEntityMassFabricatorCPU(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.MASS_FABRICATOR_RECIPES);
        this.recipeMapWorkable = new MassFabricatorRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMassFabricatorCPU(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CDDDC", "CDDDC", "CCCCC")
                .aisle("CXXXC", "D###D", "D###D", "CCCCC")
                .aisle("CXXXC", "D###D", "D###D", "CCMCC")
                .aisle("CXXXC", "D###D", "D###D", "CCCCC")
                .aisle("CCSCC", "CDDDC", "CDDDC", "CCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(25)
                        .or(autoAbilities(true, true, true, false, true, true, false)))
                .where('D', states(getSecondCasingState()))
                .where('X', states(getCoilState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.MASS_FABRICATOR_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.TRANSPARENT_UNIQUE_CASING.getState(BlockTransparentUniqueCasing.TransparentUniqueCasingType.MOLECULAR_CONTAINMENT_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.SUPPORT_CASING.getState(BlockSupportCasing.SupportCasingType.MASS_FABRICATOR_COIL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.MASS_FABRICATOR_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.MASS_FABRICATOR_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    public EnumParticleTypes getMufflerParticle() {
        return EnumParticleTypes.DRAGON_BREATH;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.get_parallel_by_voltage"));
        tooltip.add(I18n.format("gtlitecore.machine.mass_fabricator_cpu.tooltip.1"));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class MassFabricatorRecipeLogic extends MultiblockRecipeLogic {

        public MassFabricatorRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public int getParallelLimit() {
            return (16 * GTUtility.getTierByVoltage(getMaxVoltage()));
        }

    }
}
