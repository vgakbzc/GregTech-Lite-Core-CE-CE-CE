package magicbook.gtlitecore.integration.appliedenergistics2;

import magicbook.gtlitecore.integration.appliedenergistics2.recipes.CellRecipes;
import magicbook.gtlitecore.integration.appliedenergistics2.recipes.MaterialRecipes;

public class AE2RecipeLoader {

    //  This Recipe Loader is not via AE2 Original Recipe Tweak,
    //  just use ModHandler to tweak all recipes (consists of NAE2 and AE2FC).
    public static void init() {
        CellRecipes.init();
        MaterialRecipes.init();
    }
}
