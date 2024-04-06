package org.mypractice.algo.sort;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

/**
 * Randomized Quick Sort implementation of TwoWaySorter.
 * @param <T> Comparable Generic Type
 */
@AllArgsConstructor
public class RandomizedQuickSorter<T extends Comparable<T>> extends QuickSorter<T> {

    private Random random;

    @Override
    protected int partition(List<T> input, int left, int right) {
        int randomIndex = random.nextInt(left, right + 1);
        SortUtils.swap(input, left, randomIndex);
        return super.partition(input, left, right);
    }
}
