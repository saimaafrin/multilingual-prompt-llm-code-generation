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

        // Determine if the descriptor is a method descriptor or a type descriptor
        if (descriptor.startsWith("(")) {
            // Method descriptor, pop argument types
            int index = 1; // Start after '('
            while (descriptor.charAt(index) != ')') {
                char typeChar = descriptor.charAt(index);
                int size = getTypeSize(typeChar);
                for (int i = 0; i < size; i++) {
                    if (!outputFrameStack.isEmpty()) {
                        outputFrameStack.pop();
                    }
                }
                index += (typeChar == 'L') ? descriptor.indexOf(';', index) - index + 1 : 1;
            }
        } else {
            // Type descriptor, pop single type
            int size = getTypeSize(descriptor.charAt(0));
            for (int i = 0; i < size; i++) {
                if (!outputFrameStack.isEmpty()) {
                    outputFrameStack.pop();
                }
            }
        }
    }

    private int getTypeSize(char typeChar) {
        switch (typeChar) {
            case 'Z': // boolean
            case 'B': // byte
            case 'C': // char
            case 'S': // short
            case 'I': // int
                return 1;
            case 'J': // long
            case 'D': // double
                return 2;
            case 'L': // reference type
                return 1;
            default:
                throw new IllegalArgumentException("Unknown type: " + typeChar);
        }
    }
}