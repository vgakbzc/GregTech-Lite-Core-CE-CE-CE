package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.pipeNonupleFluid;
import static gregtech.api.unification.ore.OrePrefix.pipeQuadrupleFluid;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MultiFluidHatches {

    public static void init() {
        //  UHV 4x
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(4), FLUID_IMPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeQuadrupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(576)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(4), FLUID_EXPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeQuadrupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(576)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_IMPORT_HATCH[UHV])
                .input(pipeQuadrupleFluid, Duranium)
                .circuitMeta(4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(QUADRUPLE_IMPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_EXPORT_HATCH[UHV])
                .input(pipeQuadrupleFluid, Duranium)
                .circuitMeta(4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(QUADRUPLE_EXPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(300)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierMultiFluidHatch) {
            //  UEV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_10", QUADRUPLE_IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_10", QUADRUPLE_EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(300)
                    .buildAndRegister();

            //  UIV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_11", QUADRUPLE_IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_11", QUADRUPLE_EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(300)
                    .buildAndRegister();

            //  UXV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_12", QUADRUPLE_IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_12", QUADRUPLE_EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(300)
                    .buildAndRegister();

            //  OpV 4x
            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_input_to_output_13", QUADRUPLE_IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "quadruple_fluid_hatch_output_to_input_13", QUADRUPLE_EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', QUADRUPLE_IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(300)
                    .buildAndRegister();
        }

        //  UHV 9x
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(9), FLUID_IMPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeNonupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(9), FLUID_EXPORT_HATCH[UHV].getStackForm(), OreDictUnifier.get(pipeNonupleFluid, Neutronium)},
                new FluidStack[]{Polybenzimidazole.getFluid(1296)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_IMPORT_HATCH[UHV])
                .input(pipeNonupleFluid, Duranium)
                .circuitMeta(9)
                .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                .output(NONUPLE_IMPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_EXPORT_HATCH[UHV])
                .input(pipeNonupleFluid, Duranium)
                .circuitMeta(9)
                .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                .output(NONUPLE_EXPORT_HATCH[5]) // UHV
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        if (GTLiteConfigHolder.machines.enableHighTierMultiFluidHatch) {
            //  UEV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_10", NONUPLE_IMPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[0].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_10", NONUPLE_EXPORT_FLUID_HATCH[0].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[0].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0]) // UEV
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UHV])
                    .duration(600)
                    .buildAndRegister();

            //  UIV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_11", NONUPLE_IMPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[1].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_11", NONUPLE_EXPORT_FLUID_HATCH[1].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[1].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1]) // UIV
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[1]) // UIV
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_12", NONUPLE_IMPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[2].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_12", NONUPLE_EXPORT_FLUID_HATCH[2].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[2].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2]) // UXV
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[2]) // UXV
                    .EUt(VA[UIV])
                    .duration(600)
                    .buildAndRegister();

            //  OpV 9x
            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_input_to_output_13", NONUPLE_IMPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_EXPORT_FLUID_HATCH[3].getStackForm());

            ModHandler.addShapedRecipe(true, "nonuple_fluid_hatch_output_to_input_13", NONUPLE_EXPORT_FLUID_HATCH[3].getStackForm(),
                    " d ", " H ", "   ",
                    'H', NONUPLE_IMPORT_FLUID_HATCH[3].getStackForm());

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3]) // OpV
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[3]) // OpV
                    .EUt(VA[UXV])
                    .duration(600)
                    .buildAndRegister();
        }
    }
}
