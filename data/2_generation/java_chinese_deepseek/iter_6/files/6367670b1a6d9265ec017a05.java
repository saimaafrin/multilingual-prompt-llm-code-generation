public class CharUtils {

    private static final String[] CHAR_STRING_CACHE = new String[128];

    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * <p>将字符转换为仅包含该字符的字符串。</p>
     * <p>对于 ASCII 7 位字符，此方法将使用一个缓存，每次返回相同的字符串对象。</p>
     * <pre> CharUtils.toString(' ')  = " " CharUtils.toString('A')  = "A" </pre>
     * @param ch  要转换的字符
     * @return 包含指定字符的字符串
     */
    public static String toString(final char ch) {
        if (ch < CHAR_STRING_CACHE.length) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // 输出: " "
        System.out.println(toString('A'));  // 输出: "A"
        System.out.println(toString('€'));  // 输出: "€"
    }
}