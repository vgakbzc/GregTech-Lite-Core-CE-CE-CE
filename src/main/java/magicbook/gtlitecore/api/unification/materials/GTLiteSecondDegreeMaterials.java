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
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
