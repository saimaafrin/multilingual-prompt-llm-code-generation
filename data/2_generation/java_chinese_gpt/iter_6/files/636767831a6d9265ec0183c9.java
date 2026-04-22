import java.util.Stack;

public class NDC {
    private static Stack<String> contextStack = new Stack<>();

    /**
     * 查看此 NDC 顶部的最后诊断上下文，而不将其移除。<p>返回的值是最后推入的值。如果没有可用的上下文，则返回空字符串 ""。
     * @return String 最内层的诊断上下文。
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

    public static void main(String[] args) {
        // Example usage
        push("Context 1");
        push("Context 2");
        System.out.println(peek()); // Output: Context 2
        pop();
        System.out.println(peek()); // Output: Context 1
        pop();
        System.out.println(peek()); // Output: (empty string)
    }
}