public class BooleanUtils {
    /**
     * Se <code>value</code> è "true", viene restituito <code>true</code>. 
     * Se <code>value</code> è "false", viene restituito <code>false</code>. 
     * Altrimenti, viene restituito <code>default</code>.
     * Non importa se <code>value</code> è maiuscolo o minuscolo.
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        
        String trimmedValue = value.trim().toLowerCase();
        
        if (trimmedValue.equals("true")) {
            return true;
        }
        
        if (trimmedValue.equals("false")) {
            return false;
        }
        
        return dEfault;
    }
}