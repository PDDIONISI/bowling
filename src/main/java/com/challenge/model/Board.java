package com.challenge.model;

import java.util.Collections;
import java.util.List;

public class Board {
    private List<Player> players;

    public Board(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
