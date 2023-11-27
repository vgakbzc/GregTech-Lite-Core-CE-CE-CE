package magicbook.gtlitecore.api.recipe;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class GTLiteRecipeMaps {

    //  Single Machine RecipeMaps
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES;

    //  Multiblock Machine RecipeMaps
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES;


    public GTLiteRecipeMaps() {}

    static {
        //  Chemical Dryer RecipeMap
        CHEMICAL_DRYER_RECIPES = new RecipeMap<>("chemical_dryer_recipes", 1, false, 2, false, 1, false, 1, false, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.FURNACE);
        //  Vacuum Chamber RecipeMap
        VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber_recipes", 4, false, 1, false, 2, false, 1, false, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Industrial Drilling Reg RecipeMap
        DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, false, 1, false, 0, false, 1, false, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.MACERATOR);
    }
}
