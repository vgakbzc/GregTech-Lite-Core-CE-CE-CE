package magicbook.gtlitecore.loaders.multiblock;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.SIMULATOR_RECIPES;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class Simulator {

    public static void init() {
        Simulation();
        BiowareSimulation();
    }

    private static void Simulation() {

        //  LV: Zombie, Skeleton, Creeper, Slime, Spider
        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ZOMBIE)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.ROTTEN_FLESH, 64), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ZOMBIE)
                .circuitMeta(2)
                .chancedOutput(ingot, Iron, 16, 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ZOMBIE)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.CARROT, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ZOMBIE)
                .circuitMeta(4)
                .chancedOutput(new ItemStack(Items.POTATO, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ZOMBIE)
                .circuitMeta(5)
                .chancedOutput(new ItemStack(Items.SKULL, 16, 2), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SKELETON)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.BONE, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SKELETON)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.ARROW, 64), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SKELETON)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.SKULL, 16, 0), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SKELETON)
                .circuitMeta(4)
                .chancedOutput(ingot, Tin, 16, 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_CREEPER)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.GUNPOWDER, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_CREEPER)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.COAL, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_CREEPER)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.SKULL, 16, 4), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SLIME)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.SLIME_BALL, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SLIME)
                .circuitMeta(2)
                .chancedOutput(ingot, Nickel, 16, 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SPIDER)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.SPIDER_EYE, 64), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SPIDER)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.STRING, 32), 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SPIDER)
                .circuitMeta(3)
                .chancedOutput(ingot, Copper, 16, 1000, 100)
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        //  MV: Blaze, Ghast, Guardian, Wither Skeleton, Witch
        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_BLAZE)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.BLAZE_ROD, 16), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_BLAZE)
                .circuitMeta(2)
                .chancedOutput(dust, Sulfur, 32, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_BLAZE)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.MAGMA_CREAM, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GHAST)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.GHAST_TEAR, 32), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GHAST)
                .circuitMeta(2)
                .chancedOutput(ingot, Silver, 16, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GUARDIAN)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.PRISMARINE_SHARD, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GUARDIAN)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.PRISMARINE_CRYSTALS, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GUARDIAN)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.FISH, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GUARDIAN)
                .circuitMeta(4)
                .chancedOutput(ingot, Gold, 16, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_GUARDIAN)
                .circuitMeta(5)
                .chancedOutput(dust, Aluminium, 16, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.SKULL, 16, 1), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                .circuitMeta(2)
                .chancedOutput(ingot, Lead, 16, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITHER_SKELETON)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Blocks.SOUL_SAND, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITCH)
                .circuitMeta(1)
                .chancedOutput(dust, Redstone, 32, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITCH)
                .circuitMeta(2)
                .chancedOutput(dust, Glowstone, 32, 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITCH)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Items.SUGAR, 64), 1000, 100)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        //  HV: Enderman, Shulker
        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ENDERMAN)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.ENDER_PEARL, 16), 1000, 100)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ENDERMAN)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.EMERALD, 16), 1000, 100)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ENDERMAN)
                .circuitMeta(3)
                .chancedOutput(new ItemStack(Blocks.END_STONE, 32), 1000, 100)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SHULKER)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.SHULKER_SHELL, 16), 1000, 100)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_SHULKER)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Items.DIAMOND, 16), 1000, 100)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        //  EV: Wither
        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_WITHER)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.NETHER_STAR), 1000, 100)
                .EUt(VA[EV])
                .duration(1200)
                .buildAndRegister();

        //  IV: Ender Dragon
        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ENDER_DRAGON)
                .circuitMeta(1)
                .chancedOutput(new ItemStack(Items.DRAGON_BREATH, 32), 1000, 100)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        SIMULATOR_RECIPES.recipeBuilder()
                .notConsumable(MEMORY_CARD_ENDER_DRAGON)
                .circuitMeta(2)
                .chancedOutput(new ItemStack(Blocks.DRAGON_EGG), 1000, 100)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();
    }

    private static void BiowareSimulation() {

    }
}
