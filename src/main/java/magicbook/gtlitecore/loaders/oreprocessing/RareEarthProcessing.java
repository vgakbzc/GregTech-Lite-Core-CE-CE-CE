package magicbook.gtlitecore.loaders.oreprocessing;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;

/**
 * The Rare Earth Extraction Process
 *
 * <p>
 *     Produces Rare Earth Element Oxides from Rare Earth
 * </p>
 *
 * <p>Main Products: All of the REE Oxides</p>
 * <p>Side Products: None</p>
 *
 * <p>4 Rare Earth -> 1 of every REE Oxide</p>
 */
public class RareEarthProcessing {

    public static void init() {
        removeVanillaRecipes();
        DiethylhexylPhosphoricAcid();
        RareEarthProcess();
        NanoExtractingProcess();
    }

    private static void removeVanillaRecipes() {
        if (GTLiteConfigHolder.recipes.enableHarderRareEarthProcess) {
            GTRecipeHandler.removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, RareEarth));
        }
    }

    private static void DiethylhexylPhosphoricAcid() {

        //  2C4H8O + 4H -> C8H18O + H2O (lost)
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(Ethylhexanol.getFluid(1000))
                .duration(80)
                .EUt(VA[MV])
                .buildAndRegister();

        //  5C8H18O + 0.5P4O10 -> 2C16H35O4P + 2C4H10 + 2O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylhexanol.getFluid(5000))
                .input(dust, PhosphorusPentoxide, 7)
                .fluidOutputs(DiethylhexylPhosphoricAcid.getFluid(2000))
                .fluidOutputs(Butane.getFluid(2000))
                .duration(600)
                .EUt(16)
                .buildAndRegister();
    }

    private static void RareEarthProcess() {

        //  Step 1: Rare Earth -> Rare Earth Hydroxides Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, RareEarth)
                .input(dust, SodiumHydroxide, 3)
                .circuitMeta(2)
                .fluidInputs(DiethylhexylPhosphoricAcid.getFluid(100))
                .fluidInputs(Water.getFluid(900))
                .fluidOutputs(RareEarthHydroxidesSolution.getFluid(1000))
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Step 2: Rare Earth Hydroxides Solution -> Rare Earth Chlorides Solution
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthHydroxidesSolution.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, SodiumHydroxide, 3)
                .fluidOutputs(RareEarthChloridesSolution.getFluid(1000))
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();

        //  Crude Neodymium Oxide Production, can still be obtained as ore byproducts
        //  This is optional for EV Tier (Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(1)
                .output(dust, NeodymiumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(900))
                .duration(200)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Crude Cerium Oxide Production
        //  This is optional for ZPM Tier (Pu-241 Fusion)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(2)
                .output(dust, CeriumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(850))
                .duration(200)
                .EUt(3840)
                .buildAndRegister();

        //  Crude Samarium Oxide Production
        //  This is required for LuV Tier (Magnetic Samarium -> Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(3)
                .output(dust, SamariumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(800))
                .duration(200)
                .EUt(3840)
                .buildAndRegister();

        //  Crude Yttrium Oxide Production
        //  This is optional for IV Tier (Incoloy-MA956)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(4)
                .output(dust, YttriumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(750))
                .duration(200)
                .EUt(3840)
                .buildAndRegister();

        //  Crude Lanthanum Oxide Production
        //  This is required for UV Tier (Americium -> Motors)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .circuitMeta(5)
                .output(dust, LanthanumOxide)
                .fluidOutputs(HydrochloricAcid.getFluid(500))
                .duration(200)
                .EUt(15360)
                .buildAndRegister();

        //  Complete Rare Earth Process
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .output(dustSmall, Thorium)
                .fluidOutputs(LaPrNdCeOxidesSolution.getFluid(250))
                .fluidOutputs(ScEuGdSmOxidesSolution.getFluid(250))
                .fluidOutputs(YTbDyHoOxidesSolution.getFluid(250))
                .fluidOutputs(ErTmYbLuOxidesSolution.getFluid(250))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .disableDistilleryRecipes()
                .duration(200)
                .EUt(VA[UV])
                .buildAndRegister();
    }

    private static void NanoExtractingProcess() {

        //  Nano Resin Processing is an Advanced Rare Earth Processing for player which beyond ZPM tier,
        //  required Mysterious Crystal lens and Nanoscale Mask Aligner (Mega Laser Engraver) to start.
        BLAST_RECIPES.recipeBuilder()
                .input(dust, RareEarth, 8)
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, SiliconDioxide)
                .fluidOutputs(RareEarthChloridesConcentrate.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(2 * SECOND)
                .blastFurnaceTemp(1600) // Cupronickel
                .buildAndRegister();

        //  Lanthanum (La)-Praseodymium (Pr)-Neodymium (Nd)-Cerium (Ce)
        addNanoExtractingRecipe(
                Lanthanum,
                LanthanumExtractingNanoResin,
                FilledLanthanumExtractingNanoResin);

        addNanoExtractingRecipe(
                Praseodymium,
                PraseodymiumExtractingNanoResin,
                FilledPraseodymiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Neodymium,
                NeodymiumExtractingNanoResin,
                FilledNeodymiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Cerium,
                CeriumExtractingNanoResin,
                FilledCeriumExtractingNanoResin);

        //  Scandium (Sc)-Europium (Eu)-Gadolinium (Gd)-Samarium(Sm)
        addNanoExtractingRecipe(
                Scandium,
                ScandiumExtractingNanoResin,
                FilledScandiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Europium,
                EuropiumExtractingNanoResin,
                FilledEuropiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Gadolinium,
                GadoliniumExtractingNanoResin,
                FilledGadoliniumExtractingNanoResin);

        addNanoExtractingRecipe(
                Samarium,
                SamariumExtractingNanoResin,
                FilledSamariumExtractingNanoResin);

        //  Yttrium (Y)-Terbium (Tb)-Dysprosium (Dy)-Holmium (Ho)
        addNanoExtractingRecipe(
                Yttrium,
                YttriumExtractingNanoResin,
                FilledYttriumExtractingNanoResin);

        addNanoExtractingRecipe(
                Terbium,
                TerbiumExtractingNanoResin,
                FilledTerbiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Dysprosium,
                DysprosiumExtractingNanoResin,
                FilledDysprosiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Holmium,
                HolmiumExtractingNanoResin,
                FilledHolmiumExtractingNanoResin);

        //  Erbium (Er)-Thulium (Tm)-Ytterbium (Yb)-Lutetium (Lu)
        addNanoExtractingRecipe(
                Erbium,
                ErbiumExtractingNanoResin,
                FilledErbiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Thulium,
                ThuliumExtractingNanoResin,
                FilledThuliumExtractingNanoResin);

        addNanoExtractingRecipe(
                Ytterbium,
                YtterbiumExtractingNanoResin,
                FilledYtterbiumExtractingNanoResin);

        addNanoExtractingRecipe(
                Lutetium,
                LutetiumExtractingNanoResin,
                FilledLutetiumExtractingNanoResin);
    }

    private static void addNanoExtractingRecipe(Material material,
                                                Material resinMaterial,
                                                Material filledResinMaterial) {
        //  Step 1: {@code material} -> {@code resinMaterial}
        //  For example: Lanthanum -> Lanthanum Extracting Nano Resin
        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .notConsumable(lens, MysteriousCrystal)
                .input(dust, material)
                .input(swarm, Carbon)
                .fluidInputs(DiethylhexylPhosphoricAcid.getFluid(4000))
                .fluidOutputs(resinMaterial.getFluid(1000))
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Step 2: {@code resinMaterial} -> {@code filledResinMaterial}.
        //  Catalyst Liquid Decay Chain: Concentrate -> Enriched Solution -> Diluted Solution -> Waste Fluid.
        //  For example: Lanthanum Extracting Nano Resin -> Filled Lanthanum Extracting Nano Resin
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(resinMaterial.getFluid(1000))
                .fluidInputs(RareEarthChloridesConcentrate.getFluid(1000))
                .fluidOutputs(filledResinMaterial.getFluid(1000))
                .fluidOutputs(RareEarthChloridesEnrichedSolution.getFluid(1000))
                .EUt(VA[UV])
                .duration(SECOND)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(resinMaterial.getFluid(1000))
                .fluidInputs(RareEarthChloridesEnrichedSolution.getFluid(1000))
                .fluidOutputs(filledResinMaterial.getFluid(1000))
                .fluidOutputs(RareEarthChloridesDilutedSolution.getFluid(1000))
                .EUt(VA[UV])
                .duration(SECOND)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(resinMaterial.getFluid(1000))
                .fluidInputs(RareEarthChloridesDilutedSolution.getFluid(1000))
                .fluidOutputs(filledResinMaterial.getFluid(1000))
                .fluidOutputs(ChlorinatedRareEarthWasteFluid.getFluid(1000))
                .EUt(VA[UV])
                .duration(SECOND)
                .buildAndRegister();

        //  Step 3: {@code filledResinMaterial} -> {@code material} + {@code resinMaterial}.
        //  For example: Filled Lanthanum Extracting Nano Resin -> Lanthanum + Lanthanum Extracting Nano Resin
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(filledResinMaterial.getFluid(1000))
                .fluidOutputs(material.getFluid(L))
                .fluidOutputs(resinMaterial.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(3000))
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Chlorinated Rare Earth Waste Fluid recycling
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChlorinatedRareEarthWasteFluid.getFluid(10000))
                .output(dust, Chrome, 3)
                .fluidOutputs(SaltWater.getFluid(3000))
                .fluidOutputs(Phenol.getFluid(2000))
                .fluidOutputs(HydrochloricAcid.getFluid(5000))
                .EUt(VA[HV])
                .duration(15 * SECOND)
                .buildAndRegister();

    }

}