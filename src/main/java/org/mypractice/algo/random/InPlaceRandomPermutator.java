package org.mypractice.algo.random;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Implementation of RandomPermutator by swapping the current element(index i) with any random element from the
 * sublist of elements(index i to len - 1) iteratively.
 * @param <T> Generic Type
 */
@AllArgsConstructor
public class InPlaceRandomPermutator<T> implements RandomPermutator<T> {

    private final Random random;

    @Override
    public List<T> randomize(List<T> given) {
        if (given == null || given.isEmpty()) {
            return Collections.emptyList();
        }
        int len = given.size();
        List<T> randomized = new ArrayList<>(given);
        for (int i = 0; i < len; i++) {
            int swapIndex = random.nextInt(i, len);
            swap(randomized, i, swapIndex);
        }
        return randomized;
    }

    private void swap(List<T> list, int a, int b) {
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
