import java.util.Stack;

public class OutputFrame {
    private Stack<String> frame;

    public OutputFrame() {
        frame = new Stack<>();
    }

    /**
     * Elimina el número dado de tipos abstractos del "output frame" de salida.
     * @param elements el número de tipos abstractos que deben ser eliminados.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("El número de elementos a eliminar no puede ser negativo.");
        }
        if (elements > frame.size()) {
            throw new IllegalArgumentException("No hay suficientes elementos en el frame para eliminar.");
        }
        for (int i = 0; i < elements; i++) {
            frame.pop();
        }
    }

    // Método para agregar elementos al frame (solo para propósitos de prueba)
    public void push(String element) {
        frame.push(element);
    }

    // Método para obtener el tamaño del frame (solo para propósitos de prueba)
    public int size() {
        return frame.size();
    }

    public static void main(String[] args) {
        OutputFrame outputFrame = new OutputFrame();
        outputFrame.push("Tipo1");
        outputFrame.push("Tipo2");
        outputFrame.push("Tipo3");

        System.out.println("Tamaño del frame antes de pop: " + outputFrame.size());
        outputFrame.pop(2);
        System.out.println("Tamaño del frame después de pop: " + outputFrame.size());
    }
}