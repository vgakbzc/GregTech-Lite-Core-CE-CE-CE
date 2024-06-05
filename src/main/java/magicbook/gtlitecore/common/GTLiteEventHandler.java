package magicbook.gtlitecore.common;

import gregtech.api.unification.material.event.MaterialEvent;
import magicbook.gtlitecore.api.GTLiteValues;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.unification.OrePrefixAddition;
import magicbook.gtlitecore.api.unification.materials.GTLiteMaterialPropertyAddition;
import magicbook.gtlitecore.api.unification.materials.properties.GTLiteMaterialFlagAddition;
import magicbook.gtlitecore.common.items.GTLiteTools;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.Arrays;

import static net.minecraft.util.text.TextFormatting.*;

@Mod.EventBusSubscriber(modid = GTLiteValues.MODID)
public class GTLiteEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        GTLiteMaterials.init();
        OrePrefixAddition.init();
        GTLiteMaterialPropertyAddition.init();
        GTLiteMaterialFlagAddition.init();
        GTLiteTools.init();
    }

    /**
     * Player Login Event Handler.
     *
     * @author Magic_Sweepy
     *
     * <p>
     *     This class is create a {@link PlayerEvent.PlayerLoggedInEvent},
     *     when player log in world, then send message of all useful Modpack infoes to chat.
     * </p>
     *
     * @see CommonProxy#preLoad()
     *
     * @version 2.8.8-beta
     */
    public static class PlayerLoginEventHandler {

        private static final String[] lines = {
                GOLD + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+",
                BOLD + "欢迎来到格雷科技精简版 " + GREEN + " 0.0.1-alpha " + LIGHT_PURPLE + "[preview 70]",
                "",
                GRAY + "当前游戏为" + RED + "测试版本" + GRAY + "或" + RED + "预览版本" + GRAY + "，在游玩过程中若遇到问题请及时反馈",
                GRAY + "该版本中一切内容仅供预览，不保证能够按照正常的生存模式流程进行游戏。",
                "",
                GRAY + "官方交流群组：" + YELLOW + "901147549" + GRAY + "（QQ）",
                GRAY + "问题反馈渠道：" + GREEN + "https://gitlab.com/sweep_tosho/gregtech-lite-core/-/issues",
                GOLD + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+"
        };

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
            Arrays.stream(lines).map(TextComponentString::new)
                    .forEach(event.player::sendMessage);
        }
    }
}
