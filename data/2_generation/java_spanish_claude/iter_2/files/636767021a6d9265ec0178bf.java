import java.lang.Character;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;

public class CharacterConverter {

    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Character) {
            return value;
        }

        if (value instanceof String) {
            String str = (String) value;
            if (str.length() == 0) {
                throw new Exception("Cannot convert empty String to Character");
            }
            return Character.valueOf(str.charAt(0));
        }

        if (value instanceof Number) {
            int intValue = ((Number) value).intValue();
            return Character.valueOf((char) intValue);
        }

        throw new Exception("Cannot convert value of type " + value.getClass().getName() + " to Character");
    }
}