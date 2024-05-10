package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.GTLiteValues.VZ;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PLASMA_FUSION_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class DimensionallyTranscendentNeutroniumForge {

    public static void init() {

        //  Crude Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidOutputs(CrudeDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Prosaic Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidOutputs(ProsaicDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Resplendent Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidOutputs(ResplendentDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Exotic Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .fluidInputs(Bismuth.getPlasma(1000))
                .fluidInputs(Oxygen.getPlasma(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidOutputs(ExoticDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Zenith Dimensionally Transcendent Catalyst
        PLASMA_FUSION_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidInputs(Helium.getPlasma(1000))
                .fluidInputs(Iron.getPlasma(1000))
                .fluidInputs(Calcium.getPlasma(1000))
                .fluidInputs(Niobium.getPlasma(1000))
                .fluidInputs(Radon.getPlasma(1000))
                .fluidInputs(Nickel.getPlasma(1000))
                .fluidInputs(Boron.getPlasma(1000))
                .fluidInputs(Sulfur.getPlasma(1000))
                .fluidInputs(Nitrogen.getPlasma(1000))
                .fluidInputs(Zinc.getPlasma(1000))
                .fluidInputs(Silver.getPlasma(1000))
                .fluidInputs(Titanium.getPlasma(1000))
                .fluidInputs(Americium.getPlasma(1000))
                .fluidInputs(Bismuth.getPlasma(1000))
                .fluidInputs(Oxygen.getPlasma(1000))
                .fluidInputs(Tin.getPlasma(1000))
                .fluidInputs(Xenon.getPlasma(1000))
                .fluidInputs(Lead.getPlasma(1000))
                .fluidInputs(Thorium.getPlasma(1000))
                .fluidInputs(Plutonium241.getPlasma(1000))
                .fluidOutputs(ZenithDimensionallyTranscendentCatalyst.getFluid(1000))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }
}
