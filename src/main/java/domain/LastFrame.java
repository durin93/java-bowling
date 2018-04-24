package domain;

import domain.state.*;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class LastFrame extends Frame {

    private LinkedList<State> states;

    public LastFrame() {
        states = new LinkedList<>();
    }

    public void bowl(int inputScore) {
        addFrame(inputScore);
    }

    private void addFrame(int inputScore) {
        if (states.size() == 0) {
            states.add(Ready.of().bowl(inputScore));
            return;
        }
        if (states.getLast().isSpecial()) {
            states.add(Ready.of().bowl(inputScore));
            return;
        }
        states.add(states.getLast().bowl(inputScore));
    }

    @Override
    public boolean isEnd() {
        if (states.size() == 3) {
            return true;
        }
        if (states.getLast().isSpecial()) {
            return false;
        }
        return states.getLast().isEnd();
    }

    @Override
    public String toString() {
        return states.stream().map(i -> i.toString()).collect(Collectors.joining("|"));
    }
}

