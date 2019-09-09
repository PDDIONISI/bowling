package com.challenge.validator;

import com.challenge.excpetion.ChallengeException;
import com.challenge.utils.Constants;

public enum ValidationError {
    INVALID_LINE_VALUE(Constants.LINE_ERROR_DESCRIPTION),
    ;

    private String description;


    ValidationError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChallengeException toException() {
        return new ChallengeException(description);
    }
}
