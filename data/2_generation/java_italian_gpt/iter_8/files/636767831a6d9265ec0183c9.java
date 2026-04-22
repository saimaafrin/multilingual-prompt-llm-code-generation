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

    // Method to push a new context onto the stack for testing purposes
    public static void push(String context) {
        contextStack.push(context);
    }

    // Method to pop a context from the stack for testing purposes
    public static String pop() {
        return contextStack.isEmpty() ? "" : contextStack.pop();
    }

    public static void main(String[] args) {
        // Example usage
        push("Context 1");
        push("Context 2");
        System.out.println(peek()); // Should print "Context 2"
        pop();
        System.out.println(peek()); // Should print "Context 1"
        pop();
        System.out.println(peek()); // Should print ""
    }
}