package magicbook.gtlitecore.loaders.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.recipe.GTLiteRecipeMaps.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class CosmicFabricChain {

    public static void init() {

        //  todo memory foam plate and fullerene fiber recipes

        //  Cosmic Fabric
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(foil, ZBLANGlass)
                .input(plate, Spacetime)
                .input(MEMORY_FOAM_PLATE, 2)
                .input(FULLERENE_FIBER, 4)
                .fluidInputs(FluorinatedEthylenePropylene.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .output(COSMIC_FABRIC)
                .EUt(VA[UEV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  back to stellar furnace and plasma condenser recipes

    }
}
