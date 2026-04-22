import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrameStack;

    public FrameStack() {
        outputFrameStack = new Stack<>();
    }

    public void popElements(int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop must be non-negative");
        }

        if (elements > outputFrameStack.size()) {
            throw new IllegalStateException("Cannot pop more elements than exist in stack");
        }

        for (int i = 0; i < elements; i++) {
            outputFrameStack.pop();
        }
    }
}