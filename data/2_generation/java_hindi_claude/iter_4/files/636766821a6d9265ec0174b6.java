import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Type[] resolveTypeArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        Map<TypeVariable<?>, Type> typeVarMap = new HashMap<>();
        ParameterizedType paramType = (ParameterizedType) genericType;

        // Get the raw type
        Class<?> rawType = (Class<?>) paramType.getRawType();
        
        // Get type parameters and arguments
        TypeVariable<?>[] typeParams = rawType.getTypeParameters();
        Type[] typeArgs = paramType.getActualTypeArguments();

        // Map type variables to actual type arguments
        for (int i = 0; i < typeParams.length; i++) {
            typeVarMap.put(typeParams[i], typeArgs[i]);
        }

        // Find target type parameters
        TypeVariable<?>[] targetParams = targetType.getTypeParameters();
        if (targetParams.length == 0) {
            return null;
        }

        // Resolve arguments for target type
        Type[] resolvedArgs = new Type[targetParams.length];
        for (int i = 0; i < targetParams.length; i++) {
            Type resolvedType = typeVarMap.get(targetParams[i]);
            if (resolvedType == null) {
                return null; // Cannot resolve all arguments
            }
            resolvedArgs[i] = resolvedType;
        }

        return resolvedArgs;
    }
}