import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();

        if (actualTypeArguments.length != typeParameters.length) {
            return null;
        }

        Map<TypeVariable<?>, Class<?>> typeMap = new HashMap<>();
        for (int i = 0; i < typeParameters.length; i++) {
            if (actualTypeArguments[i] instanceof Class) {
                typeMap.put(typeParameters[i], (Class<?>) actualTypeArguments[i]);
            } else {
                return null;
            }
        }

        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            resolvedArguments[i] = typeMap.get(typeParameters[i]);
        }

        return resolvedArguments;
    }
}