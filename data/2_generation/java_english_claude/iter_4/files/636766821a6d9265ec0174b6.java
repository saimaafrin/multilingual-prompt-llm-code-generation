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
        
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type actualType = actualTypeArguments[i];
            
            if (actualType instanceof Class) {
                resolvedTypes[i] = (Class<?>) actualType;
            } else if (actualType instanceof TypeVariable) {
                String variableName = ((TypeVariable<?>) actualType).getName();
                
                // Try to find matching type variable in target type
                for (int j = 0; j < typeVariables.length; j++) {
                    if (typeVariables[j].getName().equals(variableName)) {
                        // Get bounds of type variable
                        Type[] bounds = typeVariables[j].getBounds();
                        if (bounds != null && bounds.length > 0 && bounds[0] instanceof Class) {
                            resolvedTypes[i] = (Class<?>) bounds[0];
                        }
                        break;
                    }
                }
                
                if (resolvedTypes[i] == null) {
                    // Could not resolve type variable
                    return null;
                }
            } else {
                // Cannot resolve other types
                return null;
            }
        }

        return resolvedTypes;
    }
}