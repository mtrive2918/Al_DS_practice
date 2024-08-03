package org.mypractice.debug.leetcode;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@Setter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractProblemTest {

    private AbstractProblem problem;

    @BeforeAll
    void setup(){
        initProblem();
    }

    public abstract void initProblem();

    @ParameterizedTest(name = "Running Test with solution method {1}")
    @MethodSource("org.mypractice.debug.leetcode.AbstractProblemTest#getTestArgumentsPerSolution")
    protected void test_solution(Method m, String mName, Map<Object[], Object> testParams) {
        testSolution(m, testParams);
    }

    private Stream<Arguments> getTestArgumentsPerSolution() {
        Map<Object[], Object> inputGeneric = problem.getTestParams();
        Method[] methods = problem.getClass().getMethods();
        return Arrays.stream(methods).filter(this::isSolution).map(m -> Arguments.of(m, m.getName(), inputGeneric));
    }

    private boolean isSolution(Method m) {
        return Arrays.equals(m.getParameterTypes(), problem.getInputParameterType())
                && m.getReturnType().equals(problem.getOutputType());
    }

    private void testSolution(Method m, Map<Object[], Object> paramMap) {
        paramMap.forEach((inputParams, expected) -> {
            Object output = null;
            try {
                output = m.invoke(problem, inputParams);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertEquals(expected, output);
        });

    }

}
