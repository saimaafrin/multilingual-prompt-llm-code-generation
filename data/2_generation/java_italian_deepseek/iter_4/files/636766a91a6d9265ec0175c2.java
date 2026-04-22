import java.util.Stack;

public class Frame {
    private Stack<Integer> outputFrameStack;

    public Frame() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * Estrae un tipo astratto dallo stack del frame di output e restituisce il suo valore.
     * @return il tipo astratto che è stato estratto dallo stack del frame di output.
     */
    private int pop() {
        if (outputFrameStack.isEmpty()) {
            throw new IllegalStateException("Lo stack del frame di output è vuoto.");
        }
        return outputFrameStack.pop();
    }
}