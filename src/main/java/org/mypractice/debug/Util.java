package org.mypractice.debug;

import org.mypractice.debug.leetcode.AbstractProblem;
import org.mypractice.debug.leetcode.Problem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {

    private static final String LC_PACKAGE_NAME = "org.mypractice.debug.leetcode";

    public void runLeetCodeProblems() {
        Set<Class<?>> lcProblems = findAllClassesUsingClassLoader(LC_PACKAGE_NAME)
                .stream()
                .filter(clazz -> AbstractProblem.class.equals(clazz.getSuperclass())).collect(Collectors.toSet());
        lcProblems.forEach(this::runProblem);
    }

    public void runProblem(Class<?> problem) {
        Problem p = null;
        try {
            p = (Problem) problem.getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        p.run();
    }

    public Set<Class<?>> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
