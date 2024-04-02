package org.mypractice.ds.heap;

import java.util.ArrayList;

public class ArrayListMinHeap<T extends Comparable<T>> implements MinHeap<T> {

    private final ArrayList<T> elements;

    public ArrayListMinHeap() {
        elements = new ArrayList<>();
    }

    @Override
    public boolean add(T element) {
        int current = elements.size();
        elements.add(null);
        return minHeapifyTowardsRoot(current, element);
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
        return getMin();
    }

    @Override
    public T extractTop() {
        return extractMin();
    }

    @Override
    public T getMin() {
        return !elements.isEmpty() ? elements.get(0) : null;
    }

    @Override
    public T extractMin() {
        if (elements.isEmpty()) {
            return null;
        }
        final T min = elements.get(0);
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        minHeapifyTowardsLeaves(0);
        return min;
    }

    @Override
    public boolean update(int index, T element) {
        return minHeapifyTowardsRoot(index, element);
    }

    private int getParentIndex(int index) {
        return index == 0 ? -1 : getNonZeroParentIndex(index);
    }

    private int getNonZeroParentIndex(int index) {
        return index % 2 == 0 ? (index - 1) / 2 : index / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean isIndexValid(int index) {
        return index < elements.size() && index >= 0;
    }

    private boolean isNewElementLowerThanCurrent(int index, T element) {
        return isIndexValid(index) && element != null
                && (elements.get(index) == null || element.compareTo(elements.get(index)) < 0);
    }

    private boolean minHeapifyTowardsRoot(int index, T element) {
        if (!isNewElementLowerThanCurrent(index, element)) {
            return false;
        }
        int current = index;
        int parent = getParentIndex(current);
        while (parent >= 0) {
            if (element.compareTo(elements.get(parent)) < 0) {
                elements.set(current, elements.get(parent));
                current = parent;
                parent = getParentIndex(current);
            } else {
                break;
            }
        }
        elements.set(current, element);
        return true;
    }

    private boolean minHeapifyTowardsLeaves(int index) {
        if (!isIndexValid(index)) {
            return false;
        }
        int maxIndex = elements.size() - 1;
        int current = index;
        T currentElement = elements.get(current);
        int left = getLeftChildIndex(current);
        int right = getRightChildIndex(current);
        while (left <= maxIndex || right <= maxIndex) {
            if ((left <= maxIndex && elements.get(left).compareTo(currentElement) < 0)
            && (right > maxIndex || elements.get(left).compareTo(elements.get(right)) < 0)) {
                elements.set(current, elements.get(left));
                current = left;
            } else if (right <= maxIndex && elements.get(right).compareTo(currentElement) < 0) {
                elements.set(current, elements.get(right));
                current = right;
            } else {
                break;
            }
            left = getLeftChildIndex(current);
            right = getRightChildIndex(current);
        }
        elements.set(current, currentElement);
        return true;
    }

}
