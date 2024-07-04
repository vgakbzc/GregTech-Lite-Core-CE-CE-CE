package magicbook.gtlitecore.common.covers;

import gregtech.api.cover.CoverDefinition;
import gregtech.api.items.behavior.CoverItemBehavior;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.common.covers.*;

import static gregtech.api.GTValues.*;
import static magicbook.gtlitecore.api.utils.GTLiteUtility.gtliteId;
import static magicbook.gtlitecore.common.items.GTLiteMetaItems.*;

public class GTLiteCoverBehavior {

    public static void init() {
        registerBehavior("pump.ulv",        ELECTRIC_PUMP_ULV,     (def, tile, side) -> new CoverPump(def, tile, side, ULV, 320));
        registerBehavior("conveyor.ulv",    CONVEYOR_MODULE_ULV,   (def, tile, side) -> new CoverConveyor(def, tile, side, ULV, 4));
        registerBehavior("robot_arm.ulv",   ROBOT_ARM_ULV,         (def, tile, side) -> new CoverRoboticArm(def, tile, side, ULV, 4));
        registerBehavior("pump.max",        ELECTRIC_PUMP_MAX,     (def, tile, side) -> new CoverPump(def, tile, side, MAX, 1048576));
        registerBehavior("conveyor.max",    CONVEYOR_MODULE_MAX,   (def, tile, side) -> new CoverConveyor(def, tile, side, MAX, 1024));
        registerBehavior("robot_arm.max",   ROBOT_ARM_MAX,         (def, tile, side) -> new CoverRoboticArm(def, tile, side, MAX, 1024));
        registerBehavior("solar_panel.uhv", COVER_SOLAR_PANEL_UHV, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[UHV]));
        registerBehavior("solar_panel.uev", COVER_SOLAR_PANEL_UEV, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[UEV]));
        registerBehavior("solar_panel.uiv", COVER_SOLAR_PANEL_UIV, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[UIV]));
        registerBehavior("solar_panel.uxv", COVER_SOLAR_PANEL_UXV, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[UXV]));
        registerBehavior("solar_panel.opv", COVER_SOLAR_PANEL_OpV, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[OpV]));
        registerBehavior("solar_panel.max", COVER_SOLAR_PANEL_MAX, (def, tile, side) -> new CoverSolarPanel(def, tile, side, V[MAX]));
    }

    /**
     * Used to register Cover Behavior to Meta Item.
     *
     * <p>
     *     Register {@link CoverBehaviors} to Meta Item.
     *     This method used internal {@code ResourceLocation} to package original method,
     *     when use this method to register, {@code ResouceLocation} of behavior is always in {@code gtlitecore}.
     * </p>
     *
     * @param name             Behavior name.
     * @param placerItem       Meta Item which this Cover correspondenced.
     * @param behaviorCreator  Cover Creater which you want this behavior actioned.
     *
     * @since 2.8.4-beta
     */
    public static void registerBehavior(String name,
                                        MetaItem<?>.MetaValueItem placerItem,
                                        CoverDefinition.CoverCreator behaviorCreator) {
        CoverDefinition coverDefinition = CoverBehaviors.registerCover(gtliteId(name), placerItem.getStackForm(), behaviorCreator);
        placerItem.addComponents(new CoverItemBehavior(coverDefinition));
    }
}
