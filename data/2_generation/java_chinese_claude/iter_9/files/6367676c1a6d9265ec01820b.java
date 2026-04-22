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
        
        // Convert charsToDelete to a Set for O(1) lookup
        Set<Character> deleteSet = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            deleteSet.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!deleteSet.contains(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}