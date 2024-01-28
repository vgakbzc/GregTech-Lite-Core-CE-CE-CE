package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Water;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class LargeCircuitAssemblyLine {

    public static void init() {
        Circuits();
        WrapComponents();
    }

    private static void Circuits() {

        //  In recipes, please put not consumable item on the first slot in item input slots.
        //  Because Large Circuit Assembly Line use special ui, you should make it on special slot on left hand.

        //  You do not need to use Data stick or other items to storage circuit's info.
        //  You just needs to put circuit in bus, it is not consumable.

        PrimitiveCircuits();
        IntegratedCircuits();
        ProcessorCircuits();
        NanoCircuits();
        QuantumCircuits();
        CrystalCircuits();
        WetwareCircuits();
        GoowareCircuits();
        OpticalCircuits();
        SpintronicCircuits();
        CosmicCircuits();
        SupracausalCircuits();
    }

    private static void WrapComponents() {
        WrapCircuitBoard();
    }

    private static void PrimitiveCircuits() {

        //  Testing Recipe
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1))
                .output(ELECTRONIC_CIRCUIT_LV)
                .EUt(VA[IV])
                .duration(1)
                .buildAndRegister();
    }

    private static void IntegratedCircuits() {

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
