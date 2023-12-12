package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class DecayGenerator {

    public static void init() {

        //  Alpha particle
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(32000))
                .chancedOutput(ALPHA_PARTICLE, 1000, 0)
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium3.getFluid(16000))
                .chancedOutput(ALPHA_PARTICLE, 4000, 0)
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getPlasma(4000))
                .chancedOutput(ALPHA_PARTICLE, 8000, 0)
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Flerovium-Ytterbium Plasma
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(QuasifissioningPlasma.getPlasma(1000))
                .fluidOutputs(FleroviumYtterbiumPlasma.getPlasma(1000))
                .EUt(VA[ZPM])
                .duration(160)
                .CasingTier(1)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(FleroviumYtterbiumPlasma.getPlasma(1000))
                .fluidOutputs(MetastableFlerovium.getFluid(L * 2))
                .fluidOutputs(Ytterbium.getFluid(L * 2))
                .EUt(VA[EV])
                .duration(290)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableFlerovium.getFluid(144)});

        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableFlerovium.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableFlerovium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Ytterbium -> Hafnium
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Ytterbium.getFluid(L))
                .fluidOutputs(Hafnium.getFluid(L))
                .EUt(VA[LuV])
                .duration(120)
                .CasingTier(1)
                .buildAndRegister();

        //  Actinium -> Francium
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Actinium.getFluid(L))
                .fluidOutputs(Francium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(100)
                .CasingTier(2)
                .buildAndRegister();

        //  Molybdenum -> Technetium
        DECAY_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(Molybdenum.getFluid(L))
                .fluidOutputs(Technetium.getFluid(L))
                .EUt(VA[IV])
                .duration(100)
                .CasingTier(1)
                .buildAndRegister();
    }
}
