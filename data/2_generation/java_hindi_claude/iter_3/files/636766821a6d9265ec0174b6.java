import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Type[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();

        if (actualTypeArguments.length == 0 || typeParameters.length == 0) {
            return null;
        }

        Map<TypeVariable<?>, Type> typeVariableMap = new HashMap<>();
        for (int i = 0; i < typeParameters.length; i++) {
            if (i < actualTypeArguments.length) {
                typeVariableMap.put(typeParameters[i], actualTypeArguments[i]);
            }
        }

        Type[] resolvedArguments = new Type[typeParameters.length];
        for (int i = 0; i < typeParameters.length; i++) {
            Type resolvedType = typeVariableMap.get(typeParameters[i]);
            resolvedArguments[i] = resolvedType != null ? resolvedType : typeParameters[i];
        }

        return resolvedArguments;
    }
}