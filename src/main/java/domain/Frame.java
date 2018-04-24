package domain;

import domain.state.Ready;
import domain.state.State;
import domain.state.Strike;

public class Frame {

    private State state;
    private Frame next;

    Frame() {
        state = Ready.of();
    }

    public State getState() {
        return state;
    }

    public void bowl(int inputScore) {
        state = state.bowl(inputScore);
    }

    public int getScore() {
        Score score = createScore();
        if (score.canCalucateScore()) {
            return score.getScore();
        }
        return next.cacluateAdditionalScore(score);
    }

    private Score createScore() {
        return state.getScore();
    }

    private int cacluateAdditionalScore(Score beforeScore) {
        return 0;
        // TODO beforeScore에 현재 Frame의 쓰러진 Pin을 추가해 점수를 구하는 로직 구현
    }

    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
