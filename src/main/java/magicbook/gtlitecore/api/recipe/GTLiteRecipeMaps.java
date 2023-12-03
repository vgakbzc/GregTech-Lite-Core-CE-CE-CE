package magicbook.gtlitecore.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.recipe.builder.GrindBallRecipeBuilder;
import magicbook.gtlitecore.api.recipe.builder.NoCoilTemperatureRecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.gtlitecore.recipe.RecipeMaps")
@ZenRegister
public class GTLiteRecipeMaps {

    //  Single Machine RecipeMaps
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DRYER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> ROCKET_ENGINE_RECIPES;

    //  Multiblock Machine RecipeMaps
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> INDUSTRIAL_ROASTER_RECIPES;
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_UNIT_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES;
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES;
    @ZenProperty
    public static final RecipeMap<GrindBallRecipeBuilder> ISA_MILL_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_RECIPES;
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRONE_AIRPORT_RECIPES;
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES;

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
        //  Naquadah Reactor RecipeMap
        NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COMBUSTION);
        //  Rocket Engine RecipeMap
        ROCKET_ENGINE_RECIPES = new RecipeMap<>("rocket_engine_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setSound(GTSoundEvents.COMBUSTION);

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
        //  CVD Unit RecipeMap
        CVD_UNIT_RECIPES = new RecipeMap<>("cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Plasma CVD Unit RecipeMap
        PLASMA_CVD_UNIT_RECIPES = new RecipeMap<>("plasma_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Laser CVD Unit RecipeMap
        LASER_CVD_UNIT_RECIPES = new RecipeMap<>("laser_cvd_unit_recipes", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Burner Reactor RecipeMap
        BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 3, 3, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);
        //  Cryogenic Reactor RecipeMap
        CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 3, 2, 2, 2, new NoCoilTemperatureRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.COOLING);
        //  Fuel Refine Factory RecipeMap
        FUEL_REFINE_FACTORY_RECIPES = new RecipeMap<>("fuel_refine_factory_recipes", 3, 4, 4, 2, new SimpleRecipeBuilder(), false)
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);
        //  Hyper Reactor Mk I RecipeMap
        HYPER_REACTOR_MK1_RECIPES = new RecipeMap<>("hyper_reactor_mk1_recipes", 0, 0, 1,0 , new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);
        //  Hyper Reactor Mk II RecipeMap
        HYPER_REACTOR_MK2_RECIPES = new RecipeMap<>("hyper_reactor_mk2_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);
        //  Hyper Reactor Mk III RecipeMap
        HYPER_REACTOR_MK3_RECIPES = new RecipeMap<>("hyper_reactor_mk3_recipes", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ARC);
        //  Isa Mill RecipeMap
        ISA_MILL_RECIPES = new RecipeMap<>("isa_mill_recipes", 3, 3, 0, 0, new GrindBallRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.MACERATOR);
        //  Flotation Cell Regulator RecipeMap
        FLOTATION_RECIPES = new RecipeMap<>("flotation_recipes", 6, 0, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.BATH);
        //  Vacuum Drying Furnace RecipeMap
        VACUUM_DRYING_RECIPES = new RecipeMap<>("vacuum_drying_recipes", 1, 9, 2, 0, new BlastRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.FURNACE);
        //  Drone Airport RecipeMap
        DRONE_AIRPORT_RECIPES = new RecipeMap<>("drone_airport_recipes", 2, 9, 1, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
                .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
                .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                .setSound(GTSoundEvents.COMPUTATION);
        //  Ion Implantator RecipeMap
        ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implantator_recipes", 3, 1, 1, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.ELECTROLYZER);
    }
}