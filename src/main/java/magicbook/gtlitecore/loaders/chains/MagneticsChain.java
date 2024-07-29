package magicbook.gtlitecore.loaders.chains;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CENTRIFUGE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.COMPRESSOR_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.seedCrystal;

public class MagneticsChain {

    public static void init() {
        PlutoniumPhosphideChain();
        NeptuniumAluminideChain();
        BismuthFerriteChain();
        ThalliumCopperChlorideChain();
    }

    private static void PlutoniumPhosphideChain() {

        //  Pu + 3H -> PuH3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Plutonium239)
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, PlutoniumTrihydride, 4)
                .EUt(VA[IV])
                .duration(3 * SECOND)
                .buildAndRegister();

        // Pu + PH3 -> PuP + 6H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PlutoniumTrihydride, 4)
                .fluidInputs(Phosphine.getFluid(1000))
                .output(ingot, PlutoniumPhosphide, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[IV])
                .duration(3 * SECOND)
                .buildAndRegister();
    }

    private static void NeptuniumAluminideChain() {

        //  Np + 3Al -> NpAl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Neptunium)
                .input(dust, Aluminium, 3)
                .output(dust, NeptuniumAluminide, 4)
                .EUt(VA[IV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }

    private static void BismuthFerriteChain() {

        //  2Bi + 3H2O -> Bi2O3 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 2)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, BismuthTrioxide, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VHA[MV])
                .duration(2 * SECOND + 10)
                .buildAndRegister();

        //  2Fe + 3O -> Fe2O3
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, FerricOxide, 5)
                .EUt(VA[MV])
                .duration(2 * SECOND + 10)
                .temperature(473)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, BandedIron)
                .output(dust, FerricOxide)
                .EUt((int) V[ULV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  4Bi2O3 + Fe2O3 -> BiFeO3
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, BismuthTrioxide, 20)
                .input(dust, FerricOxide, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, BismuthFerrite)
                .EUt(VA[LuV])
                .duration(MINUTE - 10 * SECOND)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, BismuthFerrite)
                .output(plate, BismuthFerrite)
                .EUt(VH[ULV] / 2)
                .duration(20 * SECOND)
                .buildAndRegister();
    }

    private static void ThalliumCopperChlorideChain() {

        //  Tl + Cu + 3Cl -> TlCuCl3
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(ThalliumCopperChloride.getFluid(L * 5))
                .EUt(VA[EV])
                .duration(35 * SECOND)
                .blastFurnaceTemp(1570)
                .buildAndRegister();
    }
}
