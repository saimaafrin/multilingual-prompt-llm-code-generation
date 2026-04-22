import java.util.Objects;

public class CharacterConverter {

    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (Character.class.equals(type)) {
            if (value instanceof Character) {
                return value;
            }

            final String str = value.toString();
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }

            if (str.length() == 0) {
                throw new Exception("Cannot convert empty string to Character");
            }

            throw new Exception("Cannot convert string with length > 1 to Character: " + str);
        }

        throw new Exception("Target type " + type.getName() + " is not supported");
    }
}