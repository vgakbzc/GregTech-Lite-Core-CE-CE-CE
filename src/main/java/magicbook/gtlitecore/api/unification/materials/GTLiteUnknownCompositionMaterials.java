package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.api.annotation.MaterialIDRange;
import net.minecraft.util.text.TextFormatting;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider.getID;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.DISABLE_CRYSTALLIZATION;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.FRONT;

/**
 * Unknown Composition Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class.
 * </p>
 *
 * @since 2.8.7-beta
 */
@MaterialIDRange(startID = 18000, endID = 20000)
public class GTLiteUnknownCompositionMaterials {

    public static void register() {
        //  18000 Fracturing Fluid
        FracuringFluid = new Material.Builder(getID(), gregtechId("fracturing_fluid"))
                .liquid()
                .color(0x96D6D5)
                .build();

        //  18001 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = new Material.Builder(getID(), gregtechId("rare_earth_hydroxides_solution"))
                .liquid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        //  18002 Rare Earth Chlorides Solution
        RareEarthChloridesSolution = new Material.Builder(getID(), gregtechId("rare_earth_chlorides_solution"))
                .liquid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        //  18003 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = new Material.Builder(getID(), gregtechId("la_pr_nd_ce_oxides_solution"))
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        //  18004 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = new Material.Builder(getID(), gregtechId("sc_eu_gd_sm_oxides_solution"))
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        //  18005 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = new Material.Builder(getID(), gregtechId("y_tb_dy_ho_oxides_solution"))
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        //  18006 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = new Material.Builder(getID(), gregtechId("er_tm_yb_lu_oxides_solution"))
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();
      
        //  18007 Bedrock
        Bedrock = new Material.Builder(getID(), gregtechId("bedrock"))
                .dust()
                .liquid()
                .color(0x404040)
                .iconSet(ROUGH)
                .build();

        //  18008 Bedrock Smoke
        BedrockSmoke = new Material.Builder(getID(), gregtechId("bedrock_smoke"))
                .gas()
                .color(0x525252)
                .build();

        //  18009 Bedrock Soot Solution
        BedrockSootSolution = new Material.Builder(getID(), gregtechId("bedrock_soot_solution"))
                .liquid()
                .color(0x1E2430)
                .build();

        //  18010 Clean Bedrock Solution
        CleanBedrockSolution = new Material.Builder(getID(), gregtechId("clean_bedrock_solution"))
                .liquid()
                .color(0xA89F9E)
                .build();

        //  18011 Heavy Bedrock Smoke
        HeavyBedrockSmoke = new Material.Builder(getID(), gregtechId("heavy_bedrock_smoke"))
                .gas()
                .color(0x242222)
                .build();

        //  18012 Medium Bedrock Smoke
        MediumBedrockSmoke = new Material.Builder(getID(), gregtechId("medium_bedrock_smoke"))
                .gas()
                .color(0x2E2C2C)
                .build();

        //  18013 Light Bedrock Smoke
        LightBedrockSmoke = new Material.Builder(getID(), gregtechId("light_bedrock_smoke"))
                .gas()
                .color(0x363333)
                .build();

        //  18014 Ultralight Bedrock Smoke
        UltralightBedrockSmoke = new Material.Builder(getID(), gregtechId("ultralight_bedrock_smoke"))
                .gas()
                .color(0x403D3D)
                .build();

        //  18015 Heavy Taranium Gas
        HeavyTaraniumGas = new Material.Builder(getID(), gregtechId("heavy_taranium_gas"))
                .gas()
                .color(0x262626)
                .build();

        //  18016 Medium Taranium Gas
        MediumTaraniumGas = new Material.Builder(getID(), gregtechId("medium_taranium_gas"))
                .gas()
                .color(0x313131)
                .build();

        //  18017 Light Taranium Gas
        LightTaraniumGas = new Material.Builder(getID(), gregtechId("light_taranium_gas"))
                .gas()
                .color(0x404040)
                .build();

        //  18018 Bedrock Gas
        BedrockGas = new Material.Builder(getID(), gregtechId("bedrock_gas"))
                .gas()
                .color(0x575757)
                .build();

        //  18019 Cracked Heavy Taranium
        CrackedHeavyTaranium = new Material.Builder(getID(), gregtechId("cracked_heavy_taranium"))
                .liquid()
                .color(0x1F2B2E)
                .build();

        //  18020 Cracked Medium Taranium
        CrackedMediumTaranium = new Material.Builder(getID(), gregtechId("cracked_medium_taranium"))
                .liquid()
                .color(0x29393D)
                .build();

        //  18021 Cracked Light Taranium
        CrackedLightTaranium = new Material.Builder(getID(), gregtechId("cracked_light_taranium"))
                .liquid()
                .color(0x374C52)
                .build();

        //  18022 Enriched Bedrock Soot Solution
        EnrichedBedrockSootSolution = new Material.Builder(getID(), gregtechId("enriched_bedrock_soot_solution"))
                .liquid()
                .color(0x280C26)
                .build();

        //  18023 Clean Enriched Bedrock Solution
        CleanEnrichedBedrockSolution = new Material.Builder(getID(), gregtechId("clean_enriched_bedrock_solution"))
                .liquid()
                .color(0x828C8C)
                .build();

        //  18024 Heavy Enriched Bedrock Smoke
        HeavyEnrichedBedrockSmoke = new Material.Builder(getID(), gregtechId("heavy_enriched_bedrock_smoke"))
                .gas()
                .color(0x1A2222)
                .build();

        //  18025 Medium Enriched Bedrock Smoke
        MediumEnrichedBedrockSmoke = new Material.Builder(getID(), gregtechId("medium_enriched_bedrock_smoke"))
                .gas()
                .color(0x1E2C2C)
                .build();

        //  18026 Light Enriched Bedrock Smoke
        LightEnrichedBedrockSmoke = new Material.Builder(getID(), gregtechId("light_enriched_bedrock_smoke"))
                .gas()
                .color(0x163333)
                .build();

        //  18027 Heavy Enriched Taranium Gas
        HeavyEnrichedTaraniumGas = new Material.Builder(getID(), gregtechId("heavy_enriched_taranium_gas"))
                .gas()
                .color(0x1F2626)
                .build();

        //  18028 Medium Enriched Taranium Gas
        MediumEnrichedTaraniumGas = new Material.Builder(getID(), gregtechId("medium_enriched_taranium_gas"))
                .gas()
                .color(0x1F3131)
                .build();

        //  18029 Light Enriched Taranium Gas
        LightEnrichedTaraniumGas = new Material.Builder(getID(), gregtechId("light_enriched_taranium_gas"))
                .gas()
                .color(0x1F4040)
                .build();

        //  18030 Cracked Heavy Enriched Taranium
        CrackedHeavyEnrichedTaranium = new Material.Builder(getID(), gregtechId("cracked_heavy_enriched_taranium"))
                .liquid()
                .color(0x2E1F2E)
                .build();

        //  18031 Cracked Medium Enriched Taranium
        CrackedMediumEnrichedTaranium = new Material.Builder(getID(), gregtechId("cracked_medium_enriched_taranium"))
                .liquid()
                .color(0x29393D)
                .build();

        //  18032 Cracked Light Enriched Taranium
        CrackedLightEnrichedTaranium = new Material.Builder(getID(), gregtechId("cracked_light_enriched_taranium"))
                .liquid()
                .color(0x374C52)
                .build();

        //  18033 Crude Naquadah Fuel
        CrudeNaquadahFuel = new Material.Builder(getID(), gregtechId("crude_naquadah_fuel"))
                .liquid()
                .color(0x077F4E)
                .iconSet(DULL)
                .build();

        //  18034 Heavy Naquadah Fuel
        HeavyNaquadahFuel = new Material.Builder(getID(), gregtechId("heavy_naquadah_fuel"))
                .liquid()
                .color(0x088C56)
                .build();

        //  18035 Medium Naquadah Fuel
        MediumNaquadahFuel = new Material.Builder(getID(), gregtechId("medium_naquadah_fuel"))
                .liquid()
                .color(0x09A566)
                .build();

        //  18036 Light Naquadah Fuel
        LightNaquadahFuel = new Material.Builder(getID(), gregtechId("light_naquadah_fuel"))
                .liquid()
                .color(0x0BBF75)
                .build();

        //  18037 Naquadah Gas
        NaquadahGas = new Material.Builder(getID(), gregtechId("naquadah_gas"))
                .gas()
                .color(0x0CD985)
                .build();

        //  18038 Energetic Naquadria
        EnergeticNaquadria = new Material.Builder(getID(), gregtechId("energetic_naquadria"))
                .liquid()
                .color(0x202020)
                .build()
                .setFormula("Nq?", false);

        //  18039 Heavy Hyper Fuel
        HeavyHyperFuel = new Material.Builder(getID(), gregtechId("heavy_hyper_fuel"))
                .liquid()
                .color(0x1E5064)
                .build();

        //  18040 Medium Hyper Fuel
        MediumHyperFuel = new Material.Builder(getID(), gregtechId("medium_hyper_fuel"))
                .liquid()
                .color(0xDC0A0A)
                .build();

        //  18041 Light Hyper Fuel
        LightHyperFuel = new Material.Builder(getID(), gregtechId("light_hyper_fuel"))
                .liquid()
                .color(0x8C148C)
                .build();

        //  18042 Almandine Front
        AlmandineFront = new Material.Builder(getID(), gregtechId("almandine_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Almandine.getMaterialRGB())
                .iconSet(FRONT)
                .components(Almandine.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18043 Chalcopyrite Front
        ChalcopyriteFront = new Material.Builder(getID(), gregtechId("chalcopyrite_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Chalcopyrite.getMaterialRGB())
                .iconSet(FRONT)
                .components(Chalcopyrite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18044 Monazite Front
        MonaziteFront = new Material.Builder(getID(), gregtechId("monazite_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Monazite.getMaterialRGB())
                .iconSet(FRONT)
                .components(Monazite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18045 Grossular Front
        GrossularFront = new Material.Builder(getID(), gregtechId("grossular_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Grossular.getMaterialRGB())
                .iconSet(FRONT)
                .components(Grossular.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18046 Nickel Front
        NickelFront = new Material.Builder(getID(), gregtechId("nickel_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Nickel.getMaterialRGB())
                .iconSet(FRONT)
                .components(Nickel, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18047 Platinum Front
        PlatinumFront = new Material.Builder(getID(), gregtechId("platinum_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Platinum.getMaterialRGB())
                .iconSet(FRONT)
                .components(Platinum, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18048 Pyrope Front
        PyropeFront = new Material.Builder(getID(), gregtechId("pyrope_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Pyrope.getMaterialRGB())
                .iconSet(FRONT)
                .components(Pyrope.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18049 Redstone Front
        RedstoneFront = new Material.Builder(getID(), gregtechId("redstone_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Redstone.getMaterialRGB())
                .iconSet(FRONT)
                .components(Redstone.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18050 Spessartine Front
        SpessartineFront = new Material.Builder(getID(), gregtechId("spessartine_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Spessartine.getMaterialRGB())
                .iconSet(FRONT)
                .components(Spessartine.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18051 Sphalerite Front
        SphaleriteFront = new Material.Builder(getID(), gregtechId("sphalerite_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Sphalerite.getMaterialRGB())
                .iconSet(FRONT)
                .components(Sphalerite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18052 Pentlandite Front
        PentlanditeFront = new Material.Builder(getID(), gregtechId("pentlandite_front"))
                .liquid(new FluidBuilder().temperature(283))
                .color(Pentlandite.getMaterialRGB())
                .iconSet(FRONT)
                .components(Pentlandite.getMaterialComponents())
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18053 Blazing Pyrotheum
        BlazingPyrotheum = new Material.Builder(getID(), gregtechId("blazing_pyrotheum"))
                .liquid(new FluidBuilder().temperature(8000).customStill().customFlow())
                .components(Blaze, 2, Redstone, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18054 Gelid Cryotheum
        GelidCryotheum = new Material.Builder(getID(), gregtechId("gelid_cryotheum"))
                .liquid(new FluidBuilder().temperature(8).customStill().customFlow())
                .color(0x40B8FB)
                .components(Ice, 2, Electrotine, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  18055 Rich Nitrogen Mixture
        RichNitrogenMixture = new Material.Builder(getID(), gregtechId("rich_nitrogen_mixture"))
                .gas()
                .color(0x6891D8)
                .build();

        //  18056 Rich Ammonia Mixture
        RichAmmoniaMixture = new Material.Builder(getID(), gregtechId("rich_ammonia_mixture"))
                .liquid()
                .color(0x708ACD)
                .build();

        //  18057 Iodized Brine
        IodizedBrine = new Material.Builder(getID(), gregtechId("iodized_brine"))
                .liquid()
                .color(0x525246)
                .build()
                .setFormula("I?", false);

        //  18058 Iodine Brine Mixture
        IodineBrineMixture = new Material.Builder(getID(), gregtechId("iodine_brine_mixture"))
                .liquid()
                .color(0x525234)
                .build()
                .setFormula("I?Cl", false);

        //  18059 Brominated Brine
        BrominatedBrine = new Material.Builder(getID(), gregtechId("brominated_brine"))
                .liquid()
                .color(0xA9A990)
                .build()
                .setFormula("Br?", false);

        //  24039 Iodine Slurry
        IodineSlurry = new Material.Builder(getID(), gregtechId("iodine_slurry"))
                .liquid()
                .color(0x292923)
                .build()
                .setFormula("I?", false);

        //  24040 Acidic Brominated Brine
        AcidicBrominatedBrine = new Material.Builder(getID(), gregtechId("acidic_brominated_brine"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0xC6A76F)
                .build()
                .setFormula("Br?(H2SO4)Cl", true);

        //  24041 Bromine Sulfate Solution
        BromineSulfateSolution = new Material.Builder(getID(), gregtechId("bromine_sulfate_solution"))
                .liquid()
                .color(0xCC9966)
                .build()
                .setFormula("H2SO4Br(H2O)Cl2", true);

        //  24042 Overheated Bromine Sulfate Gas
        OverheatedBromineSulfateSolution = new Material.Builder(getID(), gregtechId("overheated_bromine_sulfate_gas"))
                .gas()
                .color(0xC69337)
                .iconSet(DULL)
                .build()
                .setFormula("H2SO4Br(H2O)2Cl2", true);

        //  24043 Wet Bromine
        WetBromine = new Material.Builder(getID(), gregtechId("wet_bromine"))
                .gas()
                .color(0xDB5C5C)
                .iconSet(DULL)
                .build()
                .setFormula("Br(H2O)", true);

        //  24044 Debrominated Water
        DebrominatedWater = new Material.Builder(getID(), gregtechId("debrominated_water"))
                .liquid()
                .color(0x24A3A3)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();

        //  24045 BZ Medium
        BZMedium = new Material.Builder(getID(), gregtechId("bz_medium"))
                .liquid()
                .color(10681653)
                .build();

        //  24046 EDP
        EDP = new Material.Builder(getID(), gregtechId("edp"))
                .liquid()
                .color(16514839)
                .build();

        //  24047 Sodio Indene
        SodioIndene = new Material.Builder(getID(), gregtechId("sodio_indene"))
                .liquid()
                .color(0x1D1C24)
                .build();

        //  24048 Steam Cracked Sodio Indene
        SteamCrackedSodioIndene = new Material.Builder(getID(), gregtechId("steam_cracked_sodio_indene"))
                .liquid(new FluidBuilder().temperature(1105))
                .color(0x1C1A29)
                .build();

        //  24049 MethylamineMixture
        MethylamineMixture = new Material.Builder(getID(), gregtechId("methylamine_mixture"))
                .liquid()
                .color(0xAA4400)
                .build();

        //  24050 Phosphorene Solution
        PhosphoreneSolution = new Material.Builder(getID(), gregtechId("phosphorene_solution"))
                .liquid()
                .color(0x465966)
                .build();

        //  24051 RP-1 Rocket Fuel
        RP1RocketFuel = new Material.Builder(getID(), gregtechId("rp_1_rocket_fuel"))
                .liquid()
                .color(0xFB2A08)
                .components(CoalTar, 1, Oxygen, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24052 Dense Hydrazine Mixture Fuel
        DenseHydrazineMixtureFuel = new Material.Builder(getID(), gregtechId("dense_hydrazine_mixture_fuel"))
                .liquid()
                .color(0x912565)
                .components(Dimethylhydrazine, 1, Methanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24053 Methylhydrazine Nitrate Rocket Fuel
        MethylhydrazineNitrateRocketFuel = new Material.Builder(getID(), gregtechId("methylhydrazine_nitrate_rocket_fuel"))
                .liquid()
                .color(0x607186)
                .components(Methylhydrazine, 1, Tetranitromethane, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24054 Dragon Breath
        DragonBreath = new Material.Builder(getID(), gregtechId("dragon_breath"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x9400D3)
                .build()
                .setFormula("Dc?", false);

        //  24055 Concentrate Dragon Breath
        ConcentrateDragonBreath = new Material.Builder(getID(), gregtechId("concentrate_dragon_breath"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x9400D3)
                .build()
                .setFormula("Dc2?", true);

        //  24056 Dragon Blood
        DragonBlood = new Material.Builder(getID(), gregtechId("dragon_blood"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID).temperature(10435))
                .plasma()
                .color(0xDC2814)
                .iconSet(DULL)
                .build()
                .setFormula("*Dc*Rn?", true);

        //  24057 Chalcogen Anode Mud
        ChalcogenAnodeMud = new Material.Builder(getID(), gregtechId("chalcogen_anode_mud"))
                .dust()
                .color(0x8A3324)
                .iconSet(FINE)
                .build();

        //  24058 Molybdenum Flue
        MolybdenumFlue = new Material.Builder(getID(), gregtechId("molybdenum_flue"))
                .gas()
                .color(0x39194A)
                .build();

        //  24059 Trace Rhenium Flue
        TraceRheniumFlue = new Material.Builder(getID(), gregtechId("trace_rhenium_flue"))
                .gas()
                .color(0x96D6D5)
                .build();

        //  24061 Leached Turpentine
        LeachedTurpentine = new Material.Builder(getID(), gregtechId("leached_turpentine"))
                .liquid()
                .color(0x330D16)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("C10H16?");

        //  24062 Steam Cracked Turpentine
        SteamCrackedTurpentine = new Material.Builder(getID(), gregtechId("steam_cracked_turpentine"))
                .liquid()
                .color(0x634D56)
                .build();

        //  24063 Chlorinated Solvents
        ChlorinatedSolvents = new Material.Builder(getID(), gregtechId("chlorinated_solvents"))
                .liquid()
                .color(0x40804c)
                .components(Carbon, 2, Hydrogen, 8, Chlorine, 5)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(CH4)2Cl5", true);

        //  24064 Free Electron Gas
        FreeElectronGas = new Material.Builder(getID(), gregtechId("free_electron_gas"))
                .gas()
                .color(0x507BB3)
                .build()
                .setFormula(TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET + "§ee" + TextFormatting.OBFUSCATED + "a", false);

        //  24065 Oganesson Breeding Base
        OganessonBreedingBase = new Material.Builder(getID(), gregtechId("oganesson_breeding_base"))
                .liquid()
                .color(0xA65A7F)
                .components(Oganesson, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24066 Quasi-fissioning Plasma
        QuasifissioningPlasma = new Material.Builder(getID(), gregtechId("quasi_fissioning_plasma"))
                .plasma(new FluidBuilder().temperature(230490))
                .color(0xB0A2C3)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24067 Flerovium-Ytterbium Plasma
        FleroviumYtterbiumPlasma = new Material.Builder(getID(), gregtechId("flerovium_ytterbium_plasma"))
                .plasma(new FluidBuilder().temperature(300))
                .components(Flerovium, 1, Ytterbium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24068 Radium-Radon Mixture
        RadiumRadonMixture = new Material.Builder(getID(), gregtechId("radium_radon_mixture"))
                .liquid()
                .color(Radium.getMaterialRGB() + Radon.getMaterialRGB())
                .components(Radium, 1, Radon, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24069 Scandium-Titanium Mixture
        ScandiumTitaniumMixture = new Material.Builder(getID(), gregtechId("scandium_titanium_mixture"))
                .liquid()
                .color(Scandium.getMaterialRGB() + Titanium.getMaterialRGB())
                .components(Scandium, 1, Titanium, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24070 Electrolyte Reflector Mixture
        ElectrolyteReflectorMixture = new Material.Builder(getID(), gregtechId("electrolyte_reflector_mixture"))
                .liquid(new FluidBuilder().temperature(209))
                .color(0xE62A35)
                .components(ManganeseDifluoride, 1, ZincSulfide, 1, TantalumPentoxide, 1, Rutile, 1, Ethanol, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24071 Starlight Liquid
        StarlightLiquid = new Material.Builder(getID(), gregtechId("starlight_liquid"))
                .liquid(new FluidBuilder().block().luminosity(3).customStill().customFlow().temperature(1))
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("Ax⚶?", false);

        //  24072 Celestial Crystal
        CelestialCrystal = new Material.Builder(getID(), gregtechId("celestial_crystal"))
                .gem()
                .color(0x3B48A7)
                .iconSet(CERTUS)
                .flags(DISABLE_CRYSTALLIZATION, GENERATE_PLATE, GENERATE_LENS)
                .build()
                .setFormula("Ax⚶?", false);

        //  24073 Supercritical Steam
        SupercriticalSteam = new Material.Builder(getID(), gregtechId("supercritical_steam"))
                .gas(new FluidBuilder().temperature(873).customStill())
                .color(0xC4C4C4)
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24074 Superheated Steam
        SuperheatedSteam = new Material.Builder(getID(), gregtechId("superheated_steam"))
                .gas(new FluidBuilder().temperature(573).customStill())
                .color(0xC4C4C)
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  24075 Exotic Mutagen
        ExoticMutagen = new Material.Builder(getID(), gregtechId("exotic_mutagen"))
                .liquid(new FluidBuilder().temperature(18406).attributes(FluidAttributes.ACID))
                .color(0x9C31F9)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24076 Crude Exotic Gas
        CrudeExoticGas = new Material.Builder(getID(), gregtechId("crude_exotic_gas"))
                .gas(new FluidBuilder().temperature(8090))
                .color(0xBEF32C)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24077 Cracked Crude Exotic Gas
        CrackedCrudeExoticGas = new Material.Builder(getID(), gregtechId("cracked_crude_exotic_gas"))
                .gas(new FluidBuilder().temperature(12390))
                .color(0xEA1798)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24078 Naquadic Exotic Gas
        NaquadicExoticGas = new Material.Builder(getID(), gregtechId("naquadic_exotic_gas"))
                .gas(new FluidBuilder().temperature(40223))
                .color(0xB01172)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24079 Superheavy Exotic Gas
        SuperheavyExoticGas = new Material.Builder(getID(), gregtechId("superheavy_exotic_gas"))
                .gas()
                .color(0x33FF99)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24080 Heavy Exotic Gas
        HeavyExoticGas = new Material.Builder(getID(), gregtechId("heavy_exotic_gas"))
                .gas()
                .color(0x57FFBC)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24081 Medium Exotic Gas
        MediumExoticGas = new Material.Builder(getID(), gregtechId("medium_exotic_gas"))
                .gas()
                .color(0x1FFFA6)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24082 Light Exotic Gas
        LightExoticGas = new Material.Builder(getID(), gregtechId("light_exotic_gas"))
                .gas()
                .color(0x62FFC1)
                .iconSet(DULL)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaa", false);

        //  24083 Hyper Fuel Mk II
        HyperFuelMkII = new Material.Builder(getID(), gregtechId("hyper_fuel_mk_ii"))
                .liquid()
                .color(0xE00059)
                .build();

        //  24084 Hyper Fuel Mk III
        HyperFuelMkIII = new Material.Builder(getID(), gregtechId("hyper_fuel_mk_iii"))
                .liquid()
                .color(0xB900FF)
                .build();

        //  24085 Hyper Fuel Mk IV
        HyperFuelMkIV = new Material.Builder(getID(), gregtechId("hyper_fuel_mk_iv"))
                .liquid()
                .color(0xFFC951)
                .build();

        //  24086 Blood Cells
        BloodCells = new Material.Builder(getID(), gregtechId("blood_cells"))
                .liquid()
                .color(0xC43A31)
                .iconSet(DULL)
                .build();

        //  24087 Blood Plasma
        BloodPlasma = new Material.Builder(getID(), gregtechId("blood_plasma"))
                .liquid()
                .color(0x882822)
                .build();

        //  24088 bFGF
        BFGF = new Material.Builder(getID(), gregtechId("bfgf"))
                .liquid()
                .color(0xA15C72)
                .build()
                .setFormula("bFGF", false);

        //  24089 EGF
        EGF = new Material.Builder(getID(), gregtechId("egf"))
                .liquid()
                .color(0x993300)
                .build()
                .setFormula("EGF", false);

        //  24090 CAT
        CAT = new Material.Builder(getID(), gregtechId("cat"))
                .liquid()
                .color(0x72B5EA)
                .build()
                .setFormula("CAT", false);

        //  24091 Marine Algae
        MarineAlgae = new Material.Builder(getID(), gregtechId("marine_algae"))
                .liquid(new FluidBuilder().temperature(300))
                .color(0x2CD82C)
                .iconSet(DULL)
                .build();

        //  24092 Alien Marine Algae
        AlienMarineAlgae = new Material.Builder(getID(), gregtechId("alien_marine_algae"))
                .liquid(new FluidBuilder().temperature(350))
                .color(0xD327D3)
                .iconSet(DULL)
                .build();

        //  24093 Lanthanum Extracting Nano Resin
        LanthanumExtractingNanoResin = new Material.Builder(getID(), gregtechId("lanthanum_extracting_nano_resin"))
                .liquid()
                .color(LanthanumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24094 Praseodymium Extracting Nano Resin
        PraseodymiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("praseodymium_extracting_nano_resin"))
                .liquid()
                .color(PraseodymiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24095 Neodymium Extracting Nano Resin
        NeodymiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("neodymium_extracting_nano_resin"))
                .liquid()
                .color(NeodymiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24096 Cerium Extracting Nano Resin
        CeriumExtractingNanoResin = new Material.Builder(getID(), gregtechId("cerium_extracting_nano_resin"))
                .liquid()
                .color(CeriumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24097 Scandium Extracting Nano Resin
        ScandiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("scandium_extracting_nano_resin"))
                .liquid()
                .color(ScandiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24098 Europium Extracting Nano Resin
        EuropiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("europium_extracting_nano_resin"))
                .liquid()
                .color(EuropiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24099 Gadolinium Extracting Nano Resin
        GadoliniumExtractingNanoResin = new Material.Builder(getID(), gregtechId("gadolinium_extracting_nano_resin"))
                .liquid()
                .color(GadoliniumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24100 Samarium Extracting Nano Resin
        SamariumExtractingNanoResin = new Material.Builder(getID(), gregtechId("samarium_extracting_nano_resin"))
                .liquid()
                .color(SamariumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24101 Yttrium Extracting Nano Resin
        YttriumExtractingNanoResin = new Material.Builder(getID(), gregtechId("yttrium_extracting_nano_resin"))
                .liquid()
                .color(YttriumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24102 Terbium Extracting Nano Resin
        TerbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("terbium_extracting_nano_resin"))
                .liquid()
                .color(TerbiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24103 Dysprosium Extracting Nano Resin
        DysprosiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("dysprosium_extracting_nano_resin"))
                .liquid()
                .color(DysprosiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24104 Holmium Extracting Nano Resin
        HolmiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("holmium_extracting_nano_resin"))
                .liquid()
                .color(HolmiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24105 Erbium Extracting Nano Resin
        ErbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("erbium_extracting_nano_resin"))
                .liquid()
                .color(ErbiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24106 Thulium Extracting Nano Resin
        ThuliumExtractingNanoResin = new Material.Builder(getID(), gregtechId("thulium_extracting_nano_resin"))
                .liquid()
                .color(ThuliumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24107 Ytterbium Extracting Nano Resin
        YtterbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("ytterbium_extracting_nano_resin"))
                .liquid()
                .color(YtterbiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24108 Lutetium Extracting Nano Resin
        LutetiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("lutetium_extracting_nano_resin"))
                .liquid()
                .color(LutetiumOxide.getMaterialRGB())
                .iconSet(DULL)
                .build();

        //  24109 Filled Lanthanum Extracting Nano Resin
        FilledLanthanumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_lanthanum_extracting_nano_resin"))
                .liquid()
                .color(LanthanumOxide.getMaterialRGB())
                .build();

        //  24110 Filled Praseodymium Extracting Nano Resin
        FilledPraseodymiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_praseodymium_extracting_nano_resin"))
                .liquid()
                .color(PraseodymiumOxide.getMaterialRGB())
                .build();

        //  24111 Filled Neodymium Extracting Nano Resin
        FilledNeodymiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_neodymium_extracting_nano_resin"))
                .liquid()
                .color(NeodymiumOxide.getMaterialRGB())
                .build();

        //  24112 Filled Cerium Extracting Nano Resin
        FilledCeriumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_cerium_extracting_nano_resin"))
                .liquid()
                .color(CeriumOxide.getMaterialRGB())
                .build();

        //  24113 Filled Scandium Extracting Nano Resin
        FilledScandiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_scandium_extracting_nano_resin"))
                .liquid()
                .color(ScandiumOxide.getMaterialRGB())
                .build();

        //  24114 Filled Europium Extracting Nano Resin
        FilledEuropiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_europium_extracting_nano_resin"))
                .liquid()
                .color(EuropiumOxide.getMaterialRGB())
                .build();

        //  24115 Filled Gadolinium Extracting Nano Resin
        FilledGadoliniumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_gadolinium_extracting_nano_resin"))
                .liquid()
                .color(GadoliniumOxide.getMaterialRGB())
                .build();

        //  24116 Filled Samarium Extracting Nano Resin
        FilledSamariumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_samarium_extracting_nano_resin"))
                .liquid()
                .color(SamariumOxide.getMaterialRGB())
                .build();

        //  24117 Filled Yttrium Extracting Nano Resin
        FilledYttriumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_yttrium_extracting_nano_resin"))
                .liquid()
                .color(YttriumOxide.getMaterialRGB())
                .build();

        //  24118 Filled Terbium Extracting Nano Resin
        FilledTerbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_terbium_extracting_nano_resin"))
                .liquid()
                .color(TerbiumOxide.getMaterialRGB())
                .build();

        //  24119 Filled Dysprosium Extracting Nano Resin
        FilledDysprosiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_dysprosium_extracting_nano_resin"))
                .liquid()
                .color(DysprosiumOxide.getMaterialRGB())
                .build();

        //  24120 Filled Holmium Extracting Nano Resin
        FilledHolmiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_holmium_extracting_nano_resin"))
                .liquid()
                .color(HolmiumOxide.getMaterialRGB())
                .build();

        //  24121 Filled Erbium Extracting Nano Resin
        FilledErbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_erbium_extracting_nano_resin"))
                .liquid()
                .color(ErbiumOxide.getMaterialRGB())
                .build();

        //  24122 Filled Thulium Extracting Nano Resin
        FilledThuliumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_thulium_extracting_nano_resin"))
                .liquid()
                .color(ThuliumOxide.getMaterialRGB())
                .build();

        //  24123 Filled Ytterbium Extracting Nano Resin
        FilledYtterbiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_ytterbium_extracting_nano_resin"))
                .liquid()
                .color(YtterbiumOxide.getMaterialRGB())
                .build();

        //  24124 Filled Lutetium Extracting Nano Resin
        FilledLutetiumExtractingNanoResin = new Material.Builder(getID(), gregtechId("filled_lutetium_extracting_nano_resin"))
                .liquid()
                .color(LutetiumOxide.getMaterialRGB())
                .build();

        //  24125 Enriched Naquadah Emulsion
        EnrichedNaquadahEmulsion = new Material.Builder(getID(), gregtechId("enriched_naquadah_emulsion"))
                .liquid()
                .color(Naquadah.getMaterialRGB())
                .iconSet(DULL)
                .build()
                .setFormula("Nq+Ke?", true);

        //  24126 Naquadria Emulsion
        NaquadriaEmulsion = new Material.Builder(getID(), gregtechId("naquadria_emulsion"))
                .liquid()
                .color(Naquadria.getMaterialRGB())
                .iconSet(DULL)
                .build()
                .setFormula("*Nq*Ke?", true);

        //  24127 Trinium Goo
        TriniumGoo = new Material.Builder(getID(), gregtechId("trinium_goo"))
                .liquid()
                .color(TriniumSulfide.getMaterialRGB())
                .iconSet(DULL)
                .build()
                .setFormula("Ke?");

        //  24128 Trinium Waste
        TriniumWaste = new Material.Builder(getID(), gregtechId("trinium_waste"))
                .liquid()
                .color(0x9F4495)
                .build()
                .setFormula("GaTi(HNO3)?", true);
    }

}
