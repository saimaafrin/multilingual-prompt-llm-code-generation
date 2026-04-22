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
        CharSequence str = "Hello, World!";
        CharSequence substring = "World";
        int index = 7;
        System.out.println(substringMatch(str, index, substring)); // true
    }
}