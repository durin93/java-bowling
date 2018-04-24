package domain;

public class Score {
    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public Score bowl(int countOfPins) {
        return new Score(score += countOfPins, left - 1);
    }

    public int getScore() {
        if (!canCalucateScore()) {
            throw new RuntimeException();
        }
        return this.score;
    }

    public boolean canCalucateScore() {
        return left == 0;
    }

}
