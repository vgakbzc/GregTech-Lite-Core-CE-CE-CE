package magicbook.gtlitecore.api.recipe;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.recipe.builder.NoCoilTemperatureRecipeBuilder;

public class GTLiteRecipeMaps {

    //  Single Machine RecipeMaps
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES;

    //  Multiblock Machine RecipeMaps
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES;
    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES;
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES;
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> INDUSTRIAL_ROASTER_RECIPES;
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZATION_RECIPES;

    public GTLiteRecipeMaps() {}

    static {
        //  Chemical Dryer RecipeMap
        CHEMICAL_DRYER_RECIPES = new RecipeMap<>("chemical_dryer_recipes", 1, 2, 1, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.FURNACE);
        //  Vacuum Chamber RecipeMap
        VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber_recipes", 4, 1, 2, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ASSEMBLER);

        //  Industrial Drilling Reg RecipeMap
        DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setSound(GTSoundEvents.MACERATOR);
        //  Catalytic Reformer RecipeMap
        CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 0, 1, 4, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
        //  Sonicator RecipeMap
        SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 1, 2, 1, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.FOIL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CENTRIFUGE);
        //  Nanoscale Fabricator RecipeMap
        MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 5, 1, 2,  0, new NoCoilTemperatureRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(false, true, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
                .setSlotOverlay(true, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
                .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);
        //  Industrial Roaster RecipeMap
        INDUSTRIAL_ROASTER_RECIPES = new RecipeMap<>("industrial_roaster_recipes", 3, 3, 3,  3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
        //  Crystallization Crucible RecipeMap
        CRYSTALLIZATION_RECIPES = new RecipeMap<>("crystallization_recipes", 6, 1, 3, 0, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.FURNACE);
    }
}
