package org.mypractice.algo.random;

import org.mypractice.Constants;

public class PriorityBasedRandomPermutatorTest extends AbstractRandomPermutatorTest {

    @Override
    public void initPermutator() {
        setIntegerRandomPermutator(new PriorityBasedRandomPermutator<>(Constants.random));
    }
}
