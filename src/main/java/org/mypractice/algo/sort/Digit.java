package org.mypractice.algo.sort;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Digit implements Enumable {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
    A(10), B(11), C(12), D(13), E(14), F(15),
    G(16), H(17), I(18), J(19), K(20), L(21),
    M(22), N(23), O(24), P(25), Q(26), R(27),
    S(28), T(29), U(30), V(31), W(32), X(33),
    Y(34), Z(35);

    private final int decimalVal;

    Digit(int decimalVal) {
        this.decimalVal = decimalVal;
    }

    public static Digit valueOf(int decimalVal) {
        Optional<Digit> parsedDigit = Arrays.stream(Digit.values())
                .filter(d -> d.getDecimalVal() == decimalVal).findFirst();
        return parsedDigit.orElse(null);
    }

    @Override
    public Enum<?> getSortEnum() {
        return this;
    }

    @Override
    public Class<?> getEnumClass() {
        return this.getDeclaringClass();
    }
}
