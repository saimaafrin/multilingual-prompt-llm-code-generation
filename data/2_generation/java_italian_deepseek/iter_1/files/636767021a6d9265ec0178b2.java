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
                char c = argsDescriptor.charAt(index);
                if (c == 'L') {
                    // Tipo oggetto, trova il ';'
                    int end = argsDescriptor.indexOf(';', index);
                    if (end == -1) {
                        return; // Descrittore non valido
                    }
                    index = end + 1;
                } else if (c == '[') {
                    // Tipo array, salta al prossimo carattere
                    index++;
                } else {
                    // Tipo primitivo
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

    // Metodo di esempio per testare la funzione pop
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push("int");
        frameStack.outputFrameStack.push("java.lang.String");
        frameStack.outputFrameStack.push("double");

        System.out.println("Stack prima di pop: " + frameStack.outputFrameStack);
        frameStack.pop("(ILjava/lang/String;D)V");
        System.out.println("Stack dopo pop: " + frameStack.outputFrameStack);
    }
}