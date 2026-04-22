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
                count += getTypeSize(typeChar);
                index += getTypeLength(typeChar);
            }
        } else {
            // Type descriptor, count based on the type
            count = getTypeSize(descriptor.charAt(0));
        }

        // Pop the types from the stack
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Not enough elements in the stack to pop");
            }
        }
    }

    private int getTypeSize(char typeChar) {
        switch (typeChar) {
            case 'I': // int
            case 'B': // byte
            case 'C': // char
            case 'S': // short
            case 'Z': // boolean
            case 'F': // float
                return 1;
            case 'J': // long
            case 'D': // double
                return 2;
            case 'L': // object reference
                return 1; // reference types are treated as 1
            default:
                throw new IllegalArgumentException("Unknown type: " + typeChar);
        }
    }

    private int getTypeLength(char typeChar) {
        if (typeChar == 'L') {
            return 1; // Object reference type
        }
        return 1; // All other types are single character
    }
}