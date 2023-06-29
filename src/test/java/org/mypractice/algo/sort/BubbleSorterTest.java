package org.mypractice.algo.sort;

public class BubbleSorterTest extends AbstractTwoWaySorterTest {

    @Override
    public void initSorters() {
        setIntegerSorter(new BubbleSorter<>());
        setDoubleSorter(new BubbleSorter<>());
    }

}

