package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Naquadria;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_CYLINDER;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.GTLiteValues.VZ;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DIMENSIONAL_OSCILLATOR_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class DimensionalOscillator {

    public static void init() {

        //  Manifold Oscillatory Power Cell
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .input(plate, AstralTitanium)
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(L))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .EUt(VZ[UIV])
                .duration(10 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .input(plate, Astralium)
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(L))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 32)
                .EUt(VZ[UXV])
                .duration(10 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(21)
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .input(plate, Galaxium)
                .fluidInputs(BlackDwarfMatter.getFluid(L / 2))
                .fluidInputs(WhiteDwarfMatter.getFluid(L / 2))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 64)
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //   Raw Star Matter -> Magneto Hydrodynamically Constrainted Star Matter
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(swarm, AstralTitanium)
                .input(swarm, CelestialTungsten)
                .input(swarm, Astralium)
                .input(QUANTUM_ANOMALY)
                .input(QCD_PROTECTIVE_PLATING, 2)
                .fluidInputs(RawStarMatter.getFluid(L * 64))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 16))
                .EUt(VZ[UIV])
                .duration(30 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(12)
                .input(swarm, BlackDwarfMatter)
                .input(swarm, WhiteDwarfMatter)
                .input(QUANTUM_ANOMALY)
                .input(QCD_PROTECTIVE_PLATING, 2)
                .fluidInputs(RawStarMatter.getFluid(L * 128))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 32))
                .EUt(VZ[UXV])
                .duration(20 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(22)
                .input(swarm, Galaxium)
                .input(QUANTUM_ANOMALY)
                .input(QCD_PROTECTIVE_PLATING, 2)
                .fluidInputs(RawStarMatter.getFluid(L * 256))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 64))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(32)
                .input(swarm, Eternity)
                .fluidInputs(RawStarMatter.getFluid(L * 512))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 256))
                .EUt(VZ[MAX])
                .duration(SECOND)
                .buildAndRegister();

        //  Galaxium
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(ring, Spacetime)
                .input(swarm, Solarium)
                .input(swarm, LunaSilver)
                .input(swarm, Naquadria)
                .fluidInputs(Astralium.getFluid(L * 64))
                .fluidOutputs(Galaxium.getFluid(L * 16))
                .EUt(VZ[UXV])
                .duration(20 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(13)
                .notConsumable(ring, Shirabon)
                .input(swarm, HeavyQuarkDegenerateMatter)
                .input(swarm, QuantumchromodynamicallyConfinedMatter)
                .fluidInputs(Astralium.getFluid(L * 128))
                .fluidOutputs(Galaxium.getFluid(L * 32))
                .EUt(VZ[OpV])
                .duration(10 * SECOND)
                .buildAndRegister();

        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .circuitMeta(23)
                .notConsumable(ring, Omnium)
                .input(swarm, Eternity)
                .fluidInputs(Astralium.getFluid(L * 256))
                .fluidOutputs(Galaxium.getFluid(L * 64))
                .EUt(VZ[MAX])
                .duration(SECOND)
                .buildAndRegister();

        //  Hyperdimensional Oscillating Matter
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(DIMENSION_GAP)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .output(HYPERDIMENSIONAL_OSCILLATING_MATTER)
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(16000))
                .EUt(VZ[UXV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  Fatalium Plasma -> Fatalium
        //  Fatalium plasma recipe back to fusion reactor recipe
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Galaxium)
                .fluidInputs(Fatalium.getPlasma(L))
                .fluidInputs(Hypogen.getFluid(L * 4))
                .fluidInputs(DimensionallyTranscendentResidue.getFluid(16000))
                .fluidOutputs(Fatalium.getFluid(L))
                .EUt(VZ[OpV])
                .duration(SECOND)
                .buildAndRegister();

        //  1x Magmatter wire cycle recipe
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(wireGtSingle, Magmatter)
                .circuitMeta(1)
                .fluidInputs(Eternity.getFluid(L))
                .output(wireFine, Magmatter, 4)
                .fluidOutputs(Magmatter.getFluid(L))
                .fluidOutputs(Spacetime.getFluid(L * 4))
                .fluidOutputs(CosmicNeutronium.getFluid(1000))
                .EUt(VZ[MAX])
                .duration(20)
                .buildAndRegister();

        //  2x Magmatter wire
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(wireGtSingle, Magmatter, 2)
                .circuitMeta(2)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .output(wireGtDouble, Magmatter)
                .EUt(VZ[MAX])
                .duration(20)
                .buildAndRegister();

        //  4x Magmatter wire
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(wireGtDouble, Magmatter, 2)
                .circuitMeta(4)
                .fluidInputs(CosmicComputingMixture.getFluid(2000))
                .output(wireGtQuadruple, Magmatter)
                .EUt(VZ[MAX])
                .duration(20)
                .buildAndRegister();

        //  8x Magmatter wire
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(wireGtQuadruple, Magmatter, 2)
                .circuitMeta(8)
                .fluidInputs(CosmicComputingMixture.getFluid(4000))
                .output(wireGtOctal, Magmatter)
                .EUt(VZ[MAX])
                .duration(20)
                .buildAndRegister();

        //  16x Magmatter wire
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(wireGtOctal, Magmatter, 2)
                .circuitMeta(16)
                .fluidInputs(CosmicComputingMixture.getFluid(8000))
                .output(wireGtHex, Magmatter)
                .EUt(VZ[MAX])
                .duration(20)
                .buildAndRegister();
    }
}
