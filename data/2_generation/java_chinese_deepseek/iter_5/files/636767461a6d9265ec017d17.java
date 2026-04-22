import java.util.HashMap;
import java.util.Map;

public class UnescapeId {
    private static final Map<String, String> ESCAPE_SEQUENCES = new HashMap<>();

    static {
        ESCAPE_SEQUENCES.put("\\\"", "\"");
        ESCAPE_SEQUENCES.put("\\\\", "\\");
        ESCAPE_SEQUENCES.put("\\n", "\n");
        ESCAPE_SEQUENCES.put("\\r", "\r");
        ESCAPE_SEQUENCES.put("\\t", "\t");
        ESCAPE_SEQUENCES.put("\\b", "\b");
        ESCAPE_SEQUENCES.put("\\f", "\f");
    }

    /**
     * 反转义字符串 DOT 标识符。
     * @param input 输入字符串
     * @return 反转义后的输出
     */
    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '\\' && i + 1 < input.length()) {
                String escapeSequence = input.substring(i, i + 2);
                if (ESCAPE_SEQUENCES.containsKey(escapeSequence)) {
                    result.append(ESCAPE_SEQUENCES.get(escapeSequence));
                    i += 2;
                    continue;
                }
            }
            result.append(input.charAt(i));
            i++;
        }
        return result.toString();
    }
}