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

        // Si el descriptor es un tipo simple, simplemente extraemos un elemento
        if (!descriptor.startsWith("(")) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            }
            return;
        }

        // Si el descriptor es un descriptor de método, extraemos los tipos de argumento
        int startIndex = descriptor.indexOf('(') + 1;
        int endIndex = descriptor.indexOf(')');
        if (startIndex >= 0 && endIndex > startIndex) {
            String argsDescriptor = descriptor.substring(startIndex, endIndex);
            int argCount = countArguments(argsDescriptor);
            for (int i = 0; i < argCount; i++) {
                if (!frameStack.isEmpty()) {
                    frameStack.pop();
                }
            }
        }
    }

    /**
     * Cuenta el número de argumentos en el descriptor de argumentos.
     * @param argsDescriptor el descriptor de argumentos.
     * @return el número de argumentos.
     */
    private int countArguments(String argsDescriptor) {
        int count = 0;
        int index = 0;
        while (index < argsDescriptor.length()) {
            char c = argsDescriptor.charAt(index);
            if (c == 'L') {
                // Tipo de objeto, avanzar hasta el ';'
                int endIndex = argsDescriptor.indexOf(';', index);
                if (endIndex == -1) {
                    break;
                }
                index = endIndex + 1;
            } else if (c == '[') {
                // Tipo de array, avanzar al siguiente carácter
                index++;
            } else {
                // Tipo primitivo, avanzar al siguiente carácter
                index++;
            }
            count++;
        }
        return count;
    }

    // Método de prueba
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.frameStack.push("arg1");
        frameStack.frameStack.push("arg2");
        frameStack.frameStack.push("arg3");

        frameStack.pop("(Ljava/lang/String;I)V");
        System.out.println(frameStack.frameStack); // Debería imprimir [arg1]
    }
}