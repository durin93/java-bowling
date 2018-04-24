import domain.Round;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.PrintView;

public class Main {
    public static void main(String[] args) {

        String name = InputView.inputName();
        PrintView.printBaseBoard();
        Round round = Round.of();

        while (!round.isEnd()) {
            round.bowl(InputView.inputScore(round.frameSize()));
            PrintView.printBaseBoard();
            PrintView.printPinBoard(name, round);
            PrintView.printScoreBoard();
        }
    }
}
