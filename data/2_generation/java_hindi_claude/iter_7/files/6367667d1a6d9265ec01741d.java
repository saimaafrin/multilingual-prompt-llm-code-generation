import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {
    /**
     * Resolves the first bound for the typeVariable, returning Unknown.class if none can be resolved.
     * @param typeVariable The type variable to resolve bounds for
     * @return The first bound type, or Unknown.class if no bounds exist
     */
    public static Class<?> resolveFirstBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        
        if (bounds == null || bounds.length == 0) {
            return Unknown.class;
        }

        if (bounds[0] instanceof Class) {
            return (Class<?>) bounds[0];
        }

        return Unknown.class;
    }
}

// Helper class representing unknown type
class Unknown {
    private Unknown() {} // Prevent instantiation
}