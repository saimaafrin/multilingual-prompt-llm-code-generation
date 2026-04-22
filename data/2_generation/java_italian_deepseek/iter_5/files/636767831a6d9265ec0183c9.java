import org.apache.log4j.NDC;

public class DiagnosticContext {

    /**
     * Osserva l'ultimo contesto diagnostico in cima a questo NDC senza rimuoverlo. 
     * Il valore restituito è il valore che è stato inserito per ultimo. 
     * Se non è disponibile alcun contesto, viene restituita la stringa vuota "".
     * @return String Il contesto diagnostico più interno.
     */
    public static String peek() {
        String context = NDC.peek();
        return context != null ? context : "";
    }
}