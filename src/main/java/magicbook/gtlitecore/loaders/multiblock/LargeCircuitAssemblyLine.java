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
        //  LV: 20s, MV: 20s, HV: 40s, EV: 40s, IV: 60s, LuV, 60s, ZPM: 80s, UV: 80s,
        //  UHV: 100s, UEV: 100s, UIV: 120s, UXV: 120s, OpV: 140s, MAX: 140s
    }

    private static void WrapComponents() {
        WrapCircuitBoard();
        //  TODO WrapSMD();
    }

    private static void PrimitiveCircuits() {

        //  This recipe is not filled with enough slots, but we can separate some item to meet the visual effect.
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
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
                    .EUt(VH[LV])
                    .duration(400)
                    .buildAndRegister();
        }
    }

    private static void IntegratedCircuits() {
        for (FluidStack stack : new FluidStack[] {
                SolderingAlloy.getFluid(72 * 64),
                Tin.getFluid(144 * 64)
        }) {
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
        }
    }

    private static void ProcessorCircuits() {

    }

    private static void NanoCircuits() {

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
}
