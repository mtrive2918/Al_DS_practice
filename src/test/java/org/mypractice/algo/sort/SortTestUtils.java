package org.mypractice.algo.sort;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public final class SortTestUtils {

    private static final List<Integer> LIST_SIZES = List.of(10, 100, 10000, 10000);
    private static final long SEED = 104l;

    static <T extends Comparable<T>> boolean isSorted(final List<T> list) {
        if (list == null) return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) return false;
        }
        return true;
    }

    static <T extends Comparable<T>> boolean isSorted(final List<T> list, final SortOrder sortOrder) {
        if (SortOrder.DOWN == sortOrder) {
            SortUtils.reverse(list);
        }
        return isSorted(list);
    }

    static Stream<List<Integer>> getRandomIntLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .map(size -> random.ints(size, -100, 101).boxed().toList());
    }

    static Stream<List<Double>> getRandomDoublesLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .map(size -> random.doubles(size, -100.00, 101.00).boxed().toList());
    }
}
