package magicbook.gtlitecore.integration.gregtech.overrides;

import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Diamond;
import static gregtech.api.unification.material.Materials.Europium;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class LaserHatches {

    public static void init() {
        LaserHatches256A();
        LaserHatches1024A();
        LaserHatches4096A();
    }

    private static void LaserHatches256A() {

        if (GTLiteConfigHolder.machines.enableHighTier256ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond)
                    .input(EMITTER_UHV)
                    .input(ELECTRIC_PUMP_UHV)
                    .input(cableGtSingle, Europium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[4])
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond)
                    .input(SENSOR_UHV)
                    .input(ELECTRIC_PUMP_UHV)
                    .input(cableGtSingle, Europium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[4])
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond)
                    .input(EMITTER_UEV)
                    .input(ELECTRIC_PUMP_UEV)
                    .input(cableGtSingle, PedotTMA, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[5])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond)
                    .input(SENSOR_UEV)
                    .input(ELECTRIC_PUMP_UEV)
                    .input(cableGtSingle, PedotTMA, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[5])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond)
                    .input(EMITTER_UIV)
                    .input(ELECTRIC_PUMP_UIV)
                    .input(cableGtSingle, Solarium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[6])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond)
                    .input(SENSOR_UIV)
                    .input(ELECTRIC_PUMP_UIV)
                    .input(cableGtSingle, Solarium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[6])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond)
                    .input(EMITTER_UXV)
                    .input(ELECTRIC_PUMP_UXV)
                    .input(cableGtSingle, Hypogen, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[7])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond)
                    .input(SENSOR_UXV)
                    .input(ELECTRIC_PUMP_UXV)
                    .input(cableGtSingle, Hypogen, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[7])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond)
                    .input(EMITTER_OpV)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(cableGtSingle, Galaxium, 4)
                    .circuitMeta(1)
                    .output(LASER_INPUT_HATCH_256[8])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond)
                    .input(SENSOR_OpV)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(cableGtSingle, Galaxium, 4)
                    .circuitMeta(1)
                    .output(LASER_OUTPUT_HATCH_256[8])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();
        }

    }

    private static void LaserHatches1024A() {

        if (GTLiteConfigHolder.machines.enableHighTier1024ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UHV, 2)
                    .input(ELECTRIC_PUMP_UHV, 2)
                    .input(cableGtDouble, Europium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[4])
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UHV, 2)
                    .input(ELECTRIC_PUMP_UHV, 2)
                    .input(cableGtDouble, Europium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[4])
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UEV, 2)
                    .input(ELECTRIC_PUMP_UEV, 2)
                    .input(cableGtDouble, PedotTMA, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[5])
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UEV, 2)
                    .input(ELECTRIC_PUMP_UEV, 2)
                    .input(cableGtDouble, PedotTMA, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[5])
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UIV, 2)
                    .input(ELECTRIC_PUMP_UIV, 2)
                    .input(cableGtDouble, Solarium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[6])
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UIV, 2)
                    .input(ELECTRIC_PUMP_UIV, 2)
                    .input(cableGtDouble, Solarium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[6])
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_UXV, 2)
                    .input(ELECTRIC_PUMP_UXV, 2)
                    .input(cableGtDouble, Hypogen, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[7])
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_UXV, 2)
                    .input(ELECTRIC_PUMP_UXV, 2)
                    .input(cableGtDouble, Hypogen, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[7])
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 2)
                    .input(EMITTER_OpV, 2)
                    .input(ELECTRIC_PUMP_OpV, 2)
                    .input(cableGtDouble, Galaxium, 4)
                    .circuitMeta(2)
                    .output(LASER_INPUT_HATCH_1024[8])
                    .EUt(VA[OpV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 2)
                    .input(SENSOR_OpV, 2)
                    .input(ELECTRIC_PUMP_OpV, 2)
                    .input(cableGtDouble, Galaxium, 4)
                    .circuitMeta(2)
                    .output(LASER_OUTPUT_HATCH_1024[8])
                    .EUt(VA[OpV])
                    .duration(600)
                    .buildAndRegister();
        }
    }

    private static void LaserHatches4096A() {

        if (GTLiteConfigHolder.machines.enableHighTier4096ALaserHatch) {
            //  UHV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UHV, 4)
                    .input(ELECTRIC_PUMP_UHV, 4)
                    .input(cableGtQuadruple, Europium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[4])
                    .EUt(VA[UHV])
                    .duration(1200)
                    .buildAndRegister();

            //  UHV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UHV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UHV, 4)
                    .input(ELECTRIC_PUMP_UHV, 4)
                    .input(cableGtQuadruple, Europium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[4])
                    .EUt(VA[UHV])
                    .duration(1200)
                    .buildAndRegister();

            //  UEV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UEV, 4)
                    .input(ELECTRIC_PUMP_UEV, 4)
                    .input(cableGtQuadruple, PedotTMA, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[5])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .buildAndRegister();

            //  UEV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UEV, 4)
                    .input(ELECTRIC_PUMP_UEV, 4)
                    .input(cableGtQuadruple, PedotTMA, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[5])
                    .EUt(VA[UEV])
                    .duration(1200)
                    .buildAndRegister();

            //  UIV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UIV, 4)
                    .input(ELECTRIC_PUMP_UIV, 4)
                    .input(cableGtQuadruple, Solarium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[6])
                    .EUt(VA[UIV])
                    .duration(1200)
                    .buildAndRegister();

            //  UIV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UIV, 4)
                    .input(ELECTRIC_PUMP_UIV, 4)
                    .input(cableGtQuadruple, Solarium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[6])
                    .EUt(VA[UIV])
                    .duration(1200)
                    .buildAndRegister();

            //  UXV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_UXV, 4)
                    .input(ELECTRIC_PUMP_UXV, 4)
                    .input(cableGtQuadruple, Hypogen, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[7])
                    .EUt(VA[UXV])
                    .duration(1200)
                    .buildAndRegister();

            //  UXV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_UXV, 4)
                    .input(ELECTRIC_PUMP_UXV, 4)
                    .input(cableGtQuadruple, Hypogen, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[7])
                    .EUt(VA[UXV])
                    .duration(1200)
                    .buildAndRegister();

            //  OpV Input
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 4)
                    .input(EMITTER_OpV, 4)
                    .input(ELECTRIC_PUMP_OpV, 4)
                    .input(cableGtQuadruple, Galaxium, 4)
                    .circuitMeta(3)
                    .output(LASER_INPUT_HATCH_4096[8])
                    .EUt(VA[OpV])
                    .duration(1200)
                    .buildAndRegister();

            //  OpV Output
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(lens, Diamond, 4)
                    .input(SENSOR_OpV, 4)
                    .input(ELECTRIC_PUMP_OpV, 4)
                    .input(cableGtQuadruple, Galaxium, 4)
                    .circuitMeta(3)
                    .output(LASER_OUTPUT_HATCH_4096[8])
                    .EUt(VA[OpV])
                    .duration(1200)
                    .buildAndRegister();
        }
    }
}
