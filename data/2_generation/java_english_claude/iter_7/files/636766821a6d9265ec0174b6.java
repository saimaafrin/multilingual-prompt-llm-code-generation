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

        // Get type variables from target type
        Map<String, Type> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeVariables = targetType.getTypeParameters();
        
        for (int i = 0; i < typeVariables.length; i++) {
            typeVariableMap.put(typeVariables[i].getName(), actualTypeArguments[i]);
        }

        // Resolve each type argument
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type actualType = actualTypeArguments[i];
            
            if (actualType instanceof Class) {
                resolvedTypes[i] = (Class<?>) actualType;
            } else if (actualType instanceof TypeVariable) {
                String variableName = ((TypeVariable<?>) actualType).getName();
                Type resolvedType = typeVariableMap.get(variableName);
                
                if (resolvedType instanceof Class) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    return null; // Cannot resolve type variable
                }
            } else {
                return null; // Cannot handle other type arguments
            }
        }

        return resolvedTypes.length > 0 ? resolvedTypes : null;
    }
}