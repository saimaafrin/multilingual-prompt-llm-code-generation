import java.util.Stack;

public class FrameStack {
    private Stack<Integer> outputFrameStack;

    public FrameStack() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * Pops an abstract type from the output frame stack and returns its value.
     * @return the abstract type that has been popped from the output frame stack.
     */
    private int pop() {
        if (outputFrameStack.isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        return outputFrameStack.pop();
    }
}