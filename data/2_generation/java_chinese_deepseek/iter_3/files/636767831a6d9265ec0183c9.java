import java.util.Stack;

public class NDC {
    private static Stack<String> contextStack = new Stack<>();

    public static String peek() {
        if (!contextStack.isEmpty()) {
            return contextStack.peek();
        } else {
            return "";
        }
    }
}