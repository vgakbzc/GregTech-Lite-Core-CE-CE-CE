package magicbook.gtlitecore.common.covers;

import gregtech.api.GTValues;
import gregtech.api.cover.CoverDefinition;
import gregtech.api.items.behavior.CoverItemBehavior;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.CoverConveyor;
import gregtech.common.covers.CoverPump;
import gregtech.common.covers.CoverRoboticArm;
import gregtech.common.covers.CoverSolarPanel;
import magicbook.gtlitecore.GTLiteCore;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import net.minecraft.util.ResourceLocation;

public class GTLiteCoverBehavior {

    public static void init() {

        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "pump.ulv"), GTLiteMetaItems.ELECTRIC_PUMP_ULV,
                (def, tile, side) -> new CoverPump(def, tile, side, GTValues.ULV, 320));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "conveyor.ulv"), GTLiteMetaItems.CONVEYOR_MODULE_ULV,
                (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.ULV, 4));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "robot_arm.ulv"), GTLiteMetaItems.ROBOT_ARM_ULV,
                (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.ULV, 4));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "pump.max"), GTLiteMetaItems.ELECTRIC_PUMP_MAX,
                (def, tile, side) -> new CoverPump(def, tile, side, GTValues.MAX, 1048576));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "conveyor.max"), GTLiteMetaItems.CONVEYOR_MODULE_MAX,
                (def, tile, side) -> new CoverConveyor(def, tile, side, GTValues.MAX, 1024));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID, "robot_arm.max"), GTLiteMetaItems.ROBOT_ARM_MAX,
                (def, tile, side) -> new CoverRoboticArm(def, tile, side, GTValues.MAX, 1024));
        registerBehavior(new ResourceLocation(GTLiteCore.MODID,  "solar_panel.max"), GTLiteMetaItems.COVER_SOLAR_PANEL_MAX,
                (def, tile, side) -> new CoverSolarPanel(def, tile, side, GTValues.V[GTValues.MAX]));
    }

    public static void registerBehavior(ResourceLocation coverId,
                                        MetaItem.MetaValueItem placerItem,
                                        CoverDefinition.CoverCreator behaviorCreator) {
        CoverDefinition coverDefinition = gregtech.common.covers.CoverBehaviors.registerCover(coverId, placerItem.getStackForm(), behaviorCreator);
        placerItem.addComponents(new CoverItemBehavior(coverDefinition));
    }
}
