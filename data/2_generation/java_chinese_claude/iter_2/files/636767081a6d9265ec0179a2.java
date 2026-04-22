public class NumberUtils {
    /**
     * <p>用于 {@link #createNumber(String)} 的工具方法。</p> <p>如果 s 为 <code>null</code>，则返回 <code>true</code>。</p>
     * @param s 要检查的字符串
     * @return 如果它全是零或 <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        
        return true;
    }
}