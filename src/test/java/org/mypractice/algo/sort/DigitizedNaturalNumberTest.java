package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mypractice.Constants;

public class DigitizedNaturalNumberTest {

    private int val;
    private DigitizedNaturalNumber num;

    @BeforeEach
    void setup() {
        val = Constants.random.nextInt(0, Integer.MAX_VALUE);
        num = DigitizedNaturalNumber.valueOf(val);
    }

    @Test
    void get_sort_enum() {
        Digit lowest = Digit.valueOf(val % 10);
        Assertions.assertEquals(lowest, num.getSortEnum());
    }

    @Test
    void sort_enum_class() {
        Assertions.assertEquals(Digit.class, num.getEnumClass());
    }

    @Test
    void to_string() {
        Assertions.assertEquals(Integer.toString(val), num.toString());
    }

    @Test
    void compare_to() {
        DigitizedNaturalNumber lower = DigitizedNaturalNumber.valueOf(val - 1);
        DigitizedNaturalNumber equal = DigitizedNaturalNumber.valueOf(val);
        DigitizedNaturalNumber upper = DigitizedNaturalNumber.valueOf(val + 1);
        Assertions.assertEquals(1, num.compareTo(lower));
        Assertions.assertEquals(0, num.compareTo(equal));
        Assertions.assertEquals(-1, num.compareTo(upper));
    }

    @Test
    void generator_without_radix() {
        Assertions.assertEquals(val, num.getIntegerVal());
    }

    @Test
    void generator_valid_radix() {
        DigitizedNaturalNumber num = DigitizedNaturalNumber.valueOf(val, 16);
        Assertions.assertEquals(val, num.getIntegerVal());
    }

    @Test
    void generator_invalid_radix_lower() {
        DigitizedNaturalNumber num = DigitizedNaturalNumber.valueOf(val, 1);
        Assertions.assertEquals(val, num.getIntegerVal());
    }

    @Test
    void generator_invalid_radix_upper() {
        DigitizedNaturalNumber num = DigitizedNaturalNumber.valueOf(val, 40);
        Assertions.assertEquals(val, num.getIntegerVal());
    }

    @Test
    void generator_negative_number() {
        Assertions.assertThrows(NumberFormatException.class, () -> DigitizedNaturalNumber.valueOf(-1));
    }
}
