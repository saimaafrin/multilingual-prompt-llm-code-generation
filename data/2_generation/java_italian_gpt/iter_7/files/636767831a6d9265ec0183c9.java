import java.util.Stack;

public class DiagnosticContext {
    private static Stack<String> contextStack = new Stack<>();

    /** 
     * Osserva l'ultimo contesto diagnostico in cima a questo NDC senza rimuoverlo. <p>Il valore restituito è il valore che è stato inserito per ultimo. Se non è disponibile alcun contesto, viene restituita la stringa vuota "".
     * @return String Il contesto diagnostico più interno.
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
}