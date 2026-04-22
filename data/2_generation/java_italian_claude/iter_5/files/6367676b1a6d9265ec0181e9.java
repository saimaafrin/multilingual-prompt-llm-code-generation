public class StringMatcher {
    /**
     * Restituisce {@code true} se la stringa fornita corrisponde alla sottostringa fornita all'indice specificato, {@code false} altrimenti.
     * @param str la stringa originale (o StringBuilder)
     * @param index l'indice nella stringa originale da cui iniziare a confrontare
     * @param substring la sottostringa da confrontare all'indice specificato
     * @return {@code true} se la stringa fornita corrisponde alla sottostringa fornita all'indice specificato, {@code false} altrimenti.
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        // Check for null inputs
        if (str == null || substring == null) {
            return false;
        }

        // Check if index is out of bounds
        if (index < 0 || index > str.length()) {
            return false;
        }

        // Check if substring is longer than remaining characters from index
        if (str.length() - index < substring.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}