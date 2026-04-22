import java.lang.Character;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;

public class CharacterConverter {

    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (value == null) {
            throw new Exception("Value to convert cannot be null");
        }

        if (Character.class.equals(type)) {
            // Handle String input
            if (value instanceof String) {
                String str = (String) value;
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new Exception("String must have length of 1 to convert to Character");
            }
            
            // Handle character input
            if (value instanceof Character) {
                return value;
            }
            
            // Handle numeric input
            if (value instanceof Number) {
                int iValue = ((Number)value).intValue();
                return Character.valueOf((char)iValue);
            }

            throw new Exception("Cannot convert value of type " + value.getClass().getName() + " to Character");
        }

        throw new Exception("Target type must be Character");
    }
}