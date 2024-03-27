package org.mypractice.debug;

import java.util.Arrays;

public class Experiment {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        System.out.println("\nFinding median for arrays: \n"
                            + Arrays.toString(nums1) + "\n"
                            + Arrays.toString(nums2));
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
        System.out.println("startA: " + startA
                + ", endA: " + endA
                + ", startB: " + startB
                + ", endB: " + endB);
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

        System.out.println("midA: " + midA + ", valueMidA: " + valueMidA + ", midB: " + midB + ", valueMidB: " + valueMidB);

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

    public void run() {
        int[] nums1 = {1, 3, 7};
        int[] nums2 = {2, 11, 14, 21};

        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
        System.out.println("Median: " + findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("Median: " + findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8 , 10}));
    }
}
