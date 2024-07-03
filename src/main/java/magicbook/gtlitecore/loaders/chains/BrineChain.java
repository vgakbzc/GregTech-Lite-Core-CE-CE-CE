package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class BrineChain {

    //  Complete Bromine-Iodine Chain
    //  in gcys, this is infinite bromine until Sodium Chloride Solution is separate from Salt Water.

    public static void init() {
        IodineChain();
        BromineChain();
    }

    private static void IodineChain() {

        //  KNO3 + HCl -> K + I?
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Saltpeter)
                .fluidInputs(SaltWater.getFluid(1000))
                .output(dust, Potassium)
                .fluidOutputs(IodizedBrine.getFluid(1000))
                .EUt(VA[EV])
                .duration(12 * SECOND)
                .temperature(1128)
                .buildAndRegister();

        //  I? + 0.3 Cl -> I?Cl
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(IodizedBrine.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(300))
                .fluidOutputs(IodineBrineMixture.getFluid(1300))
                .EUt(VHA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  I?Cl -> Br? + I?
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(IodineBrineMixture.getFluid(1300))
                .fluidOutputs(BrominatedBrine.getFluid(1000))
                .fluidOutputs(IodineSlurry.getFluid(300))
                .EUt(VA[HV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  I? -> I
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .fluidInputs(IodineSlurry.getFluid(1200))
                .output(dust, Iodine)
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void BromineChain() {

        //  Br? + H2SO4 -> Br?(H2SO4)
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BrominatedBrine.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(AcidicBrominatedBrine.getFluid(1000))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Br?(H2SO4) + SO2 + H2O -> H2SO4Br(H2O)Cl2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcidicBrominatedBrine.getFluid(1000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .circuitMeta(3)
                .fluidOutputs(BromineSulfateSolution.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  2H2SO4Br(H2O)Cl2 + H2O -> 3H2SO4Br(H2O)2Cl2
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(BromineSulfateSolution.getFluid(2000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(OverheatedBromineSulfateSolution.getFluid(3000))
                .temperature(2250)
                .EUt(VA[HV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  3H2SO4Br(H2O)2Cl2 -> Br(H2O) + H2O + 2Cl + H2SO4
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(OverheatedBromineSulfateSolution.getFluid(3000))
                .fluidOutputs(WetBromine.getFluid(1000))
                .fluidOutputs(DebrominatedWater.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(14 * SECOND)
                .buildAndRegister();

        //  Br(H2O) -> Br + H2O (lost)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .fluidInputs(WetBromine.getFluid(1000))
                .fluidOutputs(Bromine.getFluid(1000))
                .EUt(VHA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Salt Water recycle
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .fluidInputs(DebrominatedWater.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(100))
                .EUt(VH[HV])
                .duration(4 * SECOND)
                .buildAndRegister();
    }

}