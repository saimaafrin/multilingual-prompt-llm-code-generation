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
        // Calculate the total size of the frame
        int frameSize = numLocal + numStack;
        
        // Initialize the currentFrame array with the appropriate size
        currentFrame = new int[frameSize];
        
        // Reset the nextElementIndex to 0
        nextElementIndex = 0;
        
        // Return the index of the next element to be written
        return nextElementIndex;
    }
}