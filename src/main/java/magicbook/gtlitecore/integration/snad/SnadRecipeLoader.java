package magicbook.gtlitecore.integration.snad;

import gregtech.api.recipes.ModHandler;
import magicbook.gtlitecore.api.utils.Mods;

import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;
import static magicbook.gtlitecore.integration.chisel.ChiselGroupHelper.addGroup;
import static magicbook.gtlitecore.integration.chisel.ChiselGroupHelper.addVariation;

public class SnadRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.Snad.getID(), "snad", 0));
        if (Mods.ExtraUtilities2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "snad", getMetaItemById(Mods.Snad.getID(), "snad", 0),
                    " S ", " S ",
                    'S', getMetaItemById(Mods.ExtraUtilities2.getID(), "compressedsand", 1));
        }

        //  Add Chisel Variation of two Snads.
        ModHandler.removeRecipeByOutput(getMetaItemById(Mods.Snad.getID(), "snad", 1));
        if (Mods.Chisel.isModLoaded()) {
            addGroup("snad");
            addVariation("snad", getMetaItemById(Mods.Snad.getID(), "snad", 0));
            addVariation("snad", getMetaItemById(Mods.Snad.getID(), "snad", 1));
        }
    }
}
