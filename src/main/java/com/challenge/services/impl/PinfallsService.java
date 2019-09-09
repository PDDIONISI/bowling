package com.challenge.services.impl;

import com.challenge.services.IPinfallsService;

public class PinfallsService implements IPinfallsService {

    private static final String TEN = "10";
    private static final String FOUL = "F";

    @Override
    public String getPinfallBoardValue(String firstRoll, String secondRoll) {
        if (isTenPins(firstRoll) && isTenPins(secondRoll)) {
            return "X\tX\t";
        }

        if (isTenPins(firstRoll)) {
            return "\tX\t";
        }
        if ((isFoul(firstRoll) || "0".equals(firstRoll)) && isTenPins(secondRoll)) {
            return firstRoll + "\t/\t";
        }

        if (!isFoul(secondRoll) && (Integer.valueOf(firstRoll) + Integer.valueOf(secondRoll)) == 10) {
            return firstRoll + "\t/\t";
        }

        return firstRoll + "\t" + secondRoll + "\t";
    }

    @Override
    public String getPinfallBoardValue(String extraRoll) {
        return isTenPins(extraRoll) ? "X" : extraRoll;
    }

    private boolean isTenPins(String roll) {
        return TEN.equals(roll);
    }

    private boolean isFoul(String roll) {
        return FOUL.equals(roll);
    }

    @Override
    public int pinfallNumericValue(String roll) {
        if (isFoul(roll)) {
            return 0;
        }
        return Integer.valueOf(roll);
    }
}
