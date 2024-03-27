package org.mypractice.algo.random;

public class PriorityBasedRandomPermutatorTest extends AbstractRandomPermutatorTest {

    @Override
    public void initPermutator() {
        setIntegerRandomPermutator(new PriorityBasedRandomPermutator<>());
    }
}
