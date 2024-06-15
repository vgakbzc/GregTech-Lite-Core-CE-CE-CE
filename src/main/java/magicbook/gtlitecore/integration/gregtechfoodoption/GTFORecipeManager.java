package magicbook.gtlitecore.integration.gregtechfoodoption;

import magicbook.gtlitecore.integration.gregtechfoodoption.chains.MineralWaterChain;

public class GTFORecipeManager {

    private GTFORecipeManager() {}

    public static void init() {
        GTFOMachineRecipeLoader.init();
        GTFOMiscRecipes.init();
        GTFOOverrideRecipeLoader.init();
    }

    public static void initChains() {
        MineralWaterChain.init();
    }
}
