package magicbook.gtlitecore.api.utils;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class GTLiteUtils {

    @Nonnull
    public static ResourceLocation gtliteId(@Nonnull String name) {
        return new ResourceLocation("gtlitecore", name);
    }
}
