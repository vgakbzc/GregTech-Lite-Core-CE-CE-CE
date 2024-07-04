package magicbook.gtlitecore.integration.fluiddrawers;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Items;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Glass;
import static gregtech.api.unification.material.Materials.Steel;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;

public class FluidDrawersRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getItemById(Mods.FluidDrawers.getID(), "tank"));
        ModHandler.addShapedRecipe(true, "tank", getItemById(Mods.FluidDrawers.getID(), "tank"),
                "AAA", "PBP", "AAA",
                'P', new UnificationEntry(plate, Glass),
                'B', Items.BUCKET,
                'A', new UnificationEntry(plate, Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input(Items.BUCKET)
                .input(plate, Steel, 6)
                .input(plate, Glass, 2)
                .outputs(getItemById(Mods.FluidDrawers.getID(), "tank"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();
    }
}
