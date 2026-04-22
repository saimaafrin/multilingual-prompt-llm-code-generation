import java.util.Stack;

public class FrameStack {
    private Stack<String> frameStack;

    public FrameStack() {
        frameStack = new Stack<>();
    }

    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // Assuming descriptor is in the format "(Ljava/lang/String;I)V" or similar
        // We need to extract the argument types from the descriptor
        if (descriptor.startsWith("(")) {
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                return;
            }

            String argsDescriptor = descriptor.substring(1, endIndex);
            int index = 0;
            while (index < argsDescriptor.length()) {
                char ch = argsDescriptor.charAt(index);
                if (ch == 'L') {
                    // Object type, e.g., Ljava/lang/String;
                    int semicolonIndex = argsDescriptor.indexOf(';', index);
                    if (semicolonIndex == -1) {
                        break;
                    }
                    String type = argsDescriptor.substring(index, semicolonIndex + 1);
                    frameStack.pop(); // Pop the corresponding type from the stack
                    index = semicolonIndex + 1;
                } else if (ch == '[') {
                    // Array type, e.g., [I
                    frameStack.pop(); // Pop the corresponding type from the stack
                    index++;
                } else {
                    // Primitive type, e.g., I, J, F, D, etc.
                    frameStack.pop(); // Pop the corresponding type from the stack
                    index++;
                }
            }
        } else {
            // Single type descriptor, e.g., Ljava/lang/String;
            frameStack.pop(); // Pop the corresponding type from the stack
        }
    }

    public static void main(String[] args) {
        FrameStack stack = new FrameStack();
        stack.frameStack.push("Ljava/lang/String;");
        stack.frameStack.push("I");
        stack.pop("(Ljava/lang/String;I)V");
        // After popping, the stack should be empty
        System.out.println(stack.frameStack.isEmpty()); // Should print true
    }
}