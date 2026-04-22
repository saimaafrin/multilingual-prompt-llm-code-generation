import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeResolver {

    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type rawType = parameterizedType.getRawType();

        if (!rawType.equals(targetType)) {
            return null;
        }

        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArgument : typeArguments) {
            if (typeArgument instanceof Class) {
                resolvedTypes.add((Class<?>) typeArgument);
            } else {
                // If the type argument is not a Class, we cannot resolve it
                return null;
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Type exampleType = new ParameterizedType() {
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

        Class<?>[] resolvedArgs = resolveArguments(exampleType, List.class);
        if (resolvedArgs != null) {
            for (Class<?> arg : resolvedArgs) {
                System.out.println(arg.getSimpleName());
            }
        } else {
            System.out.println("Could not resolve arguments.");
        }
    }
}