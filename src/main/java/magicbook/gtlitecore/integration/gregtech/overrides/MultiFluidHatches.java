package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Duranium;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.api.unification.ore.OrePrefix.pipeNonupleFluid;
import static gregtech.api.unification.ore.OrePrefix.pipeQuadrupleFluid;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.utils.GTRecipeHelper.createIOPartConv;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MultiFluidHatches {

    public static void init() {

        //  Remove original UHV recipes.
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
                .EUt(VA[UHV])
                .duration(15 * SECOND)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FLUID_EXPORT_HATCH[UHV])
                .input(pipeQuadrupleFluid, Duranium)
                .circuitMeta(4)
                .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                .output(QUADRUPLE_EXPORT_HATCH[5]) // UHV
                .EUt(VA[UHV])
                .duration(15 * SECOND)
                .buildAndRegister();

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

        if (GTLiteConfigHolder.machines.enableHighTierMultiFluidHatches) {

            //  UEV 4x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0])
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[0]) // UEV
                    .EUt(VA[UEV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UEV 4x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0])
                    .input(pipeQuadrupleFluid, Lafium)
                    .circuitMeta(4)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UEV 9x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[0])
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  UEV 9x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[0])
                    .input(pipeNonupleFluid, Lafium)
                    .circuitMeta(9)
                    .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[0])
                    .EUt(VA[UEV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  UIV 4x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1])
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UIV 4x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1])
                    .input(pipeQuadrupleFluid, CrystalMatrix)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UIV 9x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[1])
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[1])
                    .EUt(VA[UIV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  UIV 9x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[1])
                    .input(pipeNonupleFluid, CrystalMatrix)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[1])
                    .EUt(VA[UEV])
                    .duration(600)
                    .buildAndRegister();

            //  UXV 4x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2])
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UXV 4x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2])
                    .input(pipeQuadrupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(4)
                    .fluidInputs(Kevlar.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  UXV 9x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[2])
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  UXV 9x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[2])
                    .input(pipeNonupleFluid, QuantumchromodynamicallyConfinedMatter)
                    .circuitMeta(9)
                    .fluidInputs(Kevlar.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[2])
                    .EUt(VA[UXV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  OpV 4x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3])
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_IMPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  OpV 4x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3])
                    .input(pipeQuadrupleFluid, Fatalium)
                    .circuitMeta(4)
                    .fluidInputs(CosmicFabric.getFluid(L * 4))
                    .output(QUADRUPLE_EXPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            //  OpV 9x Fluid Import Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(IMPORT_FLUID_HATCH[3])
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_IMPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  OpV 9x Fluid Export Hatch
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(EXPORT_FLUID_HATCH[3])
                    .input(pipeNonupleFluid, Fatalium)
                    .circuitMeta(9)
                    .fluidInputs(CosmicFabric.getFluid(L * 9))
                    .output(NONUPLE_EXPORT_FLUID_HATCH[3])
                    .EUt(VA[OpV])
                    .duration(30 * SECOND)
                    .buildAndRegister();

            //  Add I to O and O to I convension of UEV-OpV Fluid I/O Hatches.
            createIOPartConv(UEV, 4, QUADRUPLE_IMPORT_FLUID_HATCH[0], QUADRUPLE_EXPORT_FLUID_HATCH[0], true);
            createIOPartConv(UIV, 4, QUADRUPLE_IMPORT_FLUID_HATCH[1], QUADRUPLE_EXPORT_FLUID_HATCH[1], true);
            createIOPartConv(UXV, 4, QUADRUPLE_IMPORT_FLUID_HATCH[2], QUADRUPLE_EXPORT_FLUID_HATCH[2], true);
            createIOPartConv(OpV, 4, QUADRUPLE_IMPORT_FLUID_HATCH[3], QUADRUPLE_EXPORT_FLUID_HATCH[3], true);
            createIOPartConv(UEV, 9, NONUPLE_IMPORT_FLUID_HATCH[0],   NONUPLE_EXPORT_FLUID_HATCH[0],   true);
            createIOPartConv(UIV, 9, NONUPLE_IMPORT_FLUID_HATCH[1],   NONUPLE_EXPORT_FLUID_HATCH[0],   true);
            createIOPartConv(UXV, 9, NONUPLE_IMPORT_FLUID_HATCH[2],   NONUPLE_EXPORT_FLUID_HATCH[2],   true);
            createIOPartConv(OpV, 9, NONUPLE_IMPORT_FLUID_HATCH[3],   NONUPLE_EXPORT_FLUID_HATCH[3],   true);
        }

    }
}
