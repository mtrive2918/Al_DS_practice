package org.mypractice.algo.sort;

import java.util.List;

/**
 * This class defines the insertion sort implementation of the TwoWaySorter interface.
 * @param <T> Comparable type
 */
public class InsertionTwoWaySorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    private InsertionSorter<T> sorter = new InsertionSorter<>();

    @Override
    public List<T> sort(List<T> unsortedList) {
        return sorter.sort(unsortedList);
    }

}
