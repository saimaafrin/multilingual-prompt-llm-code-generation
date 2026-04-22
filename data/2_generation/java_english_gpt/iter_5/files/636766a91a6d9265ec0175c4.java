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
                char typeChar = descriptor.charAt(index);
                count++;
                if (typeChar == 'L') {
                    // Skip to the end of the object type
                    index = descriptor.indexOf(';', index) + 1;
                } else {
                    // Move to the next type
                    index++;
                }
            }
        } else {
            // Type descriptor, count types
            for (char c : descriptor.toCharArray()) {
                if (c == 'L') {
                    count++;
                    // Skip to the end of the object type
                    while (c != ';') {
                        c = descriptor.charAt(++count);
                    }
                } else {
                    count++;
                }
            }
        }

        // Pop the types from the stack
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Not enough items in the output frame stack to pop");
            }
        }
    }

    // Method to push items onto the stack for testing purposes
    public void push(Object item) {
        outputFrameStack.push(item);
    }

    // Method to get the current size of the stack for testing purposes
    public int size() {
        return outputFrameStack.size();
    }
}