import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class GenericTypeResolver {

    /** 
     * Risolve gli argomenti per il {@code genericType} utilizzando le informazioni sulle variabili di tipo per il {@code targetType}. Restituisce {@code null} se {@code genericType} non è parametrizzato o se gli argomenti non possono essere risolti.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type rawType = parameterizedType.getRawType();

        if (!targetType.isAssignableFrom((Class<?>) rawType)) {
            return null;
        }

        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type argument = actualTypeArguments[i];
            if (argument instanceof Class) {
                resolvedArguments[i] = (Class<?>) argument;
            } else if (argument instanceof ParameterizedType) {
                resolvedArguments[i] = (Class<?>) ((ParameterizedType) argument).getRawType();
            } else {
                return null; // Cannot resolve the type
            }
        }

        return resolvedArguments;
    }

    public static void main(String[] args) {
        // Example usage
        // Assuming you have a class with generics to test the method
    }
}