import java.util.ArrayList;
import java.util.List;

public class FrameVisitor {
    private List<Object> currentFrame;

    public FrameVisitor() {
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
        // Clear the current frame to start a new one
        currentFrame.clear();

        // Add the offset, numLocal, and numStack to the frame
        currentFrame.add(offset);
        currentFrame.add(numLocal);
        currentFrame.add(numStack);

        // Return the index of the next element to be written
        return currentFrame.size();
    }

    // Example usage
    public static void main(String[] args) {
        FrameVisitor visitor = new FrameVisitor();
        int nextIndex = visitor.visitFrameStart(10, 3, 2);
        System.out.println("Next index to write: " + nextIndex);
    }
}