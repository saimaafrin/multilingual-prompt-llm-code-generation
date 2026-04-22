import java.util.Objects;

@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type == Character.class || type == char.class) {
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
                throw new Exception("String value must be exactly one character long to convert to Character.");
            }
        }
        if (value instanceof Number) {
            int intValue = ((Number) value).intValue();
            if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                return (char) intValue;
            } else {
                throw new Exception("Numeric value is out of range for Character.");
            }
        }
        throw new Exception("Cannot convert " + value.getClass().getName() + " to Character.");
    }
    throw new Exception("Conversion to " + type.getName() + " is not supported by this method.");
}