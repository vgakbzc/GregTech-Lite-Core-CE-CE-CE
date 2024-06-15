package magicbook.gtlitecore.integration.storagedrawers;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class StorageDrawersMiscRecipes {

    public static void init() {

        //  Upgrade Template
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .input("drawerBasic")
                .input(stick, Wood, 8)
                .outputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade Storage I (Obsidian)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(block, Obsidian, 2)
                .input(stick, Wood, 6)
                .outputs(getMetaItemById(Mods.StorageDrawers.getID(), "upgrade_storage", 0))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade Storage II (Iron)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(ingot, Iron, 2)
                .input(stick, Wood, 6)
                .outputs(getMetaItemById(Mods.StorageDrawers.getID(), "upgrade_storage", 1))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade Storage III (Gold)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(ingot, Gold, 2)
                .input(stick, Wood, 6)
                .outputs(getMetaItemById(Mods.StorageDrawers.getID(), "upgrade_storage", 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade Storage IV (Diamond)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(gem, Diamond, 2)
                .input(stick, Wood, 6)
                .outputs(getMetaItemById(Mods.StorageDrawers.getID(), "upgrade_storage", 3))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade Storage V (Emerald)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(gem, Emerald, 2)
                .input(stick, Wood, 6)
                .outputs(getMetaItemById(Mods.StorageDrawers.getID(), "upgrade_storage", 4))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Upgrade 1 Stack
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(8)
                .inputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_template"))
                .input(gem, Flint, 2)
                .input(stick, Wood, 6)
                .outputs(getItemById(Mods.StorageDrawers.getID(), "upgrade_one_stack"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Drawer Key
        ModHandler.removeRecipeByOutput(getItemById(Mods.StorageDrawers.getID(), "drawer_key"));
        ModHandler.addShapedRecipe(true, "drawer_key", getItemById(Mods.StorageDrawers.getID(), "drawer_key"),
                "BR ", " R ", " M ",
                'B', new UnificationEntry(bolt, Brass),
                'R', new UnificationEntry(stick, Brass),
                'M', getItemById(Mods.StorageDrawers.getID(), "upgrade_template"));

    }
}
