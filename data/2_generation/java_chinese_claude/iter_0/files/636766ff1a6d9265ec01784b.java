package org.apache.commons.lang3;

public class StringUtils {
    /**
     * <p>检查给定的 <code>String</code> 是否仅包含数字字符。</p>
     * <p><code>Null</code> 和空字符串将返回 <code>false</code>。</p>
     * @param str 要检查的 <code>String</code>
     * @return 如果 str 仅包含 unicode 数字则返回<code>true</code>
     */
    public static boolean isDigits(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}