package domain;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Round {
    private LinkedList<Frame> frames;

    public Round(LinkedList<Frame> frames) {
        this.frames = frames;
    }

    public static Round of() {
        LinkedList<Frame> frames = new LinkedList<>();
        frames.add(new Frame());
        return new Round(frames);
    }

    public LinkedList<Frame> getFrames() {
        return frames;
    }

    public void bowl(int inpuScore) {
        if (frames.getLast().isEnd()) {
            addFrame(inpuScore, frames.size() + 1);
            return;
        }
        frames.getLast().bowl(inpuScore);
    }

    private void addFrame(int inpuScore, int frameNum) {
        Frame newFrame = makeFrame(frameNum);
        newFrame.bowl(inpuScore);
        frames.add(newFrame);
    }

    private Frame makeFrame(int frameNum) {
        if (frameNum == 10) {
            return new LastFrame();
        }
        return new Frame();
    }

    public boolean isFrameEnd() {
        return frames.getLast().isEnd();
    }

    public boolean isEnd() {
        return frames.size() == 10 && frames.getLast().isEnd();
    }

    public int frameSize() {
        if (frames.getLast().isEnd()) {
            return frames.size() + 1;
        }
        return frames.size();
    }
}
