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
                        .blastStats(VA[IV], 1800)
                        .vacuumStats(VA[HV], 400))
                .components(Titanium, 5, Molybdenum, 5, Vanadium, 2, Chrome, 3, Aluminium, 1)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
