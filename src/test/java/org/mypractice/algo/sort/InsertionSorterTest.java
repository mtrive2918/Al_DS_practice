package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertionSorterTest {

    private InsertionSorter sorter;
    private static final List<Integer> UNSORTED_1 = new ArrayList<>();

    @BeforeEach
    public void setup() {
        sorter = new InsertionSorter<Integer>();
        UNSORTED_1.add(24);
        UNSORTED_1.add(2);
        UNSORTED_1.add(0);
        UNSORTED_1.add(859);
        UNSORTED_1.add(-5);
    }

    @Test
    void simple_sorted_correctly() {
        List<Integer> output = sorter.sort(UNSORTED_1);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(isSorted(output));
    }

    <T extends Comparable<T>> boolean isSorted(final List<T> list) {
        if (list == null) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) return false;
        }
        return true;
    }
}
