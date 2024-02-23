package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SortUtils {

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
