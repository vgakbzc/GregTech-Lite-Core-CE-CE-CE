package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import magicbook.gtlitecore.common.blocks.BlockExplosive;
import magicbook.gtlitecore.common.blocks.BlockTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import java.math.BigInteger;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CANNER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.DegenerateRhenium;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class StellarFurnace {

    public static void init() {
        BasicComponent();
        Recipes();
    }

    private static void BasicComponent() {

        //  Plasma Containment Cell
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_UV)
                .input(stickLong, NaquadahAlloy)
                .input(plate, Osmiridium, 4)
                .inputs(GTLiteMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.TransparentCasingType.PMMA_GLASS, 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(PLASMA_CONTAINMENT_CELL)
                .EUt(VA[ZPM])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Separation Electromagnet
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MAGNETRON)
                .input(plate, NiobiumNitride, 4)
                .input(stickLong, VanadiumGallium)
                .input(foil, Polybenzimidazole, 8)
                .input(wireFine, YttriumBariumCuprate, 16)
                .fluidInputs(BlackSteel.getFluid(L * 2))
                .output(SEPARATION_ELECTROMAGNET)
                .EUt(VA[ZPM])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void Recipes() {

        //  Degenerate Rhenium
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(1000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plateDense, Rhenium)
                .inputs(GTLiteMetaBlocks.EXPLOSIVE_BLOCK.getItemVariant(BlockExplosive.ExplosiveType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getPlasma(10000))
                .EUt(VA[UXV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(PLASMA_CONTAINMENT_CELL)
                .fluidInputs(DegenerateRhenium.getPlasma(1000))
                .output(RHENIUM_PLASMA_CONTAINMENT_CELL)
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();
    }
}