package domain.state;

import domain.Pin;
import domain.Score;

import java.util.Arrays;

public abstract class State {

    private Pin pins;
    private Score score;

    public abstract State bowl(int i);

    public Score makeScore(int inputScore) {
        return null;
//        score = Score.of(inputScore);

    }

    public void addPin(int countOfPin) {
        pins.add(countOfPin);
    }

    public Score getScore() {
        return score;
    }

    public void ofPin(Integer... pins) {
        this.pins = Pin.of(pins);
    }

    public Pin getPins() {
        return pins;
    }

    public abstract boolean isEnd();

    public boolean isSpecial() {
        return false;
    }
}

