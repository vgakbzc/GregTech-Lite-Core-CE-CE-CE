package magicbook.gtlitecore.loaders;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class FusionLoader {

    public static void init() {
        Elements();
        FantasyMaterials();
    }

    private static void Elements() {

        //  Americium + Neon -> Dubnium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Dubnium.getFluid(125))
                .EUt(VA[ZPM])
                .duration(160)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  Plutonium-241 + Neon -> Rutherfordium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Rutherfordium.getFluid(16))
                .EUt(VA[LuV])
                .duration(120)
                .EUToStart(250000000L)
                .buildAndRegister();

        //  Plutonium-241 + Titanium -> Livermorium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(32))
                .fluidInputs(Titanium.getFluid(32))
                .fluidOutputs(Livermorium.getFluid(64))
                .EUt(VA[UHV])
                .duration(200)
                .EUToStart(850000000L)
                .buildAndRegister();

        //  Plutonium-241 + Calcium -> Seaborgium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium241.getFluid(16))
                .fluidInputs(Calcium.getFluid(32))
                .fluidOutputs(Seaborgium.getFluid(48))
                .EUt(VA[UV])
                .duration(220)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Oganesson Breeding Base + Curium -> Hot Oganesson
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(OganessonBreedingBase.getFluid(L))
                .fluidInputs(Curium.getFluid(36))
                .fluidOutputs(MetastableOganesson.getFluid(L))
                .EUt(VA[UHV])
                .duration(100)
                .EUToStart(700000000L)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableOganesson.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableOganesson)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Fl-Yb Plasma Prechain (back to decay generator recipes)
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Uranium238.getFluid(125))
                .fluidInputs(Uranium238.getFluid(125))
                .fluidOutputs(QuasifissioningPlasma.getPlasma(125))
                .EUt(600000)
                .duration(100)
                .EUToStart(250000000L)
                .buildAndRegister();

        //  Metastable Hassium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(ScandiumTitaniumMixture.getFluid(L * 2))
                .fluidInputs(RadiumRadonMixture.getFluid(1000))
                .fluidOutputs(MetastableHassium.getFluid(L * 4))
                .EUt(VA[UEV])
                .duration(80)
                .EUToStart(900000000L)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableHassium.getFluid(144)});

        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableHassium.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableHassium)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();
    }

    private static void FantasyMaterials() {

        //  Nether Star + Bedrock -> Ichor Liquid
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(NetherStar.getFluid(L))
                .fluidInputs(Bedrock.getFluid(1000))
                .fluidOutputs(IchorLiquid.getPlasma(L * 4))
                .EUt(VA[UHV])
                .duration(45)
                .EUToStart(650000000L)
                .buildAndRegister();

        //  Ichor Liquid + Radon -> Ichorium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(IchorLiquid.getPlasma(L))
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(Ichorium.getFluid(500))
                .EUt(VA[UEV])
                .duration(100)
                .EUToStart(1200000000L)
                .buildAndRegister();

        //  Orichalcum + Zirconium -> Mithril
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(16))
                .fluidInputs(Zirconium.getFluid(L * 4))
                .fluidOutputs(Mithril.getPlasma(L * 4))
                .EUt(VA[UV])
                .duration(60)
                .EUToStart(450000000L)
                .buildAndRegister();

        //  Vibranium + Duranium -> Crystal Matrix
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Vibranium.getPlasma(16))
                .fluidInputs(Duranium.getFluid(L * 2))
                .fluidOutputs(CrystalMatrix.getFluid(L * 2))
                .EUt(VA[UHV])
                .duration(120)
                .EUToStart(800000000L)
                .buildAndRegister();

        //  Crystal Matrix + Mithril -> Infinity
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(CrystalMatrix.getFluid(L * 2))
                .fluidInputs(Mithril.getFluid(L * 2))
                .fluidOutputs(Infinity.getFluid(L * 4))
                .EUt(VA[UEV])
                .duration(240)
                .EUToStart(2560000000L)
                .buildAndRegister();

        //  Void Metal + Bedrock -> Rhugnor
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(VoidMetal.getFluid(L * 2))
                .fluidInputs(Bedrock.getFluid(1000))
                .fluidOutputs(Rhugnor.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(160)
                .EUToStart(900000000L)
                .buildAndRegister();

        //  Dragon Blood + Rhugnor -> Hypogen
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(DragonBlood.getFluid(L * 4))
                .fluidInputs(Rhugnor.getFluid(L * 4))
                .fluidOutputs(Hypogen.getPlasma(L * 8))
                .EUt(VA[UEV])
                .duration(320)
                .EUToStart(2530000000L)
                .buildAndRegister();

        //  Neon + Bedrock -> Taranium plasma
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Neon.getFluid(L))
                .fluidInputs(Bedrock.getFluid(L))
                .fluidOutputs(Taranium.getPlasma(L * 2))
                .EUt(VA[UV])
                .duration(64)
                .EUToStart(360000000L)
                .buildAndRegister();

        //  Titanium + Taranium plasma -> Astral Titanium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Titanium.getFluid(L * 2))
                .fluidInputs(Taranium.getPlasma(L * 2))
                .fluidOutputs(AstralTitanium.getPlasma(L * 4))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(1800000000L)
                .buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Tungsten.getFluid(L * 2))
                .fluidInputs(Taranium.getPlasma(L * 2))
                .fluidOutputs(CelestialTungsten.getPlasma(L * 4))
                .EUt(VA[UEV])
                .duration(32)
                .EUToStart(1800000000L)
                .buildAndRegister();

        //  Curium + Sodium -> Bohrium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Curium.getFluid(L * 2))
                .fluidInputs(Sodium.getFluid(L * 2))
                .fluidOutputs(Bohrium.getFluid(L * 4))
                .EUt(VA[UHV])
                .duration(140)
                .EUToStart(800000000L)
                .buildAndRegister();
    }
}