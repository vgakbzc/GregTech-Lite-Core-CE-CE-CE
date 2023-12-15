package magicbook.gtlitecore.client;

import magicbook.gtlitecore.api.utils.GTLiteLog;
import magicbook.gtlitecore.client.renderer.StructureSelectRenderer;
import magicbook.gtlitecore.client.utils.ShaderUtils;
import magicbook.gtlitecore.common.CommonProxy;
import magicbook.gtlitecore.common.blocks.GTLiteMetaBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preLoad() {
        super.preLoad();
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        ShaderUtils.initShaders();
        GTLiteTextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GTLiteLog.logger.info("Registering block models...");
        GTLiteMetaBlocks.registerItemModels();
    }

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event) {
        StructureSelectRenderer.render(event);
    }
}
