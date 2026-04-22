public class StackManipulator {
    
    private Stack<Object> outputFrameStack = new Stack<>();

    /** 
     * Pops as many abstract types from the output frame stack as described by the given descriptor.
     * @param descriptor a type or method descriptor (in which case its argument types are popped).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        // Determine the number of types to pop based on the descriptor
        int count = getArgumentCount(descriptor);
        
        // Pop the specified number of types from the stack
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }

    private int getArgumentCount(String descriptor) {
        // This method should parse the descriptor and return the number of arguments
        // For simplicity, let's assume a basic implementation that counts commas
        int count = 0;
        boolean inArray = false;
        for (char c : descriptor.toCharArray()) {
            if (c == '[') {
                inArray = true;
            } else if (c == ']') {
                inArray = false;
            } else if (c == '(' && !inArray) {
                // Start of method arguments
                count = 0; // Reset count for method arguments
            } else if (c == ',' && !inArray) {
                count++;
            } else if (c == ')') {
                count++; // Include the last argument
                break;
            }
        }
        return count;
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }
}