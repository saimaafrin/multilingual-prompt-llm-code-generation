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

    // Método para agregar contexto para pruebas
    public static void push(String context) {
        contextStack.push(context);
    }

    // Método para eliminar contexto para pruebas
    public static String pop() {
        return contextStack.isEmpty() ? "" : contextStack.pop();
    }

    public static void main(String[] args) {
        push("Contexto 1");
        push("Contexto 2");
        System.out.println(peek()); // Debería imprimir "Contexto 2"
        pop();
        System.out.println(peek()); // Debería imprimir "Contexto 1"
        pop();
        System.out.println(peek()); // Debería imprimir ""
    }
}