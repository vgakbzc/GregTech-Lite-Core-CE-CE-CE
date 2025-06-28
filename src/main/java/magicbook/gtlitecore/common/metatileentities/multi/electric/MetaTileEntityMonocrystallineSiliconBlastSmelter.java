package magicbook.gtlitecore.common.metatileentities.multi.electric;

import gregtech.api.GTValues;
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
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps;
import magicbook.gtlitecore.api.utils.GTLiteUtility;
import magicbook.gtlitecore.client.renderer.texture.GTLiteTextures;
import magicbook.gtlitecore.common.blocks.BlockBoilerCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MetaTileEntityMonocrystallineSiliconBlastSmelter extends RecipeMapMultiblockController implements IHeatingCoil {

    private int temperature;

    public MetaTileEntityMonocrystallineSiliconBlastSmelter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTLiteRecipeMaps.MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES);
        this.recipeMapWorkable = new HeatingCoilRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMonocrystallineSiliconBlastSmelter(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats)
            this.temperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
        else
            this.temperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
        this.temperature += 400 * Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.temperature = 0;
    }

    @Override
    public boolean checkRecipe(@NotNull Recipe recipe,
                               boolean consumeIfSuccess) {
        return this.temperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @NotNull @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" AAA ", " CCC ", " CCC ", " CCC ", " CCC ", " AAA ")
                .aisle("AAAAA", "CDDDC", "CDDDC", "CDDDC", "CDDDC", "ADDDA")
                .aisle("AAAAA", "CDADC", "CDADC", "CDADC", "CDADC", "ADEDA")
                .aisle("AAAAA", "CDDDC", "CDDDC", "CDDDC", "CDDDC", "ADDDA")
                .aisle(" ASA ", " CCC ", " CCC ", " CCC ", " CCC ", " AAA ")
                .where('S', this.selfPredicate())
                .where('A', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF))
                        .setMinGlobalLimited(9)
                        .or(autoAbilities(true, true, true, true, true, true, false))
                )
                .where('C', heatingCoils())
                .where('D', states(GTLiteMetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BERYLLIUM_SCANDIUM_OXIDE)))
                .where('E', abilities(MultiblockAbility.MUFFLER_HATCH))
                .build();

    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.HEAT_PROOF_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    public ICubeRenderer getFrontOverlay() {
        return GTLiteTextures.CRYSTALLIZATION_CRUCIBLE_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature",
                    TextFormatting.RED + GTLiteUtility.formatNumbers(temperature) + "K"));
        }
        super.addDisplayText(textList);
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
        return this.temperature;
    }

}
