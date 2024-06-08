package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;
import magicbook.gtlitecore.api.annotation.MaterialIDRange;
import magicbook.gtlitecore.api.unification.GTLiteElements;
import net.minecraft.init.Enchantments;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static magicbook.gtlitecore.api.GTLiteValues.addObfuscatedFormula;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider.getID;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialIconSet.*;

/**
 * Element Materials
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is a part of {@code Material} class,
 *     similar to name, this class is create correspondence material about {@code Element},
 *     for element, please see: {@link GTLiteElements}.
 * </p>
 *
 * @since 2.8.7-beta
 */
@MaterialIDRange(startID = 10000, endID = 11000)
public class GTLiteElementMaterials {

    public static void register() {
        //  10000 Orichalcum
        Orichalcum = new Material.Builder(getID(), gregtechId("orichalcum"))
                .ingot()
                .fluid()
                .color(0x72A0C1)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_ROTOR, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_LONG_ROD)
                .element(GTLiteElements.Or)
                .toolStats(ToolProperty.Builder.of(7.0F, 25.0F, 17000, 22)
                                       .magnetic()
                                       .enchantment(Enchantments.FORTUNE, 5)
                                       .build())
                .rotorStats(20.0F, 10.0F, 480000)
                .blast(9000, BlastProperty.GasTier.HIGH)
                .build();

        //  10001 Vibranium
        Vibranium = new Material.Builder(getID(), gregtechId("vibranium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xC880FF)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE, GENERATE_DENSE, GENERATE_FRAME)
                .element(GTLiteElements.Vb)
                .blast(4852, BlastProperty.GasTier.HIGH)
                .rotorStats(30.0F, 15.0F, 640000)
                .build();

        //  10001 Adamantium
        Adamantium = new Material.Builder(getID(), gregtechId("adamantium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xFF0040)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_SPRING, GENERATE_DENSE, GENERATE_FINE_WIRE)
                .element(GTLiteElements.Ad)
                .blast(5225, BlastProperty.GasTier.HIGH)
                .cableProperties(V[UHV], 24, 24, false)
                .rotorStats(35.0F, 17.5F, 500000)
                .build();

        //  10002 Taranium
        Taranium = new Material.Builder(getID(), gregtechId("taranium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0x4F404F)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_ROTOR)
                .element(GTLiteElements.Tn)
                .itemPipeProperties(1920, 128)
                .build();

        //  10003 Mithril
        Mithril = new Material.Builder(getID(), gregtechId("mithril"))
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
        Infinity = new Material.Builder(getID(), gregtechId("infinity"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) V[UIV]).customStill())
                .iconSet(CUSTOM_INFINITY)
                .element(GTLiteElements.Infinity)
                .blast(b -> b
                        .temp(12600, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 5901))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_DENSE, GENERATE_LENS, GENERATE_LONG_ROD)
                .toolStats(ToolProperty.Builder.of(10.0F, 150.0F, 80000, 30)
                        .magnetic()
                        .unbreakable()
                        .enchantment(Enchantments.SHARPNESS, 10)
                        .enchantment(Enchantments.FORTUNE, 10)
                        .build())
                .rotorStats(60.0F, 20.0F, 2560000)
                .build();

        //  10005 Crystal Matrix
        CrystalMatrix = new Material.Builder(getID(), gregtechId("crystal_matrix"))
                .ingot()
                .liquid(new FluidBuilder().temperature(660450).customStill())
                .color(0xC0FFFF)
                .iconSet(BRIGHT)
                .element(GTLiteElements.CrystalMatrix)
                .fluidPipeProperties(40000, 10000, true, true, true, true)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_LENS)
                .build();

        //  10006 Ichorium
        Ichorium = new Material.Builder(getID(), gregtechId("ichorium"))
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
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_SPRING, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  10007 Ichor Liquid
        IchorLiquid = new Material.Builder(getID(), gregtechId("ichor_liquid"))
                .plasma(new FluidBuilder().temperature(214748))
                .color(0xE5A559)
                .element(GTLiteElements.IchorLiquid)
                .build();

        //  10008 Cosmic Neutronium
        CosmicNeutronium = new Material.Builder(getID(), gregtechId("cosmic_neutronium"))
                .ingot()
                .liquid(new FluidBuilder().temperature(2000000000).customStill())
                .color(0x000000)
                .iconSet(CUSTOM_COSMIC_NEUTRONIUM)
                .blast(b -> b
                        .temp(15000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 200)
                        .blastStats(VA[UXV], 200))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_RING, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FINE_WIRE, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_LONG_ROD)
                .element(GTLiteElements.SpNt)
                .build();

        //  10009 Spacetime
        Spacetime = new Material.Builder(getID(), gregtechId("spacetime"))
                .ingot()
                .liquid(new FluidBuilder().customStill())
                .iconSet(CUSTOM_SPACETIME)
                .blast(b -> b
                        .temp(16000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[OpV], 100)
                        .vacuumStats(VA[OpV], 100))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_RING, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_LENS, GENERATE_LONG_ROD)
                .element(GTLiteElements.SpaceTime)
                .rotorStats(360.0F, 1.0F, 524288000)
                .build()
                .setFormula(addObfuscatedFormula(), false);

        //  10010 Solarium
        Solarium = new Material.Builder(getID(), gregtechId("solarium"))
                .ingot()
                .liquid()
                .color(0xFFFF33)
                .iconSet(BRIGHT)
                .element(GTLiteElements.So)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_DOUBLE_PLATE)
                .blast(b -> b
                        .temp(14800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 800)
                        .vacuumStats(VA[UEV], 400))
                .cableProperties(V[UIV], 16, 8, false)
                .build();

        //  10011 Rhugnor
        Rhugnor = new Material.Builder(getID(), gregtechId("rhugnor"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) (V[UIV] - V[UV])))
                .color(0xBE00FF)
                .iconSet(NUCLEAR)
                .element(GTLiteElements.Fs)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 3340))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .itemPipeProperties(12000, 280)
                .build();

        //  10012 Hypogen
        Hypogen = new Material.Builder(getID(), gregtechId("hypogen"))
                .ingot()
                .liquid()
                .plasma(new FluidBuilder().temperature((int) (V[UXV] - V[LuV])))
                .element(GTLiteElements.Hy)
                .color(0xDC784B)
                .iconSet(ENRICHED)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FINE_WIRE, GENERATE_LENS)
                .cableProperties(V[UXV], 32, 16, false)
                .build();

        //  10013 Void Metal
        VoidMetal = new Material.Builder(getID(), gregtechId("void_metal"))
                .ingot()
                .liquid()
                .color(0x20142C)
                .iconSet(DULL)
                .element(GTLiteElements.Vd)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .itemPipeProperties(36, 256)
                .build();

        //  10014 Astral Titanium
        AstralTitanium = new Material.Builder(getID(), gregtechId("astral_titanium"))
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
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_ROD, GENERATE_RING)
                .build();

        //  10015 Celestial Tungsten
        CelestialTungsten = new Material.Builder(getID(), gregtechId("celestial_tungsten"))
                .ingot()
                .liquid()
                .plasma()
                .color(0x323232)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(12000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV]))
                .element(GTLiteElements.CelestialTungsten)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_FINE_WIRE)
                .itemPipeProperties(8360, 496)
                .build();

        //  10016 Metastable Oganesson
        MetastableOganesson = new Material.Builder(getID(), gregtechId("metastable_oganesson"))
                .ingot()
                .gas()
                .color(0xE61C24)
                .iconSet(SHINY)
                .element(Elements.Og)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_ROTOR, GENERATE_FRAME)
                .blast(10380, BlastProperty.GasTier.HIGHEST)
                .build();

        //  10017 Metastable Flerovium
        MetastableFlerovium = new Material.Builder(getID(), gregtechId("metastable_flerovium"))
                .ingot()
                .liquid()
                .color(0x521973)
                .iconSet(SHINY)
                .element(Elements.Fl)
                .blast(11000, BlastProperty.GasTier.HIGHEST)
                .flags(GENERATE_ROD, GENERATE_PLATE, GENERATE_BOLT_SCREW)
                .build();

        //  10018 Metastable Hassium
        MetastableHassium = new Material.Builder(getID(), gregtechId("metastable_hassium"))
                .ingot()
                .fluid()
                .color(0x2D3A9D)
                .iconSet(BRIGHT)
                .element(Elements.Hs)
                .flags(GENERATE_ROD, GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_GEAR, GENERATE_ROTOR)
                .blast(14000, BlastProperty.GasTier.HIGHEST)
                .build();

        //  10019 Galaxium
        Galaxium = new Material.Builder(getID(), gregtechId("galaxium"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) (V[OpV] - V[IV])))
                .color(0x29288A)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Gx)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_FINE_WIRE)
                .cableProperties(V[OpV], 64, 32, false)
                .build();

        //  10020 Universium
        Universium = new Material.Builder(getID(), gregtechId("universium"))
                .ingot()
                .liquid(new FluidBuilder().temperature((int) V[MAX]))
                .color(0xD872EB)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Uv)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_SPRING, GENERATE_FINE_WIRE)
                .cableProperties(V[MAX], 128, 64, false)
                .build();

        //  10021 Degenerate Rhenium
        DegenerateRhenium = new Material.Builder(getID(), gregtechId("degenerate_rhenium"))
                .dust()
                .liquid()
                .plasma(new FluidBuilder().temperature((int) V[UV]))
                .color(0x6666FF)
                .iconSet(CUSTOM_DEGENERATE_RHENIUM)
                .element(Elements.Rh)
                .flags(GENERATE_PLATE)
                .build()
                .setFormula("§cR§de", false);

        //  10022 Astralium
        Astralium = new Material.Builder(getID(), gregtechId("astralium"))
                .ingot()
                .liquid()
                .color(0x3B48A7)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Ax)
                .blast(15000, BlastProperty.GasTier.HIGHEST)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_SPRING)
                .cableProperties(V[UIV], 48, 24, false)
                .build();

        //  10023 Hikarium
        Hikarium = new Material.Builder(getID(), gregtechId("hikarium"))
                .ingot()
                .liquid()
                .color(0xCCF7FB)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Hr)
                .blast(b -> b
                        .temp(18000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 480)
                        .vacuumStats(VA[UXV], 240))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_SPRING, GENERATE_FINE_WIRE)
                .cableProperties(V[UXV], 64, 32, false)
                .build();

        //  10024 Eternity
        Eternity = new Material.Builder(getID(), gregtechId("eternity"))
                .ingot()
                .liquid()
                .iconSet(CUSTOM_ETERNITY)
                .element(GTLiteElements.En)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_LENS, GENERATE_ROTOR)
                .build();

        //  10025 Tiberium
        Tiberium = new Material.Builder(getID(), gregtechId("tiberium"))
                .dust()
                .liquid()
                .color(0x79B349)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Tb)
                .build();

        //  10026 Luna Silver
        LunaSilver = new Material.Builder(getID(), gregtechId("luna_silver"))
                .ingot()
                .fluid()
                .color(0x0B8596)
                .iconSet(SHINY)
                .element(GTLiteElements.Ln)
                .blast(b -> b
                        .temp(14800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UEV], 800)
                        .vacuumStats(VA[UEV], 400))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .build();

        //  10027 Shirabon
        Shirabon = new Material.Builder(getID(), gregtechId("shirabon"))
                .ingot()
                .fluid()
                .color(0xe0156d)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Sh)
                .blast(b -> b
                        .temp(18000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UXV], 144)
                        .vacuumStats(VA[UXV], 288))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_RING)
                .cableProperties(V[OpV], 288, 144, false)
                .build();

        //  10028 Edenium
        Edenium = new Material.Builder(getID(), gregtechId("edenium"))
                .ingot()
                .fluid()
                .color(0xFFE140)
                .iconSet(ENRICHED)
                .element(GTLiteElements.Ed)
                .blast(b -> b
                        .temp(17800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[OpV], 365)
                        .vacuumStats(VA[OpV], 365))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_FRAME)
                .cableProperties(V[OpV], 360, 640, false)
                .toolStats(ToolProperty.Builder.of(50.0F, 8000.0F, 500000, 99)
                        .unbreakable()
                        .magnetic()
                        .enchantment(Enchantments.SHARPNESS, 10)
                        .enchantment(Enchantments.SWEEPING, 10)
                        .enchantment(Enchantments.LOOTING, 10)
                        .enchantment(Enchantments.FIRE_ASPECT, 10)
                        .enchantment(Enchantments.EFFICIENCY, 10)
                        .enchantment(Enchantments.FORTUNE, 10)
                        .build())
                .build();

        //  10029 Fatalium
        Fatalium = new Material.Builder(getID(), gregtechId("fatalium"))
                .ingot()
                .fluid()
                .plasma()
                .color(0xFFECEF)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Ft)
                .blast(b -> b
                        .temp(16000, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[OpV], 27)
                        .vacuumStats(VA[OpV], 50))
                .fluidPipeProperties(160000, 40000, true, true, true, true)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW)
                .build();

        //  10030 Omnium
        Omnium = new Material.Builder(getID(), gregtechId("omnium"))
                .ingot()
                .fluid()
                .iconSet(CUSTOM_OMNIUM)
                .element(GTLiteElements.Om)
                .blast(b -> b
                        .temp(18400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[MAX], 999)
                        .vacuumStats(VA[MAX], 999))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_ROUND)
                .build();

        //  10031 Magmatter
        Magmatter = new Material.Builder(getID(), gregtechId("magmatter"))
                .ingot()
                .fluid()
                .iconSet(CUSTOM_MAGMATTER)
                .element(GTLiteElements.M)
                .flags(NO_UNIFICATION, GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .cableProperties(V[MAX], 1024, 36, false)
                .build();

        //  10032 Primordial Matter
        PrimordialMatter = new Material.Builder(getID(), gregtechId("primordial_matter"))
                .ingot()
                .fluid()
                .color(0xFFD6FB)
                .iconSet(BRIGHT)
                .element(GTLiteElements.Pm)
                .flags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE)
                .cableProperties(V[MAX], 500, 125, false)
                .build();

        //  10033 Quantium
        Quantium = new Material.Builder(getID(), gregtechId("quantium"))
                .ingot()
                .fluid()
                .color(0x00D10B)
                .iconSet(SHINY)
                .element(GTLiteElements.Qt)
                .blast(b -> b
                        .temp(5400, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 300)
                        .vacuumStats(VA[IV], 295))
                .build();

        //  10034 Extremely Unstable Naquadah
        ExtremelyUnstableNaquadah = new Material.Builder(getID(), gregtechId("extremely_unstable_naquadah"))
                .ingot()
                .fluid()
                .color(0x062605)
                .iconSet(SHINY)
                .element(GTLiteElements.Nqx)
                .blast(b -> b
                        .temp(7000, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[ZPM], 800)
                        .vacuumStats(VA[LuV], 400))
                .flags(GENERATE_PLATE, GENERATE_LENS)
                .build();

        //  10035 Aetherium
        Aetherium = new Material.Builder(getID(), gregtechId("aetherium"))
                .ingot()
                .fluid()
                .color(0xFF7687)
                .iconSet(ENRICHED)
                .element(GTLiteElements.Ae)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DOUBLE_PLATE, GENERATE_SPRING, GENERATE_SPRING_SMALL)
                .cableProperties(V[MAX], 1000, 1, false)
                .fluidPipeProperties(999999, 999999, true)
                .build();
    }
}