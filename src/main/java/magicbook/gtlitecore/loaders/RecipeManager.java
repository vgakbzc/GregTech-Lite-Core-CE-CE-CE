package magicbook.gtlitecore.loaders;

import magicbook.gtlitecore.loaders.blocks.Crucibles;
import magicbook.gtlitecore.loaders.components.MachineComponents;
import magicbook.gtlitecore.loaders.oreprocessing.PlatinumGroupProcessing;

public class RecipeManager {

    private RecipeManager() {}

    public static void init() {
        initBlocks();
        MachineComponents.init();
        MaterialInfoLoader.init();
        MachineRecipeLoader.init();
        initOreProcessings();
    }

    private static void initBlocks() {
        Crucibles.init();
    }

    private static void initOreProcessings() {
        PlatinumGroupProcessing.init();
    }
}
