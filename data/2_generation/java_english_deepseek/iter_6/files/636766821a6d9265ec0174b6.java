import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    /**
     * Resolves the arguments for the {@code genericType} using the type variable information for the
     * {@code targetType}. Returns {@code null} if {@code genericType} is not parameterized or if
     * arguments cannot be resolved.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        Map<TypeVariable<?>, Type> typeVariableMap = getTypeVariableMap(targetType);

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof TypeVariable) {
                resolvedArguments[i] = (Class<?>) typeVariableMap.get(typeArgument);
            } else if (typeArgument instanceof Class) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else {
                return null;
            }
        }

        return resolvedArguments;
    }

    private static Map<TypeVariable<?>, Type> getTypeVariableMap(Class<?> targetType) {
        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();
        for (TypeVariable<?> typeParameter : typeParameters) {
            typeVariableMap.put(typeParameter, Object.class); // Default to Object if no specific type is found
        }
        return typeVariableMap;
    }
}