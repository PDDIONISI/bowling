package com.challenge.main;

import com.challenge.model.Board;
import com.challenge.model.Player;
import com.challenge.excpetion.ChallengeException;
import com.challenge.services.IBoardService;
import com.challenge.services.IFileService;
import com.challenge.services.impl.BoardService;
import com.challenge.services.impl.FileService;

import java.io.*;
import java.util.List;

public class Main {

    private static IFileService fileService = new FileService();
    private static IBoardService boardService = new BoardService();
    private static String result;

    public static void main(String[] arg) {
        if(arg.length != 2){
            System.out.println("Invalid input parameters");
            System.exit(1);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        String path = arg[0];
        String fileName = arg[1];

        try {
            List<String> lines = fileService.getLinesFromFile(path, fileName);
            List<Player> players = boardService.fillPlayersRolls(lines);

            boardService.printBoard(new Board(players));
            printConsoleResult(baos.toString());
        } catch (IOException | ChallengeException e) {
            System.out.println(e.getMessage());
            printConsoleResult(baos.toString());
        }
    }

    private static void printConsoleResult(String message){
        result = message;
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.print(result);
    }

    public static String getResult() {
        return result == null ? "" : result;
    }
}
