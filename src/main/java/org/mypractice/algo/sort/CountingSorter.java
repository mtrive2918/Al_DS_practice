package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class CountingSorter<T extends Integer> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(List<T> unsortedList) {
        List<T> mutable = new ArrayList<>(unsortedList);
        int[] counts = new int[10];
        int size = unsortedList.size();
        unsortedList.forEach(i -> counts[i.intValue()]++);
        for (int i = 1; i < 10; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }
        for (int i = size - 1; i >= 0; i--) {
            T key = unsortedList.get(i);
            int pos = counts[key.intValue()] - 1;
            mutable.set(pos, key);
            counts[key.intValue()] -= 1;
        }
        return mutable;
    }
}
