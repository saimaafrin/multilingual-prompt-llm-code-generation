import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    private static final Map<String, String> JAVA_ESCAPES;
    
    static {
        JAVA_ESCAPES = new HashMap<>();
        JAVA_ESCAPES.put("\\t", "\t");
        JAVA_ESCAPES.put("\\b", "\b");
        JAVA_ESCAPES.put("\\n", "\n");
        JAVA_ESCAPES.put("\\r", "\r");
        JAVA_ESCAPES.put("\\f", "\f");
        JAVA_ESCAPES.put("\\'", "'");
        JAVA_ESCAPES.put("\\\"", "\"");
        JAVA_ESCAPES.put("\\\\", "\\");
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if (currentChar == '\\' && i + 1 < str.length()) {
                // Check for escaped sequence
                String escape = str.substring(i, i + 2);
                if (JAVA_ESCAPES.containsKey(escape)) {
                    result.append(JAVA_ESCAPES.get(escape));
                    i++; // Skip next character as it's part of escape sequence
                } else if (i + 3 < str.length() && 
                         str.charAt(i + 1) == 'u') {
                    // Handle unicode escape sequences
                    String hex = str.substring(i + 2, i + 6);
                    try {
                        result.append((char) Integer.parseInt(hex, 16));
                        i += 5; // Skip the unicode sequence
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid unicode escape sequence: \\u" + hex);
                    }
                } else {
                    // Not a recognized escape sequence, keep the backslash
                    result.append(currentChar);
                }
            } else {
                result.append(currentChar);
            }
        }
        
        return result.toString();
    }
}