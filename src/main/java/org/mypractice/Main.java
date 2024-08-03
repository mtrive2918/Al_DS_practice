package org.mypractice;

import org.mypractice.debug.Experiment;
import org.mypractice.debug.Util;

public final class Main {

    private Main() {}

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Experiment(new Util()).run();
    }

}