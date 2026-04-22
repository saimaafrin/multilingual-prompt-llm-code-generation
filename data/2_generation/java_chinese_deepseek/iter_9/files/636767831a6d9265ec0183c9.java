import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    /**
     * 查看此 NDC 顶部的最后诊断上下文，而不将其移除。<p>返回的值是最后推入的值。如果没有可用的上下文，则返回空字符串 ""。
     * @return String 最内层的诊断上下文。
     */
    public static String peek() {
        if (contextStack.isEmpty()) {
            return "";
        }
        return contextStack.peek();
    }

    // 示例用法
    public static void main(String[] args) {
        contextStack.push("Context 1");
        contextStack.push("Context 2");
        System.out.println(peek()); // 输出: Context 2
    }
}