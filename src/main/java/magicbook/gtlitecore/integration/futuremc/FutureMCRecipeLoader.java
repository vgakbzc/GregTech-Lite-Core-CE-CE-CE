package magicbook.gtlitecore.integration.futuremc;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ALLOY_SMELTER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getMetaItemById;
import static magicbook.gtlitecore.integration.chisel.ChiselGroupHelper.addGroup;
import static magicbook.gtlitecore.integration.chisel.ChiselGroupHelper.addVariation;

public class FutureMCRecipeLoader {

    public static void init() {

        //  Blast Furnace
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "blast_furnace"));
        ModHandler.addShapedRecipe(true, "blast_furnace", getItemById(Mods.FutureMC.getID(), "blast_furnace"),
                "PPP", "PFP", "SSS",
                'S', getItemById(Mods.FutureMC.getID(), "smooth_stone"),
                'P', new UnificationEntry(plate, Iron),
                'F', new ItemStack(Blocks.FURNACE));

        //  Smoker
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "smoker"));
        if (Mods.ExtraUtilities2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "smoker", getItemById(Mods.FutureMC.getID(), "smoker"),
                    "OXO", "SFS", "OXO",
                    'F', new ItemStack(Blocks.FURNACE),
                    'S', new UnificationEntry(stick, Wood),
                    'O', getItemById(Mods.FutureMC.getID(), "smooth_stone"),
                    'X', getMetaItemById(Mods.ExtraUtilities2.getID(), "compressedcobblestone", 1));
        }

        //  Stone Cutter
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "stonecutter"));
        ModHandler.addShapedRecipe(true, "stonecutter", getItemById(Mods.FutureMC.getID(), "stonecutter"),
                " B ", "SSS",
                'S', getItemById(Mods.FutureMC.getID(), "smooth_stone"),
                'B', new UnificationEntry(toolHeadBuzzSaw, Iron));

        //  Bell
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "bell"));
        ModHandler.addShapedRecipe(true, "bell", getItemById(Mods.FutureMC.getID(), "bell"),
                "WXW", "WPW", "W W",
                'P', new UnificationEntry(plateDouble, Gold),
                'X', getItemById(Mods.GregTech.getID(), "treated_wood_fence"),
                'W', getItemById(Mods.FutureMC.getID(), "stone_brick_wall"));

        //  Chain
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "chain"));
        ModHandler.addShapedRecipe(true, "chain", getItemById(Mods.FutureMC.getID(), "chain", 4),
                " S ", " R ", " S ",
                'R', new UnificationEntry(ring, Iron),
                'S', new UnificationEntry(stick, Iron));

        //  Scaffolding
        ModHandler.addShapedRecipe(true, "scaffolding", getItemById(Mods.FutureMC.getID(), "scaffolding", 3),
                "STS", "S S", "S S",
                'S', new UnificationEntry(stick, Wood),
                'T', Items.STRING);

        //  Netherite ingot
        ModHandler.removeRecipeByOutput(getItemById(Mods.FutureMC.getID(), "netherite_ingot"));
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getItemById(Mods.FutureMC.getID(), "netherite_scrap", 4))
                .input(ingot, Gold, 4)
                .outputs(getItemById(Mods.FutureMC.getID(), "netherite_ingot"))
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(getItemById(Mods.FutureMC.getID(), "netherite_scrap", 4))
                .input(dust, Gold, 4)
                .outputs(getItemById(Mods.FutureMC.getID(), "netherite_ingot"))
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        //  Compatibility of Soul Soil and Soul Sand.
        if (Mods.Chisel.isModLoaded()) {
            addGroup("soul_sand");
            addVariation("soul_sand", new ItemStack(Blocks.SOUL_SAND));
            addVariation("soul_sand", getItemById(Mods.FutureMC.getID(), "soul_soil"));
        }

        //  TODO Add Compatibility of Vanilla Trapdoor and FutureMC Trapdoor via Chisel Group/Variation.
    }
}
