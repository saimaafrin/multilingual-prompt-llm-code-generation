import java.util.Stack;

public class FrameStackHandler {

    private Stack<String> frameStack;

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

        // Determine if the descriptor is a method descriptor
        if (descriptor.startsWith("(")) {
            // Extract argument types from method descriptor
            String[] argumentTypes = extractArgumentTypes(descriptor);
            for (String type : argumentTypes) {
                if (!frameStack.isEmpty()) {
                    frameStack.pop();
                } else {
                    throw new IllegalStateException("Frame stack is empty");
                }
            }
        } else {
            // Single type descriptor, pop one frame
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty");
            }
        }
    }

    /**
     * Extracts argument types from a method descriptor.
     * @param descriptor the method descriptor
     * @return an array of argument types
     */
    private String[] extractArgumentTypes(String descriptor) {
        // Remove the leading '(' and trailing ')'
        String args = descriptor.substring(1, descriptor.indexOf(')'));

        // Split the argument types based on the descriptor format
        // This is a simplified approach and may need to handle more complex cases
        return args.split(";");
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("Type1");
        handler.frameStack.push("Type2");
        handler.frameStack.push("Type3");

        handler.pop("(Type1;Type2)V"); // Pops Type3 and Type2
        System.out.println(handler.frameStack); // Should print [Type1]
    }
}