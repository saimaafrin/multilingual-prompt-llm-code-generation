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
        int count = getCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // This is a simplified version of counting types based on the descriptor.
        // In a real implementation, you would need to parse the descriptor properly.
        int count = 0;
        for (char c : descriptor.toCharArray()) {
            if (c == 'I' || c == 'J' || c == 'F' || c == 'D' || c == 'Z' || c == 'C' || c == 'B' || c == 'S' || c == 'L') {
                count++;
            } else if (c == '(') {
                // Start of method descriptor, count arguments
                while (c != ')') {
                    c = descriptor.charAt(++count);
                    if (c == 'I' || c == 'J' || c == 'F' || c == 'D' || c == 'Z' || c == 'C' || c == 'B' || c == 'S' || c == 'L') {
                        count++;
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