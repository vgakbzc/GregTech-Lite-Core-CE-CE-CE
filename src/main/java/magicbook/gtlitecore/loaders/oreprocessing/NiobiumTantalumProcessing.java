package magicbook.gtlitecore.loaders.oreprocessing;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class NiobiumTantalumProcessing {

    public static void init() {
        NiobiumProcess();
        TantalumProcess();
    }

    private static void NiobiumProcess() {
        //  Ca2Nb2O7 + 4HF -> Nb2O5 + 2CaF2 + 2H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pyrochlore, 11)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .output(dust, NiobiumPentoxide, 7)
                .output(dust, TantalumPentoxide)
                .output(dust, CalciumDifluoride, 6)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void TantalumProcess() {
        //  MnTa2O6 + 2HF -> Ta2O5 + MnF2 + H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Tantalite, 9)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .output(dust, TantalumPentoxide, 7)
                .output(dust, NiobiumPentoxide)
                .output(dust, ManganeseDifluoride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}