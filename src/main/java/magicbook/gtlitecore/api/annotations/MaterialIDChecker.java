package magicbook.gtlitecore.api.annotations;

import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.unification.materials.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Material ID Checker
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This annotation create a checker about Material ID range,
 *     in {@code gtlitecore}, we use a private method {@code getId()}
 *     to automatically generated ID of materials (please see: {@link GTLiteMaterials}).
 *     If you want to add Material ID Checker to a Material class,
 *     then you should use a new method (like this: {@code void checkMaterialID()}),
 *     and use reflect to get {@code startId} and {@code endId} in Material class,
 *     usually, you can use {@code startId != checker.startID()} and property like this
 *     to predicate if startId (class static parameter) is equal to your setted startId.
 * </p>
 *
 * @see GTLiteFirstDegreeMaterials
 * @see GTLiteSecondDegreeMaterials
 * @see GTLiteOrganicChemistryMaterials
 * @see GTLiteHighDegreeMaterials
 * @see GTLiteUnknownCompositionMaterials
 * @see GTLiteThirdDegreeMaterials
 * @see GTLiteModCompatibilityMaterials
 *
 * @since 2.8.8-beta
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaterialIDChecker {

    int startID() default 0;
    int endID() default 0;
}
