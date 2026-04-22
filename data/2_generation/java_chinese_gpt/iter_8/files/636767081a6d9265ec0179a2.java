public class NumberUtils {

    /** 
     * <p>用于 {@link #createNumber(String)} 的工具方法。</p> 
     * <p>如果 s 为 <code>null</code>，则返回 <code>true</code>。</p>
     * @param s 要检查的字符串
     * @return 如果它全是零或 <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        return s.chars().allMatch(c -> c == '0');
    }

    public static void main(String[] args) {
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // false
    }
}