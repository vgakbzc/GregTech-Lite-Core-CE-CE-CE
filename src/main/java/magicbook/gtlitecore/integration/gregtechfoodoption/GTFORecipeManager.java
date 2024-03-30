package magicbook.gtlitecore.integration.gregtechfoodoption;

import magicbook.gtlitecore.integration.gregtechfoodoption.chains.MineralWaterChain;

public class GTFORecipeManager {

    private GTFORecipeManager() {}

    public static void initChains() {
        MineralWaterChain.init();
    }
}
