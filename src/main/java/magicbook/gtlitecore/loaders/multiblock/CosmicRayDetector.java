package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.UHV;
import static gregtech.api.GTValues.V;
import static gregtech.api.GTValues.VA;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.COSMIC_RAY_DETECTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.HeavyLepton;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.StarlightLiquid;

public class CosmicRayDetector {

    public static void init() {

        //  Easy Starlight Liquid recipe
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(0)
                .fluidOutputs(StarlightLiquid.getFluid(100))
                .EUt(VA[UHV])
                .duration(1)
                .altitude(100)
                .buildAndRegister();

        //  Heavy Lepton
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidOutputs(HeavyLepton.getFluid(40))
                .EUt((int) V[UHV])
                .duration(1)
                .altitude(80)
                .buildAndRegister();
    }
}
