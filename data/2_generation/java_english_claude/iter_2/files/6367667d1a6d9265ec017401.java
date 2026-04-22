import java.util.HashMap;
import java.util.Map;

public class StringEscapeUtils {

    private static final Map<String, String> UNESCAPE_JAVA_MAP = new HashMap<>();
    static {
        UNESCAPE_JAVA_MAP.put("\\t", "\t");
        UNESCAPE_JAVA_MAP.put("\\b", "\b");
        UNESCAPE_JAVA_MAP.put("\\n", "\n");
        UNESCAPE_JAVA_MAP.put("\\r", "\r");
        UNESCAPE_JAVA_MAP.put("\\f", "\f");
        UNESCAPE_JAVA_MAP.put("\\'", "'");
        UNESCAPE_JAVA_MAP.put("\\\"", "\"");
        UNESCAPE_JAVA_MAP.put("\\\\", "\\");
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '\\') {
                if (i + 1 < str.length()) {
                    // Check for unicode escape sequence
                    if (str.charAt(i + 1) == 'u') {
                        if (i + 5 < str.length()) {
                            // Get 4 hex digits
                            String hex = str.substring(i + 2, i + 6);
                            try {
                                result.append((char) Integer.parseInt(hex, 16));
                                i += 5; // Skip the unicode sequence
                                continue;
                            } catch (NumberFormatException e) {
                                throw new Exception("Invalid unicode escape sequence: \\u" + hex);
                            }
                        }
                    }
                    
                    // Check for octal escape sequence
                    if (Character.isDigit(str.charAt(i + 1))) {
                        int end = Math.min(i + 4, str.length());
                        int j = i + 1;
                        while (j < end && Character.isDigit(str.charAt(j))) {
                            j++;
                        }
                        String octal = str.substring(i + 1, j);
                        try {
                            result.append((char) Integer.parseInt(octal, 8));
                            i = j - 1;
                            continue;
                        } catch (NumberFormatException e) {
                            throw new Exception("Invalid octal escape sequence: \\" + octal);
                        }
                    }
                    
                    // Check for common escape sequences
                    String escaped = str.substring(i, Math.min(i + 2, str.length()));
                    String unescaped = UNESCAPE_JAVA_MAP.get(escaped);
                    if (unescaped != null) {
                        result.append(unescaped);
                        i++;
                        continue;
                    }
                }
            }
            
            result.append(ch);
        }
        
        return result.toString();
    }
}