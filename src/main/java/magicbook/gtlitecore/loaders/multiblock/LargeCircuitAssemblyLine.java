package magicbook.gtlitecore.loaders.multiblock;

import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class LargeCircuitAssemblyLine {

    public static void init() {
        Circuits();
        WrapComponents();
    }

    private static void Circuits() {

        //  In recipes, please put not consumable item on the last slot in item input slots.
        //  Because Large Circuit Assembly Line use special ui, you should make it on special slot on left hand.

        //  You do not need to use Data stick or other items to storage circuit's info.
        //  You just needs to put circuit in bus, it is not consumable.

        PrimitiveCircuits();   // LV-MV
        IntegratedCircuits();  // LV-HV
        ProcessorCircuits();   // ULV-IV
        NanoCircuits();        // HV-LuV
        QuantumCircuits();     // EV-ZPM
        CrystalCircuits();     // IV-UV
        WetwareCircuits();     // LuV-UHV
        GoowareCircuits();     // ZPM-UEV
        OpticalCircuits();     // UV-UIV
        SpintronicCircuits();  // UHV-UXV
        CosmicCircuits();      // UEV-OpV
        SupracausalCircuits(); // UIV-MAX

        //  Duration List
        //  ULV: 10s, LV-MV: 20s, HV-EV: 40s, IV-LuV: 60s, ZPM-UV: 80s,
        //  UHV-UEV: 100s, UIV-UXV: 120s, OpV: 140s, MAX: 150s
    }

    private static void WrapComponents() {
        WrapCircuitBoard();
        WrapSMD();
    }

    private static void PrimitiveCircuits() {

        //  This recipe is not filled with enough slots, but we can separate some item to meet the visual effect.
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
            //  LV Electronic Circuit
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(ELECTRONIC_CIRCUIT_LV)
                    .input(WRAP_BASIC_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(WRAP_SMD_RESISTOR, 2) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_RESISTOR, 2)
                    .input(wireGtHex, RedAlloy, 4) // (2 * 64 = 8 * 16) / 2
                    .input(WRAP_CIRCUIT_ULV, 2) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_CIRCUIT_ULV, 2)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRONIC_CIRCUIT_LV, 64)
                    .EUt(VH[LV])
                    .duration(400)
                    .buildAndRegister();

            //  MV Electronic Circuit
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(ELECTRONIC_CIRCUIT_MV)
                    .input(WRAP_GOOD_CIRCUIT_BOARD, 4) // (4 * 16) / 2
                    .input(WRAP_CIRCUIT_LV, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_CIRCUIT_LV, 4)
                    .input(WRAP_SMD_DIODE, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_DIODE, 4)
                    .input(wireGtHex, Copper, 8) // (2 * 64 = 8 * 16) / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRONIC_CIRCUIT_MV, 64)
                    .EUt(VH[MV])
                    .duration(400)
                    .buildAndRegister();
        }
    }

    private static void IntegratedCircuits() {
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
            //  LV Integrated Circuit
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(INTEGRATED_CIRCUIT_LV)
                    .input(WRAP_BASIC_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(INTEGRATED_LOGIC_CIRCUIT_WAFER, 4) // 1 wafer = 8 chip = 16 circuit
                    .input(WRAP_SMD_RESISTOR, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_DIODE, 4) // (8 * 16 = 2 * 64) / 2
                    .input(wireGtHex, Copper, 2) // [4 * 16 = 64 (wire) = 2 * 64 (fine wire)] / 2
                    .input(stickLong, Tin, 8) // [16 long stick = 32 stick = 2 * 64 bolt] / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(INTEGRATED_CIRCUIT_LV, 64)
                    .EUt(VH[LV])
                    .duration(400)
                    .buildAndRegister();

            //  MV Integrated Circuit
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(INTEGRATED_CIRCUIT_MV)
                    .input(WRAP_GOOD_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(WRAP_CIRCUIT_LV, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_RESISTOR, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_DIODE, 4) // (8 * 16 = 2 * 64) / 2
                    .input(wireGtHex, Gold, 4) // [8 * 16 = 128 (wire) = 4 * 64 (fine wire)] / 2
                    .input(stickLong, Silver, 16) // [32 long stick = 64 stick = 4 * 64 bolt] / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(INTEGRATED_CIRCUIT_MV, 64)
                    .EUt(VH[MV])
                    .duration(400)
                    .buildAndRegister();

            //  HV Integrated Circuit
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(INTEGRATED_CIRCUIT_HV)
                    .input(WRAP_CIRCUIT_MV, 8) // (8 * 16 = 2 * 64)
                    .input(INTEGRATED_LOGIC_CIRCUIT_WAFER, 8) // 1 wafer = 8 chip = 4 circuit
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 4) // 1 wafer = 32 chip = 16 circuit
                    .input(WRAP_SMD_TRANSISTOR, 16) // (16 * 16 = 4 * 64)
                    .input(wireGtHex, Electrum, 16) // [16 * 16 = 4 * 64 (wire) =  8 * 64 (fine wire)]
                    .input(stickLong, AnnealedCopper, 64) // [64 long stick = 2 * 64 stick = 8 * 64 bolt]
                    .fluidInputs(new FluidStack[]{stack})
                    .output(INTEGRATED_CIRCUIT_HV, 64)
                    .EUt(VH[HV])
                    .duration(800)
                    .buildAndRegister();
        }
    }

    private static void ProcessorCircuits() {
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
            //  ULV NAND Chip (todo)

            //  ULV NAND Chip SoC recipe (todo)

            //  LV Microprocessor (todo)

            //  LV Microprocessor SoC recipe (todo)

            //  MV Processor
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(PROCESSOR_MV)
                    .input(WRAP_PLASTIC_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(CENTRAL_PROCESSING_UNIT_WAFER, 4) // 1 wafer = 8 chip = 16 circuit
                    .input(WRAP_SMD_RESISTOR, 8) // (16 * 16 = 4 * 64) / 2
                    .input(WRAP_SMD_CAPACITOR, 8) // (16 * 16 = 4 * 64) / 2
                    .input(WRAP_SMD_TRANSISTOR, 8) // (16 * 16 = 4 * 64) / 2
                    .input(wireGtHex, RedAlloy, 4) // [8 * 16 = 128 (wire) = 4 * 64 (fine wire)] / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(PROCESSOR_MV, 64)
                    .EUt(VH[MV])
                    .duration(400)
                    .buildAndRegister();

            //  MV Processor SoC recipe (todo)

        }

        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(144 * 64),
                Tin.getFluid(288 * 64)
        }) {
            //  HV Processor Assembly
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(PROCESSOR_ASSEMBLY_HV)
                    .input(WRAP_PLASTIC_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(WRAP_CIRCUIT_MV, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_INDUCTOR, 8) // (16 * 16 = 4 * 64) / 2
                    .input(WRAP_SMD_CAPACITOR, 16) // (32 * 16 = 8 * 64) / 2
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 4) // 1 wafer = 32 chip = 16 circuit
                    .input(wireGtHex, RedAlloy, 8) // [16 * 16 = 256 (wire) = 8 * 64 (fine wire)] / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(PROCESSOR_ASSEMBLY_HV, 64)
                    .EUt(VH[HV])
                    .duration(800)
                    .buildAndRegister();

            //  EV Workstation
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(WORKSTATION_EV)
                    .input(WRAP_PLASTIC_CIRCUIT_BOARD, 4) // 4 * 16
                    .input(WRAP_CIRCUIT_HV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_SMD_DIODE, 16) // 16 * 16 = 4 * 64
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 8) // 1 wafer = 32 chip = 8 circuit
                    .input(wireGtHex, Electrum, 16) // 64 * 16 fine wire = 64 * 8 wire = 32 * 16
                    .input(stickLong, BlueAlloy, 128) // 1 circuit = 16 bolt = 4 stick = 2 long stick
                    .fluidInputs(new FluidStack[]{stack})
                    .output(WORKSTATION_EV, 64)
                    .EUt(VH[EV])
                    .duration(800)
                    .buildAndRegister();
        }

        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(288 * 64),
                Tin.getFluid(576 * 64)
        }) {
            //  IV Computer Mainframe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(MAINFRAME_IV)
                    .input(frameGt, Aluminium, 128) // 2 * 64
                    .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_SMD_INDUCTOR, 32) // 32 * 16 = 8 * 64
                    .input(WRAP_SMD_CAPACITOR, 64) // 64 * 16
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, AnnealedCopper, 64) // 1 circuit = 16 wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(MAINFRAME_IV, 64)
                    .EUt(VH[IV])
                    .duration(1200)
                    .buildAndRegister();

            //  IV Computer Mainframe Advanced SMD recipe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(MAINFRAME_IV)
                    .input(frameGt, Aluminium, 128) // 2 * 64
                    .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_ADVANCED_SMD_INDUCTOR, 8) // (32 * 16 = 8 * 64) / 4
                    .input(WRAP_ADVANCED_SMD_CAPACITOR, 16) // (64 * 16) / 4
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, AnnealedCopper, 64) // 1 circuit = 16 wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(MAINFRAME_IV, 64)
                    .EUt(VH[IV])
                    .duration(1200)
                    .buildAndRegister();
        }
    }

    private static void NanoCircuits() {
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
            //  HV Nano Processor
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_PROCESSOR_HV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(NANO_CENTRAL_PROCESSING_UNIT_WAFER, 4) // 1 wafer = 8 chip = 16 circuit
                    .input(WRAP_SMD_RESISTOR, 16) // (32 * 16 = 8 * 64) / 2
                    .input(WRAP_SMD_CAPACITOR, 16) // (32 * 16 = 8 * 64) / 2
                    .input(WRAP_SMD_TRANSISTOR, 16) // (32 * 16 = 8 * 64) / 2
                    .input(wireGtHex, Electrum, 8) // (16 * 16 = 4 * 64 wire = 8 * 64 fine wire) / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_PROCESSOR_HV, 64)
                    .EUt(VH[HV])
                    .duration(800)
                    .buildAndRegister();

            //  HV Nano Processor Advanced SMD recipe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_PROCESSOR_HV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(NANO_CENTRAL_PROCESSING_UNIT_WAFER, 4) // 1 wafer = 8 chip = 16 circuit
                    .input(WRAP_SMD_RESISTOR, 4) // (32 * 16 = 8 * 64) / 2 / 4
                    .input(WRAP_SMD_CAPACITOR, 4) // (32 * 16 = 8 * 64) / 2 / 4
                    .input(WRAP_SMD_TRANSISTOR, 4) // (32 * 16 = 8 * 64) / 2 / 4
                    .input(wireGtHex, Electrum, 8) // (16 * 16 = 4 * 64 wire = 8 * 64 fine wire) / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_PROCESSOR_HV, 64)
                    .EUt(VH[HV])
                    .duration(800)
                    .buildAndRegister();

            //  HV Nano Processor SoC recipe (todo)
        }

        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(144 * 64),
                Tin.getFluid(288 * 64)
        }) {
            //  EV Nano Assembly
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_PROCESSOR_ASSEMBLY_EV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(WRAP_CIRCUIT_HV, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_SMD_INDUCTOR, 8) // (16 * 16 = 4 * 64) / 2
                    .input(WRAP_SMD_CAPACITOR, 16) // (32 * 16 = 8 * 64) / 2
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 8) // 1 wafer = 32 chip = 8 circuit
                    .input(wireGtHex, Electrum, 16) // (32 * 16 = 8 * 64 wire = 16 * 64 fine wire) / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_PROCESSOR_ASSEMBLY_EV, 64)
                    .EUt(VH[EV])
                    .duration(800)
                    .buildAndRegister();

            //  EV Nano Assembly Advanced SMD recipe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_PROCESSOR_ASSEMBLY_EV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 2) // (4 * 16) / 2
                    .input(WRAP_CIRCUIT_HV, 4) // (8 * 16 = 2 * 64) / 2
                    .input(WRAP_ADVANCED_SMD_INDUCTOR, 2) // (16 * 16 = 4 * 64) / 2 / 4
                    .input(WRAP_ADVANCED_SMD_CAPACITOR, 4) // (32 * 16 = 8 * 64) / 2 / 4
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 8) // 1 wafer = 32 chip = 8 circuit
                    .input(wireGtHex, Electrum, 16) // (32 * 16 = 8 * 64 wire = 16 * 64 fine wire) / 2
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_PROCESSOR_ASSEMBLY_EV, 64)
                    .EUt(VH[EV])
                    .duration(800)
                    .buildAndRegister();

            //  IV Nano Supercomputer
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_COMPUTER_IV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 4) // 4 * 16
                    .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_SMD_DIODE, 32) // 32 * 16 = 8 * 64
                    .input(NOR_MEMORY_CHIP_WAFER, 16) // 1 wafer = 16 chip = 4 circuit
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, Electrum, 32) // 32 * 16 = 8 * 64 wire = 16 * 64 fine wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_COMPUTER_IV, 64)
                    .EUt(VH[IV])
                    .duration(1200)
                    .buildAndRegister();

            //  IV Nano Supercomputer Advanced SMD recipe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_COMPUTER_IV)
                    .input(WRAP_ADVANCED_CIRCUIT_BOARD, 4) // 4 * 16
                    .input(WRAP_CIRCUIT_EV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_ADVANCED_SMD_DIODE, 8) // (32 * 16 = 8 * 64) / 4
                    .input(NOR_MEMORY_CHIP_WAFER, 16) // 1 wafer = 16 chip = 4 circuit
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, Electrum, 32) // 32 * 16 = 8 * 64 wire = 16 * 64 fine wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_COMPUTER_IV, 64)
                    .EUt(VH[IV])
                    .duration(1200)
                    .buildAndRegister();
        }

        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(288 * 64),
                Tin.getFluid(576 * 64)
        }) {
            //  LuV Nano Mainframe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_MAINFRAME_LUV)
                    .input(frameGt, Aluminium, 128)
                    .input(WRAP_CIRCUIT_IV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_SMD_INDUCTOR, 64) // 16 * 64
                    .input(WRAP_SMD_CAPACITOR, 128) // 128 * 16 = 64 * 32
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, AnnealedCopper, 128) // 1 circuit = 2 hex wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_MAINFRAME_LUV, 64)
                    .EUt(VH[LuV])
                    .duration(1200)
                    .buildAndRegister();

            //  LuV Nano Mainframe Advanced SMD recipe
            LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .notConsumable(NANO_MAINFRAME_LUV)
                    .input(frameGt, Aluminium, 128)
                    .input(WRAP_CIRCUIT_IV, 8) // 8 * 16 = 2 * 64
                    .input(WRAP_ADVANCED_SMD_INDUCTOR, 16) // (16 * 64) / 4
                    .input(WRAP_ADVANCED_SMD_CAPACITOR, 32) // (128 * 16 = 64 * 32) / 4
                    .input(RANDOM_ACCESS_MEMORY_WAFER, 32) // 1 wafer = 32 chip = 2 circuit
                    .input(wireGtHex, AnnealedCopper, 128) // 1 circuit = 2 hex wire
                    .fluidInputs(new FluidStack[]{stack})
                    .output(NANO_MAINFRAME_LUV, 64)
                    .EUt(VH[LuV])
                    .duration(1200)
                    .buildAndRegister();
        }
    }

    private static void QuantumCircuits() {

    }

    private static void CrystalCircuits() {

    }

    private static void WetwareCircuits() {

    }

    private static void GoowareCircuits() {

    }

    private static void OpticalCircuits() {

    }

    private static void SpintronicCircuits() {

    }

    private static void CosmicCircuits() {

    }

    private static void SupracausalCircuits() {

    }

    private static void WrapCircuitBoard() {

        //  Basic Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(BASIC_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_BASIC_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Good Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(GOOD_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_GOOD_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Plastic Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(PLASTIC_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_PLASTIC_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Extreme Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_EXTREME_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Elite Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(EXTREME_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_EXTREME_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Wetware Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_WETWARE_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Gooware Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(GOOWARE_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_GOOWARE_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Optical Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_OPTICAL_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Spintronic Circuit Board
        PACKER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD, 16)
                .circuitMeta(16)
                .output(WRAP_SPINTRONIC_CIRCUIT_BOARD)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();
    }

    private static void WrapSMD() {

        //  SMD Transistor
        PACKER_RECIPES.recipeBuilder()
                .input(SMD_TRANSISTOR, 16)
                .circuitMeta(16)
                .output(WRAP_SMD_TRANSISTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced SMD Transistor
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_SMD_TRANSISTOR, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_SMD_TRANSISTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  SMD Resistor
        PACKER_RECIPES.recipeBuilder()
                .input(SMD_RESISTOR, 16)
                .circuitMeta(16)
                .output(WRAP_SMD_RESISTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced SMD Resistor
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_SMD_RESISTOR, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_SMD_RESISTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  SMD Capacitor
        PACKER_RECIPES.recipeBuilder()
                .input(SMD_CAPACITOR, 16)
                .circuitMeta(16)
                .output(WRAP_SMD_CAPACITOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced SMD Capacitor
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_SMD_CAPACITOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  SMD Diode
        PACKER_RECIPES.recipeBuilder()
                .input(SMD_DIODE, 16)
                .circuitMeta(16)
                .output(WRAP_SMD_DIODE)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced SMD Diode
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_SMD_DIODE, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_SMD_DIODE)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  SMD Inductor
        PACKER_RECIPES.recipeBuilder()
                .input(SMD_INDUCTOR, 16)
                .circuitMeta(16)
                .output(WRAP_SMD_INDUCTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Advanced SMD Inductor
        PACKER_RECIPES.recipeBuilder()
                .input(ADVANCED_SMD_INDUCTOR, 16)
                .circuitMeta(16)
                .output(WRAP_ADVANCED_SMD_INDUCTOR)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();
    }
}
