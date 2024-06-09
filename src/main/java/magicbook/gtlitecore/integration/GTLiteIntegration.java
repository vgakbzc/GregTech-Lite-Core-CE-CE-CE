package magicbook.gtlitecore.integration;

import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.api.utils.Mods;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeFluidOutputInfoProvider;
import magicbook.gtlitecore.integration.theoneprobe.provider.RecipeItemOutputInfoProvider;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class GTLiteIntegration {

    public static void init() {
        //  The One Probe Integration
        if (Mods.TheOneProbe.isModLoaded()) {
            if (GTLiteConfigHolder.compats.enableTOPModule) {
                GTLiteLog.logger.info("Registering The One Probe Integration...");
                ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
                oneProbe.registerProvider(new RecipeItemOutputInfoProvider());
                oneProbe.registerProvider(new RecipeFluidOutputInfoProvider());
            }
        }
    }

    public GTLiteIntegration() {}
}
