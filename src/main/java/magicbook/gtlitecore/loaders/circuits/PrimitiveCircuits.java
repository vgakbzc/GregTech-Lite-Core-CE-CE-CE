package magicbook.gtlitecore.loaders.circuits;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.ULV;
import static gregtech.api.GTValues.V;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.GLASS_TUBE;
import static gregtech.common.items.MetaItems.STICKY_RESIN;
import static gregtech.common.items.MetaItems.VACUUM_TUBE;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.VACUUM_TUBE_COMPONENT;

public class PrimitiveCircuits {

    public static void init() {
        removeVanillaRecipes();
        Recipes();
    }

    private static void removeVanillaRecipes() {
        if (GTLiteConfigHolder.recipes.enableHarderVacuumTube) {
            ModHandler.removeRecipeByName("gregtech:vacuum_tube");
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2), IntCircuitIngredient.getIntegratedCircuit(1));
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2)},
                    new FluidStack[]{RedAlloy.getFluid(18)});
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, AnnealedCopper, 2)},
                    new FluidStack[]{RedAlloy.getFluid(18)});
        }
    }

    private static void Recipes() {

        //  ULV Glue recipe
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(STICKY_RESIN, 4)
                .notConsumable(stickLong, Iron)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Glue.getFluid(200))
                .EUt((int) V[ULV])
                .duration(MINUTE / 2)
                .buildAndRegister();

        //  Glass Tube -> Vacuum Tube Component
        ModHandler.addShapedRecipe(true, "vacuum_tube_component", VACUUM_TUBE_COMPONENT.getStackForm(4),
                "FGF", "WWW",
                'F', new UnificationEntry(foil, Gold),
                'W', new UnificationEntry(wireGtSingle, Lead),
                'G', GLASS_TUBE.getStackForm());

        //  Vacuum Tube
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(VACUUM_TUBE_COMPONENT)
                .input(ring, Steel, 2)
                .input(wireFine, Copper, 4)
                .fluidInputs(Glue.getFluid(200))
                .output(VACUUM_TUBE, 2)
                .EUt((int) V[ULV])
                .duration(10 * SECOND)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(VACUUM_TUBE_COMPONENT)
                .input(wireFine, Copper, 4)
                .output(VACUUM_TUBE, 2)
                .EUt(VA[LV])
                .duration(6 * SECOND)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(VACUUM_TUBE_COMPONENT)
                .input(wireFine, AnnealedCopper, 4)
                .output(VACUUM_TUBE, 2)
                .EUt(VA[LV])
                .duration(6 * SECOND)
                .buildAndRegister();
    }
}
