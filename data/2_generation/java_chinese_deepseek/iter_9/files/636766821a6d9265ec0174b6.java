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
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArg : actualTypeArguments) {
            if (typeArg instanceof Class) {
                resolvedTypes.add((Class<?>) typeArg);
            } else if (typeArg instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) typeArg).getRawType();
                if (rawType instanceof Class) {
                    resolvedTypes.add((Class<?>) rawType);
                } else {
                    resolvedTypes.add(null);
                }
            } else {
                resolvedTypes.add(null);
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
    }

    public static void main(String[] args) {
        // Example usage
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

        Class<?>[] resolvedArgs = resolveArguments(genericType, List.class);
        if (resolvedArgs != null) {
            for (Class<?> arg : resolvedArgs) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No arguments resolved.");
        }
    }
}