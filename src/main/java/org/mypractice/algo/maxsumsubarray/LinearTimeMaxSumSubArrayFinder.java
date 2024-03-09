package org.mypractice.algo.maxsumsubarray;

/**
 * MaxSumSubArrayFinder implementation for linear time complexity
 * Approach:
 * MaxSubArray(0, i + 1) = Max(MaxSubArray(0, i), MaxSubArray with the i+1 element)
 * MaxSubArray with i + 1 element can be calculated in O(1) time using MaxSubArray with i element
 */
public class LinearTimeMaxSumSubArrayFinder implements MaxSumSubArrayFinder {

    @Override
    public int[] find(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[3];
        result[0] = nums[0];
        int[] maxWithLast = new int[2];
        maxWithLast[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            updateMaxWithLast(maxWithLast, nums[i], i);
            if (maxWithLast[0] > result[0]) {
                result[0] = maxWithLast[0];
                result[1] = maxWithLast[1];
                result[2] = i;
            }
        }
        return result;
    }

    private void updateMaxWithLast(final int[] maxWithLast, int currentLast, int currentIndex) {
        if (maxWithLast[0] + currentLast < currentLast) {
            maxWithLast[0] = currentLast;
            maxWithLast[1] = currentIndex;
        } else {
            maxWithLast[0] = maxWithLast[0] + currentLast;
        }
    }
}
