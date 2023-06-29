package org.mypractice.algo.sort;

import java.util.List;

public abstract class AbstractTwoWaySorter<T extends Comparable<T>> implements TwoWaySorter<T> {

    @Override
    public List<T> sort(List<T> unsortedList, SortOrder sortOrder) {
        final List<T> updatedList = sort(unsortedList);
        if (SortOrder.DOWN == sortOrder) {
            SortUtils.reverse(updatedList);
        }
        return updatedList;
    }

    abstract List<T> sort(List<T> unsortedList);
}
