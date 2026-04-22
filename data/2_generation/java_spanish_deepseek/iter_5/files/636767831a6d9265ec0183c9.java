import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    public static String peek() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.peek();
    }

    // Additional methods to push and pop context if needed
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