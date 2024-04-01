package org.mypractice.algo.sort;

import java.util.List;

/**
 * Interface to sort comparable type objects in a non-decreasing order
 * @param <T> Comparable Type
 */
public interface Sorter<T extends Comparable<T>> {

    /**
     * Method to sort a list of Comparable type objects
     * @param unsortedList list of unsorted Comparable type objects
     * @return sorted list of objects
     */
    List<T> sort(final List<T> unsortedList);

}
