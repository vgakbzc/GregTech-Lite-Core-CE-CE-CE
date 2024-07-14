package magicbook.gtlitecore.api.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Mathematic Utilities for {@code BigInteger}.
 *
 * @author Magic_Sweepy
 *
 * <p>
 *     This class is Calculation class for {@code BigInteger},
 *     supported some method in {@link Math} (but for {@code BigInteger}).
 * </p>
 *
 * @see BigInteger
 * @see BigDecimal
 */
@SuppressWarnings("unused")
public class BigMath {

    private BigMath() {}

    /**
     * Returns the trigonometric sine of an angle.  Special cases:
     * <ul><li>If the argument is NaN or an infinity, then the
     * result is NaN.
     * <li>If the argument is zero, then the result is a zero with the
     * same sign as the argument.</ul>
     *
     * <p>The computed result must be within 1 ulp of the exact result.
     * Results must be semi-monotonic.
     *
     * @param   a   an angle, in radians.
     * @return  the sine of the argument.
     */
    public static BigDecimal sin(BigDecimal a) {
        return BigDecimal.valueOf(Math.sin(a.doubleValue()));
    }

    /**
     * Returns the trigonometric cosine of an angle. Special cases:
     * <ul><li>If the argument is NaN or an infinity, then the
     * result is NaN.</ul>
     *
     * <p>The computed result must be within 1 ulp of the exact result.
     * Results must be semi-monotonic.
     *
     * @param   a   an angle, in radians.
     * @return  the cosine of the argument.
     */
    public static BigDecimal cos(BigDecimal a) {
        return BigDecimal.valueOf(Math.cos(a.doubleValue()));
    }

    /**
     * Returns the trigonometric tangent of an angle.  Special cases:
     * <ul><li>If the argument is NaN or an infinity, then the result
     * is NaN.
     * <li>If the argument is zero, then the result is a zero with the
     * same sign as the argument.</ul>
     *
     * <p>The computed result must be within 1 ulp of the exact result.
     * Results must be semi-monotonic.
     *
     * @param   a   an angle, in radians.
     * @return  the tangent of the argument.
     */
    public static BigDecimal tan(BigDecimal a) {
        return BigDecimal.valueOf(Math.tan(a.doubleValue()));
    }

    //  TODO asin, acos, atan, exp, log, log10, sqrt, ceil, floor, pow, round

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
