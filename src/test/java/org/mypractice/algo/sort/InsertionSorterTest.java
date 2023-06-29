package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class InsertionSorterTest {

    private final SortTestUtils testUtils = new SortTestUtils();

    @BeforeEach
    public void setup() {
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomIntLists")
    void random_int_list_different_sizes(List<Integer> list) {
        InsertionSorter<Integer> sorter = new InsertionSorter<>();
        List<Integer> output = sorter.sort(list);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(testUtils.isSorted(output));
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomDoublesLists")
    void random_double_list_different_sizes(List<Double> list) {
        InsertionSorter<Double> sorter = new InsertionSorter<>();
        List<Double> output = sorter.sort(list);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(testUtils.isSorted(output));
    }

}
