package org.mypractice.debug.leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p></p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p></p>
 * Return the maximum amount of water a container can store.
 * <p></p>
 * Notice that you may not slant the container.
 * <p></p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p></p>
 * Example 2:
 * <p></p>
 * Input: height = [1,1]
 * Output: 1
 * <a href="https://leetcode.com/problems/container-with-most-water/description/">...</a>
 */
public class ContainerWithMaxWater extends AbstractProblem {

    public int maxArea(int[] height) {
        int lmax = 0;
        int[] max = new int[3];
        max[1] = 1;
        calculateArea(max, height);
        int [] maxWithLast = new int[3];
        for (int i = 2; i < height.length; i++) {
            maxWithLast[1] = i;
            calculateArea(maxWithLast, height);
            if (height[lmax] < height[i]) {
                boolean equalOrHigherVisited = false;
                while (lmax < i - 1 && !equalOrHigherVisited) {
                    int newArea = area(++lmax, i, height);
                    if (newArea > maxWithLast[2]
                    ) {
                        maxWithLast[0] = lmax;
                        calculateArea(maxWithLast, height);
                    }
                    equalOrHigherVisited = height[lmax] >= height[i];
                }
            } else if(height[lmax] > height[i]){
                boolean equalOrLowerVisited = false;
                while (lmax > 0 && !equalOrLowerVisited) {
                    int newArea = area(--lmax, i, height);
                    if (newArea > maxWithLast[2]
                    ) {
                        maxWithLast[0] = lmax;
                        calculateArea(maxWithLast, height);
                    }
                    equalOrLowerVisited = height[lmax] <= height[i];
                }
            }

            lmax = maxWithLast[0];

            if (maxWithLast[2] > max[2]) {
                max[0] = maxWithLast[0];
                max[1] = maxWithLast[1];
                calculateArea(max, height);
            }
        }
        return max[2];
    }

    public int maxAreaV2(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxArea = area(l, r, height);

        while(l < r) {
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
            int newArea = area(l, r, height);
            maxArea = Math.max(maxArea, newArea);
        }
        return maxArea;
    }

    private void calculateArea(int[] bucket, int[] height) {
        bucket[2] = area(bucket[0], bucket[1], height);
    }

    private int area(int l, int r, int[] height) {
        return (r - l) * Math.min(height[r], height[l]);
    }


    @Override
    public Class<?>[] getInputParameterType() {
        Class<?>[] params = new Class[1];
        params[0] = int[].class;
        return params;
    }

    @Override
    public Class<?> getOutputType() {
       return int.class;
    }


    @Override
    Map<Object[], Object> getTestParams() {
        Map<int[], Integer> input = Map.of(
                new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49,
                new int[]{1, 1}, 1,
                new int[]{1, 2, 4, 3}, 4,
                new int[]{1, 2, 4, 3, 1}, 4,
                new int[]{1, 2, 4, 3, 1, 1}, 5,
                new int[]{1, 2, 4, 3, 1, 3, 1}, 9,
                new int[]{1, 2, 4, 3, 1, 3, 1, 2}, 12,
                new int[]{1, 2, 4, 3, 1, 3, 1, 2, 1, 4}, 28,
                new int[]{1, 2, 4, 3, 2, 1, 3, 2}, 12,
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 25
        );
        return input.entrySet().stream()
                .collect(Collectors.toMap(e -> new Object[]{e.getKey()}, e -> (Object)e.getValue()));
    }
}
