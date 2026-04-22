public class DigitConverter {
    /**
     * Interpreta un carácter como un dígito (en cualquier base hasta 36) y devuelve el valor numérico. 
     * Esto es similar a {@code Character.digit()} pero no aceptamos dígitos no ASCII.
     */
    private static int valorDígito(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return -1;
    }
}