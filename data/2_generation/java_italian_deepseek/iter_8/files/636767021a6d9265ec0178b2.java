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
            // È un descrittore di metodo, rimuovi i tipi degli argomenti
            int endOfArgs = descriptor.indexOf(')');
            if (endOfArgs == -1) {
                return; // Descrittore non valido
            }

            String argsDescriptor = descriptor.substring(1, endOfArgs);
            int index = 0;
            while (index < argsDescriptor.length()) {
                char currentChar = argsDescriptor.charAt(index);
                if (currentChar == 'L') {
                    // Tipo oggetto, rimuovi fino al ';'
                    int endOfObject = argsDescriptor.indexOf(';', index);
                    if (endOfObject == -1) {
                        return; // Descrittore non valido
                    }
                    outputFrameStack.pop(); // Rimuovi il tipo oggetto dallo stack
                    index = endOfObject + 1;
                } else if (currentChar == '[') {
                    // Tipo array, rimuovi il tipo base
                    outputFrameStack.pop(); // Rimuovi il tipo array dallo stack
                    index++;
                } else {
                    // Tipo primitivo, rimuovi direttamente
                    outputFrameStack.pop(); // Rimuovi il tipo primitivo dallo stack
                    index++;
                }
            }
        } else {
            // È un tipo singolo, rimuovi direttamente
            outputFrameStack.pop(); // Rimuovi il tipo dallo stack
        }
    }
}