import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    private static final Map<Character, Character> ESCAPE_MAP = new HashMap<>();

    static {
        ESCAPE_MAP.put('n', '\n');
        ESCAPE_MAP.put('t', '\t');
        ESCAPE_MAP.put('r', '\r');
        ESCAPE_MAP.put('b', '\b');
        ESCAPE_MAP.put('f', '\f');
        ESCAPE_MAP.put('"', '\"');
        ESCAPE_MAP.put('\'', '\'');
        ESCAPE_MAP.put('\\', '\\');
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
                if (ESCAPE_MAP.containsKey(currentChar)) {
                    result.append(ESCAPE_MAP.get(currentChar));
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
            String input = "Hello\\nWorld\\t!";
            String output = unescapeJava(input);
            System.out.println(output);  // Output: Hello
                                         //         World    !
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}