package magicbook.gtlitecore.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.util.text.translation.I18n;

import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * Transform class of {@link I18n}.
 *
 * <p>
 *     Because the class {@link I18n} is deprecated, so we add a transform class of this class.
 *     The original class is {@code mezz/jei/utils/Translator}.
 *     Another hint: in Minecraft 1.7.10 forge, this class named by {@code StatCollector}.
 * </p>
 *
 * @since 2.8.7-beta
 */
@SuppressWarnings("all")
public final class Translator {

    private Translator() {}

    /**
     * Translates a Stat name.
     *
     * @param   key  Translation Key.
     * @return  If {@link I18n#canTranslate(String)} is true, then return translation,
     *          if not, then return fallback translation (a string translate instance using the hardcoded default locale, i.e. English).
     */
    public static String translateToLocal(String key) {
        return I18n.canTranslate(key) ? I18n.translateToLocal(key) : I18n.translateToFallback(key);
    }

    public static String translateToLocalFormatted(String key, Object... format) {
        String s = translateToLocal(key);
        try {
            return String.format(s, format);
        } catch (IllegalFormatException var4) {
            IllegalFormatException e = var4;
            GTLiteLog.logger.error("Format error: {}", s, e);
            return "Format error: " + s;
        }
    }

    public static String toLowercaseWithLocale(String string) {
        return string.toLowerCase(getLocale());
    }

    private static Locale getLocale() {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (minecraft != null) {
            LanguageManager languageManager = minecraft.getLanguageManager();
            if (languageManager != null) {
                Language currentLanguage = languageManager.getCurrentLanguage();
                if (currentLanguage != null) {
                    return currentLanguage.getJavaLocale();
                }
            }
        }

        return Locale.getDefault();
    }
}
