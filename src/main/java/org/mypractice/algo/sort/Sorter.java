package org.mypractice.algo.sort;

import java.util.List;

/**
 * Interface used for sorting comparable type objects
 */
public interface Sorter<T extends Comparable<T>> {

    /**
     * method to sort list of Comparable type objects
     * @param unsortedList list of unsorted Comparable type objects
     * @return sorted list of objects
     */
    List<T> sort(final List<T> unsortedList);

}
