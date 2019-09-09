package com.challenge.validator;

@FunctionalInterface
public interface BiValidation<K, L> {

    GenericValidationResult test(K param, L param2);

}
