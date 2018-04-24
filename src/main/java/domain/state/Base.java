package domain.state;

public class Base extends State {
    private int countOfPin;

    Base(int countOfPin) {
        this.countOfPin = countOfPin;
    }

    public static State of(int countOfPin) {
        return new Base(countOfPin);
    }

    @Override
    public State bowl(int countOfPin) {
        if (this.countOfPin + countOfPin == 10) {
            return Spare.of(this.countOfPin, countOfPin);
        }
        return Miss.of(this.countOfPin, countOfPin);
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(countOfPin);
    }
}