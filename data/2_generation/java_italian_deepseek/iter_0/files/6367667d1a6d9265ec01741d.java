import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * Risolve il primo vincolo per il {@code typeVariable}, restituendo {@code Unknown.class} se non può essere risolto.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        } else {
            return Unknown.class;
        }
    }

    // Classe fittizia per rappresentare un tipo sconosciuto
    public static class Unknown {
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        TypeVariable<?> typeVariable = String.class.getTypeParameters()[0];
        Type resolvedType = resolveBound(typeVariable);
        System.out.println("Resolved Type: " + resolvedType);
    }
}