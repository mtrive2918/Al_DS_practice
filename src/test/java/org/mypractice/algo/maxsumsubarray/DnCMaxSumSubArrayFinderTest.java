package org.mypractice.algo.maxsumsubarray;

public class DnCMaxSumSubArrayFinderTest extends AbstractMaxSumSubArrayFinderTest {

    @Override
    public void initFinder() {
        setMaxSumSubArrayFinder(new DnCMaxSumSubArrayFinder());
    }
}
