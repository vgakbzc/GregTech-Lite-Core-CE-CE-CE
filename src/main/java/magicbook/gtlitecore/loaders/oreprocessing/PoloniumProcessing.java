package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Polonium Process
 *
 * @author Magic_Sweepy (2023/12/30)
 *
 * <p>Produces Polonium from Pitchblende</p>
 *
 * <p>Main Products: Polonium</p>
 * <p>Side Products: Uraninite</p>
 */
public class PoloniumProcessing {

    public static void init() {

        //  (UO2)3ThPb + 4HNO3 -> UO2 + Po(NO3)4
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pitchblende, 5)
                .fluidInputs(NitricAcid.getFluid(4000))
                .output(dust, Uraninite, 3)
                .fluidOutputs(PoloniumNitrate.getFluid(1000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //  Po(NO3)4 + 2HCl + 2H -> PoCl2 + 4HNO3 (cycle)
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PoloniumNitrate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, PoloniumDichloride, 3)
                .fluidOutputs(NitricAcid.getFluid(4000))
                .EUt(VA[HV])
                .duration(200)
                .temperature(2866)
                .buildAndRegister();

        //  PoCl2 + 2H -> Po + 2HCl (cycle)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PoloniumDichloride, 3)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, Polonium)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();
    }

}
