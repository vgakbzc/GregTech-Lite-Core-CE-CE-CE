package magicbook.gtlitecore.loaders.chains;

import gregicality.multiblocks.api.fluids.GCYMFluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumCyanide;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class SuperconductorsChain {

    public static void init() {
        UXVSuperconductors();
        OpVSuperconductors();
        MAXSuperconductors();
    }

    private static void UXVSuperconductors() {
        BETSPerrhenateChain();
        BoronFranciumCarbideChain();
    }

    private static void BETSPerrhenateChain() {

        //  NaOH + CO -> HCOONa
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(SodiumFormate.getFluid(1000))
                .EUt(VA[LV])
                .duration(4 * SECOND + 10)
                .temperature(288)
                .buildAndRegister();

        //  HCOONa + H2SO4 -> Na2S2O3 + 2HCOOH (cycle to dibromoacrolein recipe)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SodiumFormate.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, SodiumThiosulfate, 7)
                .fluidOutputs(FormicAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  4Na + 2HCOOH + 2Br + 2H2O -> 4NaOH + C2H2Br2O2 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium, 4)
                .fluidInputs(FormicAcid.getFluid(2000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, SodiumHydroxide, 12)
                .fluidOutputs(Dibromoacrolein.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[EV])
                .duration(18 * SECOND)
                .buildAndRegister();

        //  2Na2S2O3 + C2H2Br2O2 + C2H4Cl2 -> 2NaCl + 2NaHSO4 + C4H4S2Br2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumThiosulfate, 14)
                .fluidInputs(Dibromoacrolein.getFluid(1000))
                .fluidInputs(Dichloroethane.getFluid(1000))
                .output(dust, Salt, 4)
                .output(dust, SodiumBisulfate, 14)
                .fluidOutputs(Bromodihydrothiine.getFluid(1000))
                .EUt(VA[IV])
                .duration(16 * SECOND)
                .buildAndRegister();

        //  2Se + C4H4S2Br2 + 2C4H9Li -> C4H4S2Li2Se2 + 2C4H9Br
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Selenium, 2)
                .fluidInputs(Bromodihydrothiine.getFluid(1000))
                .fluidInputs(Butyllithium.getFluid(2000))
                .output(dust, Lithiumthiinediselenide,14)
                .fluidOutputs(Bromobutane.getFluid(2000))
                .EUt(VA[LuV])
                .duration(17 * SECOND)
                .buildAndRegister();

        //  2C4H4S2Li2Se2 + C2F4 -> C10H8S4Se4 + 4LiF
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Lithiumthiinediselenide, 28)
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .notConsumable(TitaniumTetrachloride.getFluid(1))
                .output(dust, Bisethylenedithiotetraselenafulvalene, 26)
                .output(dust, LithiumFluoride, 8)
                .EUt(VA[UHV])
                .duration(40 * SECOND)
                .temperature(2500)
                .buildAndRegister();

        //  C10H8S4Se4 + NH4ReO4 -> ReC10H8S4Se4O4
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Bisethylenedithiotetraselenafulvalene, 26)
                .fluidInputs(AmmoniumPerrhenate.getFluid(1000))
                .output(dust, BETSPerrhenate, 31)
                .blastFurnaceTemp(5000)
                .EUt(VA[LuV])
                .duration(MINUTE)
                .buildAndRegister();
    }

    private static void BoronFranciumCarbideChain() {

        //  2Fr + C2H2 -> Fr2C2 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Francium, 2)
                .fluidInputs(Acetylene.getFluid(1000))
                .output(dust, FranciumCarbide, 4)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[HV])
                .duration(13 * SECOND)
                .buildAndRegister();

        //  4B + 3C -> B4C3
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Boron, 4)
                .input(dust, Carbon, 3)
                .output(dust, BoronCarbide, 7)
                .EUt(VA[MV])
                .duration(27 * SECOND + 10)
                .blastFurnaceTemp(4000)
                .buildAndRegister();

        //  2Fr2C2 + B4C3 -> Fr4B4C7
        MIXER_RECIPES.recipeBuilder()
                .input(dust, FranciumCarbide, 8)
                .input(dust, BoronCarbide, 7)
                .circuitMeta(2)
                .output(dust, BoronFranciumCarbide, 15)
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, BoronFranciumCarbide, 15)
                .output(dust, FranciumCarbide, 8)
                .output(dust, BoronCarbide, 7)
                .EUt(VA[HV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }


    private static void OpVSuperconductors() {

        //  Re + 5Cl -> ReCl5
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Rhenium)
                .circuitMeta(5)
                .fluidInputs(Chlorine.getFluid(5000))
                .output(dust, RheniumPentachloride, 6)
                .EUt(VA[HV])
                .duration(7 * SECOND)
                .buildAndRegister();

        //  Hs + 4Cl -> HsCl4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MetastableHassium)
                .circuitMeta(4)
                .fluidInputs(Chlorine.getFluid(4000))
                .output(dust, HassiumTetrachloride, 5)
                .EUt(VA[MV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Tl + Cl -> TlCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .circuitMeta(1)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, ThalliumChloride, 2)
                .EUt(VA[MV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  TlCuCl3 -> TlCl + CuCl2
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, ThalliumCopperChloride, 5)
                .output(dust, ThalliumChloride, 2)
                .output(dust, CopperChloride, 3)
                .EUt(VA[EV])
                .duration(12 * SECOND)
                .temperature(1800)
                .buildAndRegister();

        //  H2SiF6 + PH3 + 4O -> HPF6 + SiO2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HexafluorosilicicAcid.getFluid(1000))
                .fluidInputs(Phosphine.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(4000))
                .output(dust, SiliconDioxide, 3)
                .fluidOutputs(HexafluorophosphoricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(10 * SECOND)
                .buildAndRegister();

        IsophthaloylbisdiethylthioureaChain();

        //  TlCl + HsCl4 + ReCl5 + 3C18H26N4O2S2 + HPF6 -> C60H84O12N12S6F6PReHsTl + 7HCl + 3Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ThalliumChloride, 2)
                .input(dust, HassiumTetrachloride, 5)
                .input(dust, RheniumPentachloride, 6)
                .fluidInputs(Isophthaloylbisdiethylthiourea.getFluid(3000))
                .fluidInputs(HexafluorophosphoricAcid.getFluid(1000))
                .output(dust, RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate, 125)
                .fluidOutputs(HydrochloricAcid.getFluid(7000))
                .fluidOutputs(Chlorine.getFluid(3000))
                .EUt(VA[UIV])
                .duration(5 * SECOND)
                .buildAndRegister();

    }

    private static void IsophthaloylbisdiethylthioureaChain() {

        //  NaCN + S -> NaSCN
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .inputs(SodiumCyanide.getItemStack(3))
                .input(dust, Sulfur)
                .fluidOutputs(SodiumThiocyanate.getFluid(1000))
                .EUt(VA[IV])
                .duration(6 * SECOND)
                .temperature(980)
                .buildAndRegister();

        //  C2H4 + NH3 -> C2H5NH2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .circuitMeta(0)
                .fluidOutputs(Ethylamine.getFluid(1000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  NaSCN + HCl + 2C2H5NH2 -> NaCl + (C2H5NH)2CS + NH3 (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SodiumThiocyanate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(Ethylamine.getFluid(2000))
                .output(dust, Salt, 2)
                .fluidOutputs(Diethylthiourea.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .EUt(VA[LuV])
                .duration(7 * SECOND)
                .buildAndRegister();

        //  C6H6O + H2O2 + 2C2H2O + 2O -> C10H10O6 + H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidInputs(Ethenone.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(PhenylenedioxydiaceticAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[UV])
                .duration(17 * SECOND + 10)
                .buildAndRegister();

        //  2(C2H5NH)2CS + 2SOCl2 + C10H10O6 -> C18H26N4O2S2 + 4HCl + 2SO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Diethylthiourea.getFluid(2000))
                .fluidInputs(ThionylChloride.getFluid(2000))
                .fluidInputs(PhenylenedioxydiaceticAcid.getFluid(1000))
                .fluidOutputs(Isophthaloylbisdiethylthiourea.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .EUt(VA[UEV])
                .duration(4 * SECOND)
                .buildAndRegister();
    }

    private static void MAXSuperconductors() {

        //  Raw Tengam -> Tengame
        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, RawTengam)
                .output(dust, Tengam)
                .chancedOutput(dust, NeodymiumMagnetic, 1000, 250)
                .chancedOutput(dust, SamariumMagnetic, 2000, 600)
                .EUt(VA[OpV])
                .duration(SECOND)
                .buildAndRegister();

        //  Remove original recipe
        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES, OreDictUnifier.get(ingot, Tengam));

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, Tengam)
                .output(ingot, AttunedTengam)
                .EUt(VA[OpV])
                .duration((int) (4.9 * SECOND))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES, OreDictUnifier.get(plate, Tengam));

        POLARIZER_RECIPES.recipeBuilder()
                .input(plate, Tengam)
                .output(plate, AttunedTengam)
                .EUt(VA[OpV])
                .duration((int) (4.9 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(plateDouble, Tengam)
                .output(plateDouble, AttunedTengam)
                .EUt(VA[OpV])
                .duration((int) (9.8 * SECOND))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                OreDictUnifier.get(dust, Octiron, 8),
                OreDictUnifier.get(dust, RutheniumTriniumAmericiumNeutronate, 9),
                OreDictUnifier.get(dust, HastelloyK243, 7),
                OreDictUnifier.get(dust, AstralTitanium, 6),
                OreDictUnifier.get(dust, CelestialTungsten, 6),
                OreDictUnifier.get(dust, Shirabon, 2),
                OreDictUnifier.get(dust, Fluorocarborane, 25),
                OreDictUnifier.get(dust, AttunedTengam, 4),
                IntCircuitIngredient.getIntegratedCircuit(8));

        GTRecipeHandler.removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Octiron, 8),
                        OreDictUnifier.get(dust, RutheniumTriniumAmericiumNeutronate, 9),
                        OreDictUnifier.get(dust, HastelloyK243, 7),
                        OreDictUnifier.get(dust, AstralTitanium, 6),
                        OreDictUnifier.get(dust, CelestialTungsten, 6),
                        OreDictUnifier.get(dust, Shirabon, 2),
                        OreDictUnifier.get(dust, Fluorocarborane, 25),
                        OreDictUnifier.get(dust, AttunedTengam, 4),
                        IntCircuitIngredient.getIntegratedCircuit(18)},
                new FluidStack[]{Krypton.getFluid(670)});

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Octiron, 8)
                .input(dust, RutheniumTriniumAmericiumNeutronate, 9)
                .input(dust, HastelloyK243, 7)
                .input(dust, AstralTitanium, 6)
                .input(dust, CelestialTungsten, 6)
                .input(dust, Shirabon, 2)
                .input(dust, Fluorocarborane, 25)
                .input(dust, AttunedTengam, 4)
                .circuitMeta(8)
                .fluidInputs(Eternity.getFluid(L * 40))
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(16000))
                .fluidOutputs(CosmicMatterSuperconductor.getFluid(GCYMFluidStorageKeys.MOLTEN, 9648))
                .EUt((int) (V[MAX]))
                .duration((int) (50.25 * SECOND))
                .blastFurnaceTemp(22000)
                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Octiron, 8)
                .input(dust, RutheniumTriniumAmericiumNeutronate, 9)
                .input(dust, HastelloyK243, 7)
                .input(dust, AstralTitanium, 6)
                .input(dust, CelestialTungsten, 6)
                .input(dust, Shirabon, 2)
                .input(dust, Fluorocarborane, 25)
                .input(dust, AttunedTengam, 4)
                .circuitMeta(18)
                .fluidInputs(MetastableOganesson.getFluid(670))
                .fluidInputs(Eternity.getFluid(L * 40))
                .fluidInputs(ZenithDimensionallyTranscendentCatalyst.getFluid(16000))
                .fluidOutputs(CosmicMatterSuperconductor.getFluid(GCYMFluidStorageKeys.MOLTEN, 9648))
                .EUt((int) (V[MAX]))
                .duration((int) (33.65 * SECOND))
                .blastFurnaceTemp(22000)
                .buildAndRegister();
    }
}