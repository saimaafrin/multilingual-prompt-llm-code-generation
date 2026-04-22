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
            Type type = actualTypeArguments[i];
            
            if (type instanceof Class) {
                resolvedTypes[i] = (Class<?>) type;
            } 
            else if (type instanceof TypeVariable) {
                Type resolvedType = typeVariableMap.get(((TypeVariable<?>) type).getName());
                if (resolvedType instanceof Class) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    return null; // Cannot resolve type variable
                }
            } 
            else {
                return null; // Cannot handle other type arguments
            }
        }

        return resolvedTypes;
    }
}