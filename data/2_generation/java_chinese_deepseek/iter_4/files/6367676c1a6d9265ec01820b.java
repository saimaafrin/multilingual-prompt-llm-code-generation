import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * 删除给定字符串中的所有给定字符。
     * @param inString 原始字符串
     * @param charsToDelete 要删除的字符集合。例如 "az\n" 将删除 'a'、'z' 和换行符。
     * @return 结果字符串
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        // 将 charsToDelete 转换为字符集合
        Set<Character> charsToRemove = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToRemove.add(c);
        }

        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!charsToRemove.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!\nThis is a test.";
        String charsToDelete = "aeiou\n";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // 输出: Hll, Wrld!Ths s  tst.
    }
}