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
        Type rawType = parameterizedType.getRawType();

        if (!targetType.isAssignableFrom((Class<?>) rawType)) {
            return null;
        }

        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type arg = actualTypeArguments[i];
            if (arg instanceof Class) {
                resolvedArguments[i] = (Class<?>) arg;
            } else if (arg instanceof ParameterizedType) {
                resolvedArguments[i] = (Class<?>) ((ParameterizedType) arg).getRawType();
            } else {
                return null; // Cannot resolve the type
            }
        }

        return resolvedArguments;
    }

    public static void main(String[] args) {
        // Example usage
        Class<?>[] resolved = resolveArguments(new ParameterizedTypeImpl(List.class, new Type[]{String.class}), List.class);
        System.out.println(Arrays.toString(resolved)); // Should print [class java.lang.String]
    }
}

// Helper class to create a ParameterizedType for testing
class ParameterizedTypeImpl implements ParameterizedType {
    private final Class<?> raw;
    private final Type[] actualTypeArguments;

    public ParameterizedTypeImpl(Class<?> raw, Type[] actualTypeArguments) {
        this.raw = raw;
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}