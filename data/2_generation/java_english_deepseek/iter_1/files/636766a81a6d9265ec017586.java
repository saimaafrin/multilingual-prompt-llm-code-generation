import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrameStack;

    public FrameStack() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * Pops the given number of abstract types from the output frame stack.
     * @param elements the number of abstract types that must be popped.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop cannot be negative.");
        }
        if (outputFrameStack.size() < elements) {
            throw new IllegalStateException("Not enough elements in the stack to pop.");
        }
        for (int i = 0; i < elements; i++) {
            outputFrameStack.pop();
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push("Type1");
        frameStack.outputFrameStack.push("Type2");
        frameStack.outputFrameStack.push("Type3");

        frameStack.pop(2); // Pops "Type3" and "Type2"
        System.out.println(frameStack.outputFrameStack); // Output: [Type1]
    }
}