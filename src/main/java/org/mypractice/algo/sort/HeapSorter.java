package org.mypractice.algo.sort;

import org.mypractice.ds.heap.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSorter<T extends Comparable<T>> implements TwoWaySorter<T> {

    private final MaxHeap<T> maxHeap = new ArraylistMaxHeap<>();

    private final MinHeap<T> minHeap = new ArrayListMinHeap<>();

    @Override
    public List<T> sort(List<T> unsortedList, SortOrder sortOrder) {
        if (SortUtils.isNullOrEmpty(unsortedList)) {
            return Collections.emptyList();
        }
        Heap<T> heap = sortOrder == SortOrder.NON_DECREASING ? minHeap : maxHeap;
        unsortedList.forEach(heap::add);
        List<T> sorted = new ArrayList<>();
        while (!heap.isEmpty()) {
            sorted.add(heap.extractTop());
        }
        return sorted;
    }
}
