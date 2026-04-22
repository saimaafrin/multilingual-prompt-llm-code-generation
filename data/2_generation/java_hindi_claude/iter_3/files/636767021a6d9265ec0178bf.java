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
            int intValue = ((Number) value).intValue();
            if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                return (char) intValue;
            }
            throw new Exception("Number out of range for Character conversion");
        }

        if (value instanceof Boolean) {
            return ((Boolean) value) ? '1' : '0';
        }

        throw new Exception("Cannot convert " + value.getClass().getName() + " to Character");
    }
}