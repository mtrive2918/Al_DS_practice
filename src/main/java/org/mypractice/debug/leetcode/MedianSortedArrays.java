package org.mypractice.debug.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">...</a>
 */
public class MedianSortedArrays extends AbstractProblem {

    public double find(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;

        int lenC = lenA + lenB;

        if (lenC % 2 == 1) {
            return solve(nums1, nums2, lenC / 2, 0, lenA - 1, 0, lenB - 1);
        } else {
            return (double) (solve(nums1, nums2, lenC / 2, 0, lenA - 1, 0, lenB - 1)
                    + solve(nums1, nums2, lenC / 2 - 1, 0, lenA - 1, 0, lenB - 1)) / 2;
        }

    }

    private int solve(int[] arrA, int[] arrB, int k, int startA, int endA, int startB, int endB) {
//        System.out.println("startA: " + startA
//                + ", endA: " + endA
//                + ", startB: " + startB
//                + ", endB: " + endB);
        if (endA < startA) {
            return arrB[k - startA];
        }

        if (endB < startB) {
            return arrA[k - startB];
        }

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;
        int valueMidA = arrA[midA];
        int valueMidB = arrB[midB];

//        System.out.println("midA: " + midA + ", valueMidA: " + valueMidA + ", midB: " + midB + ", valueMidB: " + valueMidB);

        if (midA + midB < k) {
            if (valueMidA < valueMidB) {
                return solve(arrA, arrB, k, midA + 1, endA, startB, endB);
            } else {
                return solve(arrA, arrB, k, startA, endA, midB + 1, endB);
            }
        } else {
            if (valueMidA < valueMidB) {
                return solve(arrA, arrB, k, startA, endA, startB, midB - 1);
            } else {
                return solve(arrA, arrB, k, startA, midA - 1, startB, endB);
            }
        }
    }

    @Override
    Map<Object[], Object> getTestParams() {
        Map<List<int[]>, Double> input = Map.of(
                List.of(new int[]{1, 3, 7}, new int[]{2, 11, 14, 21}), 7.00,
                List.of(new int[]{1, 2}, new int[]{3, 4}), 2.5,
                List.of(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8 , 10}), 5.00
        );
        return input.entrySet().stream()
                .collect(Collectors.toMap(e -> {
                    int[] nums1 = e.getKey().get(0);
                    int[] nums2 = e.getKey().get(1);
                    return new Object[]{nums1, nums2};
                }, Map.Entry::getValue));
    }

    @Override
    public Class<?>[] getInputParameterType() {
        Class<?>[] paramTypes = new Class[2];
        paramTypes[0] = int[].class;
        paramTypes[1] = int[].class;
        return paramTypes;
    }

    @Override
    public Class<?> getOutputType() {
        return double.class;
    }
}
