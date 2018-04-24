package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pin {
    private List<Integer> pins;

    public Pin(List<Integer> pins) {
        this.pins = new ArrayList<>(pins);
    }

    public static Pin of(Integer... pins) {
        return new Pin(Arrays.asList(pins));
    }


    public void add(int countOfPin) {
        pins.add(countOfPin);
    }

    public String toString() {
        return pins.get(0) + "|" + pins.get(1);
    }

}
