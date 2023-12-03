package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class OpticalCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, GalliumNitride)
                .input(foil, Americium, 4)
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 2))//  TODO Find better material
                .output(OPTICAL_BOARD)
                .duration(40)
                .EUt(VA[UHV])
                .temperature(980)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Circuit Board
        for (FluidStack stack : new FluidStack[]{
                TetramethylammoniumHydroxide.getFluid(4000),
                EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(OPTICAL_BOARD)
                    .input(foil, Americium, 64)
                    .fluidInputs(stack)
                    .output(OPTICAL_CIRCUIT_BOARD)
                    .duration(210)
                    .EUt(VA[IV])
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }

    private static void CircuitComponent() {}

    private static void SMDs() {}

    private static void Circuits() {

        //  Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_LASER_CONTROL_UNIT)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(OPTICAL_RESISTOR, 8)
                .input(OPTICAL_CAPACITOR, 8)
                .input(OPTICAL_TRANSISTOR, 8)
                .input(OPTICAL_FIBER, 8)
                .output(OPTICAL_PROCESSOR, 2)
                .solderMultiplier(1)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  TODO SoC

        //  Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR, 2)
                .input(OPTICAL_INDUCTOR, 6)
                .input(OPTICAL_CAPACITOR, 12)
                .input(PHASE_CHANGE_MEMORY, 24)
                .input(OPTICAL_FIBER, 16)
                .output(OPTICAL_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_ASSEMBLY, 2)
                .input(OPTICAL_DIODE, 8)
                .input(OPTICAL_NOR_MEMORY_CHIP, 16)
                .input(PHASE_CHANGE_MEMORY, 32)
                .input(OPTICAL_FIBER, 24)
                .input(foil, KaptonE, 32)
                .input(plate, Tritanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Orichalcum.getFluid(L * 3))
                .output(OPTICAL_COMPUTER)
                .duration(400)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(OPTICAL_ASSEMBLY.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  Mainframe
        //ASSEMBLY_LINE_RECIPES.recipeBuilder()
        //        .input(frameGt, Orichalcum, 2)
        //        .input(OPTICAL_COMPUTER, 2)
        //        .input(OPTICAL_DIODE, 16)
        //        .input(OPTICAL_CAPACITOR, 16)
        //        .input(OPTICAL_TRANSISTOR, 16)
        //        .input(OPTICAL_RESISTOR, 16)
        //        .input(OPTICAL_INDUCTOR, 16)
        //        .input(foil, KaptonE, 64)
        //        .input(PHASE_CHANGE_MEMORY, 32)
        //        .input(wireGtDouble, , 16) //UEV Superconductor
        //        .input(plate, Tritanium, 8)
        //        .fluidInputs(SolderingAlloy.getFluid(L * 20))
        //        .fluidInputs(Kevlar.getFluid(L * 12))
        //        .fluidInputs(Polyetheretherketone.getFluid(L * 9))
        //        .fluidInputs(Draconium.getFluid(L * 6))
        //        .output(OPTICAL_MAINFRAME)
        //        .duration(1200)
        //        .EUt(VA[UEV])
        //        .stationResearch(b -> b
        //                .researchStack(OPTICAL_COMPUTER.getStackForm())
        //                .CWUt(384)
        //                .EUt(VA[UEV]))
        //        .buildAndRegister();
    }
}
