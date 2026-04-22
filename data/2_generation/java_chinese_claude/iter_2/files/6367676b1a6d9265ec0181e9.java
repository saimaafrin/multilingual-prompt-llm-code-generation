public class StringUtils {
    /**
     * 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     * @param str 原始字符串（或 StringBuilder）
     * @param index 在原始字符串中开始匹配的索引
     * @param substring 要在给定索引处匹配的子字符串
     * @return 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        
        // 检查索引是否有效
        if (index < 0 || index > str.length()) {
            return false;
        }
        
        // 检查剩余长度是否足够
        if (str.length() - index < substring.length()) {
            return false;
        }
        
        // 逐字符比较
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}