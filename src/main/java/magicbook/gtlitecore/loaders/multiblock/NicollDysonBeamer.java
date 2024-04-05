package magicbook.gtlitecore.loaders.multiblock;

import gregtech.common.blocks.MetaBlocks;

import java.math.BigInteger;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.swarm;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class NicollDysonBeamer {

    public static void init() {
        BurningModule();
        ForgingModule();
        OscillatingModule();
    }

    private static void BurningModule() {

        //  1x Magmatter Wire
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireFine, Magmatter, 4)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .fluidInputs(Magmatter.getFluid(L))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(CosmicNeutronium.getFluid(1000))
                .output(wireGtSingle, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  1x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireGtSingle, Magmatter)
                .input(foil, CosmicFabric, 2)
                .input(MetaBlocks.OPTICAL_PIPES[0])
                .input(OPTICAL_FIBER, 4)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .fluidInputs(NitrileButadieneRubber.getFluid(5000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(5000))
                .fluidInputs(Spacetime.getFluid(L * 4))
                .fluidInputs(Magmatter.getFluid(L))
                .output(cableGtSingle, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  2x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireGtDouble, Magmatter)
                .input(foil, CosmicFabric, 4)
                .input(MetaBlocks.OPTICAL_PIPES[0], 2)
                .input(OPTICAL_FIBER, 8)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 32)
                .fluidInputs(NitrileButadieneRubber.getFluid(10000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(10000))
                .fluidInputs(Spacetime.getFluid(L * 8))
                .fluidInputs(Magmatter.getFluid(L * 2))
                .output(cableGtDouble, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  4x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireGtQuadruple, Magmatter)
                .input(foil, CosmicFabric, 8)
                .input(MetaBlocks.OPTICAL_PIPES[0], 4)
                .input(OPTICAL_FIBER, 16)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 64)
                .fluidInputs(NitrileButadieneRubber.getFluid(20000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(20000))
                .fluidInputs(Spacetime.getFluid(L * 16))
                .fluidInputs(Magmatter.getFluid(L * 4))
                .output(cableGtQuadruple, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  8x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireGtOctal, Magmatter)
                .input(foil, CosmicFabric, 16)
                .input(MetaBlocks.OPTICAL_PIPES[0], 8)
                .input(OPTICAL_FIBER, 32)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 8)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 128)
                .fluidInputs(NitrileButadieneRubber.getFluid(40000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(40000))
                .fluidInputs(Spacetime.getFluid(L * 32))
                .fluidInputs(Magmatter.getFluid(L * 8))
                .output(cableGtOctal, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();

        //  16x Magmatter cable
        NICOLL_DYSON_BEAMER_BURNING_MODULE.recipeBuilder()
                .input(wireGtHex, Magmatter)
                .input(foil, CosmicFabric, 32)
                .input(MetaBlocks.OPTICAL_PIPES[0], 16)
                .input(OPTICAL_FIBER, 64)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 16)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 256)
                .fluidInputs(NitrileButadieneRubber.getFluid(80000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(80000))
                .fluidInputs(Spacetime.getFluid(L * 64))
                .fluidInputs(Magmatter.getFluid(L * 16))
                .output(cableGtHex, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .temperature(BigInteger.valueOf(Integer.MAX_VALUE))
                .buildAndRegister();
    }

    private static void ForgingModule() {

        //  Magmatter Dust
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dust, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dust, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Dust Small
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dustSmall, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dustSmall, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Dust Tiny
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(dustTiny, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(dustTiny, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Nugget
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(nugget, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(nugget, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Ingot
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(ingot, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(ingot, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Block
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(block, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(block, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Plate
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(plate, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Foil
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(foil, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(foil, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();

        //  Magmatter Wire Fine
        NICOLL_DYSON_BEAMER_FORGING_MODULE.recipeBuilder()
                .input(wireFine, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(swarm, Eternity, 2)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .fluidInputs(Magmatter.getFluid(L))
                .output(wireFine, Magmatter)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(3)
                .buildAndRegister();
    }

    private static void OscillatingModule() {

        //  Hyperstable Self-Healing Adhesive
        //  Basic materials for some recipe of this machine, and T2 casings.
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(DIMENSION_GAP)
                .input(GLUON)
                .input(QUANTUM_ANOMALY)
                .fluidInputs(SolderingAlloy.getFluid(5760000))
                .fluidInputs(Lubricant.getFluid(5760000))
                .fluidInputs(SodiumPotassium.getFluid(5760000))
                .chancedOutput(HYPERSTABLE_SELF_HEALING_ADHESIVE.getStackForm(), 2000, 0)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(1)
                .buildAndRegister();

        //  Supersolid Spacetime Continuum
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(EIGENFOLDED_SPACETIME_MANIFOLD)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE)
                .input(QUANTUM_ANOMALY)
                .fluidInputs(Spacetime.getFluid(8000))
                .chancedOutput(SUPERSOLID_SPACETIME_CONTINUUM, 2000, 0)
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(2)
                .buildAndRegister();

        //  Magmatter Liquid
        //  This is basic material to create other Magmatter components.
        NICOLL_DYSON_BEAMER_OSCILLATING_MODULE.recipeBuilder()
                .notConsumable(spring, Edenium)
                .input(BOSE_EINSTEIN_CONDENSATE, 64)
                .input(HYPERSTABLE_SELF_HEALING_ADHESIVE, 4)
                .fluidInputs(RawStarMatter.getFluid(16000))
                .fluidInputs(StarCoreMatter.getPlasma(16000))
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(16000))
                .output(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT, 64)
                .fluidOutputs(Magmatter.getFluid(16000))
                .EUt(VA[MAX])
                .duration(20)
                .CasingTier(2)
                .buildAndRegister();

    }

}
