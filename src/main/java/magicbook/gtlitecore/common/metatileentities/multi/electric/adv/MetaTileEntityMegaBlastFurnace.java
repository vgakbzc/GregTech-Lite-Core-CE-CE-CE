package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
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

import static gregtech.api.GTValues.UV;

public class MetaTileEntityMegaBlastFurnace extends RecipeMapMultiblockController implements IHeatingCoil {

    private int blastFurnaceTemperature;
    protected static int heatingCoilLevel;
    protected int heatingCoilDiscount;

    public MetaTileEntityMegaBlastFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.BLAST_RECIPES);
        this.recipeMapWorkable = new MegaBlastFurnaceRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMegaBlastFurnace(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        Object coilType = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.blastFurnaceTemperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
            heatingCoilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
            this.heatingCoilDiscount = ((IHeatingCoilBlockStats) coilType).getEnergyDiscount();
        } else {
            this.blastFurnaceTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
            heatingCoilLevel = BlockWireCoil.CoilType.CUPRONICKEL.getLevel();
            this.heatingCoilDiscount = BlockWireCoil.CoilType.CUPRONICKEL.getEnergyDiscount();
        }

        this.blastFurnaceTemperature += 100 * Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe,
                               boolean consumeIfSuccess) {
        return this.blastFurnaceTemperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCCCCCCCCCCCC", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCMCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCCCCCCCCC", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "CCCCCCCCCCCCCCC")
                .aisle("CCCCCCCSCCCCCCC", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "CCCCCCCCCCCCCCC")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(400)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH)
                        .setExactLimit(1)
                        .setPreviewCount(1))
                .where('X', heatingCoils())
                .where('G', states(getGlassState()))
                .where('#', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("CCCCCCemeCCCCCC", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCMCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "GX###########XG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCCCCCCCCCCC", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "GXXXXXXXXXXXXXG", "CCCCCCCCCCCCCCC")
                    .aisle("CCCCCijSklCCCCC", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "GGGGGGGGGGGGGGG", "CCCCCCCCCCCCCCC")
                    .where('S', GTLiteMetaTileEntities.MEGA_BLAST_FURNACE, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('e', GTLiteMetaTileEntities.WIRELESS_INPUT_ENERGY_HATCH[UV], EnumFacing.NORTH)
                    .where('i', MetaTileEntities.ITEM_IMPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('j', MetaTileEntities.ITEM_EXPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('k', MetaTileEntities.FLUID_IMPORT_HATCH_ME, EnumFacing.SOUTH)
                    .where('l', MetaTileEntities.FLUID_EXPORT_HATCH_ME, EnumFacing.SOUTH)
                    .where('M', MetaTileEntities.MUFFLER_HATCH[UV], EnumFacing.UP)
                    .where('G', getGlassState())
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('m', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH);
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> {
                    if (finalBuilder != null) {
                        shapeInfo.add(finalBuilder.where('X', entry.getKey()).build());
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
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.1"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.2"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.3"));
        tooltip.add(I18n.format("gtlitecore.universal.tooltip.max_parallel", 1024));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.HEAT_PROOF_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.BLAST_FURNACE_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public int getCurrentTemperature() {
        return this.blastFurnaceTemperature;
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        blastFurnaceTemperature = 0;
        heatingCoilLevel = 0;
        heatingCoilDiscount = 0;
    }

    protected static class MegaBlastFurnaceRecipeLogic extends HeatingCoilRecipeLogic {

        private final MetaTileEntityMegaBlastFurnace blastFurnace;

        public MegaBlastFurnaceRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.blastFurnace = (MetaTileEntityMegaBlastFurnace) tileEntity;
        }

        @Override
        public int getParallelLimit() {
            return 1024;
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / 2;
        }
    }
}
