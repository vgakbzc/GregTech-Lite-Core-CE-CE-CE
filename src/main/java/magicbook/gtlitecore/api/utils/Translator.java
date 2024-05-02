package magicbook.gtlitecore.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.FMLCommonHandler;

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

    /**
     * Common translate method.
     *
     * <p>
     *     Functionally, this method is like {@link ServerSupportI18n#format(String, String)},
     *     used for some special situation (please see effective field checker below).
     * </p>
     *
     * @param key     Translation Key.
     * @param params  Pamameters.
     * @return        If on client side, then return same like {@code I18n#format()}.
     *                If not, then return by server side {@code I18n} class,
     *                please see: {@link #translateServerSide(String, Object...)}.
     */
    public static String translate(String key, Object... params) {
        if (isDedicatedServer())
            return translateServerSide(key, params);
        try {
            return net.minecraft.client.resources.I18n.format(key, params);
        } catch (Exception e) {
            return translateServerSide(key, params);
        }
    }

    @SuppressWarnings("deprecation")
    private static String translateServerSide(String key, Object... params) {
        try {
            var localTranslated = I18n.translateToLocalFormatted(key, params);
            if (!localTranslated.equals(key))
                return localTranslated;

            var fallbackTranslated = I18n.translateToFallback(key);
            if (!fallbackTranslated.equals(key) && params.length != 0) {
                try {
                    fallbackTranslated = String.format(fallbackTranslated, params);
                } catch (IllegalFormatException var5) {
                    fallbackTranslated = "Format error: " + fallbackTranslated;
                }
            }
            return fallbackTranslated;
        } catch (Exception e) {
            return key;
        }
    }

    public static boolean isClient() {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public static boolean isServer() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer();
    }

    public static boolean isDedicatedServer() {
        return FMLCommonHandler.instance().getSide().isServer();
    }
}
