package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class CountingSorter<T extends Enumable> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(List<T> unsortedList) {
        List<T> mutable = new ArrayList<>(unsortedList);
        int len = mutable.get(0).getEnumClass().getEnumConstants().length;
        int[] counts = new int[len];
        int size = unsortedList.size();
        unsortedList.forEach(i -> counts[i.getSortEnum().ordinal()]++);
        for (int i = 1; i < len; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }
        for (int i = size - 1; i >= 0; i--) {
            T key = unsortedList.get(i);
            int pos = counts[key.getSortEnum().ordinal()] - 1;
            mutable.set(pos, key);
            counts[key.getSortEnum().ordinal()] -= 1;
        }
        return mutable;
    }
}
