package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.LuV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.MINUTE;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Alumina;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Methylamine;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.MethylamineMixture;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Trimethylamine;

public class MethylamineChain {

    public static void init() {

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Kyanite)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .EUt(VA[HV])
                .duration(MINUTE - 10 * SECOND)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina)
                .input(dust, SiliconDioxide)
                .fluidInputs(Methanol.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(MethylamineMixture.getFluid(3000))
                .EUt(VA[HV])
                .duration(MINUTE - 10 * SECOND)
                .buildAndRegister();

        //  6CH3OH + 3NH3 -> CH3NH2 + (CH3)2NH2 + (CH3)3NH2 + 3H2O
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylamineMixture.getFluid(9000))
                .fluidOutputs(Methylamine.getFluid(1000))
                .fluidOutputs(Dimethylamine.getFluid(1000))
                .fluidOutputs(Trimethylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[LuV])
                .duration(MINUTE - 10 * SECOND)
                .disableDistilleryRecipes()
                .buildAndRegister();
    }
}
