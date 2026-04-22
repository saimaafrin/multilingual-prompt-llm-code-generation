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
            throw new IllegalStateException("La pila de marcos de salida está vacía.");
        }
        return stack.pop();
    }

    // Método adicional para agregar elementos a la pila (solo para propósitos de prueba)
    public void push(int value) {
        stack.push(value);
    }
}