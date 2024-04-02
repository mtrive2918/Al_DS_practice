package org.mypractice;

import org.mypractice.debug.Experiment;

public final class Main {

    private Main() {}

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Experiment().run();
    }

}