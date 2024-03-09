package org.mypractice.algo.maxsumsubarray;

public class LinearTimeMaxSumSubArrayFinderTest extends AbstractMaxSumSubArrayFinderTest {

    @Override
    public void initFinder() {
        setMaxSumSubArrayFinder(new LinearTimeMaxSumSubArrayFinder());
    }
}
