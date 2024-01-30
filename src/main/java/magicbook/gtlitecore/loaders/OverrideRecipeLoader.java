package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.blocks.BlockHermeticCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.EXPORT_FLUID_HATCH;

public class OverrideRecipeLoader {

    public static void init() {
        SiliconWaferOverrides();
        RubberOverrides();
        SteamStageOverrides();
        HighTierOverrides();
        GCYMOverrides();
    }

    private static void SiliconWaferOverrides() {
        //  Neutronium Boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 32),
                        OreDictUnifier.get(ingot, Neutronium, 4),
                        OreDictUnifier.get(dust, GalliumArsenide, 2)},
                new FluidStack[]{Xenon.getFluid(8000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Water.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{DistilledWater.getFluid(750)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Lubricant.getFluid(250)});

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 32)
                .input(ingot, Dubnium, 4)
                .input(dust, GalliumArsenide, 2)
                .fluidInputs(Xenon.getFluid(8000))
                .output(DUBNIUM_BOULE)
                .blastFurnaceTemp(6484)
                .EUt(VA[IV])
                .duration(18000)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(block, Silicon, 64)
                .input(ingot, Neutronium, 8)
                .input(dust, GalliumArsenide, 4)
                .fluidInputs(Radon.getFluid(8000))
                .output(NEUTRONIUM_BOULE)
                .blastFurnaceTemp(8864)
                .EUt(VA[LuV])
                .duration(21000)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(3600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(2400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Water.getFluid(1000))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(6400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(4800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(250))
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(3200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Red: Integrated Logic Circuit Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Red));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Green: RAM Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Green));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Light Blue: CPU Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, LightBlue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Blue: ULPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Blue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Orange: LPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Orange));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cyan: Simple SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Cyan));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Gray: NAND Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Gray));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Pink: NOR Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Pink));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Brown: PIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Brown));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Yellow: SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Yellow));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Purple: ASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Purple));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Black: HASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Black));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 16)
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  UHASoC
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(lens, MagnetoResonatic)
                .output(UHASOC_WAFER, 32)
                .EUt(VA[LuV])
                .duration(50)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Water.getFluid(1000))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1800)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(1350)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .fluidInputs(Lubricant.getFluid(250))
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(900)
                .buildAndRegister();
    }

    private static void RubberOverrides() {
        //  Conveyor Module Recipes
        ModHandler.addShapedRecipe(true, "conveyor_module_lv_nitrile_butadiene_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "conveyor_module_lv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_LV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tin)
                    .input(ELECTRIC_MOTOR_LV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_nitrile_butadiene_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "conveyor_module_mv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_MV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Copper)
                    .input(ELECTRIC_MOTOR_MV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_nitrile_butadiene_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "conveyor_module_hv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_HV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Gold)
                    .input(ELECTRIC_MOTOR_HV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_nitrile_butadiene_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "conveyor_module_ev_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_EV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Aluminium)
                    .input(ELECTRIC_MOTOR_EV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_nitrile_butadiene_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, NitrileButadieneRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "conveyor_module_iv_poly_phosphonitrile_fluoro_rubber", CONVEYOR_MODULE_IV.getStackForm(),
                "PPP", "MWM", "PPP",
                'P', new UnificationEntry(plate, PolyPhosphonitrileFluoroRubber),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        for (FluidStack stack : new FluidStack[]{
                NitrileButadieneRubber.getFluid(L * 6),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6)}) {
            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tungsten)
                    .input(ELECTRIC_MOTOR_IV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV)
                    .EUt(VA[LV])
                    .duration(100)
                    .buildAndRegister();
        }

        //  TODO LuV-UV

        //  Electric Pump Recipes
        ModHandler.addShapedRecipe(true, "electric_pump_lv_nitrile_butadiene_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "electric_pump_lv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_LV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Tin),
                'R', new UnificationEntry(rotor, Tin),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Bronze),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tin));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_mv_nitrile_butadiene_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ModHandler.addShapedRecipe(true, "electric_pump_mv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_MV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Steel),
                'M', ELECTRIC_MOTOR_MV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Copper));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_hv_nitrile_butadiene_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "electric_pump_hv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_HV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'M', ELECTRIC_MOTOR_HV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Gold));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_ev_nitrile_butadiene_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ModHandler.addShapedRecipe(true, "electric_pump_ev_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_EV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, StainlessSteel),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, Titanium),
                'M', ELECTRIC_MOTOR_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Aluminium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "electric_pump_iv_nitrile_butadiene_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, NitrileButadieneRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ModHandler.addShapedRecipe(true, "electric_pump_iv_poly_phosphonitrile_fluoro_rubber", ELECTRIC_PUMP_IV.getStackForm(),
                "SRO", "dPw", "OMW",
                'S', new UnificationEntry(screw, TungstenSteel),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'O', new UnificationEntry(ring, PolyPhosphonitrileFluoroRubber),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'M', ELECTRIC_MOTOR_IV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, NitrileButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, PolyPhosphonitrileFluoroRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  TODO LuV-UV
    }

    private static void SteamStageOverrides() {

        if (GTLiteConfigHolder.steamOverrides.enableHarderSteamMachineRecipe) {

            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_bronze", MetaTileEntities.STEAM_BOILER_COAL_BRONZE.getStackForm(),
                    "PPP", "CHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            ModHandler.removeRecipeByName("gregtech:steam_boiler_coal_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_coal_steel", MetaTileEntities.STEAM_BOILER_COAL_STEEL.getStackForm(),
                    "PPP", "RHC", "BFB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'F', "craftingFurnace");

            ModHandler.removeRecipeByName("gregtech:steam_boiler_solar_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_solar_bronze", MetaTileEntities.STEAM_BOILER_SOLAR_BRONZE.getStackForm(),
                    "PPP", "CHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_solar_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_solar_steel", MetaTileEntities.STEAM_BOILER_SOLAR_STEEL.getStackForm(),
                    "PGP", "CHU", "BRB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'C', CONVEYOR_MODULE_ULV,
                    'U', ELECTRIC_PUMP_ULV,
                    'R', ROBOT_ARM_ULV,
                    'B', new UnificationEntry(pipeSmallFluid, TinAlloy),
                    'P', new UnificationEntry(plate, Steel),
                    'G', new UnificationEntry(plate, Glass));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_bronze");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_bronze", MetaTileEntities.STEAM_BOILER_LAVA_BRONZE.getStackForm(),
                    "PPP", "UHU", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'P', new UnificationEntry(plate, Bronze),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, Bronze));

            ModHandler.removeRecipeByName("gregtech:steam_boiler_lava_steel");
            ModHandler.addShapedRecipe(true, "steam_boiler_lava_steel", MetaTileEntities.STEAM_BOILER_LAVA_STEEL.getStackForm(),
                    "PPP", "UHR", "BAB",
                    'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                    'U', ELECTRIC_PUMP_ULV,
                    'R', ROBOT_ARM_ULV,
                    'P', new UnificationEntry(plate, Steel),
                    'B', new UnificationEntry(block, Brick),
                    'A', new UnificationEntry(pipeSmallFluid, TinAlloy));
        }
    }

    private static void HighTierOverrides() {

        //  Hermetic Casings
        ModHandler.addShapedRecipe(true, "hermetic_casing_uev", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UEV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Adamantium),
                'P', new UnificationEntry(pipeLargeFluid, Lafium));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uiv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UIV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Infinity),
                'P', new UnificationEntry(pipeLargeFluid, CrystalMatrix));

        ModHandler.addShapedRecipe(true, "hermetic_casing_uxv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_UXV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, CosmicNeutronium),
                'P', new UnificationEntry(pipeLargeFluid, QuantumchromodynamicallyConfinedMatter));

        ModHandler.addShapedRecipe(true, "hermetic_casing_opv", GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_OpV),
                "ppp", "pPp", "ppp",
                'p', new UnificationEntry(plate, Spacetime),
                'P', new UnificationEntry(pipeLargeFluid, Fatalium));

        //  End Game things
        //  a.k.a. creative things!
        ModHandler.addShapedRecipe(true, "quantum_tank_creative", CREATIVE_TANK.getStackForm(),
                "XFX", "PHP", "XpX",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                'F', FIELD_GENERATOR_MAX,
                'P', new UnificationEntry(plate, Eternity),
                'p', ELECTRIC_PUMP_MAX,
                'H', GTLiteMetaBlocks.HERMETIC_CASING.getItemVariant(BlockHermeticCasing.HermeticCasingType.HERMETIC_MAX));

        ModHandler.addShapedRecipe(true, "quantum_chest_creative", CREATIVE_CHEST.getStackForm(),
                "XPX", "PHP", "XFX",
                'H', HULL[MAX].getStackForm(),
                'P', new UnificationEntry(plate, Eternity),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                'F', FIELD_GENERATOR_MAX);

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ITEM_IMPORT_BUS[UHV])
                .input(TOOL_DATA_MODULE, 4)
                .input(circuit, MarkerMaterials.Tier.MAX, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Eternity.getFluid(2880))
                .fluidInputs(Spacetime.getFluid(1440))
                .fluidInputs(Infinity.getFluid(576))
                .output(CREATIVE_DATA_HATCH)
                .stationResearch(b -> b
                        .researchStack(TOOL_DATA_MODULE.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[MAX]))
                .EUt(VA[MAX])
                .duration(200)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "creative_energy_unit", CREATIVE_ENERGY.getStackForm(),
                "IXI", "EHS", "IPI",
                'H', HULL[MAX].getStackForm(),
                'I', FEMTO_PIC_CHIP,
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.MAX),
                'E', EMITTER_MAX,
                'S', SENSOR_MAX,
                'P', new UnificationEntry(plate, Eternity));

        //  todo some recipe should be delete, e.g. UHV multi fluid hatch?
        ItemBuses();
        FluidHatches();
        EnergyHathces();
    }

    private static void ItemBuses() {

        //  Delete vanilla UHV item bus recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_CHEST[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_CHEST[1])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(ITEM_IMPORT_BUS[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_CHEST[1])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(ITEM_EXPORT_BUS[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        //  UEV item bus
        ModHandler.addShapedRecipe(true, "item_bus_input_to_output_10", IMPORT_ITEM_HATCH[0].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_ITEM_HATCH[0].getStackForm());

        ModHandler.addShapedRecipe(true, "item_bus_output_to_input_10", EXPORT_ITEM_HATCH[0].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_ITEM_HATCH[0].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(QUANTUM_CHEST[2])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(864))
                .output(IMPORT_ITEM_HATCH[0])
                .EUt(VA[UEV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(QUANTUM_CHEST[2])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(864))
                .output(EXPORT_ITEM_HATCH[0])
                .EUt(VA[UEV])
                .duration(300)
                .buildAndRegister();

        //  UIV item bus
        ModHandler.addShapedRecipe(true, "item_bus_input_to_output_11", IMPORT_ITEM_HATCH[1].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_ITEM_HATCH[1].getStackForm());

        ModHandler.addShapedRecipe(true, "item_bus_output_to_input_11", EXPORT_ITEM_HATCH[1].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_ITEM_HATCH[1].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(QUANTUM_CHEST[3])
                .circuitMeta(1)
                .fluidInputs(Kevlar.getFluid(1008))
                .output(IMPORT_ITEM_HATCH[1])
                .EUt(VA[UIV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(QUANTUM_CHEST[3])
                .circuitMeta(2)
                .fluidInputs(Kevlar.getFluid(1008))
                .output(EXPORT_ITEM_HATCH[1])
                .EUt(VA[UIV])
                .duration(300)
                .buildAndRegister();

        //  UXV item bus
        ModHandler.addShapedRecipe(true, "item_bus_input_to_output_12", IMPORT_ITEM_HATCH[2].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_ITEM_HATCH[2].getStackForm());

        ModHandler.addShapedRecipe(true, "item_bus_output_to_input_12", EXPORT_ITEM_HATCH[2].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_ITEM_HATCH[2].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(QUANTUM_CHEST[4])
                .circuitMeta(1)
                .fluidInputs(Kevlar.getFluid(1152))
                .output(IMPORT_ITEM_HATCH[2])
                .EUt(VA[UXV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(QUANTUM_CHEST[4])
                .circuitMeta(2)
                .fluidInputs(Kevlar.getFluid(1152))
                .output(EXPORT_ITEM_HATCH[2])
                .EUt(VA[UXV])
                .duration(300)
                .buildAndRegister();

        //  OpV item bus
        ModHandler.addShapedRecipe(true, "item_bus_input_to_output_13", IMPORT_ITEM_HATCH[3].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_ITEM_HATCH[3].getStackForm());

        ModHandler.addShapedRecipe(true, "item_bus_output_to_input_13", EXPORT_ITEM_HATCH[3].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_ITEM_HATCH[3].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(QUANTUM_CHEST[5])
                .circuitMeta(1)
                .fluidInputs(CosmicFabric.getFluid(1296))
                .output(IMPORT_ITEM_HATCH[3])
                .EUt(VA[OpV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(QUANTUM_CHEST[5])
                .circuitMeta(2)
                .fluidInputs(CosmicFabric.getFluid(1296))
                .output(EXPORT_ITEM_HATCH[3])
                .EUt(VA[OpV])
                .duration(300)
                .buildAndRegister();

    }

    private static void FluidHatches() {

        //  Delete vanilla UHV fluid bus recipe
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(1)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(), QUANTUM_TANK[1].getStackForm(), IntCircuitIngredient.getIntegratedCircuit(2)},
                new FluidStack[]{Polybenzimidazole.getFluid(720)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_IMPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(QUANTUM_TANK[1])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(720))
                .output(FLUID_EXPORT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(300)
                .buildAndRegister();

        //  UEV fluid hatch
        ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_10", IMPORT_FLUID_HATCH[0].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_FLUID_HATCH[0].getStackForm());

        ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_10", EXPORT_FLUID_HATCH[0].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_FLUID_HATCH[0].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(QUANTUM_TANK[2])
                .circuitMeta(1)
                .fluidInputs(Polyetheretherketone.getFluid(864))
                .output(IMPORT_FLUID_HATCH[0])
                .EUt(VA[UEV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(QUANTUM_CHEST[2])
                .circuitMeta(2)
                .fluidInputs(Polyetheretherketone.getFluid(864))
                .output(EXPORT_FLUID_HATCH[0])
                .EUt(VA[UEV])
                .duration(300)
                .buildAndRegister();

        //  UIV
        ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_11", IMPORT_FLUID_HATCH[1].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_FLUID_HATCH[1].getStackForm());

        ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_11", EXPORT_FLUID_HATCH[1].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_FLUID_HATCH[1].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(QUANTUM_TANK[3])
                .circuitMeta(1)
                .fluidInputs(Kevlar.getFluid(1008))
                .output(IMPORT_FLUID_HATCH[1])
                .EUt(VA[UIV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(QUANTUM_TANK[3])
                .circuitMeta(2)
                .fluidInputs(Kevlar.getFluid(1008))
                .output(EXPORT_FLUID_HATCH[1])
                .EUt(VA[UIV])
                .duration(300)
                .buildAndRegister();

        //  UXV
        ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_12", IMPORT_FLUID_HATCH[2].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_FLUID_HATCH[2].getStackForm());

        ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_12", EXPORT_FLUID_HATCH[2].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_FLUID_HATCH[2].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(QUANTUM_TANK[4])
                .circuitMeta(1)
                .fluidInputs(Kevlar.getFluid(1152))
                .output(IMPORT_FLUID_HATCH[2])
                .EUt(VA[UXV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(QUANTUM_TANK[4])
                .circuitMeta(2)
                .fluidInputs(Kevlar.getFluid(1152))
                .output(EXPORT_FLUID_HATCH[2])
                .EUt(VA[UXV])
                .duration(300)
                .buildAndRegister();

        //  OpV
        ModHandler.addShapedRecipe(true, "fluid_hatch_input_to_output_13", IMPORT_FLUID_HATCH[3].getStackForm(),
                " d ", " H ", "   ",
                'H', EXPORT_FLUID_HATCH[3].getStackForm());

        ModHandler.addShapedRecipe(true, "fluid_hatch_output_to_input_13", EXPORT_FLUID_HATCH[3].getStackForm(),
                " d ", " H ", "   ",
                'H', IMPORT_FLUID_HATCH[3].getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(QUANTUM_TANK[5])
                .circuitMeta(1)
                .fluidInputs(CosmicFabric.getFluid(1296))
                .output(IMPORT_FLUID_HATCH[3])
                .EUt(VA[OpV])
                .duration(300)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(QUANTUM_TANK[5])
                .circuitMeta(2)
                .fluidInputs(CosmicFabric.getFluid(1296))
                .output(EXPORT_FLUID_HATCH[3])
                .EUt(VA[OpV])
                .duration(300)
                .buildAndRegister();

    }

    private static void EnergyHathces() {

        EnergyHatches1A();
        EnergyHatches4A();
        EnergyHatches16A();
        EnergyHatches64A();
        Transformers();
        PowerTransformers();
        HiAmpTransformers();
    }

    private static void EnergyHatches1A() {

        //  Delete UHV vanilla recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(cableGtSingle, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{HULL[UHV].getStackForm(),
                        OreDictUnifier.get(spring, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .input(spring, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .EUt(VA[UHV])
                .duration(1000)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(cableGtSingle, PedotTMA, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(VOLTAGE_COIL_UEV, 2)
                .fluidInputs(SodiumPotassium.getFluid(14000))
                .fluidInputs(SolderingAlloy.getFluid(11520))
                .output(ENERGY_INPUT_HATCH[UEV])
                .EUt(VA[UEV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UHV].getStackForm())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .input(spring, PedotTMA, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(VOLTAGE_COIL_UEV, 2)
                .fluidInputs(SodiumPotassium.getFluid(14000))
                .fluidInputs(SolderingAlloy.getFluid(11520))
                .output(ENERGY_OUTPUT_HATCH[UEV])
                .EUt(VA[UEV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UHV].getStackForm())
                        .CWUt(256)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  UIV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(cableGtSingle, Solarium, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(VOLTAGE_COIL_UIV, 2)
                .fluidInputs(SodiumPotassium.getFluid(16000))
                .fluidInputs(SolderingAlloy.getFluid(23040))
                .output(ENERGY_INPUT_HATCH[UIV])
                .EUt(VA[UIV])
                .duration(1400)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UEV].getStackForm())
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .input(spring, Solarium, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(VOLTAGE_COIL_UIV, 2)
                .fluidInputs(SodiumPotassium.getFluid(16000))
                .fluidInputs(SolderingAlloy.getFluid(23040))
                .output(ENERGY_OUTPUT_HATCH[UIV])
                .EUt(VA[UIV])
                .duration(1400)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UEV].getStackForm())
                        .CWUt(512)
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UXV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(cableGtSingle, Hypogen, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UXV)
                .input(VOLTAGE_COIL_UXV, 2)
                .fluidInputs(SodiumPotassium.getFluid(18000))
                .fluidInputs(SolderingAlloy.getFluid(46080))
                .output(ENERGY_INPUT_HATCH[UXV])
                .EUt(VA[UXV])
                .duration(1600)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UIV].getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[UXV])
                .input(spring, Hypogen, 4)
                .input(PICO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UXV)
                .input(VOLTAGE_COIL_UXV, 2)
                .fluidInputs(SodiumPotassium.getFluid(18000))
                .fluidInputs(SolderingAlloy.getFluid(46080))
                .output(ENERGY_OUTPUT_HATCH[UXV])
                .EUt(VA[UXV])
                .duration(1600)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UIV].getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        //  OpV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(cableGtSingle, Galaxium, 4)
                .input(FEMTO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.OpV)
                .input(VOLTAGE_COIL_OpV, 2)
                .fluidInputs(SodiumPotassium.getFluid(20000))
                .fluidInputs(SolderingAlloy.getFluid(92160))
                .output(ENERGY_INPUT_HATCH[OpV])
                .EUt(VA[OpV])
                .duration(1800)
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UXV].getStackForm())
                        .CWUt(2048)
                        .EUt(VA[UXV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(HULL[OpV])
                .input(spring, Galaxium, 4)
                .input(FEMTO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.OpV)
                .input(VOLTAGE_COIL_OpV, 2)
                .fluidInputs(SodiumPotassium.getFluid(20000))
                .fluidInputs(SolderingAlloy.getFluid(92160))
                .output(ENERGY_OUTPUT_HATCH[OpV])
                .EUt(VA[OpV])
                .duration(1800)
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UXV].getStackForm())
                        .CWUt(2048)
                        .EUt(VA[UXV]))
                .buildAndRegister();
    }

    private static void EnergyHatches4A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_INPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, ENERGY_OUTPUT_HATCH[UHV].getStackForm(), OreDictUnifier.get(wireGtQuadruple, Europium, 2), OreDictUnifier.get(plate, Neutronium, 2));

        //  fixme it seems ceu dev missing these... so if this recipe be deleted in future versions, this change should delete.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, TRANSFORMER[ZPM].getStackForm(), ENERGY_OUTPUT_HATCH[ZPM].getStackForm(), OreDictUnifier.get(wireGtQuadruple, VanadiumGallium, 2), OreDictUnifier.get(plate, NaquadahAlloy, 2));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[ZPM])
                .input(wireGtQuadruple, VanadiumGallium, 2)
                .input(plate, NaquadahAlloy, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[3]) // from EV to ZPM
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        //  4A output addons for LV, MV, HV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[LV])
                .input(wireGtQuadruple, Tin, 2)
                .input(plate, Steel, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[0])
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[MV])
                .input(wireGtQuadruple, Copper, 2)
                .input(plate, Aluminium, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[1])
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[HV])
                .input(wireGtQuadruple, Gold, 2)
                .input(plate, StainlessSteel, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[2])
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_INPUT_HATCH_4A[5]) // from IV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UHV])
                .input(wireGtQuadruple, Europium, 2)
                .input(plate, Orichalcum, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[5]) // from EV to UHV
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  UEV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UEV])
                .input(wireGtQuadruple, PedotTMA, 2)
                .input(plate, Adamantium, 2)
                .output(INPUT_ENERGY_HATCH_4A[0]) // from gtlitecore
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UEV])
                .input(wireGtQuadruple, PedotTMA, 2)
                .input(plate, Adamantium, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  UIV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UIV])
                .input(wireGtQuadruple, Solarium, 2)
                .input(plate, Infinity, 2)
                .output(INPUT_ENERGY_HATCH_4A[1]) // from gtlitecore
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UIV])
                .input(wireGtQuadruple, Solarium, 2)
                .input(plate, Infinity, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                .EUt(VA[UEV])
                .duration(100)
                .buildAndRegister();

        //  UXV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[UXV])
                .input(wireGtQuadruple, Hypogen, 2)
                .input(plate, CosmicNeutronium, 2)
                .output(INPUT_ENERGY_HATCH_4A[2]) // from gtlitecore
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[UXV])
                .input(wireGtQuadruple, Hypogen, 2)
                .input(plate, CosmicNeutronium, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                .EUt(VA[UIV])
                .duration(100)
                .buildAndRegister();

        //  OpV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_INPUT_HATCH[OpV])
                .input(wireGtQuadruple, Galaxium, 2)
                .input(plate, Spacetime, 2)
                .output(INPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENERGY_OUTPUT_HATCH[OpV])
                .input(wireGtQuadruple, Galaxium, 2)
                .input(plate, Spacetime, 2)
                .output(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                .EUt(VA[UXV])
                .duration(100)
                .buildAndRegister();
    }

    private static void EnergyHatches16A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_4A[5].getStackForm(2), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, HI_AMP_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_4A[5].getStackForm(), OreDictUnifier.get(wireGtOctal, Europium, 2), OreDictUnifier.get(plate, Neutronium, 4));

        //  16A output addons for LV, MV, HV, EV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[LV])
                .input(OUTPUT_ENERGY_HATCH_4A[0])
                .input(wireGtOctal, Tin, 2)
                .input(plate, Steel, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[0])
                .EUt(VA[ULV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[MV])
                .input(OUTPUT_ENERGY_HATCH_4A[1])
                .input(wireGtOctal, Copper, 2)
                .input(plate, Aluminium, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[1])
                .EUt(VA[LV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[HV])
                .input(OUTPUT_ENERGY_HATCH_4A[2])
                .input(wireGtOctal, Gold, 2)
                .input(plate, StainlessSteel, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[2])
                .EUt(VA[MV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[EV])
                .input(ENERGY_OUTPUT_HATCH_4A[0])
                .input(wireGtOctal, Aluminium, 2)
                .input(plate, Titanium, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[3])
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_4A[5], 2)
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_INPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_4A[5])
                .input(wireGtOctal, Europium, 2)
                .input(plate, Orichalcum, 4)
                .output(ENERGY_OUTPUT_HATCH_16A[4])
                .EUt(VA[UV])
                .duration(200)
                .buildAndRegister();

        //  UEV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UEV])
                .input(INPUT_ENERGY_HATCH_4A[0], 2) // from gtlitecore
                .input(wireGtOctal, PedotTMA, 2)
                .input(plate, Adamantium, 4)
                .output(INPUT_ENERGY_HATCH_16A[0]) // from gtlitecore
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UEV])
                .input(OUTPUT_ENERGY_HATCH_4A[3]) // from gtlitecore
                .input(wireGtOctal, PedotTMA, 2)
                .input(plate, Adamantium, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[4]) // from gtlitecore
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  UIV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UIV])
                .input(INPUT_ENERGY_HATCH_4A[1], 2) // from gtlitecore
                .input(wireGtOctal, Solarium, 2)
                .input(plate, Infinity, 4)
                .output(INPUT_ENERGY_HATCH_16A[1]) // from gtlitecore
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UIV])
                .input(OUTPUT_ENERGY_HATCH_4A[4]) // from gtlitecore
                .input(wireGtOctal, Solarium, 2)
                .input(plate, Infinity, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[5]) // from gtlitecore
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  UXV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UXV])
                .input(INPUT_ENERGY_HATCH_4A[2], 2) // from gtlitecore
                .input(wireGtOctal, Hypogen, 2)
                .input(plate, CosmicNeutronium, 4)
                .output(INPUT_ENERGY_HATCH_16A[2]) // from gtlitecore
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UXV])
                .input(OUTPUT_ENERGY_HATCH_4A[5]) // from gtlitecore
                .input(wireGtOctal, Hypogen, 2)
                .input(plate, CosmicNeutronium, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[6]) // from gtlitecore
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  OpV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[OpV])
                .input(INPUT_ENERGY_HATCH_4A[3], 2) // from gtlitecore
                .input(wireGtOctal, Galaxium, 2)
                .input(plate, Spacetime, 4)
                .output(INPUT_ENERGY_HATCH_16A[3]) // from gtlitecore
                .EUt(VA[UXV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[OpV])
                .input(OUTPUT_ENERGY_HATCH_4A[6]) // from gtlitecore
                .input(wireGtOctal, Galaxium, 2)
                .input(plate, Spacetime, 4)
                .output(OUTPUT_ENERGY_HATCH_16A[7]) // from gtlitecore
                .EUt(VA[UXV])
                .duration(200)
                .buildAndRegister();
    }

    private static void EnergyHatches64A() {

        //  Delete vanilla UHV recipes
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_INPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, POWER_TRANSFORMER[UV].getStackForm(), ENERGY_OUTPUT_HATCH_16A[4].getStackForm(), OreDictUnifier.get(wireGtHex, Europium, 2), OreDictUnifier.get(plate, Neutronium, 6));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_INPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_INPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UHV])
                .input(ENERGY_OUTPUT_HATCH_16A[4])
                .input(wireGtHex, Europium, 2)
                .input(plate, Orichalcum, 6)
                .output(SUBSTATION_ENERGY_OUTPUT_HATCH[4])
                .EUt(VA[UV])
                .duration(400)
                .buildAndRegister();

        //  UEV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UEV])
                .input(INPUT_ENERGY_HATCH_16A[0])
                .input(wireGtHex, PedotTMA, 2)
                .input(plate, Adamantium, 6)
                .output(SUBSTATION_INPUT_ENERGY_HATCH[0])
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UEV])
                .input(OUTPUT_ENERGY_HATCH_16A[4])
                .input(wireGtHex, PedotTMA, 2)
                .input(plate, Adamantium, 6)
                .output(SUBSTATION_OUTPUT_ENERGY_HATCH[0])
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();

        //  UIV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UIV])
                .input(INPUT_ENERGY_HATCH_16A[1])
                .input(wireGtHex, Solarium, 2)
                .input(plate, Infinity, 6)
                .output(SUBSTATION_INPUT_ENERGY_HATCH[1])
                .EUt(VA[UEV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UIV])
                .input(OUTPUT_ENERGY_HATCH_16A[5])
                .input(wireGtHex, Solarium, 2)
                .input(plate, Infinity, 6)
                .output(SUBSTATION_OUTPUT_ENERGY_HATCH[1])
                .EUt(VA[UEV])
                .duration(400)
                .buildAndRegister();

        //  UXV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UXV])
                .input(INPUT_ENERGY_HATCH_16A[2])
                .input(wireGtHex, Hypogen, 2)
                .input(plate, CosmicNeutronium, 6)
                .output(SUBSTATION_INPUT_ENERGY_HATCH[2])
                .EUt(VA[UIV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[UXV])
                .input(OUTPUT_ENERGY_HATCH_16A[6])
                .input(wireGtHex, Hypogen, 2)
                .input(plate, CosmicNeutronium, 6)
                .output(SUBSTATION_OUTPUT_ENERGY_HATCH[2])
                .EUt(VA[UIV])
                .duration(400)
                .buildAndRegister();

        //  OpV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[OpV])
                .input(INPUT_ENERGY_HATCH_16A[3])
                .input(wireGtHex, Galaxium, 2)
                .input(plate, Spacetime, 6)
                .output(SUBSTATION_INPUT_ENERGY_HATCH[3])
                .EUt(VA[UXV])
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[OpV])
                .input(OUTPUT_ENERGY_HATCH_16A[7])
                .input(wireGtHex, Galaxium, 2)
                .input(plate, Spacetime, 6)
                .output(SUBSTATION_OUTPUT_ENERGY_HATCH[3])
                .EUt(VA[UXV])
                .duration(400)
                .buildAndRegister();
    }

    private static void Transformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.uhv", TRANSFORMER[UHV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Europium),
                'P', NANO_PIC_CHIP,
                'H', HULL[UHV].getStackForm());

        //  UEV
        ModHandler.addShapedRecipe(true, "machine.transformer.uev", TRANSFORMER[UEV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, PedotTMA),
                'P', NANO_PIC_CHIP,
                'H', HULL[UEV].getStackForm());

        //  UIV
        ModHandler.addShapedRecipe(true, "machine.transformer.uiv", TRANSFORMER[UIV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Solarium),
                'P', PICO_PIC_CHIP,
                'H', HULL[UIV].getStackForm());

        //  UXV
        ModHandler.addShapedRecipe(true, "machine.transformer.uxv", TRANSFORMER[UXV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Hypogen),
                'P', PICO_PIC_CHIP,
                'H', HULL[UXV].getStackForm());

        //  OpV
        ModHandler.addShapedRecipe(true, "machine.transformer.opv", TRANSFORMER[OpV].getStackForm(),
                "PWW", "WH ", "PWW",
                'W', new UnificationEntry(cableGtSingle, Galaxium),
                'P', FEMTO_PIC_CHIP,
                'H', HULL[OpV].getStackForm());

    }

    private static void PowerTransformers() {

        //  UHV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UHV])
                .input(ELECTRIC_PUMP_IV)
                .input(cableGtOctal, PedotTMA)
                .input(cableGtHex, Europium, 2)
                .input(springSmall, Europium)
                .input(spring, PedotTMA)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UHV])
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  UEV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UEV])
                .input(ELECTRIC_PUMP_LuV)
                .input(cableGtOctal, Solarium)
                .input(cableGtHex, PedotTMA, 2)
                .input(springSmall, PedotTMA)
                .input(spring, Solarium)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UEV])
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  UIV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UIV])
                .input(ELECTRIC_PUMP_LuV)
                .input(cableGtOctal, Hypogen)
                .input(cableGtHex, Solarium, 2)
                .input(springSmall, Solarium)
                .input(spring, Hypogen)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UIV])
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  UXV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[UXV])
                .input(ELECTRIC_PUMP_ZPM)
                .input(cableGtOctal, Galaxium)
                .input(cableGtHex, Hypogen, 2)
                .input(springSmall, Hypogen)
                .input(spring, Galaxium)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[UXV])
                .EUt(VA[UXV])
                .duration(200)
                .buildAndRegister();

        //  OpV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HI_AMP_TRANSFORMER[OpV])
                .input(ELECTRIC_PUMP_ZPM)
                .input(cableGtOctal, Universium)
                .input(cableGtHex, Hypogen, 2)
                .input(springSmall, Hypogen)
                .input(spring, Universium)
                .fluidInputs(Lubricant.getFluid(2000))
                .output(POWER_TRANSFORMER[OpV])
                .EUt(VA[OpV])
                .duration(200)
                .buildAndRegister();
    }

    private static void HiAmpTransformers() {

        //  UHV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uhv", HI_AMP_TRANSFORMER[UHV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UHV,
                'H', HULL[UHV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, PedotTMA),
                'Q', new UnificationEntry(cableGtQuadruple, Europium));

        //  UEV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uev", HI_AMP_TRANSFORMER[UEV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UEV,
                'H', HULL[UEV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, Solarium),
                'Q', new UnificationEntry(cableGtQuadruple, PedotTMA));

        //  UIV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uiv", HI_AMP_TRANSFORMER[UIV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UIV,
                'H', HULL[UIV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, Hypogen),
                'Q', new UnificationEntry(cableGtQuadruple, Solarium));

        //  UXV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.uxv", HI_AMP_TRANSFORMER[UXV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_UXV,
                'H', HULL[UXV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, Galaxium),
                'Q', new UnificationEntry(cableGtQuadruple, Hypogen));

        //  OpV
        ModHandler.addShapedRecipe(true, "machine.transformer.hi_amp.opv", HI_AMP_TRANSFORMER[OpV].getStackForm(),
                "VQQ", "PH ", "VQQ",
                'V', VOLTAGE_COIL_OpV,
                'H', HULL[OpV].getStackForm(),
                'P', new UnificationEntry(cableGtQuadruple, Universium),
                'Q', new UnificationEntry(cableGtQuadruple, Galaxium));
    }

    private static void GCYMOverrides() {

        //  Mega machines
        ModHandler.removeRecipeByName("gcym:mega_blast_furnace");
        ModHandler.addShapedRecipe(true, "mega_blast_furnace", MEGA_BLAST_FURNACE.getStackForm(),
                "SXS", "FHF", "PWP",
                'H', VOLCANUS.getStackForm(),
                'F', FIELD_GENERATOR_UV,
                'S', new UnificationEntry(spring, YttriumBariumCuprate),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'P', new UnificationEntry(plate, Orichalcum),
                'W', new UnificationEntry(wireGtQuadruple, Tritanium));

        ModHandler.removeRecipeByName("gcym:mega_vacuum_freezer");
        ModHandler.addShapedRecipe(true, "mega_vacuum_freezer", MEGA_VACUUM_FREEZER.getStackForm(),
                "SXS", "FHF", "PWP",
                'H', CRYOGENIC_FREEZER.getStackForm(),
                'F', FIELD_GENERATOR_UV,
                'S', new UnificationEntry(pipeNormalFluid, Duranium),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'P', new UnificationEntry(plate, Orichalcum),
                'W', new UnificationEntry(wireGtQuadruple, Tritanium));

        ModHandler.removeRecipeByName("gcym:large_circuit_assembler");
        ModHandler.addShapedRecipe(true, "large_circuit_assembler", LARGE_CIRCUIT_ASSEMBLER.getStackForm(),
                "RER", "CXC", "WMW",
                'X', CIRCUIT_ASSEMBLER[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'R', ROBOT_ARM_IV,
                'E', EMITTER_IV,
                'M', CONVEYOR_MODULE_IV,
                'W', new UnificationEntry(cableGtSingle, Platinum));
    }
}