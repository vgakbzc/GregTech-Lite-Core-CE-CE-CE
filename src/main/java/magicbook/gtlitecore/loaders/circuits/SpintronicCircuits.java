package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SpintronicCircuits {

    public static void init() {
        CircuitBoard();
        CircuitComponent();
        SMDs();
        Circuits();
    }

    private static void CircuitBoard() {

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(plate, CarbonNanotube)
                .input(foil, Phosphorene, 4)
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 4))//  TODO Find better material
                .output(SPINTRONIC_BOARD)
                .duration(40)
                .EUt(VA[UEV])
                .temperature(3580)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Spintronic Circuit Board
        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000), EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(SPINTRONIC_BOARD)
                    .input(foil, Fullerene, 16)
                    .fluidInputs(stack)
                    .output(SPINTRONIC_CIRCUIT_BOARD)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(210)
                    .EUt(VA[LuV])
                    .buildAndRegister();
        }
    }

    private static void CircuitComponent() {

        //  STTRAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, ErbiumDopedZBLANGlass, 2)
                .input(plate, PraseodymiumDopedZBLANGlass, 2)
                .input(foil, Vibranium, 8)
                .input(wireFine, PedotPSS, 16)
                .output(SPIN_TRANSFER_TORQUE_MEMORY, 4)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  MDNAND
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(NAND_MEMORY_CHIP)
                .input(dust, PedotTMA, 2)
                .input(foil, Seaborgium, 8)
                .input(wireFine, CarbonNanotube, 16)
                .output(SPINTRONIC_NAND_MEMORY_CHIP, 4)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  ESR Computation Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(plate, PlutoniumPhosphide, 2)
                .input(plate, BismuthFerrite)
                .input(foil, BismuthChalcogenide, 2)
                .input(TOPOLOGICAL_INSULATOR_TUBE)
                .input(BOSE_EINSTEIN_CONDENSATE)
                .input(wireFine, ThalliumCopperChloride, 24)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(ESR_COMPUTATION_UNIT)
                .duration(600)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Topological Insulator Tube
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .input(dust, Antimony)
                .input(dust, Tellurium, 2)
                .input(dust, Sulfur)
                .notConsumable(plate, CadmiumSulfide)
                .output(dust, BismuthChalcogenide, 5)
                .duration(80)
                .EUt(VA[UV])
                .temperature(4876)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Tellurium, 2)
                .fluidInputs(Mercury.getFluid(2000))
                .circuitMeta(5)
                .output(dust, MercuryCadmiumTelluride, 5)
                .duration(400)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 16)
                .input(spring, CarbonNanotube)
                .output(TOPOLOGICAL_INSULATOR_TUBE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Bose-Einstein Condensate
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_IV)
                .input(HELIUM_NEON_LASER)
                .input(plate, Trinium, 2)
                .input(cableGtSingle, Europium, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .output(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .duration(80)
                .EUt(VA[UV])
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .input(dust, Rubidium, 8)
                .output(BOSE_EINSTEIN_CONDENSATE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20)
                .EUt(VA[IV])
                .buildAndRegister();
    }

    private static void SMDs() {

        CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 4)
                .input(gem, HexagonalBoronNitride)
                .output(SPINTRONIC_RESISTOR, 16)
                .fluidInputs(Kevlar.getFluid(L * 2))
                .duration(160)
                .EUt(VA[UHV])
                .temperature(2984)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, CarbonNanotube, 8)
                .input(plate, AmorphousBoronNitride)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_TRANSISTOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_UNIT_RECIPES.recipeBuilder()
                .input(wireGtSingle, CarbonNanotube, 2)
                .input(plate, CubicBoronNitride)
                .fluidInputs(Kevlar.getFluid(L / 4))
                .output(SPINTRONIC_CAPACITOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .temperature(2755)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, CadmiumSelenide)
                .input(wireFine, CarbonNanotube, 4)
                .fluidInputs(Kevlar.getFluid(L / 2))
                .output(SPINTRONIC_DIODE, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATOR_RECIPES.recipeBuilder()
                .input(ring, Fullerene)
                .input(wireFine, ThalliumCopperChloride, 4)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_INDUCTOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void Circuits() {

        //  Spintronic Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ESR_COMPUTATION_UNIT)
                .input(CRYSTAL_SYSTEM_ON_CHIP)
                .input(SPINTRONIC_RESISTOR, 8)
                .input(SPINTRONIC_CAPACITOR, 8)
                .input(SPINTRONIC_TRANSISTOR, 8)
                .input(wireFine, CarbonNanotube, 8)
                .output(SPINTRONIC_PROCESSOR, 2)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  TODO SoC

        //  Spintronic Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_PROCESSOR, 2)
                .input(SPINTRONIC_INDUCTOR, 6)
                .input(SPINTRONIC_CAPACITOR, 12)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 24)
                .input(wireFine, CarbonNanotube, 16)
                .output(SPINTRONIC_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Spintronic Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_ASSEMBLY, 2)
                .input(SPINTRONIC_DIODE, 8)
                .input(SPINTRONIC_NAND_MEMORY_CHIP, 16)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(wireFine, CarbonNanotube, 24)
                .input(foil, Fullerene, 32)
                .input(plate, PlutoniumPhosphide, 4)
                .fluidInputs(SolderingAlloy.getFluid(8640))
                .fluidInputs(Polyetheretherketone.getFluid(4608))
                .fluidInputs(Kevlar.getFluid(2304))
                .fluidInputs(Adamantium.getFluid(1152))
                .output(SPINTRONIC_COMPUTER)
                .duration(400)
                .EUt(VA[UEV])
                .stationResearch(b -> b
                        .researchStack(SPINTRONIC_ASSEMBLY.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Fullerene, 2)
                .input(SPINTRONIC_COMPUTER, 2)
                .input(SPINTRONIC_DIODE, 16)
                .input(SPINTRONIC_CAPACITOR, 16)
                .input(SPINTRONIC_TRANSISTOR, 16)
                .input(SPINTRONIC_RESISTOR, 16)
                .input(SPINTRONIC_INDUCTOR, 16)
                .input(foil, CarbonNanotube, 16)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(wireGtDouble, FullereneSuperconductor, 16)
                .input(plate, NeptuniumAluminide, 8)
                .fluidInputs(SolderingAlloy.getFluid(10944))
                .fluidInputs(Kevlar.getFluid(8640))
                .fluidInputs(Zylon.getFluid(4608))
                .fluidInputs(Adamantium.getFluid(2304))
                .output(SPINTRONIC_MAINFRAME)
                .duration(1600)
                .EUt(VA[UIV])
                .stationResearch(b -> b
                        .researchStack(SPINTRONIC_COMPUTER.getStackForm())
                        .CWUt(768)
                        .EUt(VA[UIV]))
                .buildAndRegister();
    }
}