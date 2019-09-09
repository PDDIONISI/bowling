package com.challenge.unit;

import com.challenge.excpetion.ChallengeException;
import com.challenge.services.IFileService;
import com.challenge.services.impl.FileService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.fail;

public class FileServiceTest {
    private IFileService fileService = new FileService();

    @Test
    public void getLinesFromFile_ok() throws IOException, ChallengeException {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "game.txt";

        List<String> list = fileService.getLinesFromFile(path, fileName);

        Assert.assertEquals(41, list.size());
    }

    @Test
    public void getLinesFromFile_error() throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        String fileName = "ErrorGame.txt";

        try {
            List<String> list = fileService.getLinesFromFile(path, fileName);
            fail();
        } catch (ChallengeException e) {
            Assert.assertEquals("Invalid format line", e.getMessage());
        }

    }
}
