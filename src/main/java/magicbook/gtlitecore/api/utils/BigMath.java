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
@SuppressWarnings("unused")
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

    /**
     * @param values  Long value.
     * @return        Summarized values.
     */
    public static BigInteger summarizedValue(long[] values) {
        BigInteger retValue = BigInteger.ZERO;
        long currentSum = 0;

        for (long value : values) {
            if (currentSum != 0 && value > Long.MAX_VALUE - currentSum) {
                retValue = retValue.add(BigInteger.valueOf(currentSum));
                currentSum = 0;
            }
            currentSum += value;
        }

        if (currentSum != 0) {
            retValue = retValue.add(BigInteger.valueOf(currentSum));
        }

        return retValue;
    }

    /**
     * Used to `clamp` a value ({@code BigInteger}) to a given range.
     *
     * <p>
     *     This function will `clamp` a value to given range,
     *     If {@code value} smaller than {@code min}, then return {@code min},
     *     and if {@code value} bigger than or equal to {@code min}, then check it
     *     if bigger than {@code max}, and return the smaller one.
     * </p>
     *
     * @param value  Origin value which will be clamped.
     * @param min    Range Minimium point.
     * @param max    Range Maximium point.
     * @return       Value in given range.
     *
     * @see GTLiteUtility#clamp(int, int, int)
     * @see GTLiteUtility#clamp(double, double, double)
     */
    public static BigInteger clamp(BigInteger value, BigInteger min, BigInteger max) {
        int result = value.compareTo(min);
        if (result < 0) {
            return min;
        } else {
            return min(value, max);
        }
    }

}
