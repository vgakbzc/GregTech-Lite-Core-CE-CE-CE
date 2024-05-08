package magicbook.gtlitecore.api.unification.materials;

import magicbook.gtlitecore.api.annotations.MaterialIDChecker;
import magicbook.gtlitecore.api.utils.GTLiteLog;

import java.lang.reflect.Field;

@MaterialIDChecker(startID = 21001, endID = 22000)
public class GTLiteModCompatibilityMaterials {

    //  Range: 21001-22000
    private static int startId = 21001;
    private static final int endId = startId + 999;

    //  TODO empty now, but in some version can add it from gtlite's craft tweaker files.
    public static void register() {
        //  21001 Dark Steel

        //  21002 Electrical Steel

        //  21003 Energetic Alloy

        //  21004 Vibrant Alloy

        //  21005 End Steel

        //  21006 Redstone Alloy

        //  21007 Conductive Iron

        //  21008 Pulsating Iron

        //  21009 Soularium

        //  21010 Crystalline Alloy

        //  21011 Melodic Alloy

        //  21012 Stellar Alloy

        //  21013 Crystalline Pink Slime

        //  21014 Energetic Silver

        //  21015 Vivid Alloy

        //  21016 Construction Alloy

        //  Free ID: 21016-21030

        //  21031 Lumium

        //  21032 Signalum

        //  21033 Enderium
    }

    private static int getId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void checkMaterialID() throws IllegalAccessException {
        for (Field field : GTLiteModCompatibilityMaterials.class.getFields()) {
            MaterialIDChecker checker = field.getAnnotation(MaterialIDChecker.class);
            if (checker != null) {
                Object startID = field.get(startId);
                Object endID = field.get(endId);
                if (startID instanceof Integer start && endID instanceof Integer end) {
                    if (start != checker.startID()) {
                        GTLiteLog.logger.warn("Start ID in Target Material class " + field.getName() + " seems have some conflicts or errors.");
                    } else {
                        GTLiteLog.logger.info("Start ID in Target Material class " + field.getName() + " has no problem.");
                    }
                    if (end != checker.endID()) {
                        GTLiteLog.logger.warn("End ID in Target Material class " + field.getName() + " seems have some conflicts or errors.");
                    } else {
                        GTLiteLog.logger.info("End ID in Target Material class " + field.getName() + " has no probelm.");
                    }
                }
            }
        }
    }

}
