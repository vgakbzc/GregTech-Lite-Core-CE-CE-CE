package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class DragonChain {

    public static void init() {
        VanillaCompatibility();
    }

    private static void VanillaCompatibility() {

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH)
                .output(Items.GLASS_BOTTLE)
                .fluidOutputs(DragonBreath.getFluid(1000))
                .EUt(VA[HV])
                .duration(50)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(Items.GLASS_BOTTLE)
                .fluidInputs(DragonBreath.getFluid(1000))
                .output(Items.DRAGON_BREATH)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.DRAGON_EGG))
                .fluidInputs(DragonBreath.getFluid(1000))
                .fluidOutputs(ConcentrateDragonBreath.getFluid(1000))
                .EUt(VA[IV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        SONICATION_RECIPES.recipeBuilder()
                .fluidInputs(ConcentrateDragonBreath.getFluid(200))
                .fluidInputs(Radon.getFluid(1000))
                .chancedOutput(dust, Endstone, 2000, 0)
                .fluidOutputs(DragonBlood.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
