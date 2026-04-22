import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrameStack;

    public FrameStack() {
        outputFrameStack = new Stack<>();
    }

    /**
     * Pops the given number of abstract types from the output frame stack.
     * @param elements the number of abstract types that must be popped.
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }
}