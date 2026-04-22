import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    public void push(String type) {
        stack.push(type);
    }

    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // Determine if the descriptor is a method descriptor
        if (descriptor.startsWith("(")) {
            // Extract argument types from method descriptor
            String[] parts = descriptor.split("\\)");
            if (parts.length < 1) {
                return;
            }
            String argsDescriptor = parts[0].substring(1);
            int index = 0;
            while (index < argsDescriptor.length()) {
                char c = argsDescriptor.charAt(index);
                if (c == 'L') {
                    // Object type
                    int end = argsDescriptor.indexOf(';', index);
                    if (end == -1) {
                        break;
                    }
                    stack.pop(); // Pop the object type
                    index = end + 1;
                } else if (c == '[') {
                    // Array type
                    stack.pop(); // Pop the array type
                    index++;
                } else {
                    // Primitive type
                    stack.pop(); // Pop the primitive type
                    index++;
                }
            }
        } else {
            // Single type descriptor
            stack.pop(); // Pop the type
        }
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push("int");
        frameStack.push("java.lang.String");
        frameStack.push("[D");

        frameStack.pop("(ILjava/lang/String;[D)V");

        // The stack should now be empty
        System.out.println("Stack is empty: " + frameStack.stack.isEmpty());
    }
}