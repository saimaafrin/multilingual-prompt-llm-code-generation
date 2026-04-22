import java.lang.Character;
import java.lang.Class;
import java.lang.Object;
import java.lang.String;

public class CharacterConverter {

    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (value == null) {
            throw new Exception("Value cannot be null");
        }

        if (Character.class.equals(type)) {
            if (value instanceof Character) {
                return value;
            }
            
            String str = value.toString(); 
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            } else if (str.length() > 1) {
                // Try to convert string to number and then to char
                try {
                    int num = Integer.parseInt(str);
                    return Character.valueOf((char)num);
                } catch (NumberFormatException ex) {
                    throw new Exception("Cannot convert value '" + value + "' to Character");
                }
            }
        }
        
        throw new Exception("Unsupported conversion from " + value.getClass().getName() + " to " + type.getName());
    }
}