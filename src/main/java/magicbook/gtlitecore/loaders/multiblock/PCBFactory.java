package magicbook.gtlitecore.loaders.multiblock;

import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.common.items.MetaItems.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.api.unification.materials.info.GTLiteOrePrefix.*;

public class PCBFactory {

    public static void init() {
        BasicCircuitBoard();
        GoodCircuitBoard();
        PlasticCircuitBoard();
        AdvancedCircuitBoard();
        ExtremeCircuitBoard();
        EliteCircuitBoard();
        WetwareCircuitBoard();
        KaptonCircuitBoard();
        OpticalCircuitBoard();
        SpintronicCircuitBoard();

        NanoAssemblingMode();
    }

    private static void BasicCircuitBoard() {}
    private static void GoodCircuitBoard() {}

    private static void PlasticCircuitBoard() {

        //  PE -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 8)
                .EUt(22)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 10)
                .EUt(90)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polyethylene)
                .input(foil, AnnealedCopper, 16)
                .input(foil, Copper, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(250))
                .output(PLASTIC_CIRCUIT_BOARD, 12)
                .EUt(90)
                .duration(543)
                .buildAndRegister();

        //  PVC -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 12)
                .EUt(90)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 14)
                .EUt(360)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, PolyvinylChloride)
                .input(foil, AnnealedCopper, 22)
                .input(foil, Copper, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(353))
                .output(PLASTIC_CIRCUIT_BOARD, 16)
                .EUt(360)
                .duration(362)
                .buildAndRegister();

        //  PTFE -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 16)
                .EUt(360)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 20)
                .EUt(1440)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, AnnealedCopper, 27)
                .input(foil, Copper, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(433))
                .output(PLASTIC_CIRCUIT_BOARD, 23)
                .EUt(1440)
                .duration(296)
                .buildAndRegister();

        //  Epoxy -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 23)
                .EUt(1440)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 27)
                .EUt(5760)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, AnnealedCopper, 32)
                .input(foil, Copper, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(PLASTIC_CIRCUIT_BOARD, 32)
                .EUt(5760)
                .duration(241)
                .buildAndRegister();

        //  Fibered epoxy -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 32)
                .EUt(5760)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 39)
                .EUt(23040)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, AnnealedCopper, 35)
                .input(foil, Copper, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(559))
                .output(PLASTIC_CIRCUIT_BOARD, 46)
                .EUt(23040)
                .duration(197)
                .buildAndRegister();

        //  PBI -> PVC
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 46)
                .EUt(23040)
                .duration(241)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 54)
                .EUt(92160)
                .duration(201)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, AnnealedCopper, 39)
                .input(foil, Copper, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(612))
                .output(PLASTIC_CIRCUIT_BOARD, 64)
                .EUt(92160)
                .duration(161)
                .buildAndRegister();

        //  Kapton-K -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 64)
                .EUt(92160)
                .duration(197)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 77)
                .EUt(368640)
                .duration(164)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, AnnealedCopper, 42)
                .input(foil, Copper, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(661))
                .output(PLASTIC_CIRCUIT_BOARD, 91)
                .EUt(368640)
                .duration(132)
                .buildAndRegister();

        //  Kapton-E -> PCB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 91)
                .EUt(368640)
                .duration(161)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 108)
                .EUt(1474560)
                .duration(134)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, AnnealedCopper, 45)
                .input(foil, Copper, 45)
                .fluidInputs(SulfuricAcid.getFluid(1414))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(PLASTIC_CIRCUIT_BOARD, 128)
                .EUt(1474560)
                .duration(108)
                .buildAndRegister();
    }

    private static void AdvancedCircuitBoard() {

        //  PVC -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 8)
                .EUt(90)
                .duration(665)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 10)
                .EUt(360)
                .duration(554)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, PolyvinylChloride)
                .input(foil, Gold, 16)
                .input(foil, Electrum, 16)
                .fluidInputs(SulfuricAcid.getFluid(500))
                .fluidInputs(Iron3Chloride.getFluid(500))
                .output(ADVANCED_CIRCUIT_BOARD, 12)
                .EUt(360)
                .duration(443)
                .buildAndRegister();

        //  PTFE -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 12)
                .EUt(360)
                .duration(543)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 14)
                .EUt(1440)
                .duration(452)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Gold, 22)
                .input(foil, Electrum, 22)
                .fluidInputs(SulfuricAcid.getFluid(707))
                .fluidInputs(Iron3Chloride.getFluid(707))
                .output(ADVANCED_CIRCUIT_BOARD, 16)
                .EUt(1440)
                .duration(362)
                .buildAndRegister();

        //  Epoxy -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 16)
                .EUt(1440)
                .duration(443)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 20)
                .EUt(5760)
                .duration(369)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Epoxy)
                .input(foil, Gold, 27)
                .input(foil, Electrum, 27)
                .fluidInputs(SulfuricAcid.getFluid(866))
                .fluidInputs(Iron3Chloride.getFluid(866))
                .output(ADVANCED_CIRCUIT_BOARD, 23)
                .EUt(5760)
                .duration(296)
                .buildAndRegister();

        //  Fibered epoxy -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 23)
                .EUt(5760)
                .duration(362)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 27)
                .EUt(23040)
                .duration(302)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, ReinforcedEpoxyResin)
                .input(foil, Gold, 32)
                .input(foil, Electrum, 32)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Iron3Chloride.getFluid(1000))
                .output(ADVANCED_CIRCUIT_BOARD, 32)
                .EUt(23040)
                .duration(241)
                .buildAndRegister();

        //  PBI -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 32)
                .EUt(23040)
                .duration(296)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 39)
                .EUt(92160)
                .duration(246)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, Polybenzimidazole)
                .input(foil, Gold, 35)
                .input(foil, Electrum, 35)
                .fluidInputs(SulfuricAcid.getFluid(1118))
                .fluidInputs(Iron3Chloride.getFluid(1118))
                .output(ADVANCED_CIRCUIT_BOARD, 46)
                .EUt(92160)
                .duration(197)
                .buildAndRegister();

        //  Kapton-K -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 46)
                .EUt(92160)
                .duration(241)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 54)
                .EUt(368640)
                .duration(201)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonK)
                .input(foil, Gold, 39)
                .input(foil, Electrum, 39)
                .fluidInputs(SulfuricAcid.getFluid(1224))
                .fluidInputs(Iron3Chloride.getFluid(1224))
                .output(ADVANCED_CIRCUIT_BOARD, 64)
                .EUt(368640)
                .duration(161)
                .buildAndRegister();

        //  Kapton-E -> ACB
        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 64)
                .EUt(368640)
                .duration(197)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(swarm, Silver)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 77)
                .EUt(1474560)
                .duration(164)
                .buildAndRegister();

        PCB_FACTORY_ETCH_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(swarm, Gold)
                .input(plate, KaptonE)
                .input(foil, Gold, 42)
                .input(foil, Electrum, 42)
                .fluidInputs(SulfuricAcid.getFluid(1322))
                .fluidInputs(Iron3Chloride.getFluid(1322))
                .output(ADVANCED_CIRCUIT_BOARD, 91)
                .EUt(1474560)
                .duration(132)
                .buildAndRegister();
    }
    private static void ExtremeCircuitBoard() {}
    private static void EliteCircuitBoard() {}
    private static void WetwareCircuitBoard() {}
    private static void KaptonCircuitBoard() {}
    private static void OpticalCircuitBoard() {}
    private static void SpintronicCircuitBoard() {}

    private static void NanoAssemblingMode() {

        NanotubeRecipes();
        NanosensorRecipes();
    }

    private static void NanotubeRecipes() {

        //  Silver
        for (FluidStack stack : new FluidStack[]{
                HSQ.getFluid(2000),
                KPR.getFluid(1000)}) {

            for (FluidStack substack : new FluidStack[] {
                    Polyethylene.getFluid(L * 4),
                    PolyvinylChloride.getFluid(L * 3),
                    Polytetrafluoroethylene.getFluid(L * 2),
                    Epoxy.getFluid(L),
                    ReinforcedEpoxyResin.getFluid(L / 2),
                    Polybenzimidazole.getFluid(L / 4),
                    KaptonK.getFluid(L / 6),
                    KaptonE.getFluid(L / 8),
                    Polyetheretherketone.getFluid(L / 12),
                    Kevlar.getFluid(L / 24),
                    Zylon.getFluid(L / 48),
                    FullerenePolymerMatrix.getFluid(1)
            }) {

                PCB_FACTORY_NANO_RECIPES.recipeBuilder()
                        .input(plate, Silver, 4)
                        .input(CARBON_MESH, 2)
                        .fluidInputs(new FluidStack[]{stack})
                        .fluidInputs(new FluidStack[]{substack})
                        .output(nanotube, Silver)
                        .EUt(VA[IV])
                        .duration(200)
                        .buildAndRegister();
            }
        }

        //  Gold
        for (FluidStack stack : new FluidStack[]{
                HSQ.getFluid(2000),
                KPR.getFluid(1000)}) {

            for (FluidStack substack : new FluidStack[] {
                    Polyethylene.getFluid(L * 4),
                    PolyvinylChloride.getFluid(L * 3),
                    Polytetrafluoroethylene.getFluid(L * 2),
                    Epoxy.getFluid(L),
                    ReinforcedEpoxyResin.getFluid(L / 2),
                    Polybenzimidazole.getFluid(L / 4),
                    KaptonK.getFluid(L / 6),
                    KaptonE.getFluid(L / 8),
                    Polyetheretherketone.getFluid(L / 12),
                    Kevlar.getFluid(L / 24),
                    Zylon.getFluid(L / 48),
                    FullerenePolymerMatrix.getFluid(1)
            }) {

                PCB_FACTORY_NANO_RECIPES.recipeBuilder()
                        .input(plate, Gold, 4)
                        .input(CARBON_MESH, 2)
                        .fluidInputs(new FluidStack[]{stack})
                        .fluidInputs(new FluidStack[]{substack})
                        .output(nanotube, Gold)
                        .EUt(VA[IV])
                        .duration(200)
                        .buildAndRegister();
            }
        }

    }

    private static void NanosensorRecipes() {

        //  Silver
        for (FluidStack stack : new FluidStack[] {
                SodiumPersulfate.getFluid(8000),
                Iron3Chloride.getFluid(4000),
                TetramethylammoniumHydroxide.getFluid(2000),
                EDP.getFluid(500)
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Helium.getFluid(L * 8),
                    Neon.getFluid(L * 4),
                    Argon.getFluid(L * 2),
                    Krypton.getFluid(L),
                    Xenon.getFluid(L / 2),
                    Radon.getFluid(L / 4),
                    MetastableOganesson.getFluid(L / 8)
            }) {
                for (FluidStack substack2 : new FluidStack[] {
                        Water.getFluid(1000),
                        DistilledWater.getFluid(500),
                        Lubricant.getFluid(250)
                }) {
                    PCB_FACTORY_NANO_RECIPES.recipeBuilder()
                            .input(stick, Silver)
                            .input(lens, Glass)
                            .input(CARBON_FIBERS, 2)
                            .input(wireFine, Silver, 4)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{substack2})
                            .output(nanosensor, Silver)
                            .EUt(VA[IV])
                            .duration(200)
                            .buildAndRegister();
                }
            }
        }

        //  Gold
        for (FluidStack stack : new FluidStack[] {
                SodiumPersulfate.getFluid(8000),
                Iron3Chloride.getFluid(4000),
                TetramethylammoniumHydroxide.getFluid(2000),
                EDP.getFluid(500)
        }) {
            for (FluidStack substack : new FluidStack[] {
                    Helium.getFluid(L * 8),
                    Neon.getFluid(L * 4),
                    Argon.getFluid(L * 2),
                    Krypton.getFluid(L),
                    Xenon.getFluid(L / 2),
                    Radon.getFluid(L / 4),
                    MetastableOganesson.getFluid(L / 8)
            }) {
                for (FluidStack substack2 : new FluidStack[] {
                        Water.getFluid(1000),
                        DistilledWater.getFluid(500),
                        Lubricant.getFluid(250)
                }) {
                    PCB_FACTORY_NANO_RECIPES.recipeBuilder()
                            .input(stick, Gold)
                            .input(lens, Glass)
                            .input(CARBON_FIBERS, 2)
                            .input(wireFine, Gold, 4)
                            .fluidInputs(new FluidStack[]{stack})
                            .fluidInputs(new FluidStack[]{substack})
                            .fluidInputs(new FluidStack[]{substack2})
                            .output(nanosensor, Gold)
                            .EUt(VA[IV])
                            .duration(200)
                            .buildAndRegister();
                }
            }
        }

    }
}