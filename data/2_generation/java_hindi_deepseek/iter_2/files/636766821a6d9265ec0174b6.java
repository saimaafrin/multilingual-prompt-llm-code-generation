import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeResolver {

    /**
     * {@code genericType} के लिए तर्कों को {@code targetType} के प्रकार चर जानकारी का उपयोग करके हल करता है। यदि {@code genericType} पैरामीटराइज्ड नहीं है या यदि तर्कों को हल नहीं किया जा सकता है, तो {@code null} लौटाता है।
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArgument : typeArguments) {
            if (typeArgument instanceof Class<?>) {
                resolvedTypes.add((Class<?>) typeArgument);
            } else {
                // Handle cases where typeArgument is a TypeVariable or other types
                // For simplicity, we return null if any type argument is not a Class
                return null;
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

        Class<?> targetType = List.class;
        Class<?>[] resolvedArgs = resolveArguments(genericType, targetType);

        if (resolvedArgs != null) {
            for (Class<?> arg : resolvedArgs) {
                System.out.println(arg.getSimpleName());
            }
        } else {
            System.out.println("Could not resolve arguments.");
        }
    }
}