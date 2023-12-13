package magicbook.gtlitecore.loaders.multiblock;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class Collider {

    public static void init() {

        //  Cu + Cs -> Ac
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Copper.getFluid(L))
                .fluidInputs(Caesium.getFluid(L))
                .fluidOutputs(Actinium.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  C + At -> Ac
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Astatine.getFluid(L))
                .fluidInputs(Carbon.getFluid(L * 4))
                .fluidOutputs(Actinium.getFluid(L * 3))
                .fluidOutputs(FreeElectronGas.getFluid(L * 2))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  C + Cs -> La
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Caesium.getFluid(L))
                .fluidInputs(Carbon.getFluid(L * 4))
                .fluidOutputs(Lanthanum.getFluid(L))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[LuV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  La + Li -> Ce
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Lanthanum.getFluid(L))
                .fluidInputs(Lithium.getFluid(L * 4))
                .fluidOutputs(Cerium.getFluid(L * 3))
                .fluidOutputs(FreeElectronGas.getFluid(L * 2))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Cu + Sr -> Nb
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Strontium.getFluid(L))
                .fluidInputs(Copper.getFluid(L * 4))
                .fluidOutputs(Niobium.getFluid(L * 2))
                .fluidOutputs(FreeElectronGas.getFluid(L * 3))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Be + Ce -> Nb
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Beryllium.getFluid(L * 6))
                .fluidInputs(Cerium.getFluid(L * 2))
                .fluidOutputs(Niobium.getFluid(L * 4))
                .fluidOutputs(FreeElectronGas.getFluid(L * 4))
                .EUt(VA[LuV])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  Pu-239 + alpha -> Cm
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Plutonium239.getFluid(L))
                .fluidOutputs(Curium.getFluid(L))
                .EUt(VA[IV])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Bk + alpha -> Cf
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Berkelium.getFluid(L * 2))
                .fluidOutputs(Californium.getFluid(L * 2))
                .EUt(VA[LuV])
                .duration(120)
                .CasingTier(1)
                .buildAndRegister();

        //  U-238 + alpha -> Neptunium
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Uranium238.getFluid(L))
                .fluidOutputs(Neptunium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(200)
                .CasingTier(1)
                .buildAndRegister();

        //  Cm + alpha -> Bk
        COLLIDER_RECIPES.recipeBuilder()
                .input(ALPHA_PARTICLE)
                .fluidInputs(Curium.getFluid(L))
                .fluidOutputs(Berkelium.getFluid(L))
                .EUt(VA[LuV])
                .duration(140)
                .CasingTier(1)
                .buildAndRegister();

        //  C + Am -> Es
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Carbon.getFluid(L))
                .fluidInputs(Americium.getFluid(L))
                .fluidOutputs(Einsteinium.getFluid(L))
                .EUt(VA[UV])
                .duration(70)
                .CasingTier(2)
                .buildAndRegister();

        //  O + U-238 -> Fm
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getPlasma(L))
                .fluidInputs(Uranium238.getFluid(L))
                .fluidOutputs(Fermium.getFluid(L))
                .EUt(VA[ZPM])
                .duration(120)
                .CasingTier(1)
                .buildAndRegister();

        //  Es + He -> Md
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Einsteinium.getFluid(L))
                .fluidInputs(Helium.getPlasma(L))
                .fluidOutputs(Mendelevium.getFluid(L))
                .EUt(VA[UHV])
                .duration(240)
                .CasingTier(3)
                .buildAndRegister();

        //  C + Cm -> No
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Carbon.getFluid(L))
                .fluidInputs(Curium.getFluid(L))
                .fluidOutputs(Nobelium.getFluid(L))
                .EUt(VA[UHV])
                .duration(190)
                .CasingTier(3)
                .buildAndRegister();

        //  B + Cf -> Lr
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(Boron.getFluid(L))
                .fluidInputs(Californium.getFluid(L))
                .fluidOutputs(Lawrencium.getFluid(L))
                .EUt(VA[UHV])
                .duration(200)
                .CasingTier(3)
                .buildAndRegister();

        //  Free Electron Gas -> Quantum Anomaly
        COLLIDER_RECIPES.recipeBuilder()
                .fluidInputs(FreeElectronGas.getFluid(L))
                .chancedOutput(QUANTUM_ANOMALY, 1000, 0)
                .EUt(VA[ZPM])
                .duration(200)
                .CasingTier(2)
                .buildAndRegister();

        //  Ichorium -> Void Metal
        COLLIDER_RECIPES.recipeBuilder()
                .notConsumable(QUANTUM_ANOMALY)
                .fluidInputs(Ichorium.getFluid(L))
                .fluidOutputs(VoidMetal.getFluid(L))
                .EUt(VA[UV])
                .duration(120)
                .CasingTier(2)
                .buildAndRegister();
    }
}
