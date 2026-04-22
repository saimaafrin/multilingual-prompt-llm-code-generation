import java.util.Stack;

public class FrameStack {
    private Stack<String> outputFrameStack = new Stack<>();

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        if (descriptor.startsWith("(")) {
            // È un descrittore di metodo, rimuovi i tipi di argomento
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                return;
            }
            String argsDescriptor = descriptor.substring(1, endIndex);
            removeTypesFromStack(argsDescriptor);
        } else {
            // È un tipo singolo, rimuovi il tipo dallo stack
            removeTypeFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String argsDescriptor) {
        int index = 0;
        while (index < argsDescriptor.length()) {
            char currentChar = argsDescriptor.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, trova il punto e virgola
                int semicolonIndex = argsDescriptor.indexOf(';', index);
                if (semicolonIndex == -1) {
                    break;
                }
                String type = argsDescriptor.substring(index, semicolonIndex + 1);
                removeTypeFromStack(type);
                index = semicolonIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, rimuovi il tipo base
                removeTypeFromStack(argsDescriptor.substring(index, index + 1));
                index++;
            } else {
                // Tipo primitivo
                removeTypeFromStack(argsDescriptor.substring(index, index + 1));
                index++;
            }
        }
    }

    private void removeTypeFromStack(String type) {
        if (!outputFrameStack.isEmpty() && outputFrameStack.peek().equals(type)) {
            outputFrameStack.pop();
        }
    }
}