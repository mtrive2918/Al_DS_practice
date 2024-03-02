package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

public class InsertionSorterTest {

    private InsertionSorter<Integer> sorter;

    @BeforeEach
    public void setup() {
        sorter = new InsertionSorter<>();
    }

    @ParameterizedTest
    @NullAndEmptySource
    protected void empty_list(List<Integer> list) {
        List<Integer> output = sorter.sort(list);
        Assertions.assertNotNull(output);
        Assertions.assertEquals(0, output.size());
    }
}
