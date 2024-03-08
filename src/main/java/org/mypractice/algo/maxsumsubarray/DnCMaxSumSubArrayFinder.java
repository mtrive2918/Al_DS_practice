package org.mypractice.algo.maxsumsubarray;

/**
 * Divide and Conquer Implementation of MaxSumSubArrayFinder
 */
public class DnCMaxSumSubArrayFinder implements MaxSumSubArrayFinder {

    @Override
    public int[] find(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        return findWithinBounds(nums, 0, nums.length - 1);
    }

    private int[] findWithinBounds(int[] nums, int left, int right) {
        int[] result = new int[3];
        if (left < right) {
            int mid = (left + right) / 2;
            int[] leftMax = findWithinBounds(nums, left, mid);
            int[] rightMax = findWithinBounds(nums, mid + 1, right);
            int[] midCrossingMax = findMidCrossing(nums, left, mid, right);
            if (midCrossingMax[0] > leftMax[0] && midCrossingMax[0] > rightMax[0]) {
                result = midCrossingMax;
            } else {
                result = leftMax[0] > rightMax[0] ? leftMax : rightMax;
            }
        } else {
            result[0] = nums[left];
            result[1] = left;
            result[2] = left;
        }
        return result;
    }

    private int[] findMidCrossing(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int leftMaxIndex = mid;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (leftSum < sum) {
                leftSum = sum;
                leftMaxIndex = i;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int rightMaxIndex = mid + 1;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (rightSum < sum) {
                rightSum = sum;
                rightMaxIndex = i;
            }
        }
        int[] result = new int[3];
        result[0] = leftSum + rightSum;
        result[1] = leftMaxIndex;
        result[2] = rightMaxIndex;

        return result;
    }
}
