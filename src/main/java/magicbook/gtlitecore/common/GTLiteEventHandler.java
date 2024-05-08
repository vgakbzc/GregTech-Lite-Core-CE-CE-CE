package magicbook.gtlitecore.common;

import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.common.ConfigHolder;
import magicbook.gtlitecore.api.GTLiteValues;
import magicbook.gtlitecore.api.annotations.MaterialIDChecker;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.unification.OrePrefixAddition;
import magicbook.gtlitecore.api.unification.materials.*;
import magicbook.gtlitecore.api.unification.materials.properties.GTLiteMaterialFlagAddition;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.items.GTLiteTools;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GTLiteValues.MODID)
public class GTLiteEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) throws IllegalAccessException {
        GTLiteLog.logger.info("Registering Materials...");
        GTLiteMaterials.init();
        //  GTLiteLog.logger.info("Starting check all Material ID in Material classes...");
        //  initMaterialIDChecker();
        //  GTLiteLog.logger.info("Check completed!");
        OrePrefixAddition.init();
        GTLiteLog.logger.info("Registering Material Properties...");
        GTLiteMaterialPropertyAddition.init();
        GTLiteLog.logger.info("Registering Material Flags...");
        GTLiteMaterialFlagAddition.init();
        GTLiteLog.logger.info("Registering Tools...");
        GTLiteTools.init();
    }

    /**
     * Init Material ID Checker, this is a crude processor of annotation.
     *
     * <p>
     *     Commonly used this function in dev environment (so use this method cautiously),
     *     just add this to Event bus to predicate Material classes in {@code gtlitecore}.
     *     Only be effective when {@code debug} mode at {@link ConfigHolder#misc} enabled.
     * </p>
     *
     * @throws IllegalAccessException  Check Material ID Range by {@link MaterialIDChecker}.
     */
    @SuppressWarnings("unused")
    public static void initMaterialIDChecker() throws IllegalAccessException {
        if (ConfigHolder.misc.debug) {
            GTLiteElementMaterials.checkMaterialID();
            GTLiteFirstDegreeMaterials.checkMaterialID();
            GTLiteSecondDegreeMaterials.checkMaterialID();
            GTLiteOrganicChemistryMaterials.checkMaterialID();
            GTLiteHighDegreeMaterials.checkMaterialID();
            GTLiteUnknownCompositionMaterials.checkMaterialID();
            GTLiteThirdDegreeMaterials.checkMaterialID();
            GTLiteModCompatibilityMaterials.checkMaterialID();
        }
    }
}
