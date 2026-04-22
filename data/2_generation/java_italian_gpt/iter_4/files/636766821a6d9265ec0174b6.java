import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeResolver {

    /** 
     * Risolve gli argomenti per il {@code genericType} utilizzando le informazioni sulle variabili di tipo per il {@code targetType}. Restituisce {@code null} se {@code genericType} non è parametrizzato o se gli argomenti non possono essere risolti.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type rawType = parameterizedType.getRawType();

        if (rawType instanceof Class<?>) {
            Class<?> rawClass = (Class<?>) rawType;
            if (targetType.isAssignableFrom(rawClass)) {
                return resolveFromTargetType(actualTypeArguments, targetType);
            }
        }
        return null;
    }

    private static Class<?>[] resolveFromTargetType(Type[] actualTypeArguments, Class<?> targetType) {
        Class<?>[] resolvedClasses = new Class<?>[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof Class<?>) {
                resolvedClasses[i] = (Class<?>) typeArgument;
            } else {
                // Handle other types like ParameterizedType or WildcardType if necessary
                resolvedClasses[i] = Object.class; // Fallback for unresolved types
            }
        }
        return resolvedClasses;
    }
}