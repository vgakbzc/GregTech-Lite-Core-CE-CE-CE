package magicbook.gtlitecore.loaders.handlers;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.toolitem.IGTTool;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import magicbook.gtlitecore.common.items.GTLiteTools;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

import static gregtech.api.unification.material.properties.PropertyKey.*;
import static gregtech.common.items.MetaItems.*;

public class ToolRecipeHandler {

    public static void register() {
        OrePrefix.plate.addProcessingHandler(PropertyKey.TOOL, ToolRecipeHandler::processTool);
    }

    private static void processTool(OrePrefix prefix, Material material, ToolProperty property) {

        UnificationEntry rod = new UnificationEntry(OrePrefix.stick, material);
        UnificationEntry plate = new UnificationEntry(OrePrefix.plate, material);
        UnificationEntry ingot = new UnificationEntry(material.hasProperty(GEM) ? OrePrefix.gem : OrePrefix.ingot, material);

        if (material.hasFlag(MaterialFlags.GENERATE_PLATE) && !material.hasFlag(MaterialFlags.NO_SMASHING)) {
            addToolRecipe(material, GTLiteTools.COMBINATION_WRENCH, true,
                    "PhP", "IPI", "fP ",
                    'I', ingot,
                    'P', plate);
            if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {

                addToolRecipe(material, GTLiteTools.UNIVERSAL_SPADE, true,
                        "hPP", "DRP", "RDf",
                        'P', plate,
                        'D', new UnificationEntry(OrePrefix.dye, MarkerMaterials.Color.Blue),
                        'R', rod);

                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_LV.getMaxChargeOverrideStack(100000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_LV.get(material, 0, powerUnit.getMaxCharge());
                        }
                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.lv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "hRf", "PHP", "PPP",
                                    'R', rod,
                                    'P', plate,
                                    'H', powerUnits[i]);
                        }
                    }
                }

                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_HV.getMaxChargeOverrideStack(1600000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_HV.get(material, 0, powerUnit.getMaxCharge());
                        }

                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.hv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "hRf", "PHP", "PPP",
                                    'R', rod,
                                    'P', plate,
                                    'H', powerUnits[i]);
                        }
                    }
                }

                if (property.getToolDurability() > 0) {
                    ItemStack[] powerUnits = {
                            POWER_UNIT_IV.getMaxChargeOverrideStack(25600000L)
                    };

                    for (int i = 0; i < powerUnits.length; i++) {
                        IElectricItem powerUnit = powerUnits[i].getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                        ItemStack toolItem = null;
                        if (powerUnit != null) {
                            toolItem = GTLiteTools.ELECTRIC_JACKHAMMER_IV.get(material, 0, powerUnit.getMaxCharge());
                        }

                        if (toolItem != null) {
                            ModHandler.addShapedEnergyTransferRecipe(String.format("%s_%s", "electric_jackhammer.iv", material, i),
                                    toolItem,
                                    Ingredient.fromStacks(powerUnits[i]), true, true,
                                    "hRf", "PHP", "PPP",
                                    'R', rod,
                                    'P', plate,
                                    'H', powerUnits[i]);
                        }
                    }
                }
            }

        }
    }

    public static void addToolRecipe(@Nonnull Material material,
                                     @Nonnull IGTTool tool,
                                     boolean mirrored, Object... recipe) {
        if (mirrored) {
            ModHandler.addMirroredShapedRecipe(String.format("%s_%s", tool.getToolId(), material),
                    tool.get(material), recipe);
        } else {
            ModHandler.addShapedRecipe(String.format("%s_%s", tool.getToolId(), material),
                    tool.get(material), recipe);
        }
    }
}
