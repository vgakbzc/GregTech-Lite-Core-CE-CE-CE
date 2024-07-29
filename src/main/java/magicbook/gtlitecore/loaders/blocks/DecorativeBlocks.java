package magicbook.gtlitecore.loaders.blocks;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.common.items.MetaItems;
import magicbook.gtlitecore.common.blocks.BlockDecorativeTransparentCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ALLOY_SMELTER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Abyssalloy;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.HeavyQuarkDegenerateMatter;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Mithril;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.TranscendentMetal;

public class DecorativeBlocks {

    public static void init() {

        //  Borosilicate Glass
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .fluidInputs(BorosilicateGlass.getFluid(L * 4))
                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Titanium reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Titanium, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TITANIUM_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Tungsten reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Tungsten, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TUNGSTEN_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Osmium reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Osmium, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.OSMIUM_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[LuV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Naquadah reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Naquadah, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.NAQUADAH_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Trinium reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Trinium, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TRINIUM_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Mithril reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Mithril, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.MITHRIL_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[UHV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Neutronium reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Neutronium, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.NEUTRONIUM_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[UEV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Abyssalloy reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, Abyssalloy, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.ABYSSALLOY_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[UIV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Heavy Quark Degenerate Matter reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, HeavyQuarkDegenerateMatter, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.HEAVY_QUARK_DEGENERATE_MATTER_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[UXV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Transcendent Metal reinforced Borosilicate Glass
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.BOROSILICATE_GLASS))
                .input(plate, TranscendentMetal, 4)
                .outputs(GTLiteMetaBlocks.DECORATIVE_TRANSPARENT_CASING.getItemVariant(BlockDecorativeTransparentCasing.DecorativeTransparentCasingType.TRANSCENDENT_METAL_REINFORCED_BOROSILICATE_GLASS))
                .EUt(VA[OpV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }
}
