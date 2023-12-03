package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CrystalCircuits {

    public static void init() {

        AssemblyBuffer();
    }

    private static void AssemblyBuffer() {
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
