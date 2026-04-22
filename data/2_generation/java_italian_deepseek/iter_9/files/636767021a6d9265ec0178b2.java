import java.util.Stack;

public class FrameStackHandler {
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
                return; // Descrittore non valido
            }

            String argsDescriptor = descriptor.substring(1, endOfArgs);
            int index = 0;
            while (index < argsDescriptor.length()) {
                char currentChar = argsDescriptor.charAt(index);
                if (currentChar == 'L') {
                    // Tipo oggetto, trova il ';'
                    int endOfObject = argsDescriptor.indexOf(';', index);
                    if (endOfObject == -1) {
                        return; // Descrittore non valido
                    }
                    index = endOfObject + 1;
                } else if (currentChar == '[') {
                    // Tipo array, salta il '[' e continua
                    index++;
                } else {
                    // Tipo primitivo (B, C, D, F, I, J, S, Z)
                    index++;
                }

                if (!outputFrameStack.isEmpty()) {
                    outputFrameStack.pop();
                }
            }
        } else {
            // È un tipo singolo, rimuovi un elemento dallo stack
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }

    // Metodo di esempio per testare la funzione
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.outputFrameStack.push("int");
        handler.outputFrameStack.push("float");
        handler.outputFrameStack.push("java/lang/Object");

        handler.pop("(I)V"); // Rimuove un int dallo stack
        System.out.println(handler.outputFrameStack); // Output: [int, float]

        handler.pop("Ljava/lang/Object;"); // Rimuove un Object dallo stack
        System.out.println(handler.outputFrameStack); // Output: [int]
    }
}