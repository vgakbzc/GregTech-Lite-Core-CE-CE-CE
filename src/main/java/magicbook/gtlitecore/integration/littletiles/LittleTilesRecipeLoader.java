package magicbook.gtlitecore.integration.littletiles;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.unification.material.Materials.Iron;
import static gregtech.api.unification.material.Materials.Lapis;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;

public class LittleTilesRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getItemById(Mods.LittleTiles.getID(), "hammer"));
        ModHandler.addShapedRecipe(true, "lt_hammer", getItemById(Mods.LittleTiles.getID(), "hammer"),
                "IIh", "IIR", "IIw",
                'I', new UnificationEntry(ingot, Iron),
                'R', new UnificationEntry(stick, Lapis));

        ModHandler.removeRecipeByOutput(getItemById(Mods.LittleTiles.getID(), "wrench"));
        ModHandler.addShapedRecipe(true, "lt_wrench", getItemById(Mods.LittleTiles.getID(), "wrench"),
                "PhP", " R ", " R ",
                'P', new UnificationEntry(plate, Iron),
                'R', new UnificationEntry(stick, Lapis));

        ModHandler.removeRecipeByOutput(getItemById(Mods.LittleTiles.getID(), "saw"));
        ModHandler.addShapedRecipe(true, "lt_saw", getItemById(Mods.LittleTiles.getID(), "saw"),
                "PPR", "fhR",
                'P', new UnificationEntry(plate, Iron),
                'R', new UnificationEntry(stick, Lapis));
    }
}
