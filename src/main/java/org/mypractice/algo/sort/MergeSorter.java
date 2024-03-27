package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    public List<T> sort(List<T> unsortedList) {
        final List<T> mutableList = new ArrayList<>(unsortedList);
        mergeSort(mutableList, 0, mutableList.size() - 1);
        return mutableList;
    }

    private void mergeSort(List<T> mutableList, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(mutableList, left, mid);
        mergeSort(mutableList, mid + 1, right);
        merge(mutableList, left, mid, right);
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
