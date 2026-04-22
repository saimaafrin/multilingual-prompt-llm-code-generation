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
        
        // Build mapping of type variables to actual types
        for (int i = 0; i < actualTypeArguments.length && i < typeParameters.length; i++) {
            if (actualTypeArguments[i] instanceof Class) {
                resolvedTypes[i] = (Class<?>) actualTypeArguments[i];
            } else if (actualTypeArguments[i] instanceof TypeVariable) {
                TypeVariable<?> typeVar = (TypeVariable<?>) actualTypeArguments[i];
                Type resolvedType = typeVariableMap.get(typeVar);
                if (resolvedType instanceof Class) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    // Cannot resolve type variable
                    return null;
                }
            } else {
                // Cannot resolve type argument
                return null;
            }
        }

        return resolvedTypes;
    }
}