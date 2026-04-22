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
        // This is a simplified version of type counting based on the descriptor.
        // In a real implementation, you would parse the descriptor string properly.
        int count = 0;
        for (char c : descriptor.toCharArray()) {
            if (c == '(') {
                // Start of method parameters
                continue;
            } else if (c == ')') {
                // End of method parameters
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public void push(Object obj) {
        outputFrameStack.push(obj);
    }

    public static void main(String[] args) {
        AbstractTypePoper poper = new AbstractTypePoper();
        poper.push(new Object());
        poper.push(new Object());
        poper.push(new Object());
        
        // Example usage
        poper.pop("(II)V"); // Pops 2 objects from the stack
    }
}