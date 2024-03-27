package org.mypractice.algo.sort;

import org.mypractice.ds.heap.ArraylistMaxHeap;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(List<T> unsortedList) {
        final ArraylistMaxHeap<T> heap = new ArraylistMaxHeap<>();
        unsortedList.forEach(heap::add);
        List<T> revSorted = new ArrayList<>();
        while (!heap.isEmpty()) {
            revSorted.add(heap.extractTop());
        }
        return SortUtils.reverse(revSorted);
    }
}
