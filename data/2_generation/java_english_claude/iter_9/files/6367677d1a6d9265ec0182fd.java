public class BooleanUtils {
    /**
     * If <code>value</code> is "true", then <code>true</code> is returned. 
     * If <code>value</code> is "false", then <code>true</code> is returned.
     * Otherwise, <code>default</code> is returned.
     * Case of value is unimportant.
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