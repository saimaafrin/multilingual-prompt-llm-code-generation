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
            // It's a method descriptor, extract argument types
            String[] parts = descriptor.split("\\)");
            if (parts.length < 1) {
                return;
            }
            String argumentTypes = parts[0].substring(1); // Remove the opening '('
            String[] types = argumentTypes.split(";");

            for (String type : types) {
                if (!type.isEmpty()) {
                    if (type.startsWith("L")) {
                        // It's an object type, remove the 'L' and the trailing ';'
                        type = type.substring(1);
                    }
                    if (!outputFrameStack.isEmpty() && outputFrameStack.peek().equals(type)) {
                        outputFrameStack.pop();
                    }
                }
            }
        } else {
            // It's a single type descriptor
            if (!outputFrameStack.isEmpty() && outputFrameStack.peek().equals(descriptor)) {
                outputFrameStack.pop();
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputFrameStack.push("java/lang/String");
        frameStack.outputFrameStack.push("I");
        frameStack.outputFrameStack.push("J");

        frameStack.pop("(Ljava/lang/String;IJ)V");

        System.out.println(frameStack.outputFrameStack); // Should print: []
    }
}