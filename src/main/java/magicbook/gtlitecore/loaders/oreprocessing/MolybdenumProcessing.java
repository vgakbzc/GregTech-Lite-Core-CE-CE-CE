package magicbook.gtlitecore.loaders.oreprocessing;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ARC_FURNACE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CENTRIFUGE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.INDUSTRIAL_ROASTER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

/**
 * The Molybdenum Process
 *
 * <p>
 *     Produces Molybdenum from Molybdenite, Powellite, or Wulfenite.
 *     Produces Rhenium from Molybdenite
 * </p>
 *
 * <p>Main Products: Molybdenum, Rhenium</p>
 * <p>Side Products: None</p>
 *
 * <p>3 Molybdenite -> 1 Molybdenum</p>
 * <p>6 Powellite/Wulfenite -> 1 Molybdenum</p>
 * <p>3 Molybdenite -> 1 Rhenium</p>
 */
public class MolybdenumProcessing {

    public static void init() {
        removeVanillaRecipes();
        MolybdenumChain();
        RheniumChain();
    }

    private static void removeVanillaRecipes() {
        if (GTLiteConfigHolder.recipes.enableHarderMolybdenumRheniumProcess) {
            GTRecipeHandler.removeRecipesByInputs(ARC_FURNACE_RECIPES,
                    new ItemStack[]{OreDictUnifier.get(dust, Molybdenite, 3)},
                    new FluidStack[]{Oxygen.getFluid(4000)});
        }
    }

    private static void MolybdenumChain() {

        //  MoS2 + 9O -> MoO3 + 2SO2 + ReO2
        INDUSTRIAL_ROASTER_RECIPES.recipeBuilder()
                .input(dust, Molybdenite, 3)
                .fluidInputs(Oxygen.getFluid(8000))
                .output(dust, MolybdenumTrioxide, 4)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .fluidOutputs(MolybdenumFlue.getFluid(1000))
                .temperature(1400)
                .duration(200)
                .EUt(VA[MV])
                .buildAndRegister();

        //  MoO3 + 6H -> Mo + 3H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Molybdenum)
                .fluidOutputs(Water.getFluid(3000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  CaMoO4 + 2HCl -> MoO3 + CaCl2 + H2O
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Powellite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        // PbMoO4 + 2HCl -> MoO3 + H2O + PbCl2
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Wulfenite, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, MolybdenumTrioxide, 4)
                .output(dust, LeadChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();
    }

    private static void RheniumChain() {

        //  Molybdenum Flue -> MoO3 + Rhenium Flue
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MolybdenumFlue.getFluid(1000))
                .output(dust, MolybdenumTrioxide)
                .fluidOutputs(TraceRheniumFlue.getFluid(500))
                .duration(200)
                .EUt(60)
                .buildAndRegister();

        //  ReO2 + Na2CO3 + NaOH + 3Cl -> HReO4 + 3NaCl + CO2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(TraceRheniumFlue.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, PerrhenicAcid, 6)
                .output(dust, Salt, 6)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  HReO4 + NH3 -> NH4ReO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PerrhenicAcid, 6)
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, AmmoniumPerrhenate, 10)
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();

        //  NH4ReO4 + H2S + Cl -> Re + NH4Cl + H2SO4 +
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumPerrhenate, 10)
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, Rhenium)
                .output(dust, AmmoniumChloride, 2)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}
