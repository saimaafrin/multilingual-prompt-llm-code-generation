import java.util.Deque;
import java.util.ArrayDeque;

public class NDC {
    private static final ThreadLocal<Deque<String>> contextStack = new ThreadLocal<Deque<String>>() {
        @Override 
        protected Deque<String> initialValue() {
            return new ArrayDeque<String>();
        }
    };

    public static String peek() {
        Deque<String> stack = contextStack.get();
        if (stack.isEmpty()) {
            return "";
        }
        return stack.peek();
    }
}