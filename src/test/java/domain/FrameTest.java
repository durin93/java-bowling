package domain;


import domain.state.Base;
import domain.state.Miss;
import domain.state.Spare;
import domain.state.Strike;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FrameTest {
    
    Frame frame;
    
    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void returnFirstBowl() {
        frame.bowl(1);
        assertTrue(frame.getState() instanceof Base);
    }

    @Test
    public void returnStrike() {
        frame.bowl(10);
        assertTrue(frame.getState() instanceof Strike);
    }

    @Test
    public void returnSoare() {
        frame.bowl(1);
        frame.bowl(9);
        assertTrue(frame.getState() instanceof Spare);
    }

    @Test
    public void returnMiss() {
        frame.bowl(1);
        frame.bowl(3);
        assertTrue(frame.getState() instanceof Miss);
    }

    @Test
    public void returnScore_miss() {
        frame.bowl(1);
        frame.bowl(3);
        assertThat(frame.getState().toString(), is("1|3"));
    }

    @Test
    public void returnScore_spare() {
        frame.bowl(1);
        frame.bowl(9);
        assertThat(frame.getState().toString(), is("1|/"));
    }

    @Test
    public void returnScore_strike() {
        frame.bowl(10);
        assertThat(frame.getState().toString(), is("X"));
    }

    @Test
    public void listTest() {
        List<Frame> frames = new ArrayList<>();
        Frame frame1 = new Frame();
        frame1.bowl(1);
        frame1.bowl(1);
        Frame frame3 = new Frame();
        frame3.bowl(10);
        Frame frame2 = new Frame();
        frame2.bowl(2);
        frame2.bowl(8);

        frames.add(frame1);
        frames.add(frame3);
        frames.add(frame2);

        System.out.println(frames.stream().map(frame -> String.format("  %-6s", frame.getState().toString())).collect(Collectors.joining("|")));
    }

    @Test
    public void lastFrameNormalCase() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.bowl(5);
        assertThat(lastFrame.isEnd(), is(false));
    }

    @Test
    public void lastFrameNormalCase2() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.bowl(5);
        lastFrame.bowl(4);
        assertThat(lastFrame.isEnd(), is(true));
    }

    @Test
        public void lastFrameStrikeCase() {
            LastFrame lastFrame = new LastFrame();
            lastFrame.bowl(10);
            assertThat(lastFrame.isEnd(), is(false));
            lastFrame.bowl(1);
            assertThat(lastFrame.isEnd(), is(false));
            lastFrame.bowl(5);
        assertThat(lastFrame.isEnd(), is(true));
    }

    @Test
    public void lastFrameSpareCase() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.bowl(5);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(5);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(5);
        assertThat(lastFrame.isEnd(), is(true));
    }

    @Test
    public void lastFrameStrike2() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.bowl(10);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(10);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(10);
        assertThat(lastFrame.isEnd(), is(true));
    }

    @Test
    public void lastFrameStrike3() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.bowl(10);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(10);
        assertThat(lastFrame.isEnd(), is(false));
        lastFrame.bowl(1);
        assertThat(lastFrame.isEnd(), is(true));
    }
}
