package magicbook.gtlitecore.integration.gregtechfoodoption;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import gregtechfoodoption.item.GTFOMetaItem;
import magicbook.gtlitecore.api.utils.Mods;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Bronze;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Bedrock;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getMetaItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.BEDROCK_CHOCOLATE;

public class GTFOMiscRecipes {

    public static void init() {

        //  Empty Bronze Shape
        ModHandler.addShapedRecipe("bronze_shape_empty", GTFOMetaItem.BLANK_PASTA_DIE.getStackForm(),
                "hf ", "PP ", "PP ",
                'P', new UnificationEntry(plate, Bronze));

        //  Bedrock Chocolate
        //  {@code ingotHotMilkChocolate} + 144L Bedrock -> Bedrock Chocolate
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .inputs(getMetaItemById(Mods.GregTechFoodOption.getID(), "gtfo_oredict_item", 1043))
                .fluidInputs(Bedrock.getFluid(L))
                .output(BEDROCK_CHOCOLATE)
                .EUt(VA[UHV])
                .duration(30 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }
}
