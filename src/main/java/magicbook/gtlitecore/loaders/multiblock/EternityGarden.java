package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.Gold;
import static gregtech.api.unification.material.Materials.Iron;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.ETERNITY_GARDEN_RECIPES;

public class EternityGarden {

    public static void init() {
        //  test
        ETERNITY_GARDEN_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .output(dust, Gold)
                .EUt(VA[LV])
                .duration(1)
                .buildAndRegister();
    }
}
