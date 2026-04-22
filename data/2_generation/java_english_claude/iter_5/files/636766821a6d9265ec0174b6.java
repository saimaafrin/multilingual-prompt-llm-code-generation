import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
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

        // Create type variable mapping
        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();
        
        for (int i = 0; i < typeParameters.length && i < actualTypeArguments.length; i++) {
            typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
        }

        // Resolve each type argument
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type actualType = actualTypeArguments[i];
            
            if (actualType instanceof Class) {
                resolvedTypes[i] = (Class<?>) actualType;
            } else if (actualType instanceof TypeVariable) {
                Type resolvedType = typeVariableMap.get(actualType);
                if (resolvedType instanceof Class) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    return null; // Cannot resolve type variable
                }
            } else {
                return null; // Cannot handle other type arguments
            }
        }

        // Check if all arguments were resolved
        if (Arrays.stream(resolvedTypes).anyMatch(type -> type == null)) {
            return null;
        }

        return resolvedTypes;
    }
}