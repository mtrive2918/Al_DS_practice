package org.mypractice.algo.maxsumsubarray;

/**
 * Interface used to find the sub array with maximum sum within the given integer array.
 */
public interface MaxSumSubArrayFinder {

    /**
     * Method to find the sub array with maximum sum.
     * @param nums Array of postive and negative integers
     * @return Array with first element as sum, 2nd element as start index, 3rd element as end index
     * for the sub array with the maximum sum.
     * If the nums array is empty, the method would return an empty int array.
     */
    int[] find(final int[] nums);
}
