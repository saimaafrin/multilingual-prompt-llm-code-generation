import java.util.ArrayList;
import java.util.List;

public class StackMapFrameVisitor {
    private List<Frame> currentFrame;

    public StackMapFrameVisitor() {
        this.currentFrame = new ArrayList<>();
    }

    /**
     * Starts the visit of a new stack map frame, stored in  {@link #currentFrame}.
     * @param offset   the bytecode offset of the instruction to which the frame corresponds.
     * @param numLocal the number of local variables in the frame.
     * @param numStack the number of stack elements in the frame.
     * @return the index of the next element to be written in this frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        Frame frame = new Frame(offset, numLocal, numStack);
        currentFrame.add(frame);
        return currentFrame.size() - 1; // Return the index of the newly added frame
    }

    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
        }

        public int getOffset() {
            return offset;
        }

        public int getNumLocal() {
            return numLocal;
        }

        public int getNumStack() {
            return numStack;
        }
    }
}