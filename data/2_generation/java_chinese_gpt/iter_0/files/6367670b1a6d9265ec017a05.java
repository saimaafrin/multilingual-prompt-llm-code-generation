public class CharUtils {
    private static final String[] CACHE = new String[128];

    static {
        for (char i = 0; i < CACHE.length; i++) {
            CACHE[i] = String.valueOf(i);
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
        if (ch >= 0 && ch < CACHE.length) {
            return CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(CharUtils.toString(' ')); // Output: " "
        System.out.println(CharUtils.toString('A')); // Output: "A"
        System.out.println(CharUtils.toString('Z')); // Output: "Z"
        System.out.println(CharUtils.toString('中')); // Output: "中"
    }
}