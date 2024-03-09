package org.mypractice;

import org.mypractice.algo.maxsumsubarray.DnCMaxSumSubArrayFinder;
import org.mypractice.algo.maxsumsubarray.MaxSumSubArrayFinder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static MaxSumSubArrayFinder maxSumSubArrayFinder = new DnCMaxSumSubArrayFinder();

    private static final List<Integer> SIZES = List.of(9, 16, 33, 48);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Random random = new Random(104L);
        for (int size : SIZES) {
            int[] nums = random.ints(size, -100, 101).toArray();
            System.out.println("Input Array: " + Arrays.toString(nums));
            int[] maxSumSubArray = maxSumSubArrayFinder.find(nums);
            System.out.println("Max sum sub array: " + Arrays.toString(maxSumSubArray));
        }



    }
}