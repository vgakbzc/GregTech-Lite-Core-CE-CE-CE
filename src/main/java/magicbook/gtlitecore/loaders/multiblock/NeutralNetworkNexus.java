package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
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

        //  Graphene
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Graphene)
                .input(nanosensor, Graphene)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Graphene)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Carbon
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Carbon)
                .input(nanosensor, Carbon)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Carbon)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Fullerene
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Fullerene)
                .input(nanosensor, Fullerene)
                .input(ADVANCED_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Fullerene)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Carbon Nanotube
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, CarbonNanotube)
                .input(nanosensor, CarbonNanotube)
                .input(ADVANCED_SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, CarbonNanotube)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Platinum
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Platinum)
                .input(nanosensor, Platinum)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Platinum)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Europium
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Europium)
                .input(nanosensor, Europium)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Europium)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Titanium
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Titanium)
                .input(nanosensor, Titanium)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Titanium)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Tungsten
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Tungsten)
                .input(nanosensor, Tungsten)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Tungsten)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Americium
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Americium)
                .input(nanosensor, Americium)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Americium)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Dubnium
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Dubnium)
                .input(nanosensor, Dubnium)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Dubnium)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Naquadah
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Naquadah)
                .input(nanosensor, Naquadah)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Naquadah)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Naquadah Enriched
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, NaquadahEnriched)
                .input(nanosensor, NaquadahEnriched)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, NaquadahEnriched)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Naquadria
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Naquadria)
                .input(nanosensor, Naquadria)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Naquadria)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Tin
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Tin)
                .input(nanosensor, Tin)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Tin)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Tritanium
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Tritanium)
                .input(nanosensor, Tritanium)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Tritanium)
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Orichalcum
        NEUTRAL_NETWORK_NEXUS_BREEDING_MODE.recipeBuilder()
                .circuitMeta(1)
                .input(nanotube, Orichalcum)
                .input(nanosensor, Orichalcum)
                .input(SYSTEM_ON_CHIP, 8)
                .input(dust, Carbon, 16)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .output(swarm, Orichalcum)
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
