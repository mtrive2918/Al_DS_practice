package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;


class SortUtilsTest {

    @ParameterizedTest(name = "Integer list containing {1} randomly ordered elements.")
    @MethodSource("org.mypractice.algo.sort.SortTestUtils#getRandomIntLists")
    void reverse_non_empty_list(List<Integer> list, int size) {
        List<Integer> reversedList = SortUtils.reverse(list);
        Assertions.assertTrue(isReversed(list, reversedList));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void reverse_null_empty_list(List<Integer> list) {
        List<Integer> reversedList = SortUtils.reverse(list);
        Assertions.assertTrue(isReversed(list, reversedList));
    }

    private boolean isReversed(final List<Integer> original, final List<Integer> reversed) {
        if (original == null || original.isEmpty()) {
            return reversed.isEmpty();
        }
        int len = original.size();
        for (int i = 0; i < len; i++) {
            if (!original.get(i).equals(reversed.get(len - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
