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
                return null; // No se puede resolver el argumento
            }
        }

        return resolvedArguments;
    }
}