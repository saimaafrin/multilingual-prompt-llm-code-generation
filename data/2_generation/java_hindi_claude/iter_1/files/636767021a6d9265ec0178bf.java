import java.math.BigDecimal;
import java.math.BigInteger;

public class TypeConverter {

    public Character convertToCharacter(Class<?> type, Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Character) {
            return (Character) value;
        }

        if (value instanceof String) {
            String str = (String) value;
            if (str.length() == 1) {
                return str.charAt(0);
            }
            throw new Exception("Cannot convert String with length > 1 to Character");
        }

        if (value instanceof Number) {
            int intValue;
            if (value instanceof BigDecimal) {
                intValue = ((BigDecimal) value).intValue();
            } else if (value instanceof BigInteger) {
                intValue = ((BigInteger) value).intValue();
            } else {
                intValue = ((Number) value).intValue();
            }
            return (char) intValue;
        }

        if (value instanceof Boolean) {
            return ((Boolean) value) ? '1' : '0';
        }

        throw new Exception("Cannot convert " + value.getClass().getName() + " to Character");
    }
}