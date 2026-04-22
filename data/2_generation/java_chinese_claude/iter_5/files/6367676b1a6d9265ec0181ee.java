package com.example.utils;

public class StringUtils {
    /**
     * 去除给定字符串末尾的空白字符。
     * @param str 要检查的字符串
     * @return 去除空白字符后的字符串
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        
        while (len > 0 && Character.isWhitespace(str.charAt(len - 1))) {
            len--;
        }
        
        return str.substring(0, len);
    }
}