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

        for (Type typeArgument : actualTypeArguments) {
            if (typeArgument instanceof Class) {
                resolvedTypes.add((Class<?>) typeArgument);
            } else {
                // Handle other cases like TypeVariable, WildcardType, etc.
                // For simplicity, we return null if any type argument is not a Class.
                return null;
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Type genericType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class, Integer.class };
            }

            @Override
            public Type getRawType() {
                return List.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };

        Class<?>[] resolvedArgs = resolveArguments(genericType, List.class);
        if (resolvedArgs != null) {
            for (Class<?> clazz : resolvedArgs) {
                System.out.println(clazz.getSimpleName());
            }
        } else {
            System.out.println("Unable to resolve type arguments.");
        }
    }
}