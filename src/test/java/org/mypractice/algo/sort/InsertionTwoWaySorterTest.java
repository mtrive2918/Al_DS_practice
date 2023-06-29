package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class InsertionTwoWaySorterTest {

    private final SortTestUtils testUtils = new SortTestUtils();


    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomIntLists")
    void random_int_list_different_sizes_non_decreasing(List<Integer> list) {
        InsertionTwoWaySorter<Integer> sorter = new InsertionTwoWaySorter<>();
        List<Integer> output = sorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(testUtils.isSorted(output, SortOrder.UP));
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomDoublesLists")
    void random_int_list_different_sizes_non_increasing(List<Double> list) {
        InsertionTwoWaySorter<Double> sorter = new InsertionTwoWaySorter<>();
        List<Double> output = sorter.sort(list, SortOrder.DOWN);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(testUtils.isSorted(output, SortOrder.DOWN));
    }
}
