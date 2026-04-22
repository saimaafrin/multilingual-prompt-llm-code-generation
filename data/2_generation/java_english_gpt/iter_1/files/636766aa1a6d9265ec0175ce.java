public class StackMapFrameVisitor {
    private StackMapFrame currentFrame;
    private int nextElementIndex;

    public StackMapFrameVisitor() {
        this.currentFrame = new StackMapFrame();
        this.nextElementIndex = 0;
    }

    /**
     * Starts the visit of a new stack map frame, stored in  {@link #currentFrame}.
     * @param offset   the bytecode offset of the instruction to which the frame corresponds.
     * @param numLocal the number of local variables in the frame.
     * @param numStack the number of stack elements in the frame.
     * @return the index of the next element to be written in this frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame.setOffset(offset);
        currentFrame.setNumLocal(numLocal);
        currentFrame.setNumStack(numStack);
        nextElementIndex = 0; // Reset index for new frame
        return nextElementIndex;
    }

    // Inner class to represent a stack map frame
    private class StackMapFrame {
        private int offset;
        private int numLocal;
        private int numStack;

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setNumLocal(int numLocal) {
            this.numLocal = numLocal;
        }

        public void setNumStack(int numStack) {
            this.numStack = numStack;
        }
    }
}