package org.mypractice.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertionSorterTest {

    private InsertionSorter sorter;
    private static final List<Integer> UNSORTED_1 = new ArrayList<>();

    @BeforeEach
    public void setup() {
        sorter = new InsertionSorter();
        UNSORTED_1.add(24);
        UNSORTED_1.add(2);
        UNSORTED_1.add(0);
        UNSORTED_1.add(859);
        UNSORTED_1.add(-5);
    }

    @Test
    void returnsNull() {
        List<Integer> output = sorter.sort(UNSORTED_1);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(isSorted(output));
    }

    boolean isSorted(final List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
}
