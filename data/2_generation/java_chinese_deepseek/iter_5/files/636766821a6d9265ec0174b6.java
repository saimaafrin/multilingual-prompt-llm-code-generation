import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeResolver {

    /**
     * 使用 {@code targetType} 的类型变量信息解析 {@code genericType} 的参数。如果 {@code genericType} 不是参数化的，或者无法解析参数，则返回 {@code null}。
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArg : actualTypeArguments) {
            if (typeArg instanceof Class) {
                resolvedTypes.add((Class<?>) typeArg);
            } else if (typeArg instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) typeArg).getRawType();
                if (rawType instanceof Class) {
                    resolvedTypes.add((Class<?>) rawType);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
    }
}