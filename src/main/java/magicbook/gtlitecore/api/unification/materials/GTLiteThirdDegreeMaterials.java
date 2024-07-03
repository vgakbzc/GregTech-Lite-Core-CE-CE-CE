package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.api.annotation.MaterialIDRange;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider.getID;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * Third Degree Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class.
 * </p>
 *
 * @since 2.8.7-beta
 */
@MaterialIDRange(startID = 20001, endID = 21000)
public class GTLiteThirdDegreeMaterials {

    public static void register() {

        //  20001 Proto Adamantium
        ProtoAdamantium = new Material.Builder(getID(), gregtechId("proto_adamantium"))
                .dust()
                .liquid()
                .ore(1, 1, true)
                .addOreByproducts(Adamantite)
                .color(0xAA0D0D)
                .iconSet(SHINY)
                .components(Adamantium, 3, Promethium, 2)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .build();

        //  20002 Enriched Mithril
        EnrichedMithril = new Material.Builder(getID(), gregtechId("enriched_mithril"))
                .dust()
                .liquid()
                .ore(1, 1, true)
                .addOreByproducts(Mithril)
                .color(0x2B45DF)
                .iconSet(SHINY)
                .components(Mithril, 2, NaquadahEnriched, 1, Oxygen, 14)
                .build();

        //  20003 Trinium Titanide
        TriniumTitanide = new Material.Builder(getID(), gregtechId("trinium_titanide"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Trinium)
                .color(0x9986A3)
                .iconSet(SHINY)
                .components(Trinium, 2, Titanium, 1)
                .build();

        //  20004 Germanium Tungsten Nitride
        GermaniumTungstenNitride = new Material.Builder(getID(), gregtechId("germanium_tungsten_nitride"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Germanium)
                .color(0x8F8FCF)
                .iconSet(METALLIC)
                .components(Germanium, 3, Tungsten, 3, Nitrogen, 10)
                .build();

        //  20005 Bismuth Iridiate
        BismuthIridiate = new Material.Builder(getID(), gregtechId("bismuth_iridiate"))
                .dust()
                .ore(1,1, false)
                .addOreByproducts(Iridium)
                .color(0x478A6B)
                .iconSet(DULL)
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .build();

        //  20006 Bismuth Ruthenate
        BismuthRuthenate = new Material.Builder(getID(), gregtechId("bismuth_ruthenate"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Ruthenium)
                .color(0x94CF5C)
                .iconSet(DULL)
                .components(Bismuth, 2, Ruthenium, 2, Oxygen, 7)
                .build();

        //  20007 Sylvanite
        Sylvanite = new Material.Builder(getID(), gregtechId("sylvanite"))
                .dust()
                .ore(2, 2, false)
                .addOreByproducts(Electrum)
                .color(0xE4EBDC)
                .iconSet(METALLIC)
                .components(Gold, 1, Silver, 1, Tellurium, 4)
                .build();

        //  20008 Rheniite
        Rheniite = new Material.Builder(getID(), gregtechId("rheniite"))
                .dust()
                .ore(1, 2, false)
                .addOreByproducts(Rhenium)
                .color(0xDFDFDF)
                .iconSet(SHINY)
                .components(Rhenium, 1, Sulfur, 2)
                .build();

        //  20009 Gadolinite
        Gadolinite = new Material.Builder(getID(), gregtechId("gadolinite"))
                .dust()
                .ore(1, 1, false)
                .addOreByproducts(Yttrium)
                .addOreByproducts(Holmium)
                .color(0xB52F2A)
                .iconSet(ROUGH)
                .components(Yttrium, 2, Iron, 1, Beryllium, 2, Silicon, 2, Oxygen, 10)
                .build()
                .setFormula("Y2FeBe2(SiO4)2O2", true);

        //  20010 Euxenite
        Euxenite = new Material.Builder(getID(), gregtechId("euxenite"))
                .dust()
                .ore(2, 1, false)
                .addOreByproducts(Thorium)
                .addOreByproducts(Lutetium)
                .color(0x0D6330)
                .iconSet(DULL)
                .components(Cerium, 1, Tantalum, 2, Oxygen, 6)
                .build();

        //  20011 Platarsite
        Platarsite = new Material.Builder(getID(), gregtechId("platarsite"))
                .dust()
                .ore(3, 2, false)
                .addOreByproducts(Rhodium)
                .addOreByproducts(Tellurium)
                .color(0x77055B)
                .iconSet(METALLIC)
                .components(Platinum, 1, Arsenic, 1, Sulfur, 1)
                .build();

        //  20012 Picotite
        Picotite = new Material.Builder(getID(), gregtechId("picotite"))
                .gem(3)
                .ore(2, 3, false)
                .addOreByproducts(Magnesium)
                .addOreByproducts(Aluminium)
                .color(0x931C24)
                .iconSet(DIAMOND)
                .components(Iron, 1, Chrome, 2, Oxygen, 4)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .build();

        //  20013 Xenotime
        Xenotime = new Material.Builder(getID(), gregtechId("xenotime"))
                .dust()
                .ore(2, 1, false)
                .addOreByproducts(Yttrium)
                .addOreByproducts(Ytterbium)
                .color(0xC5EB9E)
                .iconSet(METALLIC)
                .components(Yttrium, 2, Ytterbium, 2, Erbium, 2, Europium, 1, Phosphorus, 2, Oxygen, 8)
                .build();

        //  20014 Zircophyllite
        Zircophyllite = new Material.Builder(getID(), gregtechId("zircophyllite"))
                .gem()
                .ore(2, 1, false)
                .addOreByproducts(Zirconium)
                .addOreByproducts(Titanium)
                .color(0xCCFF00)
                .iconSet(OPAL)
                .components(Potassium, 3, Sodium, 3, Manganese, 7, Iron, 7, Zirconium, 2, Titanium, 2, Niobium, 2, Silicon, 8, Oxygen, 13, Fluorine, 7)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .build();

        //  20015 Lepersonnite
        Lepersonnite = new Material.Builder(getID(), gregtechId("lepersonnite"))
                .gem()
                .ore(2, 1, false)
                .addOreByproducts(Gadolinium)
                .addOreByproducts(Dysprosium)
                .color(0x61F555)
                .iconSet(RUBY)
                .components(Calcium, 1, Ytterbium, 3, Gadolinium, 2, Dysprosium, 2, Uranium235, 2, Oxygen, 29, Hydrogen, 24)
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .build()
                .setFormula("CaYb3Gd2Dy2U2O29H24", true);

    }
    
}
