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
        CharSequence str = "Hello, World!";
        CharSequence substring1 = "World";
        CharSequence substring2 = "Hello";
        CharSequence substring3 = "ld!";

        System.out.println(substringMatch(str, 7, substring1)); // true
        System.out.println(substringMatch(str, 0, substring2)); // true
        System.out.println(substringMatch(str, 10, substring3)); // true
        System.out.println(substringMatch(str, 5, substring1)); // false
        System.out.println(substringMatch(str, 7, substring2)); // false
    }
}