package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import magicbook.gtlitecore.client.renderer.GTLiteOverlayRenderer;
import magicbook.gtlitecore.client.renderer.texture.IsaMillRenderer;
import net.minecraft.client.renderer.texture.TextureMap;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");
    public static OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");

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
    public static OrientedOverlayRenderer ISA_MILL_OVERLAY = new OrientedOverlayRenderer("multiblocks/isa_mill");

    //  GTLiteOverlayRenderer
    public static GTLiteOverlayRenderer INCONEL_625_CASING = new GTLiteOverlayRenderer("casings/inconel_625_casing");
    public static GTLiteOverlayRenderer HASTELLOY_N_CASING = new GTLiteOverlayRenderer("casings/hastelloy_n_casing");
    public static GTLiteOverlayRenderer RED_STEEL_CASING = new GTLiteOverlayRenderer("casings/red_steel_casing_top");
    public static GTLiteOverlayRenderer MULTIPART_GRIND_BALL_HATCH = new GTLiteOverlayRenderer("multiparts/overlay_grind_ball_hatch");

    //  Custom Renderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();


    public GTLiteTextures() {}

    public static void register(TextureMap textureMap) {}

    public static void preInit() {
        TextureUtils.addIconRegister(GTLiteTextures::register);
    }
}
