package domain.state;

public class Spare extends SpecialState {
    private Spare(int countOfPin, int countOfPin1) {
        ofPin(countOfPin, countOfPin1);
    }

    public static Spare of(int countOfPin, int countOfPin1) {
        return new Spare(countOfPin, countOfPin1);
    }

    @Override
    public State bowl(int i) {
        return Base.of(i);
    }

    @Override
    public boolean isEnd() {
        return true;
    }

    @Override
    public String toString() {
        String[] temp = getPins().toString().split("|");
        return temp[0] + "|/";
    }
}
