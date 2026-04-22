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
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        int count = getArgumentCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Not enough elements in the stack to pop");
            }
        }
    }

    private int getArgumentCount(String descriptor) {
        // This method assumes a simple descriptor parsing logic.
        // For example, it could be a method descriptor like "(II)V" where "I" represents an integer.
        int count = 0;
        boolean inArgumentList = false;

        for (char c : descriptor.toCharArray()) {
            if (c == '(') {
                inArgumentList = true;
            } else if (c == ')') {
                inArgumentList = false;
                break;
            } else if (inArgumentList) {
                count++;
            }
        }
        return count;
    }

    // Method to simulate pushing elements onto the stack for testing purposes
    public void push(Object obj) {
        outputFrameStack.push(obj);
    }

    // Main method for testing
    public static void main(String[] args) {
        AbstractTypePoper poper = new AbstractTypePoper();
        poper.push(new Object());
        poper.push(new Object());
        poper.push(new Object());

        // Example usage
        poper.pop("(II)V"); // This should pop 2 elements from the stack
        System.out.println("Popped successfully.");
    }
}