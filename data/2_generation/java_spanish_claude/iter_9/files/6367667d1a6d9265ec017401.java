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
        JAVA_ESCAPES.put("\\\\", "\\");
        JAVA_ESCAPES.put("\\'", "'");
        JAVA_ESCAPES.put("\\\"", "\"");
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if (currentChar == '\\' && i + 1 < str.length()) {
                // Check for escaped sequences
                String escape = str.substring(i, Math.min(i + 2, str.length()));
                
                if (JAVA_ESCAPES.containsKey(escape)) {
                    result.append(JAVA_ESCAPES.get(escape));
                    i++; // Skip next character as it's part of escape sequence
                } else if (escape.charAt(1) == 'u' && i + 5 < str.length()) {
                    // Handle Unicode escape sequences
                    String unicode = str.substring(i + 2, i + 6);
                    try {
                        int code = Integer.parseInt(unicode, 16);
                        result.append((char) code);
                        i += 5; // Skip the unicode sequence
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid Unicode escape sequence: \\u" + unicode);
                    }
                } else {
                    // Invalid escape sequence, keep the backslash
                    result.append(currentChar);
                }
            } else {
                result.append(currentChar);
            }
        }
        
        return result.toString();
    }
}