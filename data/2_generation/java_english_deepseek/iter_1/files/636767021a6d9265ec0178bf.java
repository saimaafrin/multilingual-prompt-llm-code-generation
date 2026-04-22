import java.util.Objects;

@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type != Character.class && type != char.class) {
        throw new Exception("Conversion to Character is not supported for type: " + type.getName());
    }

    if (value == null) {
        throw new Exception("Cannot convert null value to Character.");
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
            throw new Exception("Numeric value is out of range for Character conversion.");
        }
    }

    throw new Exception("Unsupported value type for conversion to Character: " + value.getClass().getName());
}