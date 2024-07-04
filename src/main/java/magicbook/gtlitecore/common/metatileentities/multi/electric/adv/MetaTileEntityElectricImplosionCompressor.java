package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.block.impl.WrappedIntTier;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtility;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.BlockMachineCasing;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.UV;
import static magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate.implosionCoils;

public class MetaTileEntityElectricImplosionCompressor extends RecipeMapMultiblockController {

    private int tier;

    public MetaTileEntityElectricImplosionCompressor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.ELECTRIC_IMPLOSION_RECIPES);
        this.recipeMapWorkable = new ElectricImplosionRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityElectricImplosionCompressor(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("ImplosionCoilTieredStats");
        this.tier = GTLiteUtility.getOrDefault(() -> type instanceof WrappedIntTier,
                () -> ((WrappedIntTier) type).getIntTier(), 0);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.tier = 0;
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCC", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "CCCCCCC")
                .aisle("CCCCCCC", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", "CCCCCCC")
                .aisle("CCCCCCC", " GIIIG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GIIIG ", "CCCCCCC")
                .aisle("CCCCCCC", " GI#IG ", " G###G ", " G###G ", " G###G ", " G###G ", " G###G ", " G###G ", " GI#IG ", "CCCMCCC")
                .aisle("CCCCCCC", " GIIIG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GIIIG ", "CCCCCCC")
                .aisle("CCCCCCC", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", "CCCCCCC")
                .aisle("CCCSCCC", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "CCCCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(80)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('P', states(getBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('G', states(getGlassState()))
                .where('I', implosionCoils())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH)
                        .setExactLimit(1))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTLiteMetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LAWRENCIUM_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.LAFIUM);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Nobelium).getBlock(Materials.Nobelium);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GTLiteTextures.LAWRENCIUM_CASING;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("CCCCeem", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "CCCCCCC")
                .aisle("CCCCCCC", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", "CCCCCCC")
                .aisle("CCCCCCC", " GIIIG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GIIIG ", "CCCCCCC")
                .aisle("CCCCCCC", " GI#IG ", " G###G ", " G###G ", " G###G ", " G###G ", " G###G ", " G###G ", " GI#IG ", "CCCMCCC")
                .aisle("CCCCCCC", " GIIIG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GI#IG ", " GIIIG ", "CCCCCCC")
                .aisle("CCCCCCC", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", " PGGGP ", "CCCCCCC")
                .aisle("CCiSjCC", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "F     F", "CCCCCCC")
                .where('S', GTLiteMetaTileEntities.ELECTRIC_IMPLOSION_COMPRESSOR, EnumFacing.SOUTH)
                .where('C', getCasingState())
                .where('i', MetaTileEntities.ITEM_IMPORT_BUS[UV], EnumFacing.SOUTH)
                .where('j', MetaTileEntities.ITEM_EXPORT_BUS[UV], EnumFacing.SOUTH)
                .where('m', MetaTileEntities.AUTO_MAINTENANCE_HATCH, EnumFacing.NORTH)
                .where('e', MetaTileEntities.ENERGY_INPUT_HATCH[UV], EnumFacing.NORTH)
                .where('P', getBoilerCasingState())
                .where('F', getFrameState())
                .where('G', getGlassState())
                .where('M', MetaTileEntities.MUFFLER_HATCH[UV], EnumFacing.UP)
                .where('#', Blocks.AIR.getDefaultState());
        GTLiteAPI.MAP_IMPLOSION_COIL.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .forEach(entry -> shapeInfo.add(builder.where('I', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public void addInformation(ItemStack stack,
                               @Nullable World player,
                               @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gtlitecore.machine.electric_implosion_compressor.tooltip.1"));
        tooltip.add(I18n.format("gtlitecore.machine.electric_implosion_compressor.tooltip.2"));
        tooltip.add(I18n.format("gtlitecore.machine.electric_implosion_compressor.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.machine.electric_implosion_compressor.tooltip.4"));
        tooltip.add(I18n.format("gtlitecore.machine.electric_implosion_compressor.tooltip.5"));
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return true;
    }

    private class ElectricImplosionRecipeLogic extends MultiblockRecipeLogic {

        public ElectricImplosionRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public int getParallelLimit() {
            return (int) Math.pow(4, tier - 1);
        }
    }
}
