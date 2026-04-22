import org.slf4j.MDC;
import java.util.Deque;
import java.util.ArrayDeque;

public class DiagnosticContext {
    
    private static final ThreadLocal<Deque<String>> contextStack = ThreadLocal.withInitial(ArrayDeque::new);
    
    /**
     * Observa el último contexto de diagnóstico en la parte superior de este NDC sin eliminarlo. <p>
     * El valor devuelto es el valor que se empujó por última vez. Si no hay contexto disponible, se devuelve la cadena vacía "".
     * @return String El contexto de diagnóstico más interno.
     */
    public static String peek() {
        Deque<String> stack = contextStack.get();
        if (stack.isEmpty()) {
            return "";
        }
        return stack.peek();
    }
}