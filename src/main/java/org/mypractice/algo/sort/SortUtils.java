package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class to define methods used by sorter classes.
 */
public final class SortUtils {

    /**
     * restricting instantiation
     */
    private SortUtils(){}

    /**
     * Method to reverse the list.
     * @param original List
     * @return reversed list
     * @param <T> Type of objects in the list
     */
    public static <T> List<T> reverse(final List<T> original) {
        if (original == null) {
            return Collections.emptyList();
        }
        final List<T> reverse = new ArrayList<>(original);
        int len = original.size();
        int l = 0;
        int r = len - 1;
        while (l < r) {
            swap(reverse, l, r);
            l++;
            r--;
        }
        return reverse;
    }

    public static <T> boolean isNullOrEmpty(List<T> input) {
        return input == null || input.isEmpty();
    }

    public static <T> void swap(List<T> input, int first, int second) {
        if (first == second) {
            return;
        }
        T temp = input.get(first);
        input.set(first, input.get(second));
        input.set(second, temp);
    }
}
