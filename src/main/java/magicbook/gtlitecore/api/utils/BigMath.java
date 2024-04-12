package magicbook.gtlitecore.api.utils;

import java.math.BigInteger;

/**
 * Math class of BigInteger.
 *
 * <p>
 *     This class is {@link Math} for {@link BigInteger},
 *     used to support some common calculates.
 * </p>
 *
 * TODO other methods.
 */
public class BigMath {

    private BigMath() {}

    /**
     * Returns the smaller of two {@code BigInteger} values.
     * If the arguments have the same value, the result is that same value.
     *
     * @param a  an argument.
     * @param b  another argument.
     * @return   the smallest of {@code a} and {@code b}.
     */
    public static BigInteger min(BigInteger a, BigInteger b) {
        int result = a.compareTo(b);
        BigInteger minValue;
        if (result < 0) {
            minValue = a;
        } else {
            minValue = b;
        }
        return minValue;
    }

    /**
     * Returns the bigger of two {@code BigInteger} values.
     * If the arguments have the same value, the result is that same value.
     *
     * @param a  an argument.
     * @param b  another argument.
     * @return   the biggest of {@code a} and {@code b}.
     */
    public static BigInteger max(BigInteger a, BigInteger b) {
        int result = a.compareTo(b);
        BigInteger maxValue;
        if (result < 0) {
            maxValue = b;
        } else {
            maxValue = a;
        }
        return maxValue;
    }

}
