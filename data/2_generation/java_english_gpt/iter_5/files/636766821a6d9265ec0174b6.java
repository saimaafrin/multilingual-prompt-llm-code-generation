import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class TypeResolver {

    /** 
     * Resolves the arguments for the  {@code genericType} using the type variable information for the{@code targetType}. Returns  {@code null} if {@code genericType} is not parameterized or if arguments cannot be resolved.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type rawType = parameterizedType.getRawType();

        if (rawType instanceof Class<?>) {
            Class<?> rawClass = (Class<?>) rawType;
            Class<?>[] typeParameters = rawClass.getTypeParameters();

            if (typeParameters.length != actualTypeArguments.length) {
                return null;
            }

            Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];
            for (int i = 0; i < actualTypeArguments.length; i++) {
                resolvedArguments[i] = resolveType(actualTypeArguments[i], targetType);
            }
            return resolvedArguments;
        }

        return null;
    }

    private static Class<?> resolveType(Type type, Class<?> targetType) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        // You can test the function here with different generic types and target classes.
    }
}