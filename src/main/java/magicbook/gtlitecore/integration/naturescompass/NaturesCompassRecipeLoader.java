package magicbook.gtlitecore.integration.naturescompass;

import gregtech.api.recipes.ModHandler;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Items;

import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getMetaItemById;

public class NaturesCompassRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getItemById(Mods.NaturesCompass.getID(), "naturescompass"));
        ModHandler.addShapedRecipe(true, "natures_compass", getItemById(Mods.NaturesCompass.getID(), "naturescompass"),
                " P ", "PCP", " P ",
                'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32007), // Ore Dict: platePulsatingIron
                'C', Items.COMPASS);
    }
}
