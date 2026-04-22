import java.util.Stack;

public class FrameStack {
    private Stack<Object> frameStack = new Stack<>();

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
            // Extraer los tipos de argumento del descriptor
            String[] parts = descriptor.split("\\)");
            if (parts.length > 1) {
                String argumentTypes = parts[0].substring(1);
                String[] types = argumentTypes.split(";");

                for (String type : types) {
                    if (!type.isEmpty()) {
                        // Extraer el tipo base (eliminar 'L' y ';' si es un objeto)
                        String baseType = type.replace("L", "").replace(";", "");
                        // Extraer el tipo de la pila
                        if (!frameStack.isEmpty()) {
                            frameStack.pop();
                        }
                    }
                }
            }
        } else {
            // Si es un tipo simple, extraer un solo elemento de la pila
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.frameStack.push("Type1");
        frameStack.frameStack.push("Type2");
        frameStack.frameStack.push("Type3");

        frameStack.pop("(Ljava/lang/String;I)V");

        System.out.println(frameStack.frameStack); // Debería imprimir [Type1]
    }
}