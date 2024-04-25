package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CVD_UNIT_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GalliumNitrideChain {

    public static void init() {

        //  Al + 3Na + 3CH3Cl -> 0.5 Al2(CH3)6 + 3NaCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Aluminium)
                .input(dust, Sodium, 3)
                .fluidInputs(Chloromethane.getFluid(3000))
                .fluidOutputs(Trimethylaluminium.getFluid(500))
                .output(dust, Salt, 6)
                .EUt(VA[EV])
                .duration(7 * SECOND + 10)
                .buildAndRegister();

        //  Ga + 3Cl -> GaCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Gallium)
                .fluidInputs(Chlorine.getFluid(3000))
                .circuitMeta(3)
                .output(dust, GalliumTrichloride, 4)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  GaCl3 + 0.5 Al2(CH3)6 -> Ga(CH3)3 + AlCl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GalliumTrichloride, 4)
                .fluidInputs(Trimethylaluminium.getFluid(500))
                .output(dust, AluminiumTrichloride, 4)
                .fluidOutputs(Trimethylgallium.getFluid(1000))
                .EUt(VA[HV])
                .duration(15 * SECOND)
                .buildAndRegister();

        //  AlCl3 + 3H2O -> Al(OH)3 + 3HCl
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AluminiumTrichloride, 4)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .EUt(VA[LV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  2Al(OH)3 -> Al2O3 + 3H2O
        CHEMICAL_DRYER_RECIPES.recipeBuilder()
                .input(dust, AluminiumHydroxide, 14)
                .output(dust, Alumina, 5)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VH[LV])
                .duration(3 * SECOND)
                .buildAndRegister();

        // 2Ga(CH3)3 + 3H2O -> Ga2O3 + 3CH4 + 3H (H lost)
        CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, Sapphire)
                .fluidInputs(Trimethylgallium.getFluid(2000))
                .fluidInputs(Water.getFluid(3000))
                .output(dust, GalliumTrioxide, 5)
                .fluidOutputs(Methane.getFluid(3000))
                .EUt(VA[HV])
                .duration(8 * SECOND)
                .temperature(923)
                .buildAndRegister();

        //  Ga2O3 + 2NH3 -> 2GaN + 3H2O
        CVD_UNIT_RECIPES.recipeBuilder()
                .fluidInputs(GalliumTrioxide.getFluid(L * 5))
                .fluidInputs(Ammonia.getFluid(2000))
                .output(plate, GalliumNitride, 4)
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(VA[LuV])
                .duration(12 * SECOND + 10)
                .temperature(1023)
                .buildAndRegister();
    }
}
