package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class MiscItems {

    public static void init() {

        //  Advanced Piston (Vanilla) recipes
        ModHandler.addShapedRecipe("piston_tungsten_steel", new ItemStack(Blocks.PISTON, 16),
                "WWW", "SIS", "SDS",
                'W', "plankWood",
                'S', "stoneCobble",
                'I', new UnificationEntry(ingot, TungstenSteel),
                'D', new UnificationEntry(dust, Redstone));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TungstenSteel)
                .input("plankWood", 3)
                .input("stoneCobble", 4)
                .input(dust, Redstone)
                .outputs(new ItemStack(Blocks.PISTON, 16))
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ModHandler.addShapedRecipe("piston_rhodium_plated_palladium", new ItemStack(Blocks.PISTON, 32),
                "WWW", "SIS", "SDS",
                'W', "plankWood",
                'S', "stoneCobble",
                'I', new UnificationEntry(ingot, RhodiumPlatedPalladium),
                'D', new UnificationEntry(dust, Redstone));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, RhodiumPlatedPalladium)
                .input("plankWood", 3)
                .input("stoneCobble", 4)
                .input(dust, Redstone)
                .outputs(new ItemStack(Blocks.PISTON, 32))
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        ModHandler.addShapedRecipe("piston_naquadah_alloy", new ItemStack(Blocks.PISTON, 64),
                "WWW", "SIS", "SDS",
                'W', "plankWood",
                'S', "stoneCobble",
                'I', new UnificationEntry(ingot, NaquadahAlloy),
                'D', new UnificationEntry(dust, Redstone));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, NaquadahAlloy)
                .input("plankWood", 3)
                .input("stoneCobble", 4)
                .input(dust, Redstone)
                .outputs(new ItemStack(Blocks.PISTON, 64))
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Advanced Recipe of Optical Fiber
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, PMMA, 8)
                .input(foil, Electrum, 8)
                .fluidInputs(Polybenzimidazole.getFluid(L))
                .output(MetaBlocks.OPTICAL_PIPES[0], 4)
                .EUt(VA[LuV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, CBDOPolycarbonate, 8)
                .input(foil, FluxedElectrum, 8)
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(MetaBlocks.OPTICAL_PIPES[0], 16)
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, PraseodymiumDopedZBLANGlass, 8)
                .input(foil, Cinobite, 8)
                .fluidInputs(Zylon.getFluid(L))
                .output(MetaBlocks.OPTICAL_PIPES[0], 64)
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Advanced Recipe of Laser Fiber
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.BPA_POLYCARBONATE_GLASS))
                .input(foil, Tritanium, 2)
                .fluidInputs(Polybenzimidazole.getFluid(L))
                .output(MetaBlocks.LASER_PIPES[0], 4)
                .EUt(VA[LuV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS))
                .input(foil, Adamantium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(L))
                .output(MetaBlocks.LASER_PIPES[0], 16)
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.CBDO_POLYCARBONATE_GLASS))
                .input(foil, Hdcs, 2)
                .fluidInputs(Zylon.getFluid(L))
                .output(MetaBlocks.LASER_PIPES[0], 64)
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

}
