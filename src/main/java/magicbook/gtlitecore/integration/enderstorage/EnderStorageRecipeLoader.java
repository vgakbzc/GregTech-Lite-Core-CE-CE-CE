package magicbook.gtlitecore.integration.enderstorage;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Items;

import static gregtech.api.unification.material.Materials.Obsidian;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.FIELD_GENERATOR_ULV;

public class EnderStorageRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.EnderStorage.getID(), "ender_storage", 0));
        if (Mods.StorageDrawers.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "ender_chest", getMetaItemById(Mods.EnderStorage.getID(), "ender_storage", 0),
                    "PFP", "SCS", "PEP",
                    'P', new UnificationEntry(plate, Obsidian),
                    'S', Items.BLAZE_ROD,
                    'C', "drawerBasic",
                    'F', FIELD_GENERATOR_ULV,
                    'E', Items.ENDER_PEARL);
        }

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.EnderStorage.getID(), "ender_storage", 1));
        if (Mods.FluidDrawers.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "ender_tank", getMetaItemById(Mods.EnderStorage.getID(), "ender_storage", 1),
                    "PFP", "STS", "PEP",
                    'P', new UnificationEntry(plate, Obsidian),
                    'S', Items.BLAZE_ROD,
                    'T', getItemById(Mods.FluidDrawers.getID(), "tank"),
                    'F', FIELD_GENERATOR_ULV,
                    'E', Items.ENDER_PEARL);
        }

    }
}
