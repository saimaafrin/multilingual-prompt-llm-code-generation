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
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        int count = 0;
        boolean isMethodDescriptor = descriptor.startsWith("(");
        
        if (isMethodDescriptor) {
            // Method descriptor, count argument types
            int index = 1; // Start after '('
            while (descriptor.charAt(index) != ')') {
                count++;
                index = getNextTypeIndex(descriptor, index);
            }
        } else {
            // Type descriptor, count single type
            count = 1;
        }

        // Pop the types from the stack
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Not enough items in the stack to pop");
            }
        }
    }

    private int getNextTypeIndex(String descriptor, int startIndex) {
        char c = descriptor.charAt(startIndex);
        if (c == 'L') {
            // Object type, find the next ';'
            return descriptor.indexOf(';', startIndex) + 1;
        } else if (c == '[') {
            // Array type, just move to the next character
            return startIndex + 1;
        } else {
            // Primitive type, just move to the next character
            return startIndex + 1;
        }
    }

    // Method to simulate pushing items onto the stack for testing
    public void push(Object item) {
        outputFrameStack.push(item);
    }
}