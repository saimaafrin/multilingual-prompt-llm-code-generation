public class NumericChecker {

    /**
     * <p>Verifica si el <code>String</code> contiene solo caracteres numéricos.</p> 
     * <p><code>Null</code> y un <code>String</code> vacío devolverán <code>false</code>.</p>
     * @param str  el <code>String</code> a verificar
     * @return <code>true</code> si str contiene solo caracteres numéricos unicode
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
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