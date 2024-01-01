package magicbook.gtlitecore.common.items;

import gregtech.api.GTValues;
import gregtech.api.items.toolitem.*;
import gregtech.common.items.ToolItems;
import gregtech.common.items.tool.BlockRotatingBehavior;
import gregtech.common.items.tool.EntityDamageBehavior;
import gregtech.common.items.tool.GrassPathBehavior;
import gregtech.common.items.tool.RotateRailBehavior;
import gregtech.core.sound.GTSoundEvents;
import magicbook.gtlitecore.GTLiteCore;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.init.SoundEvents;

public class GTLiteTools {

    public static IGTTool COMBINATION_WRENCH;
    public static IGTTool UNIVERSAL_SPADE;
    public static IGTTool ELECTRIC_JACKHAMMER_LV;
    public static IGTTool ELECTRIC_JACKHAMMER_HV;
    public static IGTTool ELECTRIC_JACKHAMMER_IV;

    private GTLiteTools() {}

    public static void init() {

        COMBINATION_WRENCH = ToolItems.register(
                ItemGTTool.Builder
                        .of(GTLiteCore.MODID, "combination_wrench")
                        .toolStats(b -> b
                                .blockBreaking()
                                .crafting()
                                .sneakBypassUse()
                                .attackDamage(1.0F)
                                .attackSpeed(-2.8F)
                                .behaviors(BlockRotatingBehavior.INSTANCE, new EntityDamageBehavior(3.0F, EntityGolem.class)))
                        .sound(GTSoundEvents.WRENCH_TOOL, true)
                        .oreDict(ToolOreDict.toolWrench)
                        .secondaryOreDicts(ToolOreDict.toolHammer.toString(), "craftingToolWrench", "craftingToolHardHammer")
                        .toolClasses(ToolClasses.WRENCH, ToolClasses.HARD_HAMMER)
        );

        UNIVERSAL_SPADE = ToolItems.register(
                ItemGTTool.Builder
                        .of(GTLiteCore.MODID, "universal_spade")
                        .toolStats(b -> b
                                .blockBreaking()
                                .crafting()
                                .sneakBypassUse()
                                .attackSpeed(3.0F)
                                .attackSpeed(-2.4F)
                                .behaviors(GrassPathBehavior.INSTANCE, RotateRailBehavior.INSTANCE))
                        .sound(SoundEvents.ENTITY_ITEM_BREAK)
                        .oreDict(ToolOreDict.toolShovel)
                        .secondaryOreDicts(ToolOreDict.toolCrowbar.toString(), ToolOreDict.toolSpade.toString(), ToolOreDict.toolSaw.toString(), "craftingToolSaw")
                        .toolClasses(ToolClasses.CROWBAR, ToolClasses.SHOVEL, ToolClasses.SAW)
        );

        ELECTRIC_JACKHAMMER_LV = ToolItems.register(
                ItemGTTool.Builder
                        .of(GTLiteCore.MODID, "electric_jackhammer.lv")
                        .toolStats(b -> b
                                .blockBreaking()
                                .attacking()
                                .crafting()
                                .damagePerCraftingAction(2)
                                .attackDamage(1.0F)
                                .attackSpeed(-2.8F)
                                .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_LV)
                                .behaviors(new EntityDamageBehavior(2.0F, EntityGolem.class)))
                        .oreDict(ToolOreDict.toolHammer)
                        .secondaryOreDicts(new String[]{"craftingToolHardHammer"})
                        .sound(SoundEvents.BLOCK_ANVIL_LAND, true)
                        .toolClasses("pickaxe", "hammer")
                        .electric(GTValues.LV)
        );

        ELECTRIC_JACKHAMMER_HV = ToolItems.register(
                ItemGTTool.Builder
                        .of(GTLiteCore.MODID, "electric_jackhammer.hv")
                        .toolStats(b -> b
                                .blockBreaking()
                                .attacking()
                                .crafting()
                                .damagePerCraftingAction(2)
                                .attackDamage(3.0F)
                                .attackSpeed(-2.8F)
                                .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_HV)
                                .behaviors(new EntityDamageBehavior(6.0F, EntityGolem.class)))
                        .oreDict(ToolOreDict.toolHammer)
                        .secondaryOreDicts(new String[]{"craftingToolHardHammer"})
                        .sound(SoundEvents.BLOCK_ANVIL_LAND, true)
                        .toolClasses("pickaxe", "hammer")
                        .electric(GTValues.HV)
        );

        ELECTRIC_JACKHAMMER_IV = ToolItems.register(
                ItemGTTool.Builder
                        .of(GTLiteCore.MODID, "electric_jackhammer.iv")
                        .toolStats(b -> b
                                .blockBreaking()
                                .attacking()
                                .crafting()
                                .damagePerCraftingAction(2)
                                .attackDamage(5.0F)
                                .attackSpeed(-2.8F)
                                .brokenStack(ToolHelper.SUPPLY_POWER_UNIT_IV)
                                .behaviors(new EntityDamageBehavior(10.0F, EntityGolem.class)))
                        .oreDict(ToolOreDict.toolHammer)
                        .secondaryOreDicts(new String[]{"craftingToolHardHammer"})
                        .sound(SoundEvents.BLOCK_ANVIL_LAND, true)
                        .toolClasses("pickaxe", "hammer")
                        .electric(GTValues.IV)
        );

    }
}
