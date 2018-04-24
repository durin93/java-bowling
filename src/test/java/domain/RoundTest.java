package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoundTest {

    Round round;

    @Before
    public void createRound() {
        round = Round.of();
    }

    @Test
    public void printScores() {
        round.bowl(1);
        round.bowl(1);
        assertThat(round.isFrameEnd(), is(true));
        round.bowl(5);
        assertThat(round.isFrameEnd(), is(false));
    }
}
