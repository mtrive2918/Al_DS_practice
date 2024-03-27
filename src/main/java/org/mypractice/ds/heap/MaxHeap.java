package org.mypractice.ds.heap;

/**
 * Max Heap data structure that provides O(1) time max element lookup and rest
 * of the operations in O(log n) time complexity.
 * @param <T> Comparable type that would define the element type of the MaxHeap.
 */
public interface MaxHeap< T extends Comparable<T>> extends Heap<T> {

    /**
     * Returns the max element of the Heap without removing it from the heap.
     * Time Complexity: O(1)
     * @return Element which is max as compared to the elements of the MaxHeap.
     */
    T getMax();

    /**
     * Returns the max element of the Heap and removes it from the heap.
     * The MaxHeap then corrects itself to have the max element as the root of the Heap.
     * Time Complexity: O(log n)
     * @return Element which is max as compared to the elements of the MaxHeap.
     */
    T extractMax();

    /**
     * Updates the element at a valid index given that the new element is equal or greater
     * than the existing element.
     * Time Complexity: O(log n)
     * @param index the index of the element to update.
     * @param element the new element that would replace the current element at the given index.
     */
    boolean update(int index, T element);


}
