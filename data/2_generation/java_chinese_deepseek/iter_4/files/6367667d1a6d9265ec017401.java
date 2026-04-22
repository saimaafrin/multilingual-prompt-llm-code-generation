import java.util.HashMap;
import java.util.Map;

public class UnescapeJava {

    private static final Map<Character, Character> ESCAPE_SEQUENCES = new HashMap<>();

    static {
        ESCAPE_SEQUENCES.put('b', '\b');
        ESCAPE_SEQUENCES.put('t', '\t');
        ESCAPE_SEQUENCES.put('n', '\n');
        ESCAPE_SEQUENCES.put('f', '\f');
        ESCAPE_SEQUENCES.put('r', '\r');
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
        int i = 0;

        while (i < length) {
            char currentChar = str.charAt(i);

            if (currentChar == '\\' && i + 1 < length) {
                char nextChar = str.charAt(i + 1);

                if (ESCAPE_SEQUENCES.containsKey(nextChar)) {
                    result.append(ESCAPE_SEQUENCES.get(nextChar));
                    i += 2;
                } else if (nextChar == 'u' && i + 5 < length) {
                    // Handle Unicode escape sequences
                    String hex = str.substring(i + 2, i + 6);
                    try {
                        int unicodeValue = Integer.parseInt(hex, 16);
                        result.append((char) unicodeValue);
                        i += 6;
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid Unicode escape sequence: \\u" + hex);
                    }
                } else {
                    // Handle invalid escape sequences
                    result.append(currentChar);
                    i++;
                }
            } else {
                result.append(currentChar);
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(unescapeJava("Hello\\nWorld\\t!")); // Output: Hello\nWorld\t!
            System.out.println(unescapeJava("\\u0041")); // Output: A
            System.out.println(unescapeJava("\\\\")); // Output: \
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}