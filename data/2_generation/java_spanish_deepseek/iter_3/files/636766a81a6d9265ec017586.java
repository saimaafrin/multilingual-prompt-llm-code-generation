import java.util.Stack;

public class OutputFrame {
    private Stack<String> outputStack;

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

    // Método para agregar elementos al stack (solo para propósitos de prueba)
    public void push(String element) {
        outputStack.push(element);
    }

    // Método para obtener el tamaño del stack (solo para propósitos de prueba)
    public int size() {
        return outputStack.size();
    }

    // Método para imprimir el stack (solo para propósitos de prueba)
    public void printStack() {
        System.out.println(outputStack);
    }

    public static void main(String[] args) {
        OutputFrame frame = new OutputFrame();
        frame.push("Tipo1");
        frame.push("Tipo2");
        frame.push("Tipo3");

        System.out.println("Stack antes de pop:");
        frame.printStack();

        frame.pop(2);

        System.out.println("Stack después de pop:");
        frame.printStack();
    }
}