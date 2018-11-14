package org.paumard.lambdamasterclass.part1.util;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> negate() {
        return t -> !this.test(t);
    }

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return t -> this.test(t) && other.test(t);
    }

    default Predicate<T> xOr(Predicate<T> other) {
        Objects.requireNonNull(other);
        return t -> this.test(t) ^ other.test(t);
    }
}
