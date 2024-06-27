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
import net.minecraftforge.fml.common.event.*;

@Mod(modid        = GTLiteCore.MODID,
     name         = GTLiteCore.NAME,
     version      = GTLiteCore.VERSION,
     acceptedMinecraftVersions = "[1.12.2,1.13)",
     dependencies = "required:forge@[14.23.5.2847,);" +
                    "required-after:codechickenlib@[3.2.3,);" +
                    "required-after:gregtech@[2.8.7-beta,);" +
                             "after:gcym@[1.2.8,);" +
                             "after:gregtechfoodoption@[1.11.1,);" +
                             "after:appliedenergistics2@[v0.56.6,);" +
                             "after:ae2fc@[2.6.2-r,);" +
                             "after:nae2@[1.6.4,);" +
                             "after:libnine@[1.2.1,);" +
                             "after:threng@[1.1.26,);" +
                             "after:bdlib@[1.14.4.1,);" +
                             "after:ae2stuff@[0.9,);" +
                             "after:jei@[4.25.1,);")
public class GTLiteCore {

    /* ------------------ Internal Only Parameters ------------------ */
    public static final String MODID = "gtlitecore";
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "0.0.1-alpha";
    /* -------------------------------------------------------------- */

    //  Hint: If you want used Mod ID of {@code gtlitecore},
    //    then you should use {@code Mods.GregTechLiteCore.getID()},
    //    these parameters is only for Internal Interaction class.

    /* ------------------- Mod Instance Parameter ------------------- */
    @Mod.Instance(GTLiteCore.MODID)
    public static GTLiteCore instance;
    /* -------------------------------------------------------------- */

    //  Hint: Only used for retrieve instances of other mods.

    /* ------------------- Sided Proxy Parameter -------------------- */
    @SidedProxy(modId = GTLiteCore.MODID,
                clientSide = "magicbook.gtlitecore.client.ClientProxy",
                serverSide = "magicbook.gtlitecore.common.CommonProxy")
    public static CommonProxy proxy;
    /* -------------------------------------------------------------- */

    /* -------------------- AE2 Register Manager -------------------- */
    private static AE2RegisterManager ae2RegisterManager;
    /* -------------------------------------------------------------- */

    //  Hint: This is a Submodule Registry of {@code gtlitecore},
    //    used to add related Submodule Registry to main Event Handler.

    /* ------------------------ Constructor ------------------------- */
    public GTLiteCore() {}
    /* -------------------------------------------------------------- */

    /* ------------------ Construction Stage Event ------------------ */
    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        ConfigHolder.machines.highTierContent = true;
        ConfigHolder.machines.enableHighTierSolars = true;
    }
    /* -------------------------------------------------------------- */

    //  Hint: Construction Event means events will be loaded when Mod
    //    is starting to loaded.

    /* --------------- Pre-Initialization Stage Event --------------- */
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
    /* -------------------------------------------------------------- */

    //  Hint: Pre-Initialization Event means it will "Run before anything
    //    else". In {@code gtlitecore}, we register all basic module in
    //    this stage, like Items, Blocks and Meta Tile Entities.

    /* ----------------- Initialization Stage Event ----------------- */
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        GTLiteLog.logger.info("Registering Integration Modules...");
        GTLiteIntegration.onInit();

        ae2RegisterManager.onInit(event);

        MinecraftForge.EVENT_BUS.register(new WirelessEnergyNetworkWorldSavedData());
    }
    /* -------------------------------------------------------------- */

    //  Hint: Initialization Event means it will "Do your mod setup",
    //    you should build whatever data structures you care about.
    //    In {@code gtlitecore}, we do not use this event in common.

    /* --------------- Post-Initialization Stage Event -------------- */
    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        ae2RegisterManager.onPostInit(event);
    }
    /* -------------------------------------------------------------- */

    //  Hint: Post-Initialization event means it will "Handle interaction
    //    with other mods", you can complete your setup based on this.

    /* ----------------- Load Complete Stage Event ------------------ */
    @Mod.EventHandler
    public void onLoadComplete(FMLLoadCompleteEvent event) {}
    /* -------------------------------------------------------------- */

    //  Hint: Load Complete Event means events will be loaded when Mod
    //    is finish loaded.

    /* -------------- Server About To Start Stage Event ------------- */
    @Mod.EventHandler
    public void onServerAboutToStart(FMLServerAboutToStartEvent event) {}
    /* -------------------------------------------------------------- */

    //  Hint: Server About To Start Event means events will be loaded
    //    before Server started.

    /* ----------------- Server Started Stage Event ----------------- */
    @Mod.EventHandler
    public void onServerStarted(FMLServerStartedEvent event) {}
    /* -------------------------------------------------------------- */

    //  Hint: Server Started Event means events will be loaded when
    //    Server is started.

    /* ---------------- Server Stopping Stopping Event -------------- */
    @Mod.EventHandler
    public void onServerStopping(FMLServerStoppingEvent event) {}
    /* -------------------------------------------------------------- */

    //  Hint: Server Stopping Event means events will be loaded when
    //    Server is stopping.

    /* ----------------- Server Stopped Stage Event ----------------- */
    @Mod.EventHandler
    public void onServerStopped(FMLServerStoppedEvent event) {}
    /* -------------------------------------------------------------- */

    //  Hint: Server Stopped Event means events will be loaded when
    //    Server is stopped.

    /* ----------------------- Misc Utilities ----------------------- */

    /**
     * AE2 Register Manager Getter.
     *
     * <p>
     *     Used for registry of AE2 Base Item in {@code gtlitecore}.
     * </p>
     *
     * @return  AE2 Register Manager.
     */
    public static AE2RegisterManager getAE2RegisterManager() {
        return ae2RegisterManager;
    }

    /* -------------------------------------------------------------- */
}
