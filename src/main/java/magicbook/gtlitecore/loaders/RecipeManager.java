package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.components.MachineComponents;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        initBlocks();
        MachineComponents.init();
        MachineRecipeLoader.init();
    }

    private static void initBlocks() {
        Crucibles.init();
    }
}
