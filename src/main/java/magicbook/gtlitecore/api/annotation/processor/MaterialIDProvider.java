package magicbook.gtlitecore.api.annotation.processor;

import magicbook.gtlitecore.api.annotation.MaterialIDRange;
import magicbook.gtlitecore.api.unification.materials.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Annotation Processor of {@link MaterialIDRange}.
 *
 * @author Gate Guardian
 *
 * <p>
 *     This class is Processor of Annotation {@link MaterialIDRange},
 *     used to dynamically catch Material IDs based annotation settings
 *     of each class which has that Annotation. Because We just use this
 *     register system in {@code gtlitecore}, so it is very unsafe.
 * </p>
 *
 * <p>
 *     This Processor search Stack Trace to get all Element related
 *     this Annotation, and use a loop to get these datas (Technically
 *     speaking, if you use JDK 9+ environment, then you can use another
 *     method to implement this function; you can use {@code StackWalker}
 *     class to modify this Processor, just use {@code getInstance()}
 *     with {@code Option.RETAIN_CLASS_REFERENCE}, and in method, you
 *     needs use {@code getCallerClass()} to catch related class).
 *     Because {@code gtlitecore} is a addition mod in Minecraft 1.12.2,
 *     we cannot use this syntax (if not, then will cause problem in run,
 *     in fact, {@code compileJava} will have some problems.).
 * </p>
 *
 * @see MaterialIDRange
 * @see GTLiteElementMaterials
 * @see GTLiteFirstDegreeMaterials
 * @see GTLiteSecondDegreeMaterials
 * @see GTLiteOrganicChemistryMaterials
 * @see GTLiteHigherDegreeMaterials
 * @see GTLiteUnknownCompositionMaterials
 * @see GTLiteThirdDegreeMaterials
 * @see GTLiteModCompatibilityMaterials
 *
 * @since 2.8.8-beta
 */
public class MaterialIDProvider {

    private static final Map<String, Integer> ID_MAP = new HashMap<>();

    public static int getID() {
        try {
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            for (int i = 0; i < elements.length; i++) {
                StackTraceElement element = elements[i];
                if (element.getClassName().equals(MaterialIDProvider.class.getName())) {
                    Class<?> callerClass = Class.forName(elements[i + 1].getClassName());
                    MaterialIDRange range = callerClass.getAnnotation(MaterialIDRange.class);
                    if (range != null) {
                        int startID = range.startID();
                        int endID = range.endID();
                        String className = callerClass.getName();
                        Integer ID = ID_MAP.computeIfPresent(className, (k, v) -> v + 1);
                        if (ID != null) {
                            if (ID > endID) {
                                throw new IllegalStateException("Material ID out of range in class " + className);
                            }
                            return ID;
                        } else {
                            if (startID > endID) {
                                throw new IllegalStateException("Material ID out of range in class " + className);
                            }
                            ID_MAP.put(className, startID);
                            return startID;
                        }
                    }
                    throw new IllegalStateException("No Material ID range annotation found at class " + callerClass.getName());
                }
            }
            throw new IllegalStateException("No caller class found.");
        } catch (ClassNotFoundException ignored) {
            throw new IllegalStateException("No caller class found.");
        }
    }
}
