package domain.state;

public class SpecialState extends State {

    @Override
    public State bowl(int i) {
        return null;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
