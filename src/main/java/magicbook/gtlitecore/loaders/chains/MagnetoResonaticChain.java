package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.BismuthTellurite;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.CubicZirconia;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.MagnetoResonatic;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Prasiolite;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.seedCrystal;

public class MagnetoResonaticChain {

    public static void init() {

        //  2.5 SiO2 + Fe -> (SiO2)5Fe
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 5)
                .input(dust, Iron)
                .fluidInputs(DistilledWater.getFluid(L))
                .output(seedCrystal, Prasiolite)
                .EUt(VA[MV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  3Te + 2Bi -> Be2Te3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Tellurium, 3)
                .input(dust, Bismuth, 2)
                .notConsumable(SulfuricAcid.getFluid(1))
                .output(dust, BismuthTellurite, 5)
                .EUt(VA[MV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Magneto Resonatic
        MIXER_RECIPES.recipeBuilder()
                .input(dust, BismuthTellurite, 4)
                .input(dust, Prasiolite, 3)
                .input(dust, CubicZirconia)
                .input(dust, SteelMagnetic)
                .circuitMeta(4)
                .output(dust, MagnetoResonatic, 9)
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();
    }
}
