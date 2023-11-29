package magicbook.gtlitecore.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.Water;
import static gregtech.api.unification.material.info.MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static gregtech.api.util.GTUtility.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class GTLiteUnknownCompositionMaterials {

    //  Range: 18000-20000
    private static int startId = 18000;
    private static final int endId = startId + 2000;

    public static void register() {
        //  18000 Fracturing Fluid
        FracuringFluid = new Material.Builder(getId(), gregtechId("fracturing_fluid"))
                .liquid()
                .color(0x96D6D5)
                .build();

        //  18001 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = new Material.Builder(getId(), gregtechId("rare_earth_hydroxides_solution"))
                .liquid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        //  18002 Rare Earth Chlorides Solution
        RareEarthChloridesSolution = new Material.Builder(getId(), gregtechId("rare_earth_chlorides_solution"))
                .liquid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        //  18003 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = new Material.Builder(getId(), gregtechId("la_pr_nd_ce_oxides_solution"))
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        //  18004 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = new Material.Builder(getId(), gregtechId("sc_eu_gd_sm_oxides_solution"))
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        //  18005 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = new Material.Builder(getId(), gregtechId("y_tb_dy_ho_oxides_solution"))
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        //  18006 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = new Material.Builder(getId(), gregtechId("er_tm_yb_lu_oxides_solution"))
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
