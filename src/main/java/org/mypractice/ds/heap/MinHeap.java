package org.mypractice.ds.heap;

/**
 * Binary Heap data structure with the topmost element as the minimum of
 * all the elements.
 * Provides O(1) time min element lookup and rest of the operations with
 * O(log n) time complexity.
 */
public interface MinHeap<T extends Comparable<T>> extends Heap<T> {

    /**
     * Returns the most min elements as compared to all the elements of
     * the heap without removing it from the Heap.
     * Time Complexity: O(1)
     * @return Minimum element
     */
    T getMin();

    /**
     * Returns the most min elements as compared to all the elements of
     * the heap. The returned element is removed from the Heap and the
     * heap is updated to maintain its minHeap property.
     * Time Complexity: O(log n)
     * @return Minimum element
     */
    T extractMin();

    /**
     * Updates the element at the given index with the new element if the
     * current element is comparatively higher than the newer one. it then
     * compares the new element with all the elements in the path towards
     * the root element to find the appropriate position for the new element.
     * Time Complexity: O(log n)
     * @param index index where the element needs to be updated
     * @param element new element
     * @return boolean value indicating if the update was successful
     */
    boolean update(int index, T element);
}
