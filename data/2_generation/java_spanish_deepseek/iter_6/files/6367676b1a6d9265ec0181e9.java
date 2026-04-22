public class SubstringMatch {
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
        // Ejemplo de uso
        CharSequence str = "Hola mundo";
        CharSequence substring = "mundo";
        int index = 5;
        System.out.println(substringMatch(str, index, substring)); // Debería imprimir true
    }
}