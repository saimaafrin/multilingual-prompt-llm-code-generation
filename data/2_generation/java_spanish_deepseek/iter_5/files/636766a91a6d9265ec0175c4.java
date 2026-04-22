import java.util.Stack;

public class FrameStackProcessor {

    private Stack<String> frameStack;

    public FrameStackProcessor() {
        this.frameStack = new Stack<>();
    }

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
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
            // Single type descriptor
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty");
            }
        }
    }

    private String[] extractArgumentTypes(String methodDescriptor) {
        // Remove the leading '(' and trailing ')'
        String argsPart = methodDescriptor.substring(1, methodDescriptor.indexOf(')'));
        // Split the argument types based on the descriptor format
        // This is a simplified approach and may need to handle complex types like arrays and objects
        return argsPart.split("(?<=\\D)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackProcessor processor = new FrameStackProcessor();
        processor.frameStack.push("int");
        processor.frameStack.push("float");
        processor.frameStack.push("java/lang/String");

        processor.pop("(IFLjava/lang/String;)V"); // Pops 3 elements from the stack
    }
}