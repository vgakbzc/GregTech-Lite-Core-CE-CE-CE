package magicbook.gtlitecore.loaders.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_INGOT;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class FullereneChain {

    public static void init() {
        TruxeneChain();
        NaphthaleneChain();
        ButyllitiumChain();
        PalladiumAcetateChain();
        FullereneProcess();
    }

    private static void TruxeneChain() {

        BREWING_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(CoalTar.getFluid(1000))
                .fluidOutputs(SodioIndene.getFluid(1000))
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(SodioIndene.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedSodioIndene.getFluid(1000))
                .EUt(VA[IV])
                .duration(8 * SECOND)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedSodioIndene.getFluid(1000))
                .output(dust, Sodium)
                .fluidOutputs(Indene.getFluid(1000))
                .EUt(VA[IV])
                .duration(12 * SECOND)
                .buildAndRegister();

        //  C9H8 + O -> C9H8O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Indene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, Indanone, 3)
                .EUt(VA[IV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  3C9H8O -> C27H18 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Indanone, 9)
                .notConsumable(HydrochloricAcid.getFluid())
                .notConsumable(AceticAcid.getFluid())
                .fluidOutputs(Truxene.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[EV])
                .duration(24 * SECOND)
                .buildAndRegister();
    }

    private static void NaphthaleneChain() {

        //  CH4 + 2Br -> CH3Br + HBr
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(Bromomethane.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .EUt(VA[LV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  CH3OH + HBr -> CH3Br + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(HydrobromicAcid.getFluid(1000))
                .fluidOutputs(Bromomethane.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[LV])
                .duration(8 * SECOND)
                .buildAndRegister();

        // C10H8 + 2CH3Br -> C11H8Br2 + CH4 + 2H (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Naphthalene.getFluid(1000))
                .fluidInputs(Bromomethane.getFluid(2000))
                .fluidOutputs(BromoBromomethylNaphthalene.getFluid(1000))
                .fluidOutputs(Methane.getFluid(1000))
                .EUt(VA[IV])
                .duration(16 * SECOND)
                .buildAndRegister();
    }

    private static void ButyllitiumChain() {

        //  C4H8O + 2H -> C4H10O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Butanol.getFluid(1000))
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Anti-Markovnikov Reaction

        //  C4H10O + HBr -> C4H9Br + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butanol.getFluid(1000))
                .fluidInputs(HydrobromicAcid.getFluid(1000))
                .fluidOutputs(Bromobutane.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //  Li + C4H9Br -> C4H9Li + Br
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Lithium)
                .notConsumable(dust, Sodium)
                .fluidInputs(Bromobutane.getFluid(1000))
                .fluidOutputs(Butyllithium.getFluid(1000))
                .fluidOutputs(Bromine.getFluid(1000))
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .buildAndRegister();
    }

    private static void PalladiumAcetateChain() {

        // Pd + 2HNO3 -> Pd(NO3)2 + 2H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Palladium)
                .fluidInputs(NitricAcid.getFluid(2000))
                .output(dust, PalladiumNitrate, 9)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .EUt(VA[MV])
                .duration(10 * SECOND)
                .buildAndRegister();

        // Pd(NO3)2 + 2CH3COOH -> Pd(CH3COOH)2 + 2HNO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumNitrate, 9)
                .fluidInputs(AceticAcid.getFluid(2000))
                .output(dust, PalladiumAcetate, 5)
                .fluidOutputs(NitricAcid.getFluid(2000))
                .EUt(VA[EV])
                .duration(2 * SECOND + 10)
                .buildAndRegister();
    }

    private static void FullereneProcess() {

        //  C27H18 + 3C11H8Br2 -> C60H30 + 2HBr + 10H
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumAcetate)
                .fluidInputs(Truxene.getFluid(1000))
                .fluidInputs(BromoBromomethylNaphthalene.getFluid(3000))
                .fluidInputs(Butyllithium.getFluid(10))
                .output(dust, GeodesicPolyarene, 60)
                .fluidOutputs(HydrobromicAcid.getFluid(2000))
                .fluidOutputs(Hydrogen.getFluid(10000))
                .EUt(VA[UHV])
                .duration(30 * SECOND)
                .buildAndRegister();

        //  C60H30 -> C60 + 30H
        PYROLYSE_RECIPES.recipeBuilder()
                .input(dust, GeodesicPolyarene)
                .notConsumable(foil, Platinum)
                .output(dust, Fullerene)
                .fluidOutputs(Hydrogen.getFluid(500))
                .EUt(VA[UHV])
                .duration(10)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .input(dust, Fullerene)
                .notConsumable(SHAPE_EXTRUDER_INGOT)
                .output(ingot, Fullerene)
                .EUt(VHA[HV])
                .duration(20 * SECOND)
                .buildAndRegister();
    }
}
