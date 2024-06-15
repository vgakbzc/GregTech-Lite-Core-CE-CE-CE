package magicbook.gtlitecore.integration.packagedauto;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.init.Items;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ELECTRIC_PISTON_HV;
import static gregtech.common.items.MetaItems.ROBOT_ARM_HV;
import static gregtech.common.metatileentities.MetaTileEntities.BUFFER;
import static gregtech.common.metatileentities.MetaTileEntities.WORKBENCH;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getItemById;
import static magicbook.gtlitecore.api.utils.GTLiteUtils.getMetaItemById;

public class PackagedAutoRecipeLoader {

    public static void init() {

        //  Packager
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "packager"));
        ModHandler.addShapedRecipe(true, "packager", getItemById(Mods.PackagedAuto.getID(), "packager"),
                "PCP", "XWX", "POP",
                'P', new UnificationEntry(plate, StainlessSteel),
                'X', getMetaItemById(Mods.GregTech.getID(), "meta_wire_fine", 32005),
                'C', getItemById(Mods.PackagedAuto.getID(), "me_package_component"),
                'W', WORKBENCH.getStackForm(),
                'O', ELECTRIC_PISTON_HV);

        //  Encoder
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "encoder"));
        if (Mods.CraftingStation.isModLoaded() && Mods.ExtraUtilities2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "encoder", getItemById(Mods.PackagedAuto.getID(), "encoder"),
                    "PCP", "WGW", "PSP",
                    'P', new UnificationEntry(plate, StainlessSteel),
                    'C', getItemById(Mods.PackagedAuto.getID(), "package_component"),
                    'W', getItemById(Mods.CraftingStation.getID(), "crafting_station"),
                    'G', getMetaItemById(Mods.ExtraUtilities2.getID(), "decorativeglass", 4),
                    'S', new UnificationEntry(screw, RedAlloy));
        }

        //  Unpackager
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "unpackager"));
        ModHandler.addShapedRecipe(true, "unpackager", getItemById(Mods.PackagedAuto.getID(), "unpackager"),
                "PCP", "SXS", "POP",
                'P', new UnificationEntry(plate, StainlessSteel),
                'C', getItemById(Mods.PackagedAuto.getID(), "me_package_component"),
                'S', new UnificationEntry(stick, RedAlloy),
                'X', BUFFER[2].getStackForm(),
                'O', new UnificationEntry(pipeNormalItem, Magnalium));

        //  Extension Packager
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "packager_extension"));
        ModHandler.addShapedRecipe(true, "extension_packager", getItemById(Mods.PackagedAuto.getID(), "packager_extension"),
                "PCP", "GWG", "PRP",
                'P', new UnificationEntry(plate, StainlessSteel),
                'C', getItemById(Mods.PackagedAuto.getID(), "me_package_component"),
                'W', WORKBENCH.getStackForm(),
                'R', ROBOT_ARM_HV,
                'G', new UnificationEntry(plate, Glowstone));

        //  Recipe Holder
        ModHandler.removeRecipeByName(Mods.PackagedAuto.getID() + ":" + "recipe_holder");
        if (Mods.AppliedEnergistics2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "recipe_holder", getItemById(Mods.PackagedAuto.getID(), "recipe_holder", 16),
                    "GPG", "PWP", "XXX",
                    'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"),
                    'P', new UnificationEntry(plate, RedAlloy),
                    'X', new UnificationEntry(plate, Polyethylene),
                    'W', getItemById(Mods.PackagedAuto.getID(), "package_component"));
        }

        //  Package Component
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "package_component"));
        ModHandler.addShapedRecipe(true, "package_component", getItemById(Mods.PackagedAuto.getID(), "package_component", 4),
                "XAX", "AWA", "XAX",
                'X', new UnificationEntry(plate, Gold),
                'A', new UnificationEntry(plate, CertusQuartz),
                'W', Items.ENDER_EYE);

        //  ME Package Component
        ModHandler.removeRecipeByOutput(getItemById(Mods.PackagedAuto.getID(), "me_package_component"));
        if (Mods.CraftTweaker.isModLoaded() && Mods.AppliedEnergistics2.isModLoaded()) {
            ModHandler.addShapedRecipe(true, "me_package_component", getItemById(Mods.PackagedAuto.getID(), "me_package_component", 16),
                    "PGP", "AXB", "PGP",
                    'P', getMetaItemById(Mods.GregTech.getID(), "meta_plate", 32015), // Ore Dict: plateConstructionAlloy
                    'X', getItemById(Mods.PackagedAuto.getID(), "package_component"),
                    'A', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 43),
                    'B', getMetaItemById(Mods.AppliedEnergistics2.getID(), "material", 44),
                    'G', getItemById(Mods.AppliedEnergistics2.getID(), "quartz_vibrant_glass"));
        }
    }
}
