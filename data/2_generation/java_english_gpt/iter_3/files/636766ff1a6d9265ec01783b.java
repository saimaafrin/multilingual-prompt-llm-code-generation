public class SubstringUtil {

    /** 
     * Gets a substring from the specified String avoiding exceptions. 
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        // Example usage
        String result = sub("Hello, World!", 7, 12);
        System.out.println(result); // Output: World
    }
}