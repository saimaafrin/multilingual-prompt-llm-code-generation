import java.util.Stack;

public class NDC {
    private static Stack<String> contextStack = new Stack<>();

    /**
     * Looks at the last diagnostic context at the top of this NDC without removing it. <p>The returned value is the value that was pushed last. If no context is available, then the empty string "" is returned.
     * @return String The innermost diagnostic context.
     */
    public static String peek() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.peek();
    }

    // Additional methods to push and pop contexts if needed
    public static void push(String context) {
        contextStack.push(context);
    }

    public static String pop() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.pop();
    }
}