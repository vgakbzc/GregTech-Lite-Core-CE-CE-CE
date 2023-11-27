package magicbook.gtlitecore.loaders;

import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;

import static magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities.*;

public class MachineRecipeLoader {
    public static void init() {
        SingleMachineRecipes();
        MultiblockControllerRecipes();
    }

    private static void SingleMachineRecipes() {

        //  Chemical Dryer
        MetaTileEntityLoader.registerMachineRecipe(true, CHEMICAL_DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL);

        //  TODO Steam Vacuum Chamber

        //  Vacuum Chamber
        MetaTileEntityLoader.registerMachineRecipe(true, VACUUM_CHAMBER,
                "GCG", "PHP", "GWG",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'P', CraftingComponent.PUMP,
                'G', CraftingComponent.GLASS,
                'H', CraftingComponent.HULL);

    }

    private static void MultiblockControllerRecipes() {

    }
}
