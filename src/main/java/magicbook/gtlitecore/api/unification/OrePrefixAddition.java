package magicbook.gtlitecore.api.unification;

import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix;

public class OrePrefixAddition {
    public static void init() {
        MetaItems.addOrePrefix(GTLiteOrePrefix.milled);
        MetaItems.addOrePrefix(GTLiteOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GTLiteOrePrefix.boule);
    }
}
