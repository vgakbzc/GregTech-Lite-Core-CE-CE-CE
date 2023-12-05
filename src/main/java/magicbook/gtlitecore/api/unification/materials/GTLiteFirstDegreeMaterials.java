package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.*;

public class GTLiteFirstDegreeMaterials {

    //  Range: 11001-12000
    private static int startId = 11001;
    private static final int endId = startId + 999;

    public static void register() {

        //  11001 Platinum Group Residue
        PlatinumGroupResidue = new Material.Builder(getId(), gregtechId("platinum_group_residue"))
                .dust()
                .color(0x64632E)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Rhodium, 1, Ruthenium, 1, RareEarth, 1)
                .build()
                .setFormula("RuRhIr2Os(HNO3)3", true);

        //  11002 Platinum Group Concentrate
        PlatinumGroupConcentrate = new Material.Builder(getId(), gregtechId("platinum_group_concentrate"))
                .liquid()
                .color(0xFFFFA6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gold, 1, Platinum, 1, Palladium, 1, HydrochloricAcid, 6)
                .build()
                .setFormula("AuPtPd(HCl)6", true);

        //  11003 Purified Platinum Group Concentrate
        PurifiedPlatinumGroupConcentrate = new Material.Builder(getId(), gregtechId("purified_platinum_group_concentrate"))
                .liquid()
                .color(0xFFFFC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Platinum, 1, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("H2PtPdCl6", true);

        //  11004 Ammonium Hexachloroplatinate
        AmmoniumHexachloroplatinate = new Material.Builder(getId(), gregtechId("ammonium_hexachloroplatinate"))
                .liquid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        //  11005 Ammonium Hexachloropalladate
        AmmoniumHexachloropalladate = new Material.Builder(getId(), gregtechId("ammonium_hexachloropalladate"))
                .liquid()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PdCl6", true);

        //  11006 Sodium Nitrate
        SodiumNitrate = new Material.Builder(getId(), gregtechId("sodium_nitrate"))
                .dust()
                .color(0x846684)
                .iconSet(ROUGH)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .build();

        //  11007 Hexachloroplatinic Acid
        HexachloroplatinicAcid = new Material.Builder(getId(), gregtechId("hexachloroplatinic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xFEF4D1)
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6)
                .build();

        //  11008 Carbon Tetrachloride
        CarbonTetrachloride = new Material.Builder(getId(), gregtechId("carbon_tetrachloride"))
                .liquid()
                .color(0x75201A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Chlorine, 4)
                .build();

        //  11009 Ruthenium Chloride
        RutheniumChloride = new Material.Builder(getId(), gregtechId("ruthenium_chloride"))
                .dust()
                .color(0x605C6C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .build();

        //  11010 Sodium Peroxide
        SodiumPeroxide = new Material.Builder(getId(), gregtechId("sodium_peroxide"))
                .dust()
                .color(0xECFF80)
                .iconSet(ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        //  11011 Rhodium Oxide
        RhodiumOxide = new Material.Builder(getId(), gregtechId("rhodium_oxide"))
                .dust()
                .color(0xD93D16)
                .iconSet(METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .build();

        //  11012 Sulfur Dichloride
        SulfurDichloride = new Material.Builder(getId(), gregtechId("sulfur_dichloride"))
                .liquid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();

        //  11013 Thionyl Chloride
        ThionylChloride = new Material.Builder(getId(), gregtechId("thionyl_chloride"))
                .liquid()
                .color(0xEBE863)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build();

        //  11014 Osmium Tetrachloride
        OsmiumTetrachloride = new Material.Builder(getId(), gregtechId("osmium_tetrachloride"))
                .dust()
                .color(0x29080A)
                .iconSet(METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .build();

        //  11015 Lanthanum Oxide
        LanthanumOxide = new Material.Builder(getId(), gregtechId("lanthanum_oxide"))
                .dust()
                .color(0x5F7777)
                .iconSet(SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .build();

        //  11016 Cerium Oxide
        CeriumOxide = new Material.Builder(getId(), gregtechId("cerium_oxide"))
                .dust()
                .color(0x10937F)
                .iconSet(METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .build();

        //  11017 Praseodymium Oxide
        PraseodymiumOxide = new Material.Builder(getId(), gregtechId("praseodymium_oxide"))
                .dust()
                .color(0xD0D0D0)
                .iconSet(METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .build();

        //  11018 Neodymium Oxide
        NeodymiumOxide = new Material.Builder(getId(), gregtechId("neodymium_oxide"))
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .build();
        //  11019 Samarium Oxide
        SamariumOxide = new Material.Builder(getId(), gregtechId("samarium_oxide"))
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .build();
        //  11020 Europium Oxide
        EuropiumOxide = new Material.Builder(getId(), gregtechId("europium_oxide"))
                .dust()
                .color(0x20AAAA)
                .iconSet(SHINY)
                .components(Europium, 2, Oxygen, 3)
                .build();
        //  11021 Gadolinium Oxide
        GadoliniumOxide = new Material.Builder(getId(), gregtechId("gadolinium_oxide"))
                .dust()
                .color(0xEEEEFF)
                .iconSet(METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();
        //  11022 Terbium Oxide
        TerbiumOxide = new Material.Builder(getId(), gregtechId("terbium_oxide"))
                .dust()
                .color(0xA264A2)
                .iconSet(METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .build();

        //  11023 Dysprosium Oxide
        DysprosiumOxide = new Material.Builder(getId(), gregtechId("dysprosium_oxide"))
                .dust()
                .color(0xD273D2)
                .iconSet(METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .build();

        //  11024 Holmium Oxide
        HolmiumOxide = new Material.Builder(getId(), gregtechId("holmium_oxide"))
                .dust()
                .color(0xAF7F2A)
                .iconSet(SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .build();

        //  11025 Erbium Oxide
        ErbiumOxide = new Material.Builder(getId(), gregtechId("erbium_oxide"))
                .dust()
                .color(0xE07A32)
                .iconSet(METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .build();

        //  11026 Thulium Oxide
        ThuliumOxide = new Material.Builder(getId(), gregtechId("thulium_oxide"))
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .build();

        //  11027 Ytterbium Oxide
        YtterbiumOxide = new Material.Builder(getId(), gregtechId("ytterbium_oxide"))
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .build();

        //  11028 Lutetium Oxide
        LutetiumOxide = new Material.Builder(getId(), gregtechId("lutetium_oxide"))
                .dust()
                .color(0x11BBFF)
                .iconSet(METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .build();

        //  11029 Scandium Oxide
        ScandiumOxide = new Material.Builder(getId(), gregtechId("scandium_oxide"))
                .dust()
                .color(0x43964F)
                .iconSet(METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .build();

        //  11030 Yttrium Oxide
        YttriumOxide = new Material.Builder(getId(), gregtechId("yttrium_oxide"))
                .dust()
                .color(0x78544E)
                .iconSet(SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .build();

        //  11031 Ammonium Nitrate
        AmmoniumNitrate = new Material.Builder(getId(), gregtechId("ammonium_nitrate"))
                .dust()
                .liquid()
                .color(0xA59ED7)
                .iconSet(METALLIC)
                .components(Ammonia, 1, NitricAcid, 1)
                .build()
                .setFormula("NH4NO3", true);

        //  11032 Heavy Taranium Fuel
        HeavyTaraniumFuel = new Material.Builder(getId(), gregtechId("heavy_taranium_fuel"))
                .liquid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11033 Medium Taranium Fuel
        MediumTaraniumFuel = new Material.Builder(getId(), gregtechId("medium_taranium_fuel"))
                .liquid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11034 Light Taranium Fuel
        LightTaraniumFuel = new Material.Builder(getId(), gregtechId("light_taranium_fuel"))
                .liquid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11035 Heavy Enriched Taranium Fuel
        HeavyEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("heavy_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11036 Medium Enriched Taranium Fuel
        MediumEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("medium_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11037 Light Enriched Taranium Fuel
        LightEnrichedTaraniumFuel = new Material.Builder(getId(), gregtechId("light_enriched_taranium_fuel"))
                .liquid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        //  11038 Orichalcum Energized
        OrichalcumEnergized = new Material.Builder(getId(), gregtechId("orichalcum_energized"))
                .dust()
                .color(0xF4FC0C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .build();

        //  11039 Adamantite
        Adamantite = new Material.Builder(getId(), gregtechId("adamantite"))
                .dust()
                .color(0xC83C3C)
                .iconSet(ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .build();

        //  11040 Adamantium Unstable
        AdamantiumUnstable = new Material.Builder(getId(), gregtechId("adamantium_unstable"))
                .liquid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .build();

        //  11041 Adamantium Enriched
        AdamantiumEnriched = new Material.Builder(getId(), gregtechId("adamantium_enriched"))
                .dust()
                .color(0x64B4FF)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .build();

        //  11042 Vibranium Unstable
        VibraniumUnstable = new Material.Builder(getId(), gregtechId("vibranium_unstable"))
                .liquid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .build();

        //  11043 Deep Iron
        DeepIron = new Material.Builder(getId(), gregtechId("deep_iron"))
                .dust()
                .color(0x968C8C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .build();

        //  11044 Sodium Ethylate
        SodiumEthylate = new Material.Builder(getId(), gregtechId("sodium_ethylate"))
                .dust()
                .color(0xD0FC8F)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1)
                .build();

        //  11045 Potassium Ethylate
        PotassiumEthylate = new Material.Builder(getId(), gregtechId("potassium_ethylate"))
                .dust()
                .color(0xFBC47D)
                .iconSet(DULL)
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Potassium, 1)
                .build();

        //  11046 Calcium Carbonate
        CalciumCarbonate = new Material.Builder(getId(), gregtechId("calcium_carbonate"))
                .dust()
                .color(0xE8E8CB)
                .iconSet(ROUGH)
                .components(Calcium, 1, Carbon, 1, Oxygen, 3)
                .build();

        //  11047 Carbon Disulfide
        CarbonDisulfide = new Material.Builder(getId(), gregtechId("carbon_disulfide"))
                .fluid()
                .color(0x1F80C8)
                .components(Carbon, 1, Sulfur, 2)
                .build();

        //  11048 Sodium Ethylxanthate
        SodiumEthylxanthate = new Material.Builder(getId(), gregtechId("sodium_ethylxanthate"))
                .dust()
                .color(0xF3F311)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 5, Sodium, 1, Oxygen, 1, Sulfur, 2)
                .build();

        //  11049 Potassium Ethylxanthate
        PotassiumEthylxanthate = new Material.Builder(getId(), gregtechId("potassium_ethylxanthate"))
                .dust()
                .color(0xB9AD83)
                .iconSet(SHINY)
                .components(Carbon, 3, Hydrogen, 5, Potassium, 1, Oxygen, 1, Sulfur, 2)
                .build();

        //  11050 Calcium Carbide
        CalciumCarbide = new Material.Builder(getId(), gregtechId("calcium_carbide"))
                .dust()
                .color(0x807B70)
                .iconSet(DULL)
                .components(Calcium, 1, Carbon, 2)
                .build();

        //  11051 Calcium Hydroxide
        CalciumHydroxide = new Material.Builder(getId(), gregtechId("calcium_hydroxide"))
                .dust()
                .color(0x5F8764)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .build()
                .setFormula("Ca(OH)2", true);

        //  11052 Boric Acid
        BoricAcid = new Material.Builder(getId(), gregtechId("boric_acid"))
                .dust()
                .liquid()
                .color(0xFAFAFA)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build();

        //  11053 Boron Trioxide
        BoronTrioxide = new Material.Builder(getId(), gregtechId("boron_trioxide"))
                .dust()
                .color(0xE9FAC0)
                .iconSet(METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .build();

        //  11054 Boron Trifluoride
        BoronTrifluoride = new Material.Builder(getId(), gregtechId("boron_trifluoride"))
                .gas()
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .build();

        //  11055 Lithium Hydride
        LithiumHydride = new Material.Builder(getId(), gregtechId("lithium_hydride"))
                .ingot()
                .color(0x9BAFDB)
                .iconSet(METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .build();

        //  11056 Lithium Tetrafluoroborate
        LithiumTetrafluoroborate = new Material.Builder(getId(), gregtechId("lithium_tetrafluoroborate"))
                .dust()
                .color(0x90FAF6)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .build();

        //  11057 Diborane
        Diborane = new Material.Builder(getId(), gregtechId("diborane"))
                .gas()
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .build();

        //  11058 Borazine
        Borazine = new Material.Builder(getId(), gregtechId("borazine"))
                .liquid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .build();

        //  11059 Boron Trichloride
        BoronTrichloride = new Material.Builder(getId(), gregtechId("boron_trichloride"))
                .gas()
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .build();

        //  11060 Trichloroborazine
        Trichloroborazine = new Material.Builder(getId(), gregtechId("trichloroborazine"))
                .liquid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .build();

        //  11061 Hexagonal Boron Nitride
        HexagonalBoronNitride = new Material.Builder(getId(), gregtechId("hexagonal_boron_nitride"))
                .gem()
                .color(0x6A6A72)
                .iconSet(GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("h-BN", true);

        //  11062 Cubic Boron Nitride
        CubicBoronNitride = new Material.Builder(getId(), gregtechId("cubic_boron_nitride"))
                .gem()
                .color(0x545572)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, DISABLE_CRYSTALLIZATION, FLAMMABLE, EXPLOSIVE)
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(new ToolProperty(14.0F, 9.0F, 12400, 15))
                .build()
                .setFormula("c-BN", true);

        //  11063 Amorphous Boron Nitride
        AmorphousBoronNitride = new Material.Builder(getId(), gregtechId("amorphous_boron_nitride"))
                .ingot()
                .color(0x9193C5)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("a-BN", true);

        //  11064 Heterodiamond
        Heterodiamond = new Material.Builder(getId(), gregtechId("heterodiamond"))
                .gem()
                .color(0x512A72)
                .iconSet(GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .build();

        //  11065 Cubic Heterodiamond
        CubicHeterodiamond = new Material.Builder(getId(), gregtechId("cubic_heterodiamond"))
                .gem()
                .color(0x753DA6)
                .iconSet(DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .build()
                .setFormula("c-BC2N", true);

        //  11066 Hydrobromic Acid
        HydrobromicAcid = new Material.Builder(getId(), gregtechId("hydrobromic_acid"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11067 Potassium Hydroxide
        PotassiumHydroxide = new Material.Builder(getId(), gregtechId("potassium_hydroxide"))
                .dust()
                .liquid(new FluidBuilder().temperature(633))
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .build();

        //  11068 Potassium Bromate
        PotassiumBromate = new Material.Builder(getId(), gregtechId("potassium_bromate"))
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();

        //  11069 Potassium Formate
        PotassiumFormate = new Material.Builder(getId(), gregtechId("potassium_formate"))
                .dust()
                .color(0x74B5A9)
                .iconSet(DULL)
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Potassium, 1)
                .build();

        //  11070 Copper Chloride
        CopperChloride = new Material.Builder(getId(), gregtechId("copper_chloride"))
                .dust()
                .color(0x3FB3B8)
                .iconSet(ROUGH)
                .components(Copper, 1, Chlorine, 2)
                .build();

        //  11071 Palladium Nitrate
        PalladiumNitrate = new Material.Builder(getId(), gregtechId("palladium_nitrate"))
                .dust()
                .color(0x82312A)
                .iconSet(METALLIC)
                .components(Palladium, 1, Nitrogen, 2, Oxygen, 6)
                .build()
                .setFormula("Pd(NO3)2", true);

        //  11072 Fullerene
        Fullerene = new Material.Builder(getId(), gregtechId("fullerene"))
                .ingot()
                .color(0x72556A)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING, GENERATE_FRAME)
                .components(Carbon, 60)
                .build();

        //  11073 Trimethylaluminium
        Trimethylaluminium = new Material.Builder(getId(), gregtechId("trimethylaluminium"))
                .liquid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);

        //  11074 Gallium Trichloride
        GalliumTrichloride = new Material.Builder(getId(), gregtechId("gallium_trichloride"))
                .dust()
                .color(0x6EB4FF)
                .iconSet(ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .build();

        //  11075 Aluminium Trichloride
        AluminiumTrichloride = new Material.Builder(getId(), gregtechId("aluminium_trichloride"))
                .dust()
                .color(0x78C3EB)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .build();

        //  11076 Trimethylgallium
        Trimethylgallium = new Material.Builder(getId(), gregtechId("trimethylgallium"))
                .liquid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);

        //  11077 Aluminium Hydroxide
        AluminiumHydroxide = new Material.Builder(getId(), gregtechId("aluminium_hydroxide"))
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .build()
                .setFormula("Al(OH)3", true);

        //  11078 Alumina
        Alumina = new Material.Builder(getId(), gregtechId("alumina"))
                .dust()
                .color(0x78c3eb)
                .iconSet(METALLIC)
                .components(Aluminium, 2, Oxygen, 3)
                .build();

        //  11079 Gallium Trioxide
        GalliumTrioxide = new Material.Builder(getId(), gregtechId("gallium_trioxide"))
                .dust()
                .liquid(new FluidBuilder().temperature(2170))
                .color(0xE4CDFF)
                .iconSet(METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .build();

        //  11080 Gallium Nitride
        GalliumNitride = new Material.Builder(getId(), gregtechId("gallium_nitride"))
                .ingot()
                .color(0xFFF458)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .build();

        //  11081 Beryllium Oxide
        BerylliumOxide = new Material.Builder(getId(), gregtechId("beryllium_oxide"))
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        //  11082 Graphene Oxide
        GrapheneOxide = new Material.Builder(getId(), gregtechId("graphene_oxide"))
                .dust()
                .color(0x777777)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();

        //  11083 Carbon Nanotube
        CarbonNanotube = new Material.Builder(getId(), gregtechId("carbon_nanotube"))
                .ingot()
                .liquid()
                .color(0x05090C)
                .iconSet(BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(V[UEV], 8, 6, false)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);

        //  11084 Silver Chloride
        SilverChloride = new Material.Builder(getId(), gregtechId("silver_chloride"))
                .dust()
                .color(0x8D8D8D)
                .iconSet(METALLIC)
                .components(Silver, 1, Chlorine, 1)
                .build();

        //  11085 Silver Oxide
        SilverOxide = new Material.Builder(getId(), gregtechId("silver_oxide"))
                .dust()
                .color(0xA4A4A4)
                .components(Silver, 2, Oxygen, 1)
                .build();

        //  11086 Silver Tetrafluoroborate
        SilverTetrafluoroborate = new Material.Builder(getId(), gregtechId("silver_tetrafluoroborate"))
                .liquid()
                .color(0x818024)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silver, 1, Boron, 1, Fluorine, 4)
                .build()
                .setFormula("AgBF4", true);

        //  11087 Tin Chloride
        TinChloride = new Material.Builder(getId(), gregtechId("tin_chloride"))
                .dust()
                .liquid()
                .color(0xDBDBDB)
                .iconSet(METALLIC)
                .components(Tin, 1, Chlorine, 2)
                .build();

        //  11088 Trimethyltin Chloride
        TrimethyltinChloride = new Material.Builder(getId(), gregtechId("trimethyltin_chloride"))
                .liquid()
                .color(0x7F776F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 6, Tin, 1, Chlorine, 1)
                .build()
                .setFormula("(CH3)3SnCl", true);

        //  11089 Potassium Tetrachloroplatinate
        PotassiumTetrachloroplatinate = new Material.Builder(getId(), gregtechId("potassium_tetrachloroplatinate"))
                .dust()
                .color(0xF1B04F)
                .iconSet(SHINY)
                .components(Potassium, 2, Platinum, 1, Chlorine, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("K2PtCl4", true);

        //  11090 Ammonium Sulfate
        AmmoniumSulfate = new Material.Builder(getId(), gregtechId("ammonium_sulfate"))
                .liquid()
                .color(0x5858F4)
                .components(Nitrogen, 4, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(NH2)4SO4", true);

        //  11091 Ammonium Persulfate
        AmmoniumPersulfate = new Material.Builder(getId(), gregtechId("ammonium_persulfate"))
                .liquid()
                .color(0x4242B7)
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 2, Oxygen, 8)
                .build()
                .setFormula("(NH4)2S2O8", true);

        //  11092 White Phosphorus
        WhitePhosphorus = new Material.Builder(getId(), gregtechId("white_phosphorus"))
                .gem()
                .color(0xECEADD)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11093 Red Phosphorus
        RedPhosphorus = new Material.Builder(getId(), gregtechId("red_phosphorus"))
                .gem()
                .color(0x77040E)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11094 Violet Phosphorus
        VioletPhosphorus = new Material.Builder(getId(), gregtechId("violet_phosphorus"))
                .gem()
                .color(0x8000FF)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11095 Black Phosphorus
        BlackPhosphorus = new Material.Builder(getId(), gregtechId("black_phosphorus"))
                .gem()
                .color(0x36454F)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11096 Blue Phosphorus
        BluePhosphorus = new Material.Builder(getId(), gregtechId("blue_phosphorus"))
                .gem()
                .color(0x9BE3E4)
                .iconSet(FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        //  11097 Wollastonite
        Wollastonite = new Material.Builder(getId(), gregtechId("wollastonite"))
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);

        //  11098 Phosphorene
        Phosphorene = new Material.Builder(getId(), gregtechId("phosphorene"))
                .ingot()
                .color(0x273239)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .build();

        //  11099 Phosphorus Trichloride
        PhosphorusTrichloride = new Material.Builder(getId(), gregtechId("phosphorus_trichloride"))
                .liquid()
                .color(0xD8D85B)
                .components(Phosphorus, 1, Chlorine, 3)
                .build();

        //  11100 Phosphoryl Chloride
        PhosphorylChloride = new Material.Builder(getId(), gregtechId("phosphoryl_chloride"))
                .liquid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .build();

        //  11101 Phosphine
        Phosphine = new Material.Builder(getId(), gregtechId("phosphine"))
                .gas()
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .build();

        //  11102 Cubic Zirconia
        CubicZirconia = new Material.Builder(getId(), gregtechId("cubic_zirconia"))
                .gem()
                .color(0xFFDFE2)
                .iconSet(DIAMOND)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .build()
                .setFormula("c-ZrO2", true);

        //  11103 Sodium Fluoride
        SodiumFluoride = new Material.Builder(getId(), gregtechId("sodium_fluoride"))
                .dust()
                .color(0x460012)
                .iconSet(DULL)
                .components(Sodium, 1, Fluorine, 1)
                .build();

        //  11104 Sodium Trifluoroethanolate
        SodiumTrifluoroethanolate = new Material.Builder(getId(), gregtechId("sodium_trifluoroethanolate"))
                .dust()
                .color(0x50083E)
                .iconSet(ROUGH)
                .components(Sodium, 1, Carbon, 2, Hydrogen, 4, Oxygen, 1, Fluorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        //  11105 Chromium Germanium Telluride
        ChromiumGermaniumTelluride = new Material.Builder(getId(), gregtechId("chromium_germanium_telluride"))
                .ingot()
                .fluid()
                .color(0x8F103E)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chrome, 1, Germanium, 1, Tellurium, 3)
                .blast(b -> b
                        .temp(2900, BlastProperty.GasTier.HIGHER))
                .build();

        //  11106 Magnetic Chromium Germanium Telluride
        ChromiumGermaniumTellurideMagnetic = new Material.Builder(getId(), gregtechId("magnetic_chromium_germanium_telluride"))
                .ingot()
                .color(0x8F103E)
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .build();

        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);

        //  11107 Sodium Tellurite
        SodiumTellurite = new Material.Builder(getId(), gregtechId("sodium_tellurite"))
                .dust()
                .color(0xC6C9BE)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .build();

        //  11108 Selenium Dioxide
        SeleniumDioxide = new Material.Builder(getId(), gregtechId("selenium_dioxide"))
                .dust()
                .color(0xE0DDD8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .build();

        //  11109 Tellurium Dioxide
        TelluriumDioxide = new Material.Builder(getId(), gregtechId("tellurium_dioxide"))
                .dust()
                .color(0xE3DDB8)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .build();

        //  11110 Selenous Acid
        SelenousAcid = new Material.Builder(getId(), gregtechId("selenous_acid"))
                .dust()
                .color(0xE0E083)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .build();

        //  11111 Germanium Dioxide
        GermaniumDioxide = new Material.Builder(getId(), gregtechId("germanium_dioxide"))
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .build();

        //  11112 Roasted Sphalerite
        RoastedSphalerite = new Material.Builder(getId(), gregtechId("roasted_sphalerite"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .build();

        //  11113 Zinc Rich Sphalerite
        ZincRichSphalerite = new Material.Builder(getId(), gregtechId("zinc_rich_sphalerite"))
                .dust()
                .color(0xC3AC8F)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .build()
                .setFormula("Zn2(GaGeO2)", true);

        //  11114 Zinc Oxide
        ZincOxide = new Material.Builder(getId(), gregtechId("zinc_oxide"))
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .build();

        //  11115 Waelz Oxide
        WaelzOxide = new Material.Builder(getId(), gregtechId("waelz_oxide"))
                .dust()
                .color(0xB8B8B8)
                .iconSet(FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .build();

        //  11116 Waelz Slag
        WaelzSlag = new Material.Builder(getId(), gregtechId("waelz_slag"))
                .dust()
                .color(0xAC8B5C)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        //  11117 Impure Germanium Dioxide
        ImpureGermaniumDioxide = new Material.Builder(getId(), gregtechId("impure_germanium_dioxide"))
                .dust()
                .color(0x666666)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);

        //  11118 Germanium Tetrachloride
        GermaniumTetrachloride = new Material.Builder(getId(), gregtechId("germanium_tetrachloride"))
                .liquid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .build();

        //  11119 Molybdenum Trioxide
        MolybdenumTrioxide = new Material.Builder(getId(), gregtechId("molybdenum_trioxide"))
                .dust()
                .color(0xCBCFDA)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .build();

        //  11120 Lead Chloride
        LeadChloride = new Material.Builder(getId(), gregtechId("lead_chloride"))
                .dust()
                .color(0xF3F3F3)
                .iconSet(ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .build();

        //  11121 Perrhenic Acid
        PerrhenicAcid = new Material.Builder(getId(), gregtechId("perrhenic_acid"))
                .dust()
                .color(0xE6DC70)
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .build();

        //  11122 Ammonium Perrhenate
        AmmoniumPerrhenate = new Material.Builder(getId(), gregtechId("ammonium_perrhenate"))
                .dust()
                .liquid()
                .color(0xA69970)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .build();

        //  11123 Niobium Pentoxide
        NiobiumPentoxide = new Material.Builder(getId(), gregtechId("niobium_pentoxide"))
                .dust()
                .color(0xBAB0C3)
                .iconSet(ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .build();

        //  11124 Tantalum Pentoxide
        TantalumPentoxide = new Material.Builder(getId(), gregtechId("tantalum_pentoxide"))
                .dust()
                .color(0x72728A)
                .iconSet(ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .build();

        //  11125 Calcium Difluoride
        CalciumDifluoride = new Material.Builder(getId(), gregtechId("calcium_difluoride"))
                .dust()
                .color(0xFFFC9E)
                .iconSet(ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .build();

        //  11126 Manganese Difluoride
        ManganeseDifluoride = new Material.Builder(getId(), gregtechId("manganese_difluoride"))
                .dust()
                .color(0xEF4B3D)
                .iconSet(ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .build();

        //  11127 Heavy Alkali Chloride Solution
        HeavyAlkaliChlorideSolution = new Material.Builder(getId(), gregtechId("heavy_alkali_chloride_solution"))
                .liquid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .build()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);

        //  11128 Stannic Chloride
        StannicChloride = new Material.Builder(getId(), gregtechId("stannic_chloride"))
                .liquid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .build();

        //  11129 Rubidium Chlorostannate
        RubidiumChlorostannate = new Material.Builder(getId(), gregtechId("rubidium_chlorostannate"))
                .dust()
                .color(0xBD888A)
                .iconSet(METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .build();

        //  11130 Caesium Chlorostannate
        CaesiumChlorostannate = new Material.Builder(getId(), gregtechId("caesium_chlorostannate"))
                .dust()
                .color(0xBDAD88)
                .iconSet(SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .build();

        //  11131 Thallium Sulfate
        ThalliumSulfate = new Material.Builder(getId(), gregtechId("thallium_sulfate"))
                .dust()
                .color(0x9C222C)
                .iconSet(METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        //  11132 Tungsten Trioxide
        TungstenTrioxide = new Material.Builder(getId(), gregtechId("tungsten_trioxide"))
                .dust()
                .color(0xC7D300)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
