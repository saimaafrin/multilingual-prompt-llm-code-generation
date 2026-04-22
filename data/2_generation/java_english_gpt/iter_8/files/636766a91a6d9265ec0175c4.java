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
            } else {
                throw new IllegalStateException("Not enough elements in the stack to pop.");
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // This method should parse the descriptor and return the number of types to pop.
        // For simplicity, let's assume a basic implementation where:
        // - "I" = 1 (int)
        // - "J" = 2 (long)
        // - "F" = 1 (float)
        // - "D" = 2 (double)
        // - "L" = 1 (object reference)
        // - "V" = 0 (void)
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
        frameStack.push(1); // int
        frameStack.push(2.0); // double
        frameStack.push("Hello"); // String

        // Pop types based on descriptor
        frameStack.pop("ID"); // Pops an int and a double
    }
}