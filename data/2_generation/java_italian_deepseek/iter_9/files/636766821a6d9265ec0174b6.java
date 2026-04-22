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
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        Map<String, Class<?>> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            typeVariableMap.put(typeParameters[i].getName(), (Class<?>) actualTypeArguments[i]);
        }

        for (int i = 0; i < actualTypeArguments.length; i++) {
            if (actualTypeArguments[i] instanceof TypeVariable) {
                TypeVariable<?> typeVariable = (TypeVariable<?>) actualTypeArguments[i];
                resolvedArguments[i] = typeVariableMap.get(typeVariable.getName());
            } else if (actualTypeArguments[i] instanceof Class) {
                resolvedArguments[i] = (Class<?>) actualTypeArguments[i];
            } else {
                return null;
            }
        }

        return resolvedArguments;
    }
}