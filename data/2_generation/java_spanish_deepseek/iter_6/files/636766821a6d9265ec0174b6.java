import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof Class<?>) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else if (typeArgument instanceof ParameterizedType) {
                resolvedArguments[i] = (Class<?>) ((ParameterizedType) typeArgument).getRawType();
            } else {
                // If the type argument is not a Class or ParameterizedType, we cannot resolve it
                return null;
            }
        }

        // Check if the resolved arguments match the target type's type parameters
        Map<Type, Class<?>> typeVariableMap = new HashMap<>();
        Type[] targetTypeParameters = targetType.getTypeParameters();
        if (targetTypeParameters.length != resolvedArguments.length) {
            return null;
        }

        for (int i = 0; i < targetTypeParameters.length; i++) {
            typeVariableMap.put(targetTypeParameters[i], resolvedArguments[i]);
        }

        return resolvedArguments;
    }
}