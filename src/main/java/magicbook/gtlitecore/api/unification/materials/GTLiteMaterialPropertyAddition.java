package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.fluids.store.FluidStorageKeys.LIQUID;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags.*;

public class GTLiteMaterialPropertyAddition {
    public static void init() {

        //  Platinum Group
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);
        FluidProperty prop = new FluidProperty();
        prop.setPrimaryKey(LIQUID);
        SodiumBisulfate.setProperty(PropertyKey.FLUID, prop);

        //  Milled
        Almandine.addFlags(GENERATE_MILLED);
        Chalcopyrite.addFlags(GENERATE_MILLED);
        Grossular.addFlags(GENERATE_MILLED);
        Monazite.addFlags(GENERATE_MILLED);
        Nickel.addFlags(GENERATE_MILLED);
        Platinum.addFlags(GENERATE_MILLED);
        Pyrope.addFlags(GENERATE_MILLED);
        Redstone.addFlags(GENERATE_MILLED);
        Spessartine.addFlags(GENERATE_MILLED);
        Sphalerite.addFlags(GENERATE_MILLED);
    }
}
