import org.slf4j.MDC;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class NDC {
    private static final ThreadLocal<Deque<String>> contextStack = new ThreadLocal<Deque<String>>() {
        @Override
        protected Deque<String> initialValue() {
            return new ConcurrentLinkedDeque<>();
        }
    };

    public static String peek() {
        Deque<String> stack = contextStack.get();
        if (stack != null && !stack.isEmpty()) {
            return stack.peek();
        }
        return "";
    }
}