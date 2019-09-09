package com.challenge.services.impl;

import com.challenge.excpetion.ChallengeException;
import com.challenge.services.IInputFileLineValidatorService;
import com.challenge.validator.ValidatorUtil;
import com.challenge.validator.ValidationError;

import java.util.List;
import java.util.regex.Pattern;

public class InputFileLineValidatorService implements IInputFileLineValidatorService {
    private Pattern pattern = Pattern.compile("(([0-9]|10)$|F)");

    @Override
    public void validateLines(List<String> lines) throws ChallengeException {
        for (String line : lines) {
            if (line.split("\\t").length != 2)
                throw ValidationError.INVALID_LINE_VALUE.toException();

            ValidatorUtil.validateRegex.test(pattern, line.split("\\t")[1]).throwIfInvalid(ValidationError.INVALID_LINE_VALUE);
        }
    }

    @Override
    public void isLessEqualsThanTen(int pins) throws ChallengeException {
        ValidatorUtil.integerLessEqualsThan(10).test(pins).throwIfInvalid(ValidationError.INVALID_LINE_VALUE);
    }
}
