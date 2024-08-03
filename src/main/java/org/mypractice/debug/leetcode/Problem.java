package org.mypractice.debug.leetcode;

public interface Problem extends Runnable {

    Class<?>[] getInputParameterType();
    Class<?> getOutputType();

}
