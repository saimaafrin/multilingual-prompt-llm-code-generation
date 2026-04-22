import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    /**
     * Resuelve los argumentos para el {@code genericType} utilizando la información de las variables de tipo para el {@code targetType}. Devuelve {@code null} si {@code genericType} no está parametrizado o si no se pueden resolver los argumentos.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        Map<String, Class<?>> typeVariableMap = createTypeVariableMap(targetType);

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof Class) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else if (typeArgument instanceof TypeVariable) {
                TypeVariable<?> typeVariable = (TypeVariable<?>) typeArgument;
                resolvedArguments[i] = typeVariableMap.get(typeVariable.getName());
            } else {
                return null;
            }
        }

        return resolvedArguments;
    }

    private static Map<String, Class<?>> createTypeVariableMap(Class<?> targetType) {
        Map<String, Class<?>> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();

        for (TypeVariable<?> typeParameter : typeParameters) {
            typeVariableMap.put(typeParameter.getName(), Object.class); // Default to Object if no specific type is found
        }

        return typeVariableMap;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Type genericType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class, Integer.class };
            }

            @Override
            public Type getRawType() {
                return Map.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };

        Class<?> targetType = Map.class;
        Class<?>[] resolvedArguments = resolveArguments(genericType, targetType);

        if (resolvedArguments != null) {
            for (Class<?> arg : resolvedArguments) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No se pudieron resolver los argumentos.");
        }
    }
}