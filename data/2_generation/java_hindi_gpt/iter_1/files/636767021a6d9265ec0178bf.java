import java.lang.reflect.Method;

public class Converter {

    /**
     * <p>इनपुट ऑब्जेक्ट को java.lang.Character में परिवर्तित करें।</p>
     * @param type वह डेटा प्रकार जिसमें इस मान को परिवर्तित किया जाना चाहिए।
     * @param value वह इनपुट मान जिसे परिवर्तित किया जाना है।
     * @return परिवर्तित मान।
     * @throws Exception यदि परिवर्तित करना सफलतापूर्वक नहीं किया जा सकता है
     * @since 1.8.0
     */
    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (value == null) {
            return null;
        }
        if (type == Character.class) {
            if (value instanceof String) {
                String strValue = (String) value;
                if (strValue.length() == 1) {
                    return strValue.charAt(0);
                } else {
                    throw new Exception("String must be of length 1 to convert to Character.");
                }
            } else if (value instanceof Character) {
                return value;
            } else {
                throw new Exception("Unsupported type for conversion to Character.");
            }
        }
        throw new Exception("Unsupported target type: " + type.getName());
    }
}