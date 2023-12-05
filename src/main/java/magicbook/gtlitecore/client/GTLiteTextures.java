package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import magicbook.gtlitecore.client.renderer.GTLiteOverlayRenderer;
import magicbook.gtlitecore.client.renderer.texture.IsaMillRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");
    public static OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");
    public static OrientedOverlayRenderer ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("machines/rocket_engine");

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
    public static OrientedOverlayRenderer FARM_OVERLAY = new OrientedOverlayRenderer("multiblocks/tree_growth_factory");

    //  GTLiteOverlayRenderer
    public static GTLiteOverlayRenderer INCONEL_625_CASING = new GTLiteOverlayRenderer("casings/inconel_625_casing");
    public static GTLiteOverlayRenderer HASTELLOY_N_CASING = new GTLiteOverlayRenderer("casings/hastelloy_n_casing");
    public static GTLiteOverlayRenderer RED_STEEL_CASING = new GTLiteOverlayRenderer("casings/red_steel_casing_top");
    public static GTLiteOverlayRenderer ADVANCED_INVAR_CASING = new GTLiteOverlayRenderer("casings/advanced_invar_casing");
    public static GTLiteOverlayRenderer ADVANCED_ALUMINIUM_CASING = new GTLiteOverlayRenderer("casings/advanced_aluminium_casing");
    public static GTLiteOverlayRenderer TALONITE_CASING = new GTLiteOverlayRenderer("casings/talonite_casing");
    public static GTLiteOverlayRenderer NAQUADRIA_CASING = new GTLiteOverlayRenderer("casings/naquadria_casing");
    public static GTLiteOverlayRenderer HASTELLOY_X78_CASING = new GTLiteOverlayRenderer("casings/hastelloy_x78_casing");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK1 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk1");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK2 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk2");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK3 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk3");
    public static GTLiteOverlayRenderer IRIDIUM_CASING = new GTLiteOverlayRenderer("casings/iridium_casing");
    public static GTLiteOverlayRenderer FARM_CASING = new GTLiteOverlayRenderer("casings/aseptic_farm_casing");

    public static GTLiteOverlayRenderer MULTIPART_GRIND_BALL_HATCH = new GTLiteOverlayRenderer("multiparts/overlay_grind_ball_hatch");

    //  Custom Renderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();

    //  Multi Renderer
    public static TextureAtlasSprite HALO;
    public static TextureAtlasSprite HALO_NOISE;
    public static TextureAtlasSprite[] COSMIC;
    public static TextureAtlasSprite COSMIC_0;
    public static TextureAtlasSprite COSMIC_1;
    public static TextureAtlasSprite COSMIC_2;
    public static TextureAtlasSprite COSMIC_3;
    public static TextureAtlasSprite COSMIC_4;
    public static TextureAtlasSprite COSMIC_5;
    public static TextureAtlasSprite COSMIC_6;
    public static TextureAtlasSprite COSMIC_7;
    public static TextureAtlasSprite COSMIC_8;
    public static TextureAtlasSprite COSMIC_9;

    public GTLiteTextures() {}

    public static void register(TextureMap textureMap) {

        HALO = textureMap.registerSprite(gtliteId("items/halo"));
        HALO_NOISE = textureMap.registerSprite(gtliteId("items/halo_noise"));
        COSMIC_0 = textureMap.registerSprite(gtliteId("shader/cosmic_0"));
        COSMIC_1 = textureMap.registerSprite(gtliteId("shader/cosmic_1"));
        COSMIC_2 = textureMap.registerSprite(gtliteId("shader/cosmic_2"));
        COSMIC_3 = textureMap.registerSprite(gtliteId("shader/cosmic_3"));
        COSMIC_4 = textureMap.registerSprite(gtliteId("shader/cosmic_4"));
        COSMIC_5 = textureMap.registerSprite(gtliteId("shader/cosmic_5"));
        COSMIC_6 = textureMap.registerSprite(gtliteId("shader/cosmic_6"));
        COSMIC_7 = textureMap.registerSprite(gtliteId("shader/cosmic_7"));
        COSMIC_8 = textureMap.registerSprite(gtliteId("shader/cosmic_8"));
        COSMIC_9 = textureMap.registerSprite(gtliteId("shader/cosmic_9"));
        COSMIC = new TextureAtlasSprite[] {
                COSMIC_0,
                COSMIC_1,
                COSMIC_2,
                COSMIC_3,
                COSMIC_4,
                COSMIC_5,
                COSMIC_6,
                COSMIC_7,
                COSMIC_8,
                COSMIC_9
        };
    }

    public static void preInit() {
        TextureUtils.addIconRegister(GTLiteTextures::register);
    }
}
