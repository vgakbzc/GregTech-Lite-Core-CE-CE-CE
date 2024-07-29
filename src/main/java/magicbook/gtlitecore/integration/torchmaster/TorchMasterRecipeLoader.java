package magicbook.gtlitecore.integration.torchmaster;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.ULV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static magicbook.gtlitecore.api.GTLiteValues.SECOND;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.getItemById;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.SENSOR_ULV;

public class TorchMasterRecipeLoader {

    public static void init() {

        //  Mega Torch
        ModHandler.removeRecipeByOutput(getItemById(Mods.TorchMaster.getID(), "mega_torch"));
        ModHandler.addShapedRecipe(true, "mega_torch", getItemById(Mods.TorchMaster.getID(), "mega_torch"),
                "TTT", "PWP", "XSX",
                'S', new UnificationEntry(stickLong, Wood),
                'W', "wool",
                'T', "torch",
                'X', new UnificationEntry(screw, Wood),
                'P', new UnificationEntry(plate, TreatedWood));

        //  Terrain Lighter
        ModHandler.removeRecipeByOutput(getItemById(Mods.TorchMaster.getID(), "terrain_lighter"));
        ModHandler.addShapedRecipe(true, "terrain_lighter", getItemById(Mods.TorchMaster.getID(), "terrain_lighter"),
                "DDD", "QMQ", "QSQ",
                'S', SENSOR_ULV,
                'Q', "slabQuartz",
                'D', new ItemStack(Blocks.DAYLIGHT_DETECTOR),
                'M', getItemById(Mods.TorchMaster.getID(), "mega_torch"));

        //  Dread Lamp
        ModHandler.removeRecipeByOutput(getItemById(Mods.TorchMaster.getID(), "dread_lamp"));
        if (Mods.AppliedEnergistics2.isModLoaded() && Mods.FutureMC.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "dread_lamp", getItemById(Mods.TorchMaster.getID(), "dread_lamp"),
                    "OPO", "GSG", "OEO",
                    'S', getItemById(Mods.FutureMC.getID(), "soul_fire_lantern"),
                    'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                    'O', new UnificationEntry(block, Obsidian),
                    'P', new UnificationEntry(plate, Obsidian),
                    'E', SENSOR_ULV);
        }

        //  Feral Flare Lantern
        ModHandler.removeRecipeByOutput(getItemById(Mods.TorchMaster.getID(), "feral_flare_lantern"));
        if (Mods.AppliedEnergistics2.isModLoaded() && Mods.FutureMC.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "feral_flare_lantern", getItemById(Mods.TorchMaster.getID(), "feral_flare_lantern"),
                    "PRP", "GLG", "PRP",
                    'L', getItemById(Mods.FutureMC.getID(), "lantern"),
                    'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                    'P', new UnificationEntry(plate, Steel),
                    'R', new UnificationEntry(ring, Gold));
        }

        //  Frozen Pearl
        ModHandler.removeRecipeByOutput(getItemById(Mods.TorchMaster.getID(), "frozen_pearl"));
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(gem, EnderPearl)
                .fluidInputs(Ice.getFluid(L * 4))
                .outputs(getItemById(Mods.TorchMaster.getID(), "frozen_pearl"))
                .EUt(VA[ULV])
                .duration(15 * SECOND)
                .buildAndRegister();

    }
}
