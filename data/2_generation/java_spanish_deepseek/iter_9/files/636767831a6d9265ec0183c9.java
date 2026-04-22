import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    public static String peek() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.peek();
    }
}