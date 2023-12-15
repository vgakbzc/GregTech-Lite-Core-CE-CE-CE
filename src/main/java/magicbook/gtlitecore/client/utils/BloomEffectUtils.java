package magicbook.gtlitecore.client.utils;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.client.utils.BloomEffectUtil.getEffectiveBloomLayer;


@SideOnly(Side.CLIENT)
public class BloomEffectUtils {

    public static @NotNull BlockRenderLayer getRealBloomLayer() {
        return getEffectiveBloomLayer();
    }
}
