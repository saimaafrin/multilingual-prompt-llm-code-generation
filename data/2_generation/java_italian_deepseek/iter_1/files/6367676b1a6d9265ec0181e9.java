public class SubstringMatch {
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