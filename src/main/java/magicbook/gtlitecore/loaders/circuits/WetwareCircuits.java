package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PRECISE_ASSEMBLER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.KaptonE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.KaptonK;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class WetwareCircuits {

    public static void init() {
        CircuitBoard();
        AdvancedWetwareProcessingUnit();
        WetwareSoC();
        AssemblyBuffer();
    }

    private static void CircuitBoard() {

        if (GTLiteConfigHolder.recipes.enableHarderWetwareBoard) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{MULTILAYER_FIBER_BOARD.getStackForm(16),
                            PETRI_DISH.getStackForm(),
                            ELECTRIC_PUMP_LuV.getStackForm(),
                            SENSOR_IV.getStackForm(),
                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV),
                            OreDictUnifier.get(foil, NiobiumTitanium, 16)},
                    new FluidStack[]{SterileGrowthMedium.getFluid(4000)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(plate, KaptonK, 16)
                    .input(PETRI_DISH)
                    .input(ELECTRIC_PUMP_LuV)
                    .input(SENSOR_IV)
                    .input(circuit, MarkerMaterials.Tier.IV)
                    .input(foil, NiobiumTitanium, 16)
                    .fluidInputs(SterileGrowthMedium.getFluid(4000))
                    .output(WETWARE_BOARD, 16)
                    .cleanroom(CleanroomType.STERILE_CLEANROOM)
                    .duration(1200)
                    .EUt(VA[LuV])
                    .buildAndRegister();
        }
    }

    private static void AdvancedWetwareProcessingUnit() {

        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Polybenzimidazole)
                .input(STEM_CELLS, 4)
                .input(pipeTinyFluid, Gold)
                .input(bolt, HSSS, 4)
                .fluidInputs(KaptonE.getFluid(L * 4))
                .fluidInputs(SterileGrowthMedium.getFluid(125))
                .output(NEURO_PROCESSOR, 2)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .tier(3)
                .build();
    }

    private static void WetwareSoC() {

        //  Remove original recipes.
        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                new ItemStack[]{NEURO_PROCESSOR.getStackForm(),
                        HIGHLY_ADVANCED_SOC.getStackForm(),
                        OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8),
                        OreDictUnifier.get(bolt, Naquadah, 8)},
                new FluidStack[]{SolderingAlloy.getFluid(L / 2)});

        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                new ItemStack[]{NEURO_PROCESSOR.getStackForm(),
                        HIGHLY_ADVANCED_SOC.getStackForm(),
                        OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8),
                        OreDictUnifier.get(bolt, Naquadah, 8)},
                new FluidStack[]{Tin.getFluid(L)});

        //  Ruby Chip -> Wetware Crystal Chip
        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .input(RUBY_CHIP)
                .notConsumable(lens, Ruby)
                .fluidInputs(SterileGrowthMedium.getFluid(L))
                .fluidInputs(Americium.getFluid(16))
                .output(WETWARE_CRYSTAL_CHIP)
                .EUt(VA[UV])
                .duration(2 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Wetware Crystal Chip -> Rich Bacteria SoC
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(WETWARE_CRYSTAL_CHIP)
                .input(ring, Osmium, 2)
                .input(HIGHLY_ADVANCED_SOC, 4)
                .output(RICH_BACTERIA_SOC, 2)
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Add new Rich bacteria SoC for Wetware Processor.
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD)
                .input(RICH_BACTERIA_SOC)
                .input(wireFine, YttriumBariumCuprate, 8)
                .input(bolt, Naquadah, 8)
                .output(WETWARE_PROCESSOR_LUV, 4)
                .EUt(150000)
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .solderMultiplier(1)
                .buildAndRegister();
    }

    private static void AssemblyBuffer() {

        if (GTLiteConfigHolder.recipes.enableEasierProcessorAssembly) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{WETWARE_CIRCUIT_BOARD.getStackForm(),
                            WETWARE_PROCESSOR_LUV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(6),
                            ADVANCED_SMD_CAPACITOR.getStackForm(12),
                            RANDOM_ACCESS_MEMORY.getStackForm(24),
                            OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{WETWARE_CIRCUIT_BOARD.getStackForm(),
                            WETWARE_PROCESSOR_LUV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(6),
                            ADVANCED_SMD_CAPACITOR.getStackForm(12),
                            RANDOM_ACCESS_MEMORY.getStackForm(24),
                            OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(WETWARE_CIRCUIT_BOARD)
                    .input(WETWARE_PROCESSOR_LUV, 2)
                    .input(ADVANCED_SMD_INDUCTOR, 6)
                    .input(ADVANCED_SMD_CAPACITOR, 12)
                    .input(RANDOM_ACCESS_MEMORY, 24)
                    .input(wireFine, YttriumBariumCuprate, 16)
                    .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 2)
                    .solderMultiplier(2)
                    .EUt(38400)
                    .duration(20 * SECOND)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }
}