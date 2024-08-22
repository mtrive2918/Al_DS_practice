package org.mypractice.algo.sort;


import lombok.Setter;

public class DigitizedNaturalNumber implements Comparable<DigitizedNaturalNumber>, Enumable {

    private static final int MIN_RADIX = 2;
    private static final int MAX_RADIX = 36;
    private static final int DECIMAL_RADIX = 10;
    private static final String NEGATIVE_NUMBER_EXCEPTION_MSG = "Digitized natural number cannot be negative";

    final private Digit[] digits = new Digit[33];
    private int radix = 10;
    @Setter
    private int sortIndex = 32;

    public static DigitizedNaturalNumber valueOf(int value) {
        return valueOf(value, DECIMAL_RADIX);
    }

    public static DigitizedNaturalNumber valueOf(int value, int radix) {
        if (value < 0) {
            throw new NumberFormatException(NEGATIVE_NUMBER_EXCEPTION_MSG);
        }
        final DigitizedNaturalNumber dInt = new DigitizedNaturalNumber();
        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            dInt.radix = DECIMAL_RADIX;
        } else {
            dInt.radix = radix;
        }
        int pos = 32;
        while (value >= dInt.radix) {
            dInt.digits[pos--] = Digit.valueOf(value % dInt.radix);
            value = value / dInt.radix;
        }
        dInt.digits[pos--] = Digit.valueOf(value);
        // pad with higher order zeros
        while (pos >= 0) {
            dInt.digits[pos--] = Digit.ZERO;
        }
        return dInt;
    }

    public int getIntegerVal() {
        int pos = 32;
        int value = 0;
        while (pos >= 0) {
            value += (int)Math.pow(radix, (32 - pos)) * digits[pos].getDecimalVal();
            pos--;
        }
        return value;
    }

    @Override
    public int compareTo(DigitizedNaturalNumber o) {
        return this.getIntegerVal() - o.getIntegerVal();
    }

    @Override
    public Enum<?> getSortEnum() {
        return this.digits[sortIndex];
    }

    @Override
    public Class<?> getEnumClass() {
        return digits[0].getDeclaringClass();
    }

    @Override
    public String toString() {
        return Integer.toString(getIntegerVal());
    }
}
