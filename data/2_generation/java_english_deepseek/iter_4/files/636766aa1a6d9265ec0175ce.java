public class StackMapFrameVisitor {
    private int[] currentFrame;

    /**
     * Starts the visit of a new stack map frame, stored in  {@link #currentFrame}.
     * @param offset   the bytecode offset of the instruction to which the frame corresponds.
     * @param numLocal the number of local variables in the frame.
     * @param numStack the number of stack elements in the frame.
     * @return the index of the next element to be written in this frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Calculate the total size of the frame (locals + stack + 1 for the offset)
        int frameSize = numLocal + numStack + 1;
        currentFrame = new int[frameSize];

        // Store the offset at the beginning of the frame
        currentFrame[0] = offset;

        // Return the index of the next element to be written (after the offset)
        return 1;
    }
}