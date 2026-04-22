import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /** 
     * Resuelve el primer límite para el {@code typeVariable},devolviendo {@code Unknown.class} si no se puede resolver ninguno.
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