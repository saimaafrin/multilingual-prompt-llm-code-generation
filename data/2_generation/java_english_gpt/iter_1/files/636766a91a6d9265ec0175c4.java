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
        int count = getArgumentCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }

    private int getArgumentCount(String descriptor) {
        int count = 0;
        boolean isArray = false;
        for (int i = 0; i < descriptor.length(); i++) {
            char c = descriptor.charAt(i);
            if (c == '(') {
                continue; // Skip the opening parenthesis
            } else if (c == ')') {
                break; // Stop at the closing parenthesis
            } else if (c == 'L') {
                // Skip the class type
                while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                    i++;
                }
                count++;
            } else if (c == '[') {
                isArray = true; // Array type
            } else {
                count++; // Primitive type
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
        frameStack.pop("(Ljava/lang/Object;I)V"); // Pops 2 items
        System.out.println("Items left in stack: " + frameStack.outputFrameStack.size());
    }
}