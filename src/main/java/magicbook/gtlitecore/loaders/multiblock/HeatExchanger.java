package magicbook.gtlitecore.loaders.multiblock;

import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class HeatExchanger {

    public static void init() {

        //  Superheated Steam
        for (FluidStack stack : new FluidStack[]{
                Lava.getFluid(2000),
                // todo other high-temp fluid
        }) {
            HEAT_EXCHANGE_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(DistilledWater.getFluid(4000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(Steam.getFluid(4000))
                    .fluidOutputs(SuperheatedSteam.getFluid(2000))
                    .maxRate(16000)
                    .flowRate(20000)
                    .duration(20)
                    .buildAndRegister();
        }

        //  Supercritical Steam
        for (FluidStack stack : new FluidStack[]{
                Lava.getFluid(8000),
                // todo other high-temp fluid
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Ice.getFluid(4000),
                    GelidCryotheum.getFluid(2000)
            }) {
                HEAT_EXCHANGE_RECIPES.recipeBuilder()
                        .circuitMeta(2)
                        .fluidInputs(DistilledWater.getFluid(16000))
                        .fluidInputs(new FluidStack[]{stack})
                        .fluidInputs(new FluidStack[]{substack})
                        .fluidOutputs(Steam.getFluid(16000))
                        .fluidOutputs(SupercriticalSteam.getFluid(8000))
                        .maxRate(160000)
                        .flowRate(40000)
                        .duration(20)
                        .buildAndRegister();
            }
        }

        HIGH_PRESSURE_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SuperheatedSteam.getFluid(320))
                .fluidOutputs(DistilledWater.getFluid(64))
                .EUt((int) V[MV])
                .duration(10)
                .buildAndRegister();

        SUPERCRITICAL_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SupercriticalSteam.getFluid(640))
                .fluidOutputs(DistilledWater.getFluid(128))
                .EUt((int) V[EV])
                .duration(10)
                .buildAndRegister();
    }
}
