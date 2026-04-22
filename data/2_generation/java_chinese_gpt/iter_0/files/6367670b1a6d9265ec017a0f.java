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
            if (searchStr != null && lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 示例用法
        List<String> searchStrArray = List.of("a", "b", "c");
        String str = "Hello World";
        boolean result = containsAnyIgnoreCase(str, searchStrArray);
        System.out.println(result); // 输出: true
    }
}