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
            String argumentTypes = descriptor.substring(1, endIndex);
            removeTypesFromStack(argumentTypes);
        } else {
            // È un singolo tipo, rimuovilo dallo stack
            removeTypeFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String argumentTypes) {
        int index = 0;
        while (index < argumentTypes.length()) {
            char currentChar = argumentTypes.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, trova il punto e virgola
                int semicolonIndex = argumentTypes.indexOf(';', index);
                if (semicolonIndex == -1) {
                    break;
                }
                String objectType = argumentTypes.substring(index, semicolonIndex + 1);
                removeTypeFromStack(objectType);
                index = semicolonIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, rimuovi il tipo base
                removeTypeFromStack(String.valueOf(currentChar));
                index++;
            } else {
                // Tipo primitivo
                removeTypeFromStack(String.valueOf(currentChar));
                index++;
            }
        }
    }

    private void removeTypeFromStack(String type) {
        if (!outputFrameStack.isEmpty() && outputFrameStack.peek().equals(type)) {
            outputFrameStack.pop();
        }
    }

    // Metodo di esempio per aggiungere tipi allo stack (per testing)
    public void pushToStack(String type) {
        outputFrameStack.push(type);
    }

    // Metodo di esempio per ottenere lo stack (per testing)
    public Stack<String> getOutputFrameStack() {
        return outputFrameStack;
    }
}