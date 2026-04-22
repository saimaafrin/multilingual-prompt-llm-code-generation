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
            int endOfArgs = descriptor.indexOf(')');
            if (endOfArgs == -1) {
                return;
            }
            String argsDescriptor = descriptor.substring(1, endOfArgs);
            removeTypesFromStack(argsDescriptor);
        } else {
            // È un singolo tipo, rimuovi solo quel tipo
            removeTypeFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String argsDescriptor) {
        int index = 0;
        while (index < argsDescriptor.length()) {
            char currentChar = argsDescriptor.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, trova il ';'
                int endIndex = argsDescriptor.indexOf(';', index);
                if (endIndex == -1) {
                    break;
                }
                String type = argsDescriptor.substring(index, endIndex + 1);
                removeTypeFromStack(type);
                index = endIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, trova il tipo base
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
    public void push(String type) {
        outputFrameStack.push(type);
    }

    // Metodo di esempio per ottenere lo stack (per testing)
    public Stack<String> getOutputFrameStack() {
        return outputFrameStack;
    }
}