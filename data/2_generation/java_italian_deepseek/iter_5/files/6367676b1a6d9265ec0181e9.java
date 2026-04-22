public class SubstringMatcher {

    /**
     * Restituisce {@code true} se la stringa fornita corrisponde alla sottostringa fornita all'indice specificato, {@code false} altrimenti.
     * @param str la stringa originale (o StringBuilder)
     * @param index l'indice nella stringa originale da cui iniziare a confrontare
     * @param substring la sottostringa da confrontare all'indice specificato
     * @return {@code true} se la stringa fornita corrisponde alla sottostringa fornita all'indice specificato, {@code false} altrimenti.
     */
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
        System.out.println(substringMatch("Hello, World!", 7, "World")); // true
        System.out.println(substringMatch("Hello, World!", 0, "Hello")); // true
        System.out.println(substringMatch("Hello, World!", 7, "world")); // false (case-sensitive)
        System.out.println(substringMatch("Hello, World!", 7, "World!")); // true
        System.out.println(substringMatch("Hello, World!", 7, "Universe")); // false
        System.out.println(substringMatch("Hello, World!", 13, "!")); // true
        System.out.println(substringMatch("Hello, World!", 14, "!")); // false (index out of bounds)
    }
}