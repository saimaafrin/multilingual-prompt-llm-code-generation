import java.util.Stack;

public class AbstractTypePoper {
    private Stack<Object> outputFrameStack;

    public AbstractTypePoper() {
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
            } else {
                throw new IllegalStateException("Output frame stack is empty.");
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // This is a simplified version of counting types based on the descriptor.
        // In a real implementation, you would parse the descriptor string properly.
        if (descriptor.startsWith("(")) {
            // Method descriptor, count argument types
            int count = 0;
            for (char c : descriptor.toCharArray()) {
                if (c == ',') {
                    count++;
                }
            }
            return count + 1; // +1 for the last argument
        } else {
            // Type descriptor, count as one
            return 1;
        }
    }

    // Method to simulate pushing to the stack for testing purposes
    public void push(Object obj) {
        outputFrameStack.push(obj);
    }

    // Main method for testing
    public static void main(String[] args) {
        AbstractTypePoper poper = new AbstractTypePoper();
        poper.push(new Object());
        poper.push(new Object());
        poper.push(new Object());

        // Pop types based on a method descriptor
        poper.pop("(II)V"); // This should pop 2 items
        System.out.println("Popped successfully.");
    }
}