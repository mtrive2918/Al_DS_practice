package org.mypractice.algo.sort;

import java.util.Arrays;
import java.util.Optional;

/**
 * This enum defines the sort order patterns for sequences
 */
public enum SortOrder {

    UP,
    DOWN;

    SortOrder() {}

    /**
     * Method to get SortOrder from string name or description
     * @param val string
     * @return SortOrder
     */
    public static Optional<SortOrder> of(final String val) {
       return Arrays.stream(SortOrder.values()).
                filter(order -> order.name().equals(val)).findFirst();
    }

}
