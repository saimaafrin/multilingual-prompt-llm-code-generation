import java.util.Stack;

public class FrameStackHandler {

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        Stack<String> frameStack = new Stack<>(); // Pila de marcos de salida

        // Verificar si el descriptor es un descriptor de método
        if (descriptor.startsWith("(")) {
            // Extraer los tipos de argumento del descriptor de método
            String[] argumentTypes = extractArgumentTypes(descriptor);

            // Extraer los tipos de la pila de marcos de salida
            for (String type : argumentTypes) {
                if (!frameStack.isEmpty()) {
                    frameStack.pop();
                } else {
                    throw new IllegalStateException("No hay suficientes marcos en la pila para extraer.");
                }
            }
        } else {
            // Si no es un descriptor de método, extraer un solo tipo
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("No hay suficientes marcos en la pila para extraer.");
            }
        }
    }

    /**
     * Extrae los tipos de argumento de un descriptor de método.
     * @param descriptor el descriptor de método.
     * @return un arreglo de tipos de argumento.
     */
    private String[] extractArgumentTypes(String descriptor) {
        // Eliminar el paréntesis inicial y final
        String args = descriptor.substring(1, descriptor.indexOf(')'));

        // Dividir los tipos de argumento
        return args.split(";");
    }

    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.pop("(Ljava/lang/String;I)V"); // Ejemplo de uso
    }
}