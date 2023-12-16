package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
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
                .duration(90)
                .temperature(288)
                .buildAndRegister();

        //  HCOONa + H2SO4 -> Na2S2O3 + 2HCOOH (cycle to dibromoacrolein recipe)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SodiumFormate.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, SodiumThiosulfate, 7)
                .fluidOutputs(FormicAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(120)
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
                .duration(360)
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
                .duration(320)
                .buildAndRegister();

        //  2Se + C4H4S2Br2 + 2C4H9Li -> C4H4S2Li2Se2 + 2C4H9Br
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Selenium, 2)
                .fluidInputs(Bromodihydrothiine.getFluid(1000))
                .fluidInputs(Butyllithium.getFluid(2000))
                .output(dust, Lithiumthiinediselenide,14)
                .fluidOutputs(Bromobutane.getFluid(2000))
                .EUt(VA[LuV])
                .duration(340)
                .buildAndRegister();

        //  2C4H4S2Li2Se2 + C2F4 -> C10H8S4Se4 + 4LiF
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Lithiumthiinediselenide, 28)
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .notConsumable(TitaniumTetrachloride.getFluid(1))
                .output(dust, Bisethylenedithiotetraselenafulvalene, 26)
                .output(dust, LithiumFluoride, 8)
                .EUt(VA[UHV])
                .duration(800)
                .temperature(2500)
                .buildAndRegister();

        //  C10H8S4Se4 + NH4ReO4 -> ReC10H8S4Se4O4
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Bisethylenedithiotetraselenafulvalene, 26)
                .fluidInputs(AmmoniumPerrhenate.getFluid(1000))
                .output(dust, BETSPerrhenate, 31)
                .blastFurnaceTemp(5000)
                .EUt(VA[LuV])
                .duration(1200)
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
                .duration(260)
                .buildAndRegister();

        //  4B + 3C -> B4C3
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Boron, 4)
                .input(dust, Carbon, 3)
                .output(dust, BoronCarbide, 7)
                .EUt(VA[MV])
                .duration(550)
                .blastFurnaceTemp(4000)
                .buildAndRegister();

        //  2Fr2C2 + B4C3 -> Fr4B4C7
        MIXER_RECIPES.recipeBuilder()
                .input(dust, FranciumCarbide, 8)
                .input(dust, BoronCarbide, 7)
                .circuitMeta(2)
                .output(dust, BoronFranciumCarbide, 15)
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, BoronFranciumCarbide, 15)
                .output(dust, FranciumCarbide, 8)
                .output(dust, BoronCarbide, 7)
                .EUt(VA[HV])
                .duration(400)
                .buildAndRegister();
    }


    private static void OpVSuperconductors() {

    }

    private static void MAXSuperconductors() {

    }
}