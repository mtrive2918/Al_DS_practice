package org.mypractice.ds.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mypractice.Constants;

import java.util.List;

public class ArrayListMinHeapTest {

    private MinHeap<Integer> minHeap;
    private List<Integer> input;

    @BeforeEach
    void setup() {
        minHeap = new ArrayListMinHeap<>();
        input = Constants.random.ints(10, 0, 101).boxed().toList();
        input.forEach(val -> minHeap.add(val));
    }

    @Test
    void empty_heap() {
        minHeap = new ArrayListMinHeap<>();
        Assertions.assertNull(minHeap.getTop());
        Assertions.assertNull(minHeap.extractTop());
        Assertions.assertEquals(0, minHeap.size());
        Assertions.assertTrue(minHeap.isEmpty());
    }

    @Test
    void update_with_lesser_value() {
        boolean res = minHeap.update(4, -1);
        Assertions.assertTrue(res);
    }

    @Test
    void update_with_index_out_of_bounds() {
        boolean res = minHeap.update(-1, 1001);
        Assertions.assertFalse(res);
    }

    @Test
    void update_with_value_equal_or_greater() {
        boolean res = minHeap.update(4, 100);
        Assertions.assertFalse(res);
    }

    @Test
    void get_top_non_empty() {
        Integer res = minHeap.getTop();
        Assertions.assertNotNull(res);
        Assertions.assertEquals(findMin(input), res);
    }

    private Integer findMin(List<Integer> input) {
        Integer min = Integer.MAX_VALUE;
        for (Integer i: input) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

}
