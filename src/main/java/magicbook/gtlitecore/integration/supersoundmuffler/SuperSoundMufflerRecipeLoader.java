package magicbook.gtlitecore.integration.supersoundmuffler;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Tin;
import static gregtech.api.unification.ore.OrePrefix.spring;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;

public class SuperSoundMufflerRecipeLoader {

    public static void init() {

        ModHandler.removeRecipeByOutput(getItemById(Mods.SuperSoundMuffler.getID(), "sound_muffler"));
        ModHandler.addShapedRecipe(true, "sound_muffler", getItemById(Mods.SuperSoundMuffler.getID(), "sound_muffler"),
                " W ", "WCW", " W ",
                'C', new UnificationEntry(spring, Tin),
                'W', "wool");

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input("wool", 4)
                .input(spring, Tin)
                .outputs(getItemById(Mods.SuperSoundMuffler.getID(), "sound_muffler"))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

    }
}
