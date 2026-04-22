import org.slf4j.MDC;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class NDC {
    private static final ThreadLocal<Deque<String>> contextStack = ThreadLocal.withInitial(ConcurrentLinkedDeque::new);

    /**
     * Looks at the last diagnostic context at the top of this NDC without removing it.
     * The returned value is the value that was pushed last. If no context is available,
     * then the empty string "" is returned.
     * 
     * @return String The innermost diagnostic context.
     */
    public static String peek() {
        Deque<String> stack = contextStack.get();
        if (stack != null && !stack.isEmpty()) {
            return stack.peek();
        }
        return "";
    }
}