import java.util.Stack;

public class AbstractTypeStack {
    private Stack<Object> outputFrameStack;

    public AbstractTypeStack() {
        this.outputFrameStack = new Stack<>();
    }

    /** 
     * Pops the given number of abstract types from the output frame stack.
     * @param elements the number of abstract types that must be popped.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop must be non-negative.");
        }
        for (int i = 0; i < elements; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Not enough elements in the stack to pop.");
            }
        }
    }

    // Method to push elements for testing purposes
    public void push(Object element) {
        outputFrameStack.push(element);
    }

    // Method to get the current size of the stack for testing purposes
    public int size() {
        return outputFrameStack.size();
    }
}