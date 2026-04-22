import java.util.HashMap;
import java.util.Map;

public class DotUnescaper {

    private static final Map<String, String> ESCAPE_SEQUENCES = new HashMap<>();

    static {
        ESCAPE_SEQUENCES.put("\\\"", "\"");
        ESCAPE_SEQUENCES.put("\\n", "\n");
        ESCAPE_SEQUENCES.put("\\r", "\r");
        ESCAPE_SEQUENCES.put("\\t", "\t");
        ESCAPE_SEQUENCES.put("\\\\", "\\");
    }

    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int length = input.length();
        int i = 0;

        while (i < length) {
            char currentChar = input.charAt(i);

            if (currentChar == '\\' && i + 1 < length) {
                String escapeSequence = input.substring(i, i + 2);
                if (ESCAPE_SEQUENCES.containsKey(escapeSequence)) {
                    result.append(ESCAPE_SEQUENCES.get(escapeSequence));
                    i += 2;
                    continue;
                }
            }

            result.append(currentChar);
            i++;
        }

        return result.toString();
    }
}