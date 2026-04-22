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
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        List<Class<?>> resolvedTypes = new ArrayList<>();

        for (Type typeArg : actualTypeArguments) {
            if (typeArg instanceof Class<?>) {
                resolvedTypes.add((Class<?>) typeArg);
            } else if (typeArg instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) typeArg).getRawType();
                if (rawType instanceof Class<?>) {
                    resolvedTypes.add((Class<?>) rawType);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }

        return resolvedTypes.toArray(new Class<?>[0]);
    }
}