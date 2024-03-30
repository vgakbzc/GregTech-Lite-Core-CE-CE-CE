package magicbook.gtlitecore.integration.gregtechfoodoption;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import gregtechfoodoption.item.GTFOMetaItem;

import static gregtech.api.unification.material.Materials.Bronze;
import static gregtech.api.unification.ore.OrePrefix.plate;

public class GTFOMiscRecipes {

    public static void init() {

        //  Empty Bronze Shape
        ModHandler.addShapedRecipe("bronze_shape_empty", GTFOMetaItem.BLANK_PASTA_DIE.getStackForm(),
                "hf ", "PP ", "PP ",
                'P', new UnificationEntry(plate, Bronze));

    }
}
