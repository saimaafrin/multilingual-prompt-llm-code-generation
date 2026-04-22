import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeResolver {

    /** 
     * Resuelve los argumentos para el {@code genericType} utilizando la información de las variables de tipo para el {@code targetType}. Devuelve {@code null} si {@code genericType} no está parametrizado o si no se pueden resolver los argumentos.
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
                    resolvedArguments[i] = (Class<?>) actualTypeArguments[i];
                }
                return resolvedArguments;
            }
        }
        return null;
    }
}