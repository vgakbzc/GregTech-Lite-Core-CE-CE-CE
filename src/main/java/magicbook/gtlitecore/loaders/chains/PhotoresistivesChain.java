package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ELECTROLYZER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.CVD_UNIT_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class PhotoresistivesChain {

    public static void init() {
        GrignardReagentProcess();
        DimethylcadmiumProcess();
        CadmiumSulfideProcess();
        CadmiumSelenide();
    }

    private static void GrignardReagentProcess() {

        //  C4H10O2 -> C4H8O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1500))
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Mg + 2Cl -> MgCl2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Magnesium)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, MagnesiumChloride, 3)
                .EUt(VA[LV])
                .duration(2 * SECOND + 10)
                .buildAndRegister();

        //  MgCl2 + 2K -> Mg + 2KCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChloride, 3)
                .fluidInputs(Potassium.getFluid(L * 2))
                .fluidInputs(Tetrahydrofuran.getFluid(10))
                .output(dust, HRAMagnesium)
                .output(dust, RockSalt, 4)
                .EUt(VA[IV])
                .duration(7 * SECOND)
                .buildAndRegister();

        //  C2H4 + 2Br -> C2H4Br2
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(EthyleneDibromide.getFluid(3000))
                .EUt(VA[MV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Mg + C2H4Br2 -> CH3MgBr + HBr + C (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, HRAMagnesium)
                .fluidInputs(EthyleneDibromide.getFluid(3000))
                .fluidOutputs(GrignardReagent.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }

    private static void DimethylcadmiumProcess() {

        //  Cd + 2Br -> CdBr2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .fluidInputs(Bromine.getFluid(2000))
                .output(dust, CadmiumBromide, 3)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  CdBr2 + 2CH3MgBr -> (CH3)2Cd + 2MgBr2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CadmiumBromide, 3)
                .fluidInputs(GrignardReagent.getFluid(2000))
                .output(dust, MagnesiumBromide, 6)
                .fluidOutputs(Dimethylcadmium.getFluid(1000))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();
    }

    private static void CadmiumSulfideProcess() {

        //  2C2H4 + H2S -> C4H10S
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(2000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(DiethylSuflide.getFluid(3000))
                .EUt(VA[LV])
                .duration(7 * SECOND + 10)
                .buildAndRegister();

        //  C4H10S -> 2C2H4 + H2S
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .EUt(VA[ULV])
                .duration(17 * SECOND)
                .buildAndRegister();

        //  Cd(CH3)2 + C4H10S -> CdS + C2H6 + C4H10
        CVD_UNIT_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylcadmium.getFluid(1000))
                .fluidInputs(DiethylSuflide.getFluid(3000))
                .output(dust, CadmiumSulfide, 2)
                .fluidOutputs(Ethane.getFluid(1000))
                .fluidOutputs(Butane.getFluid(1000))
                .EUt(VA[LuV])
                .duration(4 * SECOND)
                .buildAndRegister();
    }

    private static void CadmiumSelenide() {

        //  2Al + 3Se -> Al2Se3
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 2)
                .input(dust, Selenium, 3)
                .output(dust, AluminiumSelenide, 5)
                .EUt(VA[LV])
                .duration(20 * SECOND)
                .buildAndRegister();

        //  Al2Se3 + 6H2O -> 2Al(OH)3 + 3H2Se
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AluminiumSelenide, 5)
                .fluidInputs(Water.getFluid(6000))
                .output(dust, AluminiumHydroxide, 14)
                .fluidOutputs(HydrogenSelenide.getFluid(3000))
                .EUt(VA[HV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  (CH3)2Cd + H2Se -> CdSe + 2CH4
        CVD_UNIT_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylcadmium.getFluid(1000))
                .fluidInputs(HydrogenSelenide.getFluid(1000))
                .output(dust, CadmiumSelenide, 2)
                .fluidOutputs(Methane.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(4 * SECOND)
                .buildAndRegister();
    }
}