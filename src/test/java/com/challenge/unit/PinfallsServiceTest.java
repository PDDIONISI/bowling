package com.challenge.unit;

import com.challenge.services.IPinfallsService;
import com.challenge.services.impl.PinfallsService;
import org.junit.Assert;
import org.junit.Test;

public class PinfallsServiceTest {
    private IPinfallsService pinfallsService = new PinfallsService();

    @Test
    public void getPinfallBoardValue_twoStrike() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("10","10");
        Assert.assertEquals("X\tX\t", pinfallValue);
    }

    @Test
    public void getPinfallBoardValue_strike() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("10","0");
        Assert.assertEquals("\tX\t", pinfallValue);
    }

    @Test
    public void getPinfallBoardValue_foulFirst() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("F","10");
        Assert.assertEquals("F\t/\t", pinfallValue);
    }

    @Test
    public void getPinfallBoardValue_foulsecond() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("7","F");
        Assert.assertEquals("7\tF\t", pinfallValue);
    }

    @Test
    public void getPinfallBoardValue_spare() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("4","6");
        Assert.assertEquals("4\t/\t", pinfallValue);
    }

    @Test
    public void getPinfallBoardValue_noTenPins() {
        String pinfallValue = pinfallsService.getPinfallBoardValue("3","5");
        Assert.assertEquals("3\t5\t", pinfallValue);
    }
}
