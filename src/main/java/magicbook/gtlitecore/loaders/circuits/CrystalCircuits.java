package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CrystalCircuits {

    public static void init() {
        CrystalSoCNerf();
        AssemblyBuffer();
    }

    private static void CrystalSoCNerf() {

        if (GTLiteConfigHolder.recipes.enableHarderCrystalSoC) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                    CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(),
                    OreDictUnifier.get(craftingLens, Blue));
        }

        //  c-ZrO2 + Eu -> Eu-doped c-ZrO2 Boule
        CRYSTALLIZATION_RECIPES.recipeBuilder()
                .input(dust, CubicZirconia, 64)
                .input(dust, Europium, 8)
                .output(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
                .duration(120)
                .EUt(VA[MV])
                .blastFurnaceTemp(3000)
                .buildAndRegister();

        //  Eu-doped c-ZrO2 Boule -> Eu-doped c-ZrO2 Wafer
        CUTTER_RECIPES.recipeBuilder()
                .input(CUBIC_ZIRCONIA_EUROPIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(100))
                .output(CUBIC_ZIRCONIA_EUROPIUM_WAFER, 8)
                .duration(100)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Eu-doped c-ZrO2 Wafer -> Crystal Interface Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(CUBIC_ZIRCONIA_EUROPIUM_WAFER)
                .notConsumable(lens, NetherStar)
                .output(CRYSTAL_INTERFACE_WAFER)
                .duration(20)
                .EUt(VA[LuV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal Interface Wafer -> Chip
        CUTTER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_WAFER)
                .fluidInputs(Lubricant.getFluid(100))
                .output(CRYSTAL_INTERFACE_CHIP, 8)
                .duration(100)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Sapphire Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Sapphire)
                .notConsumable(lens, Sapphire)
                .output(SAPPHIRE_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ruby Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Ruby)
                .notConsumable(lens, Ruby)
                .output(RUBY_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Diamond Crystal Chip
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(gemExquisite, Diamond)
                .notConsumable(lens, Diamond)
                .output(DIAMOND_CHIP)
                .duration(1200)
                .EUt(VA[HV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Sapphire Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SAPPHIRE_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(SAPPHIRE_MODULATOR, 8)
                .solderMultiplier(1)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Ruby Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(RUBY_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(RUBY_MODULATOR, 8)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Diamond Modulator
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(DIAMOND_CHIP)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 8)
                .input(bolt, Platinum, 4)
                .output(DIAMOND_MODULATOR, 8)
                .duration(200)
                .EUt(VA[IV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal SoC Socket
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(CRYSTAL_INTERFACE_CHIP)
                .input(SAPPHIRE_MODULATOR)
                .input(RUBY_MODULATOR)
                .input(DIAMOND_MODULATOR)
                .input(wireFine, Europium, 4)
                .output(CRYSTAL_SOC_SOCKET)
                .duration(100)
                .EUt(VA[LuV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Crystal SoC
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(CRYSTAL_SOC_SOCKET)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .output(CRYSTAL_SYSTEM_ON_CHIP)
                .duration(100)
                .EUt(VA[ZPM])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void AssemblyBuffer() {

        if (GTLiteConfigHolder.recipes.enableEasierProcessorAssembly) {
            //  Delete original recipe
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ELITE_CIRCUIT_BOARD.getStackForm(),
                            CRYSTAL_PROCESSOR_IV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(4),
                            ADVANCED_SMD_CAPACITOR.getStackForm(8),
                            RANDOM_ACCESS_MEMORY.getStackForm(24),
                            OreDictUnifier.get(wireFine, NiobiumTitanium, 16)},
                    new FluidStack[]{Tin.getFluid(288)});

            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES,
                    new ItemStack[]{ELITE_CIRCUIT_BOARD.getStackForm(),
                            CRYSTAL_PROCESSOR_IV.getStackForm(2),
                            ADVANCED_SMD_INDUCTOR.getStackForm(4),
                            ADVANCED_SMD_CAPACITOR.getStackForm(8),
                            RANDOM_ACCESS_MEMORY.getStackForm(24),
                            OreDictUnifier.get(wireFine, NiobiumTitanium, 16)},
                    new FluidStack[]{SolderingAlloy.getFluid(144)});

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ELITE_CIRCUIT_BOARD)
                    .input(CRYSTAL_PROCESSOR_IV, 2)
                    .input(ADVANCED_SMD_INDUCTOR, 4)
                    .input(ADVANCED_SMD_CAPACITOR, 8)
                    .input(RANDOM_ACCESS_MEMORY, 24)
                    .input(wireFine, NiobiumTitanium, 16)
                    .output(CRYSTAL_ASSEMBLY_LUV, 2)
                    .solderMultiplier(2)
                    .EUt(9600)
                    .duration(400)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister();
        }
    }
}
