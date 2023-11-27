package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteUnknownCompositionMaterials {

    //  Range: 18000-20000
    private static int startId = 18000;
    private static final int endId = startId + 2000;

    public static void register() {
        //  18000 Fracturing Fluid
        FracuringFluid = new Material.Builder(getId(), gregtechId("fracturing_fluid"))
                .fluid()
                .color(0x96D6D5)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
