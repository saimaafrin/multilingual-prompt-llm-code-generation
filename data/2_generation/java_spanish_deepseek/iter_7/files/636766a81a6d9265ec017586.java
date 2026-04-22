import java.util.Stack;

public class OutputFrame {
    private Stack<AbstractType> outputFrame;

    public OutputFrame() {
        this.outputFrame = new Stack<>();
    }

    /**
     * Elimina el número dado de tipos abstractos del "output frame" de salida.
     * @param elements el número de tipos abstractos que deben ser eliminados.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("El número de elementos a eliminar no puede ser negativo.");
        }
        if (elements > outputFrame.size()) {
            throw new IllegalArgumentException("No hay suficientes elementos en el output frame para eliminar.");
        }
        for (int i = 0; i < elements; i++) {
            outputFrame.pop();
        }
    }

    // Clase de ejemplo para AbstractType
    private static class AbstractType {
        // Implementación de tipo abstracto
    }
}