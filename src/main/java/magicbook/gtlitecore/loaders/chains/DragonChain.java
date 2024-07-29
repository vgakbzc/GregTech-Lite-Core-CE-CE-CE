package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CANNER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.EXTRACTOR_RECIPES;
import static gregtech.api.unification.material.Materials.Endstone;
import static gregtech.api.unification.material.Materials.Radon;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.SONICATION_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.ConcentrateDragonBreath;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.DragonBlood;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.DragonBreath;

public class DragonChain {

    public static void init() {

        //  Compatibility of Vanilla Dragon Breath (bottle?)
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH)
                .output(Items.GLASS_BOTTLE)
                .fluidOutputs(DragonBreath.getFluid(1000))
                .EUt(VA[HV])
                .duration(2 * SECOND + 10)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(Items.GLASS_BOTTLE)
                .fluidInputs(DragonBreath.getFluid(1000))
                .output(Items.DRAGON_BREATH)
                .EUt(VA[ULV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Dragon breath -> Concentrate Dragon Breath
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.DRAGON_EGG))
                .fluidInputs(DragonBreath.getFluid(1000))
                .fluidOutputs(ConcentrateDragonBreath.getFluid(1000))
                .EUt(VA[IV])
                .duration(10 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Concentrate Dragon Breath + Rn -> Dragon Blood
        //  This is a material for Hypogen's fusion recipe, another material is Rhugnor.
        //  TODO rebalanced it.
        SONICATION_RECIPES.recipeBuilder()
                .fluidInputs(ConcentrateDragonBreath.getFluid(200))
                .fluidInputs(Radon.getFluid(1000))
                .chancedOutput(dust, Endstone, 2000, 0)
                .fluidOutputs(DragonBlood.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(20 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
