import java.util.Stack;

public class NDC {
    private static Stack<String> diagnosticContexts = new Stack<>();

    /**
     * Looks at the last diagnostic context at the top of this NDC without removing it. 
     * <p>The returned value is the value that was pushed last. If no context is available, 
     * then the empty string "" is returned.
     * @return String The innermost diagnostic context.
     */
    public static String peek() {
        if (diagnosticContexts.isEmpty()) {
            return "";
        }
        return diagnosticContexts.peek();
    }
}