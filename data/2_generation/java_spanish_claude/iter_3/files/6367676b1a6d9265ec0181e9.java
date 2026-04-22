public class StringUtils {
    /**
     * Devuelve {@code true} si la cadena dada coincide con la subcadena dada en el índice especificado, {@code false} en caso contrario.
     * @param str la cadena original (o StringBuilder)
     * @param index el índice en la cadena original para comenzar a comparar
     * @param substring la subcadena para comparar en el índice dado
     * @return {@code true} si la cadena dada coincide con la subcadena dada en el índice especificado, {@code false} en caso contrario.
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        
        // Check if index is out of bounds
        if (index < 0 || index + substring.length() > str.length()) {
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