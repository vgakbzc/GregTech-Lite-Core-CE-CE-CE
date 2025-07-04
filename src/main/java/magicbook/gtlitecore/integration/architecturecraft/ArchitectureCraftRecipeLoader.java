package magicbook.gtlitecore.integration.architecturecraft;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.unification.material.Materials.Iron;
import static gregtech.api.unification.material.Materials.Wood;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static gregtech.api.unification.ore.OrePrefix.toolHeadBuzzSaw;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.ELECTRIC_MOTOR_ULV;

public class ArchitectureCraftRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getItemById(Mods.ArchitectureCraft.getID(), "sawbench"));
        ModHandler.addShapedRecipe(true, "ac_sawbench", getItemById(Mods.ArchitectureCraft.getID(), "sawbench"),
                "PBP", "SMS", "S S",
                'B', new UnificationEntry(toolHeadBuzzSaw, Iron),
                'P', new UnificationEntry(plate, Iron),
                'S', new UnificationEntry(stick, Wood),
                'M', ELECTRIC_MOTOR_ULV);

        ModHandler.removeRecipeByOutput(getItemById(Mods.ArchitectureCraft.getID(), "hammer"));
        ModHandler.addShapedRecipe(true, "ac_hammer", getItemById(Mods.ArchitectureCraft.getID(), "hammer"),
                "PP ", "ORP", "OR ",
                'P', new UnificationEntry(plate, Iron),
                'R', new UnificationEntry(stick, Wood),
                'O', "dyeOrange");

        ModHandler.removeRecipeByOutput(getItemById(Mods.ArchitectureCraft.getID(), "chisel"));
        ModHandler.addShapedRecipe(true, "ac_chisel", getItemById(Mods.ArchitectureCraft.getID(), "chisel"),
                "P  ", "OR ", "   ",
                'P', new UnificationEntry(plate, Iron),
                'R', new UnificationEntry(stick, Wood),
                'O', "dyeOrange");

    }
}
