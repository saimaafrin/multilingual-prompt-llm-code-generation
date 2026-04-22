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
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type rawType = parameterizedType.getRawType();

        if (rawType instanceof Class<?>) {
            Class<?> rawClass = (Class<?>) rawType;
            if (rawClass.isAssignableFrom(targetType)) {
                return Arrays.stream(actualTypeArguments)
                        .map(arg -> {
                            if (arg instanceof Class<?>) {
                                return (Class<?>) arg;
                            } else if (arg instanceof ParameterizedType) {
                                return (Class<?>) ((ParameterizedType) arg).getRawType();
                            }
                            return null;
                        })
                        .toArray(Class<?>[]::new);
            }
        }
        return null;
    }
}