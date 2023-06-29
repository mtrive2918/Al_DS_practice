package org.mypractice.algo.sort;

import java.util.List;

/**
 * Interface used for sorting comparable type objects in both non-decreasing and non-increasing order
 * @param <T> Comparable Type
 */
public interface TwoWaySorter<T extends Comparable<T>> {

    /**
     * Method to sort a list of comparable type of objects
     * @param unsortedList unsorted list of objects
     * @param sortOrder required order in which to sort the objects.
     * @return sorted list.
     */
    List<T> sort(final List<T> unsortedList, final SortOrder sortOrder);
}
