package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureMap;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");

    public GTLiteTextures() {}

    public static void register(TextureMap textureMap) {}

    public static void preInit() {
        TextureUtils.addIconRegister(GTLiteTextures::register);
    }
}
