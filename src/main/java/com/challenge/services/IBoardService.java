package com.challenge.services;

import com.challenge.exception.ChallengeException;
import com.challenge.model.Board;
import com.challenge.model.Player;

import java.util.List;

public interface IBoardService {

    List<Player> fillPlayersRolls(List<String> lines) throws ChallengeException;

    void printBoard(Board board);
}
