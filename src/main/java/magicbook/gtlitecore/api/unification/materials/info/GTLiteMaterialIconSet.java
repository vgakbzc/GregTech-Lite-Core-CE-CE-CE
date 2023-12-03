package magicbook.gtlitecore.api.unification.materials.info;

import magicbook.gtlitecore.client.GTLiteTextures;
import magicbook.gtlitecore.common.items.behaviors.renderer.HaloRenderItemBehavior;

public class GTLiteMaterialIconSet {

    public static final MaterialIconSetWithRenderer CUSTOM_INFINITY = new MaterialIconSetWithRenderer("infinity", null, true, new HaloRenderItemBehavior(10, 0xFF000000, () -> GTLiteTextures.HALO, true));
}
