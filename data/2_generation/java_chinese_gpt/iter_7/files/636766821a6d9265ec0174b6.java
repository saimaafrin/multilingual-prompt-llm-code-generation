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
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type rawType = parameterizedType.getRawType();

        if (rawType instanceof Class<?>) {
            Class<?> rawClass = (Class<?>) rawType;
            if (targetType.isAssignableFrom(rawClass)) {
                return resolveTypeArguments(actualTypeArguments, rawClass, targetType);
            }
        }
        return null;
    }

    private static Class<?>[] resolveTypeArguments(Type[] actualTypeArguments, Class<?> rawClass, Class<?> targetType) {
        Class<?>[] typeParameters = targetType.getTypeParameters();
        Class<?>[] resolvedClasses = new Class<?>[typeParameters.length];

        for (int i = 0; i < typeParameters.length; i++) {
            Type actualType = actualTypeArguments[i];
            resolvedClasses[i] = (actualType instanceof Class<?>) ? (Class<?>) actualType : null;
        }
        return resolvedClasses;
    }
}