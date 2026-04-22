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
                String escape = str.substring(i, i + 2);
                if (JAVA_ESCAPES.containsKey(escape)) {
                    result.append(JAVA_ESCAPES.get(escape));
                    i++; // Skip next character as it's part of escape sequence
                } else if (i + 3 < str.length() && 
                         str.substring(i + 1, i + 4).matches("[0-7]{3}")) {
                    // Handle octal escapes
                    String octal = str.substring(i + 1, i + 4);
                    result.append((char) Integer.parseInt(octal, 8));
                    i += 3;
                } else if (i + 5 < str.length() && 
                         str.substring(i + 1, i + 6).matches("u[0-9a-fA-F]{4}")) {
                    // Handle unicode escapes
                    String unicode = str.substring(i + 2, i + 6);
                    result.append((char) Integer.parseInt(unicode, 16));
                    i += 5;
                } else {
                    // Invalid escape sequence
                    throw new Exception("Invalid escape sequence at position " + i);
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}