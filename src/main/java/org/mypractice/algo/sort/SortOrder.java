package org.mypractice.algo.sort;

import java.util.Arrays;
import java.util.Optional;

/**
 * This enum defines the sort order patterns for sequences
 */
public enum SortOrder {

    UP("non-decreasing"),
    DOWN("non-increasing");

    private final String description;

    SortOrder(final String description) {
        this.description = description;
    }

    /**
     * Method to get the string description of the SortOrder
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to get SortOrder from string name or description
     * @param val string
     * @return SortOrder
     */
    public static Optional<SortOrder> of(final String val) {
       return Arrays.stream(SortOrder.values()).
                filter(order -> order.getDescription().equals(val) ||
                        order.name().equals(val)).findFirst();
    }

}
