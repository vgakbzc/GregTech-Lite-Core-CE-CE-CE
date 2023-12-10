package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class DimensionalOscillator {

    public static void init() {

        //  Manifold Oscillatory Power Cell
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(QUANTUM_ANOMALY)
                .input(plate, AstralTitanium)
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();
    }
}
