public class StringUtils {
    
    /** 
     * <p>检查给定的 <code>String</code> 是否仅包含数字字符。</p> 
     * <p><code>Null</code> 和空字符串将返回 <code>false</code>。</p>
     * @param str  要检查的 <code>String</code>
     * @return 如果 str 仅包含 unicode 数字则返回<code>true</code>
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDigits("12345")); // true
        System.out.println(isDigits("123a5")); // false
        System.out.println(isDigits(""));      // false
        System.out.println(isDigits(null));    // false
    }
}