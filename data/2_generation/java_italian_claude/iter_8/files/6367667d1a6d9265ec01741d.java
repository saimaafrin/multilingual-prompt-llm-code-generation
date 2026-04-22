import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.lang.reflect.ParameterizedType;

public class TypeResolver {

    /**
     * Risolve il primo vincolo per il {@code typeVariable}, restituendo {@code Unknown.class} se non può essere risolto.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        
        if (bounds == null || bounds.length == 0) {
            return Unknown.class;
        }
        
        Type bound = bounds[0];
        
        if (bound instanceof TypeVariable) {
            return resolveBound((TypeVariable<?>) bound);
        }
        
        if (bound instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) bound).getUpperBounds();
            if (upperBounds != null && upperBounds.length > 0) {
                return upperBounds[0];
            }
        }
        
        if (bound instanceof ParameterizedType) {
            return ((ParameterizedType) bound).getRawType();
        }
        
        return bound;
    }
    
    private static class Unknown {
        // Marker class for unknown type
    }
}