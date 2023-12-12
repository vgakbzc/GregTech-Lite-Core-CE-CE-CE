package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;

public class NeutralNetworkNexus {

    public static void init() {
        BreedingMode();
        HybridizingMode();
    }

    private static void BreedingMode() {

        //  Silver
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Silver)
                .input(nanosensor, Silver)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Silver)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Gold
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Gold)
                .input(nanosensor, Gold)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Gold)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();
    }

    private static void HybridizingMode() {

        //  Testing Recipe
        NEUTRAL_NETWORK_NEXUS_HYBRIDIZING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(swarm, Copper)
                .input(swarm, Redstone)
                .chancedOutput(swarm, Copper, 8000, 0)
                .chancedOutput(swarm, Redstone, 8000, 0)
                .chancedOutput(swarm, RedAlloy, 2000, 500)
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();
    }
}
