import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
                    // Handle other types like TypeVariable or Wildcard
                    return null;
                }
            }

            return typeArguments;
        }

        return null;
    }
}