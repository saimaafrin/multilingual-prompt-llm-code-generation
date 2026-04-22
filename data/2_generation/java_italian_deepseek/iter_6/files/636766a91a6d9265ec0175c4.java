import java.util.Stack;

public class FrameStack {
    private Stack<String> outputStack = new Stack<>();

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
            // È un singolo tipo, rimuovi il tipo dallo stack
            removeTypesFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String descriptor) {
        int index = 0;
        while (index < descriptor.length()) {
            char currentChar = descriptor.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, trova il ';'
                int endIndex = descriptor.indexOf(';', index);
                if (endIndex == -1) {
                    break;
                }
                outputStack.pop();
                index = endIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, rimuovi un elemento dallo stack
                outputStack.pop();
                index++;
            } else {
                // Tipo primitivo, rimuovi un elemento dallo stack
                outputStack.pop();
                index++;
            }
        }
    }

    // Metodo di esempio per testare la funzionalità
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputStack.push("int");
        frameStack.outputStack.push("java/lang/String");
        frameStack.outputStack.push("[I");

        frameStack.pop("(Ljava/lang/String;[I)V");

        System.out.println(frameStack.outputStack); // Dovrebbe stampare solo "int"
    }
}