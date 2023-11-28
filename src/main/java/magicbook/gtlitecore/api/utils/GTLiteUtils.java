package magicbook.gtlitecore.api.utils;

import gregtech.api.util.TextFormattingUtil;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class GTLiteUtils {

    @Nonnull
    public static ResourceLocation gtliteId(@Nonnull String name) {
        return new ResourceLocation("gtlitecore", name);
    }

    public static String formatNumbers(long number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    public static String formatNumbers(double number) {
        return TextFormattingUtil.formatNumbers(number);
    }
}