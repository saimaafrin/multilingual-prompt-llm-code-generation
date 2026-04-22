import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * Resuelve el primer límite para el {@code typeVariable}, devolviendo {@code Unknown.class} si no se puede resolver ninguno.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        } else {
            return Unknown.class;
        }
    }

    // Clase ficticia para representar el tipo desconocido
    public static class Unknown {
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        TypeVariable<?> typeVar = String.class.getTypeParameters()[0];
        Type bound = resolveBound(typeVar);
        System.out.println("Bound: " + bound);
    }
}