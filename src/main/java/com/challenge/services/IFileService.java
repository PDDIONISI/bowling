package com.challenge.services;

import com.challenge.exception.ChallengeException;

import java.io.IOException;
import java.util.List;

public interface IFileService {

    List<String> getLinesFromFile(String path, String fileName) throws ChallengeException, IOException;

}
