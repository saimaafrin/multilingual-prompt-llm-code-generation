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
        Class<?>[] resolvedTypes = new Class<?>[actualTypeArguments.length];

        // Map to store type variable mappings
        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        
        // Get type variables from target type
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();
        
        // Map type variables to actual types
        for (int i = 0; i < actualTypeArguments.length && i < typeParameters.length; i++) {
            if (actualTypeArguments[i] instanceof Class) {
                resolvedTypes[i] = (Class<?>) actualTypeArguments[i];
                typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
            } else if (actualTypeArguments[i] instanceof TypeVariable) {
                Type resolvedType = typeVariableMap.get(actualTypeArguments[i]);
                if (resolvedType instanceof Class) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    return null; // Cannot resolve type variable
                }
            } else {
                return null; // Unsupported type argument
            }
        }

        return resolvedTypes;
    }
}