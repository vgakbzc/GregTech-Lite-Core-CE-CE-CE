package magicbook.gtlitecore.api.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import magicbook.gtlitecore.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * Transform class of {@link I18n}.
 *
 * @author Mezz (original author), Magic_Sweepy
 *
 * <p>
 *     This class is used for some translation situation like {@code RecipeMap} property.
 *     Because {@link I18n} is deprecated, so we add a transform class. We referenced the
 *     class {@code mezz/jei/utils/Translator} which has same function as this class.
 *     Thanks vfyjxf teach me how to resolved Client-only problem of {@code I18n},
 *     and create method ({@link #format(String, String)}). Another hint: in Minecraft 1.7.10
 *     forge, also has a same function class which named by {@code StatCollector}.
 * </p>
 *
 * @see net.minecraft.client.resources.I18n
 * @see I18n
 *
 * @since 2.8.7-beta
 */
@SuppressWarnings("deprecation")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Translator {

    /**
     * Format with Client and Server two names.
     *
     * @author vfyjxf
     *
     * <p>
     *     Please use it for {@code RecipeProperty} init (because it needs on server side),
     *     this step is in {@link CommonProxy#registerRecipes(RegistryEvent.Register)}.
     *     otherwise init maybe cause server-side crash because server side can not cast {@link net.minecraft.client.resources.I18n} class.
     * </p>.
     *
     * @param clientName  Client side localized name.
     * @param serverName  Server name (use english).
     * @return            Same as same name method in {@link net.minecraft.client.resources.I18n}, but this method is server supported.
     */
    public static String format(String clientName, String serverName) {
        return FMLLaunchHandler.side() == Side.CLIENT ? clientHelper(clientName) : serverName;
    }

    /**
     * Client name helper.
     *
     * @author vfyjxf
     *
     * @param clientName  Client side localized name, i.e. {@code I18n.format(clientName)}.
     * @return            Return a client name by {@code format()} in {@link net.minecraft.client.resources.I18n}.
     */
    public static String clientHelper(String clientName) {
        return net.minecraft.client.resources.I18n.format(clientName);
    }

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
            GTLiteLog.logger.error("Format error: {}", s, var4);
            return "Format error: " + s;
        }
    }

    @SuppressWarnings("unused")
    public static String toLowercaseWithLocale(String string) {
        return string.toLowerCase(getLocale());
    }

    @SuppressWarnings("ConstantConditions")
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
     *     Functionally, this method is like {@link #format(String, String)},
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

    @SuppressWarnings("unused")
    public static boolean isServer() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer();
    }

    public static boolean isDedicatedServer() {
        return FMLCommonHandler.instance().getSide().isServer();
    }
}
