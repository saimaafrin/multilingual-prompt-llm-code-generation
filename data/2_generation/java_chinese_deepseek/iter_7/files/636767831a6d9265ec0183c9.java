import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    public static String peek() {
        if (!contextStack.isEmpty()) {
            return contextStack.peek();
        } else {
            return "";
        }
    }

    // Example usage
    public static void main(String[] args) {
        contextStack.push("Context 1");
        contextStack.push("Context 2");
        System.out.println(peek()); // Output: Context 2
    }
}