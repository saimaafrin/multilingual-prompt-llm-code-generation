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
            boolean matched = false;
            for (Map.Entry<String, String> entry : ESCAPE_SEQUENCES.entrySet()) {
                String escapeSeq = entry.getKey();
                if (input.startsWith(escapeSeq, i)) {
                    result.append(entry.getValue());
                    i += escapeSeq.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                result.append(input.charAt(i));
                i++;
            }
        }
        return result.toString();
    }
}