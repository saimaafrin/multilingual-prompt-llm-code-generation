import java.util.Objects;

@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type != Character.class && type != char.class) {
        throw new Exception("Unsupported conversion to type: " + type.getName());
    }

    if (value == null) {
        return null;
    }

    if (value instanceof Character) {
        return value;
    }

    if (value instanceof Number) {
        int intValue = ((Number) value).intValue();
        if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
            return (char) intValue;
        } else {
            throw new Exception("Value out of range for Character: " + intValue);
        }
    }

    if (value instanceof String) {
        String strValue = (String) value;
        if (strValue.length() == 1) {
            return strValue.charAt(0);
        } else {
            throw new Exception("String must be exactly one character long: " + strValue);
        }
    }

    throw new Exception("Cannot convert value to Character: " + value);
}