package com.challenge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Frame> frames = new ArrayList<Frame>(10);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
