package magicbook.gtlitecore.common.items;

import gregtech.api.items.toolitem.IGTTool;
import gregtech.api.items.toolitem.ItemGTTool;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.items.toolitem.ToolOreDict;
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
    }
}
