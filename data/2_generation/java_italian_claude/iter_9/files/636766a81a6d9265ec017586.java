import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputStack;

    public FrameStack() {
        outputStack = new Stack<>();
    }

    /**
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!outputStack.isEmpty()) {
                outputStack.pop();
            }
        }
    }
}