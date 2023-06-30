package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    public List<T> sort(final List<T> unsortedList) {
        if (unsortedList == null) return null;
        final List<T> mutableList = new ArrayList<>(unsortedList);
        final int len = mutableList.size();
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (j > 0 && mutableList.get(j - 1).compareTo(mutableList.get(j)) > 0) {
                    T temp = mutableList.get(j);
                    mutableList.set(j, mutableList.get(j - 1));
                    mutableList.set(j - 1, temp);
                }
            }
        }
        return mutableList;
    }
}
