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

        // Assuming descriptor is a method descriptor like "(Ljava/lang/String;I)V"
        // We need to extract the argument types from the descriptor
        String[] argumentTypes = extractArgumentTypes(descriptor);

        // Pop the types from the stack
        for (String type : argumentTypes) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            }
        }
    }

    private String[] extractArgumentTypes(String descriptor) {
        // This is a simplified version of extracting argument types from a method descriptor
        // For a full implementation, you would need to parse the descriptor properly
        // Here we assume the descriptor is in the format "(<arg1><arg2>...)"

        if (descriptor.charAt(0) != '(') {
            return new String[0];
        }

        int endIndex = descriptor.indexOf(')');
        if (endIndex == -1) {
            return new String[0];
        }

        String args = descriptor.substring(1, endIndex);
        return args.split(";");
    }

    public static void main(String[] args) {
        FrameStack stack = new FrameStack();
        stack.pop("(Ljava/lang/String;I)V");
    }
}