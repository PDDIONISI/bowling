package com.challenge.unit;

import com.challenge.exception.ChallengeException;
import com.challenge.mocks.ListMocks;
import com.challenge.model.Player;
import com.challenge.services.IBoardService;
import com.challenge.services.impl.BoardService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

public class BoardServiceTest {
    private IBoardService boardService = new BoardService();

    @Test
    public void fillPlayersRolls_ok() {
        try {
            List<Player> players = boardService.fillPlayersRolls(ListMocks.GAME);
            Assert.assertEquals(2, players.size());
            Assert.assertEquals("Pablo", players.get(0).getName());
            Assert.assertEquals("Cindy", players.get(1).getName());
        } catch (ChallengeException e) {
            fail();
        }
    }

    @Test
    public void fillPlayersRolls_fail_ROLLS_MORE_THAN_TEN() {
        try {
            boardService.fillPlayersRolls(ListMocks.ROLLS_MORE_THAN_TEN);
            fail();
        } catch (ChallengeException e) {
            Assert.assertEquals("Invalid format line", e.getMessage());
        }
    }


    @Test
    public void fillPlayersRolls_fail_SINGLE_ROLL_MORE_THAN_TEN() {
        try {
            boardService.fillPlayersRolls(ListMocks.SINGLE_ROLL_MORE_THAN_TEN);
            fail();
        } catch (ChallengeException e) {
            Assert.assertEquals("Invalid format line", e.getMessage());
        }
    }
}
