package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines insertion sort implementation
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public List<T> sort(final List<T> unsortedList) {
        final List<T> mutableList = new ArrayList<>(unsortedList);
        int len = mutableList.size();
        for (int i = 1; i < len; i++) {
            T key = mutableList.get(i);
            int j = i - 1;
            while (j >= 0 && mutableList.get(j).compareTo(key) > 0) {
                mutableList.set(j + 1, mutableList.get(j));
                j--;
            }
            mutableList.set(j + 1, key);
        }
        return mutableList;
    }
}
