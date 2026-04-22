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
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch == '\\') {
                if (i + 1 < str.length()) {
                    // Check for unicode escape sequence
                    if (str.charAt(i + 1) == 'u') {
                        if (i + 5 < str.length()) {
                            String hex = str.substring(i + 2, i + 6);
                            try {
                                result.append((char) Integer.parseInt(hex, 16));
                                i += 6;
                                continue;
                            } catch (NumberFormatException e) {
                                throw new Exception("Invalid unicode escape sequence: \\u" + hex);
                            }
                        }
                    }
                    // Check for octal escape sequence
                    else if (Character.isDigit(str.charAt(i + 1))) {
                        int end = Math.min(i + 4, str.length());
                        int j = i + 1;
                        while (j < end && Character.isDigit(str.charAt(j))) {
                            j++;
                        }
                        String octal = str.substring(i + 1, j);
                        try {
                            result.append((char) Integer.parseInt(octal, 8));
                            i = j;
                            continue;
                        } catch (NumberFormatException e) {
                            throw new Exception("Invalid octal escape sequence: \\" + octal);
                        }
                    }
                    // Check for standard escape sequences
                    String escape = str.substring(i, Math.min(i + 2, str.length()));
                    String unescaped = JAVA_ESCAPES.get(escape);
                    if (unescaped != null) {
                        result.append(unescaped);
                        i += 2;
                        continue;
                    }
                }
            }
            result.append(ch);
            i++;
        }
        return result.toString();
    }
}