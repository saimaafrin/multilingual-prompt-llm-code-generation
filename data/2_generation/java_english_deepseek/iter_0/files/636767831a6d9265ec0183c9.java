import java.util.Stack;

public class NDC {
    private static Stack<String> contextStack = new Stack<>();

    public static String peek() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.peek();
    }

    // Example usage
    public static void main(String[] args) {
        contextStack.push("Context1");
        contextStack.push("Context2");
        System.out.println(peek()); // Output: Context2
    }
}