import java.util.Stack;

public class FrameStack {
    private Stack<Integer> outputStack;

    public FrameStack() {
        outputStack = new Stack<>();
    }

    /**
     * Estrae un tipo astratto dallo stack del frame di output e restituisce il suo valore.
     * @return il tipo astratto che è stato estratto dallo stack del frame di output.
     */
    private int pop() {
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }
}