package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteSecondDegreeMaterials {

    //  Range: 12001-13000
    private static int startId = 12001;
    private static final int endId = startId + 999;

    public static void register() {
        //  12001 Inconel-625
        Inconel625 = new Material.Builder(getId(), gregtechId("inconel_625"))
                .ingot()
                .fluid()
                .color(0x3fcc60)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4850, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 1000)
                        .vacuumStats(VA[HV], 200))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_ROTOR)
                .components(Nickel, 8, Chrome, 6, Molybdenum, 4, Niobium, 4, Titanium, 3, Iron, 2, Aluminium, 2)
                .fluidPipeProperties(4500, 340, true, true, true, false)
                .build();
      
        //  12002 Hastelloy-N
        HastelloyN = new Material.Builder(getId(), gregtechId("hastelloy_n"))
                .ingot()
                .fluid()
                .color(0x939554)
                .iconSet(DULL)
                .blast(b -> b
                        .temp(4550, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[EV], 800)
                        .vacuumStats(VA[HV], 180))
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_BOLT_SCREW, GENERATE_ROTOR, GENERATE_FRAME)
                .components(Nickel, 15, Molybdenum, 4, Chrome, 2, Titanium, 2, Yttrium, 2)
                .fluidPipeProperties(4380, 300, true, true, true,false)
                .build();

        //  12003 Austenitic Stainless Steel-904L
        AusteniticStainlessSteel904L = new Material.Builder(getId(), gregtechId("super_austenitic_stainless_steel_904_l"))
                .ingot()
                .fluid()
                .color(0x881357)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4960, BlastProperty.GasTier.MID)
                        .blastStats(VA[EV], 944)
                        .vacuumStats(VA[HV], 320))
                .components(StainlessSteel, 8, NickelZincFerrite, 4, Kanthal, 4, Molybdenum, 4)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .build();

        //  12004 Tanmolyium Beta-C
        TanmolyiumBetaC = new Material.Builder(getId(), gregtechId("tanmolyium_beta_c"))
                .ingot()
                .fluid()
                .color(0xc72fcc)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(5300, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[IV], 800)
                        .vacuumStats(VA[HV], 400))
                .components(Titanium, 5, Molybdenum, 5, Vanadium, 2, Chrome, 3, Aluminium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12005 Talonite
        Talonite = new Material.Builder(getId(), gregtechId("talonite"))
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(SHINY)
                .blast(b -> b
                        .blastStats(VA[EV], 454)
                        .vacuumStats(VA[MV], 280))
                .components(Cobalt, 4, Chrome, 3, Phosphorus, 2, Molybdenum, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12006 Hastelloy-X78
        HastelloyX78 = new Material.Builder(getId(), gregtechId("hastelloy_x_78"))
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(12800, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[UHV], 1997)
                        .vacuumStats(VA[LuV], 340))
                .components(NaquadahAlloy, 10, Rhenium, 5, Naquadria, 4, Gadolinium, 3, Strontium, 2, Polonium, 3, Rutherfordium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12007 Silicon Carbide
        SiliconCarbide = new Material.Builder(getId(), gregtechId("silicon_carbide"))
                .dust()
                .fluid()
                .color(0x4D4D4D)
                .iconSet(METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blast(b -> b
                        .temp(2500, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[UV])
                        .vacuumStats(VA[EV], 280))
                .cableProperties(V[UHV], 6, 8, false)
                .build();

        //  12008 MAR-M200 Steel
        MARM200Steel = new Material.Builder(getId(), gregtechId("mar_m_200_steel"))
                .ingot()
                .fluid()
                .color(0x515151)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(5000, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[IV], 200)
                        .vacuumStats(VA[HV], 120))
                .components(Niobium, 2, Chrome, 9, Aluminium, 5, Titanium, 2, Cobalt, 10, Tungsten, 13, Nickel, 18)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12009 MAR-M200-Ce Steel
        MARM200CeSteel = new Material.Builder(getId(), gregtechId("mar_m_200_ce_steel"))
                .ingot()
                .fluid()
                .color(0x383030)
                .iconSet(BRIGHT)
                .blast(b -> b
                        .temp(7500, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 432)
                        .vacuumStats(VA[EV], 180))
                .components(MARM200Steel, 18, Cerium, 1)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12010 Stellite
        Stellite = new Material.Builder(getId(), gregtechId("stellite"))
                .ingot()
                .fluid()
                .color(0x9991A5)
                .iconSet(METALLIC)
                .blast(b -> b
                        .temp(4310, BlastProperty.GasTier.HIGH)
                        .blastStats(VA[EV], 220)
                        .vacuumStats(VA[MV], 90))
                .components(Chrome, 9, Cobalt, 9, Manganese, 5, Titanium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12011 Hastelloy-C59
        HastelloyC59 = new Material.Builder(getId(), gregtechId("hastelloy_c_59"))
                .ingot()
                .fluid()
                .color(0xD6D0F0)
                .iconSet(DULL)
                .blast(b -> b
                        .temp(7600, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 559)
                        .vacuumStats(VA[EV], 300))
                .components(Nickel, 18, Chrome, 16, TinAlloy, 8, Cobalt, 6, Niobium, 4, Aluminium, 4)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .build();

        //  12012 HMS-1J79Alloy
        HMS1J79Alloy = new Material.Builder(getId(), gregtechId("hms_1_j_79_alloy"))
                .ingot()
                .fluid()
                .color(0xD1CB0B)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(8100, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 886)
                        .vacuumStats(VA[EV], 400))
                .components(Nickel, 14, Iron, 12, Molybdenum, 11, CobaltBrass, 8, Chrome, 6, Silicon, 4)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .build();

        //  12013 High Strength Structural Steel-HY130-1
        HY1301 = new Material.Builder(getId(), gregtechId("hy_1301"))
                .ingot()
                .fluid()
                .color(0x6F3E57)
                .iconSet(SHINY)
                .blast(b -> b
                        .temp(7850, BlastProperty.GasTier.HIGHER)
                        .blastStats(VA[LuV], 766)
                        .vacuumStats(VA[EV], 357))
                .components(Nickel, 9, NickelZincFerrite, 6, Chrome, 4, Nichrome, 4, Iron, 4, Molybdenum, 4, Rhenium, 2)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();

        //  12014 Incoloy-MA813
        IncoloyMA813 = new Material.Builder(getId(), gregtechId("incoloy_ma_813"))
                .ingot()
                .fluid()
                .color(0x6CF076)
                .iconSet(SHINY)
                .components(VanadiumSteel, 4, Osmiridium, 2, HSSS, 3, Germanium, 4, Duranium, 5)
                .blast(b -> b
                        .temp(8400, BlastProperty.GasTier.HIGHEST)
                        .blastStats(VA[ZPM], 1277)
                        .vacuumStats(VA[IV], 400))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
