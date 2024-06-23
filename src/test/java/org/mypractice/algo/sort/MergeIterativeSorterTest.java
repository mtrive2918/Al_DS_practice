package org.mypractice.algo.sort;

public class MergeIterativeSorterTest extends MergeSorterTest {

    @Override
    public void initSorters() {
        setIntegerSorter(new MergeIterativeSorter<>());
        setDoubleSorter(new MergeIterativeSorter<>());
    }

}
