import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class TypeResolver {

    /** 
     * Resolves the arguments for the  {@code genericType} using the type variable information for the{@code targetType}. Returns  {@code null} if {@code genericType} is not parameterized or if arguments cannot be resolved.
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
            Class<?>[] typeArguments = new Class[actualTypeArguments.length];

            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type arg = actualTypeArguments[i];
                if (arg instanceof Class<?>) {
                    typeArguments[i] = (Class<?>) arg;
                } else {
                    return null; // Cannot resolve non-class type arguments
                }
            }

            return typeArguments;
        }

        return null; // Not a class type
    }

    public static void main(String[] args) {
        // Example usage
        Class<?>[] resolvedArgs = resolveArguments(new ParameterizedTypeImpl(), MyClass.class);
        System.out.println(Arrays.toString(resolvedArgs));
    }
}

// Dummy class for demonstration
class MyClass<T, U> {}

// Dummy implementation of ParameterizedType for demonstration
class ParameterizedTypeImpl implements ParameterizedType {
    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{String.class, Integer.class};
    }

    @Override
    public Type getRawType() {
        return MyClass.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}