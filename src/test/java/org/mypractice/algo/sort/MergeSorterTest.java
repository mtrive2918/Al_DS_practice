package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MergeSorterTest extends AbstractTwoWaySorterTest {

    @Override
    public void initSorters() {
        setIntegerSorter(new MergeSorter<>());
        setDoubleSorter(new MergeSorter<>());
    }

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getBiggerRandomIntLists")
    protected void random_int_big_lists_sorted_up(List<Integer> list, int listSize) {
        List<Integer> output = integerSorter.sort(list, SortOrder.UP);
        Assertions.assertNotNull(output);
        Assertions.assertTrue(SortTestUtils.isSorted(output, SortOrder.UP));
    }
}
