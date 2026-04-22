package org.utils;

public class StringUtils {
    /**
     * 去除给定字符串的前导空白字符。
     * @param str 要检查的字符串
     * @return 去除空白后的字符串
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        int start = 0;
        
        while (start < len && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        
        return start > 0 ? str.substring(start) : str;
    }
}