package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureMap;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");
    public static OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_drilling_reg");
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblocks/catalytic_reformer");
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/sonicator");
    public static OrientedOverlayRenderer HYDRAULIC_FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblocks/hydraulic_fracker");
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/nanoscale_fabricator");
    public static OrientedOverlayRenderer INDUSTRIAL_ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_roaster");
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblocks/crystallization_crucible");
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblocks/cvd_unit");
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/burner_reactor");
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/cryogenic_reactor");

    public GTLiteTextures() {}

    public static void register(TextureMap textureMap) {}

    public static void preInit() {
        TextureUtils.addIconRegister(GTLiteTextures::register);
    }
}
