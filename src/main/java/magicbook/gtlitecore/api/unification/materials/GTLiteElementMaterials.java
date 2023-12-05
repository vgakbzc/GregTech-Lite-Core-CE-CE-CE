package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;
import magicbook.gtlitecore.api.unification.GTLiteElements;
import net.minecraft.init.Enchantments;
import net.minecraft.util.text.TextFormatting;

import static gregtech.api.GTValues.*;
import static gregtech.api.GTValues.UHV;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.*;

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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_ROTOR, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FRAME)
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
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_SPRING)
                .element(GTLiteElements.Ad)
                .blast(5225, BlastProperty.GasTier.HIGH)
                .cableProperties(V[UHV], 24, 24, false)
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
                .liquid()
                .plasma()
                .color(0x428fdb)
                .iconSet(METALLIC)
                .element(GTLiteElements.Mh)
                .blast(10400, BlastProperty.GasTier.HIGHEST)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  10004 Infinity
        Infinity = new Material.Builder(getId(), gregtechId("infinity"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) V[UIV]).customStill())
                .iconSet(CUSTOM_INFINITY)
                .element(GTLiteElements.Infinity)
                .blast(b -> b
                        .temp(12600, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 5901))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_ROTOR, GENERATE_FRAME)
                .toolStats(ToolProperty.Builder.of(10.0F, 150.0F, 80000, 30)
                        .magnetic()
                        .unbreakable()
                        .enchantment(Enchantments.SHARPNESS, 10)
                        .enchantment(Enchantments.FORTUNE, 10)
                        .build())
                .build();

        //  10005 Crystal Matrix
        CrystalMatrix = new Material.Builder(getId(), gregtechId("crystal_matrix"))
                .ingot()
                .liquid(new FluidBuilder().temperature(660450))
                .color(0x70ecff)
                .iconSet(BRIGHT)
                .element(GTLiteElements.CrystalMatrix)
                .fluidPipeProperties(40000, 10000, true, true, true, true)
                .build();

        //  10006 Ichorium
        Ichorium = new Material.Builder(getId(), gregtechId("ichorium"))
                .ingot()
                .liquid()
                .color(0xE5A559)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(13500)
                        .blastStats(VA[UHV], 3660)
                        .vacuumStats(VA[ZPM], 1880))
                .element(GTLiteElements.Ichorium)
                .cableProperties(V[UEV], 36, 18, false)
                .flags(GENERATE_ROD, GENERATE_SPRING)
                .build();

        //  10007 Ichor Liquid
        IchorLiquid = new Material.Builder(getId(), gregtechId("ichor_liquid"))
                .plasma(new FluidBuilder().temperature(214748))
                .color(0xE5A559)
                .element(GTLiteElements.IchorLiquid)
                .build();

        //  10008 Cosmic Neutronium
        CosmicNeutronium = new Material.Builder(getId(), gregtechId("cosmic_neutronium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(2000000000))
                .color(0xF3F3F3)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(15000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 200)
                        .blastStats(VA[UXV], 200))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_ROTOR, GENERATE_FRAME)
                .element(GTLiteElements.SpNt)
                .build();

        //  10009 Spacetime
        Spacetime = new Material.Builder(getId(), gregtechId("spacetime"))
                .ingot()
                .liquid(new FluidBuilder().customStill())
                .iconSet(CUSTOM_SPACETIME)
                .blast(b -> b
                        .temp(16000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[OpV], 100)
                        .vacuumStats(VA[OpV], 100))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_ROTOR, GENERATE_FRAME)
                .element(GTLiteElements.SpaceTime)
                .build()
                .setFormula(TextFormatting.OBFUSCATED + "aaaaaa", false);

        //  10010 Solarium
        Solarium = new Material.Builder(getId(), gregtechId("solarium"))
                .ingot()
                .liquid()
                .color(0xFFFF33)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Sol)
                .blast(b -> b
                        .temp(14800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV]))
                .cableProperties(V[UIV], 16, 8, false)
                .build();

        //  10011 Rhugnor
        Rhugnor = new Material.Builder(getId(), gregtechId("rhugnor"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) (V[UIV] - V[UV])))
                .color(0xBE00FF)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Rhugnor)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 3340))
                .flags(GENERATE_PLATE)
                .build();

        //  10012 Hypogen
        Hypogen = new Material.Builder(getId(), gregtechId("hypogen"))
                .ingot()
                .liquid()
                .plasma(new FluidBuilder().temperature((int) (V[UXV] - V[LuV])))
                .element(GTLiteElements.Hypogen)
                .color(0xDC784B)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .cableProperties(V[UXV], 32, 16, false)
                .build();

        //  10013 Void Metal
        VoidMetal = new Material.Builder(getId(), gregtechId("void_metal"))
                .ingot()
                .liquid()
                .color(0x20142C)
                .iconSet(DULL)
                .element(GTLiteElements.VoidMetal)
                .build();

        //  10014 Astral Titanium
        AstralTitanium = new Material.Builder(getId(), gregtechId("astral_titanium"))
                .ingot()
                .liquid()
                .plasma()
                .color(0xDCA0F0)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV]))
                .element(GTLiteElements.AstralTitanium)
                .cableProperties(V[UIV], 32, 12, false)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .build();

        //  10015 Celestial Tungsten
        CelestialTungsten = new Material.Builder(getId(), gregtechId("celestial_tungsten"))
                .ingot()
                .liquid()
                .plasma()
                .color(0x323232)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV]))
                .element(GTLiteElements.CelestialTungsten)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_BOLT_SCREW)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}