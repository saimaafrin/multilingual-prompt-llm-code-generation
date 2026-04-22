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
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                return;
            }
            String argumentTypes = descriptor.substring(1, endIndex);
            String[] types = argumentTypes.split(";");

            for (String type : types) {
                if (!type.isEmpty()) {
                    frameStack.pop();
                }
            }
        } else {
            // Si es un tipo simple, solo extraemos uno
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

    public static void main(String[] args) {
        FrameStack stack = new FrameStack();
        stack.push("int");
        stack.push("float");
        stack.push("double");

        System.out.println("Tamaño de la pila antes de pop: " + stack.size());
        stack.pop("(I;F;D)V");
        System.out.println("Tamaño de la pila después de pop: " + stack.size());
    }
}