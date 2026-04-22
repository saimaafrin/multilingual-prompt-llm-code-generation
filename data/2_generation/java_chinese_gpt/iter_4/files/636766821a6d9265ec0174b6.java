import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeResolver {

    /**
     * 使用 {@code targetType} 的类型变量信息解析 {@code genericType} 的参数。如果 {@code genericType} 不是参数化的，或者无法解析参数，则返回 {@code null}。
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type rawType = parameterizedType.getRawType();

        if (rawType instanceof Class<?>) {
            Class<?> rawClass = (Class<?>) rawType;
            if (targetType.isAssignableFrom(rawClass)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];

                for (int i = 0; i < actualTypeArguments.length; i++) {
                    resolvedArguments[i] = (actualTypeArguments[i] instanceof Class<?>) 
                        ? (Class<?>) actualTypeArguments[i] 
                        : null; // Handle non-class types as needed
                }
                return resolvedArguments;
            }
        }
        return null;
    }
}