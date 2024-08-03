package org.mypractice.debug.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 *     '.' Matches any single character.
 *     '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <a href="https://leetcode.com/problems/regular-expression-matching/description/">..</a>
 */
public class LimitedRegexMatcher extends AbstractProblem {


    enum Result {
        TRUE("T"), FALSE("F");

        private String desc;

        Result(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return desc;
        }
    }

    private Result[][] memo;

    public boolean isMatchRecursive(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatchRecursive(s, p.substring(2))
                    || match && isMatchRecursive(s.substring(1), p);

        } else {
            return match && isMatchRecursive(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatchDP(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int os, int op) {
        if (memo[os][op] != null) {
            return memo[os][op] == Result.TRUE;
        }
        int sl = s.length();
        int pl = p.length();
        boolean ans;
        if (op == pl) {
            ans = os == sl;
        } else {
            boolean match = (sl - os) > 0 && (s.charAt(os) == p.charAt(op) || p.charAt(op) == '.');
            if (pl - op >= 2 && p.charAt(op + 1) == '*') {
                ans = isMatch(s, p, os, op + 2)
                        || match && isMatch(s, p, os + 1, op);
            } else {
                ans = match && isMatch(s, p, os + 1, op + 1);
            }
        }
        memo[os][op] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    @Override
    Map<Object[], Object> getTestParams() {
        Map<List<String>, Boolean> input = Map.of(
                List.of("aa", "a"), false,
                List.of("aa", "a*"), true,
                List.of("ab", ".*"), true,
                List.of("ab", "ab*"), true,
                List.of("ab", ".*c"), false,
                List.of("a", "ab*"), true,
                List.of("ac", "ab*c"), true
        );

        return input.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> {
                            String s = e.getKey().get(0);
                            String p = e.getKey().get(1);
                            return new Object[] {s, p};
                        },
                        Map.Entry::getValue));
    }

    @Override
    public Class<?>[] getInputParameterType() {
        Class<?>[] paramTypes = new Class[2];
        paramTypes[0] = String.class;
        paramTypes[1] = String.class;
        return paramTypes;
    }

    @Override
    public Class<?> getOutputType() {
        return boolean.class;
    }
}
