package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class AlgaeCultureTank {

    public static void init() {

        ExoticGasProcessing();
        BiomassGeneratorRecipes();

        for (FluidStack stack : new FluidStack[]{
                Biomass.getFluid(32000),
                SterileGrowthMedium.getFluid(24000)
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Mutagen.getFluid(16000),
                    ExoticMutagen.getFluid(8000)
            }) {
                for (FluidStack subsubstack : new FluidStack[] {
                        Helium.getPlasma(4000),
                        Argon.getPlasma(4000),
                        Nitrogen.getPlasma(4000),
                        Oxygen.getPlasma(4000),
                        Tin.getPlasma(4000),
                        Iron.getPlasma(4000),
                        Nickel.getPlasma(4000),
                        Americium.getPlasma(4000)
                }) {
                    ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                            .input(BARNARDA_C_BASE, 64 * 6)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{subsubstack})
                            .chancedOutput(BARNARDA_C_BRYOPSIS_HYPNOIDES, 64, 2000, 500)
                            .chancedOutput(BARNARDA_C_CHLORELLA, 64, 2000, 500)
                            .chancedOutput(BARNARDA_C_ZOOXANTHELLAE, 64, 2000, 500)
                            .fluidOutputs(EnrichedBacterialSludge.getFluid(2000))
                            .fluidOutputs(BacterialSludge.getFluid(4000))
                            .fluidOutputs(Bacteria.getFluid(8000))
                            .EUt(VA[UHV])
                            .duration(200)
                            .temperature(49930)
                            .cleanroom(CleanroomType.STERILE_CLEANROOM)
                            .buildAndRegister();

                    ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                            .input(PROXIMA_B_BASE, 64 * 6)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{subsubstack})
                            .chancedOutput(PROXIMA_B_CONCHOSPORE, 64, 2000, 500)
                            .chancedOutput(PROXIMA_B_POLYSIPHONIA_SENTICULOSA, 64, 2000, 500)
                            .chancedOutput(PROXIMA_B_SPIROGYRA, 64, 2000, 500)
                            .fluidOutputs(EnrichedBacterialSludge.getFluid(2000))
                            .fluidOutputs(BacterialSludge.getFluid(4000))
                            .fluidOutputs(Bacteria.getFluid(8000))
                            .EUt(VA[UHV])
                            .duration(200)
                            .temperature(51029)
                            .cleanroom(CleanroomType.STERILE_CLEANROOM)
                            .buildAndRegister();

                    ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
                            .input(TAU_CETI_F_BASE, 64 * 6)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{subsubstack})
                            .chancedOutput(TAU_CETI_F_PHAEOPHYTA, 64, 2000, 500)
                            .chancedOutput(TAU_CETI_F_SCENEDESMUS_OBLIQUUS, 64, 2000, 500)
                            .chancedOutput(TAU_CETI_F_SPIRULINA, 64, 2000, 500)
                            .fluidOutputs(EnrichedBacterialSludge.getFluid(2000))
                            .fluidOutputs(BacterialSludge.getFluid(4000))
                            .fluidOutputs(Bacteria.getFluid(8000))
                            .EUt(VA[UHV])
                            .duration(200)
                            .temperature(55376)
                            .cleanroom(CleanroomType.STERILE_CLEANROOM)
                            .buildAndRegister();

                }
            }
        }

    }

    private static void ExoticGasProcessing() {

        //  Algae -> Crude Exotic Gas
        DISTILLERY_RECIPES.recipeBuilder()
                .input(BARNARDA_C_BRYOPSIS_HYPNOIDES)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(BARNARDA_C_CHLORELLA)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(BARNARDA_C_ZOOXANTHELLAE)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(PROXIMA_B_CONCHOSPORE)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(PROXIMA_B_POLYSIPHONIA_SENTICULOSA)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(PROXIMA_B_SPIROGYRA)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_PHAEOPHYTA)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SCENEDESMUS_OBLIQUUS)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .input(TAU_CETI_F_SPIRULINA)
                .fluidOutputs(CrudeExoticGas.getFluid(10))
                .EUt(VA[IV])
                .duration(10)
                .buildAndRegister();

        //  Crude Exotic Gas -> Cracked Crude Exotic Gas
        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(CrudeExoticGas.getFluid(1000))
                .fluidInputs(MetastableOganesson.getFluid(8000))
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
                .EUt((int) V[ZPM])
                .buildAndRegister();

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
                .EUt((int) V[UV])
                .buildAndRegister();

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
                .EUt((int) V[UHV])
                .buildAndRegister();

    }

    private static void BiomassGeneratorRecipes() {

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Biomass.getFluid(200))
                .EUt(VA[MV])
                .duration(10)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(FermentedBiomass.getFluid(200))
                .EUt(VA[MV])
                .duration(20)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(BacterialSludge.getFluid(200))
                .EUt(VA[HV])
                .duration(30)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(EnrichedBacterialSludge.getFluid(200))
                .EUt(VA[HV])
                .duration(40)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(SterileGrowthMedium.getFluid(200))
                .EUt(VA[EV])
                .duration(50)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Mutagen.getFluid(200))
                .EUt(VA[HV])
                .duration(60)
                .buildAndRegister();

        BIOMASS_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(ExoticMutagen.getFluid(400))
                .EUt(VA[EV])
                .duration(80)
                .buildAndRegister();
    }
}
