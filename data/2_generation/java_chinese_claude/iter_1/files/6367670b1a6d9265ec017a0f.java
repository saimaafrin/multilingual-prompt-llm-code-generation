import java.util.List;

public class StringUtils {
    /**
     * 不区分大小写，检查字符串是否包含给定字符串集合中的任何字符。
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null) {
            return false;
        }
        
        String lowerStr = str.toLowerCase();
        
        for (String searchStr : searchStrArray) {
            if (searchStr == null) {
                continue;
            }
            if (lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        
        return false;
    }
}