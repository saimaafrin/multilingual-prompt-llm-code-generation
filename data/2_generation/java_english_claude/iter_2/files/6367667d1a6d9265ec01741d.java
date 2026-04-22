import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.lang.reflect.ParameterizedType;

public class TypeResolver {

    private static final Class<?> UNKNOWN = Unknown.class;

    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        
        if (bounds == null || bounds.length == 0) {
            return UNKNOWN;
        }

        Type bound = bounds[0];
        if (bound == Object.class) {
            return UNKNOWN;
        }

        return bound;
    }

    private static class Unknown {
        private Unknown() {}
    }
}