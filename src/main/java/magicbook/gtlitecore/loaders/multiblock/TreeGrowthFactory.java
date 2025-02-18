package magicbook.gtlitecore.loaders.multiblock;

import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.Biomass;
import static gregtech.api.unification.material.Materials.Water;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.TREE_GROWTH_RECIPES;

public class TreeGrowthFactory {

    public static void init() {

        //  Oak
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 0))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 0))
                .outputs(new ItemStack(Items.APPLE, 1, 0))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 0))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 0))
                .outputs(new ItemStack(Items.APPLE, 2, 0))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 0))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 0))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 0))
                .outputs(new ItemStack(Items.APPLE, 4, 0))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Spruce
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 1))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 1))
                .outputs(new ItemStack(Items.APPLE, 1, 0))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 1))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 1))
                .outputs(new ItemStack(Items.APPLE, 2, 0))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 1))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 1))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 1))
                .outputs(new ItemStack(Items.APPLE, 4, 0))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Birch
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 2))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 2))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 2))
                .outputs(new ItemStack(Items.APPLE, 1, 0))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 2))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 2))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 2))
                .outputs(new ItemStack(Items.APPLE, 2, 0))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 2))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 2))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 2))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 2))
                .outputs(new ItemStack(Items.APPLE, 4, 0))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Jungle
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 3))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 8, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 4, 3))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 3))
                .outputs(new ItemStack(Items.DYE, 1, 3))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 3))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 16, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 8, 3))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 3))
                .outputs(new ItemStack(Items.DYE, 2, 3))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 3))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG, 32, 3))
                .outputs(new ItemStack(Blocks.LEAVES, 16, 3))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 3))
                .outputs(new ItemStack(Items.DYE, 4, 3))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Acacia
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 4))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 8, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 4, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 4))
                .outputs(new ItemStack(Items.APPLE, 1, 0))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 4))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 16, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 8, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 4))
                .outputs(new ItemStack(Items.APPLE, 2, 0))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 4))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 32, 0))
                .outputs(new ItemStack(Blocks.LEAVES2, 16, 0))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 4))
                .outputs(new ItemStack(Items.APPLE, 4, 0))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Dark Oak
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 1, 5))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 8, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 4, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 1, 5))
                .outputs(new ItemStack(Items.APPLE, 1, 0))
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 4, 5))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 16, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 8, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 2, 5))
                .outputs(new ItemStack(Items.APPLE, 2, 0))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING, 16, 5))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(Blocks.LOG2, 32, 1))
                .outputs(new ItemStack(Blocks.LEAVES2, 16, 1))
                .outputs(new ItemStack(Blocks.SAPLING, 4, 5))
                .outputs(new ItemStack(Items.APPLE, 4, 0))
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();

        //  Rubber
        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 8))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 4, 1))
                .outputs(new ItemStack(MetaBlocks.RUBBER_SAPLING, 1))
                .output(MetaItems.STICKY_RESIN, 1)
                .EUt(VA[LV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING, 4))
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 16))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 8, 1))
                .outputs(new ItemStack(MetaBlocks.RUBBER_SAPLING, 2))
                .output(MetaItems.STICKY_RESIN, 2)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        TREE_GROWTH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING, 16))
                .circuitMeta(3)
                .fluidInputs(Water.getFluid(200))
                .fluidInputs(Biomass.getFluid(200))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LOG, 32))
                .outputs(new ItemStack(MetaBlocks.RUBBER_LEAVES, 16, 1))
                .outputs(new ItemStack(MetaBlocks.RUBBER_SAPLING, 4))
                .output(MetaItems.STICKY_RESIN, 4)
                .EUt(VA[HV])
                .duration(100)
                .buildAndRegister();
    }
}