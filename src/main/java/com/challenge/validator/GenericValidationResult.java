package com.challenge.validator;

import com.challenge.excpetion.ChallengeException;

public class GenericValidationResult {

    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public static GenericValidationResult ok() {
        return new GenericValidationResult(true);
    }

    private GenericValidationResult(boolean valid) {
        this.valid = valid;
    }

    public static GenericValidationResult fail() {
        return new GenericValidationResult(false);
    }

    public void throwIfInvalid(ValidationError error) throws ChallengeException {
        if(!isValid())
            throw error.toException();
    }

    public void throwIfValid(ValidationError error) throws ChallengeException{
        if(isValid())
            throw error.toException();
    }

}
