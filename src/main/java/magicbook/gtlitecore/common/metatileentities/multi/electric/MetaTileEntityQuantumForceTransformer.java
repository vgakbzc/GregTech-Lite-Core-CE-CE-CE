package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.recipe.properties.FieldCasingTierProperty;
import magicbook.gtlitecore.api.utils.GTLiteUtils;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockScienceCasing;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.UHV;

public class MetaTileEntityQuantumForceTransformer extends RecipeMapMultiblockController {

    private int casingTier;

    public MetaTileEntityQuantumForceTransformer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.QUANTUM_FORCE_TRANSFORMER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQuantumForceTransformer(metaTileEntityId);
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
    public boolean checkRecipe(@Nonnull Recipe recipe,
                               boolean consumeIfSuccess) {
        return super.checkRecipe(recipe, consumeIfSuccess) && recipe.getProperty(FieldCasingTierProperty.getInstance(), 0) <= casingTier;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("    D     D    ", "    D     D    ", "    D     D    ", "   DA     AD   ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "   DDDDGDDDD   ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", "  D         D  ", "  D         D  ", "  B         B  ", "  DFFFFFFFFFD  ", "   DDDFFFDDD   ", "      DGD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", " D           D ", " D           D ", " B           B ", " DFF       FFD ", "  DD       DD  ", "    DD   DD    ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("D             D", "D             D", "D             D", "D             D", "D             D", "B             B", "DFF         FFD", " DD         DD ", "   DD     DD   ", "     DFFFD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("      HHH      ", "      EEE      ", "      EEE      ", "      EEE      ", "A     DDD     A", "D     EEE     D", "DF    DDD    FD", " D    EEE    D ", "  DD  EEE  DD  ", "    DFEEEFD    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "A    D   D    A", "D    ECCCE    D", "DF   D   D   FD", " D   ECCCE   D ", "  D  ECCCE  D  ", "   BFECCCEFD   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "D   EC   CE   D", "A   EC   CE   A", "D   D     D   D", "D   EC   CE   D", "DF  D     D  FD", "DF  EC   CE  FD", " D  EC   CE  D ", "  DFEC   CEFD  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "D   D     D   D", "D   EC   CE   D", "GF  D     D  FG", "AF  EC   CE  FA", " G  EC   CE  G ", "  AFEC   CEFA  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "A   EC   CE   A", "D   D     D   D", "D   EC   CE   D", "DF  D     D  FD", "DF  EC   CE  FD", " D  EC   CE  D ", "  DFEC   CEFD  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "A    D   D    A", "D    ECCCE    D", "DF   D   D   FD", " D   ECCCE   D ", "  D  ECCCE  D  ", "   DFECCCEFD   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                .aisle("      HSH      ", "      EEE      ", "      EEE      ", "      EEE      ", "A     DDD     A", "D     EEE     D", "DF    DDD    FD", " D    EEE    D ", "  DD  EEE  DD  ", "    DFEEEFD    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                .aisle("D             D", "D             D", "D             D", "D             D", "D             D", "B             B", "DFF         FFD", " DD         DD ", "   DD     DD   ", "     DFFFD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", " D           D ", " D           D ", " B           B ", " DFF       FFD ", "  DD       DD  ", "    DD   DD    ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", "  D         D  ", "  D         D  ", "  B         B  ", "  DFFFFFFFFFD  ", "   DDDFFFDDD   ", "      DGD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("    D     D    ", "    D     D    ", "    D     D    ", "   DA     AD   ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "   DDDDGDDDD   ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .where('S', this.selfPredicate())
                .where('A', GTLiteTraceabilityPredicate.FIELD_CASING.get())
                .where('B', states(getSecondCasingState()))
                .where('C', states(getCoilState()))
                .where('D', states(getCasingState()))
                .where('E', states(getGlassState()))
                .where('F', states(getThirdCasingState()))
                .where('G', states(getFourthCasingState()))
                .where('H', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(autoAbilities()))
                .build();

    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.ULTIMATE_HIGH_ENERGY_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.DIMENSIONAL_BRIDGE_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.HOLLOW_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return GTLiteMetaBlocks.SCIENCE_CASING.getState(BlockScienceCasing.ScienceCasingType.SPACETIME_CASING);
    }

    private static IBlockState getCoilState() {
        return GTLiteMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL);
    }

    private static IBlockState getGlassState() {
        return GTLiteMetaBlocks.TRANSPARENT_CASING.getState(BlockTransparentCasing.TransparentCasingType.QUANTUM_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.QUANTUM_FORCE_TRANSFORMER_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.ULTIMATE_HIGH_ENERGY_CASING;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("    D     D    ", "    D     D    ", "    D     D    ", "   DA     AD   ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "   DDDDGDDDD   ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", "  D         D  ", "  D         D  ", "  B         B  ", "  DFFFFFFFFFD  ", "   DDDFFFDDD   ", "      DGD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", " D           D ", " D           D ", " B           B ", " DFF       FFD ", "  DD       DD  ", "    DD   DD    ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("D             D", "D             D", "D             D", "D             D", "D             D", "B             B", "DFF         FFD", " DD         DD ", "   DD     DD   ", "     DFFFD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("      MWW      ", "      EEE      ", "      EEE      ", "      EEE      ", "A     DDD     A", "D     EEE     D", "DF    DDD    FD", " D    EEE    D ", "  DD  EEE  DD  ", "    DFEEEFD    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                    .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "A    D   D    A", "D    ECCCE    D", "DF   D   D   FD", " D   ECCCE   D ", "  D  ECCCE  D  ", "   BFECCCEFD   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                    .aisle("    HHHHHHH    ", "    EC   CE    ", "D   EC   CE   D", "A   EC   CE   A", "D   D     D   D", "D   EC   CE   D", "DF  D     D  FD", "DF  EC   CE  FD", " D  EC   CE  D ", "  DFEC   CEFD  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                    .aisle("    UHHHHHV    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "D   D     D   D", "D   EC   CE   D", "GF  D     D  FG", "AF  EC   CE  FA", " G  EC   CE  G ", "  AFEC   CEFA  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                    .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "A   EC   CE   A", "D   D     D   D", "D   EC   CE   D", "DF  D     D  FD", "DF  EC   CE  FD", " D  EC   CE  D ", "  DFEC   CEFD  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                    .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "A    D   D    A", "D    ECCCE    D", "DF   D   D   FD", " D   ECCCE   D ", "  D  ECCCE  D  ", "   DFECCCEFD   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                    .aisle("      XSY      ", "      EEE      ", "      EEE      ", "      EEE      ", "A     DDD     A", "D     EEE     D", "DF    DDD    FD", " D    EEE    D ", "  DD  EEE  DD  ", "    DFEEEFD    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                    .aisle("D             D", "D             D", "D             D", "D             D", "D             D", "B             B", "DFF         FFD", " DD         DD ", "   DD     DD   ", "     DFFFD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", " D           D ", " D           D ", " B           B ", " DFF       FFD ", "  DD       DD  ", "    DD   DD    ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", "  D         D  ", "  D         D  ", "  B         B  ", "  DFFFFFFFFFD  ", "   DDDFFFDDD   ", "      DGD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("    D     D    ", "    D     D    ", "    D     D    ", "   DA     AD   ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "   DDDDGDDDD   ", "      DAD      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .where('S', GTLiteMetaTileEntities.QUANTUM_FORCE_TRANSFORMER, EnumFacing.SOUTH)
                    .where('B', getSecondCasingState())
                    .where('C', getCoilState())
                    .where('D', getCasingState())
                    .where('E', getGlassState())
                    .where('F', getThirdCasingState())
                    .where('G', getFourthCasingState())
                    .where('H', getCasingState())
                    .where('X', MetaTileEntities.ITEM_IMPORT_BUS[UHV], EnumFacing.SOUTH)
                    .where('Y', MetaTileEntities.ITEM_EXPORT_BUS[UHV], EnumFacing.SOUTH)
                    .where('U', MetaTileEntities.FLUID_IMPORT_HATCH[UHV], EnumFacing.WEST)
                    .where('V', MetaTileEntities.FLUID_EXPORT_HATCH[UHV], EnumFacing.EAST)
                    .where('W', MetaTileEntities.ENERGY_INPUT_HATCH[UHV], EnumFacing.NORTH)
                    .where('M', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                    .where(' ', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        GTLiteAPI.MAP_FIELD_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .forEach(entry -> {
                    if (finalBuilder != null) {
                        shapeInfo.add(finalBuilder.where('A', entry.getKey()).build());
                    }
                });
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @Nonnull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.quantum_force_transformer.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.quantum_force_transformer.tooltip.2"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}