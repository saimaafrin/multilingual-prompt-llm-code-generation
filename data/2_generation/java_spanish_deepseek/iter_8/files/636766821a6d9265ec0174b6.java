import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    /**
     * Resuelve los argumentos para el {@code genericType} utilizando la información de las variables de tipo para el {@code targetType}. 
     * Devuelve {@code null} si {@code genericType} no está parametrizado o si no se pueden resolver los argumentos.
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof Class) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else {
                // Si el tipo no es una clase, no podemos resolverlo directamente
                return null;
            }
        }

        return resolvedArguments;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Type genericType = new HashMap<String, Integer>() {}.getClass().getGenericSuperclass();
        Class<?> targetType = HashMap.class;
        Class<?>[] resolvedArgs = resolveArguments(genericType, targetType);

        if (resolvedArgs != null) {
            for (Class<?> arg : resolvedArgs) {
                System.out.println(arg.getSimpleName());
            }
        } else {
            System.out.println("No se pudieron resolver los argumentos.");
        }
    }
}