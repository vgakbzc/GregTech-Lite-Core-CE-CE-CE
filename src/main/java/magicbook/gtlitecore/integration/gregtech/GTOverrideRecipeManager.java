package magicbook.gtlitecore.integration.gregtech;

import magicbook.gtlitecore.integration.gregtech.overrides.*;

public class GTOverrideRecipeManager {

    public static void init() {
        initItems();
        initBlocks();
        initParts();
    }

    private static void initItems() {
        SolarPanels.init();
    }

    private static void initBlocks() {
        MachineCasings.init();
        HermeticCasings.init();
    }

    private static void initParts() {
        ItemBuses.init();
        FluidHatches.init();
        MultiFluidHatches.init();
        EnergyHatches.init();
        LaserHatches.init();
        WirelessEnergyHatches.init();
    }

}
