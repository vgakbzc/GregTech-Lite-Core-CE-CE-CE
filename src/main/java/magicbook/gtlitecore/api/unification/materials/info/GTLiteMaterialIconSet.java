package magicbook.gtlitecore.api.unification.materials.info;

import gregtech.api.unification.material.info.MaterialIconSet;
import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.items.behaviors.renderer.HaloRenderItemBehavior;

public class GTLiteMaterialIconSet {

    public static final MaterialIconSetWithRenderer CUSTOM_INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));
    public static final MaterialIconSet CUSTOM_SPACETIME = new MaterialIconSet("spacetime", null, true);
    public static final MaterialIconSet CUSTOM_DEGENERATE_RHENIUM = new MaterialIconSet("degenerate_rhenium", null, true);
    public static final MaterialIconSet CUSTOM_LEGENDARIUM = new MaterialIconSet("legendarium", null, true);
    public static final MaterialIconSet CUSTOM_MHCSM = new MaterialIconSet("mhcsm", null, true);
    public static final MaterialIconSet CUSTOM_ETERNITY = new MaterialIconSet("eternity", null, true);
    public static final MaterialIconSet CUSTOM_HYPOGEN = new MaterialIconSet("hypogen", null, true);
    public static final MaterialIconSet CUSTOM_COSMIC_NEUTRONIUM = new MaterialIconSet("cosmic_neutronium", null, true);
}