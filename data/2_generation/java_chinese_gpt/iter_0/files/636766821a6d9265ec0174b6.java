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
            if (rawClass.equals(targetType)) {
                return (Class<?>[]) parameterizedType.getActualTypeArguments();
            }

            Type superType = rawClass.getGenericSuperclass();
            if (superType != null) {
                Class<?>[] resolvedArguments = resolveArguments(superType, targetType);
                if (resolvedArguments != null) {
                    return resolvedArguments;
                }
            }

            Type[] interfaces = rawClass.getGenericInterfaces();
            for (Type iface : interfaces) {
                Class<?>[] resolvedArguments = resolveArguments(iface, targetType);
                if (resolvedArguments != null) {
                    return resolvedArguments;
                }
            }
        }

        return null;
    }
}