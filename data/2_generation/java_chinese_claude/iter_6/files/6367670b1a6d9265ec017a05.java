package org.apache.commons.lang3;

/**
 * Character utility class that provides operations on char values.
 */
public class CharUtils {

    // ASCII cache size
    private static final int ASCII_CACHE_SIZE = 128;
    
    // Cache for ASCII characters
    private static final String[] ASCII_CACHE = new String[ASCII_CACHE_SIZE];

    static {
        // Initialize cache for ASCII characters
        for (int i = 0; i < ASCII_CACHE_SIZE; i++) {
            ASCII_CACHE[i] = String.valueOf((char) i);
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
        if (ch < ASCII_CACHE_SIZE) {
            return ASCII_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}