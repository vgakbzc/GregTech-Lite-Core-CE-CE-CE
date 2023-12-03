package magicbook.gtlitecore.api.utils;

import gregtech.api.util.TextFormattingUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class GTLiteUtils {

    //  Mod id path
    @Nonnull
    public static ResourceLocation gtliteId(@Nonnull String name) {
        return new ResourceLocation("gtlitecore", name);
    }

    //  Format Numbers
    public static String formatNumbers(long number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    public static String formatNumbers(double number) {
        return TextFormattingUtil.formatNumbers(number);
    }

    //  Getter utils
    public static int getOrDefault(NBTTagCompound tag,
                                   String key,
                                   int defaultValue){
        if(tag.hasKey(key)){
            return tag.getInteger(key);
        }
        return defaultValue;
    }

    public static <T> T getOrDefault(BooleanSupplier canGet,
                                     Supplier<T> getter,
                                     T defaultValue){
        return canGet.getAsBoolean() ? getter.get() : defaultValue;
    }

    //  List utils
    public static <T> int maxLength(List<List<T>> lists) {
        return lists.stream()
                    .mapToInt(List::size)
                    .max()
                    .orElse(0);
    }

    public static <T> List<T> consistentList(List<T> list,
                                             int length) {
        if (list.size() >= length) {
            return list;
        }
        List<T> finalList = new ArrayList<>(list);
        T last = list.get(list.size() - 1);
        for (int i = 0; i < length - list.size(); i++) {
            finalList.add(last);
        }
        return finalList;
    }
}