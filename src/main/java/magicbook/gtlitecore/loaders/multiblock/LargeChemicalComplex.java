package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Water;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.LARGE_CHEMICAL_COMPLEX_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.CATALYST_INFINITY_MUTATION;

public class LargeChemicalComplex {

    public static void init() {
        LARGE_CHEMICAL_COMPLEX_RECIPES.recipeBuilder()
                .notConsumable(CATALYST_INFINITY_MUTATION)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Infinity.getFluid(500))
                .EUt(VA[LV])
                .duration(SECOND)
                .buildAndRegister();
    }
}
