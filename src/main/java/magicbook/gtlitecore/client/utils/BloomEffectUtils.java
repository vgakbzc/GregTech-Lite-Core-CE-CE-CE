package magicbook.gtlitecore.client.utils;

import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.client.utils.BloomEffectUtil.getEffectiveBloomLayer;


@SideOnly(Side.CLIENT)
public class BloomEffectUtils {

    public static @Nonnull BlockRenderLayer getRealBloomLayer() {
        return getEffectiveBloomLayer();
    }
}
