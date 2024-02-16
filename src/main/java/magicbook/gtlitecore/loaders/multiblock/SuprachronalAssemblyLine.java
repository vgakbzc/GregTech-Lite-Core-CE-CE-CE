package magicbook.gtlitecore.loaders.multiblock;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import magicbook.gtlitecore.common.GTLiteConfigHolder;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class SuprachronalAssemblyLine {

    private static final ItemStack[] suprachronals = {
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ULV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_HV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_EV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_IV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_LuV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_ZPM.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UHV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UEV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UIV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_UXV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_OpV.getStackForm(),
            GTLiteMetaItems.SUPRACHRONAL_CIRCUIT_MAX.getStackForm(),
    };

    public static void init() {

        //  Magic Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Naquadah)         // 1  Naquadah
                .input(singularity, NaquadahEnriched) // 2  Enriched Naquadah
                .input(singularity, Naquadria)        // 3  Naquadria
                .input(singularity, Orichalcum)       // 4  Orichalcum
                .input(singularity, Adamantium)       // 5  Adamantium
                .input(singularity, Vibranium)        // 6  Vibranium
                .input(singularity, Taranium)         // 7  Taranium
                .input(singularity, Mithril)          // 8  Mithril
                .input(singularity, Solarium)         // 9  Solarium
                .input(singularity, LunaSilver)       // 10 Luna Silver
                .input(singularity, Neutronium)       // 11 Neutronium
                .input(singularity, NetherStar)       // 12 Nether Star
                .input(singularity, Glowstone)        // 13 Glowstone
                .input(singularity, Ichorium)         // 14 Ichorium
                .input(singularity, CrystalMatrix)    // 15 Crystal Matrix
                .input(singularity, Infinity)         // 16 Infinity
                .output(MAGIC_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Metric Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(singularity, Iron)      // 1  Iron
                .input(singularity, Copper)    // 2  Copper
                .input(singularity, Tin)       // 3  Tin
                .input(singularity, Gold)      // 4  Gold
                .input(singularity, Silver)    // 5  Silver
                .input(singularity, Lead)      // 6  Lead
                .input(singularity, Zinc)      // 7  Zinc
                .input(singularity, Titanium)  // 8  Titanium
                .input(singularity, Tungsten)  // 9  Tungsten
                .input(singularity, Vanadium)  // 10 Vanadium
                .input(singularity, Platinum)  // 11 Platinum
                .input(singularity, Palladium) // 12 Palladium
                .input(singularity, Ruthenium) // 13 Ruthenium
                .input(singularity, Rhodium)   // 14 Rhodium
                .input(singularity, Iridium)   // 15 Iridium
                .input(singularity, Osmium)    // 16 Osmium
                .output(METRIC_SINGULARITY)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Exotic Singularity

        //  Ancient Singularity

        //  Void Singularity

        //  Eigen Singularity

        //  Weird Singularity

        //  All special singularities -> Eternity Singularity
        SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MAGIC_SINGULARITY)
                .input(METRIC_SINGULARITY)
                .input(EXOTIC_SINGULARITY)
                .input(ANCIENT_SINGULARITY)
                .input(VOID_SINGULARITY)
                .input(EIGEN_SINGULARITY)
                .input(WEIRD_SINGULARITY)
                .fluidInputs(TemporalFluid.getFluid(14400))
                .fluidInputs(Spacetime.getFluid(5760))
                .fluidInputs(Eternity.getFluid(5760))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(14400))
                .output(singularity, Eternity)
                .EUt(VA[MAX])
                .duration(20)
                .buildAndRegister();

        //  Eternity Singularity -> Eternity swarm
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(singularity, Eternity)
                .output(swarm, Eternity, 64)
                .EUt(VA[OpV])
                .duration(1200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Hyperdimensional Drone
        if (GTLiteConfigHolder.tools.enableHighTierUltimateBattery) {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(MINING_DRONE_OpV)
                    .input(swarm, Eternity, 4)
                    .input(plate, CosmicFabric, 16)
                    .input(circuit, MarkerMaterials.Tier.MAX, 8)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(SENSOR_OpV)
                    .input(ROBOT_ARM_OpV)
                    .input(FIELD_GENERATOR_OpV)
                    .input(ULTIMATE_BATTERY_MK5, 2)
                    .fluidInputs(AstralTitanium.getFluid(L * 40))
                    .fluidInputs(CelestialTungsten.getFluid(L * 40))
                    .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L * 4))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 4))
                    .output(HYPERDIMENSIONAL_DRONE)
                    .EUt(VA[OpV])
                    .duration(600)
                    .stationResearch(b -> b
                            .researchStack(MINING_DRONE_OpV.getStackForm())
                            .EUt(VA[OpV])
                            .CWUt(576))
                    .buildAndRegister();
        } else {
            ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(MINING_DRONE_OpV)
                    .input(swarm, Eternity, 4)
                    .input(plate, CosmicFabric, 16)
                    .input(circuit, MarkerMaterials.Tier.MAX, 8)
                    .input(ELECTRIC_PUMP_OpV)
                    .input(SENSOR_OpV)
                    .input(ROBOT_ARM_OpV)
                    .input(FIELD_GENERATOR_OpV)
                    .input(ULTIMATE_BATTERY, 2)
                    .fluidInputs(AstralTitanium.getFluid(L * 40))
                    .fluidInputs(CelestialTungsten.getFluid(L * 40))
                    .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L * 4))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 4))
                    .output(HYPERDIMENSIONAL_DRONE)
                    .EUt(VA[OpV])
                    .duration(600)
                    .stationResearch(b -> b
                            .researchStack(MINING_DRONE_OpV.getStackForm())
                            .EUt(VA[OpV])
                            .CWUt(576))
                    .buildAndRegister();
        }

        for (int tier = 0; tier < 15; tier ++) {
            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier)
                    .outputs(suprachronals[tier])
                    .duration(200)
                    .EUt(VA[tier])
                    .buildAndRegister();

            SUPRACHRONAL_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                    .notConsumable(HYPERDIMENSIONAL_DRONE)
                    .circuitMeta(tier + 10)
                    .fluidInputs(Spacetime.getFluid(L))
                    .outputs(suprachronals[tier])
                    .duration(20)
                    .EUt(VA[tier])
                    .buildAndRegister();
        }
    }
}
