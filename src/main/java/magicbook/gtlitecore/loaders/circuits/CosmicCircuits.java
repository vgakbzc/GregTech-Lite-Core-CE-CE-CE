package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SoC();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(plate, DegenerateRhenium, 2)
                .input(plate, HeavyQuarkDegenerateMatter, 2)
                .input(wireFine, Abyssalloy, 6)
                .fluidInputs(Astralium.getFluid(L))
                .output(COSMIC_INFORMATION_MODULE)
                .EUt(VA[UIV])
                .duration(50)
                .CasingTier(4)
                .buildAndRegister();

        //  Cosmic Circuit Board
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(frameGt, BlackPlutonium)
                .input(COSMIC_INFORMATION_MODULE)
                .input(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
                .input(CLADDED_OPTICAL_FIBER_CORE, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 4)
                .input(wireGtSingle, AstralTitanium, 2)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .fluidInputs(PlatinumGroupAlloy.getFluid(L))
                .output(HOLOGRAPHIC_INFORMATION_IMC, 2)
                .EUt(VA[UIV])
                .duration(20)
                .CasingTier(5)
                .buildAndRegister();
    }

    private static void CircuitComponent() {

        ScintillatorChain();

        //  Nuclear Clock
        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(SCINTILLATOR)
                .input(plate, Osmiridium, 2)
                .input(SENSOR_UEV)
                .input(ND_YAG_LASER, 2)
                .input(lens, LuTmYVO)
                .input(wireGtSingle, RutheniumTriniumAmericiumNeutronate, 2)
                .fluidInputs(Mithril.getFluid(L * 4))
                .fluidInputs(Thorium.getFluid(5000))
                .output(NUCLEAR_CLOCK)
                .EUt(VA[UEV])
                .duration(35)
                .CasingTier(4)
                .buildAndRegister();

        //  Closed Time-like Curve Guidance Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(NUCLEAR_CLOCK)
                .input(TOOL_DATA_ORB)
                .input(plate, MetastableFlerovium)
                .input(wireFine, QuantumAlloy, 4)
                .fluidInputs(SuperheavyHAlloy.getFluid(L))
                .output(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .EUt(VA[UIV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Closed Time-like Curve Computational Unit
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(plate, SuperheavyLAlloy, 2)
                .input(wireFine, Infinity, 4)
                .fluidInputs(Gluons.getFluid(2000))
                .fluidInputs(Neutronium.getFluid(L * 2))
                .output(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT, 2)
                .EUt(VA[UIV])
                .duration(200)
                .CasingTier(3)
                .buildAndRegister();

        //  Cladded Optical Fiber Core
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(wireFine, ZBLANGlass)
                .fluidInputs(Zylon.getFluid(16))
                .output(CLADDED_OPTICAL_FIBER_CORE)
                .EUt(VA[LuV])
                .duration(200)
                .buildAndRegister();

        //  Cosmic CPU
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .fluidInputs(CosmicComputingMixture.getFluid(L))
                .output(UNTREATED_COSMIC_CPU)
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .fluidInputs(CosmicNeutronium.getFluid(16))
                .output(UNTREATED_COSMIC_CPU)
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                .input(UNTREATED_COSMIC_CPU)
                .input(plate, CelestialTungsten, 2)
                .input(plate, QuantumchromodynamicallyConfinedMatter, 2)
                .input(wireFine, SuperheavyHAlloy, 4)
                .fluidInputs(TetramethylammoniumHydroxide.getFluid(3000))
                .fluidInputs(EDP.getFluid(3000))
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(COSMIC_CPU)
                .EUt(VA[UEV])
                .duration(20)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(COSMIC_CPU)
                .fluidInputs(Lubricant.getFluid(6000))
                .output(COSMIC_CPU_CHIP, 64)
                .EUt(VA[UV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void SoC() {}

    private static void SMDs() {

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 8)
                .input(plate, DegenerateRhenium)
                .input(plate, MetastableHassium)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_TRANSISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyLAlloy, 4)
                .input(dust, LanthanumFullereneNanotube)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_RESISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(4960)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyHAlloy, 8)
                .input(plate, Rhugnor)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_CAPACITOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(5630)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(plate, CelestialTungsten)
                .input(dust, PlatinumGroupAlloy, 4)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_INDUCTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, CelestialTungsten)
                .input(dust, CubicBoronNitride)
                .input(wireFine, AstralTitanium, 8)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_DIODE, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic RAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, MetastableHassium, 2)
                .input(plate, MetastableFlerovium, 2)
                .input(foil, AstralTitanium, 8)
                .input(wireFine, SuperheavyLAlloy, 16)
                .output(COSMIC_MEMORY_CHIP, 4)
                .EUt(VA[UIV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Cosmic Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(HOLOGRAPHIC_INFORMATION_IMC)
                .input(INTRAVITAL_SOC)
                .input(COSMIC_RESISTOR, 8)
                .input(COSMIC_CAPACITOR, 8)
                .input(COSMIC_TRANSISTOR, 8)
                .input(wireFine, Infinity, 8)
                .solderMultiplier(1)
                .output(COSMIC_PROCESSOR, 2)
                .EUt(VA[UIV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(COSMIC_PROCESSOR, 2)
                .input(COSMIC_INDUCTOR, 6)
                .input(COSMIC_CAPACITOR, 12)
                .input(COSMIC_MEMORY_CHIP, 24)
                .input(wireFine, Infinity, 8)
                .solderMultiplier(2)
                .output(COSMIC_ASSEMBLY, 2)
                .EUt(VA[UIV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Supercomputer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(COSMIC_ASSEMBLY, 2)
                .input(COSMIC_DIODE, 8)
                .input(COSMIC_CPU_CHIP, 16)
                .input(COSMIC_MEMORY_CHIP, 32)
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 24)
                .input(foil, CelestialTungsten, 32)
                .input(plate, MetastableHassium, 4)
                .fluidInputs(SolderingAlloy.getFluid(17280))
                .fluidInputs(Kevlar.getFluid(9216))
                .fluidInputs(Zylon.getFluid(4608))
                .fluidInputs(Infinity.getFluid(2304))
                .output(COSMIC_COMPUTER)
                .stationResearch(b -> b
                        .researchStack(COSMIC_ASSEMBLY.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(256))
                .duration(400)
                .EUt(VA[UIV])
                .buildAndRegister();

        //  Cosmic Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity, 2)
                .input(COSMIC_COMPUTER, 2)
                .input(COSMIC_DIODE, 16)
                .input(COSMIC_CAPACITOR, 16)
                .input(COSMIC_TRANSISTOR, 16)
                .input(COSMIC_RESISTOR, 16)
                .input(COSMIC_INDUCTOR, 16)
                .input(foil, Astralium, 16)
                .input(COSMIC_MEMORY_CHIP, 32)
                .input(wireGtDouble, BoronFranciumCarbideSuperconductor, 16)
                .input(plate, Rhugnor, 8)
                .fluidInputs(SolderingAlloy.getFluid(21888))
                .fluidInputs(FullerenePolymerMatrix.getFluid(17280))
                .fluidInputs(Zylon.getFluid(8640))
                .fluidInputs(Polyetheretherketone.getFluid(4608))
                .output(COSMIC_MAINFRAME)
                .stationResearch(b -> b
                        .researchStack(COSMIC_COMPUTER.getStackForm())
                        .EUt(VA[UXV])
                        .CWUt(512))
                .duration(1200)
                .EUt(VA[UXV])
                .buildAndRegister();
    }

    private static void ScintillatorChain() {

        //  Cs + I -> CsI
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .input(dust, Iodine)
                .output(dust, CaesiumIodide, 2)
                .EUt(VA[MV])
                .duration(340)
                .buildAndRegister();

        //  CsI + Tl + Tm -> Tl/Tm:CsI
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CaesiumIodide, 2)
                .input(dust, Thallium)
                .input(dust, Thulium)
                .output(dust, TlTmDopedCaesiumIodide, 4)
                .EUt(VA[EV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  WO3 + CdS + 3O -> CdWO4 + SO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .input(dust, CadmiumSulfide, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, CadmiumTungstate, 6)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(VA[IV])
                .duration(120)
                .buildAndRegister();

        //  3GeO2 + 2Bi2O3 -> Bi4Ge3O12
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 9)
                .input(dust, BismuthTrioxide, 10)
                .output(dust, BismuthGermanate, 19)
                .EUt(VA[LuV])
                .duration(50)
                .buildAndRegister();

        //  Scintillator Crystal
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PlatinumGroupAlloy)
                .input(dust, CelestialCrystal)
                .input(dust, TlTmDopedCaesiumIodide, 4)
                .input(dust, CadmiumTungstate, 6)
                .input(dust, BismuthGermanate, 19)
                .output(SCINTILLATOR_CRYSTAL)
                .EUt(VA[UHV])
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Scintillator
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SCINTILLATOR_CRYSTAL)
                .input(SEPARATION_ELECTROMAGNET)
                .input(plate, Zylon, 2)
                .input(screw, Hdcs, 4)
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(SCINTILLATOR)
                .EUt(VA[UHV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
