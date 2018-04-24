package domain.state;

public class Ready extends State {

    //Pins

    private Ready() {
        ofPin();
    }

    public static State of() {
        return new Ready();
    }

    public State bowl(int countOfPin) {
        addPin(countOfPin);
        if (countOfPin == 10) {
            return Strike.of();
        }

        makeScore(countOfPin);

        return Base.of(countOfPin);
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public String toString() {
        return getPins().toString();
    }


}
