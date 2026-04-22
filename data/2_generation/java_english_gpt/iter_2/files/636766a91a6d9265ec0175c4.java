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
        // For simplicity, let's assume a basic implementation that counts the number of argument types.
        int count = 0;
        boolean inArray = false;

        for (char c : descriptor.toCharArray()) {
            if (c == '(') {
                inArray = true;
            } else if (c == ')') {
                inArray = false;
            } else if (inArray) {
                if (c == 'I' || c == 'J' || c == 'F' || c == 'D' || c == 'Z' || c == 'C' || c == 'B' || c == 'S' || c == 'L') {
                    count++;
                    if (c == 'L') {
                        // Skip to the next semicolon for object types
                        while (c != ';') {
                            c = descriptor.charAt(++count);
                        }
                    }
                }
            }
        }
        return count;
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }
}