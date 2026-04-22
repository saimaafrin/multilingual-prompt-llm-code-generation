import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    private static final Map<Character, Character> ESCAPE_SEQUENCES = new HashMap<>();

    static {
        ESCAPE_SEQUENCES.put('n', '\n');
        ESCAPE_SEQUENCES.put('t', '\t');
        ESCAPE_SEQUENCES.put('r', '\r');
        ESCAPE_SEQUENCES.put('b', '\b');
        ESCAPE_SEQUENCES.put('f', '\f');
        ESCAPE_SEQUENCES.put('"', '\"');
        ESCAPE_SEQUENCES.put('\'', '\'');
        ESCAPE_SEQUENCES.put('\\', '\\');
    }

    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int length = str.length();
        boolean escape = false;

        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);

            if (escape) {
                if (ESCAPE_SEQUENCES.containsKey(currentChar)) {
                    result.append(ESCAPE_SEQUENCES.get(currentChar));
                } else {
                    throw new Exception("Invalid escape sequence: \\" + currentChar);
                }
                escape = false;
            } else {
                if (currentChar == '\\') {
                    escape = true;
                } else {
                    result.append(currentChar);
                }
            }
        }

        if (escape) {
            throw new Exception("Incomplete escape sequence at the end of the string");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(unescapeJava("Hello\\nWorld!"));  // Output: Hello
                                                                 // World!
            System.out.println(unescapeJava("C:\\\\path\\to\\file"));  // Output: C:\path\to\file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}