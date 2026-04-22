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
        int count = getTypeCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Output frame stack is empty.");
            }
        }
    }

    private int getTypeCountFromDescriptor(String descriptor) {
        // This is a simplified version of type counting based on the descriptor.
        // In a real implementation, you would need to parse the descriptor properly.
        if (descriptor.startsWith("(")) {
            // Method descriptor, count argument types
            return (descriptor.split(";").length - 1);
        } else {
            // Single type descriptor
            return 1;
        }
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }

    public static void main(String[] args) {
        AbstractTypePoper poper = new AbstractTypePoper();
        poper.push(new Object());
        poper.push(new Object());
        poper.push(new Object());

        // Example usage
        poper.pop("(Ljava/lang/String;)V"); // Pops 1 item
        System.out.println("Popped from stack.");
    }
}