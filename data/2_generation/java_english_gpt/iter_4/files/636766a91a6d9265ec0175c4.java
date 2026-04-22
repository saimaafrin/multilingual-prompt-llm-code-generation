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
                throw new IllegalStateException("Output frame stack is empty.");
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // This method should parse the descriptor and return the number of types to pop.
        // For simplicity, let's assume a basic implementation that counts the number of argument types.
        int count = 0;
        boolean inArray = false;
        for (char c : descriptor.toCharArray()) {
            if (c == '(') {
                inArray = true; // Start of method arguments
            } else if (c == ')') {
                inArray = false; // End of method arguments
            } else if (inArray) {
                if (c == 'L') {
                    // Skip to the next semicolon for object types
                    while (c != ';') {
                        c = descriptor.charAt(++count);
                    }
                    count++; // Count the semicolon
                } else {
                    count++; // Count primitive types
                }
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
        frameStack.pop("(Ljava/lang/String;I)V"); // Pops 2 items from the stack
    }
}