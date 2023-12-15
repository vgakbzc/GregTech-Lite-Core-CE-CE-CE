package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class FEPChain {

    public static void init() {

        //  3C2F4 -> 2C3F6
        PYROLYSE_RECIPES.recipeBuilder()
                .input(stick, Steel)
                .fluidInputs(Tetrafluoroethylene.getFluid(3000))
                .fluidOutputs(Hexafluoropropylene.getFluid(2000))
                .EUt(VA[HV])
                .duration(400)
                .buildAndRegister();

        //  C2F4 + C3F6 -> C5F10
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .fluidInputs(Hexafluoropropylene.getFluid(1000))
                .fluidOutputs(FluorinatedEthylenePropylene.getFluid(1000))
                .EUt(VA[EV])
                .duration(100)
                .buildAndRegister();
    }
}
