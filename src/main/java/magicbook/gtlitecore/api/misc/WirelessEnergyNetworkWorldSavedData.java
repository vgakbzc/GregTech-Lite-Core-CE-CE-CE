package magicbook.gtlitecore.api.misc;

import magicbook.gtlitecore.api.utils.GTLiteLog;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static magicbook.gtlitecore.api.misc.GlobalVariableStorage.WirelessEnergy;

/**
 * Global Energy World Saved Data
 *
 * <p>
 *     This class is create a wireless energy network for gteu,
 *     and the original class is from <a href="https://github.com/GTNewHorizons/GT5-Unofficial">GT5u</a>,
 *     please see this path 'src/main/java/gregtech/common/misc/WirelessEnergyNetworkWorldSavedData.java' in GT5u.
 * </p>
 *
 * @since 2.8.7-beta
 */
public class WirelessEnergyNetworkWorldSavedData extends WorldSavedData {

    public static WirelessEnergyNetworkWorldSavedData INSTANCE;

    private static final String DATA_NAME = "WirelessEnergyNetworkWorldSavedData";
    private static final String NBT_TAG = "WirelessEnergyNBTTag";

    public WirelessEnergyNetworkWorldSavedData() {
        super(DATA_NAME);
    }

    public WirelessEnergyNetworkWorldSavedData(String name) {
        super(name);
    }

    public static void init(World world) {
        WirelessEnergy.clear();
        MapStorage storage = world.getMapStorage();

        INSTANCE = (WirelessEnergyNetworkWorldSavedData) storage.getOrLoadData(WirelessEnergyNetworkWorldSavedData.class, DATA_NAME);
        if (INSTANCE == null) {
            INSTANCE = new WirelessEnergyNetworkWorldSavedData();
            storage.setData(DATA_NAME, INSTANCE);
        }
        INSTANCE.markDirty();
    }

    @SubscribeEvent
    public void registerWorldLoadEvent(WorldEvent.Load event) {
        if (!event.getWorld().isRemote && event.getWorld().provider.getDimension() == 0) {
            init(event.getWorld());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        try {
            byte[] byteArray = tagCompound.getByteArray(NBT_TAG);
            InputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object data = objectInputStream.readObject();
            HashMap<Object, BigInteger> hashData = (HashMap<Object, BigInteger>) data;
            for (Map.Entry<Object, BigInteger> entry : hashData.entrySet()) {
                WirelessEnergy.put(UUID.fromString(entry.getKey().toString()), entry.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            GTLiteLog.logger.error("Loaded " + NBT_TAG + " failed.");
        }
    }

    @NotNull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(WirelessEnergy);
            objectOutputStream.flush();
            byte[] data = byteArrayOutputStream.toByteArray();
            tagCompound.setByteArray(NBT_TAG, data);
        } catch (IOException e) {
            GTLiteLog.logger.error("Saved " + NBT_TAG + " failed.");
        }
        return tagCompound;
    }
}
