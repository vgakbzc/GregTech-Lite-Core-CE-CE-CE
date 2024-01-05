package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SupracausalCircuits {

    public static void init() {
        CircuitBoard();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        //  Supracausal Board
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(plate, BlackDwarfMatter, 2)
                .input(plate, Hypogen, 2)
                .input(STABILIZED_WORMHOLE_GENERATOR)
                .input(swarm, CarbonNanotube)
                .input(wireFine, Hikarium, 8)
                .fluidInputs(Galaxium.getFluid(L))
                .output(SPACETIME_CONDENSER)
                .stationResearch(b -> b
                        .researchStack(COSMIC_INFORMATION_MODULE.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(256))
                .EUt(VA[UXV])
                .duration(20)
                .buildAndRegister();

        //  Supracausal Processing Unit
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, TantalumHafniumSeaborgiumCarbide)
                .input(SPACETIME_CONDENSER)
                .input(plate, CosmicFabric, 4)
                .input(QCD_PROTECTIVE_PLATING, 4)
                .input(NUCLEAR_CLOCK)
                .input(TOPOLOGICAL_MANIPULATOR_UNIT)
                .input(GRAVITON_TRANSDUCER)
                .input(EIGENFOLDED_SPACETIME_MANIFOLD)
                .input(BOSE_EINSTEIN_CONDENSATE, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(wireGtSingle, HeavyQuarkDegenerateMatter, 2)
                .fluidInputs(CosmicComputingMixture.getFluid(4000))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(2000))
                .fluidInputs(Spacetime.getFluid(1000))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(LIGHT_CONE_MODULE, 2)
                .EUt(VA[UXV])
                .duration(20)
                .CasingTier(5)
                .buildAndRegister();

    }

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, WhiteDwarfMatter, 8)
                .input(plate, NeutroniumNanotube)
                .input(plate, Periodicium)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_TRANSISTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(dust, ChargedCaesiumCeriumCobaltIndiumAlloy)
                .input(wireFine, QuantumchromodynamicallyConfinedMatter, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_RESISTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .temperature(6675)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, Hypogen)
                .input(wireFine, BlackDwarfMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_CAPACITOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .temperature(7432)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Spacetime)
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(wireFine, HeavyQuarkDegenerateMatter, 8)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_DIODE, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, TantalumHafniumSeaborgiumCarbide)
                .input(wireFine, CosmicNeutronium, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(SUPRACAUSAL_INDUCTOR, 32)
                .EUt(VA[UIV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Supracausal Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(LIGHT_CONE_MODULE)
                .input(INTRAVITAL_SOC)
                .input(SUPRACAUSAL_RESISTOR, 8)
                .input(SUPRACAUSAL_CAPACITOR, 8)
                .input(SUPRACAUSAL_TRANSISTOR, 8)
                .input(wireFine, Hypogen, 8)
                .solderMultiplier(1)
                .output(SUPRACAUSAL_PROCESSOR, 2)
                .EUt(VA[UXV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_PROCESSOR, 2)
                .input(SUPRACAUSAL_INDUCTOR, 6)
                .input(SUPRACAUSAL_CAPACITOR, 12)
                .input(COSMIC_MEMORY_CHIP, 24) // TODO new RAM
                .input(wireFine, Hypogen, 8)
                .solderMultiplier(2)
                .output(SUPRACAUSAL_ASSEMBLY, 2)
                .EUt(VA[UXV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Supracausal Supercomputer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPACETIME_CONDENSER)
                .input(SUPRACAUSAL_ASSEMBLY, 2)
                .input(SUPRACAUSAL_DIODE, 8)
                .input(COSMIC_CPU_CHIP, 16) // TODO new chip
                .input(COSMIC_MEMORY_CHIP, 32) // TODO new RAM
                .input(wireFine, HeavyQuarkDegenerateMatter, 24)
                .input(foil, Hikarium, 32)
                .input(plate, BlackDwarfMatter, 4)
                .fluidInputs(SolderingAlloy.getFluid(34560))
                .fluidInputs(Kevlar.getFluid(18432))
                .fluidInputs(Zylon.getFluid(9216))
                .fluidInputs(Hypogen.getFluid(4608))
                .output(SUPRACAUSAL_COMPUTER)
                .stationResearch(b -> b
                        .researchStack(SUPRACAUSAL_ASSEMBLY.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(512))
                .duration(400)
                .EUt(VA[UXV])
                .buildAndRegister();

        //  TODO Mainframe
    }
}
