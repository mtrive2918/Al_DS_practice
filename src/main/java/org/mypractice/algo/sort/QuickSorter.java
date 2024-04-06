package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Quick sort implementation of the TwoWaySorter.
 * @param <T> Generic Comparable Type
 */
public class QuickSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(List<T> unsorted) {
        final List<T> mutable = new ArrayList<>(unsorted);
        quickSort(mutable, 0, mutable.size() - 1);
        return mutable;
    }

    private void quickSort(List<T> input, int left, int right){
        if (left < right) {
            int partition = partition(input, left, right);
            quickSort(input, left, partition - 1);
            quickSort(input, partition + 1, right);
        }
    }

    protected int partition(List<T> input, int left, int right) {
        final T key = input.get(left);
        int swap = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (input.get(i).compareTo(key) < 0) {
                SortUtils.swap(input, i, swap);
                swap++;
            }
        }
        SortUtils.swap(input, left, swap - 1);
        return swap - 1;
    }

}
