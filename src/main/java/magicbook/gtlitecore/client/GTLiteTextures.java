package magicbook.gtlitecore.client;

import codechicken.lib.texture.TextureUtils;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOrientedCubeRenderer;
import magicbook.gtlitecore.client.renderer.GTLiteOverlayRenderer;
import magicbook.gtlitecore.client.renderer.texture.IndustrialCentrifugeRenderer;
import magicbook.gtlitecore.client.renderer.texture.IsaMillRenderer;
import magicbook.gtlitecore.client.renderer.texture.TurbineMixerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.gtliteId;

public class GTLiteTextures {

    //  Oriented Overlay Renderer
    public static OrientedOverlayRenderer CHEMICAL_DRYER_OVERLAY = new OrientedOverlayRenderer("machines/chemical_dryer");
    public static OrientedOverlayRenderer NAQUADAH_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor");
    public static OrientedOverlayRenderer ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("machines/rocket_engine");
    public static OrientedOverlayRenderer BIO_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/bio_reactor");
    public static OrientedOverlayRenderer CONDENSER_OVERLAY = new OrientedOverlayRenderer("machines/condenser");
    public static OrientedOverlayRenderer SIMULATOR_OVERLAY = new OrientedOverlayRenderer("machines/simulator");
    public static OrientedOverlayRenderer BIOMASS_GENERATOR_OVERLAY = new OrientedOverlayRenderer("machines/biomass_generator");

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
    public static OrientedOverlayRenderer VIRTUAL_COSMOS_SIMULATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/virtual_cosmos_simulator");
    public static OrientedOverlayRenderer COLLIDER_OVERLAY = new OrientedOverlayRenderer("multiblocks/collider");
    public static OrientedOverlayRenderer DIMENSIONAL_OSCILLATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/dimensional_oscillator");
    public static OrientedOverlayRenderer STELLAR_FURNACE_OVERLAY = new OrientedOverlayRenderer("multiblocks/stellar_furnace");
    public static OrientedOverlayRenderer DECAY_GENERATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/decay_generator");
    public static OrientedOverlayRenderer SUPRACHRONAL_ASSEMBLY_LINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/suprachronal_assembly_line");
    public static OrientedOverlayRenderer SPACE_ELEVATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/space_elevator");
    public static OrientedOverlayRenderer LARGE_PROCESSING_FACTORY_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_processing_factory");
    public static OrientedOverlayRenderer MEGA_TURBINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/mega_turbine");
    public static OrientedOverlayRenderer NEUTRAL_NETWORK_NEXUS_OVERLAY = new OrientedOverlayRenderer("multiblocks/neutral_network_nexus");
    public static OrientedOverlayRenderer QUANTUM_FORCE_TRANSFORMER_OVERLAY = new OrientedOverlayRenderer("multiblocks/quantum_force_transformer");
    public static OrientedOverlayRenderer TURBINE_MIXER_OVERLAY = new OrientedOverlayRenderer("multiblocks/turbine_mixer");
    public static OrientedOverlayRenderer INDUSTRIAL_CENTRIFUGE_OVERLAY = new OrientedOverlayRenderer("multiblocks/industrial_centrifuge");
    public static OrientedOverlayRenderer COKING_TOWER_OVERLAY = new OrientedOverlayRenderer("multiblocks/coking_tower");
    public static OrientedOverlayRenderer BIOWARE_SIMULATOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/bioware_simulator");
    public static OrientedOverlayRenderer LARGE_ROCKET_ENGINE_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_rocket_engine");
    public static OrientedOverlayRenderer ALGAE_CULTURE_TANK_OVERLAY = new OrientedOverlayRenderer("multiblocks/algae_culture_tank");
    public static OrientedOverlayRenderer LARGE_BIO_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblocks/large_bio_reactor");
    public static OrientedOverlayRenderer ELECTROMAGNETIC_SEPARATION_PLANT_OVERLAY = new OrientedOverlayRenderer("multiblocks/electromagnetic_separation_plant");
    public static OrientedOverlayRenderer DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_OVERLAY = new OrientedOverlayRenderer("multiblocks/dimensionally_transcendent_plasma_forge");
    public static OrientedOverlayRenderer LIGHTNING_ROD_OVERLAY = new OrientedOverlayRenderer("generators/lightning_rod");

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
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK4 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk4");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK5 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk5");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK6 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk6");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK7 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk7");
    public static GTLiteOverlayRenderer PRECISE_ASSEMBLER_CASING_MK8 = new GTLiteOverlayRenderer("casings/precise_assembler_casing_mk8");
    public static GTLiteOverlayRenderer IRIDIUM_CASING = new GTLiteOverlayRenderer("casings/iridium_casing");
    public static GTLiteOverlayRenderer FARM_CASING = new GTLiteOverlayRenderer("casings/aseptic_farm_casing");
    public static GTLiteOverlayRenderer HYPER_CASING = new GTLiteOverlayRenderer("casings/hyper_casing");
    public static GTLiteOverlayRenderer ADVANCED_HYPER_CASING = new GTLiteOverlayRenderer("casings/advanced_hyper_casing");
    public static GTLiteOverlayRenderer HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/high_energy_casing");
    public static GTLiteOverlayRenderer ADVANCED_HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/advanced_high_energy_casing");
    public static GTLiteOverlayRenderer ULTIMATE_HIGH_ENERGY_CASING = new GTLiteOverlayRenderer("casings/ultimate_high_energy_casing");
    public static GTLiteOverlayRenderer TRITANIUM_CASING = new GTLiteOverlayRenderer("casings/tritanium_casing");
    public static GTLiteOverlayRenderer ZIRCONIUM_CARBIDE_CASING = new GTLiteOverlayRenderer("casings/zirconium_carbide_casing");
    public static GTLiteOverlayRenderer SPACE_ELEVATOR_CASING = new GTLiteOverlayRenderer("casings/spaces/basic_casing");
    public static GTLiteOverlayRenderer STABALLOY_CASING = new GTLiteOverlayRenderer("casings/staballoy_casing");
    public static GTLiteOverlayRenderer QUANTUM_CASING = new GTLiteOverlayRenderer("casings/quantum_casing");
    public static GTLiteOverlayRenderer BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = new GTLiteOverlayRenderer("casings/basic_photolithographic_framework_casing");
    public static GTLiteOverlayRenderer HG_1223_CASING = new GTLiteOverlayRenderer("casings/hg_1223_casing");
    public static GTLiteOverlayRenderer EGLIN_STEEL_CASING = new GTLiteOverlayRenderer("casings/eglin_steel_casing");
    public static GTLiteOverlayRenderer INCONEL_792_CASING = new GTLiteOverlayRenderer("casings/inconel_792_casing");
    public static GTLiteOverlayRenderer AUSTENITIC_STAINLESS_STEEL_CASING = new GTLiteOverlayRenderer("casings/austenitic_stainless_steel_casing");
    public static GTLiteOverlayRenderer MAR_M200_STEEL_CASING = new GTLiteOverlayRenderer("casings/mar_m200_steel_casing");
    public static GTLiteOverlayRenderer BIOWARE_COMPUTER_CASING = new GTLiteOverlayRenderer("casings/bioware_computer_casing_top");
    public static GTLiteOverlayRenderer ADVANCED_BIOWARE_COMPUTER_CASING = new GTLiteOverlayRenderer("casings/bioware_computer_casing");
    public static GTLiteOverlayRenderer HSS_S_CASING = new GTLiteOverlayRenderer("casings/hss_s_casing");
    public static GTLiteOverlayRenderer EINSTEINIUM_CASING = new GTLiteOverlayRenderer("casings/einsteinium_casing");
    public static GTLiteOverlayRenderer NITINOL_60_CASING = new GTLiteOverlayRenderer("casings/nitinol_60_casing");
    public static GTLiteOverlayRenderer FERMIUM_CASING = new GTLiteOverlayRenderer("casings/fermium_casing");
    public static GTLiteOverlayRenderer PROTACTINIUM_CASING = new GTLiteOverlayRenderer("casings/protactinium_casing");
    public static GTLiteOverlayRenderer MENDELEVIUM_CASING = new GTLiteOverlayRenderer("casings/mendelevium_casing");
    public static GTLiteOverlayRenderer HSS_G_CASING = new GTLiteOverlayRenderer("casings/hss_g_casing");
    public static GTLiteOverlayRenderer INCOLOY_MA_813_CASING = new GTLiteOverlayRenderer("casings/incoloy_ma_813_casing");
    public static GTLiteOverlayRenderer URANIUM_CASING = new GTLiteOverlayRenderer("casings/uranium_casing");
    public static GTLiteOverlayRenderer POTIN_CASING = new GTLiteOverlayRenderer("casings/potin_casing");
    public static GTLiteOverlayRenderer PLUTONIUM_CASING = new GTLiteOverlayRenderer("casings/plutonium_casing");
    public static GTLiteOverlayRenderer BLACK_STEEL_CASING = new GTLiteOverlayRenderer("casings/black_steel_casing");
    public static GTLiteOverlayRenderer TUMBAGA_CASING = new GTLiteOverlayRenderer("casings/tumbaga_casing");
    public static GTLiteOverlayRenderer RHODIUM_PLATED_PALLADIUM_CASING = new GTLiteOverlayRenderer("casings/rhodium_plated_palladium_casing");
    public static GTLiteOverlayRenderer NIOBIUM_TITANIUM_CASING = new GTLiteOverlayRenderer("casings/niobium_titanium_casing");
    public static GTLiteOverlayRenderer BOTMIUM_CASING = new GTLiteOverlayRenderer("casings/botmium_casing");
    public static GTLiteOverlayRenderer LAURENIUM_CASING = new GTLiteOverlayRenderer("casings/laurenium_casing");
    public static GTLiteOverlayRenderer INCOLOY_DS_CASING = new GTLiteOverlayRenderer("casings/incoloy_ds_casing");
    public static GTLiteOverlayRenderer MARAGING_STEEL_250_CASING = new GTLiteOverlayRenderer("casings/maraging_steel_250_casing");
    public static GTLiteOverlayRenderer RURIDIT_CASING = new GTLiteOverlayRenderer("casings/ruridit_casing");
    public static GTLiteOverlayRenderer OSMIRIDIUM_CASING = new GTLiteOverlayRenderer("casings/osmiridium_casing");
    public static GTLiteOverlayRenderer FLUXED_ELECTRUM_CASING = new GTLiteOverlayRenderer("casings/fluxed_electrum_casing");
    public static GTLiteOverlayRenderer RHODIUM_CASING = new GTLiteOverlayRenderer("casings/rhodium_casing");
    public static GTLiteOverlayRenderer DIMENSIONAL_BRIDGE_CASING = new GTLiteOverlayRenderer("casings/dimensional_bridge_casing");
    public static GTLiteOverlayRenderer NAQUADAH_ALLOY_CASING = new GTLiteOverlayRenderer("casings/naquadah_alloy_casing");
    public static GTLiteOverlayRenderer INCOLOY_020_CASING = new GTLiteOverlayRenderer("casings/incoloy_020_casing");
    public static GTLiteOverlayRenderer TANTALUM_CARBIDE_CASING = new GTLiteOverlayRenderer("casings/tantalum_carbide_casing");
    public static GTLiteOverlayRenderer MULTIPART_GRIND_BALL_HATCH = new GTLiteOverlayRenderer("multiparts/overlay_grind_ball_hatch");

    //  SimpleOrientedCubeRenderer
    public static SimpleOrientedCubeRenderer ADVANCED_FILTER_IRIDIUM_FRONT = new SimpleOrientedCubeRenderer("casings/advanced_filter_iridium_front");
    public static SimpleOrientedCubeRenderer ADVANCED_GRATE_OSMIRIDIUM_FRONT = new SimpleOrientedCubeRenderer("casings/advanced_grate_osmiridium_front");
    public static SimpleOrientedCubeRenderer FORCE_FIELD_CONSTRAINED_CASING = new SimpleOrientedCubeRenderer("casings/force_field_constrained_casing");

    //  Custom Renderer
    public static IsaMillRenderer ISA_MILL = new IsaMillRenderer();
    public static TurbineMixerRenderer TURBINE_MIXER = new TurbineMixerRenderer();
    public static IndustrialCentrifugeRenderer INDUSTRIAL_CENTRIFUGE = new IndustrialCentrifugeRenderer();

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
