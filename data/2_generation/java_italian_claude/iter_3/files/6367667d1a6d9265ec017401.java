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

    /** 
     * <p>Rimuove l'escape da qualsiasi letterale Java trovato nella <code>String</code>. Ad esempio, trasformerà una sequenza di <code>'\'</code> e <code>'n'</code> in un carattere di nuova linea, a meno che il <code>'\'</code> non sia preceduto da un altro <code>'\'</code>.</p>
     * @param str la <code>String</code> da desescapare, può essere null
     * @return una nuova <code>String</code> desescapata, <code>null</code> se l'input è una stringa null
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder(str.length());
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '\\' && i + 1 < str.length()) {
                // Check for escaped sequences
                String escape = str.substring(i, Math.min(i + 2, str.length()));
                
                if (JAVA_ESCAPES.containsKey(escape)) {
                    result.append(JAVA_ESCAPES.get(escape));
                    i++; // Skip next character as it's part of escape sequence
                } else if (escape.charAt(1) == 'u' && i + 5 < str.length()) {
                    // Handle Unicode escape sequences
                    String hex = str.substring(i + 2, i + 6);
                    try {
                        result.append((char) Integer.parseInt(hex, 16));
                        i += 5; // Skip the unicode sequence
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid Unicode escape sequence: \\u" + hex);
                    }
                } else {
                    // Not a recognized escape sequence, keep the backslash
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}