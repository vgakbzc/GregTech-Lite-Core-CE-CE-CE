package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;
import magicbook.gtlitecore.api.unification.GTLiteElements;
import net.minecraft.init.Enchantments;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteElementMaterials {

    //  Range: 10000-11000
    private static int startId = 10000;
    private static final int endId = startId + 1000;

    public static void register() {
        //  10000 Orichalcum
        Orichalcum = new Material.Builder(getId(), gregtechId("orichalcum"))
                .ingot()
                .fluid()
                .color(0x72A0C1)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_ROTOR, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .element(GTLiteElements.Or)
                .toolStats(ToolProperty.Builder.of(7.0F, 25.0F, 17000, 22)
                                       .magnetic()
                                       .enchantment(Enchantments.FORTUNE, 5)
                                       .build())
                .blast(9000, BlastProperty.GasTier.HIGH)
                .build();
        //  10001 Vibranium
        Vibranium = new Material.Builder(getId(), gregtechId("vibranium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xC880FF)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_DOUBLE_PLATE)
                .element(GTLiteElements.Vb)
                .blast(4852, BlastProperty.GasTier.HIGH)
                .build();
        //  10001 Adamantium
        Adamantium = new Material.Builder(getId(), gregtechId("adamantium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xFF0040)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND)
                .element(GTLiteElements.Ad)
                .blast(5225, BlastProperty.GasTier.HIGH)
                .build();
        //  10002 Taranium
        Taranium = new Material.Builder(getId(), gregtechId("taranium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0x4F404F)
                .iconSet(METALLIC)
                .element(GTLiteElements.Tn)
                .build();
        //  10003 Mithril
        Mithril = new Material.Builder(getId(), gregtechId("mithril"))
                .ingot()
                .fluid()
                .plasma()
                .color(0x428fdb)
                .iconSet(METALLIC)
                .element(GTLiteElements.Mh)
                .blast(10400, BlastProperty.GasTier.HIGHEST)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}