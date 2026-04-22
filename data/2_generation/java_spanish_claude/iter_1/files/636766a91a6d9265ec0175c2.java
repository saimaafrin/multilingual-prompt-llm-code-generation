import java.util.Stack;

public class FrameStack {
    private Stack<Integer> outputFrameStack;
    
    public FrameStack() {
        outputFrameStack = new Stack<>();
    }
    
    /**
     * Extrae un tipo abstracto de la pila de marcos de salida y devuelve su valor.
     * @return el tipo abstracto que ha sido extraído de la pila de marcos de salida.
     */
    private int pop() {
        if (!outputFrameStack.isEmpty()) {
            return outputFrameStack.pop();
        } else {
            throw new IllegalStateException("La pila de marcos está vacía");
        }
    }
}