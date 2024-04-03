package org.mypractice.algo.sort;

public class QuickSorterTest extends AbstractTwoWaySorterTest {

    @Override
    public void initSorters() {
        setDoubleSorter(new QuickSorter<>());
        setIntegerSorter(new QuickSorter<>());
    }
}
