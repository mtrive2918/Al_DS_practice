package org.mypractice.algo.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

class SortOrderTest {

    @ParameterizedTest
    @ValueSource(strings = {"NON_DECREASING", "NON_INCREASING"})
    void get_enum_from_valid_string(String val) {
        Optional<SortOrder> sortOrderOptional = SortOrder.of(val);
        Assertions.assertFalse(sortOrderOptional.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"RANDOM"})
    void get_enum_from_invalid_string(String val) {
        Optional<SortOrder> sortOrderOptional = SortOrder.of(val);
        Assertions.assertTrue(sortOrderOptional.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void get_enum_from_null_or_empty_string(String val) {
        Optional<SortOrder> sortOrderOptional = SortOrder.of(val);
        Assertions.assertTrue(sortOrderOptional.isEmpty());
    }
}
