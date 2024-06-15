package magicbook.gtlitecore.integration.chisel;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.unification.material.Materials.Cobalt;
import static gregtech.api.unification.ore.OrePrefix.pipeSmallItem;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class ChiselMiscRecipes {

    public static void init() {

        ModHandler.removeRecipeByName(Mods.Chisel.getID() + ":" + "auto_chisel");
        if (Mods.EnderIO.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "auto_chisel", getItemById(Mods.Chisel.getID(), "auto_chisel"),
                    "GXG", "YHR", "PCP",
                    'H', getMetaItemById(Mods.EnderIO.getID(), "item_material", 0), // Ore Dict: itemSimpleMachineChassi
                    'C', "craftingChisel",
                    'Y', CONVEYOR_MODULE_LV,
                    'R', ROBOT_ARM_LV,
                    'X', ITEM_FILTER,
                    'P', new UnificationEntry(pipeSmallItem, Cobalt),
                    'G', new ItemStack(Blocks.GLASS));
        }
    }
}
