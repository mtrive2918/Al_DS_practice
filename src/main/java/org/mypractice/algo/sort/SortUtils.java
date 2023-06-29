package org.mypractice.algo.sort;

import java.util.List;

public final class SortUtils {

    <T> void reverse(final List<T> original) {
        if (original == null) {
            return;
        }
        int len = original.size();
        int r = 0;
        int l = len - 1;
        while (r < l) {
            T temp = original.get(r);
            original.set(r, original.get(l));
            original.set(l, temp);
            r++;
            l--;
        }
    }
}
