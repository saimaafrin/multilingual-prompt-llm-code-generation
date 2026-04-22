import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

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
            if (rawClass.isAssignableFrom(targetType)) {
                Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    resolvedArguments[i] = resolveType(actualTypeArguments[i], targetType);
                }
                return resolvedArguments;
            }
        }
        return null;
    }

    private static Class<?> resolveType(Type type, Class<?> targetType) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        // You can test the resolveArguments method here with different generic types and target types.
    }
}