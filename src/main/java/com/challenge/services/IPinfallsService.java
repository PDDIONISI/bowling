package com.challenge.services;

public interface IPinfallsService {

    String getPinfallBoardValue(String firstRoll, String secondRoll);

    String getPinfallBoardValue(String extraRoll);

    int pinfallNumericValue(String roll);
}
