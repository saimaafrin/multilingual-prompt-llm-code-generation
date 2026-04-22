import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotUnescaper {

    /**
     * 反转义字符串 DOT 标识符。
     * @param input 输入字符串
     * @return 反转义后的输出
     */
    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }

        // 定义需要反转义的字符
        String[][] escapeSequences = {
            {"\\\"", "\""},
            {"\\n", "\n"},
            {"\\r", "\r"},
            {"\\t", "\t"},
            {"\\\\", "\\"}
        };

        // 逐个替换反转义字符
        for (String[] escape : escapeSequences) {
            input = input.replace(escape[0], escape[1]);
        }

        return input;
    }

    public static void main(String[] args) {
        DotUnescaper unescaper = new DotUnescaper();
        String input = "This\\nis\\ta\\\"test\\\"";
        System.out.println(unescaper.unescapeId(input));
    }
}