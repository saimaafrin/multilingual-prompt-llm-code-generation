import java.util.Stack;

public class FrameStackHandler {

    private Stack<Object> frameStack;

    public FrameStackHandler() {
        this.frameStack = new Stack<>();
    }

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        // Determine the number of arguments based on the descriptor
        int argumentCount = 0;
        if (descriptor.startsWith("(")) {
            // Method descriptor: count the number of arguments
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Invalid method descriptor");
            }
            String args = descriptor.substring(1, endIndex);
            argumentCount = countArguments(args);
        } else {
            // Single type descriptor: treat as one argument
            argumentCount = 1;
        }

        // Pop the required number of elements from the stack
        for (int i = 0; i < argumentCount; i++) {
            if (frameStack.isEmpty()) {
                throw new IllegalStateException("Frame stack is empty");
            }
            frameStack.pop();
        }
    }

    /**
     * Counts the number of arguments in a method descriptor's argument list.
     * @param args the argument part of the method descriptor
     * @return the number of arguments
     */
    private int countArguments(String args) {
        int count = 0;
        int i = 0;
        while (i < args.length()) {
            char c = args.charAt(i);
            if (c == 'L') {
                // Object type: skip until ';'
                int end = args.indexOf(';', i);
                if (end == -1) {
                    throw new IllegalArgumentException("Invalid object type in descriptor");
                }
                i = end + 1;
            } else if (c == '[') {
                // Array type: skip the array brackets
                i++;
            } else {
                // Primitive type: move to the next character
                i++;
            }
            count++;
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("arg1");
        handler.frameStack.push("arg2");
        handler.frameStack.push("arg3");

        handler.pop("(Ljava/lang/String;I)V"); // Pops 2 arguments
        System.out.println(handler.frameStack); // Should print [arg1]
    }
}