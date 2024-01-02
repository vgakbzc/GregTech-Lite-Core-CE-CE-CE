package magicbook.gtlitecore;

import gregtech.common.ConfigHolder;
import magicbook.gtlitecore.api.GTLiteAPI;
import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import magicbook.gtlitecore.common.items.GTLiteMetaItems;
import magicbook.gtlitecore.common.metatileentities.GTLiteMetaTileEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid        = GTLiteCore.MODID,
     name         = GTLiteCore.NAME,
     version      = GTLiteCore.VERSION,
     dependencies = "required-after:gregtech@[2.8.5-beta,);after:gcym@[1.2.7,);after:gregtechfoodoption")
public class GTLiteCore {

    public static final String MODID = "gtlitecore";
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "0.0.1-alpha";

    @SidedProxy(modId = MODID,
                clientSide = "magicbook.gtlitecore.client.ClientProxy",
                serverSide = "magicbook.gtlitecore.common.CommonProxy")
    public static CommonProxy proxy;

    public GTLiteCore() {}

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        ConfigHolder.machines.highTierContent = true;
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        GTLiteLog.init(event.getModLog());
        GTLiteLog.logger.info("Enabled highTierContent in GregTech...");
        ConfigHolder.machines.highTierContent = true;

        GTLiteMetaItems.init();
        GTLiteMetaBlocks.init();
        GTLiteAPI.init();
        GTLiteMetaTileEntities.init();

        proxy.preLoad();
    }
}
