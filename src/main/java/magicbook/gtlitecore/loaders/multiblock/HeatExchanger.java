package magicbook.gtlitecore.loaders.multiblock;

import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class HeatExchanger {

    public static void init() {

        //  Lava
        for (FluidStack stack : new FluidStack[] {
                Lava.getFluid(1),
                Helium.getPlasma(1),                     // Mark 1 Fusion
                Nitrogen.getPlasma(1),                   // Mark 2 Fusion
                Oxygen.getPlasma(1),                     // Mark 2 Fusion
                Argon.getPlasma(1),                      // Mark 2 Fusion
                Iron.getPlasma(1),                       // Mark 2 Fusion
                Tin.getPlasma(1),                        // Mark 2 Fusion
                Adamantium.getPlasma(1),                 // Mark 2 Fusion
                QuasifissioningPlasma.getPlasma(1),      // Mark 2 Fusion
                Nickel.getPlasma(1),                     // Mark 3 Fusion
                Americium.getPlasma(1),                  // Mark 3 Fusion
                Vibranium.getPlasma(1),                  // Mark 3 Fusion
                Taranium.getPlasma(1),                   // Mark 3 Fusion
                Mithril.getPlasma(1),                    // Mark 3 Fusion
                IchorLiquid.getPlasma(1),                // Mark 4 Fusion
                Hypogen.getPlasma(1),                    // Mark 5 Fusion
                AstralTitanium.getPlasma(1),             // Mark 5 Fusion
                CelestialTungsten.getPlasma(1),          // Mark 5 Fusion
                DegenerateRhenium.getPlasma(1),          // Stellar Furnace
                CosmicFabric.getPlasma(1),               // Stellar Furnace
                QuarkGluonPlasma.getPlasma(1),           // Stellar Furnace
                HeavyQuarkDegenerateMatter.getPlasma(1), // Stellar Furnace
                DenseNeutronPlasma.getPlasma(1),         // Stellar Furnace
                HighEnergyQuarkGluonPlasma.getPlasma(1), // Stellar Furnace
                StarCoreMatter.getPlasma(1),             // Space Elevator
                FleroviumYtterbiumPlasma.getPlasma(1)    // Decay Generator
        }) {
            HEAT_EXCHANGE_RECIPES.recipeBuilder()
                    .fluidInputs(DistilledWater.getFluid(5))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidOutputs(SuperheatedSteam.getFluid(80 * 5))
                    .fluidOutputs(Steam.getFluid(160 * 5))
                    .fluidOutputs(SupercriticalSteam.getFluid(1))
                    .maxRate(1600)
                    .flowRate(500)
                    .duration(20)
                    .buildAndRegister();
        }

        //  Superheated Steam
        HIGH_PRESSURE_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SuperheatedSteam.getFluid(320))
                .fluidOutputs(DistilledWater.getFluid(64))
                .EUt((int) V[MV])
                .duration(10)
                .buildAndRegister();

        //  Supercritical Steam
        SUPERCRITICAL_STEAM_TURBINE_RECIPES.recipeBuilder()
                .fluidInputs(SupercriticalSteam.getFluid(640))
                .fluidOutputs(DistilledWater.getFluid(128))
                .EUt((int) V[EV])
                .duration(10)
                .buildAndRegister();
    }
}
