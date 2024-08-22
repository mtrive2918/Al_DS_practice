package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountingSorterTest {

    private CountingSorter<Digit> sorter;

    @BeforeAll
    void init() {
        sorter = new CountingSorter<>();
    }

    @ParameterizedTest(name = "Digit list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDigitLists")
    protected void random_digit_lists_sorted_up(List<Digit> list, int listSize) {
        List<Digit> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }

    @ParameterizedTest(name = "Digit list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDigitLists")
    protected void random_digit_lists_sorted_down(List<Digit> list, int listSize) {
        List<Digit> output = sorter.sort(list, SortOrder.NON_INCREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_INCREASING));
    }

    @ParameterizedTest
    @NullAndEmptySource
    protected void null_and_empty_list(List<Digit> list) {
        List<Digit> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(0, output.size());
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }
}
