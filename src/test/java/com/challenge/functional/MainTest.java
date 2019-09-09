package com.challenge.functional;

import com.challenge.main.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testMain_errorGame() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "errorGame.txt";

        Main.main(new String[]{path, fileName});
        Assert.assertTrue(Main.getResult().contains("Invalid format line"));
    }

    @Test
    public void testMain_perfectGame() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "perfectGame.txt";

        Main.main(new String[]{path, fileName});
        Assert.assertTrue(Main.getResult().startsWith("Frame"));
        Assert.assertTrue(Main.getResult().contains("300"));
        Assert.assertTrue(Main.getResult().contains("88"));
    }

    @Test
    public void testMain_foulGame() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "foulGame.txt";

        Main.main(new String[]{path, fileName});
        Assert.assertTrue(Main.getResult().startsWith("Frame"));
        Assert.assertTrue(Main.getResult().contains("F\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF"));
        Assert.assertTrue(Main.getResult().contains("88"));
    }

    @Test
    public void testMain_game() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "game.txt";

        Main.main(new String[]{path, fileName});
        Assert.assertTrue(Main.getResult().startsWith("Frame"));
        Assert.assertTrue(Main.getResult().contains("104"));
        Assert.assertTrue(Main.getResult().contains("88"));
    }

    @Test
    public void testMain_zeroGame() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "zeroGame.txt";

        Main.main(new String[]{path, fileName});
        Assert.assertTrue(Main.getResult().startsWith("Frame"));
        Assert.assertTrue(Main.getResult().contains("Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0"));
        Assert.assertTrue(Main.getResult().contains("88"));
    }
}
