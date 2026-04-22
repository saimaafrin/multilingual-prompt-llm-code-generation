public class SubstringUtil {

    /**
     * Gets a substring from the specified String avoiding exceptions.
     * 
     * @param str   the original string
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     * @return the substring, or an empty string if the indices are invalid
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (start < 0) {
            start = 0;
        }
        if (end > length) {
            end = length;
        }
        if (start >= end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String testStr = "Hello, World!";
        System.out.println(sub(testStr, 7, 12)); // Outputs "World"
        System.out.println(sub(testStr, -1, 5)); // Outputs "Hello"
        System.out.println(sub(testStr, 7, 100)); // Outputs "World!"
        System.out.println(sub(testStr, 12, 7)); // Outputs ""
        System.out.println(sub(null, 0, 5)); // Outputs ""
    }
}