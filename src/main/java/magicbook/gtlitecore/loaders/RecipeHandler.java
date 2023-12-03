package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.handlers.BouleRecipeHandler;

public class RecipeHandler {

    public static void init() {
        BouleRecipeHandler.register();
    }
}