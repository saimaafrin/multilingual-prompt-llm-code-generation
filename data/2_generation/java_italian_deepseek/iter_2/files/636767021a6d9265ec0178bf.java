import java.util.Objects;

@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type == Character.class || type == char.class) {
        if (value == null) {
            throw new Exception("Cannot convert null to Character.");
        }
        if (value instanceof Character) {
            return value;
        }
        if (value instanceof String) {
            String strValue = (String) value;
            if (strValue.length() == 1) {
                return strValue.charAt(0);
            } else {
                throw new Exception("String must be exactly one character long to convert to Character.");
            }
        }
        if (value instanceof Number) {
            int intValue = ((Number) value).intValue();
            if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                return (char) intValue;
            } else {
                throw new Exception("Number is out of range for Character conversion.");
            }
        }
        throw new Exception("Unsupported type for Character conversion: " + value.getClass().getName());
    }
    throw new Exception("Conversion to type " + type.getName() + " is not supported.");
}