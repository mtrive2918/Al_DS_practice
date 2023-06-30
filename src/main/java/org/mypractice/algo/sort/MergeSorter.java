package org.mypractice.algo.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> extends AbstractTwoWaySorter<T> {

    @Override
    List<T> sort(List<T> unsortedList) {
        if (unsortedList == null) return null;
        final List<T> mutableList = new ArrayList<>(unsortedList);
        mergeSort(mutableList, 0, mutableList.size() - 1);
        return mutableList;
    }

    private void mergeSort(List<T> mutableList, int right, int left) {
        if (right >= left) return;
        int mid = (right + left) / 2;
        mergeSort(mutableList, right, mid);
        mergeSort(mutableList, mid + 1, left);
        merge(mutableList, right, mid, left);
    }

    private void merge(List<T> mutableList, int right, int mid, int left) {
        List<T> temp = new ArrayList<>(left - right + 1);
        int rp = right;
        int lp = mid + 1;
        while (rp <= mid || lp <= left) {
            if (rp > mid ||
                    (lp <= left && mutableList.get(lp).compareTo(mutableList.get(rp)) < 0)) {
                temp.add(mutableList.get(lp++));
            } else {
                temp.add(mutableList.get(rp++));
            }
        }
        for (int i = 0; i <= left - right; i++) {
            mutableList.set(right + i, temp.get(i));
        }
    }

 }
