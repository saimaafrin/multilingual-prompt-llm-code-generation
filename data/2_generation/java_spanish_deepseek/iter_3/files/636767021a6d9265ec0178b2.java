import java.util.Stack;

public class FrameStack {
    private Stack<String> frameStack;

    public FrameStack() {
        frameStack = new Stack<>();
    }

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // Si el descriptor es un método, extraemos los tipos de argumento
        if (descriptor.startsWith("(")) {
            String[] parts = descriptor.split("\\)");
            if (parts.length > 1) {
                String argumentTypes = parts[0].substring(1); // Ignoramos el '(' inicial
                String[] types = argumentTypes.split(";");
                for (String type : types) {
                    if (!type.isEmpty()) {
                        frameStack.pop(); // Extraemos cada tipo de la pila
                    }
                }
            }
        } else {
            // Si es un tipo simple, extraemos un solo elemento
            frameStack.pop();
        }
    }

    // Método para agregar elementos a la pila (solo para propósitos de prueba)
    public void push(String type) {
        frameStack.push(type);
    }

    // Método para obtener el tamaño de la pila (solo para propósitos de prueba)
    public int size() {
        return frameStack.size();
    }
}