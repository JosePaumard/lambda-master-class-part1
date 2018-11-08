package org.paumard.lambdamasterclass.part1.util;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator<T> {

    public class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

    Supplier<T> validate(T t);

    default Validator<T> thenValidate(Predicate<T> predicate, String errorMessage) {

        return t -> {
            try {
                validate(t).get();
                return !predicate.test(t) ? () -> t : () -> {
                    throw new IllegalArgumentException(errorMessage);
                };
            } catch (IllegalArgumentException iae) {
                return !predicate.test(t) ?
                        () -> {
                            ValidationException validationException = new ValidationException("Invalid object");
                            validationException.addSuppressed(iae);
                            throw validationException;
                        } :
                        () -> {
                            ValidationException validationException = new ValidationException("Invalid object");
                            validationException.addSuppressed(iae);
                            validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                            throw validationException;
                        };
            } catch (ValidationException validationException) {
                return !predicate.test(t) ?
                        () -> {
                            throw validationException;
                        } :
                        () -> {
                            validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                            throw validationException;
                        };
            }
        };

    }

    static <T> Validator<T> firstValidate(Predicate<T> predicate, String errorMessage) {

        return t -> !predicate.test(t) ? () -> t : () -> {
            ValidationException validationException = new ValidationException("Invalid object");
            validationException.addSuppressed(new IllegalArgumentException(errorMessage));
            throw validationException;
        };
    }
}
