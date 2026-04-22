public class CharUtils {
    private static final String[] CACHE = new String[128];

    static {
        for (char c = 0; c < CACHE.length; c++) {
            CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * <p>Converts the character to a String that contains the one character.</p>
     * <p>For ASCII 7 bit characters, this uses a cache that will return the same String object each time.</p>
     * <pre> CharUtils.toString(' ')  = " " CharUtils.toString('A')  = "A" </pre>
     * @param ch  the character to convert
     * @return a String containing the one specified character
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(CharUtils.toString(' ')); // Output: " "
        System.out.println(CharUtils.toString('A')); // Output: "A"
        System.out.println(CharUtils.toString('Z')); // Output: "Z"
        System.out.println(CharUtils.toString('ñ')); // Output: "ñ"
    }
}