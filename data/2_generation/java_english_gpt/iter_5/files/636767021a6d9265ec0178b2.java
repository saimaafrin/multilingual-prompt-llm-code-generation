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
        boolean isMethodDescriptor = descriptor.charAt(0) == '(';

        if (isMethodDescriptor) {
            // Method descriptor, count argument types
            int index = 1; // Start after '('
            while (descriptor.charAt(index) != ')') {
                count += getArgumentSize(descriptor.charAt(index));
                index++;
            }
        } else {
            // Type descriptor
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

    private int getArgumentSize(char type) {
        switch (type) {
            case 'I': // int
            case 'B': // byte
            case 'C': // char
            case 'S': // short
            case 'Z': // boolean
                return 1;
            case 'J': // long
            case 'D': // double
                return 2;
            case 'L': // object reference
                return 1; // reference types are treated as 1
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    private int getTypeSize(char type) {
        switch (type) {
            case 'I': // int
            case 'B': // byte
            case 'C': // char
            case 'S': // short
            case 'Z': // boolean
            case 'L': // object reference
                return 1;
            case 'J': // long
            case 'D': // double
                return 2;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}