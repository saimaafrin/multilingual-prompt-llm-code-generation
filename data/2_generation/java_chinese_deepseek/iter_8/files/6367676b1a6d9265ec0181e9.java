public class SubstringMatcher {
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        if (index < 0 || index > str.length() - substring.length()) {
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
        CharSequence str = "Hello, World!";
        CharSequence substring = "World";
        int index = 7;
        System.out.println(substringMatch(str, index, substring)); // Output: true
    }
}