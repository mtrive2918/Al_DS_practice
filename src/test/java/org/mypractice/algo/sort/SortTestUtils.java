package org.mypractice.algo.sort;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public final class SortTestUtils {

    private static final List<Integer> LIST_SIZES = List.of(1, 2, 10, 41, 100, 1000, 10000, 100000);

    private static final List<Integer> BIGGER_LIST_SIZES = List.of(1000000, 10000000);

    private static final long SEED = 104l;

    static <T extends Comparable<T>> boolean isSorted(final List<T> list) {
        return isSorted(list, SortOrder.UP);
    }

    static <T extends Comparable<T>> boolean isSorted(final List<T> list, final SortOrder sortOrder) {
        if (list == null) return true;
        for (int i = 1; i < list.size(); i++) {
            switch (sortOrder) {
                case UP:
                    if (list.get(i).compareTo(list.get(i - 1)) < 0) return false;
                    break;
                case DOWN:
                    if (list.get(i).compareTo(list.get(i - 1)) > 0) return false;
                    break;
                default:
            }
        }
        return true;
    }

    static Stream<Arguments> getRandomIntLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .map(size -> Arguments.of(random.ints(size, -100, 101).boxed().toList(), size));
    }

    static Stream<Arguments> getRandomDoublesLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .map(size -> Arguments.of(random.doubles(size, -100.00, 101.00).boxed().toList(), size));
    }

    static Stream<Arguments> getIncreasingIntLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .filter(size -> size > 100)
                .map(size -> Arguments.of(Stream.iterate(random.nextInt(), i -> i + 1).limit(size).toList(), size));
    }

    static Stream<Arguments> getDecreasingIntLists() {
        Random random = new Random(SEED);
        return LIST_SIZES.stream()
                .filter(size -> size > 100)
                .map(size -> Arguments.of(Stream.iterate(random.nextInt(), i -> i - 1).limit(size).toList(), size));
    }

    static Stream<Arguments> getBiggerRandomIntLists() {
        Random random = new Random(SEED);
        return BIGGER_LIST_SIZES.stream()
                .map(size -> Arguments.of(random.ints(size, -100, 101).boxed().toList(), size));
    }
}
