package org.mypractice.ds.heap;

/**
 * A data structure that provides O(1) operation to peek the
 * top most element of the collection of elements.
 * @param <T> Type that defines the elements of the Heap
 */
public interface Heap<T> {

    /**
     * Adds a new element to the MaxHeap.
     * Time Complexity: O(log n), n is the size of the Heap.
     * @param element New element that needs to be added to the MaxHeap.
     */
    boolean add(T element);

    /**
     * Returns the size of the MaxHeap.
     * Time Complexity: O(1).
     * @return an int value that equals the current size of the MaxHeap.
     */
    int size();

    /**
     * Returns true if the Heap is empty, false otherwise.
     * @return boolean value
     */
    boolean isEmpty();

    /**
     * Returns the top element of the Heap without removing it from the heap.
     * Time Complexity: O(1).
     * @return Element which is at the top/root of the Heap.
     */
    T getTop();

    /**
     * Returns the top element of the Heap and removes it from the heap.
     * The Heap then corrects itself to have the appropriate top element as the
     * root of the Heap.
     * @return Element which is at the top/root of the Heap.
     */
    T extractTop();
}
