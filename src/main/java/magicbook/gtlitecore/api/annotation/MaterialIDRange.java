package magicbook.gtlitecore.api.annotation;

import magicbook.gtlitecore.api.annotation.processor.MaterialIDProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Material ID Range Annotation.
 *
 * @author Gate Guardian, Magic_Sweepy
 *
 * <p>
 *     This Annotation is a Runtime Annotation about Material Registry,
 *     each class which use this Annotation will allowed to set a range
 *     of Material ID, and then Processor will automatically generated
 *     all ID of Materials in that class.
 * </p>
 *
 * <p>
 *     Only can put this Annotation in class head, and this class must
 *     be a Material class (GregTech form). You can use {@link #startID()}
 *     to set the start point of ID range, and use {@link #endID()} to
 *     set the end point of ID range. If Material ID is out of ID range,
 *     then Processor will throws a {@code IllegalStateException} to hint.
 *     If you want to use this Annotation, then should use related method
 *     to register Material ID list (correspondence to class by a Hash),
 *     and use {@link MaterialIDProvider#getID()} to get auto-generated
 *     ID of each Materials in class.
 * </p>
 *
 * @see MaterialIDProvider
 *
 * @since 2.8.8-beta
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaterialIDRange {

    int startID() default 0;
    int endID() default 0;
}
