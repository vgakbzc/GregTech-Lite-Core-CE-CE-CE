package magicbook.gtlitecore.api.misc;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.UUID;

/**
 * Global Variable Storage
 *
 * <p>
 *     The original class is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>.
 * </p>
 *
 * @since 2.8.7-beta
 */
public abstract class GlobalVariableStorage {

    public static HashMap<UUID, BigInteger> WirelessEnergy = new HashMap<>(100, 0.9f);
}
