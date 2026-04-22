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
            Class<?>[] typeArguments = new Class[actualTypeArguments.length];

            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type arg = actualTypeArguments[i];
                if (arg instanceof Class<?>) {
                    typeArguments[i] = (Class<?>) arg;
                } else {
                    return null; // Cannot resolve non-class type arguments
                }
            }

            return typeArguments;
        }

        return null; // Not a class type
    }

    public static void main(String[] args) {
        // Example usage
        Class<?>[] resolvedArgs = resolveArguments(new ParameterizedTypeImpl(List.class, new Type[]{String.class}), List.class);
        System.out.println(Arrays.toString(resolvedArgs)); // Output: [class java.lang.String]
    }
}

// A simple implementation of ParameterizedType for demonstration purposes
class ParameterizedTypeImpl implements ParameterizedType {
    private final Class<?> raw;
    private final Type[] actualTypeArguments;

    public ParameterizedTypeImpl(Class<?> raw, Type[] actualTypeArguments) {
        this.raw = raw;
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}