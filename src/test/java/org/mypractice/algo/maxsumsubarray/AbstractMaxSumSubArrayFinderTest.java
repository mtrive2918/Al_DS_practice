package org.mypractice.algo.maxsumsubarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractMaxSumSubArrayFinderTest {

    private MaxSumSubArrayFinder maxSumSubArrayFinder;

    @BeforeEach
    public void setuo() {
        initFinder();
    }

    public abstract void initFinder();

    public MaxSumSubArrayFinder getMaxSumSubArrayFinder() {
        return maxSumSubArrayFinder;
    }

    public void setMaxSumSubArrayFinder(final MaxSumSubArrayFinder maxSumSubArrayFinder) {
        this.maxSumSubArrayFinder = maxSumSubArrayFinder;
    }

    @ParameterizedTest
    @EmptySource
    protected void empty_array(int[] nums) {
        int[] maxSubArray = maxSumSubArrayFinder.find(nums);
        Assertions.assertEquals(0, maxSubArray.length);
    }

    @ParameterizedTest(name = "Positive integer list of size: {2}")
    @MethodSource("org.mypractice.algo.maxsumsubarray.MaxSumSubArrayTestUtil#getPositiveIntArrays")
    public void postive_int_arrays(int[] nums, int[] expectedMaxSumSubArray, int size) {
        int[] result = maxSumSubArrayFinder.find(nums);
        MaxSumSubArrayTestUtil.validateMaxSubArrayResult(expectedMaxSumSubArray, result);
    }

    @ParameterizedTest(name = "Negative integer list of size: {2}")
    @MethodSource("org.mypractice.algo.maxsumsubarray.MaxSumSubArrayTestUtil#getNegativeIntArrays")
    public void negative_int_arrays(int[] nums, int[] expectedMaxSumSubArray, int size) {
        int[] result = maxSumSubArrayFinder.find(nums);
        MaxSumSubArrayTestUtil.validateMaxSubArrayResult(expectedMaxSumSubArray, result);
    }
}
