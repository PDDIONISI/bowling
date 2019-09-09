package com.challenge.services;

import com.challenge.excpetion.ChallengeException;

import java.util.List;

public interface IInputFileLineValidatorService {

    void validateLines(List<String> lines) throws ChallengeException;

    void isLessEqualsThanTen(int pins) throws ChallengeException;

}
