package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeIterativeSorter<T extends  Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    protected List<T> sort(List<T> unsortedList) {
        final List<T> mutable = new ArrayList<>(unsortedList);
        final int listSize = mutable.size();
        int sortSize = 1;
        while (sortSize <= listSize) {
            int offset = 0;
            while ((2 * offset + 1) * sortSize < listSize) {
                int left = offset * 2 * sortSize;
                int mid = left + sortSize - 1;
                int right = mid + sortSize;
                right = Math.min(right, listSize - 1);
                merge(mutable, left, mid, right);
                offset++;
            }
            sortSize *= 2;
        }
        return List.of();
    }

    private void merge(List<T> mutableList, int left, int mid, int right) {
        List<T> temp = new ArrayList<>(right - left + 1);
        int lp = left;
        int rp = mid + 1;
        while (lp <= mid || rp <= right) {
            if (lp > mid ||
                    (rp <= right && mutableList.get(rp).compareTo(mutableList.get(lp)) < 0)) {
                temp.add(mutableList.get(rp++));
            } else {
                temp.add(mutableList.get(lp++));
            }
        }
        for (int i = 0; i <= right - left; i++) {
            mutableList.set(left + i, temp.get(i));
        }
    }


}
