package org.mypractice.algo.random;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mypractice.algo.sort.MergeSorter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public abstract class AbstractRandomPermutatorTest {

    protected RandomPermutator<Integer> integerRandomPermutator;

    private MergeSorter<Integer> intSorter = new MergeSorter<>();

    public abstract void initPermutator();

    @BeforeEach
    public void setup() {
        initPermutator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void null_empty_list(List<Integer> given) {
        List<Integer> randomized = integerRandomPermutator.randomize(given);
        Assertions.assertNotNull(randomized);
        Assertions.assertEquals(Collections.emptyList(), randomized);
    }

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtil#getBiggerRandomIntLists")
    public void random_int_list(List<Integer> given, int size) {
        List<Integer> randomized = integerRandomPermutator.randomize(given);
        Assertions.assertTrue(validateRandomizedList(given, randomized));
    }

    private boolean validateRandomizedList(List<Integer> given, List<Integer> randomized) {
        int matchCount = 0;
        for (int i = 0; i < given.size(); i++) {
            if (given.get(i).equals(randomized.get(i))) {
                matchCount++;
            }
        }
        return matchCount < given.size();
    }
}
