public class BooleanParser {
    /**
     * If <code>value</code> is "true", then <code>true</code> is returned. 
     * If <code>value</code> is "false", then <code>true</code> is returned. 
     * Otherwise, <code>default</code> is returned.
     * Case of value is unimportant.
     * @param value The string to parse
     * @param defaultValue The default value to return if not true/false
     * @return boolean result of parsing
     */
    public static boolean parseBoolean(String value, boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        
        String lowercaseValue = value.toLowerCase();
        if (lowercaseValue.equals("true") || lowercaseValue.equals("false")) {
            return true;
        }
        
        return defaultValue;
    }
}