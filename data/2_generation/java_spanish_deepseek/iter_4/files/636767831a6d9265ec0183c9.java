import org.apache.log4j.NDC;

public class DiagnosticContext {

    /**
     * Observa el último contexto de diagnóstico en la parte superior de este NDC sin eliminarlo. 
     * El valor devuelto es el valor que se empujó por última vez. Si no hay contexto disponible, se devuelve la cadena vacía "".
     * @return String El contexto de diagnóstico más interno.
     */
    public static String peek() {
        String context = NDC.peek();
        return context != null ? context : "";
    }
}