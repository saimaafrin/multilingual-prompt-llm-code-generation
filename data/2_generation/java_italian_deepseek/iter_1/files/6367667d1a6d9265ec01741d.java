import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * Risolve il primo vincolo per il {@code typeVariable}, restituendo {@code Unknown.class} se non può essere risolto.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        if (typeVariable == null) {
            return Unknown.class;
        }

        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            return Unknown.class;
        }

        // Restituisce il primo bound disponibile
        return bounds[0];
    }

    // Classe fittizia per rappresentare un tipo sconosciuto
    public static class Unknown {}
}