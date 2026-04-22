public class CharUtils {

    private static final String[] CHAR_STRING_CACHE = new String[128];

    static {
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * <p>Converts the character to a String that contains the one character.</p>
     * <p>For ASCII 7 bit characters, this uses a cache that will return the same String object each time.</p>
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     * @param ch  the character to convert
     * @return a String containing the one specified character
     */
    public static String toString(final char ch) {
        if (ch < CHAR_STRING_CACHE.length) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toString(' '));  // Output: " "
        System.out.println(toString('A'));  // Output: "A"
        System.out.println(toString('€'));  // Output: "€"
    }
}