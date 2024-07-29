package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.VH;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.Acetone;
import static gregtech.api.unification.material.Materials.Ammonia;
import static gregtech.api.unification.material.Materials.Methanol;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.AcetoneCyanohydrin;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.PMMA;

public class PMMAChain {

    public static void init() {

        //  (CH3)2CO + HCN -> C4H7NO
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(AcetoneCyanohydrin.getFluid(2000))
                .EUt(VH[HV])
                .duration(7 * SECOND + 10)
                .buildAndRegister();

        //  C4H7NO + CH3OH -> C5H8O2 + NH3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcetoneCyanohydrin.getFluid(2000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(PMMA.getFluid(L * 4))
                .fluidOutputs(Ammonia.getFluid(1000))
                .EUt(VH[HV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }
}
