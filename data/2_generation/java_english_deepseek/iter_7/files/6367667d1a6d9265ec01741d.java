import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * Resolves the first bound for the {@code typeVariable}, returning {@code Unknown.class} if none can be resolved.
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
        // Placeholder class to represent an unknown type
    }

    public static void main(String[] args) {
        // Example usage
        TypeVariable<?> typeVar = String.class.getTypeParameters()[0];
        Type bound = resolveBound(typeVar);
        System.out.println("Resolved bound: " + bound);
    }
}