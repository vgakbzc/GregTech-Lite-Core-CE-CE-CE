package magicbook.gtlitecore.api;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import magicbook.gtlitecore.GTLiteCore;
import magicbook.gtlitecore.api.unification.GTLiteMaterials;
import magicbook.gtlitecore.api.utils.Mods;
import net.minecraft.util.text.TextFormatting;

import java.math.BigInteger;
import java.util.Arrays;

import static gregtech.api.GTValues.*;

@SuppressWarnings("unused")
public class GTLiteValues {

    /**
     * Special Voltage for some recipes needs integer based energy consumed.
     * This voltage is based on {@link GTValues#V} but less than it (but more precious).
     */
    public static final int[] VZ = new int[] { 1, 30, 100, 500, 2000, 8000, 30000, 100000, 500000, 2000000, 8000000, 30000000, 100000000, 500000000, 2000000000 };

    /**
     * Particle Voltage, this voltage is exactly like {@link GTValues#VA}, but use {@code long} like {@link GTValues#V},
     * it is also lower than the recipe to use a full amperage of that tier.
     */
    public static final long[] VP = Arrays.stream(V)
            .map(i -> BigInteger.valueOf(i)
                    .multiply(BigInteger.valueOf(VA[LV]))
                    .divide(BigInteger.valueOf(V[LV]))
                    .longValueExact())
            .toArray();

    /**
     * Tier list for {@link OrePrefix#circuit}, used in some recipes.
     */
    public static final Material[] tierList = { MarkerMaterials.Tier.ULV, MarkerMaterials.Tier.LV, MarkerMaterials.Tier.MV, MarkerMaterials.Tier.HV, MarkerMaterials.Tier.EV, MarkerMaterials.Tier.IV, MarkerMaterials.Tier.LuV, MarkerMaterials.Tier.ZPM, MarkerMaterials.Tier.UV, MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX };

    /**
     * Color list for recipes (used in some special situation like {@link OrePrefix#lens}).
     */
    public static final Material[] colorList = { MarkerMaterials.Color.White, MarkerMaterials.Color.Orange, MarkerMaterials.Color.Magenta, MarkerMaterials.Color.LightBlue, MarkerMaterials.Color.Yellow, MarkerMaterials.Color.Lime, MarkerMaterials.Color.Pink, MarkerMaterials.Color.Gray, MarkerMaterials.Color.LightGray, MarkerMaterials.Color.Cyan, MarkerMaterials.Color.Purple, MarkerMaterials.Color.Blue, MarkerMaterials.Color.Brown, MarkerMaterials.Color.Green, MarkerMaterials.Color.Red, MarkerMaterials.Color.Black };

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 second = 20 tick (in game), so we can use this to add 1 second.
     */
    public static final int SECOND = 20;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 minute = 60 second = 1200 tick (in game), so we can use this to add 1 minute.
     */
    public static final int MINUTE = 60 * SECOND;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * because 1 hour = 60 minute = 3600 second, so we can use this to add 1 hour.
     */
    public static final int HOUR = 60 * MINUTE;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/2 {@link #HOUR} (means 30 minute and 1800 second).
     */
    public static final int HALF_HOUR = HOUR / 2;

    /**
     * Used for recipes, please see {@link RecipeBuilder#duration(int)},
     * just 1/4 {@link #HOUR} and 1/2 {@link #HALF_HOUR} (means 15 minute and 900 second).
     */
    public static final int QUAT_HOUR = HOUR / 4;

    /**
     * Math Unit: Kilo/Thousand (10^3).
     */
    public static final int K = (int) Math.pow(10, 3);

    /**
     * Same as {@link #K}, used to resolve conflict.
     */
    public static final int Kilo = K;

    /**
     * Math Unit: Mega/Million (10^6).
     */
    public static final int M = (int) Math.pow(10, 6);

    /**
     * Same as {@link #M}, used to resolve conflict.
     * because when use {@link #M}, it has conflict with {@link GTValues#M}.
     */
    public static final int Million = M;

    /**
     * Math Unit: Giga/Billion (10^9).
     */
    public static final int G = (int) Math.pow(10, 9);

    /**
     * Same as {@link #G}, used to resolve conflict.
     */
    public static final int Giga = G;

    /**
     * Math Unit: Tera/Trillion (10^12).
     */
    public static final int T = (int) Math.pow(10, 12);

    /**
     * Same as {@link #T}, used to resolve conflict.
     */
    public static final int Tera = T;

    /**
     * Math Unit: Peta/Quadrillion (10^15)
     */
    public static final int P = (int) Math.pow(10, 15);

    /**
     * Same as {@link #P}, used to resolve conflict.
     */
    public static final int Peta = P;

    /**
     * Math Unit: Exa/Quintillion (10^18)
     */
    public static final int E = (int) Math.pow(10, 18);

    /**
     * Same as {@link #E}, used to resolve conflict.
     */
    public static final int Exa = E;

    /**
     * Math Unit: Zetta/Sextillion (10^21)
     */
    public static final int Z = (int) Math.pow(10, 21);

    /**
     * Same as {@link #Z}, used to resolve conflict.
     */
    public static final int Zetta = Z;

    /**
     * Math Unit: Yotta/Septillion (10^24)
     */
    public static final int Y = (int) Math.pow(10, 24);

    /**
     * Same as {@link #Y}, used to resolve conflict.
     */
    public static final int Yotta = Y;

    /**
     * Special String for some {@code formula}, please see: {@link GTLiteMaterials}.
     * Commonly, we use below method {@link #formulaWithObfuscatedA(String)} for {@code formula}.
     */
    public static final String ObfuscatedA = TextFormatting.OBFUSCATED  + "a" + TextFormatting.RESET;

    /**
     * Used to add {@code formula} with two {@link #ObfuscatedA} at head and tail.
     *
     * <p>
     *     This format of {@code formula} is from {@code gregicality} originally,
     *     in that mod, formula of some high-energy material used two obfuscated symbol,
     *     of cause also at head and tail (so this method is a salute for {@code gregicality}).
     * </p>
     *
     * @param formula  Middle {@code formula}.
     * @return         Formula of {@code material}.
     */
    public static String formulaWithObfuscatedA(String formula) {
        return ObfuscatedA + formula + ObfuscatedA;
    }

    /**
     * Used to add obfuscated {@code formula}.
     *
     * @return Obfuscated {@code formula} (five a symbol, also is a salute of {@code gregicality}).
     */
    public static String addObfuscatedFormula() {
        return TextFormatting.OBFUSCATED + "aaaaaa";
    }

    /**
     * Used to add obfuscated {@code formula}.
     *
     * @param formula  Formula String.
     * @return         Obfuscated {@code formula} with string.
     */
    public static String addObfuscatedFormula(String formula) {
        return TextFormatting.OBFUSCATED + formula;
    }

    /**
     * This modid is same as {@link GTLiteCore#MODID}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     * Used {@link Mods} is also a choice, it is also appropriate.
     */
    public static final String MODID = "gtlitecore";

    /**
     * This mod name is same as {@link GTLiteCore#NAME}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String NAME = "Gregicality Science";

    /**
     * This mod version is same as {@link GTLiteCore#VERSION}.
     * Hint: this parameter is internal, we use it on class in {@code gtlitecore}.
     * Do not use this parameter in external situation (please use the first).
     */
    public static final String VERSION = "0.0.1-alpha";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_GT = "gregtech";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_GCYM = "gcym";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_GTFO = "gregtechfoodoption";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_AE2 = "appliedenergistics2";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_NAE2 = "nae2";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_XU2 = "extrautils2";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_EIO = "enderio";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_TOP = "theoneprobe";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_AC = "architecturecraft";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_AA = "actuallyadditions";

    /** @deprecated use {@link Mods}. **/
    @Deprecated
    public static final String MODID_CHISEL = "chisel";

    private GTLiteValues() {}
}
