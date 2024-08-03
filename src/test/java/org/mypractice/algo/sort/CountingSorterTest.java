package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

public class CountingSorterTest {

    private CountingSorter<Integer> sorter;

    @BeforeEach
    void init() {
        sorter = new CountingSorter<>();
    }

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDecimalDigitIntLists")
    protected void random_int_lists_sorted_up(List<Integer> list, int listSize) {
        List<Integer> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDecimalDigitIntLists")
    protected void random_int_lists_sorted_down(List<Integer> list, int listSize) {
        List<Integer> output = sorter.sort(list, SortOrder.NON_INCREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_INCREASING));
    }

    @ParameterizedTest
    @NullAndEmptySource
    protected void null_and_empty_list(List<Integer> list) {
        List<Integer> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(0, output.size());
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }
}
