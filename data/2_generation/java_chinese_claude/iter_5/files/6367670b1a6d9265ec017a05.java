package org.apache.commons.lang3;

/**
 * Character utility class that provides operations for working with characters.
 */
public class CharUtils {

    // ASCII 7 bit characters cache
    private static final String[] CHAR_STRING_CACHE = new String[128];

    // Initialize cache with commonly used characters
    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * <p>将字符转换为仅包含该字符的字符串。</p>
     * <p>对于 ASCII 7 位字符，此方法将使用一个缓存，每次返回相同的字符串对象。</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch 要转换的字符
     * @return 包含指定字符的字符串
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}