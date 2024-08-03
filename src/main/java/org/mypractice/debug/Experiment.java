package org.mypractice.debug;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Experiment implements Runnable {

    private Util util;

    @Override
    public void run() {
        util.runLeetCodeProblems();
    }
}
