package org.mypractice.algo.random;

import org.mypractice.Constants;

public class InPlaceRandomPermutatorTest extends AbstractRandomPermutatorTest {
    @Override
    public void initPermutator() {
        setIntegerRandomPermutator(new InPlaceRandomPermutator<Integer>(Constants.random));
    }
}