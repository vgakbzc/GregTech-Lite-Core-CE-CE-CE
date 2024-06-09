package magicbook.gtlitecore.integration.gregtech.overrides;

import gregtech.common.blocks.BlockComputerCasing;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.MetaBlocks;
import magicbook.gtlitecore.common.blocks.BlockScienceCasing;
import magicbook.gtlitecore.common.blocks.BlockUniqueCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Lubricant;
import static gregtech.api.unification.material.Materials.SolderingAlloy;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.GTLiteValues.tierList;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.SPACE_ELEVATOR_ASSEMBLING_MODULE;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.CHARGED_HYPERCUBE;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.CRUDE_HYPERCUBE;
import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class WirelessEnergyHatches {
    public static void init() {
        //  TODO Add MAX stage recipes, should rebalanced it now,
        //       because when add MAX stage recipe, then we can make MAX Magneto Resonatic Circuit.
        for (int i = ULV; i < MAX; i++) {
            int final_i = i;

            //  T1

            //  2A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(1)
                    .input(ENERGY_INPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING))
                    .input(wireGtSingle, Ichorium, 2)
                    .input(plateDense, Infinity)
                    .input(circuit, tierList[i])
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_INPUT_ENERGY_HATCH[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  2A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(1)
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING))
                    .input(wireGtSingle, Ichorium, 2)
                    .input(plateDense, Infinity)
                    .input(circuit, tierList[i])
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  4A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(2)
                    .input(ENERGY_INPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 2))
                    .input(wireGtSingle, Ichorium, 4)
                    .input(plateDense, Infinity, 2)
                    .input(circuit, tierList[i], 2)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_4A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  4A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(2)
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 2))
                    .input(wireGtSingle, Ichorium, 4)
                    .input(plateDense, Infinity, 2)
                    .input(circuit, tierList[i], 2)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_4A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  16A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(3)
                    .input(ENERGY_INPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 4))
                    .input(wireGtSingle, Ichorium, 16)
                    .input(plateDense, Infinity, 3)
                    .input(circuit, tierList[i], 4)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_16A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  16A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(3)
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 4))
                    .input(wireGtSingle, Ichorium, 16)
                    .input(plateDense, Infinity, 3)
                    .input(circuit, tierList[i], 4)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_16A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  64A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(4)
                    .input(ENERGY_INPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 8))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 8))
                    .input(wireGtSingle, Ichorium, 64)
                    .input(plateDense, Infinity, 4)
                    .input(circuit, tierList[i], 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_64A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  64A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(4)
                    .input(ENERGY_OUTPUT_HATCH[i])
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                    .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL, 8))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(MetaBlocks.COMPUTER_CASING.getItemVariant(BlockComputerCasing.CasingType.HIGH_POWER_CASING, 8))
                    .input(wireGtSingle, Ichorium, 64)
                    .input(plateDense, Infinity, 4)
                    .input(circuit, tierList[i], 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 9))
                    .fluidInputs(Lubricant.getFluid(3000))
                    .fluidInputs(DegenerateRhenium.getFluid(L))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_64A[i])
                    .EUt(30000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  T2

            //  256A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(5)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                    .input(wireGtSingle, Astralium, 2)
                    .input(plateDense, Hypogen)
                    .input(circuit, tierList[i])
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_256A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  256A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(5)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING))
                    .input(wireGtSingle, Astralium, 2)
                    .input(plateDense, Hypogen)
                    .input(circuit, tierList[i])
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_256A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  1024A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(6)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 2))
                    .input(wireGtSingle, Astralium, 4)
                    .input(plateDense, Hypogen, 2)
                    .input(circuit, tierList[i], 2)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_1024A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  1024A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(6)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 2))
                    .input(wireGtSingle, Astralium, 4)
                    .input(plateDense, Hypogen, 2)
                    .input(circuit, tierList[i], 2)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_1024A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  4096A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(7)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 4))
                    .input(wireGtSingle, Astralium, 16)
                    .input(plateDense, Hypogen, 3)
                    .input(circuit, tierList[i], 4)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_4096A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  4096A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(7)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 4))
                    .input(wireGtSingle, Astralium, 16)
                    .input(plateDense, Hypogen, 3)
                    .input(circuit, tierList[i], 4)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_4096A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  16384A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(8)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 8))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 8))
                    .input(wireGtSingle, Astralium, 64)
                    .input(plateDense, Hypogen, 4)
                    .input(circuit, tierList[i], 8)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_16384A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  16384A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(8)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_64A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK2))
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.MOLECULAR_COIL, 8))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.HIGH_ENERGY_CASING, 8))
                    .input(wireGtSingle, Astralium, 64)
                    .input(plateDense, Hypogen, 4)
                    .input(circuit, tierList[i], 8)
                    .input(CRUDE_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 18))
                    .fluidInputs(Lubricant.getFluid(6000))
                    .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L * 2))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_16384A[i])
                    .EUt(100000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  T3

            //  65536A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(9)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING))
                    .input(wireGtSingle, Hikarium, 2)
                    .input(plateDense, Spacetime)
                    .input(circuit, tierList[i])
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_65536A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  65536A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(9)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING))
                    .input(wireGtSingle, Hikarium, 2)
                    .input(plateDense, Spacetime)
                    .input(circuit, tierList[i])
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_65536A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  262144A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(10)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 2))
                    .input(wireGtSingle, Hikarium, 4)
                    .input(plateDense, Spacetime, 2)
                    .input(circuit, tierList[i], 2)
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_262144A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  262144A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(10)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL, 2))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 2))
                    .input(wireGtSingle, Hikarium, 4)
                    .input(plateDense, Spacetime, 2)
                    .input(circuit, tierList[i], 2)
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_262144A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  1048576A Energy Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(11)
                    .input(WIRELESS_INPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 4))
                    .input(wireGtSingle, Hikarium, 16)
                    .input(plateDense, Spacetime, 3)
                    .input(circuit, tierList[i], 4)
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_INPUT_ENERGY_HATCH_1048576A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();

            //  1048576A Dynamo Hatch
            SPACE_ELEVATOR_ASSEMBLING_MODULE.recipeBuilder()
                    .circuitMeta(11)
                    .input(WIRELESS_OUTPUT_ENERGY_HATCH_256A[i])
                    .inputs(GTLiteMetaBlocks.FUSION_CASING.getItemVariant(magicbook.gtlitecore.common.blocks.BlockFusionCasing.FusionCasingType.FUSION_COIL_MK3))
                    .inputs(GTLiteMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.QUANTUM_COIL, 4))
                    .input(ACTIVE_TRANSFORMER)
                    .inputs(GTLiteMetaBlocks.SCIENCE_CASING.getItemVariant(BlockScienceCasing.ScienceCasingType.ADVANCED_HIGH_ENERGY_CASING, 4))
                    .input(wireGtSingle, Hikarium, 16)
                    .input(plateDense, Spacetime, 3)
                    .input(circuit, tierList[i], 4)
                    .input(CHARGED_HYPERCUBE)
                    .fluidInputs(SolderingAlloy.getFluid(L * 36))
                    .fluidInputs(Lubricant.getFluid(12000))
                    .fluidInputs(Shirabon.getFluid(L * 4))
                    .output(WIRELESS_OUTPUT_ENERGY_HATCH_1048576A[i])
                    .EUt(2000000000)
                    .duration(200)
                    .tier(5)
                    .buildAndRegister();
        }
    }
}
