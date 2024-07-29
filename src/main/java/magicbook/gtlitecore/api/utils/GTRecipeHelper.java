package magicbook.gtlitecore.api.utils;

import gregtech.api.block.VariantBlock;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.ingredients.GTRecipeItemInput;
import gregtech.api.recipes.ingredients.GTRecipeOreInput;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.ConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.Glue;
import static gregtech.api.unification.material.Materials.Polybenzimidazole;
import static gregtech.api.unification.material.Materials.Polyethylene;
import static gregtech.api.unification.material.Materials.Polytetrafluoroethylene;
import static gregtech.api.unification.ore.OrePrefix.frameGt;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.plateDouble;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.CosmicFabric;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Kevlar;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Polyetheretherketone;

/**
 * Recipe Helper for GregTech.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is an Utility class for GregTech recipes,
 *     add many special recipe adder for {@code gtlitecore}.
 * </p>
 *
 * @since 2.8.10-beta
 */
public class GTRecipeHelper {

    /**
     * Create common Metal Casing recipe.
     *
     * <p>
     *     This method will add two recipe of each Metal Casing,
     *     one is crafting table recipe by Hammer (hard) and Wrench,
     *     another is assembler recipe.
     * </p>
     *
     * @param regName           Register Name of recipe.
     * @param outputCasingType  Variant Block class of {@code MetaBlock}.
     * @param outputCasing      Casing type of {@code MetaBlock}.
     * @param material          Basic {@code material} of Metal Casing,
     *                          means plate and frame material.
     */
    public static <T extends Enum<T> & IStringSerializable> void createCasingRecipe(String regName,
                                                                                     VariantBlock<T> outputCasingType,
                                                                                     T outputCasing,
                                                                                     Material material) {
        ModHandler.addShapedRecipe(true, regName, outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, material),
                'F', new UnificationEntry(frameGt, material));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, material, 6)
                .input(frameGt, material)
                .circuitMeta(6)
                .outputs(outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();
    }

    /**
     * Create Metal Casing recipe with different plate-frame material.
     *
     * <p>
     *     This method will add two recipe of each Metal Casing,
     *     one is crafting table recipe by Hammer (hard) and Wrench,
     *     another is assembler recipe.
     * </p>
     *
     * @param regName           Register Name of recipe.
     * @param outputCasingType  Variant Block class of {@code MetaBlock}.
     * @param outputCasing      Casing type of {@code MetaBlock}.
     * @param plateMaterial     Plate {@code material} of Metal Casing.
     * @param frameMaterial     Frame {@code material} of Metal Casing.
     */
    public static <T extends Enum<T> & IStringSerializable> void createCasingRecipe(String regName,
                                                                                     VariantBlock<T> outputCasingType,
                                                                                     T outputCasing,
                                                                                     Material plateMaterial,
                                                                                     Material frameMaterial) {
        ModHandler.addShapedRecipe(true, regName, outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, plateMaterial),
                'F', new UnificationEntry(frameGt, frameMaterial));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, plateMaterial, 6)
                .input(frameGt, frameMaterial)
                .circuitMeta(6)
                .outputs(outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();
    }

    /**
     * Create Metal Casing recipe with different plate-frame material and new double plate material.
     *
     * <p>
     *     This method will add two recipe of each Metal Casing,
     *     one is crafting table recipe by Hammer (hard) and Wrench,
     *     another is assembler recipe.
     * </p>
     *
     * @param regName              Register Name of recipe.
     * @param outputCasingType     Variant Block class of {@code MetaBlock}.
     * @param outputCasing         Casing type of {@code MetaBlock}.
     * @param plateDoubleMaterial  Double Plate {@code material} of Metal Casing.
     * @param plateMaterial        Plate {@code material} of Metal Casing.
     * @param frameMaterial        Frame {@code material} of Metal Casing.
     */
    public static <T extends Enum<T> & IStringSerializable> void createCasingRecipe(String regName,
                                                                                     VariantBlock<T> outputCasingType,
                                                                                     T outputCasing,
                                                                                     Material plateDoubleMaterial,
                                                                                     Material plateMaterial,
                                                                                     Material frameMaterial) {
        ModHandler.addShapedRecipe(true, regName, outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, plateDoubleMaterial),
                'T', new UnificationEntry(plate, plateMaterial),
                'F', new UnificationEntry(frameGt, frameMaterial));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, plateDoubleMaterial, 4)
                .input(plate, plateMaterial, 2)
                .input(frameGt, frameMaterial)
                .circuitMeta(6)
                .outputs(outputCasingType.getItemVariant(outputCasing, ConfigHolder.recipes.casingsPerCraft))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();
    }

    /**
     * Create I/O Part Recipes from {@code tier} and {@code extraInput}.
     *
     * <p>
     *     This method is used for I/O part recipe registry, it's different with the original method
     *     in vanilla GregTech, because in {@code gtlitecore}, we used {@code HT}, so this method is
     *     for total tier voltages (used {@code gtlitecore} materials for High Tier contents).
     * </p>
     *
     * @param tier        Bus/Hatch tier, used {@code tier} of voltages.
     * @param input       Input Bus/Hatch.
     * @param output      Output Bus/Hatch.
     * @param extraInput  Extra Input in recipes, check via {@link #getGtRecipeInput(Object)}.
     */
    public static void createIOPartRecipe(int tier, MetaTileEntity input, MetaTileEntity output, Object extraInput) {
        GTRecipeInput extra = getGtRecipeInput(extraInput);
        //  Glue recipe for ULV and LV.
        if (tier <= LV) {
            int fluidAmount = tier == ULV ? 250 : 500;
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Glue.getFluid(fluidAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Glue.getFluid(fluidAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();
        }

        //  PE recipe for HV and below.
        if (tier <= HV) {
            int peAmount = getFluidAmount(tier + 4);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polyethylene.getFluid(peAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polyethylene.getFluid(peAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();
        }

        //  PTFE recipe for LuV and below.
        if (tier <= LuV) {
            int ptfeAmount = getFluidAmount(tier + 3);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polytetrafluoroethylene.getFluid(ptfeAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polytetrafluoroethylene.getFluid(ptfeAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    .buildAndRegister();
        }

        //  PBI recipe for UV and below.
        if (tier <= UV) {
            int pbiAmount = getFluidAmount(tier);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polybenzimidazole.getFluid(pbiAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polybenzimidazole.getFluid(pbiAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();
        }

        //  PEEK recipe for UEV and below.
        if (tier <= UEV) {
            int peekAmount = getFluidAmount(tier - 1);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polyetheretherketone.getFluid(peekAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Polyetheretherketone.getFluid(peekAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();
        }

        //  Kevlar recipe for UXV and below
        if (tier <= UXV) {
            int kevlarAmount = getFluidAmount(tier - 2);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Kevlar.getFluid(kevlarAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(Kevlar.getFluid(kevlarAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();

        }

        //  Cosmic Fabric recipe for MAX and below
        if (tier <= MAX) {
            int cosmicFabricAmount = getFluidAmount(tier - 4);
            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(CosmicFabric.getFluid(cosmicFabricAmount))
                    .output(input)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(HULL[tier])
                    .inputs(extra)
                    .fluidInputs(CosmicFabric.getFluid(cosmicFabricAmount))
                    .output(output)
                    .EUt(VA[tier])
                    .duration(15 * SECOND)
                    // .withRecycling()
                    .buildAndRegister();
        }

    }

    /**
     * Add Convension Recipes of I/O Buses/Hatches.
     *
     * @param tier     Bus/Hatch tier, used {@code tier} of voltages.
     * @param input    Input Bus/Hatch.
     * @param output   Output Bus/Hatch.
     * @param isFluid  Check if Buses/Hatches is Fluid Buses.
     */
    public static void createIOPartConv(int tier, MetaTileEntity input, MetaTileEntity output, boolean isFluid) {
        if (isFluid) {
            ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_" + tier, input.getStackForm(),
                    " d ", " H ", "   ",
                    'H', output.getStackForm());
            ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_" + tier, output.getStackForm(),
                    " d ", " H ", "   ",
                    'H', input.getStackForm());
        } else {
            ModHandler.addShapedRecipe(true, "item_hatch_input_to_output_" + tier, input.getStackForm(),
                    " d ", " H ", "   ",
                    'H', output.getStackForm());
            ModHandler.addShapedRecipe(true, "item_hatch_output_to_input_" + tier, output.getStackForm(),
                    " d ", " H ", "   ",
                    'H', input.getStackForm());
        }
    }

    /**
     * Add Convension Recipes of I/O Buses/Hatches.
     *
     * @param tier     Bus/Hatch tier, used {@code tier} of voltages.
     * @param type     Type of Bus/Hatch, means 4x or 9x (only be useful for multi fluid hatches).
     * @param input    Input Bus/Hatch.
     * @param output   Output Bus/Hatch.
     * @param isFluid  Check if Buses/Hatches is Fluid Buses.
     */
    public static void createIOPartConv(int tier, int type, MetaTileEntity input, MetaTileEntity output, boolean isFluid) {
        if (isFluid) {
            ModHandler.addShapedRecipe(true,
                    type == 4 ? "quadruple_fluid_hatch_input_to_output_" + tier
                            : (type == 9 ? "nonuple_fluid_hatch_input_to_output_" + tier : "fluid_hatch_input_to_output_" + tier), input.getStackForm(),
                    " d ", " H ", "   ",
                    'H', output.getStackForm());
            ModHandler.addShapedRecipe(true,
                    type == 4 ? "quadruple_fluid_hatch_input_to_output_" + tier
                            : (type == 9 ? "nonuple_fluid_hatch_input_to_output_" + tier : "fluid_hatch_output_to_input_" + tier), output.getStackForm(),
                    " d ", " H ", "   ",
                    'H', input.getStackForm());
        } else {
            ModHandler.addShapedRecipe(true, "item_hatch_input_to_output_" + tier, input.getStackForm(),
                    " d ", " H ", "   ",
                    'H', output.getStackForm());
            ModHandler.addShapedRecipe(true, "item_hatch_output_to_input_" + tier, output.getStackForm(),
                    " d ", " H ", "   ",
                    'H', input.getStackForm());
        }
    }

    /**
     * Check Object type in {@code GTRecipeInput}.
     *
     * @param extraInput  Object.
     * @return            If {@code extraInput} is Item stack or Ore Dictionary Name, then create a {@code GTRecipeInput}.
     */
    @NotNull
    private static GTRecipeInput getGtRecipeInput(Object extraInput) {
        GTRecipeInput extra; //  Used to check {@code extraInput} type.
        if (extraInput instanceof ItemStack stack) { //  If {@code extraInput} is Item Stack, then create a {@code GTRecipeItemInput}.
            extra = new GTRecipeItemInput(stack);
        } else if (extraInput instanceof String oreDict) { //  If {@code extraInput} is Ore Dictionary Name, then create a {@code GTRecipeOreInput}.
            extra = new GTRecipeOreInput(oreDict);
        } else {
            throw new IllegalArgumentException("extraInput must be ItemStack or GTRecipeInput.");
        }
        return extra;
    }

    /**
     * Get Fluid Amount from {@code offsetTier}.
     *
     * @param offsetTier  Voltage tier.
     * @return            Custom Fluid Amount for Hatch/Bus Assembler recipe input.
     */
    private static int getFluidAmount(int offsetTier) {
        return switch (offsetTier) {
            case ULV -> 4;
            case LV  -> L / 16; // 9
            case MV  -> L / 8;  // 18
            case HV  -> L / 4;  // 36
            case EV  -> L / 2;  // 72
            case IV  -> L;      // 144
            case LuV -> L * 2;  // 288
            case ZPM -> L * 3;  // 432
            case UV  -> L * 4;  // 576
            case UHV -> L * 5;  // 720
            case UEV -> L * 6;  // 864
            case UIV -> L * 7;  // 1008
            case UXV -> L * 8;  // 1152
            case OpV -> L * 9;  // 1296
            default -> 1;
        };
    }


}
