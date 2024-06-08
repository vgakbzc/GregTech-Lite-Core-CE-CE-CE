package magicbook.gtlitecore.loaders.oreprocessing;

import gregtech.api.fluids.store.FluidStorageKey;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

/**
 *
 * The Taranium Production Process
 *
 * <p>
 *     Produces Taranium and Bedrock Dust from Bedrock Smoke
 * </p>
 *
 * <p>Main Products: Taranium Dust, Taranium Fuels, Bedrock Dust</p>
 * <p>Side Products: Platinum, Iridium, Osmium</p>
 *
 * <p>Credit to the <a href="https://github.com/GT-IMPACT">GT-IMPACT Modpack</a>.
 *    This processing chain was adapted from their Hyper Fuel production process</p>
 *
 * <p>Naquadah Fuel chain from Gregicality Legacy.</p>
 */
public class TaraniumProcessing {

    public static void init() {
        BedrockProcess();
        BedrockSmokeProcess();
        TaraniumGasProcess();
        EnrichedBedrockProcess();
        EnrichedBedrockSmokeProcess();
        EnrichedTaraniumGasProcess();
        FantasyMaterials();
        Fuels();
    }

    private static void FantasyMaterials() {
        OrichalcumProcess();
        AdamantiumProcess();
        VibraniumProcess();
        StoneProcess();
    }

    private static void Fuels() {
        CrudeNaquadahFuel();
        NaquadahReactorRecipes();
        FuelRefineFactoryRecipes();
        HyperReactorRecipes();
    }

    private static void BedrockProcess() {

        //  Drilling Bedrock dust and smoke in Bedrock
        DRILLING_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.BEDROCK))
                .chancedOutput(dust, Bedrock, 100, 0)
                .fluidOutputs(BedrockSmoke.getFluid(1000))
                .duration(20)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  NH3 + HNO3 -> NH4NO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, AmmoniumNitrate, 2)
                .duration(60)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Bedrock Smoke -> Bedrock Soot Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .input(dust, AmmoniumNitrate, 2)
                .fluidInputs(BedrockSmoke.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(BedrockSootSolution.getFluid(1000))
                .duration(600)
                .EUt(1024)
                .buildAndRegister();

        //  Bedrock Soot Solution -> Clean Bedrock Solution (+ Pt, Ir, Nq)
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockSootSolution.getFluid(2000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Iridium, 3, 1000, 0)
                .chancedOutput(dust, Naquadah, 1000, 0)
                .fluidOutputs(CleanBedrockSolution.getFluid(1000))
                .duration(600)
                .EUt(4096)
                .buildAndRegister();

        //  Clean Bedrock Solution -> Bedrock + Bedrock Smokes
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumBedrockSmoke.getFluid(320))
                .fluidOutputs(LightBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(90)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void BedrockSmokeProcess() {

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 3)
                .fluidOutputs(HeavyTaraniumGas.getFluid(1000))
                .duration(200)
                .EUt(VA[LuV])
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock, 2)
                .fluidOutputs(MediumTaraniumGas.getFluid(1000))
                .duration(140)
                .EUt(VA[LuV])
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .output(dust, Bedrock)
                .fluidOutputs(LightTaraniumGas.getFluid(1000))
                .duration(90)
                .EUt(VA[LuV])
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UltralightBedrockSmoke.getFluid(2000))
                .output(dust, Iridium)
                .chancedOutput(dust, Bedrock, 5000, 0)
                .fluidOutputs(BedrockGas.getFluid(1000))
                .duration(50)
                .EUt(VA[LuV])
                .buildAndRegister();
    }

    private static void TaraniumGasProcess() {

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(6000))
                .fluidInputs(HeavyTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyTaranium.getFluid(2000))
                .duration(300)
                .EUt(9216)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(4000))
                .fluidInputs(MediumTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumTaranium.getFluid(1600))
                .duration(250)
                .EUt(9216)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidInputs(LightTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightTaranium.getFluid(1200))
                .duration(200)
                .EUt(9216)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(250))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumTaraniumFuel.getFluid(200))
                .fluidOutputs(LightTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(160)
                .EUt(16384)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(150))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumTaraniumFuel.getFluid(400))
                .fluidOutputs(LightTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(140)
                .EUt(16384)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightTaranium.getFluid(1000))
                .output(dust, Taranium)
                .fluidOutputs(Fluorine.getFluid(50))
                .fluidOutputs(HeavyTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumTaraniumFuel.getFluid(150))
                .fluidOutputs(LightTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(120)
                .EUt(16384)
                .buildAndRegister();
    }

    private static void EnrichedBedrockProcess() {

        //  Bedrock Gas -> Enriched Bedrock Soot Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(SulfuricAcid.getFluid(900))
                .fluidInputs(BedrockGas.getFluid(100))
                .fluidOutputs(EnrichedBedrockSootSolution.getFluid(1000))
                .duration(200)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Enriched Bedrock Soot Solution -> Clean Enriched Bedrock Solution
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedBedrockSootSolution.getFluid(2000))
                .chancedOutput(dust, Platinum, 5, 1000, 0)
                .chancedOutput(dust, Osmium, 3, 1000, 0)
                .chancedOutput(dust, NaquadahEnriched, 1000, 0)
                .fluidOutputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .duration(300)
                .EUt(98304)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CleanEnrichedBedrockSolution.getFluid(1000))
                .output(dust, Bedrock, 4)
                .fluidOutputs(HeavyEnrichedBedrockSmoke.getFluid(440))
                .fluidOutputs(MediumEnrichedBedrockSmoke.getFluid(320))
                .fluidOutputs(LightEnrichedBedrockSmoke.getFluid(180))
                .fluidOutputs(UltralightBedrockSmoke.getFluid(150))
                .duration(140)
                .EUt(40960)
                .buildAndRegister();
    }

    private static void EnrichedBedrockSmokeProcess() {

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 5)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(HeavyEnrichedTaraniumGas.getFluid(4000))
                .duration(1200)
                .EUt(VA[ZPM])
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 4)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(MediumEnrichedTaraniumGas.getFluid(4000))
                .duration(960)
                .EUt(VA[ZPM])
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedBedrockSmoke.getFluid(8000))
                .output(dust, Bedrock, 3)
                .output(dust, Naquadria)
                .output(dust, Iridium, 2)
                .output(dust, Osmium, 3)
                .fluidOutputs(LightEnrichedTaraniumGas.getFluid(4000))
                .duration(600)
                .EUt(VA[ZPM])
                .buildAndRegister();
    }

    private static void EnrichedTaraniumGasProcess() {

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(6000))
                .fluidInputs(HeavyEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedHeavyEnrichedTaranium.getFluid(2000))
                .duration(300).EUt(49152).buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(4000))
                .fluidInputs(MediumEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedMediumEnrichedTaranium.getFluid(1600))
                .duration(250)
                .EUt(49152)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Radon.getFluid(2000))
                .fluidInputs(LightEnrichedTaraniumGas.getFluid(1000))
                .fluidOutputs(CrackedLightEnrichedTaranium.getFluid(1200))
                .duration(200)
                .EUt(49152)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedHeavyEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(250))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(BedrockGas.getFluid(50))
                .duration(160)
                .EUt(98304)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedMediumEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(150))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(100))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(200))
                .fluidOutputs(BedrockGas.getFluid(150))
                .duration(140).EUt(98304).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrackedLightEnrichedTaranium.getFluid(1000))
                .output(dust, Taranium, 2)
                .fluidOutputs(Radon.getFluid(50))
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(50))
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(150))
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(400))
                .fluidOutputs(BedrockGas.getFluid(350))
                .duration(120)
                .EUt(98304)
                .buildAndRegister();
    }

    private static void CrudeNaquadahFuel() {

        //  Naquadah -> Crude Naquadah Fuel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(1000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //  Enriched Naquadah -> Crude Naquadah Fuel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(3000))
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  Naquadria -> Crude Naquadah Fuel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(AmmoniumNitrate.getFluid(1000))
                .fluidOutputs(CrudeNaquadahFuel.getFluid(6000))
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrudeNaquadahFuel.getFluid(9000))
                .chancedOutput(dust, Naquadah, 1000, 500)
                .fluidOutputs(HeavyNaquadahFuel.getFluid(1000))
                .fluidOutputs(MediumNaquadahFuel.getFluid(2000))
                .fluidOutputs(LightNaquadahFuel.getFluid(3000))
                .fluidOutputs(NaquadahGas.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(800))
                .fluidOutputs(Ammonia.getFluid(400))
                .fluidOutputs(EnrichedNaquadahWaste.getFluid(400))
                .fluidOutputs(NaquadriaWaste.getFluid(200))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();
    }

    private static void OrichalcumProcess() {

        //  Remove CEu Neutronium
        GTRecipeHandler.removeRecipesByInputs(FUSION_RECIPES, Americium.getFluid(128), Naquadria.getFluid(128));

        //  Replace with orichalcum
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(128))
                .fluidInputs(Naquadria.getFluid(128))
                .fluidOutputs(Orichalcum.getFluid(32))
                .EUToStart(600000000)
                .duration(200)
                .EUt(VA[LuV] * 3)
                .buildAndRegister();

        //  Orichalcum + Helium -> Energized Orichalcum
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(Helium.getPlasma(125))
                .output(dust, OrichalcumEnergized)
                .duration(200)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Remove Orichalcum dust -> hot ingot
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Orichalcum), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Orichalcum),
                                IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Argon.getFluid(50)});

        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .circuitMeta(1)
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(2000)
                .EUt(VA[UV])
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .circuitMeta(2)
                .fluidInputs(Argon.getFluid(50))
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(1000)
                .EUt(VA[UV])
                .buildAndRegister();
    }

    private static void AdamantiumProcess() {

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockGas.getFluid(1000))
                .output(dust, Bedrock)
                .fluidOutputs(Helium3.getFluid(20))
                .duration(100)
                .EUt(1024)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Bedrock)
                .chancedOutput(dust, Adamantite, 3000, 500)
                .chancedOutput(dust, Monazite, 2, 3000, 0)
                .chancedOutput(dust, Zirconium, 3, 6000, 0)
                .duration(120)
                .EUt(VA[IV])
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Adamantium, 4)
                .fluidInputs(Naquadah.getFluid(L * 4))
                .output(dust, Naquadah)
                .output(dust, Uranium238)
                .fluidOutputs(AdamantiumUnstable.getFluid(L * 4))
                .duration(800)
                .EUt(VA[LuV])
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Europium.getFluid(16))
                .fluidInputs(AdamantiumUnstable.getFluid(16))
                .fluidOutputs(Adamantium.getPlasma(16))
                .EUToStart(300000000)
                .duration(32)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Remove Adamantium dust -> hot ingot
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Adamantium), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Adamantium), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(MetaItems.SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(L))
                .output(ingotHot, Adamantium)
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void VibraniumProcess() {

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, DeepIron, 4)
                .output(dust, Iron, 2)
                .output(dust, Trinium)
                .output(dust, Indium)
                .duration(600)
                .EUt(VA[IV])
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AdamantiumEnriched, 4)
                .fluidInputs(NaquadahEnriched.getFluid(L * 4))
                .output(dust, NaquadahEnriched, 2)
                .output(dust, Plutonium239)
                .fluidOutputs(VibraniumUnstable.getFluid(L * 4))
                .duration(1600)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(L))
                .fluidInputs(VibraniumUnstable.getFluid(L))
                .fluidOutputs(Vibranium.getPlasma(L))
                .EUToStart(620000000)
                .duration(64)
                .EUt(VA[ZPM] * 2)
                .buildAndRegister();

        //  Vibranium dust -> hot ingot used for Quantum Force Transformer,
        //  in common game, you can not get vibranium dust in your bedrock processing stage.

        //  Another common vibranium hot ingot recipes.
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(MetaItems.SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(L))
                .output(ingotHot, Vibranium)
                .duration(400)
                .EUt(500000)
                .buildAndRegister();
    }

    /**
     * Product Taranium by Stone dust and Red Mud.
     *
     * <p>
     *     Required Isa Mill Ore Processing, and so many machines in LuV-UHV stage,
     *     this chain is just a joke in nature. Basic Processing chain from Gregicality Legacy.
     * </p>
     *
     * @see IsaMillOreProcessing
     */
    private static void StoneProcess() {

        //  24 Stone + 6HF -> H2SiF6?
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Stone, 24)
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidOutputs(DirtyHexafluorosilicicAcid.getFluid(3000))
                .EUt(VA[MV])
                .duration(SECOND * 2)
                .buildAndRegister();

        //  H2SiF6? + 4kL Red Mud -> + (H2SiF6)(H2O)2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DirtyHexafluorosilicicAcid.getFluid(3000))
                .fluidInputs(RedMud.getFluid(4000))
                .output(dust, StoneResidue, 12)
                .fluidOutputs(DilutedHexafluorosilicicAcid.getFluid(3000))
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  (H2SiF6)(H2O)2 -> H2SiF6 + 2H2O
        //  This is another recipe of H2SiF6 (for Power Int Circuit chain).
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedHexafluorosilicicAcid.getFluid(3000))
                .fluidOutputs(HexafluorosilicicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  24 Stone Residue + NaOH + H2O -> Selected Stone Residue + Fe3O4 (chanced) + Red Mud
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, StoneResidue, 24)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .fluidInputs(SodiumHydroxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SelectedStoneResidue)
                .chancedOutput(dust, Magnetite, 2500, 0)
                .fluidOutputs(RedMud.getFluid(1000))
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  2O + 2F -> F2O2
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(MICROFOCUS_X_RAY_TUBE)
                .fluidInputs(Oxygen.getFluid(FluidStorageKeys.LIQUID, 2000))
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(DioxygenDifluoride.getFluid(1000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Selected Stone Residue + F2O2 -> Partically Oxidized Residue
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, SelectedStoneResidue)
                .fluidInputs(DioxygenDifluoride.getFluid(1000))
                .output(dust, PartiallyOxidizedStoneResidue)
                .EUt(VA[MV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  10 Partically Oxidized Residue + 10H2O -> 10 Oxidized Residual Stone Slurry + Inert Residue
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, PartiallyOxidizedStoneResidue, 10)
                .fluidInputs(DistilledWater.getFluid(10000))
                .output(dust, InertStoneResidue)
                .fluidOutputs(OxidizedResidualStoneSlurry.getFluid(10000))
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  2 Oxidized Residual Stone Slurry -> Oxidized Stone Residue + Heavy Oxidized Residue
        CHEMICAL_DRYER_RECIPES.recipeBuilder()
                .fluidInputs(OxidizedResidualStoneSlurry.getFluid(2000))
                .output(dust, OxidizedStoneResidue)
                .output(dust, HeavyOxidizedStoneResidue)
                .EUt(VA[EV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  10 Oxidized Stone Residue + 60H -> Metallic Stone Residue + 40(HF)(H2O)
        BLAST_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, OxidizedStoneResidue, 10)
                .fluidInputs(Hydrogen.getFluid(60000))
                .output(dust, MetallicStoneResidue)
                .fluidOutputs(DilutedHydrofluoricAcid.getFluid(40000))
                .EUt(VA[IV])
                .duration(80 * SECOND)
                .blastFurnaceTemp(3500)
                .buildAndRegister();

        //  10 Heavy Oxidized Residue + 60H -> Heavy Metallic Residue + 40(HF)(H2O)
        BLAST_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, HeavyOxidizedStoneResidue, 10)
                .fluidInputs(Hydrogen.getFluid(60000))
                .output(dust, HeavyMetallicStoneResidue)
                .fluidOutputs(DilutedHydrofluoricAcid.getFluid(40000))
                .EUt(VA[IV])
                .duration(80 * SECOND)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        //  (HF)(H2O) -> H2O + HF
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedHydrofluoricAcid.getFluid(2000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  10 Metallic Stone Residue -> Some residues
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, MetallicStoneResidue, 10)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .output(dust, DiamagneticResidue, 3)
                .output(dust, ParamagneticResidue, 3)
                .output(dust, FerromagneticResidue, 3)
                .output(dust, SelectedStoneResidue)
                .EUt(VA[IV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  10 Heavy Metallic Stone Residue -> Some Heavy residues + Superheavy Stone Residue
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, HeavyMetallicStoneResidue, 10)
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .output(dust, HeavyDiamagneticResidue, 3)
                .output(dust, HeavyParamagneticResidue, 3)
                .output(dust, HeavyFerromagneticResidue, 3)
                .output(dust, SuperheavyStoneResidue)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Diamagnetic Residue -> Calcium, Zinc, Copper, Gallium, Berylium, Tin
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, DiamagneticResidue, 6)
                .chancedOutput(dust, Calcium, 2500, 0)
                .chancedOutput(dust, Zinc, 2500, 0)
                .chancedOutput(dust, Copper, 2500, 0)
                .chancedOutput(dust, Gallium, 2500, 0)
                .chancedOutput(dust, Beryllium, 2500, 0)
                .chancedOutput(dust, Tin, 2500, 0)
                .EUt(VH[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Paramagnetic Residue -> Sodium, Potassium, Magnesium, Titanium, Vanadium, Manganese
        SIFTER_RECIPES.recipeBuilder()
                .input(dust, ParamagneticResidue, 6)
                .chancedOutput(dust, Sodium, 2500, 0)
                .chancedOutput(dust, Potassium, 2500, 0)
                .chancedOutput(dust, Magnesium, 2500, 0)
                .chancedOutput(dust, Titanium, 2500, 0)
                .chancedOutput(dust, Vanadium, 2500, 0)
                .chancedOutput(dust, Manganese, 2500, 0)
                .EUt(VH[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Ferromagnetic Residue -> Iron, Nickel, Cobalt
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, FerromagneticResidue, 6)
                .chancedOutput(dust, Iron, 2500, 0)
                .chancedOutput(dust, Nickel, 2500, 0)
                .chancedOutput(dust, Cobalt, 2500, 0)
                .EUt(VH[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Heavy Diamagnetic Residue -> Lead, Cadmium, Indium, Gold, Bismuth
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, HeavyDiamagneticResidue, 6)
                .chancedOutput(dust, Lead, 2500, 0)
                .chancedOutput(dust, Cadmium, 2500, 0)
                .chancedOutput(dust, Indium, 2500, 0)
                .chancedOutput(dust, Gold, 2500, 0)
                .chancedOutput(dust, Bismuth, 2500, 0)
                .fluidOutputs(Mercury.getFluid(36))
                .EUt(VH[LuV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Heavy Paramagnetic Residue -> Thorium, Uranium-235, Tungsten, Hafnium, Tantalum, Thallium
        SIFTER_RECIPES.recipeBuilder()
                .input(dust, HeavyParamagneticResidue, 6)
                .chancedOutput(dust, Thorium, 2500, 0)
                .chancedOutput(dust, Uranium235, 2500, 0)
                .chancedOutput(dust, Tungsten, 2500, 0)
                .chancedOutput(dust, Hafnium, 2500, 0)
                .chancedOutput(dust, Tantalum, 2500, 0)
                .chancedOutput(dust, Thallium, 2500, 0)
                .EUt(VH[LuV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Heavy Ferromagnetic Residue -> Dy2O3
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, HeavyFerromagneticResidue, 6)
                .chancedOutput(dust, DysprosiumOxide, 5, 2500, 0)
                .EUt(VH[LuV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Superheavy Stone Residue Processing
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SuperheavyStoneResidue, 16)
                .input(dust, SodiumHydroxide, 3)
                .input(PROTONATED_FULLERENE_SIEVING_MATRIX)
                .circuitMeta(4)
                .fluidInputs(DistilledWater.getFluid(2000))
                .output(SATURATED_FULLERENE_SIEVING_MATRIX)//todo processing
                .EUt(VA[UHV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  Inert Residue -> Clean Inert Resique + Naquadria
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, InertStoneResidue, 10)
                .notConsumable(FluoroantimonicAcid.getFluid(1))
                .output(dust, CleanInertStoneResidue, 10)
                .chancedOutput(dust, Naquadria, 2500, 0)
                .EUt(VA[ZPM])
                .duration(16 * SECOND)
                .buildAndRegister();

        //  T + H -> TH
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Tritium.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidOutputs(TritiumHydride.getFluid(2000))
                .EUt(VH[EV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  TH -> He-3H + TH
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TritiumHydride.getFluid(10000))
                .fluidOutputs(Helium3Hydride.getFluid(100))
                .fluidOutputs(TritiumHydride.getFluid(9900))
                .EUt(VH[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Clean Inert Stone Residue + He-3H -> Ultraacidic Stone Residue Solution
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CleanInertStoneResidue)
                .fluidInputs(Helium3Hydride.getFluid(1000))
                .fluidOutputs(UltraacidicStoneResidueSolution.getFluid(1000))
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  Ultraacidic Stone Residue Solution -> Dusty Helium-3
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(UltraacidicStoneResidueSolution.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(FluidStorageKeys.LIQUID, 4000))
                .fluidInputs(Xenon.getFluid(1000))
                .fluidOutputs(DustyHelium3.getFluid(2000))
                .fluidOutputs(XenicAcid.getFluid(1000))
                .EUt(VA[LuV])
                .duration(6 * SECOND)
                .temperature(1355)
                .buildAndRegister();

        //  Another Application of H2XeO4: H2XeO4 -> XeO3 + H2O
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(XenicAcid.getFluid(1000))
                .fluidOutputs(XenonTrioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dusty Helium-3 -> Taranium-enriched Helium-3 + Taranium-semidepleted Helium-3 + Taranium-depleted Helium-3
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(DustyHelium3.getFluid(1000))
                .fluidOutputs(TaraniumEnrichedHelium3.getFluid(100))
                .fluidOutputs(TaraniumSemidepletedHelium3.getFluid(300))
                .fluidOutputs(TaraniumDepletedHelium3.getFluid(600))
                .EUt(VA[UV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  Taranium-enriched Helium-3 -> Taranium Rich Dusty Helium Plasma
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumEnrichedHelium3.getFluid(1000))
                .fluidInputs(Helium3.getFluid(1000))
                .fluidOutputs(TaraniumRichDustyHelium3.getPlasma(3000))
                .EUt(VA[IV])
                .duration(8 * SECOND)
                .EUToStart(480000000L)
                .buildAndRegister();

        //  Taranium Rich Dusty Helium Plasma -> Taranium rich Helium-4 (liquid), Taranium-depleted Helium-3 (plasma), Hydrogen
        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumRichDustyHelium3.getPlasma(3000))
                .notConsumable(plate, Bedrock)
                .fluidOutputs(TaraniumRichHelium4.getPlasma(500))
                .fluidOutputs(TaraniumDepletedHelium3.getPlasma(500))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Taranium-depleted Helium-3 (plasma) + He (plasma) -> Taranium-depleted Helium-3 (liquid)
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumDepletedHelium3.getPlasma(1000))
                .fluidInputs(Helium.getPlasma(1000))
                .fluidOutputs(TaraniumDepletedHelium3.getFluid(2000))
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Taranium-depleted Helium-3 (liquid) -> Helium (plasma) + Clean Inert Stone Residue
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumDepletedHelium3.getFluid(10000))
                .notConsumable(SEPARATION_ELECTROMAGNET.getStackForm())
                .output(dust, CleanInertStoneResidue, 2)
                .fluidOutputs(Helium.getPlasma(5000))
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Taranium-semidepleted Helium-3 -> Taranium-enriched Helium-3 + Taranium-depleted Helium-3
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumSemidepletedHelium3.getFluid(1000))
                .fluidOutputs(TaraniumEnrichedHelium3.getFluid(100))
                .fluidOutputs(TaraniumDepletedHelium3.getFluid(900))
                .EUt(VA[EV])
                .duration(20 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Taranium rich He-4 -> Tn + Taranium Poor Helium
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumRichHelium4.getPlasma(400))
                .output(dust, Taranium)
                .fluidOutputs(TaraniumPoorHelium.getFluid(400))
                .EUt(VA[UHV])
                .duration(SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Taranium Poor Helium + He-3 -> Taranium Poor Helium Mixture
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumPoorHelium.getFluid(1000))
                .fluidInputs(Helium3.getFluid(200))
                .fluidOutputs(TaraniumPoorHeliumMixture.getFluid(1200))
                .EUt(VA[LuV])
                .duration(4 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Taranium Poor Helium Mixture -> He + Dusty He-3
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumPoorHeliumMixture.getFluid(1200))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.LIQUID, 1000))
                .fluidOutputs(DustyHelium3.getFluid(200))
                .EUt(VA[IV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  Taranium Rich He-4 (plasma) -> Taranium Rich He-4 (liquid)
        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumRichHelium4.getPlasma(1000))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 100))
                .circuitMeta(1)
                .fluidOutputs(TaraniumRichHelium4.getFluid(1000))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 100))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .fluidInputs(TaraniumRichHelium4.getPlasma(1000))
                .fluidInputs(GelidCryotheum.getFluid(50))
                .circuitMeta(1)
                .fluidOutputs(TaraniumRichHelium4.getFluid(1000))
                .fluidOutputs(Ice.getFluid(50))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();
        
    }

    private static void NaquadahReactorRecipes() {

        //  Heavy Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyNaquadahFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueNaquadahFuel)
                .duration(180)
                .buildAndRegister();

        //  Medium Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumNaquadahFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueNaquadahFuel)
                .duration(120)
                .buildAndRegister();

        //  Light Naquadah Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightNaquadahFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueNaquadahFuel)
                .duration(60)
                .buildAndRegister();

        //  Heavy Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueTaraniumFuel)
                .duration(360)
                .buildAndRegister();

        //  Medium Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueTaraniumFuel)
                .duration(240)
                .buildAndRegister();

        //  Light Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueTaraniumFuel)
                .duration(120)
                .buildAndRegister();

        //  Heavy Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueEnrichedTaraniumFuel)
                .duration(720)
                .buildAndRegister();

        //  Medium Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueEnrichedTaraniumFuel)
                .duration(480)
                .buildAndRegister();

        //  Light Enriched Taranium Fuel
        NAQUADAH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(1))
                .EUt(GTLiteConfigHolder.misc.heatValueEnrichedTaraniumFuel)
                .duration(240)
                .buildAndRegister();

        //  Naquadah Gas
        if (GTLiteConfigHolder.misc.enableNaquadahGasTurbineRecipe) {
            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(NaquadahGas.getFluid(1))
                    .EUt(GTLiteConfigHolder.misc.heatValueNaquadahGas)
                    .duration(240)
                    .buildAndRegister();
        }
    }

    private static void FuelRefineFactoryRecipes() {

        //  Cetane Boosted Diesel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(Diesel.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidOutputs(CetaneBoostedDiesel.getFluid(6000))
                .EUt(VA[EV])
                .duration(20)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(BioDiesel.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidOutputs(CetaneBoostedDiesel.getFluid(6000))
                .EUt(VA[EV])
                .duration(20)
                .buildAndRegister();

        //  High Octane Gasoline
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .fluidInputs(Gasoline.getFluid(1000))
                .fluidInputs(Octane.getFluid(1000))
                .fluidOutputs(HighOctaneGasoline.getFluid(6000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();

        //  Light Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .fluidInputs(Uranium235.getFluid(500))
                .fluidInputs(Nitrogen.getFluid(500))
                .circuitMeta(1)
                .fluidOutputs(LightNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, GalliumSulfide)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .circuitMeta(11)
                .fluidOutputs(LightNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Medium Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, NaquadahEnriched)
                .fluidInputs(Uranium235.getFluid(500))
                .fluidInputs(Plutonium241.getFluid(500))
                .circuitMeta(2)
                .output(dust, Plutonium241)
                .fluidOutputs(MediumNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, IndiumPhosphide)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .circuitMeta(12)
                .fluidOutputs(MediumNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Heavy Naquadah Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .input(dust, Plutonium239)
                .fluidInputs(Nitrogen.getPlasma(500))
                .circuitMeta(3)
                .output(dust, Naquadah)
                .fluidOutputs(HeavyNaquadahFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[ZPM])
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Trinium)
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .circuitMeta(13)
                .fluidOutputs(HeavyNaquadahFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Light Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Gallium)
                .fluidInputs(LightNaquadahFuel.getFluid(12000))
                .fluidInputs(Krypton.getFluid(6000))
                .circuitMeta(4)
                .fluidOutputs(LightTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Medium Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Duranium)
                .fluidInputs(MediumNaquadahFuel.getFluid(12000))
                .fluidInputs(Xenon.getFluid(6000))
                .circuitMeta(5)
                .fluidOutputs(MediumTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Heavy Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Taranium)
                .input(dust, Tritanium)
                .fluidInputs(HeavyNaquadahFuel.getFluid(12000))
                .fluidInputs(Radon.getFluid(6000))
                .circuitMeta(6)
                .fluidOutputs(HeavyTaraniumFuel.getFluid(12000))
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  Light Enriched Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Americium)
                .fluidInputs(LightTaraniumFuel.getFluid(6000))
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .circuitMeta(14)
                .fluidOutputs(LightEnrichedTaraniumFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Medium Enriched Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Dubnium)
                .fluidInputs(MediumTaraniumFuel.getFluid(6000))
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .circuitMeta(15)
                .fluidOutputs(MediumEnrichedTaraniumFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Heavy Enriched Taranium Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Livermorium)
                .fluidInputs(HeavyTaraniumFuel.getFluid(6000))
                .fluidInputs(EnergeticNaquadria.getFluid(1000))
                .circuitMeta(16)
                .fluidOutputs(HeavyEnrichedTaraniumFuel.getFluid(6000))
                .duration(300)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Energetic Naquadria
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(NitrogenDioxide.getFluid(500))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .circuitMeta(0)
                .output(dust, Lutetium)
                .output(dust, Uranium238)
                .output(dust, Plutonium241)
                .output(dust, NaquadahEnriched)
                .fluidOutputs(EnergeticNaquadria.getFluid(1000))
                .duration(300)
                .EUt(65536)
                .buildAndRegister();

        //  Light Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Europium)
                .fluidInputs(LightTaraniumFuel.getFluid(500))
                .fluidInputs(LightEnrichedTaraniumFuel.getFluid(300))
                .fluidInputs(EnergeticNaquadria.getFluid(200))
                .fluidInputs(Uranium238.getFluid(L))
                .circuitMeta(7)
                .output(dust, Naquadah)
                .fluidOutputs(LightHyperFuel.getFluid(2000))
                .duration(460)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Medium Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Americium)
                .fluidInputs(MediumTaraniumFuel.getFluid(400))
                .fluidInputs(MediumEnrichedTaraniumFuel.getFluid(350))
                .fluidInputs(EnergeticNaquadria.getFluid(250))
                .fluidInputs(Uranium235.getFluid(L))
                .circuitMeta(8)
                .output(dust, NaquadahEnriched)
                .fluidOutputs(MediumHyperFuel.getFluid(2000))
                .duration(520)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Heavy Hyper Fuel
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(HeavyTaraniumFuel.getFluid(300))
                .fluidInputs(HeavyEnrichedTaraniumFuel.getFluid(400))
                .fluidInputs(EnergeticNaquadria.getFluid(300))
                .fluidInputs(Plutonium239.getFluid(L))
                .circuitMeta(9)
                .output(dust, NaquadahEnriched)
                .fluidOutputs(HeavyHyperFuel.getFluid(2000))
                .duration(580)
                .EUt(VA[UHV])
                .buildAndRegister();

        //  Adamantium + Bedrock Gas + Sulfuric Acid -> Adamantium Enriched + Deep Iron + Naquadah + Osmium + Diluted Sulfuric Acid
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Adamantium, 10)
                .fluidInputs(BedrockGas.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(100))
                .circuitMeta(10)
                .output(dust, AdamantiumEnriched)
                .output(dust, DeepIron, 5)
                .output(dust, Naquadah, 2)
                .output(dust, Osmium, 2)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(900))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  Hyper Fuel MK2
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(11)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(HeavyHyperFuel.getFluid(400))
                .fluidInputs(SuperheavyExoticGas.getFluid(200))
                .fluidOutputs(HyperFuelMkII.getFluid(3000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(12)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(HeavyHyperFuel.getFluid(800))
                .fluidInputs(HeavyExoticGas.getFluid(400))
                .fluidOutputs(HyperFuelMkII.getFluid(2000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(13)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(MediumHyperFuel.getFluid(1600))
                .fluidInputs(MediumExoticGas.getFluid(1400))
                .fluidOutputs(HyperFuelMkII.getFluid(1000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(13)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(LightHyperFuel.getFluid(3200))
                .fluidInputs(LightExoticGas.getFluid(2000))
                .fluidOutputs(HyperFuelMkII.getFluid(500))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  Hyper Fuels MK3
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Rhugnor)
                .input(dust, Adamantium)
                .circuitMeta(14)
                .fluidInputs(StarlightLiquid.getFluid(8000))
                .fluidInputs(AstralTitanium.getFluid(1000))
                .fluidInputs(CelestialTungsten.getFluid(1000))
                .fluidInputs(HyperFuelMkII.getFluid(2000))
                .fluidOutputs(HyperFuelMkIII.getFluid(1000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  Hyper Fuel MK4
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Hypogen)
                .input(dust, Astralium)
                .circuitMeta(15)
                .fluidInputs(Ichorium.getFluid(8000))
                .fluidInputs(Galaxium.getFluid(2000))
                .fluidInputs(CrystalMatrix.getFluid(2000))
                .fluidInputs(HyperFuelMkIII.getFluid(4000))
                .fluidOutputs(HyperFuelMkIV.getFluid(500))
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();

    }

    private static void HyperReactorRecipes() {

        //  Hyper Reactor Mk I
        HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(LightHyperFuel.getFluid(1))
                .duration(200)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark1)
                .buildAndRegister();

        HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(MediumHyperFuel.getFluid(1))
                .duration(400)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark1)
                .buildAndRegister();

        HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(HeavyHyperFuel.getFluid(1))
                .duration(600)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark1)
                .buildAndRegister();

        HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkII.getFluid(1))
                .duration(300)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark2)
                .buildAndRegister();

        //  Hyper Reactor Mk II
        HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(LightHyperFuel.getFluid(1))
                .duration(200)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark2)
                .buildAndRegister();

        HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(MediumHyperFuel.getFluid(1))
                .duration(400)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark2)
                .buildAndRegister();

        HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(HeavyHyperFuel.getFluid(1))
                .duration(600)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark2)
                .buildAndRegister();

        HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkIII.getFluid(1))
                .duration(600)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark3)
                .buildAndRegister();

        //  Hyper Reactor Mk III
        HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(LightHyperFuel.getFluid(1))
                .duration(200)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark3)
                .buildAndRegister();

        HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(MediumHyperFuel.getFluid(1))
                .duration(400)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark3)
                .buildAndRegister();

        HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(HeavyHyperFuel.getFluid(1))
                .duration(600)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelsMark3)
                .buildAndRegister();

        HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkIV.getFluid(1))
                .duration(1200)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark4)
                .buildAndRegister();
    }
}
