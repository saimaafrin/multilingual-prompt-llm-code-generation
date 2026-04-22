import java.util.ArrayList;
import java.util.List;

public class FrameVisitor {
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;

    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        return currentFrame.getNextIndex();
    }

    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;
        private int nextIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextIndex = 0; // Inicialmente, el siguiente índice es 0
        }

        public int getNextIndex() {
            return nextIndex++;
        }
    }
}