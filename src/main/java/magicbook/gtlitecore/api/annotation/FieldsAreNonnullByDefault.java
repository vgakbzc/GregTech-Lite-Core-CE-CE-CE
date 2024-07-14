package magicbook.gtlitecore.api.annotation;

import org.jetbrains.annotations.NotNull;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Field-level {@code NotNull} Annotation
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This Annotation combines the following Annotations:
 *     <ul>
 *         <li>{@link NotNull}: Indicates that the elements annotated are guaranteed not to be {@code null};</li>
 *         <li>{@link TypeQualifierDefault}: Specifies that the default type qualifier for fields is applied.</li>
 *     </ul>
 * </p>
 *
 * @see NotNull
 * @see TypeQualifierDefault
 *
 * @since 2.8.10-beta
 */
@NotNull
@TypeQualifierDefault(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsAreNonnullByDefault {
}
