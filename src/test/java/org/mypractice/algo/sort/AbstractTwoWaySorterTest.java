package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public abstract class AbstractTwoWaySorterTest {

    private TwoWaySorter<Integer> integerSorter;
    private TwoWaySorter<Double> doubleSorter;

    @BeforeEach
    public void setup() {
        initSorters();
    }

    public abstract void initSorters();

    public void setIntegerSorter(final TwoWaySorter<Integer> integerSorter) {
        this.integerSorter = integerSorter;
    }

    public void setDoubleSorter(final TwoWaySorter<Double> doubleSorter) {
        this.doubleSorter = doubleSorter;
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomIntLists")
    protected void random_int_list_different_sizes_non_decreasing(List<Integer> list) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtils.isSorted(output, SortOrder.UP));
    }

    @ParameterizedTest
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomDoublesLists")
    protected void random_int_list_different_sizes_non_increasing(List<Double> list) {
        List<Double> output = doubleSorter.sort(list, SortOrder.DOWN);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtils.isSorted(output, SortOrder.DOWN));
    }
}
