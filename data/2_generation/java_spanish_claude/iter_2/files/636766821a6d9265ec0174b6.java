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

        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        buildTypeVariableMap(targetType, genericType, typeVariableMap);

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type actualType = actualTypeArguments[i];
            
            if (actualType instanceof Class<?>) {
                resolvedTypes[i] = (Class<?>) actualType;
            } else if (actualType instanceof TypeVariable) {
                Type resolvedType = typeVariableMap.get(actualType);
                if (resolvedType instanceof Class<?>) {
                    resolvedTypes[i] = (Class<?>) resolvedType;
                } else {
                    return null; // Cannot resolve type variable
                }
            } else {
                return null; // Cannot handle other type scenarios
            }
        }

        return resolvedTypes;
    }

    private static void buildTypeVariableMap(Class<?> targetType, Type genericType, Map<TypeVariable<?>, Type> typeVariableMap) {
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            TypeVariable<?>[] typeParameters = ((Class<?>) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

            for (int i = 0; i < typeParameters.length; i++) {
                typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
            }

            if (targetType.getSuperclass() != null) {
                buildTypeVariableMap(targetType.getSuperclass(), targetType.getGenericSuperclass(), typeVariableMap);
            }
            
            Type[] genericInterfaces = targetType.getGenericInterfaces();
            Class<?>[] interfaces = targetType.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                buildTypeVariableMap(interfaces[i], genericInterfaces[i], typeVariableMap);
            }
        }
    }
}