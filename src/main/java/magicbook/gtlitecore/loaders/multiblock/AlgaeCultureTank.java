package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class AlgaeCultureTank {

    public static void init() {
        AlgaeProcessing();
        ExoticGasProcessing();
        HyperFuelProcessing();
        BiomassGeneratorRecipes();
    }

    private static void AlgaeProcessing() {

        //  TODO Exotic Mutagen catalyst algae recipes

        //  Barnarda C Algae
        SIFTER_RECIPES.recipeBuilder()
                .input(BARNARDA_C_BASE, 64)
                .output(BARNARDA_C_BRYOPSIS_HYPNOIDES, 10)
                .output(BARNARDA_C_CHLORELLA, 10)
                .output(BARNARDA_C_ZOOXANTHELLAE, 10)
                .chancedOutput(BARNARDA_C_BRYOPSIS_HYPNOIDES, 10, 1000, 500)
                .chancedOutput(BARNARDA_C_CHLORELLA, 10, 1000, 500)
                .chancedOutput(BARNARDA_C_ZOOXANTHELLAE, 10, 1000, 500)
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  Proxima B Algae
        SIFTER_RECIPES.recipeBuilder()
                .input(PROXIMA_B_BASE, 64)
                .output(PROXIMA_B_CONCHOSPORE, 10)
                .output(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 10)
                .output(PROXIMA_B_SPIROGYRA, 10)
                .chancedOutput(PROXIMA_B_CONCHOSPORE, 10, 1000, 500)
                .chancedOutput(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 10, 1000, 500)
                .chancedOutput(PROXIMA_B_SPIROGYRA, 10, 1000, 500)
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  Tau Ceti F Algae
        SIFTER_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_BASE, 64)
                .output(TAU_CETI_F_PHAEOPHYTA, 10)
                .output(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 10)
                .output(TAU_CETI_F_SPIRULINA, 10)
                .chancedOutput(TAU_CETI_F_PHAEOPHYTA, 10, 1000, 500)
                .chancedOutput(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 10, 1000, 500)
                .chancedOutput(TAU_CETI_F_SPIRULINA, 10, 1000, 500)
                .EUt(VA[EV])
                .duration(200)
                .buildAndRegister();

        //  Barnarda C Bryopsis Hypnoides
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(BARNARDA_C_BRYOPSIS_HYPNOIDES, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(BARNARDA_C_BRYOPSIS_HYPNOIDES, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(104)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Barnarda C Chlorella
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(BARNARDA_C_CHLORELLA, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(BARNARDA_C_CHLORELLA, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(121)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Barnarda C Zooxanthellae
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(BARNARDA_C_ZOOXANTHELLAE, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(BARNARDA_C_ZOOXANTHELLAE, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(109)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Proxima B Conchospore
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(PROXIMA_B_CONCHOSPORE, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(PROXIMA_B_CONCHOSPORE, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(99)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Proxima B Polysiphonia Senticulosa
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(103)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Proxima B Spirogyra
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(PROXIMA_B_SPIROGYRA, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(PROXIMA_B_SPIROGYRA, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(105)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Tau Ceti F Phaeophyta
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_PHAEOPHYTA, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(TAU_CETI_F_PHAEOPHYTA, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(120)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Tau Ceti F Scenedesmus Obliquus
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(117)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  Tau Ceti F Spirulina
        ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SPIRULINA, 2)
                .circuitMeta(1)
                .fluidInputs(Mutagen.getFluid(2))
                .output(TAU_CETI_F_SPIRULINA, 16)
                .EUt(VA[UV])
                .duration(200)
                .temperature(115)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();
    }

    private static void ExoticGasProcessing() {

        //  Algae -> Crude Exotic Gas
        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_BRYOPSIS_HYPNOIDES, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_CHLORELLA, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(BARNARDA_C_ZOOXANTHELLAE, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_CONCHOSPORE, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(PROXIMA_B_SPIROGYRA, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_PHAEOPHYTA, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SPIRULINA, 4)
                .fluidInputs(Biomass.getFluid(200))
                .circuitMeta(1)
                .fluidOutputs(CrudeExoticGas.getFluid(200))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        //  Crude Exotic Gas -> Cracked Crude Exotic Gas
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(CrudeExoticGas.getFluid(1000))
                .fluidInputs(MetastableOganesson.getFluid(1000))
                .fluidOutputs(CrackedCrudeExoticGas.getFluid(2000))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Cs + F -> CsF
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .fluidInputs(Fluorine.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(CaesiumFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Xe + 3O -> XeO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Xenon.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(XenonTrioxide.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Rn + 3O -> RnO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Radon.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .circuitMeta(3)
                .fluidOutputs(RadonTrioxide.getFluid(1000))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  RnO3 + 2HF -> RnF2 + H2O + O (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RadonTrioxide.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(RadonDifluoride.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[EV])
                .duration(50)
                .buildAndRegister();

        //  *Nq* dust + RnF2 + 6HF -> Rn*Nq*F8 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Naquadria)
                .fluidInputs(RadonDifluoride.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidOutputs(RadonNaquadriaOctafluoride.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[UV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  CsF + XeO3 -> CsXeO3F
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CaesiumFluoride.getFluid(1000))
                .fluidInputs(XenonTrioxide.getFluid(1000))
                .fluidOutputs(CaesiumXenontrioxideFluoride.getFluid(1000))
                .EUt(VA[MV])
                .duration(480)
                .buildAndRegister();

        //  Rn*Nq*F8 + CsXeO3F -> *Nq*CsXeF9 + RnO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(RadonNaquadriaOctafluoride.getFluid(1000))
                .fluidInputs(CaesiumXenontrioxideFluoride.getFluid(1000))
                .fluidOutputs(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .fluidOutputs(RadonTrioxide.getFluid(1000))
                .EUt(VA[IV])
                .duration(800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cracked Crude Exotic Gas + *Nq*CsXeF9 -> Naquadic Exotic Gas
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CrackedCrudeExoticGas.getFluid(8000))
                .fluidInputs(NaquadriaCaesiumXenonnonfluoride.getFluid(1000))
                .fluidOutputs(NaquadicExoticGas.getFluid(4000))
                .fluidOutputs(NaquadriaCaesiumfluoride.getFluid(1000))
                .EUt(VA[UHV])
                .temperature(40976)
                .duration(200)
                .buildAndRegister();

        //  Naquadic Exotic Gas process
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(NaquadicExoticGas.getFluid(4000))
                .output(dust, Tiberium)
                .fluidOutputs(SuperheavyExoticGas.getFluid(200))
                .fluidOutputs(HeavyExoticGas.getFluid(400))
                .fluidOutputs(MediumExoticGas.getFluid(1400))
                .fluidOutputs(LightExoticGas.getFluid(2000))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  *Nq*F2CsF -> *Nq* (cycle) + Cs (cycle) + 3F
        CHEMICAL_DRYER_RECIPES.recipeBuilder()
                .fluidInputs(NaquadriaCaesiumfluoride.getFluid(1000))
                .output(dust, Naquadria)
                .output(dust, Caesium)
                .fluidOutputs(Fluorine.getFluid(3000))
                .EUt(VA[ZPM])
                .duration(40)
                .buildAndRegister();

        //  Exotic Gas
        if (GTLiteConfigHolder.misc.enableExoticGasTurbineRecipe) {
            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(SuperheavyExoticGas.getFluid(1))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(480)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(HeavyExoticGas.getFluid(2))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(360)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(MediumExoticGas.getFluid(4))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(180)
                    .buildAndRegister();

            GAS_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(LightExoticGas.getFluid(8))
                    .EUt(GTLiteConfigHolder.misc.heatValueExoticGas)
                    .duration(90)
                    .buildAndRegister();
        }
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
