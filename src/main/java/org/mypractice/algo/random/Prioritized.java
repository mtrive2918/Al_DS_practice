package org.mypractice.algo.random;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Decorator Class to add an int value that represents the priority for the element.
 * @param <T> Generic Type
 */
@Getter
@AllArgsConstructor
public class Prioritized<T> implements Comparable<Prioritized<T>> {
    private int priority;
    private T element;

    @Override
    public int compareTo(Prioritized<T> o) {
        return priority - o.getPriority();
    }
}
