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

        // Determine the number of types to pop based on the descriptor
        int typesToPop = 0;
        if (descriptor.startsWith("(")) {
            // Method descriptor: count the number of argument types
            typesToPop = countArgumentTypes(descriptor);
        } else {
            // Type descriptor: pop one type
            typesToPop = 1;
        }

        // Pop the required number of types from the stack
        for (int i = 0; i < typesToPop; i++) {
            if (frameStack.isEmpty()) {
                throw new IllegalStateException("Frame stack is empty");
            }
            frameStack.pop();
        }
    }

    /**
     * Counts the number of argument types in a method descriptor.
     * @param descriptor the method descriptor
     * @return the number of argument types
     */
    private int countArgumentTypes(String descriptor) {
        int count = 0;
        int index = 1; // Start after the opening '('
        while (descriptor.charAt(index) != ')') {
            char c = descriptor.charAt(index);
            if (c == 'L') {
                // Skip over the class name
                index = descriptor.indexOf(';', index) + 1;
            } else if (c == '[') {
                // Skip over array dimensions
                while (descriptor.charAt(index) == '[') {
                    index++;
                }
                if (descriptor.charAt(index) == 'L') {
                    index = descriptor.indexOf(';', index) + 1;
                } else {
                    index++;
                }
            } else {
                // Primitive type
                index++;
            }
            count++;
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackProcessor processor = new FrameStackProcessor();
        processor.frameStack.push("int");
        processor.frameStack.push("java.lang.String");
        processor.frameStack.push("double");

        processor.pop("(Ljava/lang/String;D)I");

        System.out.println("Frame stack after pop: " + processor.frameStack);
    }
}