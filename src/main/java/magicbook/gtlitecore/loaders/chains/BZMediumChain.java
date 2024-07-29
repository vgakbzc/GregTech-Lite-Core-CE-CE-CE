package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ELECTROLYZER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CRYOGENIC_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class BZMediumChain {

    public static void init() {
        PotassiumBromateChain();
        MalonicAcidChain();

        //  0.8 KBrO3 + 0.25 C3H4O4 + Ce -> BZ Medium
        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotassiumBromate, 4)
                .input(dust, MalonicAcid, 3)
                .input(dust, Cerium)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(BZMedium.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .buildAndRegister();
    }

    private static void PotassiumBromateChain() {

        //  2Br + SO2 + 2H2O -> H2SO4 + 2HBr
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(2000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(2000))
                .EUt(VA[HV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  KCl + H2O -> KOH + Cl + H
        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, PotassiumHydroxide, 3)
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[LV])
                .duration(36 * SECOND)
                .buildAndRegister();

        //  3HBr + 3KOH -> KBrO3 + 3H2O
        CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(3000))
                .fluidInputs(PotassiumHydroxide.getFluid(L * 9))
                .output(dust, PotassiumBromate, 5)
                .fluidOutputs(Ice.getFluid(3000))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .temperature(273)
                .buildAndRegister();
    }

    private static void MalonicAcidChain() {

        //  C2H4Cl2 + Cl -> C2HCl3 + 3H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(Trichloroethylene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(3000))
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .temperature(400)
                .buildAndRegister();

        //  C2HCl3 + 2H2O -> C2H3ClO2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trichloroethylene.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .notConsumable(SulfuricAcid.getFluid(250))
                .output(dust, ChloroaceticAcid, 8)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  C2H3ClO2 + Na2CO3 + 2H2O -> C3H4O4 + 2NaOH + HClO
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, ChloroaceticAcid, 8)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, SodiumHydroxide, 6)
                .output(dust, MalonicAcid, 11)
                .fluidOutputs(HypochlorousAcid.getFluid(1000))
                .EUt(VA[IV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }
}
