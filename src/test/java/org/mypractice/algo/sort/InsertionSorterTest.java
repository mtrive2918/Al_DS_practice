package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class InsertionSorterTest {

    private InsertionSorter<Integer> intSorter = new InsertionSorter<>();
    private InsertionSorter<Double> doubleSorter = new InsertionSorter<>();

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomIntLists")
    void random_int_list_different_sizes(List<Integer> list) {
        List<Integer> output = intSorter.sort(list);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtils.isSorted(output));
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomDoublesLists")
    void random_double_list_different_sizes(List<Double> list) {
        List<Double> output = doubleSorter.sort(list);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtils.isSorted(output));
    }

}
