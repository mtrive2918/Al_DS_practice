package org.mypractice.debug.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public abstract class AbstractProblem implements Problem {

    abstract Map<Object[], Object> getTestParams();

    @Override
    public void run() {
        System.out.println("\nRunning Tests for Problem: " + getClass().getName());
        Map<Object[], Object> inputGeneric = getTestParams();
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            if (isSolution(m)) {
                runSolution(m, inputGeneric);
            }
        }
    }

    private void runSolution(Method m, Map<Object[], Object> paramMap) {
        System.out.println("\nRunning with solution method: " + m.getName());
        paramMap.forEach((inputParams, expected) -> {
            Object output = null;
            try {
                output = m.invoke(this, inputParams);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input: ");
            printInput(inputParams);
            System.out.println("Expected: " + expected + ", Actual: " + output + ", Match: " + (output.equals(expected)));
        });

    }

    private void printInput(Object[] objects) {
        Arrays.stream(objects).forEach(o -> {
            if (!o.getClass().isArray()) {
                System.out.println(o);
            } else {
                printArray(o);
            }
        });
    }

    private void printArray(Object o) {
        Class<?> arrayType = o.getClass().getComponentType();
        if (int.class.equals(arrayType)) {
            System.out.println(Arrays.toString((int[])o));
        } else if (double.class.equals(arrayType)) {
            System.out.println(Arrays.toString((double[])o));
        } else if (long.class.equals(arrayType)) {
            System.out.println(Arrays.toString((long[])o));
        } else if (boolean.class.equals(arrayType)) {
            System.out.println(Arrays.toString((boolean[])o));
        } else if (char.class.equals(arrayType)) {
            System.out.println(Arrays.toString((char[])o));
        } else if (String.class.equals(arrayType)) {
            System.out.println(Arrays.toString((String[])o));
        } else {
            System.out.println(Arrays.toString((Object[])o));
        }
    }

    private boolean isSolution(Method m) {
        return Arrays.equals(m.getParameterTypes(), getInputParameterType())
                && m.getReturnType().equals(getOutputType());
    }

}
