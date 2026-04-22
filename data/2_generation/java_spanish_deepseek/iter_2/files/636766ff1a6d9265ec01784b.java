public class NumericChecker {

    /**
     * Verifica si el String contiene solo caracteres numéricos.
     * Null y un String vacío devolverán false.
     *
     * @param str el String a verificar
     * @return true si str contiene solo caracteres numéricos unicode
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(isDigits("12345")); // true
        System.out.println(isDigits("123a45")); // false
        System.out.println(isDigits("")); // false
        System.out.println(isDigits(null)); // false
    }
}