package com.challenge.services.impl;

import com.challenge.exception.ChallengeException;
import com.challenge.model.Board;
import com.challenge.model.Frame;
import com.challenge.model.Player;
import com.challenge.services.IBoardService;
import com.challenge.validator.ValidationError;

import java.util.List;
import java.util.stream.Collectors;

public class BoardService implements IBoardService {

    private PinfallsService pinfallsService = new PinfallsService();
    private InputFileLineValidatorService validatorService = new InputFileLineValidatorService();


    @Override
    public List<Player> fillPlayersRolls(List<String> lines) throws ChallengeException {
        List<Player> players = lines.stream()
                .map(line -> line.split("\\t")[0].trim())
                .distinct().map(Player::new).collect(Collectors.toList());

        String firstPlayer = players.get(0).getName();
        int frameNbr = 1;

        for (int i = 0; i < lines.size(); i++) {

            String playerName = lines.get(i).split("\\t")[0].trim();
            String playerRoll = lines.get(i).split("\\t")[1].trim();

            int firstRollValue = pinfallsService.pinfallNumericValue(playerRoll);
            validatorService.isLessEqualsThanTen(firstRollValue);
            int secondRollValue = 0;
            Frame frame = new Frame(frameNbr);

            if (isNotEndOfFileAndNextPlayerRoll(i, lines, playerName, playerRoll)) {
                isEndOfFile(lines, i, frameNbr, playerName);

                frame.setFirstRoll(playerRoll);
                if("10".equals(playerRoll) && frameNbr < 10 && !playerName.equals(lines.get(i+1).split("\\t")[0].trim())) {
                    frame.setSecondRoll("0");
                    i--;
                } else {
                    frame.setSecondRoll(lines.get(i + 1).split("\\t")[1].trim());
                }

                secondRollValue = pinfallsService.pinfallNumericValue(frame.getSecondRoll());
                validatorService.isLessEqualsThanTen(secondRollValue);
                int pins = firstRollValue + secondRollValue;

                if (frameNbr < 10) {
                    validatorService.isLessEqualsThanTen(pins);
                }

                i++;

                if (frameNbr == 10 && i < lines.size() - 1) {
                    int extraRollValue = pinfallsService.pinfallNumericValue(lines.get(i + 1).split("\\t")[1].trim());
                    validatorService.isLessEqualsThanTen(extraRollValue);
                    frame.setExtraRoll(lines.get(i + 1).split("\\t")[1].trim());
                    try {
                        String nextPlayerName = lines.get(i + 2).split("\\t")[0].trim();
                        if (nextPlayerName.equals(playerName))
                            throw ValidationError.INVALID_LINE_VALUE.toException();
                    } catch (IndexOutOfBoundsException e) {
                        // nothing to do, end of file
                    }
                    i++;
                }
            }

            frame.setStrike("10".equals(frame.getFirstRoll()));
            frame.setSpare((firstRollValue + secondRollValue) == 10
                    && !frame.isStrike());

            Player player = players.stream().filter(p -> p.getName().equals(playerName)).findFirst().get();
            player.getFrames().add(frame);

            if (isMoveToNextFrame(i, lines, firstPlayer)) {
                frameNbr++;
            }

            validatorService.isLessEqualsThanTen(frameNbr);
        }

        return players;
    }

    private void isEndOfFile(List<String> lines, int index, int frameNbr, String playerName) throws ChallengeException {
        try {
            String nextPlayerName = lines.get(index + 2).split("\\t")[0].trim();
            if (frameNbr != 10 && nextPlayerName.equals(playerName))
                throw ValidationError.INVALID_LINE_VALUE.toException();
        } catch (IndexOutOfBoundsException e) {
            // nothing to do, end of file
        }
    }

    @Override
    public void printBoard(Board board) {
        System.out.println("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
        for (int i = 0; i < board.getPlayers().size(); i++) {
            int totalScore = 0;
            System.out.println(board.getPlayers().get(i).getName());
            System.out.print("Pinfalls\t");
            for (int j = 0; j < board.getPlayers().get(i).getFrames().size(); j++) {
                Frame frame = board.getPlayers().get(i).getFrames().get(j);
                System.out.print(pinfallsService.getPinfallBoardValue(frame.getFirstRoll(), frame.getSecondRoll()));
                if (j == 9) {
                    System.out.print(pinfallsService.getPinfallBoardValue(frame.getExtraRoll()));
                }
            }
            System.out.println();
            System.out.print("Score\t\t");
            for (int j = 0; j < board.getPlayers().get(i).getFrames().size(); j++) {
                Frame frame = board.getPlayers().get(i).getFrames().get(j);
                totalScore += pinfallsService.pinfallNumericValue(frame.getFirstRoll()) + pinfallsService.pinfallNumericValue(frame.getSecondRoll());

                if (j >= 9) {
                    totalScore += pinfallsService.pinfallNumericValue(frame.getExtraRoll());
                }

                if (j < 9) {
                    Frame nextFrame = board.getPlayers().get(i).getFrames().get(j + 1);
                    if (frame.isSpare()) {
                        totalScore += pinfallsService.pinfallNumericValue(nextFrame.getFirstRoll());
                    }

                    //Is continuous strike
                    if (!frame.isSpare() && frame.isStrike() && nextFrame.isStrike()) {
                        totalScore += pinfallsService.pinfallNumericValue(nextFrame.getFirstRoll());
                        if (j == 8) {
                            totalScore += pinfallsService.pinfallNumericValue(nextFrame.getExtraRoll());
                        } else {
                            totalScore += pinfallsService.pinfallNumericValue(board.getPlayers().get(i).getFrames().get(j + 2).getFirstRoll());
                        }
                    }

                    //Is not continuous strike
                    if (!frame.isSpare() && frame.isStrike() && !nextFrame.isStrike()) {
                        totalScore += pinfallsService.pinfallNumericValue(nextFrame.getFirstRoll());
                        totalScore += pinfallsService.pinfallNumericValue(nextFrame.getSecondRoll());
                    }
                }
                System.out.print(totalScore + "\t\t");
            }
            System.out.println();
        }
    }

   private boolean isMoveToNextFrame(int index, List<String> lines, String firstPlayer) {
        return index < lines.size() - 1 && lines.get(index + 1).startsWith(firstPlayer);
    }

    private boolean isNotEndOfFileAndNextPlayerRoll(int index, List<String> lines, String playerName, String playerRoll) {
        return index < lines.size() - 1 && (lines.get(index + 1).split("\\t")[0].trim().equals(playerName) || "10".equals(playerRoll));
    }
}
