import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrameStack;

    public FrameStack() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * Pops as many abstract types from the output frame stack as described by the given descriptor.
     * @param descriptor a type or method descriptor (in which case its argument types are popped).
     */
    private void pop(final String descriptor) {
        int count = getCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // This is a simplified version of counting based on the descriptor.
        // In a real implementation, you would parse the descriptor string properly.
        if (descriptor.startsWith("(")) {
            // Method descriptor, count argument types
            int count = 0;
            for (char c : descriptor.toCharArray()) {
                if (c == ')') break;
                if (c == 'L') {
                    // Object type, count as 1
                    count++;
                    while (c != ';') c++; // Skip to the end of the object type
                } else if (c == 'I' || c == 'Z' || c == 'F' || c == 'D' || c == 'J') {
                    // Primitive types, count as 1
                    count++;
                }
            }
            return count;
        } else {
            // Type descriptor, count as 1
            return 1; // Simplified assumption for single type descriptors
        }
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }
}