package magicbook.gtlitecore.integration.appliedenergistics2;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AE2RegisterManager {

    public AE2RegisterManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onPreInit(FMLPreInitializationEvent event) {

    }

    public void onInit(FMLInitializationEvent event) {

    }

    public void onPostInit(FMLPostInitializationEvent event) {

    }


}
