package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.GTValues.VH;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CRACKING_RECIPES;
import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.unification.material.Materials.Naphtha;
import static gregtech.api.unification.material.Materials.Steam;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.LeachedTurpentine;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.SteamCrackedTurpentine;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.Turpentine;

public class TurpentineChain {

    public static void init() {

        CHEMICAL_RECIPES.recipeBuilder()
                .input("logWood")
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(LeachedTurpentine.getFluid(1000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1000))
                .fluidInputs(LeachedTurpentine.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(SteamCrackedTurpentine.getFluid(1000))
                .EUt(VH[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedTurpentine.getFluid(1000))
                .fluidOutputs(Turpentine.getFluid(1000))
                .fluidOutputs(Naphtha.getFluid(1000))
                .EUt(VA[MV])
                .duration(6 * SECOND)
                .buildAndRegister();
    }
}
