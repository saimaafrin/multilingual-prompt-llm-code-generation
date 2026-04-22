import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class GenericTypeResolver {

    /** 
     * {@code genericType} के लिए तर्कों को {@code targetType} के प्रकार चर जानकारी का उपयोग करके हल करता है। यदि {@code genericType} पैरामीटराइज्ड नहीं है या यदि तर्कों को हल नहीं किया जा सकता है, तो {@code null} लौटाता है।
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type rawType = parameterizedType.getRawType();

        if (!rawType.equals(targetType)) {
            return null;
        }

        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];

        for (int i = 0; i < actualTypeArguments.length; i++) {
            resolvedArguments[i] = resolveType(actualTypeArguments[i]);
        }

        return resolvedArguments;
    }

    private static Class<?> resolveType(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else if (type instanceof WildcardType) {
            return resolveType(((WildcardType) type).getUpperBounds()[0]);
        }
        return null;
    }
}