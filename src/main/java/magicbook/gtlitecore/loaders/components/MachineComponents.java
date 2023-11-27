package magicbook.gtlitecore.loaders.components;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.blocks.BlockMultiblockCasing;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static magicbook.gtlitecore.api.unification.GTLiteMaterials.*;

public class MachineComponents {
    public static void init() {
        ComponentRecipes();
        MultiblockRecipes();
    }

    private static void ComponentRecipes() {

    }

    private static void MultiblockRecipes() {

        //  Substrate Casing
        ModHandler.addShapedRecipe(true, "substrate_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Palladium),
                'R', new UnificationEntry(stick, RedSteel),
                'F', new UnificationEntry(frameGt, BlueSteel));

        //  Advanced Substrate Casing
        ModHandler.addShapedRecipe(true, "advanced_substrate_casing", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.ADVANCED_SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Ruridit),
                'R', new UnificationEntry(stick, Duranium),
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        //  Drill Head
        ModHandler.addShapedRecipe(true, "drill_head", GTLiteMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.DRILL_HEAD),
                "PGP", "MHM", "SSS",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'G', new UnificationEntry(gear, Orichalcum),
                'M', ELECTRIC_MOTOR_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'S', COMPONENT_GRINDER_TUNGSTEN.getStackForm());
    }
}
