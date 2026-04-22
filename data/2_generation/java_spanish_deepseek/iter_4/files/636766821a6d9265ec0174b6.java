import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArg : actualTypeArguments) {
            if (typeArg instanceof Class) {
                resolvedTypes.add((Class<?>) typeArg);
            } else {
                // Si el tipo no es una clase, no podemos resolverlo directamente
                return null;
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
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
                return List.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };

        Class<?> targetType = List.class;
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