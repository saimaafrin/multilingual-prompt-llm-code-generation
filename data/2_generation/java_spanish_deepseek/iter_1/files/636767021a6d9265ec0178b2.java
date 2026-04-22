import java.util.Stack;

public class FrameStackHandler {

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        Stack<String> frameStack = new Stack<>();

        // Simulación de una pila de marcos de salida
        frameStack.push("Frame1");
        frameStack.push("Frame2");
        frameStack.push("Frame3");

        // Determinar cuántos elementos extraer basado en el descriptor
        int elementsToPop = 0;
        if (descriptor.startsWith("(")) {
            // Si el descriptor es un descriptor de método, extraer los tipos de argumento
            String[] parts = descriptor.split("\\)");
            if (parts.length > 0) {
                String argumentTypes = parts[0].substring(1);
                elementsToPop = argumentTypes.length();
            }
        } else {
            // Si es un tipo simple, extraer un solo elemento
            elementsToPop = 1;
        }

        // Extraer los elementos de la pila
        for (int i = 0; i < elementsToPop; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                break;
            }
        }

        // Imprimir el estado de la pila después de la extracción
        System.out.println("Estado de la pila después de extraer " + elementsToPop + " elementos: " + frameStack);
    }

    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.pop("(Ljava/lang/String;I)V"); // Ejemplo de descriptor de método
    }
}