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
        } else {
            return Unknown.class;
        }
    }

    public static class Unknown {
        // Placeholder class to represent an unknown type
    }

    public static void main(String[] args) {
        // Example usage
        TypeVariable<?> typeVar = new TypeVariable<Object>() {
            @Override
            public Type[] getBounds() {
                return new Type[]{String.class};
            }

            @Override
            public String getName() {
                return "T";
            }

            @Override
            public java.lang.reflect.GenericDeclaration getGenericDeclaration() {
                return Object.class;
            }
        };

        Type resolvedType = resolveBound(typeVar);
        System.out.println("Resolved Type: " + resolvedType);
    }
}