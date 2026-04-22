import java.util.Stack;

public class FrameStack {
    private Stack<AbstractType> outputFrameStack;

    public FrameStack() {
        outputFrameStack = new Stack<>();
    }

    public AbstractType pop() {
        if (outputFrameStack.isEmpty()) {
            throw new IllegalStateException("Output frame stack is empty");
        }
        return outputFrameStack.pop();
    }
}

// Abstract type class for type safety
abstract class AbstractType {
    // Base class for abstract types
}