package magicbook.gtlitecore.api.unification;

import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix;

public class OrePrefixAddition {
    public static void init() {
        MetaItems.addOrePrefix(GTLiteOrePrefix.milled);
        MetaItems.addOrePrefix(GTLiteOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GTLiteOrePrefix.boule);
        MetaItems.addOrePrefix(GTLiteOrePrefix.swarm);
        MetaItems.addOrePrefix(GTLiteOrePrefix.nanotube);
        MetaItems.addOrePrefix(GTLiteOrePrefix.nanosensor);
        MetaItems.addOrePrefix(GTLiteOrePrefix.singularity);
    }
}
