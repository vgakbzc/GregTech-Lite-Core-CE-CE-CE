package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.EXPORT_FLUID_HATCH;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.IMPORT_FLUID_HATCH;

/**
 * Override of Fluid Hatches
 *
 * @author Magic_Sweepy
 *
 * @since 2.8.7-beta
 */
public class FluidHatches {

    public static void init() {
        //  Delete vanilla UHV fluid bus recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_IMPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_EXPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierFluidHatch) {
            //  UEV fluid hatch
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_10", IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_10", EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_TANK[2])
                    .circuitMeta(1)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(IMPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UEV])
                    .input(QUANTUM_CHEST[2])
                    .circuitMeta(2)
                    .fluidInputs(Polyetheretherketone.getFluid(864))
                    .output(EXPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_11", IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_11", EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_TANK[3])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(IMPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UIV])
                    .input(QUANTUM_TANK[3])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1008))
                    .output(EXPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_12", IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_12", EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_TANK[4])
                    .circuitMeta(1)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(IMPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[UXV])
                    .input(QUANTUM_TANK[4])
                    .circuitMeta(2)
                    .fluidInputs(Kevlar.getFluid(1152))
                    .output(EXPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_13", IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_13", EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_TANK[5])
                    .circuitMeta(1)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(IMPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(HULL[OpV])
                    .input(QUANTUM_TANK[5])
                    .circuitMeta(2)
                    .fluidInputs(CosmicFabric.getFluid(1296))
                    .output(EXPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(300)
                    .buildAndRegister();
        }
    }
}
