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
        // This is a simplified version, assuming the descriptor is well-formed
        int start = methodDescriptor.indexOf('(') + 1;
        int end = methodDescriptor.indexOf(')');
        String args = methodDescriptor.substring(start, end);
        return args.split(";");
    }

    // For testing purposes
    public static void main(String[] args) {
        FrameStackProcessor processor = new FrameStackProcessor();
        processor.frameStack.push("Type1");
        processor.frameStack.push("Type2");
        processor.frameStack.push("Type3");

        processor.pop("(Type1;Type2)V"); // Pops Type1 and Type2
        System.out.println(processor.frameStack); // Should print [Type3]
    }
}