package org.mypractice.algo.sort;

public class InsertionTwoWaySorterTest extends AbstractTwoWaySorterTest {

    @Override
    public void initSorters() {
        setIntegerSorter(new InsertionTwoWaySorter<>());
        setDoubleSorter(new InsertionTwoWaySorter<>());
    }

}
