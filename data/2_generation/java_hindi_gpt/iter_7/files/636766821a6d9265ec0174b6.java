import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class GenericTypeResolver {

    /** 
     * {@code genericType} के लिए तर्कों को {@code targetType} के प्रकार चर जानकारी का उपयोग करके हल करता है। यदि {@code genericType} पैरामीटराइज्ड नहीं है या यदि तर्कों को हल नहीं किया जा सकता है, तो {@code null} लौटाता है।
     */
    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Class<?>[] resolvedArguments = new Class[actualTypeArguments.length];

            for (int i = 0; i < actualTypeArguments.length; i++) {
                resolvedArguments[i] = resolveType(actualTypeArguments[i], targetType);
            }
            return resolvedArguments;
        }
        return null;
    }

    private static Class<?> resolveType(Type type, Class<?> targetType) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length > 0) {
                return resolveType(upperBounds[0], targetType);
            }
        }
        return null;
    }
}