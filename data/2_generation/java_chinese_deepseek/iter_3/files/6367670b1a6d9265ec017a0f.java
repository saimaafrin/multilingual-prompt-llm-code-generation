import java.util.List;

public class StringUtils {

    /**
     * 不区分大小写，检查字符串是否包含给定字符串集合中的任何字符。
     * 
     * @param str 要检查的字符串
     * @param searchStrArray 要搜索的字符串集合
     * @return 如果字符串包含集合中的任何字符，返回true；否则返回false
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null || searchStrArray.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerCaseStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> searchStrArray = List.of("hello", "world", "java");
        String str = "Hello, this is a test string.";
        System.out.println(containsAnyIgnoreCase(str, searchStrArray)); // 输出: true
    }
}