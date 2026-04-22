import java.util.Stack;

public class FrameStack {
    private Stack<Integer> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /**
     * Extrae un tipo abstracto de la pila de marcos de salida y devuelve su valor.
     * @return el tipo abstracto que ha sido extraído de la pila de marcos de salida.
     */
    private int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return stack.pop();
    }

    // Método adicional para agregar elementos a la pila (push)
    public void push(int value) {
        stack.push(value);
    }

    // Método adicional para verificar si la pila está vacía
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}