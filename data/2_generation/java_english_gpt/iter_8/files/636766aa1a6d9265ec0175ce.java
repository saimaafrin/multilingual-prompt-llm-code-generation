public class StackMapFrameVisitor {
    private int currentFrameOffset;
    private int currentNumLocal;
    private int currentNumStack;

    /**
     * Starts the visit of a new stack map frame, stored in  {@link #currentFrame}.
     * @param offset   the bytecode offset of the instruction to which the frame corresponds.
     * @param numLocal the number of local variables in the frame.
     * @param numStack the number of stack elements in the frame.
     * @return the index of the next element to be written in this frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        this.currentFrameOffset = offset;
        this.currentNumLocal = numLocal;
        this.currentNumStack = numStack;
        // Assuming the next index to write is the number of local variables
        return numLocal;
    }

    public static void main(String[] args) {
        StackMapFrameVisitor visitor = new StackMapFrameVisitor();
        int nextIndex = visitor.visitFrameStart(10, 5, 3);
        System.out.println("Next index to write: " + nextIndex);
    }
}