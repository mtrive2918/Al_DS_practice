package org.mypractice.ds.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of MaxHeap using ArrayList.
 * @param <T> Comparable Type
 */
public class ArraylistMaxHeap<T extends Comparable<T>> implements MaxHeap<T> {

    private final List<T> elements;

    public ArraylistMaxHeap() {
        elements = new ArrayList<>();
    }


    @Override
    public boolean add(T element) {
        int current = elements.size();
        elements.add(null);
        maxHeapifyTowardsRoot(current, element);
        return true;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public T getTop() {
        return getMax();
    }

    @Override
    public T extractTop() {
        return extractMax();
    }

    @Override
    public T getMax() {
        return !elements.isEmpty() ? elements.get(0) : null;
    }

    @Override
    public T extractMax() {
        if (elements.isEmpty()) {
            return null;
        }
        final T max = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        maxHeapifyTowardsLeaves(0);
        return max;
    }

    @Override
    public boolean update(int index, T element) {
        return maxHeapifyTowardsRoot(index, element);
    }

    private boolean maxHeapifyTowardsRoot(int index, T element) {
        if (index < 0 || index >= elements.size()
                || (elements.get(index) != null && elements.get(index).compareTo(element) >= 0)) {
            return false;
        }
        int current = index;
        int parentIndex = getParentIndex(current);
        while (parentIndex >= 0
                && elements.get(parentIndex) != null
                && elements.get(parentIndex).compareTo(element) < 0) {
            elements.set(current, elements.get(parentIndex));
            current = parentIndex;
            parentIndex = getParentIndex(current);
        }
        elements.set(current, element);
        return true;
    }

    private void maxHeapifyTowardsLeaves(int index) {
        if (elements.isEmpty() || index >= elements.size()) {
            return;
        }
        T element = elements.get(index);
        int current = index;
        int right = getRightChildIndex(current);
        int left = getLeftChildIndex(current);
        int maxIndex = elements.size() - 1;
        while (left <= maxIndex || right <= maxIndex) {
            if ((left <= maxIndex && elements.get(left).compareTo(element) > 0)
                    && (right > maxIndex ||  elements.get(left).compareTo(elements.get(right)) >= 0)) {
                elements.set(current, elements.get(left));
                current = left;
            } else if(right <= maxIndex && elements.get(right).compareTo(element) > 0) {
                elements.set(current, elements.get(right));
                current = right;
            } else {
                break;
            }
            left = getLeftChildIndex(current);
            right = getRightChildIndex(current);
        }
        elements.set(current, element);
    }

    private int getParentIndex(int index) {
        return index == 0 ? -1 : getParentIndexPositiveNonZero(index);
    }

    private int getParentIndexPositiveNonZero(int index) {
        return index % 2 == 0 ? (index - 1) / 2 : index / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

}
