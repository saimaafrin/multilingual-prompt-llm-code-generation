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
        String argsPart = methodDescriptor.substring(1, methodDescriptor.indexOf(')'));
        return argsPart.split(";");
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackProcessor processor = new FrameStackProcessor();
        processor.frameStack.push("Type1");
        processor.frameStack.push("Type2");
        processor.frameStack.push("Type3");

        processor.pop("(Type1;Type2)V"); // Pops Type3 and Type2
        System.out.println(processor.frameStack); // Should print [Type1]
    }
}