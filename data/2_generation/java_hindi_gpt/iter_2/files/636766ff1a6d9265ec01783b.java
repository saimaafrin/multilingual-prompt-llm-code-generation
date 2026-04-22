public class SubstringExtractor {

    /** 
     * निर्दिष्ट स्ट्रिंग से उपस्ट्रिंग प्राप्त करता है, अपवादों से बचते हुए। 
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
        String example = "Hello, World!";
        System.out.println(sub(example, 7, 12)); // Output: World
        System.out.println(sub(example, -1, 5)); // Output: Hello
        System.out.println(sub(example, 0, 20)); // Output: Hello, World!
        System.out.println(sub(example, 5, 3));  // Output: (empty string)
    }
}