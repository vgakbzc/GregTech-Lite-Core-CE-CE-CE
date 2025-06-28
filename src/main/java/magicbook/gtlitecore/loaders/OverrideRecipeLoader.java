package magicbook.gtlitecore.loaders;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.integration.gregtech.GTOverrideRecipeManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.MarkerMaterials.Color.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.GTLiteValues.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.NANO_SCALE_MASK_ALIGNER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class OverrideRecipeLoader {

    public static void init() {
        GTOverrideRecipeManager.init();
        SiliconWaferOverrides();
        RubberOverrides();
        MiscOverrides();
    }

    /**
     * Override of Silicon Wafers
     *
     * <p>
     *     This is a necessary tweak about {@link Materials#Neutronium}, because in gtlitecore,
     *     you needs to build Fusion Reactor Mark V to get Neutronium,
     *     so in the same tier, you can not get Neutronium Wafer same as vanilla GregTech environment.
     * </p>
     */
    private static void SiliconWaferOverrides() {

        //  Delete Neutronium Boule recipe
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 32),
                                OreDictUnifier.get(ingot, Neutronium, 4),
                                OreDictUnifier.get(dust, GalliumArsenide, 2)},
                new FluidStack[]{Xenon.getFluid(8000)});

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .input(dust, Silicon, 1)
                .fluidOutputs(Trichlorosilane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[LV])
                .duration(29 * 20 + 9)
                .buildAndRegister();

        // remove pure boule recipe
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon, 32),
                        OreDictUnifier.get(dustSmall, GalliumArsenide, 1),
                        IntCircuitIngredient.getIntegratedCircuit(2)});
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .fluidInputs(Trichlorosilane.getFluid(16000))
                .fluidInputs(Hydrogen.getFluid(16000))
                .input(dustSmall, GalliumArsenide, 1)
                .output(SILICON_BOULE)
                .fluidOutputs(HydrochloricAcid.getFluid(48000))
                .EUt(VA[MV])
                .duration(450 * 20)
                .blastFurnaceTemp(1784)
                .buildAndRegister();


        // remove P-doped boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon, 32),
                        OreDictUnifier.get(dust, Phosphorus, 4),
                        OreDictUnifier.get(dustSmall, GalliumArsenide, 2)},
                new FluidStack[]{Nitrogen.getFluid(8000)});
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .fluidInputs(Trichlorosilane.getFluid(64000))
                .fluidInputs(Hydrogen.getFluid(64000))
                .input(dust, Phosphorus, 4)
                .input(dustSmall, GalliumArsenide, 2)
                .fluidInputs(Nitrogen.getFluid(8000))
                .fluidOutputs(HydrochloricAcid.getFluid(192000))
                .output(PHOSPHORUS_BOULE)
                .EUt(VA[HV])
                .duration(600 * 20)
                .blastFurnaceTemp(2484)
                .buildAndRegister();

        // remove Nq-doped boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 16),
                        OreDictUnifier.get(ingot, Naquadah, 1),
                        OreDictUnifier.get(dust, GalliumArsenide, 1)},
                new FluidStack[]{Argon.getFluid(8000)});
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .input(block, Silicon, 16)
                .input(ingot, Naquadah, 1)
                .input(dust, GalliumArsenide, 1)
                .fluidInputs(Argon.getFluid(8000))
                .output(NAQUADAH_BOULE)
                .EUt(VA[EV])
                .duration(750 * 20)
                .blastFurnaceTemp(5407)
                .buildAndRegister();

        //  Delete Neutronium Boule -> Wafer recipes
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Water.getFluid(1000)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{DistilledWater.getFluid(750)});

        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES,
                new ItemStack[]{NEUTRONIUM_BOULE.getStackForm()},
                new FluidStack[]{Lubricant.getFluid(250)});

        //  Eu-doped Boule
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .input(block, Silicon, 32)
                .input(ingot, Europium, 4)
                .input(dust, GalliumArsenide, 2)
                .fluidInputs(Xenon.getFluid(8000))
                .output(EUROPIUM_BOULE)
                .EUt(VA[IV])
                .duration(QUAT_HOUR) // 900 sec
                .blastFurnaceTemp(6484) // 5400K < x < 7500K (Naquadah Coil)
                .buildAndRegister();

        //  Am-doped Boule
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .input(block, Silicon, 64)
                .input(ingot, Americium, 8)
                .input(dust, GalliumArsenide, 4)
                .fluidInputs(Radon.getFluid(8000))
                .output(AMERICIUM_BOULE)
                .EUt(VA[LuV])
                .duration((int) (17.5 * MINUTE)) // 1050 sec
                .blastFurnaceTemp(8860) // 7500K < x < 10800K (Trinium Coil)
                .buildAndRegister();

        //  Db-doped Boule
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .input(block, SiliconCarbide, 32)
                .input(ingot, Dubnium, 16)
                .input(dust, GalliumArsenide, 8)
                .fluidInputs(MetastableOganesson.getFluid(8000))
                .output(DUBNIUM_BOULE)
                .EUt(VA[ZPM])
                .duration(20 * MINUTE) // 1200 sec
                .blastFurnaceTemp(10400) // 10800K < x < 13501K (Tritanium Coil)
                .buildAndRegister();

        //  Nt-doped Boule
        MONOCRYSTALLINE_SILICON_BLAST_SMELTER_RECIPES.recipeBuilder()
                .input(block, SiliconCarbide, 64)
                .input(ingot, Neutronium, 32)
                .input(dust, GalliumArsenide, 16)
                .fluidInputs(InertGasMixture.getFluid(8000))
                .output(NEUTRONIUM_BOULE)
                .EUt(VA[UV])
                .duration((int) (22.5 * MINUTE)) // 1350 sec
                .blastFurnaceTemp(14860) // 13501K < x < 16600K
                .buildAndRegister();

        //  Eu-doped Boule -> Eu-doped Wafers
        CUTTER_RECIPES.recipeBuilder()
                .input(EUROPIUM_BOULE)
                .output(EUROPIUM_WAFER, 64)
                .output(EUROPIUM_WAFER, 32)
                .EUt(VA[IV])
                .duration(3 * MINUTE) // 180 sec
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Am-doped Boule -> Am-doped Wafers
        CUTTER_RECIPES.recipeBuilder()
                .input(AMERICIUM_BOULE)
                .output(AMERICIUM_WAFER, 64)
                .output(AMERICIUM_WAFER, 64)
                .EUt(VA[LuV])
                .duration(4 * MINUTE) // 240 sec
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Db-doped Boule -> Db-doped Wafers
        CUTTER_RECIPES.recipeBuilder()
                .input(DUBNIUM_BOULE)
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 64)
                .output(DUBNIUM_WAFER, 32)
                .EUt(VA[ZPM])
                .duration(5 * MINUTE) // 300 sec
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Nt-doped Boule -> Nt-doped Wafers
        CUTTER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_BOULE)
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .output(NEUTRONIUM_WAFER, 64)
                .EUt(VA[UV])
                .duration(6 * MINUTE) // 360 sec
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Add Laser Engraver recipe to Dubnium Wafer and Neutronium Wafer.
        int baseDuration = 10 * SECOND;

        //  Red: Integrated Logic Circuit Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Red));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Red)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 64)
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Green: RAM Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Green));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Green)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 64)
                .output(RANDOM_ACCESS_MEMORY_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Light Blue: CPU Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, LightBlue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, LightBlue)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 64)
                .output(CENTRAL_PROCESSING_UNIT_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Blue: ULPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Blue));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Blue)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Orange: LPIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Orange));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Orange)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cyan: Simple SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Cyan));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Cyan)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 64)
                .output(SIMPLE_SYSTEM_ON_CHIP_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Gray: NAND Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Gray));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Gray)
                .output(NAND_MEMORY_CHIP_WAFER, 64)
                .output(NAND_MEMORY_CHIP_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Pink: NOR Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Pink));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Pink)
                .output(NOR_MEMORY_CHIP_WAFER, 64)
                .output(NOR_MEMORY_CHIP_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Brown: PIC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Brown));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Brown)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Yellow: SoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Yellow));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 64)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Yellow)
                .output(SYSTEM_ON_CHIP_WAFER, 64)
                .output(SYSTEM_ON_CHIP_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Purple: ASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Purple));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 4)
                .EUt(VA[IV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 16)
                .EUt(VA[LuV])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 32)
                .EUt(VA[ZPM])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Purple)
                .output(ADVANCED_SYSTEM_ON_CHIP_WAFER, 64)
                .EUt(VA[UV])
                .duration(baseDuration / 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Black: HASoC Wafer
        GTRecipeHandler.removeRecipesByInputs(LASER_ENGRAVER_RECIPES,
                NEUTRONIUM_WAFER.getStackForm(),
                OreDictUnifier.get(craftingLens, Black));

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(EUROPIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER)
                .EUt(VA[IV])
                .duration(45 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 4)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 16)
                .EUt(VA[ZPM])
                .duration((int) (2.5 * SECOND))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(craftingLens, Black)
                .output(HIGHLY_ADVANCED_SOC_WAFER, 32)
                .EUt(VA[UV])
                .duration(SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Chromatic: UHASoC Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(CHROMATIC_LENS)
                .output(UHASOC_WAFER)
                .EUt(VA[LuV])
                .duration(45 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(CHROMATIC_LENS)
                .output(UHASOC_WAFER, 4)
                .EUt(VA[ZPM])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(CHROMATIC_LENS)
                .output(UHASOC_WAFER, 16)
                .EUt(VA[UV])
                .duration((int) (2.5 * SECOND))
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  UHASoC Wafer -> UHASoC Chips
        CUTTER_RECIPES.recipeBuilder()
                .input(UHASOC_WAFER)
                .output(UHASOC_CHIP, 6)
                .EUt(VA[LuV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Lithium Niobate: Nano PIC Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(AMERICIUM_WAFER)
                .notConsumable(lens, LithiumNiobate)
                .output(NANO_PIC_WAFER)
                .EUt(VA[LuV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(lens, LithiumNiobate)
                .output(NANO_PIC_WAFER, 4)
                .EUt(VA[ZPM])
                .duration(baseDuration / 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NEUTRONIUM_WAFER)
                .notConsumable(lens, LithiumNiobate)
                .output(NANO_PIC_WAFER, 16)
                .EUt(VA[UV])
                .duration(baseDuration / 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Nano PIC Wafer -> Nano PIC Chips
        CUTTER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .output(NANO_PIC_CHIP, 2)
                .EUt(VA[ZPM])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Lu/Tm-doped YVO: Pico PIC Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .notConsumable(lens, LuTmYVO)
                .output(PICO_PIC_WAFER)
                .EUt(VA[UV])
                .duration(baseDuration)
                .buildAndRegister();

        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .notConsumable(lens, LuTmYVO)
                .notConsumable(lens, Picotite)
                .fluidInputs(Helium.getPlasma(L / 2))
                .output(PICO_PIC_WAFER, 4)
                .EUt(VA[UHV])
                .duration(baseDuration / 4)
                .buildAndRegister();

        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .notConsumable(lens, LuTmYVO)
                .notConsumable(lens, Picotite)
                .notConsumable(lens, CrystalMatrix)
                .fluidInputs(Argon.getPlasma(L / 4))
                .output(PICO_PIC_WAFER, 16)
                .EUt(VA[UEV])
                .duration(SECOND)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(PICO_PIC_WAFER)
                .output(PICO_PIC_CHIP, 2)
                .EUt(VA[UV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Pr/Ho-YLF: Femto PIC Wafer
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(PICO_PIC_WAFER)
                .notConsumable(lens, PrHoYLF)
                .output(FEMTO_PIC_WAFER)
                .EUt(VA[UHV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .input(PICO_PIC_WAFER)
                .notConsumable(lens, PrHoYLF)
                .notConsumable(lens, ExtremelyUnstableNaquadah)
                .fluidInputs(Neon.getPlasma(L / 2))
                .output(FEMTO_PIC_WAFER, 4)
                .EUt(VA[UEV])
                .duration(baseDuration / 4)
                .buildAndRegister();

        NANO_SCALE_MASK_ALIGNER_RECIPES.recipeBuilder()
                .input(PICO_PIC_WAFER)
                .notConsumable(lens, PrHoYLF)
                .notConsumable(lens, ExtremelyUnstableNaquadah)
                .notConsumable(lens, Infinity)
                .fluidInputs(Xenon.getPlasma(L / 4))
                .output(FEMTO_PIC_WAFER, 16)
                .EUt(VA[UIV])
                .duration(SECOND)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(FEMTO_PIC_WAFER)
                .output(FEMTO_PIC_CHIP, 2)
                .EUt(VA[UHV])
                .duration(baseDuration)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    /**
     * Override of Rubbers
     *
     * <p>
     *     In gtlitecore, we add two new rubbers (please see:
     *      {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#NitrileButadieneRubber},
     *      {@link magicbook.gtlitecore.api.unification.GTLiteMaterials#PolyPhosphonitrileFluoroRubber}),
     *     so we should add some recipes about old rubbers in GregTech.
     * </p>
     */
    private static void RubberOverrides() {

        //  Conveyor Module Recipes

        //  LV Conveyor Module
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

        //  MV Conveyor Module
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

        //  HV Conveyor Module
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

        //  EV Conveyor Module
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

        //  IV Conveyor Module
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

        //  todo maybe we can add recipes of LuV-UV conveyor modules, but they are assembly line recipes.

        //  Electric Pump Recipes

        //  LV Electric Pump
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

        //  MV Electric Pump
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

        //  HV Electric Pump
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

        //  EV Electric Pump
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

        //  IV Electric Pump
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

        //  todo maybe we can add recipes of LuV-UV electric pumps, but they are assembly line recipes.
    }

    private static void MiscOverrides() {

        //  Remove Energy Cluster recipe.
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{
                        WETWARE_CIRCUIT_BOARD.getStackForm(),
                        OreDictUnifier.get(plate, Americium, 16),
                        WETWARE_SUPER_COMPUTER_UV.getStackForm(4),
                        ENERGY_MODULE.getStackForm(),
                        FIELD_GENERATOR_ZPM.getStackForm(),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(32),
                        ADVANCED_SMD_DIODE.getStackForm(16),
                        ADVANCED_SMD_CAPACITOR.getStackForm(16),
                        ADVANCED_SMD_RESISTOR.getStackForm(16),
                        ADVANCED_SMD_TRANSISTOR.getStackForm(16),
                        ADVANCED_SMD_INDUCTOR.getStackForm(16),
                        OreDictUnifier.get(wireFine, Osmiridium, 64),
                        OreDictUnifier.get(bolt, Naquadria, 16)
                },
                new FluidStack[]{
                        SolderingAlloy.getFluid(2880),
                        Polybenzimidazole.getFluid(576)});

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WETWARE_CIRCUIT_BOARD)
                .input(plate, Americium, 16)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ENERGY_MODULE)
                .input(FIELD_GENERATOR_ZPM)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(ADVANCED_SMD_DIODE, 16)
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .input(ADVANCED_SMD_RESISTOR, 16)
                .input(ADVANCED_SMD_TRANSISTOR, 16)
                .input(ADVANCED_SMD_INDUCTOR, 16)
                .input(wireFine, Osmiridium, 64)
                .input(bolt, Naquadria, 16)
                .fluidInputs(SolderingAlloy.getFluid(2880))
                .fluidInputs(Polybenzimidazole.getFluid(576))
                .output(ENERGY_CLUSTER)
                .EUt(200000) // UV
                .duration(70 * SECOND)
                .stationResearch(b -> b
                        .researchStack(ENERGY_MODULE.getStackForm())
                        .CWUt(96)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        //  Magnetic Materials Overrides
        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(ingot, ChromiumGermaniumTelluride));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stick, ChromiumGermaniumTelluride));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stickLong, ChromiumGermaniumTelluride));

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, ChromiumGermaniumTelluride)
                .output(ingot, ChromiumGermaniumTellurideMagnetic)
                .EUt(VA[ZPM])
                .duration((int) (5.05 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stick, ChromiumGermaniumTelluride)
                .output(stick, ChromiumGermaniumTellurideMagnetic)
                .EUt(VA[ZPM])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTelluride)
                .output(stickLong, ChromiumGermaniumTellurideMagnetic)
                .EUt(VA[ZPM])
                .duration((int) (5.05 * SECOND))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(ingot, PhosphorusDopedEuropiumIronArsenide));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stick, PhosphorusDopedEuropiumIronArsenide));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stickLong, PhosphorusDopedEuropiumIronArsenide));

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, PhosphorusDopedEuropiumIronArsenide)
                .output(ingot, PhosphorusDopedEuropiumIronArsenideMagnetic)
                .EUt(VA[UHV])
                .duration((int) (3.65 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stick, PhosphorusDopedEuropiumIronArsenide)
                .output(stick, PhosphorusDopedEuropiumIronArsenideMagnetic)
                .EUt(VA[UHV])
                .duration((int) (1.8 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stickLong, PhosphorusDopedEuropiumIronArsenide)
                .output(stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic)
                .EUt(VA[UHV])
                .duration((int) (3.65 * SECOND))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(ingot, BismuthLawrenciumStrontiumCuprate));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stick, BismuthLawrenciumStrontiumCuprate));

        GTRecipeHandler.removeRecipesByInputs(POLARIZER_RECIPES,
                OreDictUnifier.get(stickLong, BismuthLawrenciumStrontiumCuprate));

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, BismuthLawrenciumStrontiumCuprate)
                .output(ingot, BismuthLawrenciumStrontiumCuprateMagnetic)
                .EUt(VA[UIV])
                .duration((int) (3.85 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stick, BismuthLawrenciumStrontiumCuprate)
                .output(stick, BismuthLawrenciumStrontiumCuprateMagnetic)
                .EUt(VA[UIV])
                .duration((int) (1.9 * SECOND))
                .buildAndRegister();

        POLARIZER_RECIPES.recipeBuilder()
                .input(stickLong, BismuthLawrenciumStrontiumCuprate)
                .output(stickLong, BismuthLawrenciumStrontiumCuprateMagnetic)
                .EUt(VA[UIV])
                .duration((int) (3.85 * SECOND))
                .buildAndRegister();

        //  Ore Decomposition Fix
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Zircophyllite, 54)
                .output(dust, Potassium, 3)
                .output(dust, Sodium, 3)
                .output(dust, Manganese, 7)
                .output(dust, Iron, 7)
                .output(dust, Zirconium, 2)
                .output(dust, Titanium, 2)
                .fluidOutputs(Niobium.getFluid(L * 2))
                .fluidOutputs(Silicon.getFluid(L * 8))
                .fluidOutputs(Oxygen.getFluid(13000))
                .fluidOutputs(Fluorine.getFluid(7000))
                .EUt(VA[EV])
                .duration(14 * SECOND)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Lepersonnite, 63)
                .output(dust, Calcium)
                .output(dust, Ytterbium, 3)
                .output(dust, Gadolinium, 2)
                .output(dust, Dysprosium, 2)
                .output(dust, Uranium235, 2)
                .fluidOutputs(Oxygen.getFluid(29000))
                .fluidOutputs(Hydrogen.getFluid(24000))
                .EUt(VA[EV])
                .duration((int) (12.8 * SECOND))
                .buildAndRegister();
    }

}