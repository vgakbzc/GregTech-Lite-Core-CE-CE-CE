package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.SolderingAlloy;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.DYSON_SWARM_RECIPES;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.PRECISE_ASSEMBLER_RECIPES;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.DYSON_SWARM_MODULE;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.MINING_DRONE_UIV;

public class DysonSwarm {

    public static void init() {

        //  Dyson Swarm Module
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(plate, HY1301, 2)
                .input(MINING_DRONE_UIV)
                .input(wireFine, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(MARM200CeSteel.getFluid(L))
                .fluidInputs(QuantumAlloy.getFluid(L / 2))
                .fluidInputs(SiliconCarbide.getFluid(L / 4))
                .output(DYSON_SWARM_MODULE, 64)
                .EUt(VA[UHV])
                .duration(100)
                .CasingTier(5) // UEV
                .buildAndRegister();

        //  x1
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(DYSON_SWARM_MODULE)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .EUt(10000000)
                .duration(200)
                .buildAndRegister();

        //  x4
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(DYSON_SWARM_MODULE, 4)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 5000, 0)
                .EUt(40000000)
                .duration(200)
                .buildAndRegister();

        //  x16
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(DYSON_SWARM_MODULE, 16)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 2, 5000, 0)
                .EUt(160000000)
                .duration(200)
                .buildAndRegister();

        //  x32
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(DYSON_SWARM_MODULE, 32)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 4, 5000, 0)
                .EUt(320000000)
                .duration(200)
                .buildAndRegister();

        //  x64
        DYSON_SWARM_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(DYSON_SWARM_MODULE, 64)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .chancedOutput(DYSON_SWARM_MODULE, 8, 5000, 0)
                .EUt(640000000)
                .duration(200)
                .buildAndRegister();
    }
}
