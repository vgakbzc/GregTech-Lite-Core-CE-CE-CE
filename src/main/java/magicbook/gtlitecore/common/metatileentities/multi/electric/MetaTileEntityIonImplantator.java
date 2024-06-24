package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetaTileEntityIonImplantator extends RecipeMapMultiblockController {

    public MetaTileEntityIonImplantator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.ION_IMPLANTATOR_RECIPES);
        this.recipeMapWorkable = new MultiblockRecipeLogic(this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityIonImplantator(metaTileEntityId);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("  CCC        ", "  CCC        ", "  CUC        ", "  CCC        ", "  CCC        ", "  CUC        ", "  CCC        ", "             ", "             ", "             ", "             ", "             ")
                .aisle(" CCCCC       ", " F   F       ", " F   F   ccc ", " F   F   cgc ", " F   F   cgc ", " F   F   ccc ", " F   F       ", " CCCCC       ", "             ", "             ", "             ", "             ")
                .aisle("CCCCCCC      ", "C fsf C  ccc ", "C     C c   c", "C     C c   c", "C     C c   c", "C     C c   c", "C     C  ccc ", " CCPCC       ", "  FPF        ", "  FPF        ", "  FPF        ", "  CCC        ")
                .aisle("CCCCCCC   c  ", "C sGs C  c c ", "U     U c   c", "C     PPP   c", "C     PPP   c", "U     U c   c", "C     C  c c ", " CP PC    c  ", "  P P        ", "  P P        ", "  P P        ", "  CCC        ")
                .aisle("CCCCCCC      ", "C fsf C  ccc ", "C     C c   c", "C     C c   c", "C     C c   c", "C     C c   c", "C     C  ccc ", " CCPCC       ", "  FPF        ", "  FPF        ", "  FPF        ", "  CCC        ")
                .aisle(" CCCCC       ", " F   F       ", " F   F   ccc ", " F   F   cgc ", " F   F   cgc ", " F   F   ccc ", " F   F       ", " CCCCC       ", "             ", "             ", "             ", "             ")
                .aisle("  CCC        ", "  CCC        ", "  CCC        ", "  CSC        ", "  CCC        ", "  CCC        ", "  CCC        ", "             ", "             ", "             ", "             ", "             ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(110)
                        .or(autoAbilities(true, true, true, true, true, false, false)))
                .where('c', states(getSecondCasingState()))
                .where('f', states(getThirdCasingState()))
                .where('s', states(getFourthCasingState()))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where('U', states(getUniqueCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('g', states(getSecondGlassState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_SUBSTRATE_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    private static IBlockState getSecondGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.NaquadahAlloy).getBlock(Materials.NaquadahAlloy);
    }

    private IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.ENGRAVER_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.LASER_ENGRAVER_OVERLAY;
    }

    @Override
    public void addInformation(@NotNull ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }
}
