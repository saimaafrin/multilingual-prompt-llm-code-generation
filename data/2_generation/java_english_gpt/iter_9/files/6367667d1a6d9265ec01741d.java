import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /** 
     * Resolves the first bound for the  {@code typeVariable}, returning  {@code Unknown.class} if none can be resolved.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        }
        return Unknown.class;
    }

    public static class Unknown {}
}