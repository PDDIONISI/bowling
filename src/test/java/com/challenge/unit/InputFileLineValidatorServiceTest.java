package com.challenge.unit;

import com.challenge.excpetion.ChallengeException;
import com.challenge.mocks.ListMocks;
import com.challenge.services.IInputFileLineValidatorService;
import com.challenge.services.impl.InputFileLineValidatorService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

public class InputFileLineValidatorServiceTest {
    private IInputFileLineValidatorService inputFileLineValidatorService = new InputFileLineValidatorService();

    @Test
    public void validateLines_ok() {
        try {
            inputFileLineValidatorService.validateLines(ListMocks.GAME);
            Assert.assertTrue("Shoud not throw an excpetion", true);
        } catch (ChallengeException e) {
            fail();
        }
    }

    @Test
    public void validateLines_fail() {

        String[] array = new String[]{"Pablo	10", "Cindy	3", "Cindy	6", "Pablo	3", "Pablo	6", "Cindy	2", "Cindy	0",
                "Pablo	0", "Pablo 6", "Cindy	5", "Cindy	2", "Pablo	5", "Pablo	0", "Cindy	9", "Cindy	0", "Pablo	6",
                "Pablo	0", "Cindy	7", "Cindy	2", "Pablo	8", "Pablo	1", "Cindy	7", "Cindy	2", "Pablo	3", "Pablo	6",
                "Cindy	2", "Cindy	4", "Pablo	5", "Pablo	1", "Cindy	9", "Cindy	0", "Pablo	10", "Pablo	0", "Cindy	7",
                "Cindy	2", "Pablo	4", "Pablo	6", "Pablo	5", "Cindy	3", "Cindy	7", "Cindy	9"};

        try {
            inputFileLineValidatorService.validateLines(Arrays.asList(array));
            fail();
        } catch (ChallengeException e) {
            Assert.assertEquals("Invalid format line", e.getMessage());
        }
    }

    @Test
    public void isLessEqualsThanTen_ok() {
        try {
            inputFileLineValidatorService.isLessEqualsThanTen(10);
            Assert.assertTrue("Shoud not throw an excpetion", true);
        } catch (ChallengeException e) {
            fail();
        }
    }

    @Test
    public void isLessEqualsThanTen_fail() {
        try {
            inputFileLineValidatorService.isLessEqualsThanTen(11);
            fail();
        } catch (ChallengeException e) {
            Assert.assertEquals("Invalid format line", e.getMessage());
        }
    }
}
