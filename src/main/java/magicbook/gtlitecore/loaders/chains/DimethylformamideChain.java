package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.DimethylamineHydrochloride;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Dimethylformamide;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.PotassiumFormate;

public class DimethylformamideChain {

    public static void init() {
        SimpleProcess();
        FullProcess();
    }

    private static void SimpleProcess() {

        //  (CH3)2NH + CO -> (CH3)2NC(O)H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(Dimethylformamide.getFluid(1000))
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void FullProcess() {

        //  KCl + CH4O -> CH3OK + HCl
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .fluidInputs(Methanol.getFluid(1000))
                .output(dust, PotassiumFormate, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(12 * SECOND)
                .temperature(980)
                .buildAndRegister();

        //  (CH3)2NH + HCl -> C2H8NCl
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(DimethylamineHydrochloride.getFluid(1000))
                .EUt(VA[EV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  CH3OK + C2H8NCl -> KCl + (CH3)2NC(O)H + H + Cl (lost)
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumFormate, 6)
                .fluidInputs(DimethylamineHydrochloride.getFluid(1000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(Dimethylformamide.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .temperature(1488)
                .buildAndRegister();
    }
}