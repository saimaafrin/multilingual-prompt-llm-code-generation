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
        // Simplified extraction of argument types from method descriptor
        // This is a basic implementation and may not cover all cases
        String arguments = methodDescriptor.substring(1, methodDescriptor.indexOf(')'));
        return arguments.split(";");
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackProcessor processor = new FrameStackProcessor();
        processor.frameStack.push("Ljava/lang/String;");
        processor.frameStack.push("I");
        processor.frameStack.push("D");

        processor.pop("(Ljava/lang/String;ID)V");

        System.out.println(processor.frameStack); // Should print: []
    }
}