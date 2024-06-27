package magicbook.gtlitecore.integration.appliedenergistics2;

import magicbook.gtlitecore.integration.appliedenergistics2.recipes.*;

/**
 * AE2 Recipe Loader.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This Recipe Loader is not a basic Recipe Loader via AE2 Original Recipe Tweak system,
 *     we add Inscriber via this system in Modpack (TODO resolved it in mod).
 * </p>
 */
public class AE2RecipeLoader {

    //  This Recipe Loader is not via AE2 Original Recipe Tweak,
    //  just use ModHandler to tweak all recipes (consists of NAE2 and AE2FC).

    public static void init() {
        //  Register of Ore Dicts of AE2 and related mod materials.
        AE2OreDictRegistry.registerOreDicts();
        //  Register of Recipes about AE2 and related mods.
        AE2MachineRecipeLoader.init();
        AE2MaterialRecipeLoader.init();
        AE2ComponentRecipeLoader.init();
        AE2MiscRecipes.init();
    }
}
