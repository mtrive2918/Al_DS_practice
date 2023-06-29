package org.mypractice.algo.sort;

import java.util.List;

/**
 * This class defines the insertion sort implementation of the TwoWaySorter interface.
 * @param <T> Comparable type
 */
public class InsertionTwoWaySorter<T extends Comparable<T>> implements TwoWaySorter<T> {

    private InsertionSorter<T> sorter = new InsertionSorter<>();

    private SortUtils utils = new SortUtils();

    @Override
    public List<T> sort(List<T> unsortedList, SortOrder sortOrder) {
        final List<T> updatedList = sorter.sort(unsortedList);
        if (SortOrder.DOWN == sortOrder) {
            utils.reverse(updatedList);
        }
        return updatedList;
    }

}
