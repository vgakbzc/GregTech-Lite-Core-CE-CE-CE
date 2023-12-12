package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.handlers.BouleRecipeHandler;
import magicbook.gtlitecore.loaders.handlers.ToolRecipeHandler;

public class RecipeHandler {

    public static void init() {
        BouleRecipeHandler.register();
        ToolRecipeHandler.register();
    }
}