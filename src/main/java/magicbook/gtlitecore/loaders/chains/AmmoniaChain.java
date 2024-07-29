package magicbook.gtlitecore.loaders.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.BREWING_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.RichAmmoniaMixture;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.RichNitrogenMixture;

public class AmmoniaChain {

    //  Minimized Haber-Bosch Process

    public static void init() {

        if (GTLiteConfigHolder.recipes.enableHarderAmmoniaProcess) {
            GTRecipeHandler.removeRecipesByInputs(CHEMICAL_RECIPES,
                    new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                    new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)});
            GTRecipeHandler.removeRecipesByInputs(LARGE_CHEMICAL_RECIPES,
                    new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(1)},
                    new FluidStack[]{Nitrogen.getFluid(1000), Hydrogen.getFluid(3000)});
        }

        //  CH4 + N -> CH4N
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Air.getFluid(1500))
                .fluidOutputs(RichNitrogenMixture.getFluid(2500))
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  CH4N + 2H2O -> NH4 + CH4 + O2 (lost)
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, GTLiteConfigHolder.recipes.enableHarderAmmoniaProcess ? Chrome : Ruthenium)
                .fluidInputs(RichNitrogenMixture.getFluid(2500))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(RichAmmoniaMixture.getFluid(GTLiteConfigHolder.recipes.enableHarderAmmoniaProcess ? 1000 : 3000))
                .fluidOutputs(Methane.getFluid(1000))
                .EUt(VA[MV])
                .duration(4 * SECOND)
                .buildAndRegister();

        //  NH4 -> NH3 + H (lost)
        BREWING_RECIPES.recipeBuilder()
                .notConsumable(dust, Magnetite)
                .fluidInputs(RichAmmoniaMixture.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(160)
                .EUt(VA[LV])
                .buildAndRegister();
    }
}
