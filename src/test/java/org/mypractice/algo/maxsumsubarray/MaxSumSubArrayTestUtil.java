package org.mypractice.algo.maxsumsubarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public final class MaxSumSubArrayTestUtil {

    private static final List<Integer> POSITIVE_INT_LIST_SIZES = List.of(1, 2, 5, 16, 31);

    private static final List<Integer> NEGATIVE_INT_LIST_SIZES = List.of(4, 11);

    private static final long SEED = 104L;

    private static final Random random = new Random(SEED);

    static void validateMaxSubArrayResult(int[] expectedMaxSumSubArray, int[] actualMaxSumSubArray) {
        Assertions.assertEquals(expectedMaxSumSubArray[0], actualMaxSumSubArray[0], "max sum not as expected");
        Assertions.assertEquals(expectedMaxSumSubArray[1], actualMaxSumSubArray[1], "max sum sub array start index not as expected");
        Assertions.assertEquals(expectedMaxSumSubArray[2], actualMaxSumSubArray[2], "max sum sub array end index not as expected");
    }

    static Stream<Arguments> getPositiveIntArrays() {
        return POSITIVE_INT_LIST_SIZES.stream().map(MaxSumSubArrayTestUtil::getArgumentsForPositiveIntArray);
    }

    private static Arguments getArgumentsForPositiveIntArray(final int size) {
        final int[] nums = random.ints(size, 0, 101).toArray();
        final int[] maxSumResult = new int[3];
        maxSumResult[0] = Arrays.stream(nums).sum();
        maxSumResult[2] = nums.length -1;
        return Arguments.of(nums, maxSumResult, size);
    }

    static Stream<Arguments> getNegativeIntArrays() {
        return NEGATIVE_INT_LIST_SIZES.stream().map(MaxSumSubArrayTestUtil::getArgumentsForNegativeIntArray);
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
