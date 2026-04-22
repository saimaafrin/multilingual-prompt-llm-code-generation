public class SubstringMatch {
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        if (index < 0 || index + substring.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(substringMatch("Hello World", 6, "World")); // true
        System.out.println(substringMatch("Hello World", 0, "Hello")); // true
        System.out.println(substringMatch("Hello World", 5, " "));    // true
        System.out.println(substringMatch("Hello World", 6, "world")); // false (case-sensitive)
        System.out.println(substringMatch("Hello World", 11, "d"));     // true
        System.out.println(substringMatch("Hello World", 12, "d"));     // false (index out of bounds)
    }
}