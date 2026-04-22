public class StringUtils {
    /**
     * 从指定的字符串中获取子字符串，避免抛出异常。
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        
        int length = str.length();
        
        if (start < 0) {
            start = 0;
        }
        
        if (end > length) {
            end = length; 
        }
        
        if (start > end) {
            return "";
        }
        
        if (start > length) {
            return "";
        }
        
        return str.substring(start, end);
    }
}