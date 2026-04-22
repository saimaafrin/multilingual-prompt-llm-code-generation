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

        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        buildTypeVariableMap(targetType, typeVariableMap);

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof TypeVariable) {
                Type resolvedType = typeVariableMap.get(typeArgument);
                if (resolvedType instanceof Class) {
                    resolvedArguments[i] = (Class<?>) resolvedType;
                } else {
                    return null;
                }
            } else if (typeArgument instanceof Class) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else {
                return null;
            }
        }

        return resolvedArguments;
    }

    private static void buildTypeVariableMap(Class<?> targetType, Map<TypeVariable<?>, Type> typeVariableMap) {
        Type genericSuperclass = targetType.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            TypeVariable<?>[] typeParameters = targetType.getSuperclass().getTypeParameters();

            for (int i = 0; i < actualTypeArguments.length; i++) {
                typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
            }
        }

        for (Type genericInterface : targetType.getGenericInterfaces()) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                TypeVariable<?>[] typeParameters = ((Class<?>) parameterizedType.getRawType()).getTypeParameters();

                for (int i = 0; i < actualTypeArguments.length; i++) {
                    typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
                }
            }
        }
    }
}