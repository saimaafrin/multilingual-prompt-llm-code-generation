public class StackMapFrameVisitor {
    private int[] currentFrame;
    private int nextElementIndex;

    public StackMapFrameVisitor() {
        this.currentFrame = new int[0];
        this.nextElementIndex = 0;
    }

    /**
     * Starts the visit of a new stack map frame, stored in {@link #currentFrame}.
     * @param offset   the bytecode offset of the instruction to which the frame corresponds.
     * @param numLocal the number of local variables in the frame.
     * @param numStack the number of stack elements in the frame.
     * @return the index of the next element to be written in this frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Calculate the total size of the frame: offset + numLocal + numStack
        int frameSize = 1 + numLocal + numStack;
        currentFrame = new int[frameSize];

        // Store the offset in the first position of the frame
        currentFrame[0] = offset;

        // Initialize the next element index to 1 (after the offset)
        nextElementIndex = 1;

        return nextElementIndex;
    }

    // Additional methods to manipulate the frame can be added here
}