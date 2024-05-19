package magicbook.gtlitecore.loaders.multiblock;

import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class AlgaeCultureTank {

    public static void init() {
        //AlgaeProcessing();
        //ExoticGasProcessing();
        HyperFuelProcessing();
        BiomassGeneratorRecipes();
    }
    private static void ExoticGasProcessing() {
    }

    private static void HyperFuelProcessing() {
        //  Hyper Fuel Mk II
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(11)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(HeavyHyperFuel.getFluid(400))
                .fluidInputs(SuperheavyExoticGas.getFluid(200))
                .fluidOutputs(HyperFuelMkII.getFluid(3000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(12)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(HeavyHyperFuel.getFluid(800))
                .fluidInputs(HeavyExoticGas.getFluid(400))
                .fluidOutputs(HyperFuelMkII.getFluid(2000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(13)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(MediumHyperFuel.getFluid(1600))
                .fluidInputs(MediumExoticGas.getFluid(1400))
                .fluidOutputs(HyperFuelMkII.getFluid(1000))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Tiberium)
                .input(dust, OrichalcumEnergized)
                .circuitMeta(13)
                .fluidInputs(NaquadahEnriched.getFluid(2000))
                .fluidInputs(Vibranium.getPlasma(1000))
                .fluidInputs(LightHyperFuel.getFluid(3200))
                .fluidInputs(LightExoticGas.getFluid(2000))
                .fluidOutputs(HyperFuelMkII.getFluid(500))
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkII.getFluid(1))
                .duration(300)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark2)
                .buildAndRegister();

        //  Hyper Reactor Mk III
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Rhugnor)
                .input(dust, Adamantium)
                .circuitMeta(14)
                .fluidInputs(StarlightLiquid.getFluid(8000))
                .fluidInputs(AstralTitanium.getFluid(1000))
                .fluidInputs(CelestialTungsten.getFluid(1000))
                .fluidInputs(HyperFuelMkII.getFluid(2000))
                .fluidOutputs(HyperFuelMkIII.getFluid(1000))
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkIII.getFluid(1))
                .duration(600)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark3)
                .buildAndRegister();

        //  Hyper Reactor Mk IV
        FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
                .input(dust, Hypogen)
                .input(dust, Astralium)
                .circuitMeta(15)
                .fluidInputs(Ichorium.getFluid(8000))
                .fluidInputs(Galaxium.getFluid(2000))
                .fluidInputs(CrystalMatrix.getFluid(2000))
                .fluidInputs(HyperFuelMkIII.getFluid(4000))
                .fluidOutputs(HyperFuelMkIV.getFluid(500))
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();

        HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
                .fluidInputs(HyperFuelMkIV.getFluid(1))
                .duration(1200)
                .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark4)
                .buildAndRegister();
    }

    private static void BiomassGeneratorRecipes() {

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Biomass.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueBiomass)
                .duration(10)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(FermentedBiomass.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueFermentedBiomass)
                .duration(20)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(BacterialSludge.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueBacterialSludge)
                .duration(30)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedBacterialSludge.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueBacterialSludge)
                .duration(40)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(SterileGrowthMedium.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueSterileGrowthMedium)
                .duration(50)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Mutagen.getFluid(200))
                .EUt(GTLiteConfigHolder.misc.heatValueMutagen)
                .duration(60)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(ExoticMutagen.getFluid(400))
                .EUt(GTLiteConfigHolder.misc.heatValueExoticMutagen)
                .duration(80)
                .buildAndRegister();
    }
}
