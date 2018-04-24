package domain.state;

public class Miss extends State {

    private Miss(int countOfPin, int countOfPin1) {
        ofPin(countOfPin, countOfPin1);
    }

    public static Miss of(int countOfPin, int countOfPin1) {
        return new Miss(countOfPin, countOfPin1);
    }

    public State bowl(int i) {
        return null;
    }

    @Override
    public boolean isEnd() {
        return true;
    }

    @Override
    public String toString() {
        return getPins().toString();
    }


}
