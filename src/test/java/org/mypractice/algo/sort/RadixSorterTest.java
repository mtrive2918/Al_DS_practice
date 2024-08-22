package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RadixSorterTest {

    private RadixSorter<DigitizedNaturalNumber> sorter;

    @BeforeAll
    void setup() {
        sorter = new RadixSorter<>();
    }

    @ParameterizedTest(name = "Digitized Natural number list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDigitizedNaturalNumberLists")
    protected void random_digitized_natural_num_lists_sorted_up(List<DigitizedNaturalNumber> list, int listSize) {
        List<DigitizedNaturalNumber> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }

    @ParameterizedTest(name = "Digitized Natural number list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getBiggerRandomDigitizedNaturalNumberLists")
    protected void random_digitized_natural_num_big_lists_sorted_down(List<DigitizedNaturalNumber> list, int listSize) {
        List<DigitizedNaturalNumber> output = sorter.sort(list, SortOrder.NON_INCREASING);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_INCREASING));
    }

    @ParameterizedTest
    @NullAndEmptySource
    protected void null_and_empty_list(List<DigitizedNaturalNumber> list) {
        List<DigitizedNaturalNumber> output = sorter.sort(list, SortOrder.NON_DECREASING);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(0, output.size());
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.NON_DECREASING));
    }
}
