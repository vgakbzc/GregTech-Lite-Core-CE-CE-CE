package magicbook.gtlitecore.integration.ironchest;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.plateDouble;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getMetaItemById;

public class IronChestRecipeLoader {

    public static void init() {

        //  T1: Iron Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 0));
        ModHandler.addShapedRecipe(true, "iron_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 0),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Iron),
                'F', new ItemStack(Blocks.CHEST));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.CHEST))
                .input(plateDouble, Iron, 2)
                .outputs(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 0))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  T2: Copper Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 3));
        ModHandler.addShapedRecipe(true, "copper_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 3),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Copper),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 0));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.CHEST))
                .input(plateDouble, Copper, 2)
                .outputs(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 3))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  T3: Silver Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 4));
        ModHandler.addShapedRecipe(true, "silver_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 4),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Silver),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 3));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.CHEST))
                .input(plateDouble, Silver, 2)
                .outputs(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 4))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  T4: Gold Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 1));
        ModHandler.addShapedRecipe(true, "gold_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 1),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Gold),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 4));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.CHEST))
                .input(plateDouble, Gold, 2)
                .outputs(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 1))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  T5: Diamond Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 2));
        ModHandler.addShapedRecipe(true, "diamond_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 2),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Diamond),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 1));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Blocks.CHEST))
                .input(plate, Diamond, 4)
                .outputs(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  T6: Diamond Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 5));
        ModHandler.addShapedRecipe(true, "crystal_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 5),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Glass),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 2));

        //  T6: Obsidian Chest
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.IronChest.getID(), "iron_chest", 6));
        ModHandler.addShapedRecipe(true, "obsidian_chest", getMetaItemById(Mods.IronChest.getID(), "iron_chest", 6),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(plate, Obsidian),
                'F', getMetaItemById(Mods.IronChest.getID(), "iron_chest", 2));

    }
}
