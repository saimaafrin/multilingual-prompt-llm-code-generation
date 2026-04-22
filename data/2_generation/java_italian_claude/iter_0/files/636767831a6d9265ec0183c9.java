import org.slf4j.MDC;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class NDC {
    private static final ThreadLocal<Deque<String>> contextStack = ThreadLocal.withInitial(ConcurrentLinkedDeque::new);

    /**
     * Osserva l'ultimo contesto diagnostico in cima a questo NDC senza rimuoverlo. <p>Il valore restituito è il valore che è stato inserito per ultimo. Se non è disponibile alcun contesto, viene restituita la stringa vuota "".
     * @return String Il contesto diagnostico più interno.
     */
    public static String peek() {
        Deque<String> stack = contextStack.get();
        if (stack != null && !stack.isEmpty()) {
            return stack.peek();
        }
        return "";
    }
}