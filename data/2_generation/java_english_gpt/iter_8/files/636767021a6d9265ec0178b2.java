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
        int count = getTypeCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // This method should parse the descriptor and return the number of types to pop.
        // For simplicity, let's assume the descriptor is a simple string where:
        // - "I" represents an int (1)
        // - "J" represents a long (2)
        // - "F" represents a float (1)
        // - "D" represents a double (2)
        // - "V" represents void (0)
        // - "L" represents an object reference (1)
        // - Method descriptors will be handled separately.

        int count = 0;
        for (char c : descriptor.toCharArray()) {
            switch (c) {
                case 'I':
                case 'F':
                case 'L':
                    count += 1;
                    break;
                case 'J':
                case 'D':
                    count += 2;
                    break;
                case 'V':
                    break; // void does not count
                default:
                    throw new IllegalArgumentException("Unknown type in descriptor: " + c);
            }
        }
        return count;
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push(new Object());
        frameStack.push(new Object());
        frameStack.push(new Object());
        
        // Example usage
        frameStack.pop("I"); // Pops 1 item
        frameStack.pop("JJ"); // Pops 2 items (for long)
    }
}