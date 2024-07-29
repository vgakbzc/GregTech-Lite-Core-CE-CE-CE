package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.BREWING_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.VACUUM_CHAMBER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class KevlarChain {

    public static void init() {
        TerephthalicAcidChain();
        KevlarProcess();
    }

    private static void TerephthalicAcidChain() {

        //  Amoco Process for Terephthalic Acid

        //  4Br + C2H2 -> C2H2Br4
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(4000))
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidOutputs(Tetrabromoethane.getFluid(1000))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  C6H4(CH3)2 + 6O -> C6H4(CO2H)2 + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(foil, Titanium, 10)
                .notConsumable(dust, Manganese)
                .notConsumable(dust, Cobalt)
                .notConsumable(Acetone.getFluid())
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Tetrabromoethane.getFluid(50))
                .fluidInputs(Air.getFluid(12000))
                .output(dust, TerephthalicAcid, 3)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(12 * SECOND)
                .buildAndRegister();
    }

    private static void KevlarProcess() {

        // C6H4(CH3)2 + 6O -> C6H4(CO2H)2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(6000))
                .fluidOutputs(Bistrichloromethylbenzene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  C6H4(CCl3)2 + C6H4(CO2H)2 -> 2C6H4(COCl)2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TerephthalicAcid, 3)
                .fluidInputs(Bistrichloromethylbenzene.getFluid(1000))
                .output(dust, TerephthaloylChloride, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(VH[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  C4H8 + HClO + H2O -> C4H10O2 + HCl
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidInputs(HypochlorousAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Butanediol.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(3 * SECOND)
                .buildAndRegister();

        //  C4H10O2 -> C4H6O2 + 4H (4H lost)
        BREWING_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidOutputs(GammaButyrolactone.getFluid(1000))
                .EUt(VA[EV])
                .duration(6 * SECOND)
                .buildAndRegister();

        //  CH3NH2 + C4H6O2 -> C5H9NO + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methylamine.getFluid(1000))
                .fluidInputs(GammaButyrolactone.getFluid(1000))
                .fluidOutputs(NMethylPyrrolidone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[IV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  Ca + 2Cl -> CaCl2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Calcium)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, CalciumChloride, 3)
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  C6H4(NH2)2 + C6H4(COCl)2 -> [-CO-C6H4-CO-NH-C6H4-NH-]n + 2HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumChloride)
                .input(dust, ParaPhenylenediamine, 8)
                .input(dust, TerephthaloylChloride, 3)
                .fluidInputs(NMethylPyrrolidone.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Kevlar, 4)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .EUt(VA[UV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }
}