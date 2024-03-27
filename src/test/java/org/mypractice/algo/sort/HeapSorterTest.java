package org.mypractice.algo.sort;

public class HeapSorterTest extends AbstractTwoWaySorterTest {
    @Override
    public void initSorters() {
        setDoubleSorter(new HeapSorter<>());
        setIntegerSorter(new HeapSorter<>());
    }
}
