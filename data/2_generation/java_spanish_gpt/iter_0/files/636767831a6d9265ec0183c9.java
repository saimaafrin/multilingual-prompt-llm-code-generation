import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    /**
     * Observa el último contexto de diagnóstico en la parte superior de este NDC sin eliminarlo. 
     * El valor devuelto es el valor que se empujó por última vez. 
     * Si no hay contexto disponible, se devuelve la cadena vacía "".
     * @return String El contexto de diagnóstico más interno.
     */
    public static String peek() {
        return contextStack.isEmpty() ? "" : contextStack.peek();
    }

    // Método para empujar un nuevo contexto al stack
    public static void push(String context) {
        contextStack.push(context);
    }

    // Método para eliminar el contexto más interno
    public static String pop() {
        return contextStack.isEmpty() ? "" : contextStack.pop();
    }
}