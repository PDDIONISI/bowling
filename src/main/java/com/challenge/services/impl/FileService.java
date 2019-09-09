package com.challenge.services.impl;

import com.challenge.excpetion.ChallengeException;
import com.challenge.services.IFileService;
import com.challenge.services.IInputFileLineValidatorService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService implements IFileService {

    private IInputFileLineValidatorService validatorService = new InputFileLineValidatorService();

    @Override
    public List<String> getLinesFromFile(String path, String fileName) throws ChallengeException, IOException {
        Stream<String> stream = Files.lines(Paths.get(path + fileName));
        List<String> lines = stream.collect(Collectors.toList());

        validatorService.validateLines(lines);

        return lines;
    }
}
