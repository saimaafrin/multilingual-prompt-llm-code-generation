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

    public static class Unknown {
        // Clase vacía para representar un tipo desconocido
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        TypeVariable<?> typeVariable = ExampleClass.class.getTypeParameters()[0];
        Type bound = resolveBound(typeVariable);
        System.out.println("Bound: " + bound);
    }

    class ExampleClass<T> {
        // Clase de ejemplo con un parámetro de tipo
    }
}