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
        int r = 0;
        int l = len - 1;
        while (r < l) {
            T temp = reverse.get(r);
            reverse.set(r, original.get(l));
            reverse.set(l, temp);
            r++;
            l--;
        }
        return reverse;
    }
}
