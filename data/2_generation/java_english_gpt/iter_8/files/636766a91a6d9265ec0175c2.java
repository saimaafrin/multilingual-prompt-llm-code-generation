import java.util.Stack;

public class AbstractTypeStack {
    private Stack<Integer> outputFrameStack;

    public AbstractTypeStack() {
        outputFrameStack = new Stack<>();
    }

    /**
     * Pops an abstract type from the output frame stack and returns its value.
     * @return the abstract type that has been popped from the output frame stack.
     */
    private int pop() {
        if (outputFrameStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        return outputFrameStack.pop();
    }

    // Method to push an integer onto the stack for testing purposes
    public void push(int value) {
        outputFrameStack.push(value);
    }

    // Main method for testing
    public static void main(String[] args) {
        AbstractTypeStack stack = new AbstractTypeStack();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped value: " + stack.pop()); // Should print 20
        System.out.println("Popped value: " + stack.pop()); // Should print 10
    }
}