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
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
