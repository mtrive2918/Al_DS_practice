package org.mypractice.ds.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class ArrayListMaxHeapTest {

    private ArraylistMaxHeap<Integer> heap;
    private List<Integer> input;

    private final Random random = new Random();

    @BeforeEach
    public void setup() {
        heap = new ArraylistMaxHeap<>();
        input = random.ints(10, 0, 101).boxed().toList();
        input.forEach(val -> heap.add(val));
    }

    @Test
    void empty_heap() {
        heap = new ArraylistMaxHeap<>();
        Assertions.assertNull(heap.getTop());
        Assertions.assertNull(heap.extractTop());
        Assertions.assertEquals(0, heap.size());
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    void update_with_larger_value() {
        boolean res = heap.update(4, 102);
        Assertions.assertTrue(res);
    }

    @Test
    void update_with_index_out_of_bounds() {
        boolean res = heap.update(-1, 1001);
        Assertions.assertFalse(res);
    }

    @Test
    void update_with_value_equal_or_lesser() {
        boolean res = heap.update(4, -1);
        Assertions.assertFalse(res);
    }

    @Test
    void get_top_non_empty() {
        Integer res = heap.getTop();
        Assertions.assertNotNull(res);
        Assertions.assertEquals(findMax(input), res);
    }

    private Integer findMax(List<Integer> input) {
        Integer max = Integer.MIN_VALUE;
        for (Integer i: input) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
