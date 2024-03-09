package org.mypractice.algo.maxsumsubarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public final class MaxSumSubArrayTestUtil {

    private static final List<Integer> POSITIVE_INT_ARRAY_SIZES = List.of(1, 2, 5, 16, 31);

    private static final List<Integer> NEGATIVE_INT_ARRAY_SIZES = List.of(4, 11);

    /*
    Map
    key: random int list with range [-100, 100] with sizes: 9, 16, 33, 48
    value: max sum sub array result int list. (sum, start index, end index)
     */
    private static final Map<List<Integer>, List<Integer>> RANDOM_INT_ARRAY_MAP =
            Map.of(
                    List.of(-4, -42, 78, -20, 83, -54, -24, -79, 42),
                    List.of(141, 2, 4),
                    List.of(-55, -33, 3, -63, -41, 85, 26, -93, -84, -66, -47, 33, -25, 87, 80, 32),
                    List.of(207, 11, 15),
                    List.of(70, 91, -44, -72, -66, 91, 79, 14, 29, -42, -5, 48, 76, -41, -66, -31, -31,
                            -34, -67, 84, 4, -41, -37, -16, -8, 53, 23, 77, 48, 80, 0, -80, -12),
                    List.of(290, 5, 12),
                    List.of(-53, -91, 56, 55, -30, -58, -35, 15, -88, 57, 9, 23, -32, -97, 25, 50, 2,
                            -48, 88, 31, 30, 54, 13, -3, 88, 95, -40, 94, -92, -84, -53, 91, 33, 70, 63, -59, 98,
                            58, -71, -96, -14, -52, -31, 29, 37, -81, 85, 1),
                    List.of(604, 14, 37)
            );

    private static final long SEED = 104L;

    private static final Random random = new Random(SEED);

    static void validateMaxSubArrayResult(int[] expectedMaxSumSubArray, int[] actualMaxSumSubArray) {
        Assertions.assertEquals(expectedMaxSumSubArray[0], actualMaxSumSubArray[0], "max sum not as expected");
        Assertions.assertEquals(expectedMaxSumSubArray[1], actualMaxSumSubArray[1], "max sum sub array start index not as expected");
        Assertions.assertEquals(expectedMaxSumSubArray[2], actualMaxSumSubArray[2], "max sum sub array end index not as expected");
    }

    static Stream<Arguments> getPositiveIntArrays() {
        return POSITIVE_INT_ARRAY_SIZES.stream().map(MaxSumSubArrayTestUtil::getArgumentsForPositiveIntArray);
    }

    static Stream<Arguments> getNegativeIntArrays() {
        return NEGATIVE_INT_ARRAY_SIZES.stream().map(MaxSumSubArrayTestUtil::getArgumentsForNegativeIntArray);
    }

    static Stream<Arguments> getRandomIntArrays() {
        return RANDOM_INT_ARRAY_MAP.entrySet().stream().
                map(entry -> Arguments.of(entry.getKey().stream().mapToInt(Integer::intValue).toArray(),
                        entry.getValue().stream().mapToInt(Integer::intValue).toArray(), entry.getKey().size()));
    }

    private static Arguments getArgumentsForPositiveIntArray(final int size) {
        final int[] nums = random.ints(size, 0, 101).toArray();
        final int[] maxSumResult = new int[3];
        maxSumResult[0] = Arrays.stream(nums).sum();
        maxSumResult[2] = nums.length -1;
        return Arguments.of(nums, maxSumResult, size);
    }

    private static Arguments getArgumentsForNegativeIntArray(final int size) {
        final int[] nums = random.ints(size, -100, 0).toArray();
        final int[] maxSumResult = new int[3];
        maxSumResult[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxSumResult[0] < nums[i]) {
                maxSumResult[0] = nums[i];
                maxSumResult[1] = i;
                maxSumResult[2] = i;
            }
        }
        return Arguments.of(nums, maxSumResult, size);
    }

}
