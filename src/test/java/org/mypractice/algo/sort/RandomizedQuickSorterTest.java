package org.mypractice.algo.sort;

import org.mypractice.Constants;

public class RandomizedQuickSorterTest extends AbstractTwoWaySorterTest {

    @Override
    public void initSorters() {
        setDoubleSorter(new RandomizedQuickSorter<>(Constants.random));
        setIntegerSorter(new RandomizedQuickSorter<>(Constants.random));
    }
}
