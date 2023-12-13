package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.VA;
import static gregtech.api.GTValues.ZPM;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TURBINE_MIXER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class TurbineMixer {

    public static void init() {

        //  this recipe is bigger than mixer, so...maybe we can add all gcym Alloy Smelter recipe in this recipe!
        //  of course, its product dust material.

        //  An easy testing recipe
        TURBINE_MIXER_RECIPES.recipeBuilder()
                .input(dust, Inconel792, 8)
                .input(dust, EglinSteel, 5)
                .input(dust, NaquadahAlloy, 4)
                .input(dust, TungstenSteel, 4)
                .input(dust, Cerium, 3)
                .input(dust, Antimony, 2)
                .input(dust, Platinum, 2)
                .input(dust, Ytterbium)
                .circuitMeta(8)
                .output(dust, Pikyonium64B, 29)
                .EUt(VA[ZPM])
                .duration(6000)
                .buildAndRegister();

    }
}
