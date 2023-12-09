package magicbook.gtlitecore.loaders.chains;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
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
                .duration(60)
                .EUt(VA[IV])
                .buildAndRegister();

        // Pu + PH3 -> PuP + 6H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PlutoniumTrihydride, 4)
                .fluidInputs(Phosphine.getFluid(1000))
                .output(ingot, PlutoniumPhosphide, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(60)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void NeptuniumAluminideChain() {

        //  Np + 3Al -> NpAl3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Neptunium)
                .input(dust, Aluminium, 3)
                .output(dust, NeptuniumAluminide, 4)
                .duration(400)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void BismuthFerriteChain() {

        //  2Bi + 3H2O -> Bi2O3 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 2)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, BismuthTrioxide, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(50)
                .EUt(60)
                .buildAndRegister();

        //  2Fe + 3O -> Fe2O3
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, FerricOxide, 5)
                .temperature(473)
                .duration(50)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, BandedIron)
                .output(dust, FerricOxide)
                .duration(200)
                .EUt(8)
                .buildAndRegister();

        //  4Bi2O3 + Fe2O3 -> BiFeO3
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, BismuthTrioxide, 20)
                .input(dust, FerricOxide, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, BismuthFerrite)
                .duration(1000)
                .EUt(VA[LuV])
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, BismuthFerrite)
                .output(plate, BismuthFerrite)
                .duration(400)
                .EUt(2)
                .buildAndRegister();
    }

    private static void ThalliumCopperChlorideChain() {

        //  Tl + Cu + 3Cl -> TlCuCl3
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(ThalliumCopperChloride.getFluid(L * 5))
                .blastFurnaceTemp(1570)
                .duration(700)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
