package magicbook.gtlitecore.loaders;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class FusionLoader {

    public static void init() {

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
                .EUToStart(150000000L)
                .buildAndRegister();
    }
}