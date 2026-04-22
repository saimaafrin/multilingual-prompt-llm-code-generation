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

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push(10);
        frameStack.outputFrameStack.push(20);
        System.out.println(frameStack.pop()); // Output: 20
        System.out.println(frameStack.pop()); // Output: 10
    }
}