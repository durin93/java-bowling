package domain.state;

public class Strike extends SpecialState {

    private Strike() {
        ofPin(10);
    }

    public static Strike of() {
        return new Strike();
    }

    @Override
    public State bowl(int i) {
        if (i == 10) {
            return Strike.of();
        }
        return Base.of(i);
    }

    public boolean isEnd() {
        return true;
    }

    @Override
    public String toString() {
        return "X";
    }

}
