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
        int length = input.length();
        int i = 0;

        while (i < length) {
            if (i + 1 < length && input.charAt(i) == '\\') {
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

    public static void main(String[] args) {
        DotUnescaper unescaper = new DotUnescaper();
        String input = "This\\nis\\ta\\\"test\\\"";
        String output = unescaper.unescapeId(input);
        System.out.println(output);  // Output: This
                                     // is	a"test"
    }
}