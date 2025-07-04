package magicbook.gtlitecore.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.machines.RecipeMapAssemblyLine;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.api.capability.impl.HeatExchangerRecipeLogic;
import magicbook.gtlitecore.api.gui.GTLiteGuiTextures;
import magicbook.gtlitecore.api.pattern.GTLiteTraceabilityPredicate;
import magicbook.gtlitecore.api.recipe.builders.*;
import magicbook.gtlitecore.api.recipe.machines.*;
import magicbook.gtlitecore.api.recipe.properties.*;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.unification.materials.info.GTLiteMaterialFlags;
import magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.*;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import magicbook.gtlitecore.common.metatileentities.multi.electric.*;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityExtremeHeatExchanger;
import magicbook.gtlitecore.common.metatileentities.multi.electric.adv.MetaTileEntityMegaHeatExchanger;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityHyperReactorMkI;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityHyperReactorMkII;
import magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityHyperReactorMkIII;
import magicbook.gtlitecore.loaders.chains.*;
import magicbook.gtlitecore.loaders.circuits.*;
import magicbook.gtlitecore.loaders.handlers.BouleRecipeHandler;
import magicbook.gtlitecore.loaders.multiblock.*;
import magicbook.gtlitecore.loaders.oreprocessing.IsaMillOreProcessing;
import magicbook.gtlitecore.loaders.oreprocessing.TaraniumProcessing;
import net.minecraft.init.SoundEvents;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

import java.math.BigInteger;
import java.util.function.Consumer;

import static gregtech.api.recipes.RecipeMaps.*;

/**
 * Recipe Maps
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is the basic class of {@code gtlitecore} recipe maps.
 *     Examples and notes in this class is not for ZenScript (CraftTweaker),
 *     these descriptions are for Java, so if you want create a addition mod,
 *     then you can read and learn it (maybe needs some basic tutorials).
 * </p>
 *
 * <p>
 *     This class is also a {@link ZenClass}, in CraftTweaker, you can use
 *     <pre>{@code
 *         mods.gtlitecore.recipe.RecipeMaps
 *     }</pre>
 *     to use this class (fixme some parameter maybe error now).
 * </p>
 *
 * @since 2.8.7-beta
 */
@ZenClass("mods.gtlitecore.recipe.RecipeMaps")
@ZenRegister
public class GTLiteRecipeMaps {

    public GTLiteRecipeMaps() {}

    //////////////////////////////////
    //  Single Machine Recipe Maps  //
    /////////////////////////////////

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CHEMICAL_DRYER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, Materials.Naquadria)
     *          .fluidInputs(GTLiteMaterials.Orichalcum.getFluid(1000))
     *          .output(OrePrefix.dust, Materials.Naquadah, 2)
     *          .fluidOutputs(GTLiteMaterials.Bedrock.getFluid(1000))
     *          .EUt(VA[EV])
     *          .duration(1200)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Another name is `Dehydrator` (some mod use this name, such as GT++ and GCY),
     *     we use `Chemical Dryer` like Gregicality Science. This Recipe Map has 1 inputs,
     *     2 outputs, and 1 fluid inputs and 1 fluid outputs, just like Gregicality Science.
     *     If you want to tweak these settings, please init it before this class load,
     *     you can use some method like {@link RecipeMap#setMaxInputs(int)} (change size),
     *     and {@link RecipeMap#setSlotOverlay(boolean, boolean, TextureArea)} (change texture).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CHEMICAL_DEHYDRATOR_RECIPES = new RecipeMap<>("chemical_dehydrator", 1, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_LV.getStackForm(2))
     *          .input(OrePrefix.String, Materials.Bronze)
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, 1000))
     *          .output(MetaItems.COIN_CHOCOLATE, 2)
     *          .EUt((int) (V[OpV]))
     *          .duration(Materials.Bronze.getMass() * 16)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Vacuum Chamber is special machine from Gregicality Science (has many different),
     *     in {@code gtlitecore}, this machine has Steam/High Pressure Steam version,
     *     so if you want add Steam stage recipes, you can use {@code V[ULV]} or {@code V[LV]}
     *     in Energy Consumed, i.e. {@link RecipeBuilder#EUt(int)}
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER_RECIPES = new RecipeMap<>("vacuum_chamber", 4, 1, 2, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.NAQUADAH_REACTOR_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.NaquadahEnriched)
     *          .EUt(3356)
     *          .duration(124)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Fuel Recipe Map for Naquadah Reactor (Gregicality Style, so has not product).
     *     In {@code gtlitecore}, all fuel of Generators can tweak heat value by config,
     *     we wrote it in {@link GTLiteConfigHolder#misc} in common, and use below formatting:
     *
     *     <pre>{@code
     *         heatValueFuelName
     *     }</pre>
     *
     *     and set a range to give player choice chance (do not too large). Please use non-negative
     *     energy consumed, if not, then your generator fuel cannot emitted any energy.
     * </p>
     *
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR_RECIPES = new RecipeMap<>("naquadah_reactor", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.ROCKET_ENGINE_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, L / 4))
     *          .EUt(VHA[IV])
     *          .duration(15)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Rocket Engine is another Liquid-Only Generator, just like Naquadah Reactor.
     *     In example, this symbol 'L' is {@link GTValues#L}, means 144 (liquid unit).
     * </p>
     *
     * @see RocketFuelChain
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> ROCKET_ENGINE_RECIPES = new RecipeMap<>("rocket_engine", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.BIO_REACTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Biomass.getFluid(L * 4))
     *          .fluidInputs(Materials.Lava.getFluid(L * 2))
     *          .output(OrePrefix.dust, Materials.Obsidian, 4)
     *          .fluidOutputs(Materials.Water.getFluid(L * 2))
     *          .EUt(VH[ZPM])
     *          .duration(1200)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Bio Reactor (a.k.a. Biological Reactor) is a Chemical Reactor-like machine,
     *     the prototype of this machine is Bio Lab in Bartworks.
     * </p>
     *
     * @see BioReactor
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIO_REACTOR_RECIPES = new RecipeMap<>("bio_reactor", 6, 1, 3, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, true, GTLiteGuiTextures.DISH_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CONDENSER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.block, Materials.Gold)
     *          .output(GTLiteOrePrefix.singularity, Materials.Gold)
     *          .EUt(VA[IV])
     *          .duration(800)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Condenser is a special Machine for Singularity Processing (prototype is from Avaritia),
     *     this machine is dependenced with Processing Array, because its fluid capacity is too low.
     * </p>
     *
     * @see GTLiteMaterialFlags#GENERATE_SINGULARITY
     * @see Condenser
     */

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CONDENSER_RECIPES = new RecipeMap<>("condenser", 1, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
            .setSound(GTSoundEvents.COMPRESSOR);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.SIMULATOR_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MEMORY_CARD_ZOMBIE)
     *          .circuitMeta(1)
     *          .chancedOutput(new ItemStack(Items.ROTTEN_FLESH, 64), 8000, 500)
     *          .EUt(VA[LV])
     *          .duration(1200)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Simulator is a special Machine used to product mob drops and misc.
     *     The prototype is a same function machine in Deep Mob Learning.
     *     All chance of this machine can tweak in {@link GTLiteConfigHolder#machines},
     *     and exist of this machine also can disable in this config.
     * </p>
     *
     * @see Simulator
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SIMULATOR_RECIPES = new RecipeMap<>("simulator", 2, 2, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

    //////////////////////////////////////
    //  Multiblock Machine Recipe Maps  //
    //////////////////////////////////////

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.DRILLING_RECIPES.recipeBuilder()
     *          .input(new ItemStack(Blocks.BEDROCK))
     *          .chancedOutput(OrePrefix.dust, GTLiteMaterials.Bedrock, 5000, 500)
     *          .fluidOutputs(GTLiteMaterials.BedrockSmoke.getFluid(16000))
     *          .duration(200)
     *          .EUt(VA[UEV])
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Industrial Drilling Rig is a special Multiblock Machine which used to drilling block,
     *     this machine will break the block which below the Drill Heat block in Structures.
     *     If you use not consumable input, then the below block cannot breaked.
     * </p>
     *
     * @see MetaTileEntityIndustrialDrillingRig
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMap<>("industrial_drilling_rig", 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CATALYTIC_REFORMER_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, Materials.Neutronium)
     *          .fluidInputs(GTLiteMaterials.Spacetime.getFluid(48000))
     *          .fluidOutputs(GTLiteMaterials.Infinity.getFluid(8000))
     *          .fluidOutputs(GTLiteMaterials.Hypogen.getFluid(12000))
     *          .fluidOutputs(GTLiteMaterials.Rhugnor.getFluid(14000))
     *          .fluidOutputs(GTLiteMaterials.CrystalMatrix.getFluid(14000))
     *          .duration(200)
     *          .EUt(VA[UEV])
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Catalytic Reformer is a Multiblock Machine used to rearrange molecules of material,
     *     we use a not consumable plate as catalyst in common.
     * </p>
     *
     * @see MetaTileEntityCatalyticReformer
     * @see OilChain
     * @see ChlorineChain
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer", 1, 0, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.SONICATION_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.Blood.getFluid(64000))
     *          .fluidOutputs(GTLiteMaterials.BloodCells.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.BloodPlasma.getFluid(16000))
     *          .EUt(VA[ZPM])
     *          .duration(200)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Sonicator is a Multiblock Machine used to extraction/stirring/separation,
     *     we used this Recipe Map in some Biological recipes and Fantastic recipes.
     * </p>
     *
     * @see MetaTileEntitySonicator
     * @see DragonChain
     * @see PhosphorusChain
     * @see GoowareCircuits
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES = new RecipeMap<>("sonicator", 0, 1, 2, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
                .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
                .setSlotOverlay(true, false, true, GTLiteGuiTextures.FOIL_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
                .setSound(GTSoundEvents.CENTRIFUGE);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.MOLECULAR_BEAM_RECIPES.recipeBuilder()
     *          .input(OrePrefix.foil, Materials.Nickel, 8)
     *          .input(OrePrefix.dust, Materials.Boron)
     *          .fluidInputs(Materials.Nitrogen.getFluid(1000))
     *          .output(OrePrefix.gem, GTLiteMaterials.HexagonalBoronNitride, 2)
     *          .EUt(VA[UEV])
     *          .duration(80)
     *          .temperature(2900)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Nanoscale Fabricator is a Multiblock Machine from GregTech 6 (but has many different),
     *     this machine use Crucible to predicate temperature, use {@link NoCoilTemperatureRecipeBuilder#temperature(int)}
     *     to set temperature of recipe, but the predicate is in {@code MetaTileEntity} class.
     * </p>
     *
     * @see MetaTileEntityNanoscaleFabricator
     * @see BlockCrucible
     * @see BoronNitrideChain
     * @see PhosphorusChain
     * @see OpticalCircuits
     * @see SpintronicCircuits
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES = new RecipeMap<>("nanoscale_fabricator", 6, 1, 2,  0, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, GTLiteGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, Materials.Quicklime, 2)
     *          .input(OrePrefix.dust, Materials.Carbon, 3)
     *          .output(OrePrefix.dust, Materials.CalciumCarbide, 3)
     *          .fluidOutputs(Materials.CarbonMonoxide.getFluid(1000))
     *          .EUt(VA[MV])
     *          .duration(500)
     *          .temperature(2473)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Industrial Roaster is a Multiblock Machine used to processing ore,
     *     this machine use Fire Box Casing to predicate temperature,
     *     but the predicate is in {@code MetaTileEntity} class.
     * </p>
     *
     * @see MetaTileEntityIndustrialRoaster
     * @see BlockFireboxCasing
     * @see GTLiteTraceabilityPredicate#FIRE_BOX
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> INDUSTRIAL_ROASTER_RECIPES = new RecipeMap<>("industrial_roaster", 3, 3, 3,  3, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CRYSTALLIZATION_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, CubicZirconia, 64)
     *          .input(OrePrefix.dust, Europium, 8)
     *          .output(GTLiteMetaItems.CUBIC_ZIRCONIA_EUROPIUM_BOULE)
     *          .EUt(VA[MV])
     *          .duration(120)
     *          .blastFurnaceTemp(3000)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Crystallization Crucible is a Multiblock Machine used to processing crystal.
     *     This Recipe Map is actually unused in common situation, because we used auto-generated recipes.
     *     In some special Crystal, like {@link GTLiteMetaItems#CUBIC_ZIRCONIA_EUROPIUM_BOULE},
     *     we used this Recipe Map to tweak its recipe (this is the only situation in {@code gtlitecore}).
     * </p>
     *
     * @see MetaTileEntityCrystallizationCrucible
     * @see GTLiteOrePrefix#seedCrystal
     * @see GTLiteOrePrefix#boule
     * @see GTLiteMaterialFlags#GENERATE_BOULE
     * @see GTLiteMaterialFlags#DISABLE_CRYSTALLIZATION
     * @see BouleRecipeHandler
     *
     */
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZATION_RECIPES = new RecipeMap<>("crystallization_crucible", 6, 1, 3, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CVD_UNIT_RECIPES.recipeBuilder()
     *          .inputs(GTFOMaterialHandler.LithiumCarbonate.getItemStack(6))
     *          .fluidInputs(GTLiteMaterials.CalciumTrifluoromethansulphonate.getFluid(1000))
     *          .output(dust, GTLiteMaterials.LithiumTrifluoromethansulphonate, 18)
     *          .output(dust, GTLiteMaterials.CalciumCarbonate, 5)
     *          .EUt(VA[EV])
     *          .duration(340)
     *          .temperature(1600)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Chemical Vapor Deposition Unit is a Multiblock Machine like Chemical Reactor function,
     *     this machine also has temperature property, but not has pressure property (in Gregicality
     *     Science, CVD Unit has both two properties, but it is too fussy in {@code gtlitecore}).
     * </p>
     *
     * @see MetaTileEntityCVDUnit
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CVD_UNIT_RECIPES = new RecipeMap<>("cvd_unit", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.PLASMA_CVD_UNIT_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, Materials.Rhenium)
     *          .fluidInputs(GTLiteMaterials.Acetylene.getFluid(3000))
     *          .fluidInputs(GTLiteMaterials.Cycloparaphenylene.getFluid(7000))
     *          .fluidInputs(Materials.Nitrogen.getPlasma(10000))
     *          .output(OrePrefix.ingot, GTLiteMaterials.CarbonNanotube)
     *          .fluidOutputs(Materials.Ammonia.getFluid(10000))
     *          .EUt(VA[UV])
     *          .duration(100)
     *          .temperature(993)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Plasma-enriched Chemical Vapor Deposition Unit is a Multiblock Machine
     *     like CVD Unit (but needs to use plasma as catalyst). In {@code gtlitecore},
     *     this machine use to product different Nanotubes, and use another catalyst
     *     to resolve recipe conflicts (like plate or double plate).
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this Recipe Map
     *          be advanced version of CVD Unit recipes.
     * </p>
     *
     * @see MetaTileEntityPlasmaCVDUnit
     * @see NanotubesChain
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> PLASMA_CVD_UNIT_RECIPES = new RecipeMap<>("plasma_cvd_unit", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.LASER_CVD_UNIT_RECIPES.recipeBuilder()
     *          .input(OrePrefix.wireFine, GTLiteMaterials.SuperheavyHAlloy, 8)
     *          .input(OrePrefix.plate, GTLiteMaterials.Rhugnor)
     *          .fluidInputs(GTLiteMaterials.Zylon.getFluid(L * 2))
     *          .output(GTLiteMetaItems.COSMIC_CAPACITOR, 32)
     *          .EUt(VA[UEV])
     *          .duration(160)
     *          .temperature(5630)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Laser-induced Chemical Vapor Deposition Unit is a Multiblock Machine
     *     like CVD Unit. Just like Plasma CVD Unit, this machine is also an Advanced CVD
     *     Unit. Used for all Advanced SMD Components (Optical-Supracausal), Optical Fiber
     *     and some misc items.
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this Recipe Map
     *          be advanced version of CVD Unit recipes.
     * </p>
     *
     * @see MetaTileEntityLaserCVDUnit
     * @see NanotubesChain
     * @see OpticalCircuits
     * @see SpintronicCircuits
     * @see CosmicCircuits
     * @see SupracausalCircuits
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> LASER_CVD_UNIT_RECIPES = new RecipeMap<>("laser_cvd_unit", 2, 2, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.BURNER_REACTOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.dust, Materials.Silver)
     *          .fluidInputs(Materials.Ethylene.getFluid(7000))
     *          .fluidOutputs(GTLiteMaterials.EthyleneOxide.getFluid(6000))
     *          .fluidOutputs(Materials.CarbonDioxide.getFluid(2000))
     *          .fluidOutputs(Materials.Water.getFluid(2000))
     *          .EUt(VA[HV])
     *          .duration(150)
     *          .temperature(450)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Burner Reactor is a Multiblock Machine like Chemical Reactor function.
     * </p>
     *
     * @see MetaTileEntityBurnerReactor
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor", 3, 3, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSlotOverlay(false, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.dust, Materials.Iron)
     *          .fluidInputs(Materials.Butadiene.getFluid(1000))
     *          .fluidInputs(GTLiteMaterials.Acrylonitrile.getFluid(1000))
     *          .notConsumable(GTLiteMaterials.HydrogenPeroxide.getFluid(1))
     *          .fluidOutputs(GTLiteMaterials.NitrileButadieneRubber.getFluid(1000))
     *          .EUt(VA[LuV])
     *          .duration(200)
     *          .temperature(286)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Cryogenic Reactor is a Multiblock Machine like Chemical Reactor function.
     * </p>
     *
     * @see MetaTileEntityCryogenicReactor
     */
    @ZenProperty
    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor", 3, 3, 3, 3, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSlotOverlay(false, true, GuiTextures.BEAKER_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.FUEL_REFINE_FACTORY_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.Tiberium)
     *          .input(OrePrefix.dust, GTLiteMaterials.OrichalcumEnergized)
     *          .circuitMeta(11)
     *          .fluidInputs(Materials.NaquadahEnriched.getFluid(2000))
     *          .fluidInputs(GTLiteMaterials.Vibranium.getPlasma(1000))
     *          .fluidInputs(GTLiteMaterials.HeavyHyperFuel.getFluid(400))
     *          .fluidInputs(GTLiteMaterials.SuperheavyExoticGas.getFluid(200))
     *          .fluidOutputs(GTLiteMaterials.HyperFuelMkII.getFluid(3000))
     *          .EUt(VA[UEV])
     *          .duration(100)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Fuel Refine Factory is a Multiblock Machine used to product many fuels,
     *     part of function of this machine is called by `Superheavy Reaction` in Gregicality
     *     Science. The special product of this machine is related of Hyper Reactor.
     * </p>
     *
     * @see MetaTileEntityFuelRefineFactory
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES = new RecipeMap<>("fuel_refine_factory", 3, 4, 4, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK1_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.HyperFuelMkII.getFluid(1))
     *          .duration(300)
     *          .EUt(524288)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Hyper Reactors are Ultimate Naquadah Reactor (and have 3 tier), this is T1 Hyper Reactor.
     * </p>
     *
     * @see MetaTileEntityHyperReactorMkI
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES = new RecipeMap<>("hyper_reactor_mk1", 0, 0, 1,0 , new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK2_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.HyperFuelMkIII.getFluid(1))
     *          .duration(600)
     *          .EUt(2097152)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Hyper Reactors are Ultimate Naquadah Reactor (and have 3 tier), this is T2 Hyper Reactor.
     * </p>
     *
     * @see MetaTileEntityHyperReactorMkII
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES = new RecipeMap<>("hyper_reactor_mk2", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.HYPER_REACTOR_MK3_RECIPES.recipeBuilder()
     *          .fluidInputs(HyperFuelMkIV.getFluid(1))
     *          .duration(1200)
     *          .EUt(GTLiteConfigHolder.misc.heatValueHyperFuelMark4)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     Hyper Reactors are Ultimate Naquadah Reactor (and have 3 tier), this is T3 Hyper Reactor.
     * </p>
     *
     * @see MetaTileEntityHyperReactorMkIII
     * @see TaraniumProcessing
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES = new RecipeMap<>("hyper_reactor_mk3", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.ISA_MILL_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ore, Materials.Almandine, 16)
     *          .circuitMeta(10)
     *          .output(GTLiteOrePrefix.milled, Materials.Almandine, 64)
     *          .output(GTLiteOrePrefix.milled, Materials.Almandine, 32)
     *          .EUt(VA[EV])
     *          .duration(2400)
     *          .grindBallTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Related to the special ore prefix {@link GTLiteOrePrefix#milled},
     *     this recipe map has a special property: grindball (please see {@link GTLiteMetaItems#GRINDBALL_ALUMINIUM}
     *     and {@link GTLiteMetaItems#GRINDBALL_SOAPSTONE}).
     *     Please use 1 or 2 to tweak grindball material (one correspond soapstone and another correspond to aluminium).
     * </p>
     *
     * @see MetaTileEntityIsaMill
     * @see GTLiteOrePrefix#milled
     * @see GTLiteMaterialFlags#GENERATE_MILLED
     * @see IsaMillOreProcessing
     */
    @ZenProperty
    public static final RecipeMap<GrindBallRecipeBuilder> ISA_MILL_RECIPES = new RecipeMap<>("isa_mill", 2, 2, 0, 0, new GrindBallRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.INT_CIRCUIT_OVERLAY)
            .setSlotOverlay(true, false, GTLiteGuiTextures.MILLED_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.FLOTATION_RECIPES.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.PotassiumEthylxanthate, 32)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .input(GTLiteOrePrefix.milled, Materials.Chalcopyrite, 64)
     *          .fluidInputs(GTLiteMaterials.Turpentine.getFluid(12000))
     *          .fluidOutputs(GTLiteMaterials.ChalcopyriteFront.getFluid(1000))
     *          .EUt(VA[IV])
     *          .duration(9600)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Next processing step before after {@link #ISA_MILL_RECIPES},
     *     please see {@link IsaMillOreProcessing}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_RECIPES = new RecipeMap<>("flotation_cell_regulator", 6, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GTLiteGuiTextures.REAGENT_OVERLAY)
            .setSlotOverlay(false, false, true, GTLiteGuiTextures.MILLED_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.VIAL_OVERLAY_2)
            .setSlotOverlay(true, true, GuiTextures.HEATING_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.VACUUM_DRYING_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.MonaziteFront.getFluid(4000))
     *          .output(OrePrefix.dust, Materials.Erbium, 64)
     *          .output(OrePrefix.dust, Materials.Zirconium, 64)
     *          .output(OrePrefix.dust, Materials.Lanthanum, 32)
     *          .output(OrePrefix.dust, Materials.Lutetium, 16)
     *          .output(OrePrefix.dust, Materials.Europium, 8)
     *          .EUt(VA[ZPM])
     *          .duration(2400)
     *          .blastFurnaceTemp(5500)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Final step of Isa Mill Ore Processing chain (after {@link #FLOTATION_RECIPES}),
     *     same as EBF's temperature system (but just have some special ranges).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_RECIPES = new RecipeMap<>("vacuum_drying_furnace", 1, 9, 1, 2, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, GuiTextures.INT_CIRCUIT_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DRONE_AIRPORT_RECIPES.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_EV.getStackForm(16))
     *          .circuitMeta(1)
     *          .fluidInputs(GTLiteMaterials.MethylhydrazineNitrateRocketFuel.getFluid(4000))
     *          .chancedOutput(OrePrefix.ore, Materials.Naquadah, 64, 5000, 500)
     *          .EUt(VA[EV)
     *          .duration(8)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipe map, please see {@link DroneAirport}.
     *     Usually used special method, please use this method.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DRONE_AIRPORT_RECIPES = new RecipeMap<>("unmanned_drone_airport", 2, 9, 1, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.COMPUTATION);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.ION_IMPLANTATOR_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ring, GTLiteMaterials.Fullerene)
     *          .input(OrePrefix.wireFine, GTLiteMaterials.ThalliumCopperChloride, 4)
     *          .fluidInputs(GTLiteMaterials.Kevlar.getFluid(L))
     *          .output(GTLiteMetaItems.SPINTRONIC_INDUCTOR, 16)
     *          .duration(160)
     *          .EUt(VA[UHV])
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used to product advanced smd inductor, such as {@link CosmicCircuits}.
     *     Now this recipe map just have this function (may be add more recipes for other function).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implantator", 3, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.FLUID_CORE_T7)
     *          .input(MetaItems.FIELD_GENERATOR_UV)
     *          .input(MetaTileEntities.QUANTUM_TANK[5])
     *          .input(OrePrefix.foil, GTLiteMaterials.PolyPhosphonitrileFluoroRubber, 64)
     *          .fluidInputs(GTLiteMaterials.Polyetheretherketone.getFluid(L * 128))
     *          .fluidInputs(Materials.TinAlloy.getFluid(L * 128))
     *          .fluidInputs(Materials.Lubricant.getFluid(7000))
     *          .fluidInputs(GTLiteMaterials.CelestialTungsten.getFluid(L * 4))
     *          .output(GTLiteMetaItems.FLUID_CORE_T8)
     *          .EUt(VA[UIV])
     *          .duration(400)
     *          .CasingTier(6)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Port from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>,
     *     and this recipe map has special property (different predicate of casings and internal casings),
     *     casings is {@link BlockPreciseAssemblerCasing},
     *     internal casings is {@link BlockMachineCasing} (above LuV).
     *     Usually used for some high tier components and System on Chip of advanced circuits (above wetware circuit),
     *     and also have some advanced recipes for original circuits (like wetware processing unit).
     *     Please use .CasingTier() method to define total tier of recipe,
     *     you can see {@link GTLiteTraceabilityPredicate#PA_CASING} and
     *      {@link GTLiteTraceabilityPredicate#PA_INTERNAL_CASING},
     *     these predicates control this machine recipes.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<AssemblyCasingTierRecipeBuilder> PRECISE_ASSEMBLER_RECIPES = new RecipeMapPreciseAssembler<>("precise_assembler", 4, 1, 4, 0, new AssemblyCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.cableGtDouble, Materials.Tungsten, 2)
     *          .input(OrePrefix.stick, Materials.TungstenSteel, 2)
     *          .input(OrePrefix.stick, Materials.NeodymiumMagnetic)
     *          .input(wireGtDouble, Materials.Graphene, 4)
     *          .output(MetaItems.ELECTRIC_MOTOR_IV)
     *          .EUt(VA[LV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Easy version of {@link #COMPONENT_ASSEMBLY_LINE_RECIPES}, so just a simple recipe map.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler", 6, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .input(OrePrefix.stickLong, GTLiteMaterials.PhosphorusDopedEuropiumIronArsenideMagnetic, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.stickLong, GTLiteMaterials.Legendarium, 64)
     *          .input(OrePrefix.cableGtHex, GTLiteMaterials.Solarium, 8)
     *          .fluidInputs(Materials.SolderingAlloy.getFluid(L * 32 * 64))
     *          .fluidInputs(Materials.Lubricant.getFluid(448000))
     *          .fluidInputs(GTLiteMaterials.Zylon.getFluid(L * 4 * 64))
     *          .fluidInputs(GTLiteMaterials.Astralium.getFluid(L * 2 * 64))
     *          .fluidInputs(GTLiteMaterials.Abyssalloy.getFluid(L * 16 * 64))
     *          .output(MetaItems.ELECTRIC_MOTOR_UIV, 64)
     *          .EUt(VA[UIV])
     *          .duration(1800)
     *          .CasingTier(UIV)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Port from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>,
     *     and this recipe map has special property (predicate blocks in {@link BlockComponentAssemblyLineCasing}),
     *     please see: {@link GTLiteTraceabilityPredicate#CA_CASING}.
     *     Used special JEI page textures, please see {@link RecipeMapComponentAssemblyLine}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<ComponentCasingTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapComponentAssemblyLine<>("component_assembly_line", 12, 1, 12, 0, new ComponentCasingTierRecipeBuilder(), false)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.TREE_GROWTH_RECIPES.recipeBuilder()
     *          .notConsumable(new ItemStack(Blocks.SAPLING, 1, 4))
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Water.getFluid(200))
     *          .outputs(new ItemStack(Blocks.LOG2, 8, 0))
     *          .outputs(new ItemStack(Blocks.LEAVES2, 4, 0))
     *          .chancedOutput(new ItemStack(Blocks.SAPLING, 1, 4), 4000, 500)
     *          .chancedOutput(new ItemStack(Items.APPLE), 2000, 500)
     *          .EUt(VA[LV])
     *          .duration(100)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipes for {@link MetaTileEntityTreeGrowthFactory}.
     *     TODO maybe rebalanced this recipe map and {@link gregtechfoodoption.recipe.chain.GreenhouseChain}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TREE_GROWTH_RECIPES = new RecipeMap<>("tree_growth_factory", 2, 4, 2, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.CHAINSAW_TOOL);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.COLLIDER_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.Copper.getFluid(L))
     *          .fluidInputs(Materials.Caesium.getFluid(L))
     *          .fluidOutputs(Materials.Actinium.getFluid(L))
     *          .fluidOutputs(GTLiteMaterials.FreeElectronGas.getFluid(L))
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .CasingTier(1)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used {@link GTLiteTraceabilityPredicate#FIELD_CASING} predicate,
     *     just another voltage property (so you can use voltage name, but should above ZPM),
     *     predicate blocks in {@link BlockFieldCasing}.
     *     If you add recipes of particles, then should output some Free Electric Gas.
     *     For high energy physics recipes, you should add circuit to distinguish recipes (pay attention conflicts!).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> COLLIDER_RECIPES = new RecipeMap<>("collider", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSound(GTSoundEvents.ELECTROLYZER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
     *          .notConsumable(OrePrefix.spring, GTLiteMaterials.Edenium)
     *          .input(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE, 64)
     *          .input(GTLiteMetaItems.HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
     *          .fluidInputs(GTLiteMaterial.RawStarMatter.getFluid(16000))
     *          .fluidInputs(GTLiteMaterial.StarCoreMatter.getPlasma(16000))
     *          .fluidInputs(GTLiteMaterial.QuantumchromodynamicallyConfinedMatter.getFluid(16000))
     *          .output(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT, 64)
     *          .fluidOutputs(GTLiteMaterials.Magmatter.getFluid(16000))
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is advanced version of {@link #DIMENSIONAL_OSCILLATOR_RECIPES},
     *     used special recipe property {@link GravitonCasingTierRecipeBuilder},
     *     and predicate tier by blocks in {@link BlockGravitonCasing}.
     *     All Dimensional Oscillator recipe will generate a same recipe in this recipe map,
     *     these recipes all have 1 tier property (mean low).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_OSCILLATING_MODULE = new RecipeMap<>("nicoll_dyson_beamer_oscillating_module", 6, 6, 6, 6, new GravitonCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : SoundEvents.ENTITY_GENERIC_EXPLODE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.plate, GTLiteMaterials.Galaxium)
     *          .fluidInputs(GTLiteMaterials.Fatalium.getPlasma(L))
     *          .fluidInputs(GTLiteMaterials.Hypogen.getFluid(L * 4))
     *          .fluidInputs(GTLiteMaterials.DimensionallyTranscendentResidue.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.Fatalium.getFluid(L))
     *          .EUt(VA[OpV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Maybe just a advanced version of {@link RecipeMaps#IMPLOSION_RECIPES},
     *     but you do not needs to use tnt! Used to some advanced materials for UIV+.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DIMENSIONAL_OSCILLATOR_RECIPES = new RecipeMap<>("dimensional_oscillator", 6, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.ARC : SoundEvents.ENTITY_GENERIC_EXPLODE)
            .onRecipeBuild((recipeBuilder) -> NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                    .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                    .fluidInputs(recipeBuilder.getFluidInputs())
                    .outputs(recipeBuilder.getOutputs())
                    .chancedOutputs(recipeBuilder.getChancedOutputs())
                    .fluidOutputs(recipeBuilder.getFluidOutputs())
                    .chancedFluidOutputs(recipeBuilder.getChancedFluidOutputs())
                    .duration(recipeBuilder.getDuration())
                    .EUt(recipeBuilder.getEUt())
                    .tier(1)
                    .hidden() // Hidden same recipes in NDB Oscillating Module recipe.
                    .buildAndRegister());

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
     *          .input(OrePrefix.wireFine, GTLiteMaterials.Magmatter, 4)
     *          .input(GTLiteMetaItems.HYPERSTABLE_SELF_HEALING_ADHESIVE)
     *          .input(GTLiteMetaItems.MANIFOLD_OSCILLATORY_POWER_CELL, 16)
     *          .fluidInputs(GTLiteMaterials.Magmatter.getFluid(L))
     *          .fluidInputs(GTLiteMaterials.Spacetime.getFluid(L * 4))
     *          .fluidInputs(GTLiteMaterials.CosmicNeutronium.getFluid(1000))
     *          .output(OrePrefix.wireGtSingle, GTLiteMaterials.Magmatter)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map is advanced version of {@link #STELLAR_FURNACE_RECIPES},
     *     all Stellar Furnace recipe will generate a same recipe in this recipe map.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_BURNING_MODULE = new RecipeMapNDBBurningModule<>("nicoll_dyson_beamer_burning_module", 9, 9, 9, 9, new GravitonCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(true, false, false, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTSoundEvents.FURNACE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.STELLAR_FURNACE_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ingot, Materials.Rhenium)
     *          .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
     *          .fluidOutputs(GTLiteMaterials.DegenerateRhenium.getPlasma(1000))
     *          .EUt(VA[UIV])
     *          .duration(20)
     *          .temperature(BigInteger.valueOf(3932160))
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Basic processing recipe in UEV+, use a special recipe builder.
     *     The different between {@link NoCoilTemperatureRecipeBuilder} and {@link NoCoilHigherTemperatureRecipeBuilder} is data type,
     *     this recipe builder use {@link BigInteger}, so you can write some big numbers in this recipe maps.
     *     Pay attention, if you use too big numbers, then may be cause some problem about {@link RecipeMap}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<NoCoilHigherTemperatureRecipeBuilder> STELLAR_FURNACE_RECIPES = new RecipeMap<>("stellar_furnace", 6, 6, 6, 6, new NoCoilHigherTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSound(GTValues.FOOLS.get() ? SoundEvents.ENTITY_GENERIC_EXPLODE : GTSoundEvents.FURNACE)
            .onRecipeBuild((recipeBuilder) -> NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                    .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                    .fluidInputs(recipeBuilder.getFluidInputs())
                    .outputs(recipeBuilder.getOutputs())
                    .chancedOutputs(recipeBuilder.getChancedOutputs())
                    .fluidOutputs(recipeBuilder.getFluidOutputs())
                    .chancedFluidOutputs(recipeBuilder.getChancedFluidOutputs())
                    .duration(recipeBuilder.getDuration())
                    .EUt(recipeBuilder.getEUt())
                    .tier(1)
                    .hidden() // Hidden same recipes in NDB Burning Module recipes.
                    .buildAndRegister());

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.PLASMA_CONDENSER_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.RHENIUM_PLASMA_CONTAINMENT_CELL)
     *          .fluidInputs(Materials.Helium.getFluid(FluidStorageKeys.LIQUID, 16000))
     *          .circuitMeta(1)
     *          .output(GTLiteMetaItems.PLASMA_CONTAINMENT_CELL)
     *          .fluidOutputs(GTLiteMaterials.DegenerateRhenium.getFluid(1000))
     *          .fluidOutputs(Materials.Helium.getFluid(FluidStorageKeys.GAS, 16000))
     *          .EUt(VA[UEV])
     *          .duration(100)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple recipe. please see {@link PlasmaCondenser},
     *     used to add materials and containment cells cooling recipes.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES = new RecipeMap<>("plasma_condenser", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DECAY_GENERATOR_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.QuasifissioningPlasma.getPlasma(1000))
     *          .fluidOutputs(GTLiteMaterials.FleroviumYtterbiumPlasma.getPlasma(1000))
     *          .EUt(VA[ZPM])
     *          .duration(160)
     *          .CasingTier(1)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used {@link GTLiteTraceabilityPredicate#FIELD_CASING} predicate,
     *     just another voltage property (so you can use voltage name, but should above ZPM),
     *     predicate blocks in {@link BlockFieldCasing}.
     *     Same as {@link #COLLIDER_RECIPES}, used {@link FieldCasingTierRecipeBuilder}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> DECAY_GENERATOR_RECIPES = new RecipeMap<>("decay_generator", 1, 1, 1, 1, new FieldCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_HAMMER, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .input(GTLiteOrePrefix.singularity, Materials.Water)
     *          .input(GTLiteOrePrefix.singularity, Materials.Lava)
     *          .input(GTLiteOrePrefix.singularity, Materials.Wood)
     *          .input(GTLiteOrePrefix.singularity, Materials.Stone)
     *          .input(GTLiteOrePrefix.singularity, Materials.Netherrack)
     *          .input(GTLiteOrePrefix.singularity, Materials.Endstone)
     *          .input(GTLiteOrePrefix.singularity, Materials.Emerald)
     *          .input(GTLiteOrePrefix.singularity, Materials.Obsidian)
     *          .input(GTLiteOrePrefix.singularity, Materials.TreatedWood)
     *          .input(GTLiteOrePrefix.singularity, Materials.Gunpowder)
     *          .input(GTLiteOrePrefix.singularity, Materials.Diamond)
     *          .input(GTLiteOrePrefix.singularity, Materials.NetherQuartz)
     *          .input(GTLiteOrePrefix.singularity, Materials.Brick)
     *          .input(GTLiteOrePrefix.singularity, Materials.Coal)
     *          .input(GTLiteOrePrefix.singularity, Materials.Steam)
     *          .input(GTLiteOrePrefix.singularity, Materials.Clay)
     *          .output(GTLiteMetaItems.ANCIENT_SINGULARITY)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     End machine in OpV stage, please see {@link SuprachronalAssemblyLine}.
     *     Used {@link RecipeMapSuprachronalAssemblyLine} for JEI page, just like {@link RecipeMapAssemblyLine},
     *     but not has research property (but this recipe map is also simple recipe builder).
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SUPRACHRONAL_ASSEMBLY_LINE_RECIPES = new RecipeMapSuprachronalAssemblyLine<>("suprachronal_assembly_line", 16, 1, 4, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.REPLICATOR);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_DRILLING_MODULE.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_ZPM.getStackForm(16))
     *          .fluidInputs(Materials.RocketFuel.getFluid(16000))
     *          .fluidOutputs(Materials.Naquadah.getFluid(80000))
     *          .EUt(VH[ZPM])
     *          .duration(20)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_DRILLING_MODULE = new RecipeMap<>("space_elevator_drilling_module", 2, 0, 1, 1, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.DRILL_TOOL);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_MINING_MODULE.recipeBuilder()
     *          .circuitMeta(30)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_OpV.getStackForm(16))
     *          .chancedOutput(OrePrefix.ore, Materials.Naquadah, 4096)
     *          .EUt(VA[UV)
     *          .duration(Materials.Naquadah.getMass() * Materials.NaquadahEnriched.getMass())
     *          .CasingTier(3)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_MINING_MODULE = new RecipeMap<>("space_elevator_mining_module", 4, 9, 2, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_MINING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.MINER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
     *          .input(OrePrefix.frameGt, GTLiteMaterials.BlackPlutonium)
     *          .input(GTLiteMetaItems.COSMIC_INFORMATION_MODULE)
     *          .input(GTLiteMetaItems.CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
     *          .input(GTLiteMetaItems.CLADDED_OPTICAL_FIBER_CORE, 8)
     *          .input(GTLiteMetaItems.BOSE_EINSTEIN_CONDENSATE, 4)
     *          .input(OrePrefix.wireGtSingle, GTLiteMaterials.AstralTitanium, 2)
     *          .fluidInputs(GTLiteMaterials.CosmicComputingMixture.getFluid(1000))
     *          .fluidInputs(GTLiteMaterials.PlatinumGroupAlloy.getFluid(L))
     *          .output(GTLiteMetaItems.HOLOGRAPHIC_INFORMATION_IMC, 2)
     *          .EUt(VA[UIV])
     *          .duration(20)
     *          .CasingTier(5)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three module of space elevator modules, please see {@link SpaceElevator}.
     *     Predicate casing tier by motor casings in {@link BlockActiveMultiblockCasing}.
     *     TODO maybe deprecate or tweak, if redo space elevator in future.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SpaceElevatorCasingTierRecipeBuilder> SPACE_ELEVATOR_ASSEMBLING_MODULE = new RecipeMapSuprachronalAssemblyLine<>("space_elevator_assembling_module", 16, 1, 4, 0, new SpaceElevatorCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ASSEMBLY_LINE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * <p>
     *     Fake recipe map groups for {@link MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#COMPRESSOR_RECIPES}, {@link RecipeMaps#LATHE_RECIPES},
     *     and {@link RecipeMaps#POLARIZER_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_A = new RecipeMapPseudoGroup<>("processing_mode_a", 1, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES, true);

    /**
     * <p>
     *     Fake recipe map groups for {@link MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#FERMENTING_RECIPES}, {@link RecipeMaps#EXTRACTOR_RECIPES},
     *     and {@link RecipeMaps#CANNER_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_B = new RecipeMapPseudoGroup<>("processing_mode_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES, true);

    /**
     * <p>
     *     Fake recipe map groups for {@link MetaTileEntityLargeProcessingFactory}.
     *     This processing mode consist of three common recipes: {@link RecipeMaps#LASER_ENGRAVER_RECIPES}, {@link RecipeMaps#AUTOCLAVE_RECIPES},
     *     and {@link RecipeMaps#FLUID_SOLIDFICATION_RECIPES}, and use different circuit to check it, please see {@link RecipeMapPseudoGroup}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMapPseudoGroup<SimpleRecipeBuilder> PROCESSING_MODE_C  = new RecipeMapPseudoGroup<>("processing_mode_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES, true);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
     *          .input(OrePrefix.ingot, Materials.Tin)
     *          .output(OrePrefix.ingot, Materials.Silver)
     *          .EUt(VA[EV])
     *          .duration(600)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Used to build some fantastic transform, such as iron -> iridium,
     *     please see: {@link MolecularTransformer}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> MOLECULAR_TRANSFORMER_RECIPES = new RecipeMap<>("molecular_transformer", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .fluidOutputs(HeavyLepton.getFluid(40))
     *          .EUt((int) V[UHV])
     *          .duration(1)
     *          .Altitude(80)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     A special check recipe map, please see: {@link MetaTileEntityCosmicRayDetector}.
     *     This recipe map will check altitude of special block in multiblock structure.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<AltitudeRecipeBuilder> COSMIC_RAY_DETECTOR_RECIPES = new RecipeMap<>("cosmic_ray_detector", 4, 4, 2, 2, new AltitudeRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>{@code
     *     GTLiteRecipeMaps.PCB_FACTORY_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .input(plate, Wood)
     *          .input(foil, Lead, 16)
     *          .input(foil, WroughtIron, 16)
     *          .fluidInputs(SulfuricAcid.getFluid(500))
     *          .fluidInputs(Iron3CHloride.getFluid(250))
     *          .output(MetaItems.BASIC_CIRCUIT_BOARD, 8)
     *          .EUt(VA[ULV] * 3 / 4)
     *          .duration(20)
     *          .tier(1)
     *          .isBioUpgrade(1)
     *          .buildAndRegister();
     * }</pre>
     *
     * <p>
     *     This recipe is used for {@link MetaTileEntityPCBFactory}, pay attention, this description is useful for
     *     devs which want add PCB Factory recipes, this Recipe Map is just used for Auto-generated Recipes in {@link PCBFactory},
     *     of cause you can use this as common Recipe Map. But in this description, we will show how add Auto-generated recipes
     *     for a Circuit Board. In {@code gtlitecore}, we add 12 plastic tier ({@link PCBFactory#plasticTier}) by default:
     *
     *     <ul>
     *         <li>1 -> {@link Materials#Polyethylene};</li>
     *         <li>2 -> {@link Materials#PolyvinylChloride};</li>
     *         <li>3 -> {@link Materials#Polytetrafluoroethylene};</li>
     *         <li>4 -> {@link Materials#Epoxy};</li>
     *         <li>5 -> {@link Materials#ReinforcedEpoxyResin};</li>
     *         <li>6 -> {@link Materials#Polybenzimidazole};</li>
     *         <li>7 -> {@link GTLiteMaterials#KaptonK};</li>
     *         <li>8 -> {@link GTLiteMaterials#KaptonE};</li>
     *         <li>9 -> {@link GTLiteMaterials#Polyetheretherketone};</li>
     *         <li>10 -> {@link GTLiteMaterials#Kevlar};</li>
     *         <li>11 -> {@link GTLiteMaterials#Zylon};</li>
     *         <li>12 -> {@link GTLiteMaterials#FullerenePolymerMatrix};</li>
     *     </ul>
     *
     *     Though we can define more {@code plasticTier}, the {@code maxOutputs} slot limit of this Recipe Map is too small
     *     than some advanced recipes. So we just add 12 {@code plasticTier}. In {@code gtlitecore}, we have following Circuit
     *     Boards (consists of vanilla GregTech Circuit Boards):
     *
     *     <ul>
     *         <li>1 -> Plastic Circuit Board -> Processor Circuit;</li>
     *         <li>2 -> Advanced Circuit Board -> Nano Circuit;</li>
     *         <li>3 -> Extreme Circuit Board -> Quantum Circuit;</li>
     *         <li>4 -> Elite Circuit Board -> Crystal Circuit;</li>
     *         <li>5 -> Wetware Circuit Board -> Wetware Circuits;</li>
     *         <li>6 -> Super Circuit Board -> Gooware Circuits;</li>
     *         <li>7 -> Ultimate Circuit Board -> Optical Circuits;</li>
     *         <li>8 -> Infinite Circuit Board -> All Circuits beyond Optical Circuit;</li>
     *     </ul>
     *
     *     Imaginatively, for default {@code plasticTier}, you can add 4 new circuit type exactly (when add fifth, will cause
     *     problem because it is higher than maximum {@code plasticTier}). Here is a example of Auto-generated recipes:
     *
     *     <pre>{@code
     *         for (int tier = 1; tier <= plasticTier; tier++) {
     *             int boardAmount = (int) Math.ceil(8 * Math.sqrt(Math.pow(2, tier - 1)));
     *             List<ItemStack> boards = new ArrayList<>();
     *             for (int i = boardAmount; i > 64; i -= 64) {
     *                 boards.add(PLASTIC_CIRCUIT_BOARD.getStackForm(64));
     *                 boardAmount -= 64;
     *             }
     *             boards.add(PLASTIC_CIRCUIT_BOARD.getStackForm(boardAmount));
     *             PCB_FACTORY_RECIPES.recipeBuilder()
     *                     .circuitMeta(1)
     *                     .input(plate, plasticTiers.inverse().get(tier))
     *                     .input(foil, AnnealedCopper, (int) (16 * (Math.sqrt(tier))))
     *                     .input(foil, Copper, (int) (16 * Math.sqrt(tier)))
     *                     .fluidInputs(SulfuricAcid.getFluid((int) (500 * Math.sqrt(tier))))
     *                     .fluidInputs(Iron3Chloride.getFluid((int) (250 * Math.sqrt(tier))))
     *                     .outputs(boards.toArray(new ItemStack[0]))
     *                     .EUt(VA[tier] * 3 / 4)
     *                     .duration((int) Math.ceil(600 / Math.sqrt(Math.pow(1.5, tier - 1.5))))
     *                     .tier(1)
     *                     .buildAndRegister();
     *         }
     *     }</pre>
     *
     *     In this example, we use a {@code HashBiSet} to storage plastic tier infos (which called by {@code plasticTiers}),
     *     and the first part is a simple stack spliting step (used to make Recipe Map list more clean, effect of this step
     *     is split total number of stacks to each stack), and the second part is Recipe Builder, we use fixed datas about:
     *
     *     <ul>
     *         <li>{@code circuitMeta}: Used 1, 2 and 3 to preserve different of 3 {@code tier} recipes;</li>
     *         <li>{@code input}: Used 2 different Material Foil, and amount is always {@code 16 * sqrt(tier)};</li>
     *         <li>{@code fluidInputs}: Used Etching Liquid, {@link Materials#SulfuricAcid} is fixed usage,
     *                                  others required related recipes.</li>
     *         <li>{@code EUt}: Used {@code VA[tier] * 3 / 4} in T1 recipe, and use {@code VA[tier + 1] * 3 / 4}
     *                          in T2 and T3 recipes.</li>
     *         <li>{@code duration}: Used {@code ceil(600 / sqrt(pow(1.5, tier - 1.5)))} for T1 recipe,
     *                               used {@code ceil(500 / sqrt(pow(1.5, tier - 1.5)))} for T2 recipe,
     *                               used {@code ceil(400 / sqrt(pow(1.5, tier - 1.5)))} for T3 recipe;</li>
     *         <li>{@code tier}: Used to check {@code mainUpgradeNumber} in {@link MetaTileEntityPCBFactory}
     *                           used 1, 2 and 3 to check it Main Structure Tier (T1, T2, T3), T1 is just the
     *                           Basic Structure of Multiblock.</li>
     *         <li>{@code isBioUpgrade}: Used to check {@code bioUpgradeNumber} in {@link MetaTileEntityPCBFactory},
     *                                   1 means {@code true} (consider for the future contents, use {@code Integer}
     *                                   maybe more safe for update).</li>
     *     </ul>
     *
     *     If you want to add new Upgrade, then you should add it structure for {@link MetaTileEntityPCBFactory},
     *     an auxiliary structure in Multiblock Structure should have a {@code context} which wrote in {@code formStructure()},
     *     and has related Structure in {@link FactoryBlockPattern} part and Structure View part ({@link MultiblockShapeInfo}).
     *     Then, you should add a new Recipe Property (and init it in {@link CommonProxy}), and compare it in Main Recipe Builder,
     *     i.e. {@link PCBFactoryRecipeBuilder#applyProperty(String, Object)}.
     * </p>
     *
     * @see MetaTileEntityPCBFactory
     * @see PCBFactoryRecipeBuilder
     * @see PCBFactoryProperty
     * @see PCBFactoryBioUpgradeProperty
     * @see PCBFactory
     *
     * @since 2.8.8-beta
     */
    @ZenProperty
    public static final RecipeMap<PCBFactoryRecipeBuilder> PCB_FACTORY_RECIPES = new RecipeMap<>("pcb_factory", 6, 9, 3, 0, new PCBFactoryRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE.recipeBuilder()
     *          .input(lens, Glass)
     *          .input(CARBON_FIBERS, 8)
     *          .fluidInputs(Materials.Helium.getFluid(L * 8)})
     *          .fluidInputs(Materials.Iron3Chloride.getFluid(4000))
     *          .fluidInputs(Materials.Lubricant.getFluid(250))
     *          .output(nanosensor, Carbon)
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three modes of Neutral Network Nexus, used to create Nanosensor and Nanotube.
     * </p>
     *
     * @see MetaTileEntityNeutralNetworkNexus
     * @see SwarmTierRecipeBuilder
     * @see SwarmTierProperty
     * @see NeutralNetworkNexus
     *
     * @since 2.8.7-beta
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NEUTRAL_NETWORK_NEXUS_ASSEMBLING_MODE = new RecipeMap<>("neutral_network_nexus_assembling_mode", 6, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.IN_SLOT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.IN_SLOT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.OUT_SLOT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
     *          .circuitMeta(1)
     *          .input(GTLiteOrePrefix.nanotube, Materials.Carbon)
     *          .input(GTLiteOrePrefix.nanosensor, Materials.Carbon)
     *          .input(MetaItems.SIMPLE_SYSTEM_ON_CHIP, 8)
     *          .input(OrePrefix.dust, Materials.Carbon, 4)
     *          .fluidInputs(PCBCoolant.getFluid(L))
     *          .output(GTLiteOrePrefix.swarm, Materials.Carbon)
     *          .EUt(VA[LV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of three modes of Neutral Network Nexus, used to breeding nano swarm.
     * </p>
     *
     * @see MetaTileEntityNeutralNetworkNexus
     * @see SwarmTierRecipeBuilder
     * @see SwarmTierProperty
     * @see NeutralNetworkNexus
     *
     * @since 2.8.7-beta
     */
    @ZenProperty
    public static final RecipeMap<SwarmTierRecipeBuilder> NEUTRAL_NETWORK_NEXUS_BREEDING_MODE = new RecipeMap<>("neutral_network_nexus_breeding_mode", 6, 1, 3, 0, new SwarmTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GuiTextures.EXTRACTOR_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE.recipeBuilder()
     *          .circuitMeta(1)
     *          .input(GTLiteOrePrefix.swarm, Materials.Copper)
     *          .input(GTLiteOrePrefix.swarm, Materials.Redstone)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.Copper, 8000, 0)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.Redstone, 8000, 0)
     *          .chancedOutput(GTLiteOrePrefix.swarm, Materials.RedAlloy, 2000, 500)
     *          .EUt(VA[IV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     One of two modes of Neutral Network Nexus, used to hybridizing nano swarm.
     * </p>
     *
     * @see MetaTileEntityNeutralNetworkNexus
     * @see SwarmTierRecipeBuilder
     * @see SwarmTierProperty
     * @see NeutralNetworkNexus
     *
     * @since 2.8.7-beta
     */
    @ZenProperty
    public static final RecipeMap<SwarmTierRecipeBuilder> NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE = new RecipeMap<>("neutral_network_nexus_hybridizing_mode", 6, 6, 3, 3, new SwarmTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.QUANTUM_FORCE_TRANSFORMER_RECIPES.recipeBuilder()
     *          .circuitMeta(11)
     *          .notConsumable(GTLiteOrePrefix.swarm, GTLiteMaterials.Fullerene)
     *          .input(OrePrefix.dust, Materials.Carbon, 64)
     *          .fluidInputs(Materials.Chlorine.getFluid(16000))
     *          .fluidInputs(Materials.Hydrogen.getFluid(16000))
     *          .fluidInputs(Materials.Oxygen.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.NitrileButadieneRubber.getFluid(9216))
     *          .fluidOutputs(GTLiteMaterials.PolyPhosphonitrileFluoroRubber.getFluid(9216))
     *          .fluidOutputs(GTLiteMaterials.Polyetheretherketone.getFluid(18432))
     *          .fluidOutputs(Materials.Rubber.getFluid(36864))
     *          .EUt(VA[UV])
     *          .duration(400)
     *          .CasingTier(2)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map's predicate like {@link #COLLIDER_RECIPES}.
     *     If you want to add new recipes, please use swarm ({@link GTLiteOrePrefix#swarm})
     *     as catalyst, and add a advanced version of your recipe (use different swarm as catalyst),
     *     and add a special circuit to resolve conflicts.
     * </p>
     *
     * @see MetaTileEntityQuantumForceTransformer
     * @see FieldCasingTierRecipeBuilder
     * @see FieldCasingTierProperty
     * @see QuantumForceTransformer
     *
     * @since 2.7.4-beta
     *
     */
    @ZenProperty
    public static final RecipeMap<FieldCasingTierRecipeBuilder> QUANTUM_FORCE_TRANSFORMER_RECIPES = new RecipeMap<>("quantum_force_transformer", 6, 6, 6, 6, new FieldCasingTierRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.TURBINE_MIXER_RECIPES.recipeBuilder()
     *          .circuitMeta(8)
     *          .input(OrePrefix.dust, Materials.Gadolinium)
     *          .input(OrePrefix.dust, Materials.Terbium)
     *          .input(OrePrefix.dust, Materials.Dysprosium)
     *          .input(OrePrefix.dust, Materials.Holmium)
     *          .input(OrePrefix.dust, Materials.Erbium)
     *          .input(OrePrefix.dust, Materials.Thulium)
     *          .input(OrePrefix.dust, Materials.Ytterbium)
     *          .input(OrePrefix.dust, Materials.Lutetium)
     *          .output(OrePrefix.dust, GTLiteMaterials.LanthanumGroupHAlloy, 8)
     *          .EUt(VA[UEV])
     *          .duration(180)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Extended version of {@link RecipeMaps#MIXER_RECIPES}, has 9 input slots and 6 fluid input slots,
     *     usually add special component material recipe in this recipe map (such as {@link GTLiteMaterials#Periodicium}).
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of mixer recipes,
     *          or create recipes of {@link gregicality.multiblocks.api.recipes.GCYMRecipeMaps#ALLOY_BLAST_RECIPES} via recipe handler.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> TURBINE_MIXER_RECIPES = new RecipeMapTurbineMixer<>("turbine_mixer", 9, 1, 6, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSound(GTSoundEvents.MIXER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.HEAT_EXCHANGE_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.DistilledWater.getFluid(5))
     *          .fluidInputs(Materials.Helium.getPlasma(1))
     *          .fluidOutputs(GTLiteMaterials.SuperheatedSteam.getFluid(160 * 5))
     *          .fluidOutputs(GTLiteMaterials.SupercriticalSteam.getFluid(80 * 5))
     *          .fluidOutputs(Materials.Helium.getFluid(1))
     *          .maxRate(1600)
     *          .flowRate(500)
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see: {@link FlowRateRecipeBuilder}, this recipe map has two special property.
     *     Pay attention, the correspond machine also has some special check.
     *     Textures of JEI page from Prim's mod <a href="https://github.com/GTNewHorizons/GoodGenerator">Good Generator</a>.
     * </p>
     *
     * @see MetaTileEntityHeatExchanger
     * @see MetaTileEntityExtremeHeatExchanger
     * @see MetaTileEntityMegaHeatExchanger
     * @see HeatExchangerRecipeLogic
     * @see FlowRateRecipeBuilder
     * @see FlowRateProperty
     * @see MaxRateProperty
     * @see HeatExchanger
     *
     * @since 2.7.4-beta
     */
    @ZenProperty
    public static final RecipeMap<FlowRateRecipeBuilder> HEAT_EXCHANGE_RECIPES = new RecipeMapHeatExchanger<>("heat_exchanger", 0, 0, 2, 3, new FlowRateRecipeBuilder(), false)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_HEAT_EXCHANGE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.HIGH_PRESSURE_STEAM_TURBINE_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.SuperheatedSteam.getFluid(320))
     *          .fluidOutputs(Materials.DistilledWater.getFluid(64))
     *          .EUt((int) V[MV])
     *          .duration(10)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fuel Recipe map like {@link RecipeMaps#GAS_TURBINE_FUELS},
     *     used for {@link GTLiteMetaTileEntities#HIGH_PRESSURE_STEAM_TURBINE},
     *     and its mega version {@link GTLiteMetaTileEntities#MEGA_HIGH_PRESSURE_STEAM_TURBINE}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> HIGH_PRESSURE_STEAM_TURBINE_RECIPES = new RecipeMap<>("high_pressure_steam_turbine", 0, 0, 1, 1, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, true, true, GuiTextures.DARK_CANISTER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.TURBINE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.SUPERCRITICAL_STEAM_TURBINE_RECIPES.recipeBuilder()
     *          .fluidInputs(GTLiteMaterials.SupercriticalSteam.getFluid(640))
     *          .fluidOutputs(Materials.DistilledWater.getFluid(128))
     *          .EUt((int) V[EV])
     *          .duration(10)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fuel Recipe map like {@link RecipeMaps#GAS_TURBINE_FUELS},
     *     used for {@link GTLiteMetaTileEntities#SUPERCRITICAL_STEAM_TURBINE},
     *     and its mega version {@link GTLiteMetaTileEntities#MEGA_SUPERCRITICAL_STEAM_TURBINE}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> SUPERCRITICAL_STEAM_TURBINE_RECIPES = new RecipeMap<>("supercritical_steam_turbine", 0, 0, 1, 1, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, true, true, GuiTextures.DARK_CANISTER_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.TURBINE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.BIOWARE_SIMULATOR.recipeBuilder()
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_EV.getStackForm(35))
     *          .fluidInputs(Materials.Biomass.getFluid(80000))
     *          .output(OrePrefix.dust, Materials.Naquadah, 64)
     *          .EUt(VHA[UV])
     *          .duration(2000)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Unused now, maybe just a advanced version of {@link #SIMULATOR_RECIPES}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> BIOWARE_SIMULATOR_RECIPES = new RecipeMap<>("bioware_simulator", 2, 2, 2, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.DATA_ORB_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.FILTER_SLOT_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
     *          .notConsumable(OrePrefix.lens, GTLiteMaterials.MagnetoResonatic)
     *          .notConsumable(OrePrefix.lens, GTLiteMaterials.NdYAG)
     *          .notConsumable(OrePrefix.lens, Materials.NetherStar)
     *          .input(MetaItems.NEUTRONIUM_WAFER)
     *          .output(GTLiteMetaItems.UHASOC_WAFER, 32)
     *          .EUt(VA[LuV])
     *          .duration(50)
     *          .cleanroom(CleanroomType.CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Advanced version of {@link RecipeMaps#LASER_ENGRAVER_RECIPES}.
     *     TODO use {@link RecipeMap#onRecipeBuild(Consumer)} to tweak this recipe map be advanced version of laser engraver recipes.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> NANO_SCALE_MASK_ALIGNER_RECIPES = new RecipeMap<>("nano_scale_mask_aligner", 4, 2, 2, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.LENS_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.ALGAE_CULTURE_TANK_RECIPES.recipeBuilder()
     *          .input(GTLiteMetaItems.BARNARDA_C_ZOOXANTHELLAE, 2)
     *          .circuitMeta(1)
     *          .fluidInputs(Materials.Mutagen.getFluid(2))
     *          .output(GTLiteMetaItems.BARNARDA_C_ZOOXANTHELLAE, 16)
     *          .EUt(VA[UV])
     *          .duration(200)
     *          .temperature(109)
     *          .cleanroom(CleanroomType.STERILE_CLEANROOM)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Just a easy recipe for {@link MetaTileEntityAlgaeCultureTank}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ALGAE_CULTURE_TANK_RECIPES = new RecipeMap<>("algae_culture_tank", 6, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GTLiteGuiTextures.DISH_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.BIOMASS_GENERATOR_RECIPES.recipeBuilder()
     *          .fluidInputs(Materials.FermentedBiomass.getFluid(200))
     *          .EUt((int) V[EV])
     *          .duration(20)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Simple fuel recipe map for {@link GTLiteMetaTileEntities#BIOMASS_GENERATOR}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> BIOMASS_GENERATOR_RECIPES = new RecipeMap<>("biomass_generator", 0, 0, 1, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH)
            .allowEmptyOutput();

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.LARGE_GAS_COLLECTOR_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(MetaItems.ELECTRIC_PUMP_LV)
     *          .fluidOutputs(Materials.Air.getFluid(40000))
     *          .EUt(VA[HV])
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Advanced version of {@link RecipeMaps#GAS_COLLECTOR_RECIPES},
     *     please see: {@link LargeGasCollector}.
     *     Use different circuits and electric pumps to resolve conflicts.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> LARGE_GAS_COLLECTOR_RECIPES = new RecipeMap<>("large_gas_collector", 2, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.VIRTUAL_COSMOS_SIMULATOR_RECIPES.recipeBuilder()
     *          .notConsumable(COSMIC_MEMORY_CARD_OVERWORLD)
     *          .output(dust, Stone, 240891153)
     *          .EUt(VA[UXV])
     *          .duration(1200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Special JEI page {@link RecipeMapVirtualCosmosSimulator},
     *     like Eye of Harmony in <a href="https://github.com/GTNewHorizons/TecTech">TecTech</a>.
     *     This recipe map has 81 output slots and 18 fluid output slots.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> VIRTUAL_COSMOS_SIMULATOR_RECIPES = new RecipeMapVirtualCosmosSimulator<>("virtual_cosmos_simulator", 1, 81, 0, 18, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
     *          .notConsumable(MetaItems.QUANTUM_PROCESSOR_EV)
     *          .input(GTLiteMetaItems.WRAP_EXTREME_CIRCUIT_BOARD, 2)
     *          .input(MetaItems.QUBIT_CENTRAL_PROCESSING_UNIT_WAFER, 8)
     *          .input(MetaItems.NANO_CENTRAL_PROCESSING_UNIT_WAFER, 4)
     *          .input(GTLiteMetaItems.WRAP_ADVANCED_SMD_CAPACITOR, 6)
     *          .input(GTLiteMetaItems.WRAP_ADVANCED_SMD_TRANSISTOR, 6)
     *          .input(OrePrefix.wireGtHex, Materials.Platinum, 12)
     *          .fluidInputs(Materials.SolderingAlloy.getFluid(72 * 64))
     *          .output(MetaItems.QUANTUM_PROCESSOR_EV, 64)
     *          .EUt(VA[EV])
     *          .duration(800)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Recipe Map for {@link MetaTileEntityLargeCircuitAssemblyLine}.
     *     In this recipe map, please put not consumable item on the last slot in item input slots.
     *     Because Large Circuit Assembly Line use special ui ({@link RecipeMapLargeCircuitAssemblyLine}),
     *     you should make it on special slot on left hand.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES = new RecipeMapLargeCircuitAssemblyLine<>("large_circuit_assembly_line", 7, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.DATA_ORB_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.DYSON_SWARM_RECIPES.recipeBuilder()
     *          .circuitMeta(2)
     *          .input(GTLiteMetaItems.DYSON_SWARM_MODULE, 4)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .chancedOutput(GTLiteMetaItems.DYSON_SWARM_MODULE, 5000, 0)
     *          .EUt(40000000)
     *          .duration(200)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Fake fuel recipe map of {@link magicbook.gtlitecore.common.metatileentities.multi.electric.generator.MetaTileEntityDysonSwarm},
     *     TODO maybe deprecate or tweak, if redo dyson swarm in future.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<FuelRecipeBuilder> DYSON_SWARM_RECIPES = new RecipeMap<>("dyson_swarm", 2, 8, 0, 0, new FuelRecipeBuilder(), true)
            .allowEmptyOutput()
            .setSound(GTSoundEvents.COOLING);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.PLANETARY_GAS_SIPHON_RECIPES.recipeBuilder()
     *          .circuitMeta(1)
     *          .notConsumable(GTLiteMetaItems.MINING_DRONE_OpV.getStackForm(64))
     *          .input(OrePrefix.pipeNormalFluid, GTLiteMaterials.CrystalMatrix, 16)
     *          .input(OrePrefix.toolHeadDrill, GTLiteMaterials.Hypogen, 8)
     *          .fluidInputs(Materials.RocketFuel.getFluid(16000))
     *          .fluidOutputs(GTLiteMaterials.Spacetime.getFluid(160000))
     *          .EUt((int) V[MAX])
     *          .duration(2000)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     Please see: {@link magicbook.gtlitecore.loaders.multiblock.PlanetaryGasSiphon},
     *     may be just a easy version of {@link #SPACE_ELEVATOR_DRILLING_MODULE}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLANETARY_GAS_SIPHON_RECIPES = new RecipeMap<>("planetary_gas_siphon", 4, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_SPACE_ELEVATOR_DRILLING_MODULE, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.MINER);

    /**
     * Example:
     *
     * <pre>
     *     GTLiteRecipeMaps.NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
     *          .input(OrePrefix.dust, GTLiteMaterials.MagnetoHydrodynamicallyConstrainedStarMatter)
     *          .input(GTLiteOrePrefix.swarm, GTLiteMaterials.Eternity, 2)
     *          .input(GTLiteMetaItems.MANIFOLD_OSCILLATORY_POWER_CELL, 4)
     *          .fluidInputs(GTLiteMaterials.Magmatter.getFluid(L))
     *          .output(OrePrefix.dust, GTLiteMaterials.Magmatter)
     *          .EUt(VA[MAX])
     *          .duration(20)
     *          .CasingTier(3)
     *          .buildAndRegister();
     * </pre>
     *
     * <p>
     *     This recipe map used special recipe property {@link GravitonCasingTierRecipeBuilder},
     *     and predicate tier by blocks in {@link magicbook.gtlitecore.common.blocks.BlockGravitonCasing}.
     * </p>
     */
    @ZenProperty
    public static final RecipeMap<GravitonCasingTierRecipeBuilder> NICOLL_DYSON_BEAMER_FORGING_MODULE = new RecipeMap<>("nicoll_dyson_beamer_forging_module", 3, 2, 1, 0, new GravitonCasingTierRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_FOCUSING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ETERNITY_GARDEN_RECIPES = new RecipeMapEternityGarden<>("eternity_garden", 7, 7, 7, 7, new SimpleRecipeBuilder(), false)
            .setSound(SoundEvents.BLOCK_CHORUS_FLOWER_GROW);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> AUTO_CHISEL_RECIPES = new RecipeMap<>("auto_chisel", 2, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.BOXED_BACKGROUND)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_CHISEL, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FILE_TOOL);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_TRANSMUTATION_RECIPES = new RecipeMap<>("dimensionally_transcendent_neutronium_forge_transmutation_mode", 1, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.INT_CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_FUSION_RECIPES = new RecipeMapDTNFFusionMode<>("dimensionally_transcendent_neutronium_forge_fusion_mode", 1, 0, 20, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.INT_CIRCUIT_OVERLAY)
            .setProgressBar(GTLiteGuiTextures.PROGRESS_BAR_REACTION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MIXER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_COLLISION_RECIPES = new RecipeMapNDBBurningModule<>("dimensionally_transcendent_neutronium_forge_collision_mode", 9, 9, 9, 9, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, false, false, GuiTextures.CRACKING_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.CRACKING_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.VIAL_OVERLAY_2)
            .setSlotOverlay(false, true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSlotOverlay(true, true, false, GuiTextures.LIGHTNING_OVERLAY_2)
            .setSlotOverlay(true, true, true, GuiTextures.LIGHTNING_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ELECTRIC_IMPLOSION_RECIPES = new RecipeMap<>("electric_implosion_compressor", 3, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE)
            .onRecipeBuild((recipeBuilder) -> DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                    .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                    .fluidInputs(recipeBuilder.getFluidInputs())
                    .outputs(recipeBuilder.getOutputs())
                    .chancedOutputs(recipeBuilder.getChancedOutputs())
                    .fluidOutputs(recipeBuilder.getFluidOutputs())
                    .chancedFluidOutputs(recipeBuilder.getChancedFluidOutputs())
                    .EUt(recipeBuilder.getEUt())
                    .duration(recipeBuilder.getDuration())
                    .hidden() // Hidden same recipes in Dimensional Oscillator.
                    .buildAndRegister());

    @ZenProperty
    public static final RecipeMap<LargeChemicalComplexRecipeBuilder> LARGE_CHEMICAL_COMPLEX_RECIPES = new RecipeMapLargeChemicalComplex<>("large_chemical_complex", 8, 8, 8, 8, new LargeChemicalComplexRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSlotOverlay(false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static void init() {
        CUTTER_RECIPES.setMaxOutputs(4);
        ELECTROLYZER_RECIPES.setMaxFluidInputs(2);
        ELECTROLYZER_RECIPES.setSlotOverlay(false, true, false, GuiTextures.LIGHTNING_OVERLAY_2);
        LASER_ENGRAVER_RECIPES.setMaxOutputs(2);
        MASS_FABRICATOR_RECIPES.setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY);
        REPLICATOR_RECIPES.setMaxFluidInputs(3);
        REPLICATOR_RECIPES.setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY);
        REPLICATOR_RECIPES.setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY);
    }
}