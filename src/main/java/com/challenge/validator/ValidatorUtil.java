package com.challenge.validator;

import java.util.regex.Pattern;

public final class ValidatorUtil {
    public static final BiValidation<Pattern, String> validateRegex =
            GenericBiValidation.from((pattern, value) -> pattern.matcher(value).matches());

    public static Validation<Integer> integerLessEqualsThan(int size) {
        return GenericValidation.from(s -> s <= size);
    }
}
