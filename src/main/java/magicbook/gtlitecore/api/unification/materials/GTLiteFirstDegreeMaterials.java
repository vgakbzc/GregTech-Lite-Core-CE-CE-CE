package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

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

    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
