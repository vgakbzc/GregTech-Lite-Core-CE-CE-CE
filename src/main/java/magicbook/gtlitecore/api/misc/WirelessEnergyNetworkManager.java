package magicbook.gtlitecore.api.misc;

import magicbook.gtlitecore.api.utils.GTLiteLog;

import java.math.BigInteger;
import java.util.UUID;

import static magicbook.gtlitecore.api.misc.GlobalVariableStorage.WirelessEnergy;
import static magicbook.gtlitecore.api.misc.WirelessEnergyNetworkWorldSavedData.INSTANCE;

/**
 * Wireless Network Manager
 *
 * <p>
 *     This class is create a wireless energy network for gteu,
 *     and the original class is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>,
 *     please see this path 'src/main/java/gregtech/common/misc/WirelessEnergyNetworkManager.java' in GT5u.
 * </p>
 */
public class WirelessEnergyNetworkManager {

    private WirelessEnergyNetworkManager() {}

    /**
     * Strong check or add a new user to Network.
     *
     * <p>
     *     Used to put a default data for every player,
     *     means 1 uuid and 1 default wireless energy stored (default: {@link BigInteger#ZERO}).
     * </p>
     *
     * @param uuid  UUID of player.
     */
    public static void strongCheckOrAddUser(UUID uuid) {
        if (!WirelessEnergy.containsKey(uuid)) {
            WirelessEnergy.put(uuid, BigInteger.ZERO);
        }
    }

    /**
     * Add EU to Wireless Energy Network.
     *
     * <p>
     *     You can enter a negative number to subtract it.
     *     If the value goes below 0 it will return false and not perform the operation.
     *     {@link BigInteger}s have much slower operations than longs/ints,
     *     you should call these methods as infrequently as possible,
     *     and bulk store values to add to the global map.
     * </p>
     *
     * @param uuid    UUID of player.
     * @param energy  Interaction energy.
     * @return        Check if energy can interaction with Wireless Energy Network.
     */
    public static boolean addEUToWirelessEnergyNetwork(UUID uuid,
                                                       BigInteger energy) {
        //  Mark the data as dirty and in need of saving.
        try {
            INSTANCE.markDirty();
        } catch (Exception e) {
            GTLiteLog.logger.warn("Could not mark global energy as dirty in add EU.");
        }

        //  Get total energy stored.
        BigInteger totalEnergy = WirelessEnergy.getOrDefault(uuid, BigInteger.ZERO);
        totalEnergy = totalEnergy.add(energy);

        //  If there is sufficient energy, then complete the operation and return true.
        if (totalEnergy.signum() >= 0) {
            WirelessEnergy.put(uuid, totalEnergy);
            return true;
        }
        //  There is insufficient energy, so cancel the operation and return false.
        return false;
    }

    /**
     * Add EU to Wireless Energy Network.
     *
     * <p>
     *     Same as {@link #addEUToWirelessEnergyNetwork(UUID, BigInteger)},
     *     but use long as energy data type.
     * </p>
     *
     * @param uuid    UUID of player.
     * @param energy  Interaction energy.
     * @return        Check if energy can interaction with Wireless Energy Network.
     */
    public static boolean addEUToWirelessEnergyNetwork(UUID uuid,
                                                       long energy) {
        return addEUToWirelessEnergyNetwork(uuid, BigInteger.valueOf(energy));
    }

    /**
     * Add EU to Wireless Energy Network.
     *
     * <p>
     *     Same as {@link #addEUToWirelessEnergyNetwork(UUID, BigInteger)},
     *     but use int as energy data type.
     * </p>
     * @param uuid    UUID of player.
     * @param energy  Interaction energy/
     * @return        Check if energy can interaction with Wireless Energy Network.
     */
    public static boolean addEUToWirelessEnergyNetwork(UUID uuid,
                                                       int energy) {
        return addEUToWirelessEnergyNetwork(uuid, BigInteger.valueOf(energy));
    }

    /**
     * Get wireless energy by UUID.
     *
     * @param uuid  UUID of player.
     * @return      Energy stored of speical UUID.
     */
    public static BigInteger getUserEU(UUID uuid) {
        return WirelessEnergy.getOrDefault(uuid, BigInteger.ZERO);
    }

    /**
     * Set energy to special UUID player's network.
     *
     * <p>
     *     This overwrites the EU in the network.
     *     Only use this if you are absolutely sure you know what you are doing.
     * </p>
     *
     * @param uuid    UUID of player.
     * @param energy  Energy stored of special UUID.
     */
    public static void setUserEU(UUID uuid,
                                 BigInteger energy) {
        //  Mark the data as dirty and in need of saving.
        try {
            INSTANCE.markDirty();
        } catch (Exception e) {
            GTLiteLog.logger.warn("Could not mark global energy as dirty in set EU.");
        }

        WirelessEnergy.put(uuid, energy);
    }

    /**
     * Clear wireless energy network information.
     *
     * <p>
     *     WARNING: Do not use this unless you are 100% certain you know what you are doing.
     * </p>
     */
    public static void clearWirelessEnergyInformation() {
        WirelessEnergy.clear();
    }
}
