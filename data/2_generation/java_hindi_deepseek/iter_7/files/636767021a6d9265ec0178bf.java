import java.lang.Character;

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
    if (type != Character.class && type != char.class) {
        throw new Exception("Target type must be Character or char.");
    }

    if (value == null) {
        return null;
    }

    if (value instanceof Character) {
        return value;
    }

    if (value instanceof String) {
        String strValue = (String) value;
        if (strValue.length() == 1) {
            return strValue.charAt(0);
        } else {
            throw new Exception("String value must be exactly one character long.");
        }
    }

    if (value instanceof Number) {
        int intValue = ((Number) value).intValue();
        if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
            return (char) intValue;
        } else {
            throw new Exception("Numeric value is out of range for a char.");
        }
    }

    throw new Exception("Cannot convert value to Character: " + value.getClass().getName());
}