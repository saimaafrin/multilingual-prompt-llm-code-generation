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
            // Se il descrittore è un descrittore di metodo, rimuove i tipi di argomento
            String[] parts = descriptor.split("\\)");
            if (parts.length > 1) {
                String argumentTypes = parts[0].substring(1);
                String[] types = argumentTypes.split(";");
                for (String type : types) {
                    if (!type.isEmpty()) {
                        outputFrameStack.pop();
                    }
                }
            }
        } else {
            // Se il descrittore è un tipo singolo, rimuove solo quel tipo
            outputFrameStack.pop();
        }
    }

    // Metodo di esempio per testare la funzione
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push("Type1");
        frameStack.outputFrameStack.push("Type2");
        frameStack.outputFrameStack.push("Type3");

        System.out.println("Stack prima di pop: " + frameStack.outputFrameStack);
        frameStack.pop("(Type1;Type2)V");
        System.out.println("Stack dopo pop: " + frameStack.outputFrameStack);
    }
}