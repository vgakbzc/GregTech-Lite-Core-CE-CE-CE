package magicbook.gtlitecore.loaders.chains;

import magicbook.gtlitecore.common.GTLiteConfigHolder;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.COMBUSTION_GENERATOR_FUELS;
import static gregtech.api.recipes.RecipeMaps.FUSION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.IMPLOSION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CATALYTIC_REFORMER_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.ELECTRIC_IMPLOSION_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.HIGH_DENSITY_PLUTONIUM;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.HIGH_DENSITY_THORIUM;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.HIGH_DENSITY_URANIUM;

public class OilChain {

    public static void init() {
        CatalyticReformerRecipes();
        ThoriumBasedLiquidFuelChain();
        UraniumBasedLiquidFuelChain();
        PlutoniumBasedLiquidFuelChain();
    }

    private static void CatalyticReformerRecipes() {
        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Platinum)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(60))
                .fluidOutputs(Benzene.getFluid(200))
                .fluidOutputs(ParaXylene.getFluid(350))
                .fluidOutputs(Ethylbenzene.getFluid(200))
                .EUt(VA[MV])
                .duration(6 * SECOND)
                .buildAndRegister();

        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(120))
                .fluidOutputs(Benzene.getFluid(400))
                .fluidOutputs(ParaXylene.getFluid(700))
                .fluidOutputs(Ethylbenzene.getFluid(400))
                .EUt(VA[MV])
                .duration(6 * SECOND)
                .buildAndRegister();
    }

    private static void ThoriumBasedLiquidFuelChain() {

        //  12Th + U-235 + 3C -> Th12UC3
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Thorium, 12)
                .input(dust, Uranium235)
                .input(dust, Carbon, 3)
                .circuitMeta(4)
                .output(dust, UraniumThoriumCarbides, 16)
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  High Density Thorium
        IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, UraniumThoriumCarbides, 64)
                .input(foil, TungstenSteel, 16)
                .output(HIGH_DENSITY_THORIUM)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .explosivesAmount(32)
                .buildAndRegister();

        ELECTRIC_IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, UraniumThoriumCarbides, 64)
                .input(foil, TungstenSteel, 16)
                .output(HIGH_DENSITY_THORIUM)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();


        //  High Density Thorium + 4Li + 2Ba + Hg -> Th64Li4Ba2Hg
        MIXER_RECIPES.recipeBuilder()
                .input(HIGH_DENSITY_THORIUM)
                .input(dust, Lithium, 4)
                .input(dust, Barium, 2)
                .circuitMeta(4)
                .fluidInputs(Mercury.getFluid(1000))
                .fluidOutputs(ThoriumBasedLiquidFuel.getFluid(1000))
                .EUt(VA[IV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  Th64Li4Ba2Hg Combustion Generator Recipe
        COMBUSTION_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(ThoriumBasedLiquidFuel.getFluid(10))
                .EUt(GTLiteConfigHolder.misc.heatValueThoriumBasedLiquidFuel)
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  Th64Li4Ba2Hg -> *Th64Li4Ba2Hg*
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(ThoriumBasedLiquidFuel.getFluid(1000))
                .fluidInputs(Helium.getPlasma(250))
                .fluidOutputs(ExcitedThoriumBasedLiquidFuel.getFluid(L))
                .EUt(VA[IV])
                .duration(SECOND)
                .EUToStart(120000000L) // MK1
                .buildAndRegister();

        //  *Th64Li4Ba2Hg* Naquadah Reactor Recipe
        //  back to Taranium Processing class.
    }

    private static void UraniumBasedLiquidFuelChain() {

        //  3C + U-238 -> C3U
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Graphite, 3)
                .input(dust, Uranium238)
                .circuitMeta(2)
                .output(dust, GraphiteUraniumMixture, 4)
                .EUt(VA[MV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  High Density Uranium
        IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, GraphiteUraniumMixture, 36)
                .input(foil, TungstenCarbide, 16)
                .output(HIGH_DENSITY_URANIUM)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .explosivesAmount(32)
                .buildAndRegister();

        ELECTRIC_IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, GraphiteUraniumMixture, 36)
                .input(foil, TungstenCarbide, 16)
                .output(HIGH_DENSITY_URANIUM)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  High Density Uranium + 8K + 4Nq + Rn -> U36K8Nq4Rn
        MIXER_RECIPES.recipeBuilder()
                .input(HIGH_DENSITY_URANIUM)
                .input(dust, Potassium, 8)
                .input(dust, Naquadah, 4)
                .circuitMeta(4)
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(UraniumBasedLiquidFuel.getFluid(1000))
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  U36K8Nq4Rn Combustion Generator Recipe
        COMBUSTION_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(UraniumBasedLiquidFuel.getFluid(10))
                .EUt(GTLiteConfigHolder.misc.heatValueUraniumBasedLiquidFuel)
                .duration(5 * SECOND)
                .buildAndRegister();

        //  U36K8Nq4Rn -> *U36K8Nq4Rn*
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(UraniumBasedLiquidFuel.getFluid(1000))
                .fluidInputs(Argon.getPlasma(250))
                .fluidOutputs(ExcitedUraniumBasedLiquidFuel.getFluid(L))
                .EUt(VA[LuV])
                .duration(SECOND)
                .EUToStart(240000000L) // MK2
                .buildAndRegister();

        //  *U36K8Nq4Rn* Naquadah Reactor recipe
        //  back to Taranium Processing class.
    }

    private static void PlutoniumBasedLiquidFuelChain() {

        //  10Pu-239 + 2U-238 + 8C + 12O -> Pu10O12U2C8
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Plutonium239, 10)
                .input(dust, Uranium238, 2)
                .input(dust, Carbon, 8)
                .circuitMeta(4)
                .fluidInputs(Oxygen.getFluid(12000))
                .output(dust, PlutoniumUraniumOxides, 32)
                .EUt(VA[HV])
                .duration((int) (2.5 * SECOND))
                .buildAndRegister();

        //  High Density Plutonium
        IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, PlutoniumUraniumOxides, 64)
                .input(foil, HSSS, 16)
                .output(HIGH_DENSITY_PLUTONIUM)
                .EUt(VA[ZPM])
                .duration(10 * SECOND)
                .explosivesAmount(32)
                .buildAndRegister();

        ELECTRIC_IMPLOSION_RECIPES.recipeBuilder()
                .input(dust, PlutoniumUraniumOxides, 64)
                .input(foil, HSSS, 16)
                .output(HIGH_DENSITY_PLUTONIUM)
                .EUt(VA[ZPM])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  High Density Plutonium + 8Rb + 16Cs + 2Nq+ -> Pu64Rb8Cs16Nq+2
        MIXER_RECIPES.recipeBuilder()
                .input(HIGH_DENSITY_PLUTONIUM)
                .input(dust, Rubidium, 8)
                .input(dust, Caesium, 16)
                .input(dust, NaquadahEnriched, 2)
                .circuitMeta(4)
                .fluidOutputs(PlutoniumBasedLiquidFuel.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Pu64Rb8Cs16Nq+2 Combustion Generator Recipe
        COMBUSTION_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(PlutoniumBasedLiquidFuel.getFluid(10))
                .EUt(GTLiteConfigHolder.misc.heatValuePlutoniumBasedLiquidFuel)
                .duration((int) (7.5 * SECOND))
                .buildAndRegister();

        //  Pu64Rb8Cs16Nq+2 -> *Pu64Rb8Cs16Nq+2*
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(PlutoniumBasedLiquidFuel.getFluid(1000))
                .fluidInputs(Xenon.getPlasma(250))
                .fluidOutputs(ExcitedPlutoniumBasedLiquidFuel.getFluid(L))
                .EUt(VA[ZPM])
                .duration(SECOND)
                .EUToStart(360000000L) // MK3
                .buildAndRegister();

        //  *Pu64Rb8Cs16Nq+2* Naquadah Reactor recipe
        //  back to Taranium Processing class

    }

}