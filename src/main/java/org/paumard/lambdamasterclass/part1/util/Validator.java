package org.paumard.lambdamasterclass.part1.util;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

    Supplier<T> validate(T t);

    default Validator<T> thenValidate(Predicate<T> predicate, String errorMessage) {

        return t ->
                () -> {
                    try {
                        validate(t).get();
                        if (predicate.test(t)) {
                            ValidationException validationException = new ValidationException("Object is not valid");
                            validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                            throw validationException;
                        } else {
                            return t;
                        }
                    } catch (ValidationException validationException) {
                        if (predicate.test(t)) {
                            validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                            throw validationException;
                        } else {
                            throw validationException;
                        }
                    }
                };
    }

    static <T> Validator<T> firstValidate(Predicate<T> predicate, String errorMessage) {
        return t -> predicate.test(t) ?
                () -> {
                    ValidationException validationException = new ValidationException("Object is not valid");
                    validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw validationException;
                } :
                () -> t;

    }
}
