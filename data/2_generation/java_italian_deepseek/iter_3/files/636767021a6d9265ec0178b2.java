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
            removeTypesFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String descriptor) {
        int index = 0;
        while (index < descriptor.length()) {
            char currentChar = descriptor.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, rimuovi fino al ';'
                int endIndex = descriptor.indexOf(';', index);
                if (endIndex == -1) {
                    break;
                }
                outputFrameStack.pop();
                index = endIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, rimuovi l'array
                outputFrameStack.pop();
                index++;
            } else {
                // Tipo primitivo, rimuovi il tipo
                outputFrameStack.pop();
                index++;
            }
        }
    }

    // Metodo di esempio per testare la funzionalità
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push("int");
        frameStack.outputFrameStack.push("java/lang/String;");
        frameStack.outputFrameStack.push("[I");

        frameStack.pop("(ILjava/lang/String;[I)V");

        System.out.println(frameStack.outputFrameStack); // Dovrebbe essere vuoto
    }
}