package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.components.MachineComponents;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        MachineComponents.init();
        MachineRecipeLoader.init();
    }
}
