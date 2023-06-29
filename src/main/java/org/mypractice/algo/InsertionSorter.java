package org.mypractice.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines insertion sort implementation
 */
public class InsertionSorter {

    /**
     * This method defines insertion sort implementation for unsorted integer list
     * @param unsortedList unsorted integer list
     * @return sorted integer list
     */
    public List<Integer> sort(final List<Integer> unsortedList) {
        final List<Integer> mutableList = new ArrayList<>(unsortedList);
        int len = mutableList.size();
        for (int i = 1; i < len; i++) {
            Integer key = mutableList.get(i);
            int j = i - 1;
            while (j >= 0 && mutableList.get(j) > key) {
                mutableList.set(j + 1, mutableList.get(j));
                j--;
            }
            mutableList.set(j + 1, key);
        }
        return mutableList;
    }
}
