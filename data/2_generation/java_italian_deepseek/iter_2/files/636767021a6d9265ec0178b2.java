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
            // Se il descrittore è un metodo, rimuove i tipi degli argomenti
            String[] parts = descriptor.split("\\)");
            if (parts.length > 1) {
                String argumentTypes = parts[0].substring(1);
                String[] types = argumentTypes.split(";");
                for (String type : types) {
                    if (!type.isEmpty()) {
                        outputStack.pop();
                    }
                }
            }
        } else {
            // Se il descrittore è un singolo tipo, rimuove solo quel tipo
            outputStack.pop();
        }
    }

    // Metodo di esempio per testare la funzione
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputStack.push("int");
        frameStack.outputStack.push("float");
        frameStack.outputStack.push("java/lang/String");

        frameStack.pop("(I;F;Ljava/lang/String;)V");

        System.out.println(frameStack.outputStack); // Output: []
    }
}