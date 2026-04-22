import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /** 
     * {@code typeVariable} के लिए पहला बाउंड हल करता है, यदि कोई हल नहीं किया जा सकता है तो {@code Unknown.class} लौटाता है।
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        }
        return Object.class; // Return Object.class if no bounds are found
    }

    public static void main(String[] args) {
        // Example usage
        class Example<T> {
            T value;
        }

        TypeVariable<?>[] typeVariables = Example.class.getTypeParameters();
        Type resolvedType = resolveBound(typeVariables[0]);
        System.out.println("Resolved Type: " + resolvedType.getTypeName());
    }
}