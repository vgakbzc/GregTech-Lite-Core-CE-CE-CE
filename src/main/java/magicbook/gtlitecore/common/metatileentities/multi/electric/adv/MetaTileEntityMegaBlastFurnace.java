package magicbook.gtlitecore.common.metatileentities.multi.electric.adv;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.IMufflerHatch;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static gregtech.api.GTValues.UV;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.formatNumbers;

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

    /**
     * Structure of Mega Blast Furnace (MBF).
     *
     * <p>
     *     This Structure is from Gregicality Legacy (I just tweak some block and little structure).
     * </p>
     *
     * @return Total Structure of MBF.
     */
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     CCCCC     ", "     CCGCC     ", "     CCCCC     ", "     CCPCC     ", "       P       ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("   CCCcccCCC   ", "   CGCCRCCGC   ", "   CCCCPCCCC   ", "   CPCCPCCPC   ", "    PPPPPPP    ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("  CCccCcCccCC  ", "  GCR#C#C#RCG  ", "  CCP#C#C#PCC  ", "  PCPCCCCCPCP  ", "  PPP#####PPP  ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle(" CCCccCcCccCCC ", " CCC##C#C##CCC ", " CCC##C#C##CCC ", " CCCCCCCCCCCCC ", "  P#########P  ", " FF#########FF ", "      DDD      ", "       D       ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ")
                .aisle(" CccCccCccCccC ", " CR#C##C##C#RC ", " CP#C##C##C#PC ", " PPCCCCCCCCCPP ", " PP####D####PP ", " FF####D####FF ", "    DDDDDDD    ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "    DDDDDDD    ")
                .aisle("CCcccCcCcCcccCC", "CC###C#C#C###CC", "CC###C#C#C###CC", "CCCCCCCCCCCCCCC", " P###D###D###P ", " FF##D###D##FF ", "    DDDDDDD    ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "    DDDDDDD    ")
                .aisle("CcCCccCCCccCCcC", "C#CC##CCC##CC#C", "C#CC##CCC##CC#C", "CCCCCCCCCCCCCCC", " P###########P ", " FF#########CC ", "   DDDDDDDDD   ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "   DDDDDDDDD   ")
                .aisle("CcccCCCXCCCcccC", "GR##CCCXCCC##RG", "CP##CCCXCCC##PC", "PPCCCCCXCCCCCPP", "PP##D##X##D##PP", " FF#D##X##D#CP ", "   DDDDDDDDD P ", "   DfL###LPPPP ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "   DDDDMPPPD   ")
                .aisle("CcCCccCCCccCCcC", "C#CC##CCC##CC#C", "C#CC##CCC##CC#C", "CCCCCCCCCCCCCCC", " P###########P ", " FF#########CC ", "   DDDDDDDDD   ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "   DDDDDDDDD   ")
                .aisle("CCcccCcCcCcccCC", "CC###C#C#C###CC", "CC###C#C#C###CC", "CCCCCCCCCCCCCCC", " P###D###D###P ", " FF##D###D##FF ", "    DDDDDDD    ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "    DDDDDDD    ")
                .aisle(" CccCccCccCccC ", " CR#C##C##C#RC ", " CP#C##C##C#PC ", " PPCCCCCCCCCPP ", " PP####D####PP ", " FF####D####FF ", "    DDDDDDD    ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "    DDDDDDD    ")
                .aisle(" CCCccCPCccCCC ", " CCC##CPC##CCC ", " CCC##CPC##CCC ", " CCCCCCPCCCCCC ", "  P###PP####P  ", " FF#########FF ", "      DDD      ", "       D       ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ")
                .aisle("  CCccCGCccCC  ", "  GCR#CGC#RCG  ", "  CCP#CGC#PCC  ", "  PCPCCGCCPCP  ", "  PPPPPP#PPPP  ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle(" F CCCCGCCCC   ", " F CGCCGCCGC   ", " F CCCCGCCCC   ", " F CPCCGCCPC   ", " F  PP   PP    ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("     CCSCC     ", "     CCGCC     ", "     CCGCC     ", "     CCGCC     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .where('S', this.selfPredicate())
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(400)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('c', states(getSecondCasingState()))
                .where('X', states(getThirdCasingState()))
                .where('D', states(getFourthCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('R', states(getSecondBoilerCasingState()))
                .where('F', states(getFrameState()))
                .where('f', states(getSecondFrameState()))
                .where('G', states(getGlassState()))
                .where('L', heatingCoils())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH)
                        .setExactLimit(1)
                        .setPreviewCount(1))
                .where('#', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS);
    }

    private static IBlockState getThirdCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING);
    }

    private static IBlockState getFourthCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getSecondBoilerCasingState() {
        return MetaBlocks.BOILER_FIREBOX_CASING.getState(BlockFireboxCasing.FireboxCasingType.TUNGSTENSTEEL_FIREBOX);
    }

    private static IBlockState getGlassState() {
        return GTLiteMetaBlocks.TRANSPARENT_CASING.getState(BlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.BlackSteel).getBlock(Materials.BlackSteel);
    }

    private static IBlockState getSecondFrameState() {
        return MetaBlocks.FRAMES.get(GTLiteMaterials.SiliconCarbide).getBlock(GTLiteMaterials.SiliconCarbide);
    }


    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("     CemeC     ", "     CCGCC     ", "     CCCCC     ", "     CCPCC     ", "       P       ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("   CCCcccCCC   ", "   CGCCRCCGC   ", "   CCCCPCCCC   ", "   CPCCPCCPC   ", "    PPPPPPP    ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("  CCccCcCccCC  ", "  GCR#C#C#RCG  ", "  CCP#C#C#PCC  ", "  PCPCCCCCPCP  ", "  PPP#####PPP  ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle(" CCCccCcCccCCC ", " CCC##C#C##CCC ", " CCC##C#C##CCC ", " CCCCCCCCCCCCC ", "  P#########P  ", " FF#########FF ", "      DDD      ", "       D       ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ")
                    .aisle(" CccCccCccCccC ", " CR#C##C##C#RC ", " CP#C##C##C#PC ", " PPCCCCCCCCCPP ", " PP####D####PP ", " FF####D####FF ", "    DDDDDDD    ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "    DDDDDDD    ")
                    .aisle("CCcccCcCcCcccCC", "CC###C#C#C###CC", "CC###C#C#C###CC", "CCCCCCCCCCCCCCC", " P###D###D###P ", " FF##D###D##FF ", "    DDDDDDD    ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "    DDDDDDD    ")
                    .aisle("CcCCccCCCccCCcC", "C#CC##CCC##CC#C", "C#CC##CCC##CC#C", "CCCCCCCCCCCCCCC", " P###########P ", " FF#########CC ", "   DDDDDDDDD   ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "   DDDDDDDDD   ")
                    .aisle("CcccCCCXCCCcccC", "GR##CCCXCCC##RG", "CP##CCCXCCC##PC", "PPCCCCCXCCCCCPP", "PP##D##X##D##PP", " FF#D##X##D#CP ", "   DDDDDDDDD P ", "   DfL###LPPPP ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "    fL###LP    ", "   DDDDMPPPD   ")
                    .aisle("CcCCccCCCccCCcC", "C#CC##CCC##CC#C", "C#CC##CCC##CC#C", "CCCCCCCCCCCCCCC", " P###########P ", " FF#########CC ", "   DDDDDDDDD   ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "     L###L     ", "   DDDDDDDDD   ")
                    .aisle("CCcccCcCcCcccCC", "CC###C#C#C###CC", "CC###C#C#C###CC", "CCCCCCCCCCCCCCC", " P###D###D###P ", " FF##D###D##FF ", "    DDDDDDD    ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "     LLLLL     ", "    DDDDDDD    ")
                    .aisle(" CccCccCccCccC ", " CR#C##C##C#RC ", " CP#C##C##C#PC ", " PPCCCCCCCCCPP ", " PP####D####PP ", " FF####D####FF ", "    DDDDDDD    ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "       f       ", "    DDDDDDD    ")
                    .aisle(" CCCccCPCccCCC ", " CCC##CPC##CCC ", " CCC##CPC##CCC ", " CCCCCCPCCCCCC ", "  P###PP####P  ", " FF#########FF ", "      DDD      ", "       D       ", "               ", "               ", "               ", "               ", "               ", "               ", "      DDD      ")
                    .aisle("  CCccCGCccCC  ", "  GCR#CGC#RCG  ", "  CCP#CGC#PCC  ", "  PCPCCGCCPCP  ", "  PPPPPP#PPPP  ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle(" F CCCCGCCCC   ", " F CGCCGCCGC   ", " F CCCCGCCCC   ", " F CPCCGCCPC   ", " F  PP   PP    ", " FFFFFFFFFFFFF ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("     ijSkl     ", "     CCGCC     ", "     CCGCC     ", "     CCGCC     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .where('S', GTLiteMetaTileEntities.MEGA_BLAST_FURNACE, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('c', getSecondCasingState())
                    .where('X', getThirdCasingState())
                    .where('D', getFourthCasingState())
                    .where('P', getBoilerCasingState())
                    .where('R', getSecondBoilerCasingState())
                    .where('F', getFrameState())
                    .where('f', getSecondFrameState())
                    .where('G', getGlassState())
                    .where('M', MetaTileEntities.MUFFLER_HATCH[UV], EnumFacing.UP)
                    .where('i', MetaTileEntities.ITEM_IMPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('j', MetaTileEntities.ITEM_EXPORT_BUS_ME, EnumFacing.SOUTH)
                    .where('k', MetaTileEntities.FLUID_IMPORT_HATCH_ME, EnumFacing.SOUTH)
                    .where('l', MetaTileEntities.FLUID_EXPORT_HATCH_ME, EnumFacing.SOUTH)
                    .where('e', GTLiteMetaTileEntities.WIRELESS_INPUT_ENERGY_HATCH[UV], EnumFacing.NORTH)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('m', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH);
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> {
                    if (finalBuilder != null) {
                        shapeInfo.add(finalBuilder.where('L', entry.getKey()).build());
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
        if (iMultiblockPart instanceof IMufflerHatch) {
            return Textures.ROBUST_TUNGSTENSTEEL_CASING;
        } else {
            return Textures.HEAT_PROOF_CASING;
        }
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

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockDisplayText.builder(textList, this.isStructureFormed())
                .setWorkingStatus(this.recipeMapWorkable.isWorkingEnabled(), this.recipeMapWorkable.isActive())
                .addEnergyUsageLine(this.getEnergyContainer())
                .addEnergyTierLine(GTUtility.getTierByVoltage(this.recipeMapWorkable.getMaxVoltage()))
                .addCustom((tl) -> {
                    if (this.isStructureFormed()) {
                        ITextComponent heatString = TextComponentUtil.stringWithColor(TextFormatting.RED,
                                formatNumbers(this.blastFurnaceTemperature) + "K");
                        tl.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.blast_furnace.max_temperature", heatString));
                    }})
                .addParallelsLine(this.recipeMapWorkable.getParallelLimit())
                .addWorkingStatusLine()
                .addProgressLine(this.recipeMapWorkable.getProgressPercent());
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
