package org.mypractice.algo.sort;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

@Getter
@Setter
public abstract class AbstractTwoWaySorterTest {

    private TwoWaySorter<Integer> integerSorter;

    private TwoWaySorter<Double> doubleSorter;

    @BeforeEach
    public void setup() {
        initSorters();
    }

    public abstract void initSorters();

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomIntLists")
    protected void random_int_lists_sorted_up(List<Integer> list, int listSize) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.UP));
    }

    @ParameterizedTest(name = "Double list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getRandomDoublesLists")
    protected void random_double_lists_sorted_down(List<Double> list, int listSize) {
        List<Double> output = doubleSorter.sort(list, SortOrder.DOWN);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.DOWN));
    }

    @ParameterizedTest(name = "Integer list containing {1} elements in increasing order.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getIncreasingIntLists")
    protected void increasing_int_lists_sorted_up(List<Integer> list, int listSize) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.UP));
    }

    @ParameterizedTest(name = "Integer list containing {1} elements in decreasing order.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getDecreasingIntLists")
    protected void decreasing_int_lists_sorted_up(List<Integer> list, int listSize) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.UP));
    }

    @ParameterizedTest
    @NullAndEmptySource
    protected void null_and_empty_list(List<Integer> list) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(0, output.size());
        Assertions.assertTrue(SortTestUtil.isSorted(output, SortOrder.UP));
    }

}
