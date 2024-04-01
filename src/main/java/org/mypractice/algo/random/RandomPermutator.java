package org.mypractice.algo.random;

import java.util.List;

/**
 * Interface to reorder list of items randomly.
 * @param <T> Generic Type
 */
public interface RandomPermutator<T> {

    List<T> randomize(List<T> given);
}
