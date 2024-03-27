package org.mypractice.algo.random;

public class InPlaceRandomPermutatorTest extends AbstractRandomPermutatorTest {
    @Override
    public void initPermutator() {
        setIntegerRandomPermutator(new InPlaceRandomPermutator<Integer>());
    }
}