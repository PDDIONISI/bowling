package com.challenge.services;

import com.challenge.exception.ChallengeException;

import java.util.List;

public interface IInputFileLineValidatorService {

    void validateLines(List<String> lines) throws ChallengeException;

    void isLessEqualsThanTen(int pins) throws ChallengeException;

}
