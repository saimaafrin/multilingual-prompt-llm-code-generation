import java.util.Stack;

public class OutputFrame {
    private Stack<AbstractType> outputStack;

    public OutputFrame() {
        this.outputStack = new Stack<>();
    }

    /**
     * Elimina el número dado de tipos abstractos del "output frame" de salida.
     * @param elements el número de tipos abstractos que deben ser eliminados.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("El número de elementos a eliminar no puede ser negativo.");
        }
        if (elements > outputStack.size()) {
            throw new IllegalArgumentException("No hay suficientes elementos en el stack para eliminar.");
        }
        for (int i = 0; i < elements; i++) {
            outputStack.pop();
        }
    }

    // Ejemplo de clase AbstractType para completar la implementación
    private static class AbstractType {
        // Implementación de la clase AbstractType
    }
}