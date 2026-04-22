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

        Type firstBound = bounds[0];
        if (firstBound instanceof Class) {
            return (Class<?>) firstBound;
        }
        
        return Unknown.class;
    }
    
    // Unknown class used as default return value
    private static class Unknown {
    }
}