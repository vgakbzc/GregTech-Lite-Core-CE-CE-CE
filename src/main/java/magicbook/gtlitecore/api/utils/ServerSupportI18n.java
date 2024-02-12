package magicbook.gtlitecore.api.utils;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Server side Support I18n
 *
 * @author vfyjxf
 *
 * <p>
 *     Thanks vfyjxf create this class and help me to learn it.
 * </p>
 */
public class ServerSupportI18n {

    /**
     * @param clientName Client side localized name.
     * @param serverName Server name (use english).
     * @return Same as I18n.format(), but this method is server supported. Please use it for Recipe Property init (in Common Proxy).
     */
    public static String format(String clientName, String serverName) {
        return FMLLaunchHandler.side() == Side.CLIENT ? clientHelper(clientName) : serverName;
    }

    /**
     * @param clientName Client side localized name, i.e. I18n.format().
     * @return Same as  I18n.format().
     */
    public static String clientHelper(String clientName) {
        return I18n.format(clientName);
    }
}
