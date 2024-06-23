package magicbook.gtlitecore;

import gregtech.common.ConfigHolder;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.misc.WirelessEnergyNetworkWorldSavedData;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import magicbook.gtlitecore.integration.GTLiteIntegration;
import magicbook.gtlitecore.integration.appliedenergistics2.AE2RegisterManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid        = GTLiteCore.MODID,
     name         = GTLiteCore.NAME,
     version      = GTLiteCore.VERSION,
     acceptedMinecraftVersions = "[1.12.2,1.13)",
     dependencies = "required-after:gregtech@[2.8.7-beta,);" +
                             "after:gcym@[1.2.8,);" +
                             "after:gregtechfoodoption@[1.11.1,);")
public class GTLiteCore {

    public static final String MODID = "gtlitecore";
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "0.0.1-alpha";

    @SidedProxy(modId = MODID,
                clientSide = "magicbook.gtlitecore.client.ClientProxy",
                serverSide = "magicbook.gtlitecore.common.CommonProxy")
    public static CommonProxy proxy;

    private static AE2RegisterManager ae2RegisterManager;

    public GTLiteCore() {}

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        ConfigHolder.machines.highTierContent = true;
        ConfigHolder.machines.enableHighTierSolars = true;
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        ae2RegisterManager = new AE2RegisterManager();

        GTLiteLog.logger.info("Enabled highTierContent in GregTech...");
        ConfigHolder.machines.highTierContent = true;

        GTLiteLog.logger.info("Enabled highTierSolars in GregTech...");
        ConfigHolder.machines.enableHighTierSolars = true;

        GTLiteMetaItems.init();
        GTLiteMetaBlocks.init();
        GTLiteAPI.init();
        GTLiteMetaTileEntities.init();

        proxy.preLoad();

        ae2RegisterManager.onPreInit(event);
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        GTLiteLog.logger.info("Registering Integration Modules...");
        GTLiteIntegration.onInit();

        ae2RegisterManager.onInit(event);

        MinecraftForge.EVENT_BUS.register(new WirelessEnergyNetworkWorldSavedData());
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        ae2RegisterManager.onPostInit(event);
    }

    public static AE2RegisterManager getAE2RegisterManager() {
        return ae2RegisterManager;
    }
}
