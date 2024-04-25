package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumCyanide;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.BURNER_REACTOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class EDTAChain {

    public static void init() {

        //  C2H4 + 2Cl -> C2H4Cl2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .notConsumable(Iron3Chloride.getFluid(1))
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  Cu + 2Cl -> CuCl2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, CopperChloride, 3)
                .EUt(VA[LV])
                .duration(2 * SECOND)
                .buildAndRegister();

        //  C2H4 + 2HCl -> C2H4Cl2 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .notConsumable(dust, CopperChloride)
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  C2H4Cl2 -> C2H3Cl + HCl
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .circuitMeta(1)
                .fluidOutputs(VinylChloride.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[MV])
                .duration(2 * SECOND)
                .temperature(773)
                .buildAndRegister();

        //  C2H4Cl2 + 2NH3 -> C2H4(NH2)2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Ethylenediamine.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VA[HV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  NaOH + HCN -> NaCN + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .outputs(SodiumCyanide.getItemStack(3))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  CH3OH -> CH2O + 2H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, Silver)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[HV])
                .duration(9 * SECOND)
                .temperature(923)
                .buildAndRegister();

        //  C2H4(NH2)2 + 4CH2O + 4NaCN + 6H2O -> C10H12Na4N2O8 + 4NH3 + 2O
        CHEMICAL_RECIPES.recipeBuilder()
                .inputs(SodiumCyanide.getItemStack(12))
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(4000))
                .fluidInputs(Water.getFluid(4000))
                .output(dust, TetrasodiumEDTA)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .EUt(VA[HV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  C10H12Na4N2O8 + 4HCl -> C10H16N2O8 + 4NaCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TetrasodiumEDTA)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .output(dust, EthylenediaminetetraaceticAcid, 32)
                .output(dust, Salt, 8)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }
}
