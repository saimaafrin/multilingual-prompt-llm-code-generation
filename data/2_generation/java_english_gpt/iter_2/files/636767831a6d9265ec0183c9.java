import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    /** 
     * Looks at the last diagnostic context at the top of this NDC without removing it. 
     * The returned value is the value that was pushed last. If no context is available, 
     * then the empty string "" is returned.
     * @return String The innermost diagnostic context.
     */
    public static String peek() {
        return contextStack.isEmpty() ? "" : contextStack.peek();
    }

    // Method to push a new context onto the stack
    public static void push(String context) {
        contextStack.push(context);
    }

    // Method to pop the top context from the stack
    public static String pop() {
        return contextStack.isEmpty() ? "" : contextStack.pop();
    }
}