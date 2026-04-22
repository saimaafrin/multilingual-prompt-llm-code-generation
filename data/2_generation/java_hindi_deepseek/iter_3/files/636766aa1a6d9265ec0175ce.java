import java.util.HashMap;
import java.util.Map;

public class StackMapFrame {
    private Map<Integer, Frame> frames = new HashMap<>();
    private Frame currentFrame;

    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.put(offset, currentFrame);
        return currentFrame.getNextElementIndex();
    }

    private static class Frame {
        private int offset;
        private int numLocal;
        private int numStack;
        private int nextElementIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextElementIndex = 0; // Initialize the next element index
        }

        public int getNextElementIndex() {
            return nextElementIndex++;
        }
    }
}