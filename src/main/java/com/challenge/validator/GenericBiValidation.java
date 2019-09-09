package com.challenge.validator;

import java.util.function.BiPredicate;

public class GenericBiValidation<K, L> implements BiValidation<K, L> {

    private BiPredicate<K, L> predicate;

    public static <K, L> GenericBiValidation<K, L> from(BiPredicate<K, L> predicate) {
        return new GenericBiValidation<>(predicate);
    }

    private GenericBiValidation(BiPredicate<K, L> predicate) {
        this.predicate = predicate;
    }

    @Override
    public GenericValidationResult test(K param, L param2) {
        return predicate.test(param, param2) ? GenericValidationResult.ok() : GenericValidationResult.fail();
    }
}
