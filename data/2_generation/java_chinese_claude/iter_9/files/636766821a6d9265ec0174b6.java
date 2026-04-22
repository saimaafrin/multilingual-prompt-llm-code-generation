import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericType;
            Type[] actualTypeArgs = paramType.getActualTypeArguments();
            Class<?>[] result = new Class<?>[actualTypeArgs.length];

            // Create type variable mapping
            Map<TypeVariable<?>, Type> typeVarMap = new HashMap<>();
            TypeVariable<?>[] typeParams = targetType.getTypeParameters();
            for (int i = 0; i < typeParams.length; i++) {
                if (i < actualTypeArgs.length) {
                    typeVarMap.put(typeParams[i], actualTypeArgs[i]);
                }
            }

            // Resolve actual types
            for (int i = 0; i < actualTypeArgs.length; i++) {
                Type actualType = actualTypeArgs[i];
                if (actualType instanceof Class<?>) {
                    result[i] = (Class<?>) actualType;
                } else if (actualType instanceof TypeVariable<?>) {
                    Type resolvedType = typeVarMap.get(actualType);
                    if (resolvedType instanceof Class<?>) {
                        result[i] = (Class<?>) resolvedType;
                    } else {
                        return null; // Cannot resolve type variable
                    }
                } else {
                    return null; // Cannot handle other type scenarios
                }
            }
            return result;
        }
        return null; // Not a parameterized type
    }
}