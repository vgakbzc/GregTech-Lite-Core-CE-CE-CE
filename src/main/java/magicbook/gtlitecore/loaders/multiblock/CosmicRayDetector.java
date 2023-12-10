package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class CosmicRayDetector {

    public static void init() {

        //  Heavy Lepton
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidOutputs(HeavyLepton.getFluid(40))
                .Altitude(80)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();
    }
}
