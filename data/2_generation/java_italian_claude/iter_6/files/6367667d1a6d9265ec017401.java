import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    private static final Map<String, String> JAVA_ESCAPES = new HashMap<>();
    static {
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
            char ch = str.charAt(i);
            
            if (ch == '\\') {
                // Check if we have enough characters left for an escape sequence
                if (i + 1 >= str.length()) {
                    throw new Exception("Invalid escape sequence - string ends with \\");
                }
                
                // Get the escape sequence (backslash + next char)
                String escape = str.substring(i, i + 2);
                
                // Check if it's a valid Java escape sequence
                String unescaped = JAVA_ESCAPES.get(escape);
                if (unescaped != null) {
                    result.append(unescaped);
                    i++; // Skip the next character since we've handled it
                } else {
                    // Handle octal escapes
                    if (Character.isDigit(str.charAt(i + 1))) {
                        int end = Math.min(i + 4, str.length());
                        String octal = str.substring(i + 1, end);
                        int len = 1;
                        while (len < octal.length() && Character.isDigit(octal.charAt(len))) {
                            len++;
                        }
                        octal = octal.substring(0, len);
                        result.append((char) Integer.parseInt(octal, 8));
                        i += len;
                    } else {
                        throw new Exception("Invalid escape sequence: " + escape);
                    }
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}