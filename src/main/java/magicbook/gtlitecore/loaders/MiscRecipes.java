package magicbook.gtlitecore.loaders;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Neutronium;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.GRAVI_STAR;
import static gregtech.common.items.MetaItems.QUANTUM_STAR;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class MiscRecipes {

    public static void init() {

        //  TODO Fracturing Fluid

        //  Gravi Star
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES,
                new ItemStack[]{QUANTUM_STAR.getStackForm()},
                new FluidStack[]{Neutronium.getFluid(288)});

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .fluidInputs(Orichalcum.getFluid(288))
                .output(GRAVI_STAR)
                .EUt(7680)
                .duration(480)
                .buildAndRegister();

        //  c-BN sawblade
        LATHE_RECIPES.recipeBuilder()
                .input(gemExquisite, CubicBoronNitride)
                .output(toolHeadBuzzSaw, CubicBoronNitride)
                .duration((int) (CubicBoronNitride.getMass() * 4))
                .EUt(240)
                .buildAndRegister();

        //  Boron Nitride Grinder
        ModHandler.addShapedRecipe("component_grinder_boron_nitride", GTLiteMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, CubicBoronNitride),
                'D', new UnificationEntry(plateDouble, Vibranium),
                'G', new UnificationEntry(gem, CubicHeterodiamond));
    }
}
